package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingService borrowingService; 
	
	public Member(String name, BorrowingService service) { 
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.borrowingService = service; //dependency injection
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(Book book) {
		if (book != null && book.getIsAvailable() == true) {
			borrowedBooks.add(book);
			book.setIsAvailable(false);
		}
	}
	public void returnBook(Book book) {
		if (book != null) {
			borrowedBooks.remove(book);
			book.setIsAvailable(true);
		}
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
	
	public BorrowingService getBorrowingService() {
		return borrowingService;
	}

	
	
}
