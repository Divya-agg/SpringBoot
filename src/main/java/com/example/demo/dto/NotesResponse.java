package com.example.demo.dto;


import com.example.demo.models.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NotesResponse {
        private int notesCount;
        private List<Notes> notes;
}

