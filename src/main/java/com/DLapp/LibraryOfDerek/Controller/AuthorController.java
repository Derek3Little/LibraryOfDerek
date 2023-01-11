package com.DLapp.LibraryOfDerek.Controller;

import com.DLapp.LibraryOfDerek.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
}
