package com.example.portfolioapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ModelButtonViewModel extends ViewModel {
    private MutableLiveData<List<ModelButtonData>> modelButtonLiveData;
    private ModelButtonRepository modelButtonRepository;

    private List <ModelButtonType> specificTypes = new ArrayList<>();

    public ModelButtonViewModel () {
        modelButtonRepository = ModelButtonRepository.getInstance();
        modelButtonLiveData = new MutableLiveData<>();
    }

    public void loadModelButtons() {
        List <ModelButtonData> modelButtons = modelButtonRepository.getSpecificButtons(specificTypes);
        modelButtonLiveData.setValue(modelButtons);
    }

    public LiveData<List<ModelButtonData>> getModelButtonLiveData() {
        return modelButtonLiveData;
    }

    public void toggleLike(ModelButtonData modelButtonData) {
        modelButtonData.toggleLike();
        modelButtonRepository.sortButtons();
        loadModelButtons();
    }

    public void setSpecificTypes(List<ModelButtonType> specificTypes) {
        this.specificTypes = specificTypes;
        loadModelButtons();
    }
}
