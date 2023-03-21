package com.example.schoolproject.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Spinner;

public class CustomSpinner extends Spinner {

    public CustomSpinner(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = com.example.schoolproject.helper.FontCache.getTypeface("GothamMedium.ttf", context);
        setTypeface(customFont);
    }

    private void setTypeface(Typeface customFont) {
    }
}
