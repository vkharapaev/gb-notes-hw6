package com.headmostlab.notes.ui.note;

import com.headmostlab.notes.model.Note;

import java.lang.ref.WeakReference;

public class NotePresenter implements NoteContract.Presenter {

    private WeakReference<NoteContract.View> view;
    private Note note;

    @Override
    public void takeView(NoteContract.View view, Note note) {
        this.view = new WeakReference<>(view);
        setNote(note);
    }

    private void setNote(Note note) {
        this.note = note;
        if (note != null && view() != null) {
            view().show(note);
        }
    }

    NoteContract.View view() {
        if (view != null) {
            return view.get();
        }
        return null;
    }
}
