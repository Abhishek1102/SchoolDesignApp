package com.example.schoolproject.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AskdoubtFragment extends BaseFragment {

    @BindView(R.id.txt_doubt_title)
    TextView txt_doubt_title;
    @BindView(R.id.edt_doubt_title)
    EditText edt_doubt_title;
    @BindView(R.id.txt_doubt_description)
    TextView txt_doubt_description;
    @BindView(R.id.edt_doubt_description)
    EditText edt_doubt_description;
    @BindView(R.id.spinner_subject)
    Spinner spinner_subject;
    @BindView(R.id.spinner_teacher)
    Spinner spinner_teacher;

    String[] teachers = {"James Smith","Paul Smith","Steve Smith","Andy Smith","Richardson Smith"};
    String [] subjects = {"Math","English","Science","Gujarati","History"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_askdoubt, container, false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        textWatcher(edt_doubt_title,txt_doubt_title);
        textWatcher(edt_doubt_description,txt_doubt_description);


        //custom spinner
        ArrayAdapter<String> spinnerTeacherAdapter = new ArrayAdapter<String>(activity, R.layout.custom_spinner,
                teachers);
        spinnerTeacherAdapter.setDropDownViewResource(R.layout.custom_spinner);
        spinner_teacher.setAdapter(spinnerTeacherAdapter);

        ArrayAdapter<String> spinnerSubjectAdapter = new ArrayAdapter<String>(activity, R.layout.custom_spinner,
                subjects);
        spinnerSubjectAdapter.setDropDownViewResource(R.layout.custom_spinner);
        spinner_subject.setAdapter(spinnerSubjectAdapter);

    }

    @OnClick(R.id.lv_sendDoubt)
    void lv_sendDoubt(){
        Toast.makeText(activity, "Doubt Submitted", Toast.LENGTH_SHORT).show();
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