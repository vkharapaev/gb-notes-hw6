package com.headmostlab.notes.ui.notelist;

import com.headmostlab.notes.model.Note;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

public class NoteListPresenter implements NoteListContract.Presenter {

    private WeakReference<NoteListContract.View> view;

    @Override
    public void takeView(NoteListContract.View view) {
        this.view = new WeakReference<>(view);
        loadNotes();
    }

    @Override
    public void select(Note note) {
        if (view() != null) {
            view().show(note);
        }
    }

    public void loadNotes() {
        ArrayList<Note> notes = createNotes();
        if (view() != null) {
            view().show(notes);
        }
    }

    private ArrayList<Note> createNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("Note 1", "Note 1 Description", new Date()));
        notes.add(new Note("Note 2", "Note 2 Description", new Date()));
        notes.add(new Note("Note 3", "Note 3 Description", new Date()));
        return notes;
    }

    NoteListContract.View view() {
        if (view != null) {
            return view.get();
        }
        return null;
    }
}
