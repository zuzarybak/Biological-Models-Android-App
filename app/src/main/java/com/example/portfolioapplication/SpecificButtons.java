package com.example.portfolioapplication;

import java.util.List;

public class SpecificButtons implements ButtonSelectionStrategy {
    private List<ModelButtonType> buttonTypes;

    public SpecificButtons(List<ModelButtonType> buttonTypes) {
        this.buttonTypes = buttonTypes;
    }

    @Override
    public void selectButtons(ModelButtonViewModel modelButtonViewModel) {
        modelButtonViewModel.setSpecificTypes(buttonTypes);
    }
}
