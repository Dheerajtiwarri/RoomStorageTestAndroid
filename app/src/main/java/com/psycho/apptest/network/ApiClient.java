package com.psycho.apptest.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public class ApiClient {
  private static final String BASE_URL = "http://www.addatimes.com/api/";
  private static final String TAG = "ApiClient";
  private static Retrofit retrofit = null;

  public static Retrofit getApiClient() {

    Gson gson = new GsonBuilder().setLenient().create();

    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
    }
    return retrofit;
  }
}
