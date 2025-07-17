package com.edy.course.library.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "tb_authors")
@EntityListeners(AuditingEntityListener.class)
public class Author implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id @GeneratedValue
    private UUID id;

    @Column(length = 70, nullable = false, unique = true)
    private String name;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(length = 50, nullable = false)
    private String nacionality;

    @CreatedDate
    @Column(name = "date_register")
    private LocalDateTime dateRegister;

    @LastModifiedDate
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

    public Author() {
    }

    public Author(UUID id, String name, LocalDate dateBirth, String nacionality, LocalDateTime dateRegister, LocalDateTime dateUpdate, List<Book> books) {
        this.id = id;
        this.name = name;
        this.dateBirth = dateBirth;
        this.nacionality = nacionality;
        this.dateRegister = dateRegister;
        this.dateUpdate = dateUpdate;
        this.books = books;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
