package com.example.portfolioapplication;

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

public class NucleicAcidsFragment extends Fragment {
    private List<ModelButtonView> geneticsButtons = new ArrayList<>();

    public NucleicAcidsFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        geneticsButtons.clear();

        View root = inflater.inflate(R.layout.nucleic_acids_fragment, container, false);

        ModelButtonFactory modelButtonFactory = new ModelButtonFactory();

        ModelButtonView button1 = modelButtonFactory.createButton(getContext(), getResources(), ModelButtonType.DNA);
        ModelButtonView button2 = modelButtonFactory.createButton(getContext(), getResources(), ModelButtonType.MRNA);

        LinearLayout parent = root.findViewById(R.id.parent_linear_genetics);

        geneticsButtons.add(button1);
        geneticsButtons.add(button2);

        for (ModelButtonView modelButton : geneticsButtons) {
            parent.addView(modelButton);
        }

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());

        for (ModelButtonView modelButton : geneticsButtons) {
            modelButton.setNavController(navController,R.id.geneticsFragment);
        }
    }
}
