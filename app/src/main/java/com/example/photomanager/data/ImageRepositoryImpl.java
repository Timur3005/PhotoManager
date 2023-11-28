package com.example.photomanager.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.photomanager.di.ApplicationScope;
import com.example.photomanager.domain.ImageItem;
import com.example.photomanager.domain.ImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

@ApplicationScope
public class ImageRepositoryImpl implements ImageRepository {

    private final ImageDao dao;
    private final ImageMapper mapper;

    @Inject
    public ImageRepositoryImpl(ImageDao dao, ImageMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public LiveData<List<ImageItem>> getImages() {
        return Transformations.map(
                dao.getImageItemList(),
                mapper::mapListImageDbModelToListImageItem
        );
    }

    @Override
    public LiveData<ImageItem> getImageItem(int id) {
        return Transformations.map(
                dao.getImageItemById(id),
                mapper::mapImageDbModelToImageItem
        );
    }

    @Override
    public void insertImage(ImageItem imageItem) {
        dao.insert(mapper.mapImageItemToImageItemDbModel(imageItem))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
