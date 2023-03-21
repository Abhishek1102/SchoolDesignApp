package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.HolidayModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttendenceFragment extends BaseFragment {

    @BindView(R.id.tv_attendence)
    TextView tv_attendence;
    @BindView(R.id.tv_holiday)
    TextView tv_holiday;
    @BindView(R.id.lv_atendence)
    LinearLayout lv_attendence;
    @BindView(R.id.lv_holidays)
    LinearLayout lv_holidays;

    @BindView(R.id.rv_holidays)
    RecyclerView rv_holidays;

    HolidayAdapter holidayAdapter;

    List<HolidayModel> holidaylist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendence, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        holidaylist = new ArrayList<>();

        holidaylist.add(new HolidayModel("Diwali","15 November","Saturday"));
        holidaylist.add(new HolidayModel("Christmas","16 December","Sunday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));
        holidaylist.add(new HolidayModel("Makarsankranti","17 January","Monday"));

        holidayAdapter = new HolidayAdapter();
        rv_holidays.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_holidays.setAdapter(holidayAdapter);

    }

    @OnClick(R.id.tv_attendence)
    void tv_attendenceClick(){
        tv_attendence.setBackground(getResources().getDrawable(R.drawable.rounded_layout));
        tv_attendence.setTextColor(getResources().getColor(R.color.blue));
        tv_holiday.setBackground(null);
        tv_holiday.setTextColor(getResources().getColor(R.color.white));

        lv_attendence.setVisibility(View.VISIBLE);
        lv_holidays.setVisibility(View.GONE);

    }

    @OnClick(R.id.tv_holiday)
    void tv_holidayClick(){
        tv_holiday.setBackground(getResources().getDrawable(R.drawable.rounded_layout));
        tv_holiday.setTextColor(getResources().getColor(R.color.blue));
        tv_attendence.setBackground(null);
        tv_attendence.setTextColor(getResources().getColor(R.color.white));

        lv_holidays.setVisibility(View.VISIBLE);
        lv_attendence.setVisibility(View.GONE);

    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>{

        @NonNull
        @Override
        public HolidayAdapter.HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_holidays,parent,false);
            return new HolidayViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HolidayAdapter.HolidayViewHolder holder, int position) {
            HolidayModel holidayModel = holidaylist.get(position);
            holder.tv_holidayName.setText(holidayModel.getHoldiayName());
            holder.tv_holidayDate.setText(holidayModel.getHolidayDate());
            holder.tv_holidayDay.setText(holidayModel.getHolidayDay());
        }

        @Override
        public int getItemCount() {
            return holidaylist.size();
        }

        public class HolidayViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_holidayName)
            TextView tv_holidayName;
            @BindView(R.id.tv_holidayDate)
            TextView tv_holidayDate;
            @BindView(R.id.tv_holidayDay)
            TextView tv_holidayDay;
            public HolidayViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}