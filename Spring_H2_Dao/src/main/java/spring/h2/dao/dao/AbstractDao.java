package main.java.spring.h2.dao.dao;

import javax.annotation.PostConstruct;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public abstract class AbstractDao extends HibernateDaoSupport{

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(sessionFactory);
	}

}
