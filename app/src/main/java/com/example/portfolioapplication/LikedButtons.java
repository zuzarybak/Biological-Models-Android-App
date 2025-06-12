package com.example.portfolioapplication;

public class LikedButtons implements ButtonSelectionStrategy {
    @Override
    public void selectButtons(ModelButtonViewModel modelButtonViewModel) {
        modelButtonViewModel.setLikedTypes();
    }
}
