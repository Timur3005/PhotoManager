package com.example.photomanager.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(ImageItemDbModel item);

    @Query("SELECT * FROM image_table")
    LiveData<List<ImageItemDbModel>> getImageItemList();

    @Query("SELECT * FROM image_table WHERE id == :id LIMIT 1")
    LiveData<ImageItemDbModel> getImageItemById(int id);
}
