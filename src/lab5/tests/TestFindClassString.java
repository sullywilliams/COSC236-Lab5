package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.PaperBook;
import lab5.Library;
import lab5.Member;
import lab5.Book;
import lab5.BorrowingService;

class TestFindClassString {

	
private Library library;
private BorrowingService borrowingService; 
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
		 this.borrowingService = BorrowingService.getInstance();
	}
	
	Member member1 = new Member("Dude", borrowingService);
	Member member2 = new Member("Gal", borrowingService);
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");

	@Test
	void FindMember() {
		library.addMember(member1);
		library.addMember(member2);
		Member member = library.findMemberByName(member1.getName());
		assertEquals(member, member1, "Found member doesn't match");
		assertEquals(library.membersCount(), 2, "There should be two members");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "There should be only one member remain");
		member = library.findMemberByName(member2.getName());
		assertNull(member, "The mmber should not hav ben found after removal from the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(),  1, "Removal of a non-existent member should not affect library");
		library.removeMember(member1);
		assertEquals(library.membersCount(), 0, "All members should have been removed");
	}

	@Test
	void FindBook() {
		library.addBook(book1);
		library.addBook(book2);
		Book book = library.findBookByTitle(book1.getTitle());
		assert(book == book1);
		assert(library.booksCount() == 2);
		library.removeBook(book2);
		assert(library.booksCount() == 1);
		book = library.findBookByTitle(book2.getTitle());
		assert(book == null);
		library.removeBook(book2);
		assert(library.booksCount() == 1);
		library.removeBook(book1);
		assert(library.booksCount() == 0);
	}
}
