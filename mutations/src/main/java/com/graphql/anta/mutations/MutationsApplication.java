package com.graphql.anta.mutations;

import com.graphql.anta.mutations.model.Book;
import com.graphql.anta.mutations.model.Review;
import com.graphql.anta.mutations.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MutationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutationsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (BookRepository bookRepository) {
		return args -> {
			Book book1 = new Book("Reactive Spring", "Josh", 484);
			Review review1 = new Review("Great book", "Really great read. was able to finish in 5 days");
			book1.setReviews(List.of(review1));
			bookRepository.save(book1);
		};
	}

}
