package com.example.portfolioapplication;

import java.util.List;

public class HomeFragment extends ButtonsFragment {
    @Override
    public List<ModelButtonType> getButtonTypes() {
        return List.of(ModelButtonType.DNA, ModelButtonType.MRNA);
    }

    @Override
    public String getTitle() {
        return "ALL THE MODELS";
    }
}
