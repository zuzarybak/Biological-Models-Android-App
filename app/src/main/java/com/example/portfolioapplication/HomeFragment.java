package com.example.portfolioapplication;

import static com.example.portfolioapplication.ModelButtonType.DNA;
import static com.example.portfolioapplication.ModelButtonType.MRNA;

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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<ModelButton> buttons = new ArrayList<>();

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        buttons.clear();
        View root = inflater.inflate(R.layout.home_fragment, container, false);
        ModelButtonFactory factory = new ModelButtonFactory();
       ModelButton modelButton1 = factory.createButton(getContext(),getResources(),DNA,R.id.action_homeFragment_to_fragment1);
       ModelButton modelButton2 = factory.createButton(getContext(),getResources(),MRNA,R.id.action_homeFragment_to_fragment2);
        LinearLayout parent = root.findViewById(R.id.parent_linear_home);
        buttons.add(modelButton1);
        buttons.add(modelButton2);
        for (ModelButton button : buttons) {
            parent.addView(button);
        }
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());
        for (ModelButton button : buttons) {
            button.setNavController(navController);
        }
    }
}

