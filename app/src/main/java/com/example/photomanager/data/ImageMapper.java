package com.example.photomanager.data;

import com.example.photomanager.di.ApplicationScope;
import com.example.photomanager.domain.ImageItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@ApplicationScope
public class ImageMapper {

    @Inject
    public ImageMapper() {}

    public ImageItem mapImageDbModelToImageItem(ImageItemDbModel imageItemDbModel){
        return new ImageItem(
                imageItemDbModel.id,
                imageItemDbModel.name,
                imageItemDbModel.description,
                imageItemDbModel.photoPath
        );
    }

    public List<ImageItem> mapListImageDbModelToListImageItem(List<ImageItemDbModel> imagesItemDbModel){
        ArrayList<ImageItem> newList = new ArrayList<>();
        for (int i =0; i<imagesItemDbModel.size();i++){
            newList.add(mapImageDbModelToImageItem(imagesItemDbModel.get(i)));
        }
        return newList;
    }

    public ImageItemDbModel mapImageItemToImageItemDbModel(ImageItem imageItem){
        return new ImageItemDbModel(
                imageItem.id,
                imageItem.name,
                imageItem.description,
                imageItem.photoPath
        );
    }
}
