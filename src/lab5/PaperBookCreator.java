package lab5;

public class PaperBookCreator extends BookFactory{

	public PaperBookCreator(Library library) {
		super(library);
	}

	@Override
	public Book createBook(String title) {
		// TODO Auto-generated method stub
		return new PaperBook(title);
	}

}
