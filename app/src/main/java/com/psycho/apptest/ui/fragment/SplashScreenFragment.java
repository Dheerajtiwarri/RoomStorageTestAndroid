package com.psycho.apptest.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.psycho.apptest.R;
import com.psycho.apptest.viewModel.DataViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFragment extends Fragment {

    private View fragmentSplashView;
    private DataViewModel dataViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO if this layout is red.. it's just because of new android 3.6 so don't worry it'll work..
        fragmentSplashView = inflater.inflate(R.layout.fragment_splash_screen, container, false);

        dataViewModel = new ViewModelProvider(this)
                .get(DataViewModel.class);

        new Handler()
                .postDelayed((Runnable) () -> {
                    Navigation.findNavController(fragmentSplashView)
                            .navigate(R.id.homeFragment);
                },4000);

        return fragmentSplashView;
    }
}
