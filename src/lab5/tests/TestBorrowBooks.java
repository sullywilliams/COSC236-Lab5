package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;
import lab5.PaperBook;
import lab5.AudioBook;
import lab5.Book;
import lab5.EBook;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	
	Book book3 = new EBook("The Art of War");
	Book book4 = new AudioBook("The Lord of the Rings");

	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(),"Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(book2.getIsAvailable(),"Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
		
		assertTrue(book3.getIsAvailable(),"Book must be available");
		member1.borrowBook(book3);
		assertTrue(!book3.getIsAvailable(),"Book must be available");
		
		assertTrue(book4.getIsAvailable(),"Book must be available");
		member1.borrowBook(book4);
		assertTrue(!book4.getIsAvailable(),"Book must be available");
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertTrue(book3.getIsAvailable(), "Book 1 should be available");
		assertTrue(book4.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		member1.borrowBook(book3);
		member1.borrowBook(book4);
		assertEquals(member1.borrowedBooksCount(),4, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");
		assertFalse(book3.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book4.getIsAvailable(), "Book 2 should not be available");
		
		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 3, "Count of books must be 3");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 2, "Member 1 should have 2 books");
		
		member1.returnBook(book3);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Member 1 should have 1 book");
		
		member1.returnBook(book4);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
	}

}
