package com.example.schoolproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.schoolproject.R;
import com.example.schoolproject.helper.AppConstant;
import com.example.schoolproject.helper.SecurePreferences;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (AppConstant.isOnline(getApplicationContext())) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (SecurePreferences.getBooleanPreference(getApplicationContext(),AppConstant.IS_LOGIN)){
                        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    }
                    else {
                        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    }
                    finish();
                }

            }, 2000);
        }
    }
}