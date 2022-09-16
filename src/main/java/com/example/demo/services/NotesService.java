package com.example.demo.services;

import com.example.demo.models.Notes;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {

    List<Notes> getAllNotes();
    Notes getNotesById(int id);
    Notes createNotes(Notes notes);
    Notes updateNotes(int id, Notes notes);
    void deleteNotes(int id);

    public class NotesNotFoundException extends Throwable {
        public NotesNotFoundException(int id) {
            super("Could not find notes " + id);
        }

    }
}
