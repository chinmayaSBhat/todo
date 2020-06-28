package com.example.todo.todo;

import com.example.todo.user.UserEntity;
import com.example.todo.user.UserRepository;
import com.example.todo.note.NoteQueries;
import com.example.todo.note.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;


@Controller
public class TodoContoller {

    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public String PassingNotesListGet(Model model, Principal principal){
        todoService.sendListOfTodosToHtmlTemplate(model, principal);
        return "todoList";
    }
    @PostMapping("/todo")
    public String PassingNotesListPost(Model model, Principal principal){
        todoService.sendListOfTodosToHtmlTemplate(model, principal);
        return "todoList";
    }
}
