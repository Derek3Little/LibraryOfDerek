package com.DLapp.LibraryOfDerek.Repository;

import com.DLapp.LibraryOfDerek.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> { // repository of Authors, identified by Long authorId

}
