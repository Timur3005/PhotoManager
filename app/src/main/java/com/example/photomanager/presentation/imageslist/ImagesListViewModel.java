package com.example.photomanager.presentation.imageslist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.usecases.GetImageItemListUseCase;

import java.util.List;

import javax.inject.Inject;

public class ImagesListViewModel extends ViewModel {

    private GetImageItemListUseCase getImageItemListUseCase;

    @Inject
    public ImagesListViewModel(GetImageItemListUseCase getImageItemListUseCase) {
        this.getImageItemListUseCase = getImageItemListUseCase;
    }

    public LiveData<List<ImageItem>> getImages() {
        return getImageItemListUseCase.getImages();
    }
}
