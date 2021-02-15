package com.headmostlab.notes.ui.notelist;

import com.headmostlab.notes.model.Note;

public interface NoteListContract {
    interface View {
        void show(Note note);
    }

    interface Presenter {
        void takeView(View view);

        void select(Note note);
    }
}
