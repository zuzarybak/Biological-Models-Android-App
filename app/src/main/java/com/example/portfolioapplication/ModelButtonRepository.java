package com.example.portfolioapplication;

import java.util.ArrayList;
import java.util.List;

public class ModelButtonRepository {
    private List <ModelButtonData> modelButtons;

    private ModelButtonRepository() {
        modelButtons = new ArrayList<>();
        modelButtons.add(new ModelButtonData(ModelButtonType.DNA, 1));

    }
}
