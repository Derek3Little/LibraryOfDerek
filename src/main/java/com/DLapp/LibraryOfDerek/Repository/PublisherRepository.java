package com.DLapp.LibraryOfDerek.Repository;

import com.DLapp.LibraryOfDerek.Entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> { // identifying publisher by Long publisherId

}
