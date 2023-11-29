package com.example.photomanager.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ImageItemDbModel.class, version = 1, exportSchema = false)
abstract public class ImageDatabase extends RoomDatabase {
    public abstract ImageDao getImageDao();

    private static volatile ImageDatabase INSTANCE;

    public static ImageDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ImageDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                                    ImageDatabase.class, "app_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
