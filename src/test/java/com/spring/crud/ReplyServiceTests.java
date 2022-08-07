package com.spring.crud;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.crud.impl.ReplyDAO;
import com.spring.crud.impl.ReplyServiceImpl;

import lombok.Setter;

public class ReplyServiceTests {

	
	private ReplyServiceImpl service;
	
	int article_id = 47;
	
	@Test
	public void testGetList() {
		
		service = new ReplyServiceImpl();
		
		System.out.println(service);
		List<ReplyVO> list = service.getList(article_id);
		System.out.println("testGetList �����޼�~~");
		list = service.getList(article_id);
		if(service.getList(article_id)!=null) {
			
			list = service.getList(article_id);
			for (ReplyVO replyVO : list) {
				System.out.println(replyVO);
			}
		}else {
			System.out.println("list ������°� �����غθ� ��");
		}
		
	}

}
