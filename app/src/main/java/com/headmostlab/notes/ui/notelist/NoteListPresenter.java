package com.headmostlab.notes.ui.notelist;

import java.lang.ref.WeakReference;

public class NoteListPresenter implements NoteListContract.Presenter {

    private WeakReference<NoteListContract.View> view;

    @Override
    public void takeView(NoteListContract.View view) {
        this.view = new WeakReference<>(view);
    }
}
