package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

}
