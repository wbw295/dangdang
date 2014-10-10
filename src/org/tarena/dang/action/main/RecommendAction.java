package org.tarena.dang.action.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.tarena.dang.action.BaseAction;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Book;
import org.tarena.dang.util.Factory;

public class RecommendAction extends BaseAction {
	//output
	private List<Book> books=new ArrayList<Book>();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ProductDAO dao=(ProductDAO) Factory.getInstance("ProductDAO");
		List<Book> list=dao.findAllBooks();
		int size=list.size();
		Random random=new Random();
		int randomNumOne=random.nextInt(size);
		int randomNumTwo=random.nextInt(size);
		books.add(list.get(randomNumOne));
		books.add(list.get(randomNumTwo));
		return super.execute();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
