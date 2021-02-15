package com.headmostlab.notes.ui.notelist;

import com.headmostlab.notes.model.Note;

import java.lang.ref.WeakReference;

public class NoteListPresenter implements NoteListContract.Presenter {

    private WeakReference<NoteListContract.View> view;

    @Override
    public void takeView(NoteListContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void select(Note note) {
        if (view() != null) {
            view().show(note);
        }
    }

    NoteListContract.View view() {
        if (view != null) {
            return view.get();
        }
        return null;
    }
}
