package com.example.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.NotesViewHolder> {

  class  NotesViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView button;
      public NotesViewHolder(@NonNull View itemView) {
          super(itemView);
          textView= itemView.findViewById(R.id.textview);
          button= itemView.findViewById(R.id.deleteButton);
      }
  }

  ArrayList<Notes> allNotes=new ArrayList<>();
  private final Context context;
  INotesAdapter listener;
  public NotesRVAdapter(Context context, INotesAdapter listener)
  {
      this.context=context;
      this.listener=listener;
  }

    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
     View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes,parent,false);
     NotesViewHolder viewHolder=new NotesViewHolder(view);
     viewHolder.button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
                listener.onItemClicked(allNotes.get(viewHolder.getAdapterPosition()));
         }
     });
     return viewHolder;

    }

    @Override
    public void onBindViewHolder( NotesViewHolder holder, int position) {
        Notes currentNotes=allNotes.get(position);
        holder.textView.setText(currentNotes.text);
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    void updateList(ArrayList<Notes> newList)
    {
        allNotes.clear();
        allNotes.addAll(newList);
        notifyDataSetChanged();
    }
}

interface INotesAdapter {
    void onItemClicked(Notes notes);
}