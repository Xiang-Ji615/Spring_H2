package main.java.spring.h2.bo.bo;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.spring.h2.dao.dao.IBookDao;

public abstract class AbstractBo {

	@Autowired
	IBookDao bookDao;
}
