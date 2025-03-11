package com.example.portfolioapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ModelButtonFactory {

    public ModelButton createButton(Context context, Resources resources,  ModelButtonType type) {
        Fragment destination;

       if (type == ModelButtonType.DNA) {
           destination = new ModelDnaFragment();
       } else if (type == ModelButtonType.MRNA) {
           destination = new ModelMrnaFragment();
       } else {
           throw new IllegalStateException("Nie rozpoznany model type");
       }

       ModelButton result = new ModelButton(context, destination);
        //ModelButton result = new ModelButton(context, actionId);

        result.setText(type.getTitle(),type.getSubtitle(), type.getDescription());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        result.setLayoutParams(params);
        Drawable likeIcon = resources.getDrawable(R.drawable.baseline_bookmark_border_24);

        Drawable image1 = resources.getDrawable(type.getImage());
        result.setImage(image1);
        result.setLikeIcon(likeIcon);
        return result;
    }

}
