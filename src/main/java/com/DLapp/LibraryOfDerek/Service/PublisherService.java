package com.DLapp.LibraryOfDerek.Service;

import com.DLapp.LibraryOfDerek.Entity.Publisher;
import com.DLapp.LibraryOfDerek.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Publisher not found!")); // check if publisher exists first!
        return publisher;
    }

    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        Publisher publisher = findPublisherById(id);
        publisherRepository.deleteById(publisher.getId());
    }
}
