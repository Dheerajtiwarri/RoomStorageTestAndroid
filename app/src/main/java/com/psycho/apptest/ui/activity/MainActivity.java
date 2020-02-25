package com.psycho.apptest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.psycho.apptest.R;

public class MainActivity extends AppCompatActivity {

  private NavController navController;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    navController = Navigation.findNavController(this, R.id.main_activity_fragment);
  }

  @Override
  public void onBackPressed() {
    if(navController.getCurrentDestination().getId() == R.id.homeFragment){
      finish();
    }else {
      super.onBackPressed();
    }

  }
}
