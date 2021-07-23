package com.example.mynotes;

import android.app.Application;
import android.content.pm.LauncherApps;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
   private final LiveData<List<Notes>> allNotes;
    private NotesRepository repository;
    public NotesViewModel(Application application) {
        super(application);
        NotesDao dao= NotesDatabase.getDatabase(application).getNotesDao();
         repository= new NotesRepository(application);
        allNotes=repository.getAllNotes();
    }

    LiveData<List<Notes>> getallNote(){
        return allNotes;
    }
   public void deleteNotes(Notes notes) {
        repository.delete(notes);
    }
     public void insertNotes(Notes notes)
    {
        repository.insert(notes);
    }

    }

