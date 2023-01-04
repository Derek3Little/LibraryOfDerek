package com.DLapp.LibraryOfDerek.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    // book can have multiple authors, author can have multiple books
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors", // name of table storing relationship between author and book
            joinColumns = {@JoinColumn(name = "book_id")}, // join = foreign key of book, local!
            inverseJoinColumns = {@JoinColumn(name = "author_id")}) // inverseJoin = foreign key of author, mapped!
    private Set<Author> authors = new HashSet<Author>();

    // book can have multiple categories, category can have multiple books
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_categories", // name of table storing relationship between category and book
            joinColumns = {@JoinColumn(name = "book_id")}, // foreign key of book, defined here in Book class
            inverseJoinColumns = {@JoinColumn(name = "category_id")}) // foreign key for category, defined in Category class
    private Set<Category> categories = new HashSet<Category>();

    // book can have multiple publishers, publisher can have multiple books
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_publishers", // name of table
            joinColumns = {@JoinColumn(name = "book_id")}, // foreign key: book
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")}) // foreign key: publisher
    private Set<Publisher> publishers = new HashSet<Publisher>();

}
