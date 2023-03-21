package com.example.schoolproject.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class CustomTextViewSemiBold extends TextView {
    public CustomTextViewSemiBold(Context context) {
        super(context);
        applyCustomFont(context);

    }

    public CustomTextViewSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs); applyCustomFont(context);
    }

    public CustomTextViewSemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextViewSemiBold(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = com.example.schoolproject.helper.FontCache.getTypeface("GothamSemibold.ttf", context);
        setTypeface(customFont);
    }
}
