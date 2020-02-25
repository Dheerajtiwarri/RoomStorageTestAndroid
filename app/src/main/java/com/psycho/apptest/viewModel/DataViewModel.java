package com.psycho.apptest.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.psycho.apptest.data.model.TestData;
import com.psycho.apptest.data.response.TestResponse;
import com.psycho.apptest.repo.DataRepo;

import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public class DataViewModel extends AndroidViewModel {
  private DataRepo dataRepo;

  public DataViewModel(@NonNull Application application) {
    super(application);
    dataRepo = DataRepo
        .getInstance(application
            .getApplicationContext());
  }

 /* public LiveData<List<TestData>> getTestDataList() {

    return dataRepo.getDataFromRoom();
  }*/

 public LiveData<TestResponse> getResponseFromRoom(){
   return dataRepo.getResponseFromRoom();
 }
}
