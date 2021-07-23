package com.example.mynotes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
   public abstract NotesDao getNotesDao();

    private static NotesDatabase INSTANCE;
//    private static final int NUMBER_OF_THREADS = 4;
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static NotesDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
          //  synchronized (NotesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NotesDatabase.class, "notes_database")
                            .allowMainThreadQueries()
                            .build();
                }
          //  }
        }
        return INSTANCE;
    }

}
