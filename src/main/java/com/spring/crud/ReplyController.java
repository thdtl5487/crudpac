package com.spring.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.impl.ReplyDAO;

import lombok.AllArgsConstructor;

@RequestMapping("/replies/")
@RestController
@AllArgsConstructor 
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@GetMapping(value="/{article_id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("article_id")int article_id){
		
		System.out.println("getList »Ì°í¿À°Ù´Ù");
		System.out.println(service.getList(article_id).get(1).getContent());
		
		return new ResponseEntity<List<ReplyVO>>(service.getList(article_id), HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public void testFunc() {
		System.out.println("½ÇÇàÁßÀÌ¸é·Î±×°¡ÂïÈù´Ù");
	}
	
}
