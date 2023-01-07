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
	public CommandLineRunner initialCreate(BookService bookService) { // adding initial books for testing
		return(args) -> {

			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My second book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC21", "Book name", "My third book");
			Author author3 = new Author("Test name3", "Test description");
			Category category3 = new Category("Fiction books");
			Publisher publisher3 = new Publisher("Third Publisher");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

			/* more detailed sample books

			Book book1 = new Book("9780674040755",
					"The Ants (First Edition)",
					"The distillation of a lifetime of research by the world’s leading myrmecologists.");
			Author author1 = new Author("Edward O. Wilson",
					 "The world's leading expert in his specialty of myrmecology");
			Author author2 = new Author("Bert Holldobler",
					"Sociobiologist and evolutionary biologist who studies evolution and social organization in ants.");
			Category category1 = new Category("Biology");
			Publisher publisher1 = new Publisher("Belknap Press: An Imprint of Harvard University Press; " +
					"1st edition (March 28, 1990)");
			book1.addAuthor(author1);
			book1.addAuthor(author2);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("1015494072",
					"The Genealogical History of the Gallup Family in the United States",
					"A detailed survey of the Gallup Family Tree starting from 1630.");
			Author author3 = new Author("John Douglass Gallup",
					"A somewhat distant relative of none other than Derek himself!");
			Category category2 = new Category("Genealogy");
			Publisher publisher2 = new Publisher("Legare Street Press (October 26, 2022)");
			book2.addAuthor(author3);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("1611212626",
					"Fighting for General Lee: Confederate General Rufus Barringer and the " +
							"North Carolina Cavalry Brigade",
					"A Biography of Rufus Barringer, Confederate General");
			Author author4 = new Author("Sheridan R. Barringer",
					"Another somewhat distant relative of none other than Derek himself!");
			Publisher publisher3 = new Publisher("Savas Beatie (March 10, 2016)");
			book3.addAuthor(author3);
			book3.addCategory(category2);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

			 */
		};
	}
}
