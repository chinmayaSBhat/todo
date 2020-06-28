package com.example.todo.note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface NoteQueries extends Repository<NoteEntity, Integer> {
    @Query("SELECT u FROM Note u where u.user.id = :#{#userId} order by u.id desc")
    List<NoteEntity> NotesFromUserId(Integer userId);
}
