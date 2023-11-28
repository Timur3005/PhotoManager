package com.example.photomanager;

import android.app.Application;

import com.example.photomanager.di.ApplicationComponent;
import com.example.photomanager.di.DaggerApplicationComponent;

public class PhotoManagerApp extends Application {

    public ApplicationComponent component = DaggerApplicationComponent.factory().create(this);
}
