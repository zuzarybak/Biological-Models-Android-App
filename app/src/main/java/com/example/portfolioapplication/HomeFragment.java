package com.example.portfolioapplication;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {
    private Button model1Button;
    private Button model2Button;

        public HomeFragment() {
        }


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.home_fragment, container, false);
            model1Button = root.findViewById(R.id.model1_button);
            String formattedText1 = "<big>DNA</big><br><small> (deoxyribonucleic acid) <br> a polymer carrying genetic instructions </small>";
            model1Button.setText(Html.fromHtml(formattedText1, Html.FROM_HTML_MODE_LEGACY));
            Drawable drawable = getResources().getDrawable(R.drawable.dna);
            drawable.setBounds(0, 0, 200, 200);
            model1Button.setCompoundDrawables(drawable, null, null, null);
            model2Button = root.findViewById(R.id.model2_button);
            String formattedText2 = "<big>mRNA</big><br><small> (messenger ribonucleic acid) <br> a polymer being2 a product of transcription";
            model2Button.setText(Html.fromHtml(formattedText2, Html.FROM_HTML_MODE_LEGACY));
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
    }
}
