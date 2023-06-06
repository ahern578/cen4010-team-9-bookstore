package com.Group9.Shoppingcart.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany
    private List<Book> userBooks;
    public User() {
    }

    public User( String username, String password) {
        this.username = username;
        this.password = password;
        userBooks = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public Long getId(Long id) {

        return id;
    }

    public void setId(Long id) {
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

    public List<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> books) {
        this.userBooks = books;
    }

    @Override
    public String toString() {
        return "User-"+id+" username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", books=" + userBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
