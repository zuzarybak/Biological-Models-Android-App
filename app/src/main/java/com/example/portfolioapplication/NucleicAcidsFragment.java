package com.example.portfolioapplication;
import java.util.List;

public class NucleicAcidsFragment extends ButtonsFragment {

    @Override
    public ButtonSelectionStrategy createStrategy() {
        return new SpecificButtons(List.of(ModelButtonType.DNA));
    }

    @Override
    public String getTitle() {
        return "MODELS FROM THE CATEGORY : \"NUCLEIC ACIDS\"";
    }
}
