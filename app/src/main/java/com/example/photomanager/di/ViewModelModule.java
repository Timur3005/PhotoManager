package com.example.photomanager.di;

import androidx.lifecycle.ViewModel;

import com.example.photomanager.presentation.imageitem.ImageItemViewModel;
import com.example.photomanager.presentation.imageslist.ImagesListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(ImageItemViewModel.class)
    ViewModel bindImageItemViewModel(ImageItemViewModel impl);

    @IntoMap
    @Binds
    @ViewModelKey(ImagesListViewModel.class)
    ViewModel bindImagsListViewModel(ImagesListViewModel impl);
}
