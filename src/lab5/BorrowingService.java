package lab5;

<<<<<<< HEAD
public class BorrowingService implements BorrowingServiceAPI{

	@Override
	public boolean borrowBook(Member member, Book book) {
		// TODO Auto-generated method stub
		//borrow book using this borrowing service
		if (book != null && book.getIsAvailable() == true) {
			member.addBorrowedBook(book);
			book.setIsAvailable(false);
			return true;
		}
		return false;
	}

	@Override
	public boolean returnBook(Member member, Book book) {
		// TODO Auto-generated method stub
		if (book != null) {
			member.removeBorrowedBook(book);
			book.setIsAvailable(true);
			return true;
		}
		return false;
=======
public enum BorrowingService implements BorrowingServiceAPI{
	
	private static volatile BorrowingService INSTANCE; // private member
	private int borrowingLimit; // to restrict the count of borrowed books
	
	private BorrowingService() { // private constructor
		borrowingLimit = 3;
	}
	
	public static BorrowingService getInstance() {
		if(INSTANCE == null) {
			synchronized(BorrowingService.class) {
				if(INSTANCE == null) {
					INSTANCE = new BorrowingService();
				}
			}
		}
		return INSTANCE;
	}

	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) { 
		

	}
	@Override
	public BorrowingBookResult returnBook(Member member, Book book) { 

>>>>>>> aec7cfec1ef56b1084fffa5282d7cfe19fe48de8
	}

}
