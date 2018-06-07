package wsz.spring.jpa.service;

import java.util.List;

import wsz.spring.jpa.domain.Book;

public interface BookService {

	public List<Book> getAll();
	
	public Book getBookById(long id);

	public List<Book> jdbc(long id);
}
