package com.example.photomanager.di;

import android.app.Application;

import com.example.photomanager.presentation.imageitem.ImageItemFragment;
import com.example.photomanager.presentation.imageslist.ImagesListFragment;

import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {DataModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    void inject(ImageItemFragment fragment);
    void inject(ImagesListFragment fragment);

    @Component.Factory
    interface Factory{
        ApplicationComponent create(@BindsInstance Application application);
    }
}
