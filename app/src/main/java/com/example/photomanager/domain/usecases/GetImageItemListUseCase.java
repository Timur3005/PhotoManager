package com.example.photomanager.domain.usecases;

import androidx.lifecycle.LiveData;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import java.util.List;

import javax.inject.Inject;

public class GetImageItemListUseCase {

    private final ImageRepository repository;

    @Inject
    public GetImageItemListUseCase(ImageRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<ImageItem>> getImages(){
        return repository.getImages();
    }
}
