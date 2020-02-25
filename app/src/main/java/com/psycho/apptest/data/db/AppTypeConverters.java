package com.psycho.apptest.data.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.psycho.apptest.data.model.TestData;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */

public class AppTypeConverters {

    private static Gson gson = new Gson();


    @TypeConverter
    public static String objectToString(TestData testData){
        return gson.toJson(testData);
    }

    @TypeConverter
    public static TestData stringToObject(String string){
        Type typeOfObject = new TypeToken<TestData>(){}.getType();

        return gson.fromJson(string,typeOfObject);
    }

    @TypeConverter
    public static String arrayListToString(List<TestData> list){
        return gson.toJson(list);
    }

    @TypeConverter
    public static List<TestData> stringToArrayList(String string){
        Type typeOfList = new TypeToken<List<TestData>>(){}.getType();

        List<TestData> result = gson.fromJson(string,typeOfList);
        return result;
    }


/*@TypeConverter
  public static String arrayListToString(List<RequestedTestDetailsModel> list) {
    return gson.toJson(list);
  }

  @TypeConverter
  public static List<RequestedTestDetailsModel> stringToArrayList(String string) {
    Type typeOfList = new TypeToken<List<RequestedTestDetailsModel>>() {

    }.getType();

    List<RequestedTestDetailsModel> result = gson.fromJson(string, typeOfList);
    return result;
  }*/
}
