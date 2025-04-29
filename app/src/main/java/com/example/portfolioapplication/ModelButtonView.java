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

import androidx.annotation.Nullable;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;

public class ModelButtonView extends LinearLayout {

    NavController navController;
    private TextView textView;
    private ImageView image;
    private ImageButton likeIcon;
    private int destinationId;
    private Runnable likeAction;
    private ModelButtonData data;

    public ModelButtonView(Context context, int destinationId, ModelButtonData data) {
        super(context);
        this.destinationId = destinationId;
        this.data = data;
        init(context);
    }

    public ModelButtonView(Context context, @Nullable AttributeSet attrs, ModelButtonData data) {
        super(context, attrs);
        this.data = data;
        init(context);
    }

    public ModelButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, ModelButtonData data) {
        super(context, attrs, defStyleAttr);
        this.data = data;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.model_button, this);
        textView = findViewById(R.id.model_button_text);
        setText(data.getType().getTitle(), data.getType().getSubtitle(), data.getType().getDescription());


        setLikeIcon();

        Drawable image1 = getResources().getDrawable(data.getType().getImage());
        setImage(image1);

        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        }); //todo : dalsza inicjacja na bazie model button data
    }
    public void setNavController(NavController navController,int fromId) {
        this.navController = navController;
        NavGraph navGraph = navController.getGraph();
        NavAction dynamicAction = new NavAction(destinationId);
        navGraph.putAction(fromId, dynamicAction);
        navController.setGraph(navGraph);
    }

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

    public void setLikeIcon() {
        Drawable drawable = getResources().getDrawable(R.drawable.baseline_bookmark_border_24);
        //todo : jak poprawić drawable
        likeIcon = findViewById(R.id.like_icon);
        likeIcon.setImageDrawable(drawable);

        if (data.isLiked()) {
            likeIcon.setImageResource(R.drawable.baseline_bookmark_24);
        } else {
            likeIcon.setImageResource(R.drawable.baseline_bookmark_border_24);
        }

        likeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeAction.run();
            }
        });
    }

    public void clickButton() {
        navController.navigate(destinationId);
    }

    public void setLikeAction(Runnable likeAction) {
        this.likeAction = likeAction;
    }
}


