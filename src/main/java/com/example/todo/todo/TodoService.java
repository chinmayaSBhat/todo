package com.example.todo.todo;

import com.example.todo.note.NoteEntity;
import com.example.todo.note.NoteQueries;
import com.example.todo.note.NoteRepository;
import com.example.todo.user.UserEntity;
import com.example.todo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Service
public class TodoService {

    private UserRepository userRepository;
    private NoteQueries noteQueries;
    private NoteRepository noteRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setNoteQueries(NoteQueries noteQueries){
        this.noteQueries = noteQueries;
    }

    @Autowired
    public void setnoteRepository(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }


    public void sendListOfTodosToHtmlTemplate(Model model, Principal principal){
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<NoteEntity> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        // TODO: 02.01.2020 Name the model attributes ("name" name) 
    }

    public void deleteNoteById(Integer id){
        noteRepository.deleteById(id);
    }

    public void findNoteByIdAndPassItsAttributesToHtmlTemplate(Integer id, Model model){
        NoteEntity noteEdit = noteRepository.findById(id).get();
        model.addAttribute("NoteEdit", noteEdit);
    }

    public void saveNote(String msg, String color, Principal principal){
        NoteEntity note = new NoteEntity(msg,
                            color,
                            userRepository.findByUsername(principal.getName()));

        noteRepository.save(note);
    }
}
