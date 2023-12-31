package com.example.photomanager.domain;

import androidx.annotation.Nullable;


public class ImageItem {
    public int id = UNDEFINED_ID;
    public String name;
    public String description;
    public String photoPath;

    public ImageItem(int id, String name, String description, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }

    public ImageItem(String name, String description, String photoPath) {
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return this == obj;
    }

    public static final int UNDEFINED_ID = 0;
}
