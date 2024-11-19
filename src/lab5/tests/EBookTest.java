package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.EBook;

class EBookTest {

	@Test
	void EBookTest() {
		Book book = new EBook("Title");
		assertEquals(book.getIsAvailable(), true);
		assertEquals(book.getClass().getName(), "lab5.EBook");
		assertTrue(book instanceof lab5.Book);
		assertEquals(book.getTitle(), "Title");
	}

}
