package main.java.spring.h2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import main.java.spring.h2.bo.bo.IBookBo;
import main.java.spring.h2.dao.model.Book;

@RestController
@RequestMapping(value="Rest/V1")
public class RestfulController {
	
	@Autowired
	IBookBo bookBo;
	
	@Autowired
	Gson gson;

	@RequestMapping(value="HelloWorld", method=RequestMethod.GET)
	public ResponseEntity<?> helloWorld(){
		return ResponseEntity.ok("Hello world");
	}
	
	
	@RequestMapping(value="Book", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveNewBook(@RequestBody String data){
		System.out.println(data);
		return ResponseEntity.ok(bookBo.saveBook(gson.fromJson(data, Book.class)));
	}
}
