package com.example.photomanager.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.photomanager.di.ApplicationScope;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

@ApplicationScope
public class ViewModelFactory implements ViewModelProvider.Factory {


    private Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelsProviders;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelsProviders) {
        this.viewModelsProviders = viewModelsProviders;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) viewModelsProviders.get(modelClass).get();
    }
}
