package com.example.portfolioapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModelButtonRepository {
    private List <ModelButtonData> modelButtons;
    private static ModelButtonRepository instance  = new ModelButtonRepository();


    private ModelButtonRepository() {
        modelButtons = new ArrayList<>();
        modelButtons.add(new ModelButtonData(ModelButtonType.DNA, 1));
        modelButtons.add(new ModelButtonData(ModelButtonType.MRNA, 2));
    }

    public List <ModelButtonData> getAllButtons() {
        return modelButtons;
    }

    public List <ModelButtonData> getSpecificButtons(List <ModelButtonType> specificButtons) {
        return modelButtons.stream()
                .filter(button -> specificButtons.contains(button.getType()))
                .collect(Collectors.toList());
    }

    public static ModelButtonRepository getInstance() {
        return instance;
    }

    public List <ModelButtonData> getLikedButtons() {
        return modelButtons.stream()
                .filter(button -> button.isLiked())
                .collect(Collectors.toList());
    }

    public void sortButtons() {
        modelButtons.sort((m1,m2)->{
            if (m1.isLiked() && !m2.isLiked()) {
                return -1;
            } else if (!m1.isLiked() && m2.isLiked()) {
                return 1;
            }else{
                return 0;
            }
        });
    }

}
