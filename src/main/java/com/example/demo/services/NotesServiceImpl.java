package com.example.demo.services;

import com.example.demo.models.Notes;
import com.example.demo.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Notes> getAllNotes() {
        List<Notes> list = new ArrayList<>();
        notesRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Notes getNotesById(int id) {
        return notesRepository.findById(id).get();
    }

    @Override
    public Notes createNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    @Override
    public Notes updateNotes(int id, Notes notes) {
        Notes updatedNotes = notesRepository.findById(id).get();
        updatedNotes.setText(notes.getText());
        updatedNotes.setId(notes.getId());
        return notesRepository.save(updatedNotes);
    }

    @Override
    public void deleteNotes(int id) {
        notesRepository.deleteById(id);
    }
}
