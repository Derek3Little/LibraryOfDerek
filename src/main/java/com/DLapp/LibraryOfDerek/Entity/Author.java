package com.DLapp.LibraryOfDerek.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId; // long type to accommodate Derek's gigantic library

    @Column(name = "name", nullable = false, unique = true)
    private String authorName;

    @Column(name = "description", nullable = false)
    private String authorDescription;

    // book can have multiple authors, author can have multiple books
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

}
