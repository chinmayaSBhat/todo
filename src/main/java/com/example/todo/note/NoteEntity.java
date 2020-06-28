package com.example.todo.note;

import com.example.todo.user.UserEntity;

import javax.persistence.*;

@Entity(name="Note")
public class NoteEntity {
    @Id
    @GeneratedValue
    private int id;
    private String note;
    private String color;
    @ManyToOne
    @JoinColumn
    private UserEntity user;

    public NoteEntity() {
    }
    public NoteEntity(String note, String color, UserEntity user) {
        this.note = note;
        this.color = color;
        this.user = user;
    }
    public NoteEntity(Integer id, String note, String color, UserEntity user) {
        this.id = id;
        this.note = note;
        this.color = color;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
