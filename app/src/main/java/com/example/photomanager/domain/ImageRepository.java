package com.example.photomanager.domain;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface ImageRepository {

    LiveData<List<ImageItem>> getImages();
    LiveData<ImageItem> getImageItem();
}