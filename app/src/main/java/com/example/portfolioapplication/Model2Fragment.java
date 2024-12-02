package com.example.portfolioapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Model2Fragment extends Fragment {
    private TextView model2Text;
    public Model2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.model2_fragment, container, false);
        model2Text = root.findViewById(R.id.model2Text);
        model2Text.setText("MODEL");
        return root;
    }
}
