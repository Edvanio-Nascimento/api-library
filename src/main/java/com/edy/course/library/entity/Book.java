package com.edy.course.library.entity;

import com.edy.course.library.enums.GenderBook;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity @Table(name = "tb_books")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "date_register")
    private LocalDateTime dateRegister;

    @LastModifiedDate
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(UUID id, String isbn, String title, LocalDate datePublish, GenderBook gender, BigDecimal price, LocalDateTime dateRegister, LocalDateTime dateUpdate, Author author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.datePublish = datePublish;
        this.gender = gender;
        this.price = price;
        this.dateRegister = dateRegister;
        this.dateUpdate = dateUpdate;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    public GenderBook getGender() {
        return gender;
    }

    public void setGender(GenderBook gender) {
        this.gender = gender;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
}
