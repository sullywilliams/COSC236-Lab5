package lab5.tests;

import org.junit.Test;

import lab5.Book;
import lab5.EBook;
import lab5.EBookCreator;
import lab5.Library;
import lab5.AudioBookCreator;

class EBookTest {

	@Test
	void differentBooksTypes() {
		Library library = new Library();
		
		EBookCreator ebook = new EBookCreator(library);
		AudioBookCreator audioBook = new AudioBookCreator(library);
		
		assertEquals(ebook, audioBook, false); 
		
		
		
	}

}
