package com.example.demo.controllers;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.NotesResponse;
import com.example.demo.dto.SuccessResponse;
import com.example.demo.models.Notes;
import com.example.demo.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public ResponseEntity<NotesResponse> getAllNotes(){
        var notes = notesService.getAllNotes();
        return ResponseEntity.ok(new NotesResponse(notes.size(), notes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotesResponse> getNotesById(@PathVariable("id") Integer id){
        var notes = notesService.getAllNotes();
        return ResponseEntity.ok(new NotesResponse(notes.size(), notes));
    }

    @PostMapping("")
    public ResponseEntity<Notes> createNotes(@RequestBody Notes notes){
        Notes newNotes = notesService.createNotes(notes);
        return new ResponseEntity<Notes>(newNotes,null, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Notes> updateNotes(@PathVariable("id") Integer id, @RequestBody Notes notes){
        Notes updatedNotes = notesService.updateNotes(id,notes);
        return new ResponseEntity<Notes>(updatedNotes,null,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteNotes(@PathVariable("id") int id){
        notesService.deleteNotes(id);
        return ResponseEntity.accepted().body(new SuccessResponse("Notes id "+ id+ " deleted"));
    }

    @ExceptionHandler(NotesService.NotesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){
        return new ResponseEntity<>(
               new ErrorResponse(e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
