package com.example.photomanager.domain.usecases;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import javax.inject.Inject;

public class DeleteImageItemUseCase {

    private ImageRepository repository;

    @Inject
    public DeleteImageItemUseCase(ImageRepository repository) {
        this.repository = repository;
    }

    public void deleteImageItem(ImageItem imageItem){
        repository.deleteImageItem(imageItem);
    }
}
