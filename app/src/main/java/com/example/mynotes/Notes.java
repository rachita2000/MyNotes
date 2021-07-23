package com.example.mynotes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Notes {

    @PrimaryKey(autoGenerate = true)
     public int id=0;
    @ColumnInfo(name = "text")
    String text;
    public Notes(String text) {
        this.text = text;
    }


}
