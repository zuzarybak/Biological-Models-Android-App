package com.example.portfolioapplication;

public enum ModelButtonType {
    DNA("DNA", "(deoxyribonucleic acid)", "a polymer carrying genetic instructions",
            R.drawable.dna),
    MRNA("mRNA", "(messenger ribonucleic acid)", "a polymer which is a product " +
            "of transcription, and a substrate of translation", R.drawable.mrna);

    ModelButtonType(String title, String subtitle, String description, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.image = image;
    }

    private String title;
    private String subtitle;
    private String description;
    private int image;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
