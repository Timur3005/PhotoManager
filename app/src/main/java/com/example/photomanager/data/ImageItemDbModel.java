package com.example.photomanager.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_table")
public class ImageItemDbModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;
    public String photoPath;

    public ImageItemDbModel(int id, String name, String description, String photoPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
    }
}
