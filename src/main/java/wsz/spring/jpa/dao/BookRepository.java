package wsz.spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wsz.spring.jpa.domain.Book;
import wsz.spring.jpa.utils.Des;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Des("根据id获取book对象")
	@Query("select b from Book b where id =:id")
	public Book getBookById(@Param("id") long id);
	
	
}
