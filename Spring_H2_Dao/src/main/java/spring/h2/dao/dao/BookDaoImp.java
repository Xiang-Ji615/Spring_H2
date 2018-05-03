package main.java.spring.h2.dao.dao;

import org.springframework.stereotype.Repository;

import main.java.spring.h2.dao.model.Book;

@Repository
public class BookDaoImp extends AbstractDao implements IBookDao{

	@Override
	public Boolean saveBook(Book book) {
		Boolean ret = true;
		getHibernateTemplate().save(book);
		return ret;
	}

}
