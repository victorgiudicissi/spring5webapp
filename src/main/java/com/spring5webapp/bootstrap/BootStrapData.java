package com.spring5webapp.bootstrap;

import com.spring5webapp.domain.Author;
import com.spring5webapp.domain.Book;
import com.spring5webapp.domain.Publisher;
import com.spring5webapp.repositories.AuthorRepository;
import com.spring5webapp.repositories.BookRepository;
import com.spring5webapp.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("BootStrap data initialized.");

        Publisher pub1 = new Publisher("AraraPub", "Araraquara", "São Paulo", "123142143");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12312412", pub1);

        eric.getBooks().add(ddd);
        ddd.setAuthor(eric);

        publisherRepository.save(pub1);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123124123214", pub1);

        rod.getBooks().add(ddd);
        noEJB.setAuthor(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        bookRepository.findAll().forEach(book -> {
            log.info("book {}", book.toString());
        });

        authorRepository.findAll().forEach(author -> {
            log.info("author {}", author.toString());
        });

        publisherRepository.findAll().forEach(publisher -> {
            log.info("publisher {}", publisher.toString());
        });

        log.info("BootStrap data was saved. Number of authors: {} publishers: {} books: {}",
                authorRepository.count(),
                publisherRepository.count(),
                bookRepository.count());
    }
}
