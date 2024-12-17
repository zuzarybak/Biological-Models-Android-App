package com.example.portfolioapplication;

import android.os.Bundle;
import android.util.Log;
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

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button model1Button;
    private Button model2Button;

        public HomeFragment() {
        }


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.home_fragment, container, false);
            model1Button = root.findViewById(R.id.model1_button);
            model2Button = root.findViewById(R.id.model2_button);
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
