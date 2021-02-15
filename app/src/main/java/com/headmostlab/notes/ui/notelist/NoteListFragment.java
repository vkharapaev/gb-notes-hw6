package com.headmostlab.notes.ui.notelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.headmostlab.notes.R;
import com.headmostlab.notes.databinding.FragmentNoteListBinding;
import com.headmostlab.notes.model.Note;
import com.headmostlab.notes.ui.note.NoteFragment;

import java.util.ArrayList;
import java.util.List;

public class NoteListFragment extends Fragment implements NoteListContract.View {

    public static final String NOTES_KEY = "NOTES";
    private FragmentNoteListBinding binding;
    private NoteListContract.Presenter presenter;

    public static NoteListFragment newNoteListFragment(ArrayList<Note> notes) {
        NoteListFragment fragment = new NoteListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NOTES_KEY, notes);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNoteListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        List<Note> notes = getArguments().getParcelableArrayList(NOTES_KEY);
        binding.noteList.setAdapter(new NoteListAdapter(notes));
        presenter = new NoteListPresenter();
        presenter.takeView(this);
    }

    @Override
    public void show(Note note) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, NoteFragment.newNoteFragment(note))
                .addToBackStack(null)
                .commit();
    }

    private class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> {

        private final List<Note> notes;

        public NoteListAdapter(List<Note> notes) {
            this.notes = notes;
        }

        @NonNull
        @Override
        public NoteListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.note_row_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NoteListAdapter.ViewHolder holder, int position) {
            holder.title.setText(notes.get(position).getTitle());
            holder.container.setOnClickListener(v -> presenter.select(notes.get(position)));
        }

        @Override
        public int getItemCount() {
            return notes.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView title;
            private final ViewGroup container;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
                container = itemView.findViewById(R.id.item_container);
            }
        }
    }
}
