package com.DLapp.LibraryOfDerek.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(name = "name", nullable = false, unique = true)
    private String publisherName;

}
