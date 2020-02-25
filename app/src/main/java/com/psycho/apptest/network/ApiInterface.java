package com.psycho.apptest.network;

import com.psycho.apptest.data.response.TestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public interface ApiInterface {

  @GET("getShow")
  Call<TestResponse> getShow(@Query("show_slug") String name,
                             @Query("user_id") int id);
}
