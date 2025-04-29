package com.example.portfolioapplication;

public class ModelButtonData {
    private ModelButtonType type;
    private boolean liked;
    private int id;

    public ModelButtonData(ModelButtonType type, int id) {
        this.type = type;
        this.liked = false;
        this.id = id;
    }

    public ModelButtonType getType() {
        return type;
    }

    public boolean isLiked() {
        return liked;
    }

    public int getId() {
        return id;
    }

    public void toggleLike() {
        if (liked) {
            liked = false;
        } else {
            liked = true;
        }
    }
}
