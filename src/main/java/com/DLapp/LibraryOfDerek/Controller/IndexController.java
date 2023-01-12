package com.DLapp.LibraryOfDerek.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/") // no path, homepage!
    public String listHome() {
        return "index";
    }

}
