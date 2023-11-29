package com.example.photomanager.presentation.imageitem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.usecases.AddImageUseCase;
import com.example.photomanager.domain.usecases.GetImageItemUseCase;

import javax.inject.Inject;

public class ImageItemViewModel extends ViewModel {

    private final AddImageUseCase addImageUseCase;
    private final GetImageItemUseCase getImageItemUseCase;

    @Inject
    public ImageItemViewModel(AddImageUseCase addImageUseCase, GetImageItemUseCase getImageItemUseCase) {
        this.addImageUseCase = addImageUseCase;
        this.getImageItemUseCase = getImageItemUseCase;
    }


    public LiveData<ImageItem> getImageItem(int id){
        return getImageItemUseCase.getImageItem(id);
    }

    void insertImageItem(ImageItem imageItem){
        addImageUseCase.addItem(imageItem);
    }
}
