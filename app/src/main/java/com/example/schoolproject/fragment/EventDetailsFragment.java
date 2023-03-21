package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.EventProgramModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventDetailsFragment extends BaseFragment {

    @BindView(R.id.tv_eventdetailTime)
    TextView tv_eventdetailTime;
    @BindView(R.id.tv_eventdetailTitle)
    TextView tv_eventdetailTitle;
    @BindView(R.id.iv_eventDetail)
    ImageView iv_eventDetail;
    @BindView(R.id.tv_eventdetailDescription)
    TextView tv_eventdetailDescription;

    EventProgramModel eventProgramModel;

    public EventDetailsFragment(EventProgramModel eventProgramModel) {
        this.eventProgramModel = eventProgramModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_details, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        iv_eventDetail.setImageResource(eventProgramModel.getEventImage());
        tv_eventdetailTime.setText(eventProgramModel.getEventTime());
        tv_eventdetailTitle.setText(eventProgramModel.getEventTitle());
        tv_eventdetailDescription.setText(eventProgramModel.getEventDescription());
    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }
}