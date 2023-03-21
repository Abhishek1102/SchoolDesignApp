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
import android.widget.Toast;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.AssignmentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AssigmentFragment extends BaseFragment {

    @BindView(R.id.rv_assignment)
    RecyclerView rv_assignment;

    AssignmentAdapter assignmentAdapter;
    List<AssignmentModel> assignmentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assigment, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        assignmentList = new ArrayList<>();

        assignmentList.add(new AssignmentModel("Mathematics","Surface Areas and Volumes","10 Nov 2020","10 Dec 2020"));
        assignmentList.add(new AssignmentModel("Science","Structure of Atoms","10 Nov 2020","20 Nov 2020"));
        assignmentList.add(new AssignmentModel("English","My Bestfriend Essay","20 Dec 2020","20 Dec 2020"));
        assignmentList.add(new AssignmentModel("English","My Bestfriend Essay","20 Dec 2020","20 Dec 2020"));
        assignmentList.add(new AssignmentModel("English","My Bestfriend Essay","20 Dec 2020","20 Dec 2020"));

        assignmentAdapter = new AssignmentAdapter();
        rv_assignment.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false));
        rv_assignment.setAdapter(assignmentAdapter);

    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>{

        @NonNull
        @Override
        public AssignmentAdapter.AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_assignment,parent,false);
            return new AssignmentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AssignmentAdapter.AssignmentViewHolder holder, int position) {
            AssignmentModel assignmentModel = assignmentList.get(position);
            holder.tv_assigment_SubjectName.setText(assignmentModel.getSubjectName());
            holder.tv_assigment_Title.setText(assignmentModel.getTitle());
            holder.tv_assignDate.setText(assignmentModel.getAssigndate());
            holder.tv_submissionDate.setText(assignmentModel.getSubmissiondate());
            holder.lv_tobesubmitted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, assignmentModel.getSubjectName()+"assignment submitted", Toast.LENGTH_SHORT).show();
                }
            });
            if(position==(getItemCount()-1)){
               holder.lv_tobesubmitted.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return assignmentList.size();
        }

        public class AssignmentViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.tv_assigment_SubjectName)
            TextView tv_assigment_SubjectName;
            @BindView(R.id.tv_assigment_Title)
            TextView tv_assigment_Title;
            @BindView(R.id.tv_assignDate)
            TextView tv_assignDate;
            @BindView(R.id.tv_submissionDate)
            TextView tv_submissionDate;
            @BindView(R.id.lv_tobesubmitted)
            LinearLayout lv_tobesubmitted;

            public AssignmentViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }

}