package com.headmostlab.notes.ui.notelist;

public interface NoteListContract {
    interface View {
    }

    interface Presenter {
        void takeView(View view);
    }
}
