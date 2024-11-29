package lab5;

public enum BorrowingService implements BorrowingServiceAPI{

	private static BorrowingService INSTANCE; // private member
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
		// TODO Auto-generated method stub
		//borrow book using this borrowing service
		if (book != null && book.getIsAvailable() == true) {
			member.addBorrowedBook(book);
			book.setIsAvailable(false);
			return new BorrowingBookResult(true, "Book borrowed successfully");
		}
		return new BorrowingBookResult(true, "Coudn't borrow book because its not available");
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		// TODO Auto-generated method stub
		if (book != null) {
			member.removeBorrowedBook(book);
			book.setIsAvailable(true);
			return new BorrowingBookResult(true, "Book returned successfully");
		}
		return new BorrowingBookResult(true, "Coudn't return book because it was somehow null");
}
}