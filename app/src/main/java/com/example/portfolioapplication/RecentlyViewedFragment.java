package com.example.portfolioapplication;

public class RecentlyViewedFragment extends ButtonsFragment {
    @Override
    public ButtonSelectionStrategy createStrategy() {
        return new LikedButtons();
    }

    @Override
    public String getTitle() {
        return "RECENTLY VIEWED MODELS";
    }

}
