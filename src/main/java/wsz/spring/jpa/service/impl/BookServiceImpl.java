package wsz.spring.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import wsz.spring.jpa.dao.BookRepository;
import wsz.spring.jpa.domain.Book;
import wsz.spring.jpa.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	public List<Book> getAll(){
		return bookRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Book getBookById(long id) {
		String key = "book_"+id;
		ValueOperations<String, Book> opsForValue = redisTemplate.opsForValue();
		Boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			System.out.println("缓存中");
			return opsForValue.get(key);
		}
		Book bookById = bookRepository.getBookById(id);
		opsForValue.set(key, bookById, 100, TimeUnit.SECONDS);
		System.out.println("数据库");
		return bookById;
	}
	
	public List<Book> jdbc(long id) {
		String sql = "select id, name, writer, introduction, price from t_book where id=?";
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, id);
		List<Book> listBook = new ArrayList<Book>(10);
		for (Map<String, Object> map : queryForList) {
			Book b = new Book();
			b.setId(Integer.parseInt(map.get("id").toString()));
			b.setName(map.get("name").toString());
			b.setIntroduction(map.get("introduction").toString());
			b.setWriter(map.get("writer").toString());
			String price = map.get("price").toString();
			if(!StringUtils.isEmpty(price)) {
				b.setPrice(Double.parseDouble(price));
			}
			listBook.add(b);
		}
		return listBook;
	}
}
