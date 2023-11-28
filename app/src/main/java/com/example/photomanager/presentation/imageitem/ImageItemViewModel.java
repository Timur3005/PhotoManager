package com.example.photomanager.presentation.imageitem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import javax.inject.Inject;

public class ImageItemViewModel extends ViewModel {

    private ImageRepository repository;
    @Inject
    public ImageItemViewModel(ImageRepository repository) {
        this.repository = repository;
    }

    private MutableLiveData<ImageItem> imageItem = new MutableLiveData<>();

    public LiveData<ImageItem> getImageItem(){
        return imageItem;
    }

    void insertImageItem(ImageItem imageItem){
        repository.insertImage(imageItem);
    }
}
