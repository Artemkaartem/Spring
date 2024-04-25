package ru.gb.Hw6.service;

import ru.gb.Hw6.model.Note;
import ru.gb.Hw6.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());
        noteById.setDescription(note.getDescription());
        noteById.setTitle(note.getTitle());
        noteById.setLocal_date_time(LocalDateTime.now());
        return noteRepository.save(noteById);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNoteStatus(Long id, Note.Status status) {
        Optional<Note> optionalTask = noteRepository.findById(id);
        if (optionalTask.isPresent()) {
            Note task = optionalTask.get();
            task.setStatus(status);
            return noteRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public List<Note> getNoteByStatus(Note.Status status) {
        return noteRepository.getNoteByStatus(status);
    }
}