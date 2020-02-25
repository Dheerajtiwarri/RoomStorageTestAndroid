package com.psycho.apptest.data.response;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;
import com.psycho.apptest.data.model.TestData;

import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
@Entity(tableName = "testResponse")
public class TestResponse {
  @SerializedName("success")
  private boolean status;
  @SerializedName("latest_video")
  private TestData testData;
  @SerializedName("videos")
  private List<TestData> testDataList;
  @SerializedName("logoThumbnail")
  private String videoThumb;
  @PrimaryKey(autoGenerate = false)
  @SerializedName("currentVideoId")
  private int videoId;

  @Ignore
  public TestResponse() {
  }

  public TestResponse(boolean status,
                      TestData testData,
                      List<TestData> testDataList,
                      String videoThumb,
                      int videoId) {
    this.status = status;
    this.testData = testData;
    this.testDataList = testDataList;
    this.videoThumb = videoThumb;
    this.videoId = videoId;
  }

  @BindingAdapter("headerImage")
  public static void loadImage(ImageView view, String imageUrl) {
    Glide.with(view.getContext())
            .load(imageUrl)
            .into(view);
  }

  public boolean isStatus() {
    return status;
  }

  public TestData getTestData() {
    return testData;
  }

  public List<TestData> getTestDataList() {
    return testDataList;
  }

  public String getVideoThumb() {
    return videoThumb;
  }

  public int getVideoId() {
    return videoId;
  }
}
