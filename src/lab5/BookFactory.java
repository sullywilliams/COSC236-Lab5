package lab5;

abstract class BookFactory {
	
	protected abstract Book createBook(String title);
	
	private Library library;
	
	public BookFactory(Library library) {
		this.library = library; 
	}
	
	public void supplyBookToLibrary(String title) {
		Book book = createBook(title); 
		book.toString();
		library.addBook(book);
	}

}
