package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;
import com.example.schoolproject.model.EventProgramModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventProgramFragment extends BaseFragment {

    @BindView(R.id.rv_eventsPrograms)
    RecyclerView rv_events;

    EventsAdapter eventsAdapter;

    List<EventProgramModel> eventProgramList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_program, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {

        eventProgramList = new ArrayList<>();

        eventProgramList.add(new EventProgramModel("Cycle Race", R.drawable.cyclerace, "06 Jan 20,09:00 AM", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content."));
        eventProgramList.add(new EventProgramModel("Cycle Race", R.drawable.cyclerace, "06 Jan 20,09:00 AM", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content."));
        eventProgramList.add(new EventProgramModel("Cycle Race", R.drawable.cyclerace, "06 Jan 20,09:00 AM", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."));
        eventProgramList.add(new EventProgramModel("Cycle Race", R.drawable.cyclerace, "06 Jan 20,09:00 AM", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."));
        eventProgramList.add(new EventProgramModel("Cycle Race", R.drawable.cyclerace, "06 Jan 20,09:00 AM", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface."));


        eventsAdapter = new EventsAdapter();
        rv_events.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        rv_events.setAdapter(eventsAdapter);

    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

        @NonNull
        @Override
        public EventsAdapter.EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_events, parent, false);
            return new EventsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EventsAdapter.EventsViewHolder holder, int position) {
            EventProgramModel eventProgramModel = eventProgramList.get(position);
            holder.tv_eventTitle.setText(eventProgramModel.getEventTitle());
            holder.tv_eventTime.setText(eventProgramModel.getEventTime());
            holder.tv_eventDescription.setText(eventProgramModel.getEventDescription());
            holder.iv_event.setImageResource(eventProgramModel.getEventImage());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventDetailsFragment eventDetailsFragment = new EventDetailsFragment(eventProgramModel);
                    loadFragmentFull(eventDetailsFragment,"eventDetailsFragment,");
                }
            });
        }

        @Override
        public int getItemCount() {
            return eventProgramList.size();
        }

        public class EventsViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.tv_eventTitle)
            TextView tv_eventTitle;
            @BindView(R.id.tv_eventTime)
            TextView tv_eventTime;
            @BindView(R.id.tv_eventDescription)
            TextView tv_eventDescription;
            @BindView(R.id.iv_event)
            ImageView iv_event;

            public EventsViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}