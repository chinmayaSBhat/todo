package com.example.todo.user;

import javax.persistence.*;

@Entity(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue
    public int id;
    @Column(nullable = false, unique = true)
    public String username;
    public String password;

    public UserEntity() { }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
