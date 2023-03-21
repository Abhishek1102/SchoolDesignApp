package com.example.schoolproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.AppConstant;
import com.example.schoolproject.helper.SecurePreferences;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btnverify)
    void btnverifyClick(){
        SecurePreferences.savePreferences(getApplicationContext(), AppConstant.IS_LOGIN,true);
        startActivity(new Intent(OtpActivity.this,MainActivity.class));
        finish();
    }
}