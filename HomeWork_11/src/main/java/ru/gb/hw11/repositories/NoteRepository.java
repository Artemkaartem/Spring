package ru.gb.hw11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hw11.models.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}