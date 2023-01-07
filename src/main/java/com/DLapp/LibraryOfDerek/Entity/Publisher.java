package com.DLapp.LibraryOfDerek.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(name = "name", nullable = false, unique = true)
    private String publisherName;

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();

    // constructor for name
    public Publisher(String name) {
        this.publisherName = name;
    }

}
