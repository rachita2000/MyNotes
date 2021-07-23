package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements INotesAdapter {
    private NotesViewModel viewModel;
    RecyclerView mRecycleView;
    NotesRVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

         adapter = new NotesRVAdapter(this, this);
        mRecycleView.setAdapter(adapter);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(NotesViewModel.class);
        viewModel.getallNote().observe(this, Observer -> {
            adapter.updateList((ArrayList<Notes>) Observer);
        });


    }

    @Override
    public void onItemClicked(Notes notes) {
        viewModel.deleteNotes(notes);
        Toast.makeText(this,"Note is deleted" , Toast.LENGTH_LONG).show();
    }

    public void addNote(View view) {
        EditText editText = findViewById(R.id.input);
        String text = editText.getText().toString();
        double value = 0;
        if (!text.isEmpty()) {
            viewModel.insertNotes(new Notes(text));
            Toast.makeText(this,"New note created" ,Toast.LENGTH_LONG).show();;
        }
    }
}