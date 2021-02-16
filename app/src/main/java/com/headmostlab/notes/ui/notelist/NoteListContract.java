package com.headmostlab.notes.ui.notelist;

import com.headmostlab.notes.model.Note;

import java.util.ArrayList;

public interface NoteListContract {
    interface View {
        void show(Note note);

        void show(ArrayList<Note> notes);
    }

    interface Presenter {
        void takeView(View view);

        void select(Note note);
    }
}
