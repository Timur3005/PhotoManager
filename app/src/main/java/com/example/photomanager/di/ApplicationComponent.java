package com.example.photomanager.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = DataModule.class)
public interface ApplicationComponent {
    @Component.Factory
    interface Factory{
        ApplicationComponent create(@BindsInstance Application application);
    }
}
