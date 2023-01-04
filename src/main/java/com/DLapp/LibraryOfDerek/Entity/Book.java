package com.DLapp.LibraryOfDerek.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String bookIsbn;

    @Column(name = "title", nullable = false)
    private String bookTitle;

    @Column(name = "description", nullable = false, unique = true)
    private String bookDescription;

}
