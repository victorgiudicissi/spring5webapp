package com.spring5webapp.controller;

import com.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String findBook(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
