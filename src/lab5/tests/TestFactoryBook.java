package lab5.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lab5.AudioBookCreator;
import lab5.Book;
import lab5.EBook;
import lab5.AudioBook;
import lab5.PaperBook;
import lab5.EBookCreator;
import lab5.Library;
import lab5.PaperBookCreator;

public class TestFactoryBook {
	
	@Test
	void testUnsorportedBookTypes() {
		Library library = new Library();
		
		EBookCreator ebook = new EBookCreator(library);
		AudioBookCreator audioBook = new AudioBookCreator(library);
		PaperBookCreator paperBook = new PaperBookCreator(library);
				
		assertEquals(audioBook, new AudioBook("Alice")); 
		assertEquals(paperBook, new PaperBook("Moby Dick")); 
	}
	
	@Test
	void testBookType() {
		Library library = new Library();
		
		EBookCreator ebook = new EBookCreator(library);
		Book book1 = ebook.createBook("Dune");
		AudioBookCreator audioBook = new AudioBookCreator(library);
		Book book2 = audioBook.createBook("Alice"); 
		PaperBookCreator paperBook = new PaperBookCreator(library);
		Book book3 = paperBook.createBook("Moby Dick");
				
		assertEquals(book1, new EBook("Dune")); 
		assertEquals(book2, new AudioBook("Alice")); 
		assertEquals(book3, new PaperBook("Moby Dick")); 
		assertFalse(paperBook.equals(new AudioBook("Little Prince"))); 
	}

}
