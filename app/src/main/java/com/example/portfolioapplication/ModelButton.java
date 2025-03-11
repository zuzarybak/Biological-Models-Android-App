package com.example.portfolioapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.text.Html;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;

public class ModelButton extends LinearLayout {

    //NavController navController;
    private TextView textView;
    private ImageView image;
    private ImageButton likeIcon;
    private Fragment destination;
    //private int destinationId;
    private boolean isLiked;

    public ModelButton(Context context, Fragment destination) {
        super(context);
        init(context);
        this.destination = destination;

    }

    public ModelButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ModelButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.model_button, this);
        textView = findViewById(R.id.model_button_text);

        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });
    }
    /* public void setNavController(NavController navController) {
        this.navController = navController;
    } */

    public void setText(String title, String subtitle, String description) {
        String formattedText = "<big>" + title + "</big><br><small>" + subtitle + "<br>" + description;
        textView.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickButton();
            }
        });
    }

    public void setImage(Drawable drawable) {
        image = findViewById(R.id.model_image);
        image.setImageDrawable(drawable);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });
    }

    public void setLikeIcon(Drawable drawable) {
        likeIcon = findViewById(R.id.like_icon);
        likeIcon.setImageDrawable(drawable);
        likeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLiked) {
                    likeIcon.setImageResource(R.drawable.baseline_bookmark_border_24);
                    isLiked = false;
                } else {
                    likeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                    isLiked = true;
                    LinearLayout parent = (LinearLayout) ModelButton.this.getParent();
                    parent.removeView(ModelButton.this);
                    parent.addView(ModelButton.this, 1);
                }
            }
        });
    }
    public void clickButton() {
        System.out.println("click");
        ((MainActivity) getContext()).loadFragment(destination);
        //navController.navigate(destinationId);
    }
}


