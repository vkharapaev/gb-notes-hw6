package com.headmostlab.notes.ui.notelist;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.headmostlab.notes.model.Note;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;

public class NoteListPresenter extends ViewModel implements NoteListContract.Presenter {

    public static final String NOTE_KEY = "NOTE";
    private WeakReference<NoteListContract.View> view;
    private final SavedStateHandle dataStorage;
    private Note note;

    public NoteListPresenter(SavedStateHandle savedState) {
        dataStorage = savedState;
        note = savedState.get(NOTE_KEY);
    }

    @Override
    public void takeView(NoteListContract.View view) {
        this.view = new WeakReference<>(view);
        loadNotes();
        show();
    }

    private void show() {
        if (view() != null && note != null) {
            view().show(note);
        }
    }

    @Override
    public void select(Note note) {
        setNote(note);
        show();
    }

    private void setNote(Note note) {
        this.note = note;
        dataStorage.set(NOTE_KEY, note);
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
