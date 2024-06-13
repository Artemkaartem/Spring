package ru.gb.hw11.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.hw11.models.Note;
import ru.gb.hw11.models.exceptions.ResourceNotFoundException;
import ru.gb.hw11.repositories.NoteRepository;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService{

    private final NoteRepository repository;

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(Long id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Note " + id + " not found!"));
    }

    @Override
    public Note createNote(Note note) {
        note.setCreateDate(LocalDateTime.now());
        return repository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note note) throws ResourceNotFoundException{
        Note noteForUpdate = getNoteById(id);
        noteForUpdate.setTitle(note.getTitle());
        noteForUpdate.setDescription(note.getDescription());
        return repository.save(noteForUpdate);
    }

    @Override
    public void removeNote(Long id) throws ResourceNotFoundException{
        // Проверка на существование, для генерации исключения.
        getNoteById(id);
        repository.deleteById(id);
    }
}
