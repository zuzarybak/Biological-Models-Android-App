package com.example.portfolioapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class ModelButtonFactory {
    private ModelButtonViewModel modelButtonViewModel;

    ModelButtonFactory(ModelButtonViewModel modelButtonViewModel) {
        this.modelButtonViewModel = modelButtonViewModel;
    }

    public ModelButtonView createButton(Context context, ModelButtonData modelButtonData) {
       int destinationId;
       ModelButtonType type = modelButtonData.getType();

       if (type == ModelButtonType.DNA) {
           destinationId = R.id.model1Fragment;
       } else if (type == ModelButtonType.MRNA) {
           destinationId = R.id.model2Fragment;
        } else {
           throw new IllegalStateException("nie wykryto model type");
       }

        ModelButtonView result = new ModelButtonView(context, destinationId, modelButtonData);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        result.setLayoutParams(params);
        result.setLikeAction(() -> modelButtonViewModel.toggleLike(modelButtonData));
        return result;
    }

}
