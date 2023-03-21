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
import com.example.schoolproject.model.TimetableModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimeTableFragment extends BaseFragment {

    @BindView(R.id.tv_mon)
    TextView tv_mon;
    @BindView(R.id.tv_tue)
    TextView tv_tue;
    @BindView(R.id.tv_wed)
    TextView tv_wed;
    @BindView(R.id.tv_thu)
    TextView tv_thu;
    @BindView(R.id.tv_fri)
    TextView tv_fri;
    @BindView(R.id.tv_sat)
    TextView tv_sat;

    @BindView(R.id.rv_timetable)
    RecyclerView rv_timetable;

    List<TimetableModel> timetableList;

    TimeTableAdapter timeTableAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_table, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {

        timetableList = new ArrayList<>();

        timetableList.add(new TimetableModel("Computer Science","08:15 am-09:00 am","James Smith"));
        timetableList.add(new TimetableModel("Computer Science","08:15 am-09:00 am","James Smith"));
        timetableList.add(new TimetableModel("Computer Science","08:15 am-09:00 am","James Smith"));
        timetableList.add(new TimetableModel("Computer Science","08:15 am-09:00 am","James Smith"));
        timetableList.add(new TimetableModel("Computer Science","08:15 am-09:00 am","James Smith"));

        timeTableAdapter = new TimeTableAdapter();
        rv_timetable.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_timetable.setAdapter(timeTableAdapter);

    }

    @OnClick(R.id.tv_mon)
    void tv_monClick(){
        tv_mon.setTextColor(getResources().getColor(R.color.white));
        tv_mon.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_tue.setTextColor(getResources().getColor(R.color.black));
        tv_wed.setTextColor(getResources().getColor(R.color.black));
        tv_thu.setTextColor(getResources().getColor(R.color.black));
        tv_fri.setTextColor(getResources().getColor(R.color.black));
        tv_sat.setTextColor(getResources().getColor(R.color.black));

        tv_tue.setBackground(null);
        tv_wed.setBackground(null);
        tv_thu.setBackground(null);
        tv_fri.setBackground(null);
        tv_sat.setBackground(null);    }

    @OnClick(R.id.tv_tue)
    void tv_tueClick(){
        tv_tue.setTextColor(getResources().getColor(R.color.white));
        tv_tue.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_mon.setTextColor(getResources().getColor(R.color.black));
        tv_wed.setTextColor(getResources().getColor(R.color.black));
        tv_thu.setTextColor(getResources().getColor(R.color.black));
        tv_fri.setTextColor(getResources().getColor(R.color.black));
        tv_sat.setTextColor(getResources().getColor(R.color.black));

        tv_mon.setBackground(null);
        tv_wed.setBackground(null);
        tv_thu.setBackground(null);
        tv_fri.setBackground(null);
        tv_sat.setBackground(null);
    }
    @OnClick(R.id.tv_wed)
    void tv_wedClick(){
        tv_wed.setTextColor(getResources().getColor(R.color.white));
        tv_wed.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_mon.setTextColor(getResources().getColor(R.color.black));
        tv_tue.setTextColor(getResources().getColor(R.color.black));
        tv_thu.setTextColor(getResources().getColor(R.color.black));
        tv_fri.setTextColor(getResources().getColor(R.color.black));
        tv_sat.setTextColor(getResources().getColor(R.color.black));

        tv_mon.setBackground(null);
        tv_tue.setBackground(null);
        tv_thu.setBackground(null);
        tv_fri.setBackground(null);
        tv_sat.setBackground(null);
    }
    @OnClick(R.id.tv_thu)
    void tv_thuClick(){
        tv_thu.setTextColor(getResources().getColor(R.color.white));
        tv_thu.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_mon.setTextColor(getResources().getColor(R.color.black));
        tv_tue.setTextColor(getResources().getColor(R.color.black));
        tv_wed.setTextColor(getResources().getColor(R.color.black));
        tv_fri.setTextColor(getResources().getColor(R.color.black));
        tv_sat.setTextColor(getResources().getColor(R.color.black));

        tv_mon.setBackground(null);
        tv_tue.setBackground(null);
        tv_wed.setBackground(null);
        tv_fri.setBackground(null);
        tv_sat.setBackground(null);
    }
    @OnClick(R.id.tv_fri)
    void tv_friClick(){
        tv_fri.setTextColor(getResources().getColor(R.color.white));
        tv_fri.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_mon.setTextColor(getResources().getColor(R.color.black));
        tv_tue.setTextColor(getResources().getColor(R.color.black));
        tv_wed.setTextColor(getResources().getColor(R.color.black));
        tv_thu.setTextColor(getResources().getColor(R.color.black));
        tv_sat.setTextColor(getResources().getColor(R.color.black));

        tv_mon.setBackground(null);
        tv_tue.setBackground(null);
        tv_wed.setBackground(null);
        tv_thu.setBackground(null);
        tv_sat.setBackground(null);
    }
    @OnClick(R.id.tv_sat)
    void tv_satClick(){
        tv_sat.setTextColor(getResources().getColor(R.color.white));
        tv_sat.setBackground(getResources().getDrawable(R.drawable.rounded_blue_layout));

        tv_mon.setTextColor(getResources().getColor(R.color.black));
        tv_tue.setTextColor(getResources().getColor(R.color.black));
        tv_wed.setTextColor(getResources().getColor(R.color.black));
        tv_thu.setTextColor(getResources().getColor(R.color.black));
        tv_fri.setTextColor(getResources().getColor(R.color.black));


        tv_mon.setBackground(null);
        tv_tue.setBackground(null);
        tv_wed.setBackground(null);
        tv_thu.setBackground(null);
        tv_fri.setBackground(null);
    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder>{

        @NonNull
        @Override
        public TimeTableAdapter.TimeTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_timetable,parent,false);
            return new TimeTableViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TimeTableAdapter.TimeTableViewHolder holder, int position) {
            TimetableModel timetableModel = timetableList.get(position);
            holder.tv_timetable_subjectName.setText(timetableModel.getSubject());
            holder.tv_timetable_subjectTeacherName.setText(timetableModel.getTeacher());
            holder.tv_timetable_subjectDuration.setText(timetableModel.getDuration());
            holder.tv_timetable_periodNo.setText("Period "+(position+1));
        }

        @Override
        public int getItemCount() {
            return timetableList.size();
        }

        public class TimeTableViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_timetable_subjectName)
            TextView tv_timetable_subjectName;
            @BindView(R.id.tv_timetable_subjectDuration)
            TextView tv_timetable_subjectDuration;
            @BindView(R.id.tv_timetable_subjectTeacherName)
            TextView tv_timetable_subjectTeacherName;
            @BindView(R.id.tv_timetable_periodNo)
            TextView tv_timetable_periodNo;
            public TimeTableViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}