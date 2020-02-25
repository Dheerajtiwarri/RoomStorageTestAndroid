package com.psycho.apptest.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.psycho.apptest.data.response.TestResponse;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
@Dao
public interface TestResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TestResponse testResponse);

    @Query("SELECT * FROM testResponse")
    LiveData<TestResponse> getResponse();
}
