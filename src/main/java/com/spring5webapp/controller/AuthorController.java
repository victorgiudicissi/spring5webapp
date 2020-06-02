package com.spring5webapp.controller;

import com.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "author/list";
    }
}
