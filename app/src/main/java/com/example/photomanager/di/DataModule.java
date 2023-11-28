package com.example.photomanager.di;

import android.app.Application;

import com.example.photomanager.data.ImageDao;
import com.example.photomanager.data.ImageDatabase;
import com.example.photomanager.data.ImageRepositoryImpl;
import com.example.photomanager.domain.ImageRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    public ImageDao provideImageDao(Application application){
        return ImageDatabase.getDatabase(application).getImageDao();
    }

    @Provides
    public ImageRepository provideImageRepository(ImageRepositoryImpl impl){
        return impl;
    }
}
