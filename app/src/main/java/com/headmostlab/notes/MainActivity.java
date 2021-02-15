package com.headmostlab.notes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.headmostlab.notes.model.Note;
import com.headmostlab.notes.ui.notelist.NoteListFragment;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, NoteListFragment.newNoteListFragment(createNotes()))
                .commit();
    }

    private ArrayList<Note> createNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note.Builder().setTitle("Note 1")
                .setDescription("Note 1 Description").setCreateDate(new Date()).build());
        notes.add(new Note.Builder().setTitle("Note 2")
                .setDescription("Note 2 Description").setCreateDate(new Date()).build());
        notes.add(new Note.Builder().setTitle("Note 3")
                .setDescription("Note 3 Description").setCreateDate(new Date()).build());
        return notes;
    }
}
