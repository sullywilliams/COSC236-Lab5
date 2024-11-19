package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.PaperBook;
import lab5.Member;
import lab5.AudioBook;
import lab5.Book;
import lab5.EBook;



class TestAddRemoveBooks {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Moby Dick");
	
	Book book4 = new EBook("The Art of War");
	Book book5 = new EBook("The Lord of the Rings");
	Book book6 = new EBook("The Alchemist");
	
	Book book7 = new AudioBook("Frankenstein");
	Book book8 = new AudioBook("The Outsiders");
	Book book9 = new AudioBook("Animal Farm");
	
	Member member = new Member("Grady Booch");
	
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		library.addBook(book4);
		library.addBook(book5);
		library.addBook(book6);
		assertEquals(library.booksCount(), 6, "There should be 6 books in the library");
		
		library.addBook(book7);
		library.addBook(book8);
		library.addBook(book9);
		assertEquals(library.booksCount(), 9, "There should be 9 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 9, "There should be 9 books in the library");
		library.removeBook(book2);
		library.removeBook(book3);
		assertEquals(library.booksCount(), 7, "There should be 7 books left in the library");
		
		library.removeBook(book4);
		library.removeBook(book6);
		assertEquals(library.booksCount(), 5, "There should be 5 books left in the library");
		
		library.removeBook(book7);
		library.removeBook(book8);
		assertEquals(library.booksCount(), 3, "There should be 3 books left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 9, "There should be 9 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 8, "There should be 8 books left in the library");
		library.removeBook("Animal Farm");
		assertEquals(library.booksCount(), 7, "There should be 8 books left in the library");
		library.removeBook("The Alchemist");
		assertEquals(library.booksCount(), 6, "There should be 8 books left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 9, "There should be 9 books in the library");
		
		member.borrowBook(book1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		member.borrowBook(book4);
		assertEquals(member.borrowedBooksCount(), 2, "Should be 2 borrowed book");
		
		member.borrowBook(book6);
		assertEquals(member.borrowedBooksCount(), 3, "Should be 2 borrowed book");
		
		library.removeBook(book1);
		assertEquals(library.booksCount(), 8, "There should be 8 books left in the library");
		
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
}
