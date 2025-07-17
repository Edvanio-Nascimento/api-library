package com.edy.course.library.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "tb_authors")
public class Author implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(length = 70, nullable = false, unique = true)
    private String name;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(length = 50, nullable = false)
    private String nacionality;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;
}
