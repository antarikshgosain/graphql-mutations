package com.graphql.anta.mutations.controller;

import com.graphql.anta.mutations.model.Book;
import com.graphql.anta.mutations.model.BookInput;
import com.graphql.anta.mutations.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer pages, @Argument String author) {
        Book book = new Book(title, author, pages);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        return bookRepository.save(new Book(book.title(), book.author(), book.pages()));
    }

    @MutationMapping
    public List<Book> batchCreate(@Argument List<BookInput> books) {
        return bookRepository.saveAll(books.stream().map(book -> {
            return new Book(book.title(), book.author(), book.pages());
        }
        ).collect(Collectors.toList()));
    }
}
