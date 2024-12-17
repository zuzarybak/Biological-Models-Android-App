package com.example.portfolioapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Model1Fragment extends Fragment {

    private TextView model1Text;

    public Model1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.model1_fragment, container, false);
        model1Text = root.findViewById(R.id.model1Text);
        model1Text.setText("DNA");
        model1Text.append("\ndna_button_description");
        return root;
    }
}
