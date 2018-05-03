package main.java.spring.h2.bo.bo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.spring.h2.dao.model.Book;

@Service
public class BookBoImp extends AbstractBo implements IBookBo {

	@Transactional
	@Override
	public Boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.saveBook(book);
	}

}
