package ru.gb.hw11.services;

import ru.gb.hw11.models.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note createNote(Note note);

    Note updateNote(Long id, Note note);

    void removeNote(Long id);
}
