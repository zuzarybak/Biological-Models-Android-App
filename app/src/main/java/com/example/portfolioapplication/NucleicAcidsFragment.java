package com.example.portfolioapplication;
import java.util.List;

public class NucleicAcidsFragment extends ButtonsFragment {
    @Override
    public List<ModelButtonType> getButtonTypes() {
        return List.of( ModelButtonType.MRNA);
    }

    @Override
    public String getTitle() {
        return "MODELS FROM THE CATEGORY : NUCLEIC ACIDS";
    }
}
