package lab5;

public class EBookCreator extends BookFactory{
	
	public EBookCreator(Library library) {
		super(library);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book createBook(String title) {
		// TODO Auto-generated method stub
		return new EBook(title);
	}
	
	
}
