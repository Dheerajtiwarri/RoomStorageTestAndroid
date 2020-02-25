package com.psycho.apptest.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.psycho.apptest.data.dao.TestDataDao;
import com.psycho.apptest.data.dao.TestResponseDao;
import com.psycho.apptest.data.model.TestData;
import com.psycho.apptest.data.response.TestResponse;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
@Database(entities = {TestResponse.class}, version = 1, exportSchema = false)
@TypeConverters(AppTypeConverters.class)
public abstract class AppDatabase extends RoomDatabase {

  private static final Object LOCK = new Object();
  public static volatile AppDatabase instance;

  public static AppDatabase getInstance(Context context) {
    if (instance == null) {
      synchronized (LOCK) {
        if (instance == null) {
          instance = Room.databaseBuilder(context.getApplicationContext(),
              AppDatabase.class,
              "appTestdb.db").build();
        }
      }
    }
    return instance;
  }

  public abstract TestDataDao testDataDao();
  public abstract TestResponseDao testResponseDao();
}
