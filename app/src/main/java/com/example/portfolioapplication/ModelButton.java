package com.example.portfolioapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.text.Html;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ModelButton extends LinearLayout {
    private TextView textView;
    private ImageView image;
    private ImageButton likeIcon;

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
        inflate(context, R.layout.model_button, this);
        textView = findViewById(R.id.model_button_text);
    }

    public void setText(String title, String subtitle, String description) {
        String formattedText = "<big>" + title + "</big><br><small>" + subtitle + "<br>" + description;
        textView.setText(Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY));
    }

    public void setImage(Drawable drawable) {
        image = findViewById(R.id.model_image);
        image.setImageDrawable(drawable);
    }

    public void setLikeIcon(Drawable drawable) {
        likeIcon = findViewById(R.id.like_icon);
        likeIcon.setImageDrawable(drawable);
        likeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                LinearLayout parent = (LinearLayout) ModelButton.this.getParent();
                parent.removeView(ModelButton.this);
                parent.addView(ModelButton.this, 1);
            }
        });
    }
}
