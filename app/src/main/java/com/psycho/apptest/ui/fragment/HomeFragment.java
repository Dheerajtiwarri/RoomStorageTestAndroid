package com.psycho.apptest.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.psycho.apptest.R;
import com.psycho.apptest.data.model.TestData;
import com.psycho.apptest.databinding.FragmentHomeBinding;
import com.psycho.apptest.ui.adapter.DataAdapter;
import com.psycho.apptest.viewModel.DataViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
  private static final String TAG = "HomeFragment";

  private FragmentHomeBinding binding;
  private View fragHomeView;
  private DataAdapter adapter;
  private Context context;
  private DataViewModel dataViewModel;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_home,
        container,
        false);
    fragHomeView = binding.getRoot();
    context = getContext();
    dataViewModel = new ViewModelProvider(this)
        .get(DataViewModel.class);

    adapter = new DataAdapter(context);

    dataViewModel.getResponseFromRoom()
            .observe(getViewLifecycleOwner(),
                    testResponse -> {
              if(testResponse != null && testResponse.isStatus()){
                binding.setObj(testResponse.getTestData());
                adapter.setData(testResponse.getTestDataList());
                adapter.notifyDataSetChanged();
              }
                    });

    /*dataViewModel
        .getTestDataList()
        .observe(getViewLifecycleOwner(), testDataList -> {
          for (TestData testData : testDataList) {
            Log.i(TAG, "onCreateView: " + testData.getId());
          }
          adapter.setData(testDataList);
          adapter.notifyDataSetChanged();
        });*/


    initializeView();


    return fragHomeView;
  }

  private void initializeView() {
    RecyclerView recyclerView = fragHomeView
        .findViewById(R.id.recyclerView_data_list);
    recyclerView.setLayoutManager(new LinearLayoutManager(context));
    recyclerView.setAdapter(adapter);

  }
}
