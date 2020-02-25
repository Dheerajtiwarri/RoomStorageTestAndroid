package com.psycho.apptest.repo;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.psycho.apptest.data.db.AppDatabase;
import com.psycho.apptest.data.model.TestData;
import com.psycho.apptest.data.response.TestResponse;
import com.psycho.apptest.network.ApiClient;
import com.psycho.apptest.network.ApiInterface;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public class DataRepo {

  private static final String TAG = "TestRepo";
  private static DataRepo instance;
  private Executor executor = Executors.newSingleThreadExecutor();
  private AppDatabase appDatabase;
  private ApiInterface apiInterface;

  public DataRepo(Context context) {
    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    appDatabase = AppDatabase.getInstance(context);
    getNetworkData();
  }

  public static DataRepo getInstance(Context context) {
    if (instance == null) {
      instance = new DataRepo(context);
    }

    return instance;
  }

  public void getNetworkData() {
    Call<TestResponse> call = apiInterface
        .getShow("the-thrill-pill", 0);
    call.enqueue(new Callback<TestResponse>() {
      @Override
      public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {
        if (response.body().isStatus()) {
         /* insetBooksDataIntoRoom(response.body()
              .getTestDataList());*/
         insertResponseIntoRoom(response.body());
        } else {
          Log.i(TAG, "onResponse: status false");
        }
      }

      @Override
      public void onFailure(Call<TestResponse> call, Throwable t) {
        Log.i(TAG, "onFailure: " + t.toString());
      }
    });


  }

  private void insertResponseIntoRoom(TestResponse response){
    if(response != null){
      executor.execute(() ->{
        appDatabase
                .testResponseDao()
                .insert(response);
      });
    }
  }

  public LiveData<TestResponse> getResponseFromRoom(){
    return appDatabase.testResponseDao().getResponse();
  }


 /* private void insetBooksDataIntoRoom(List<TestData> testDataList) {
    if (testDataList != null) {
      executor.execute(() -> {
        Log.i(TAG, "insetBooksDataIntoRoom: ");
        appDatabase
            .testDataDao()
            .insertAll(testDataList);
      });
    }
  }

  public LiveData<List<TestData>> getDataFromRoom() {
    return appDatabase
        .testDataDao()
        .getAllData();
  }*/
}
