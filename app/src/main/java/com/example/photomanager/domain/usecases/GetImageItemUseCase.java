package com.example.photomanager.domain.usecases;

import androidx.lifecycle.LiveData;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import javax.inject.Inject;

public class GetImageItemUseCase {

    private final ImageRepository repository;

    @Inject
    public GetImageItemUseCase(ImageRepository repository) {
        this.repository = repository;
    }

    public LiveData<ImageItem> getImageItem(){
        return repository.getImageItem();
    }
}
