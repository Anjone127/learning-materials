package getreturn;

import model.Book;

public class GetReturnDemo {
	public static void main(String[] args) throws InterruptedException {
		Book book = new Book();
		BookTitleTread bookTitleTread = new BookTitleTread(book);
		bookTitleTread.start();
		bookTitleTread.join();
		System.out.println(book.getTitle());
		int i = 0;
		while(true){
			i++;
		}
	}
}
