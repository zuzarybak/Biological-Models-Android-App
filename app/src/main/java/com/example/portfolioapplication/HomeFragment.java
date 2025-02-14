package com.example.portfolioapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {
    private ImageButton model1LikeIcon;
    private ImageButton model2LikeIcon;

    ModelButton modelButton1;
    ModelButton modelButton2;


    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        modelButton1 = new ModelButton(getContext());
        modelButton2 = new ModelButton(getContext());

        View root = inflater.inflate(R.layout.home_fragment, container, false);

        modelButton1.setText("DNA","(deoxyribonucleic acid)", "a polymer carrying genetic instructions");
        LinearLayout parent = root.findViewById(R.id.parent_linear);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        modelButton1.setLayoutParams(params);
        modelButton2.setLayoutParams(params);
        parent.addView(modelButton1);
        parent.addView(modelButton2);

        Drawable likeIcon = getResources().getDrawable(R.drawable.baseline_bookmark_border_24);

        Drawable image1 = getResources().getDrawable(R.drawable.dna);
        modelButton1.setImage(image1);
        modelButton1.setLikeIcon(likeIcon);

        Drawable image2 = getResources().getDrawable(R.drawable.mrna);
        modelButton2.setImage(image2);
        modelButton2.setLikeIcon(likeIcon);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());

        modelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_fragment1);
            }
        });
        modelButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_fragment2);
            }
        });
        model1LikeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model1LikeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                if(modelButton1.getGravity() != Gravity.TOP) {
                    modelButton1.setGravity(Gravity.TOP);
                }
            }
        });
       model2LikeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model2LikeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                if(modelButton2.getGravity() != Gravity.TOP) {
                    modelButton2.setGravity(Gravity.TOP);
                }
            }
        });
    }
}

