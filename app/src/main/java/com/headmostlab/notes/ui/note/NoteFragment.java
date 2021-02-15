package com.headmostlab.notes.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.headmostlab.notes.databinding.FragmentNoteBinding;
import com.headmostlab.notes.model.Note;

public class NoteFragment extends Fragment {

    public static final String NOTE_KEY = "NOTE";
    private FragmentNoteBinding binding;

    public static NoteFragment newNoteFragment(Note note) {
        NoteFragment fragment = new NoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(NOTE_KEY, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Note note = getArguments().getParcelable(NOTE_KEY);
        binding.title.setText(note.getTitle());
        binding.description.setText(note.getDescription());
        binding.createDate.setText(String.format("%s", note.getCreationDate()));

    }
}
