package com.example.schoolproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.activity.LoginActivity;
import com.example.schoolproject.helper.AppConstant;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.helper.SecurePreferences;
import com.example.schoolproject.model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends BaseFragment {


    @BindView(R.id.rv_dashboard)
    RecyclerView rv_dashboard;

    DashboardAdapter dashboardAdapter;
    List<DashboardModel> dashboardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {

        dashboardList = new ArrayList<>();

        dashboardList.add(new DashboardModel(R.drawable.ic_quiz,"Play Quiz"));
        dashboardList.add(new DashboardModel(R.drawable.ic_assignment,"Assignment"));
        dashboardList.add(new DashboardModel(R.drawable.ic_holiday,"School Holiday"));
        dashboardList.add(new DashboardModel(R.drawable.ic_calendar,"Time Table"));
        dashboardList.add(new DashboardModel(R.drawable.ic_results,"Result"));
        dashboardList.add(new DashboardModel(R.drawable.ic_date_sheet,"Data Sheet"));
        dashboardList.add(new DashboardModel(R.drawable.ic_doubts,"Ask Doubts"));
        dashboardList.add(new DashboardModel(R.drawable.ic_gallery,"School Gallery"));
        dashboardList.add(new DashboardModel(R.drawable.ic_leave,"Leave Application"));
        dashboardList.add(new DashboardModel(R.drawable.ic_password,"Change Password"));
        dashboardList.add(new DashboardModel(R.drawable.ic_event,"Events"));
        dashboardList.add(new DashboardModel(R.drawable.ic_logout,"Logout"));

        dashboardAdapter = new DashboardAdapter();
        rv_dashboard.setLayoutManager(new GridLayoutManager(activity,2));
        rv_dashboard.setAdapter(dashboardAdapter);
        AppConstant.runLayoutAnimation(rv_dashboard);

    }

    @OnClick(R.id.rl_profile)
    void rl_profileClick(){
        loadFragmentFull(new ProfileFragment(),"ProfileFragment");
    }

    @OnClick(R.id.lv_attendence)
    void lv_attendenceClick(){
        loadFragmentFull(new AttendenceFragment(),"AttendenceFragment");
    }

    @OnClick(R.id.lv_feesdue)
    void lv_feesdueClick(){
        loadFragmentFull(new FeesDueFragment(),"FeesDueFragment");
    }

    @Override
    public void onBack() {

    }

    class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>{

        @NonNull
        @Override
        public DashboardAdapter.DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dashboard,parent,false);
            return new DashboardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull DashboardAdapter.DashboardViewHolder holder, int position) {
            DashboardModel dashboardModel = dashboardList.get(position);
            holder.iv_dashboardIcon.setImageResource(dashboardModel.getImage());
            holder.tv_dashboardTitle.setText(dashboardModel.getTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dashboardModel.getTitle().equalsIgnoreCase("Play Quiz")){
                        loadFragmentFull(new QuizFragment(),"QuizFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Assignment")){
                        loadFragmentFull(new AssigmentFragment(),"AssigmentFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Time Table")){
                        loadFragmentFull(new TimeTableFragment(),"TimeTableFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Data Sheet")){
                        loadFragmentFull(new DataSheetFragment(),"DataSheetFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("School Holiday")){
                        loadFragmentFull(new AttendenceFragment(),"AttendenceFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Ask Doubts")){
                        loadFragmentFull(new AskdoubtFragment(),"AskdoubtFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("School Gallery")){
                        loadFragmentFull(new SchoolGalleryFragment(),"SchoolGalleryFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Leave Application")){
                        loadFragmentFull(new LeaveApplicationFragment(),"LeaveApplicationFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Change Password")){
                        loadFragmentFull(new ChangePasswordFragment(),"ChangePasswordFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Events")){
                        loadFragmentFull(new EventProgramFragment(),"EventProgramFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Result")){
                        loadFragmentFull(new ResultFragment(),"ResultFragment");
                    }
                    else if (dashboardModel.getTitle().equalsIgnoreCase("Logout")){
                        SecurePreferences.clearSecurepreference(activity);
                        startActivity(new Intent(activity, LoginActivity.class));
                        activity.finish();
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return dashboardList.size();
        }

        public class DashboardViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.iv_dashboardIcon)
            ImageView iv_dashboardIcon;
            @BindView(R.id.tv_dashboardTitle)
            TextView tv_dashboardTitle;
            public DashboardViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }

}