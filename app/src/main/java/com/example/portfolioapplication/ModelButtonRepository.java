package com.example.portfolioapplication;

import java.util.ArrayList;
import java.util.List;

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

    public static ModelButtonRepository getInstance() {
        return instance;
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
