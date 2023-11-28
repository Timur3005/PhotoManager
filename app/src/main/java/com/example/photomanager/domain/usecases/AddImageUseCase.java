package com.example.photomanager.domain.usecases;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import javax.inject.Inject;

public class AddImageUseCase {
    private ImageRepository repository;

    @Inject
    public AddImageUseCase(ImageRepository repository) {
        this.repository = repository;
    }

    public void addItem(ImageItem imageItem){
        repository.insertImage(imageItem);
    }
}
