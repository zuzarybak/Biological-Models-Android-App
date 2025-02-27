package com.example.portfolioapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class GeneticsFragment extends Fragment {
    ModelButton modelButton1;
    ModelButton modelButton2;

    public GeneticsFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        modelButton1 = new ModelButton(getContext(), R.id.action_homeFragment_to_fragment1);
        modelButton2 = new ModelButton(getContext(), R.id.action_homeFragment_to_fragment2);

        View root = inflater.inflate(R.layout.home_fragment, container, false);

        modelButton1.setText("DNA","(deoxyribonucleic acid)", "a polymer carrying genetic instructions");
        modelButton2.setText("mRNA","(messenger ribonucleic acid)", "a polymer which is a product of transcription, and a substrate of translation");

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

//        model1LikeIcon2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                model1LikeIcon2.setImageResource(R.drawable.baseline_bookmark_24);
//            }
//        });
//
//        model2LikeIcon2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                model2LikeIcon2.setImageResource(R.drawable.baseline_bookmark_24);
//            }
//        });
    }
}
