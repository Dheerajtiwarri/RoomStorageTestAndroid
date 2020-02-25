package com.psycho.apptest.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.psycho.apptest.BR;
import com.psycho.apptest.R;
import com.psycho.apptest.data.model.TestData;
import com.psycho.apptest.databinding.RecyclerDataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dheeraj on 25,February,2020
 * Kolkata, India.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
  private RecyclerDataBinding binding;
  private Context context;
  private LayoutInflater inflater;
  private List<TestData> testDataList
      = new ArrayList<>();

  public DataAdapter(Context context) {
    this.context = context;
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
    binding = DataBindingUtil.inflate(
        inflater,
        R.layout.recycler_data, parent,
        false);
    return new MyViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder,
                               int position) {
    holder.onBind(testDataList.get(position));
  }

  @Override
  public int getItemCount() {
    return testDataList.size();
  }

  public void setData(List<TestData> testDataList) {
    this.testDataList = testDataList;

  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public MyViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void onBind(Object obj) {
      binding.setVariable(BR.obj, obj);
      binding.executePendingBindings();


    }


  }
}
