package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.AudioBook;

class AudioBookTest {

	@Test
	void test() {
		Book book = new AudioBook("Title");
		assertEquals(book.getIsAvailable(), true);
		assertEquals(book.getClass().getName(), "lab5.AudioBook");
		assertTrue(book instanceof lab5.Book);
		assertEquals(book.getTitle(), "Title");
	}

}
