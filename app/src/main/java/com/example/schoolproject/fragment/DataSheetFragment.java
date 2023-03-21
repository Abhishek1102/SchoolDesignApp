package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.DataSheetModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataSheetFragment extends BaseFragment {

    @BindView(R.id.rv_datasheet)
    RecyclerView rv_datasheet;

    DataSheetAdapter dataSheetAdapter;
    List<DataSheetModel> dataSheetList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_sheet, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        dataSheetList = new ArrayList<>();

        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));
        dataSheetList.add(new DataSheetModel("11","Monday","JAN","Science","09:00 AM"));


        dataSheetAdapter = new DataSheetAdapter();
        rv_datasheet.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_datasheet.setAdapter(dataSheetAdapter);
    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    class DataSheetAdapter extends RecyclerView.Adapter<DataSheetAdapter.DataSheetViewHolder>{

        @NonNull
        @Override
        public DataSheetAdapter.DataSheetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_datasheet,parent,false);
            return new DataSheetViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DataSheetAdapter.DataSheetViewHolder holder, int position) {
            DataSheetModel dataSheetModel = dataSheetList.get(position);
            holder.tv_datasheetDate.setText(dataSheetModel.getDate());
            holder.tv_datasheetMonth.setText(dataSheetModel.getMonth());
            holder.tv_datasheet_SubjectName.setText(dataSheetModel.getSubject());
            holder.tv_datasheetDay.setText(dataSheetModel.getDay());
            holder.tv_datasheet_Time.setText(dataSheetModel.getTime());
        }

        @Override
        public int getItemCount() {
            return dataSheetList.size();
        }

        public class DataSheetViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_datasheetDate)
            TextView tv_datasheetDate;
            @BindView(R.id.tv_datasheetMonth)
            TextView tv_datasheetMonth;
            @BindView(R.id.tv_datasheet_SubjectName)
            TextView tv_datasheet_SubjectName;
            @BindView(R.id.tv_datasheetDay)
            TextView tv_datasheetDay;
            @BindView(R.id.tv_datasheet_Time)
            TextView tv_datasheet_Time;
            public DataSheetViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}