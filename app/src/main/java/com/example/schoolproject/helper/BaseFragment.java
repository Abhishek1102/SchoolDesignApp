package com.example.schoolproject.helper;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.schoolproject.R;

public abstract class BaseFragment extends Fragment
{
    public AppCompatActivity activity;
    @Nullable
    @Override
    public abstract View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public abstract void initView();

    public abstract void onBack();

    public void loadFragmentFull(Fragment fragment1, String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.frame_full, fragment1, tag).addToBackStack(null).commit();
    }
//    public void loadLoginFragmentFull(Fragment fragment1, String tag) {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.add(R.id.frame_authentication, fragment1, tag).addToBackStack(null).commit();
//    }
//    public void loadLandingPageFragmentFull(Fragment fragment1, String tag) {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.add(R.id.frame_landingpage, fragment1, tag).addToBackStack(null).commit();
//    }
//    public void loadFragmentMain(Fragment fragment1, String tag) {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.add(R.id.frame_main, fragment1, tag).addToBackStack(null).commit();
//    }

//     public void addFragmentRegionFull(Fragment fragment1, String tag) {
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_full, fragment1, tag).addToBackStack(null).commit();
//    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

//    public void unauthenticate(String error)
//    {
//        if (error.equalsIgnoreCase("Unauthenticated."))
//        {
//            SecurePreferences.clearSecurepreference(activity);
//            onBack();
//            startActivity(new Intent(activity, LoginActivity.class));
//        }
//        Toast.makeText(activity, error, Toast.LENGTH_SHORT).show();
//    }
}
