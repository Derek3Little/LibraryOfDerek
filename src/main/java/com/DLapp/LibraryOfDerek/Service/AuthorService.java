package com.DLapp.LibraryOfDerek.Service;

import com.DLapp.LibraryOfDerek.Entity.Author;
import com.DLapp.LibraryOfDerek.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService {

    @Autowired // Spring autowire for repository data access
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        // remember when finding by id, account for possibility that the id does not exist! throw the runtime error!
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found!"));

        return author;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author = findAuthorById(id); // first must successfully find the author to be deleted
        authorRepository.deleteById(author.getAuthorId()); // getAuthorId provided by lombok NICE!
    }
}
