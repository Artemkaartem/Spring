package ru.gb.Hw6.repository;

import ru.gb.Hw6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> getNoteByStatus(Note.Status status);
}