package com.psycho.apptest.data.model;

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

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */

//TODO this not in room currently

@Entity(tableName = "testModel")
public class TestData {
  @PrimaryKey(autoGenerate = false)
  @SerializedName("id")
  private int id;
  @SerializedName("title")
  private String title;
  @SerializedName("content_type")
  private String contentType;
  @SerializedName("og_image")
  private String image;
  @SerializedName("description")
  private String description;

  @Ignore
  public TestData() {
  }

  public TestData(int id,
                  String title,
                  String contentType,
                  String image,
                  String description) {
    this.id = id;
    this.title = title;
    this.contentType = contentType;
    this.image = image;
    this.description = description;
  }

  @BindingAdapter("testImage")
  public static void loadImage(ImageView view, String imageUrl) {
    Glide.with(view.getContext())
        .load(imageUrl)
        .apply(new RequestOptions()
            .transform(new CenterCrop(),
                new RoundedCorners(16)))
        .into(view);
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContentType() {
    return contentType;
  }

  public String getImage() {
    return image;
  }

  public String getDescription() {
    return description;
  }
}
