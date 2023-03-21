package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeaveApplicationFragment extends BaseFragment {

    @BindView(R.id.txt_leave_teacher)
    TextView txt_leave_teacher;
    @BindView(R.id.edt_leave_teacher)
    EditText edt_leave_teacher;
    @BindView(R.id.txt_leave_title)
    TextView txt_leave_title;
    @BindView(R.id.edt_leave_title)
    EditText edt_leave_title;
    @BindView(R.id.txt_leave_description)
    TextView txt_leave_description;
    @BindView(R.id.edt_leave_description)
    EditText edt_leave_description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_application, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        textWatcher(edt_leave_teacher,txt_leave_teacher);
        textWatcher(edt_leave_title,txt_leave_title);
        textWatcher(edt_leave_description,txt_leave_description);


    }

    @OnClick(R.id.tv_sendRequest)
    void tv_sendRequestClick() {
        Toast.makeText(activity, "Leave Submitted", Toast.LENGTH_SHORT).show();
        getParentFragmentManager().popBackStack();
    }

    @Override
    @OnClick(R.id.iv_back)
    public void onBack() {
        getParentFragmentManager().popBackStack();
    }

    public void textWatcher(EditText edt, TextView textView)
    {
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edt.getText().length()>0)
                    textView.setVisibility(View.VISIBLE);
                else
                    textView.setVisibility(View.GONE);
            }
        });
    }
}