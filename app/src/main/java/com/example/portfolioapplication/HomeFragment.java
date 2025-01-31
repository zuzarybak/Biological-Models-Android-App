package com.example.portfolioapplication;

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
    private TextView model1Text;
    private TextView model2Text;
    private ImageView model1Image;
    private ImageView model2Image;
    private ImageButton model1LikeIcon;
    private ImageButton model2LikeIcon;
    private LinearLayout model1Button;
    private LinearLayout model2Button;

    public HomeFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_fragment, container, false);
        model1Button = root.findViewById(R.id.model_1_button);
        model1Text = root.findViewById(R.id.model_1_text);
        String formattedText1 = "<big>DNA</big><br><small> (deoxyribonucleic acid) <br> a polymer carrying genetic instructions </small>";
        model1Text.setText(Html.fromHtml(formattedText1, Html.FROM_HTML_MODE_LEGACY));
        model1Image = root.findViewById(R.id.model1_image);
        model1LikeIcon = root.findViewById(R.id.like_icon1);

        model2Button = root.findViewById(R.id.model_2_button);
        model2Text = root.findViewById(R.id.model_2_text);
        String formattedText2 = "<big>mRNA</big><br><small> (messenger ribonucleic acid) <br> a polymer being a product of transcription";
        model2Text.setText(Html.fromHtml(formattedText2, Html.FROM_HTML_MODE_LEGACY));
        model2Image = root.findViewById(R.id.model2_image);
        model2LikeIcon = root.findViewById(R.id.like_icon2);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());

        model1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_fragment1);
            }
        });
        model2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_homeFragment_to_fragment2);
            }
        });
        model1LikeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model1LikeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                if(model1Button.getGravity() != Gravity.TOP) {
                    model1Button.setGravity(Gravity.TOP);
                }
            }
        });
        model2LikeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model2LikeIcon.setImageResource(R.drawable.baseline_bookmark_24);
                if(model2Button.getGravity() != Gravity.TOP) {
                    model2Button.setGravity(Gravity.TOP);
                }
            }
        });
    }
}

