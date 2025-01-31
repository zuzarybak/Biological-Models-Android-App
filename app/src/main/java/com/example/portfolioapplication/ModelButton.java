package com.example.portfolioapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ModelButton extends LinearLayout {
    public ModelButton(Context context) {
        super(context);
        initContext(context);
    }

    public ModelButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initContext(context);
    }

    public ModelButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContext(context);
    }

    private void initContext(Context context) {
        inflate(context,R.layout.model_button,this);
    }
}
