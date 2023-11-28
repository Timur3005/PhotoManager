package com.example.photomanager.presentation.imageslist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.usecases.DeleteImageItemUseCase;
import com.example.photomanager.domain.usecases.GetImageItemListUseCase;

import java.util.List;

import javax.inject.Inject;

public class ImagesListViewModel extends ViewModel {

    private final GetImageItemListUseCase getImageItemListUseCase;
    private final DeleteImageItemUseCase deleteImageItemUseCase;

    @Inject
    public ImagesListViewModel(GetImageItemListUseCase getImageItemListUseCase, DeleteImageItemUseCase deleteImageItemUseCase) {
        this.getImageItemListUseCase = getImageItemListUseCase;
        this.deleteImageItemUseCase = deleteImageItemUseCase;
    }

    public LiveData<List<ImageItem>> getImages() {
        return getImageItemListUseCase.getImages();
    }

    public void deleteImageItem(ImageItem imageItem){
        deleteImageItemUseCase.deleteImageItem(imageItem);
    }
}
