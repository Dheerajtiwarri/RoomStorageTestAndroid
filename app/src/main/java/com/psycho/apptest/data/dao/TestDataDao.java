package com.psycho.apptest.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.psycho.apptest.data.model.TestData;

import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
@Dao
public interface TestDataDao {

    //Not in use .. Change the process..

  /*@Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertAll(List<TestData> dataModelList);

  @Query("SELECT * FROM testModel")
  LiveData<List<TestData>> getAllData();*/


}
