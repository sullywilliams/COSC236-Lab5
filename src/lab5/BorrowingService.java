package lab5;

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

	}

}
