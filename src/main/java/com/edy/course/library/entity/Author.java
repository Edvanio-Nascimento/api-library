package com.edy.course.library.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "tb_authors")
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

//    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
//    private List<Book> books;
}
