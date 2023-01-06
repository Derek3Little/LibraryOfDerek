package com.DLapp.LibraryOfDerek.Repository;

import com.DLapp.LibraryOfDerek.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { // repository of Books, identified by Long bookId

}
