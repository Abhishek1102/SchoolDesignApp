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

public class ChangePasswordFragment extends BaseFragment {

    @BindView(R.id.txt_password_old)
    TextView txt_password_old;
    @BindView(R.id.txt_password_new)
    TextView txt_password_new;
    @BindView(R.id.txt_password_retype)
    TextView txt_password_retype;
    @BindView(R.id.edt_password_old)
    EditText edt_password_old;
    @BindView(R.id.edt_password_new)
    EditText edt_password_new;
    @BindView(R.id.edt_password_retype)
    EditText edt_password_retype;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        textWatcher(edt_password_old,txt_password_old);
        textWatcher(edt_password_new,txt_password_new);
        textWatcher(edt_password_retype,txt_password_retype);
    }

    @OnClick(R.id.lv_changePassword)
    void lv_changePassword(){
        Toast.makeText(activity, "Password Changed", Toast.LENGTH_SHORT).show();
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