package com.springframework.spring5webapp.bootstrap;

import com.springframework.spring5webapp.model.Author;
import com.springframework.spring5webapp.model.Book;
import com.springframework.spring5webapp.model.Publisher;
import com.springframework.spring5webapp.repository.AuthorRepository;
import com.springframework.spring5webapp.repository.BookRepository;
import com.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData(){

        Publisher indiaPublisher = new Publisher("Publisher 1", "india");
        publisherRepository.save(indiaPublisher);

        Publisher noidaPublisher = new Publisher("Publisher 2", "Noida");
        publisherRepository.save(noidaPublisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Java1", "1234", indiaPublisher);
        eric.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);

        //Pranjal
        Author pranjal = new Author("Pranjal", "Kumar");

        Book book2 = new Book("Java2", "12344" , noidaPublisher);
        pranjal.getBooks().add(book2);

        authorRepository.save(pranjal);
        bookRepository.save(book2);
    }
}
