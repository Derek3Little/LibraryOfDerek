package com.DLapp.LibraryOfDerek;

import com.DLapp.LibraryOfDerek.Entity.Author;
import com.DLapp.LibraryOfDerek.Entity.Book;
import com.DLapp.LibraryOfDerek.Entity.Category;
import com.DLapp.LibraryOfDerek.Entity.Publisher;
import com.DLapp.LibraryOfDerek.Service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryOfDerekApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryOfDerekApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return(args) -> {

			// adding initial books for testing

			Book book1 = new Book("9780674040755", "The Ants", "Myrmecology Textbook");
			Author author1 = new Author("Edward O. Wilson", "World's foremost myrmecologist!");
			Category category1 = new Category("Biology");
			Publisher publisher1 = new Publisher("Belknap Press: An Imprint of Harvard University Press; " +
					"1st edition (March 28, 1990)");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("1015494072",
					"The Genealogical History of the Gallup Family in the United States",
					"Maternal Genealogy");
			Author author2 = new Author("John Douglass Gallup", "A not so distant cousin!");
			Category category2 = new Category("Maternal Genealogy");
			Publisher publisher2 = new Publisher("Legare Street Press (October 26, 2022)");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("1611212626",
					"Fighting for General Lee: Confederate General Rufus Barringer and the North Carolina Cavalry Brigade",
					"Paternal Genealogy, signed by author!");
			Author author3 = new Author("Sheridan Barringer", "A distant cousin!");
			Category category3 = new Category("Paternal Genealogy");
			Publisher publisher3 = new Publisher("Savas Beatie (March 10, 2016)");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

		};
	}
}
