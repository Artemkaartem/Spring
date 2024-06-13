package ru.gb.hw11.controllers;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.hw11.models.Note;
import ru.gb.hw11.services.NoteService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class NoteController {

    private final Counter requestCounter = Metrics.counter("request_count");


    private final NoteService service;

    @GetMapping()
    public ResponseEntity<List<Note>> allNotes(){
        requestCounter.increment();
        return ResponseEntity.ok().body(service.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getNoteById(id));
    }

    @PostMapping()
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok().body(service.createNote(note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id,
                                           @RequestBody Note note){
        return ResponseEntity.ok().body(service.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.removeNote(id);
        return ResponseEntity.ok().body(null);
    }
}