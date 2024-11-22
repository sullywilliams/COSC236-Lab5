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
	
	public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }
	
	public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }
	
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	
	public void borrowBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.borrowBook(this, book); 
		if(success)
		{
		// print something
		} else {
		// print something else
		}
		
	}
	public void returnBook(Book book) {
		
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.returnBook(this, book); 
		if(success)
		{
		// print something
		} else {
		// print something else
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
