package lab5;


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
		}
	}
