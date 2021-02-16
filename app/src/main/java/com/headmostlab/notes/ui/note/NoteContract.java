package com.headmostlab.notes.ui.note;

import com.headmostlab.notes.model.Note;

public interface NoteContract {
    interface View {
        void show(Note note);
    }

    interface Presenter {
        void takeView(View view);

        void setNote(Note note);
    }
}
