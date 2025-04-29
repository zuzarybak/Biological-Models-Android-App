package com.example.portfolioapplication;

import static com.example.portfolioapplication.ModelButtonType.DNA;
import static com.example.portfolioapplication.ModelButtonType.MRNA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<ModelButtonView> buttons = new ArrayList<>();
    private ModelButtonRepository repository;

    private ModelButtonViewModel modelButtonViewModel;

    LinearLayout topLinearLayout;

    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        modelButtonViewModel = new ViewModelProvider(this).get(ModelButtonViewModel.class);

        modelButtonViewModel.getModelButtonLiveData().observe(
                getViewLifecycleOwner(),
                modelButtons -> refreshModelButtonViews(modelButtons)
        );
        View root = inflater.inflate(R.layout.home_fragment, container, false);
        topLinearLayout = root.findViewById(R.id.top_linear_layout);
    /*    buttons.clear();

        ModelButtonFactory factory = new ModelButtonFactory();
        ModelButtonView modelButton1 = factory.createButton(getContext(),getResources(),DNA);
        ModelButtonView modelButton2 = factory.createButton(getContext(),getResources(),MRNA);
        buttons.add(modelButton1);
        buttons.add(modelButton2);

        for (ModelButtonView button : buttons) {
            topLinearLayout.addView(button);
        }*/

        return root;
    }

    private void refreshModelButtonViews(List<ModelButtonData> modelButtons) {
        topLinearLayout.removeAllViews();
        ModelButtonFactory factory = new ModelButtonFactory(modelButtonViewModel);
        for (ModelButtonData modelButton : modelButtons) {
            ModelButtonView modelButtonView = factory.createButton(getContext(), modelButton);
            topLinearLayout.addView(modelButtonView);
            //todo podpiąć toggle na ViewModel pod akcję kliknięcia oraz informację o stanie like wyciągać z ModelButtonData
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireView());
        for (ModelButtonView button : buttons) {
            button.setNavController(navController, R.id.homeFragment);
        }
    }
}

//Fragment -> składa całość wyłapuje kliknięcie, pobiera zaktualizowane przyciski


