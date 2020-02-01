package getreturn;

import model.Book;

public class BookTitleTread extends Thread{

	private Book book;

	BookTitleTread(Book book){
		this.book = book;
	}

	@Override
	public void run() {
		book.setTitle("A GOOD BOOK");
		System.out.println("set tiele finish");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
