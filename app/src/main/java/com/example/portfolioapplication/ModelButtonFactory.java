package com.example.portfolioapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class ModelButtonFactory {

    public ModelButton createButton(Context context, Resources resources,  ModelButtonType type) {
       int destinationId;

       if (type == ModelButtonType.DNA) {
           destinationId = R.id.model1Fragment;
       } else if (type == ModelButtonType.MRNA) {
           destinationId = R.id.model2Fragment;
        } else {
           throw new IllegalStateException("nie wykryto model type");
       }

        ModelButton result = new ModelButton(context, destinationId);

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
