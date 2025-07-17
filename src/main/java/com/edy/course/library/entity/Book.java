package com.edy.course.library.entity;

import com.edy.course.library.enums.GenderBook;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity @Table(name = "tb_books")
public class Book implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id @GeneratedValue
    private UUID id;

    @Column(length = 30, nullable = false, unique = true)
    private String isbn;

    @Column(length = 150, nullable = false, unique = true)
    private String title;

    @Column(name = "date_publish", nullable = false)
    private LocalDate datePublish;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private GenderBook gender;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}
