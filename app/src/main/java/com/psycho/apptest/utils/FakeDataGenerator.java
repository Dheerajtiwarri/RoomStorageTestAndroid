package com.psycho.apptest.utils;

import com.psycho.apptest.data.model.TestData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public class FakeDataGenerator {

  public List<TestData> getDummyList() {
    List<TestData> testDataList = new ArrayList<>();

    /*for (int i = 0; i < 50; i++) {
      testDataList.add(new TestData(i,
          "https://homepages.cae.wisc.edu/~ece533/images/airplane.png"));
    }*/


    return testDataList;
  }

}
