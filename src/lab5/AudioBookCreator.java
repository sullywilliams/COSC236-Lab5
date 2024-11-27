package lab5;

public class AudioBookCreator extends BookFactory{

	public AudioBookCreator(Library library) {
		super(library);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book createBook(String title) {
		return new AudioBook(title);
	}
	

}
