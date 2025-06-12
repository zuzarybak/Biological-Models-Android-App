package com.example.portfolioapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.List;

abstract class ButtonsFragment extends Fragment {
    private ModelButtonViewModel modelButtonViewModel;
    private LinearLayout buttonsContainerLayout;

    private ButtonSelectionStrategy strategy;

    public abstract ButtonSelectionStrategy createStrategy();
    public abstract String getTitle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        modelButtonViewModel = new ViewModelProvider(this).get(ModelButtonViewModel.class);
        //modelButtonViewModel.setSpecificTypes(getButtonTypes());
        strategy = createStrategy();
        strategy.selectButtons(modelButtonViewModel);
        modelButtonViewModel.getModelButtonLiveData().observe(
                getViewLifecycleOwner(),
                modelButtons -> refreshModelButtonViews(modelButtons)
        );

        View root = inflater.inflate(R.layout.buttons_container, container, false);
        buttonsContainerLayout = root.findViewById(getFragmentId());

        TextView textView = root.findViewById(R.id.text_view);
        textView.setText(getTitle());
        return root;
    }

    private void refreshModelButtonViews(List<ModelButtonData> modelButtons) {
        buttonsContainerLayout.removeAllViews();
        ModelButtonFactory factory = new ModelButtonFactory(modelButtonViewModel);
        NavController navController = Navigation.findNavController(requireView());
        for (ModelButtonData modelButton : modelButtons) {
            ModelButtonView modelButtonView = factory.createButton(getContext(), modelButton);
            buttonsContainerLayout.addView(modelButtonView);
            modelButtonView.setNavController(navController, getFragmentId());
        }
    }

    int getFragmentId() {
        return R.id.buttons_container_layout;
    }

    public void setStrategy(ButtonSelectionStrategy strategy) {
        this.strategy = strategy;
    }
}

