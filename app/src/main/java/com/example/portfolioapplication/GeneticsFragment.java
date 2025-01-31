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

public class GeneticsFragment extends Fragment {

    private TextView model1Text2;
    private TextView model2Text2;
    private ImageView model1Image2;
    private ImageView model2Image2;
    private ImageButton model1LikeIcon2;
    private ImageButton model2LikeIcon2;
    private LinearLayout model1Button2;
    private LinearLayout model2Button2;

    public GeneticsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.genetics_fragment, container, false);
        model1Button2 = root.findViewById(R.id.model_1_button);
        model1Text2 = root.findViewById(R.id.model_1_text);
        String formattedText1 = "<big>DNA</big><br><small> (deoxyribonucleic acid) <br> a polymer carrying genetic instructions </small>";
        model1Text2.setText(Html.fromHtml(formattedText1, Html.FROM_HTML_MODE_LEGACY));
        model1Image2 = root.findViewById(R.id.model1_image);
        model1LikeIcon2 = root.findViewById(R.id.like_icon1);

        model2Button2 = root.findViewById(R.id.model_2_button);
        model2Text2 = root.findViewById(R.id.model_2_text);
        String formattedText2 = "<big>mRNA</big><br><small> (messenger ribonucleic acid) <br> a polymer being a product of transcription";
        model2Text2.setText(Html.fromHtml(formattedText2, Html.FROM_HTML_MODE_LEGACY));
        model2Image2 = root.findViewById(R.id.model2_image);
        model2LikeIcon2 = root.findViewById(R.id.like_icon2);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());

        model1LikeIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model1LikeIcon2.setImageResource(R.drawable.baseline_bookmark_24);
            }
        });

        model2LikeIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model2LikeIcon2.setImageResource(R.drawable.baseline_bookmark_24);
            }
        });
    }
}
