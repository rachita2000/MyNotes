package com.example.mynotes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {
   private  NotesDao notesDao;
  private LiveData<List<Notes>> allNotes ;
//    public NotesRepository(NotesDao notesDao)
//    {
//        this.notesDao=notesDao;
//    }
    NotesRepository(Application application) {
        NotesDatabase db = NotesDatabase.getDatabase(application);
         notesDao = db.getNotesDao();
         allNotes =notesDao.getAllNotes();
}
    public LiveData<List<Notes>> getAllNotes()
    {
        return allNotes;
    }
    void insert(Notes notes)
    {
        notesDao.insert(notes);
    }
   public  void delete(Notes notes)
    {
        notesDao.delete(notes);
    }


}
