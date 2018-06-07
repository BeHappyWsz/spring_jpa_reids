package wsz.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import wsz.spring.jpa.domain.Book;
import wsz.spring.jpa.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public List<Book> getAll(){
		return bookService.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public Book getBookById(@PathVariable("id")long id) {
		return bookService.getBookById(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/book/{id}", method=RequestMethod.PUT)
	public List<Book> jdbc(@PathVariable("id")long id) {
		return bookService.jdbc(id);
	}
}
