package com.spring.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.ReplyService;
import com.spring.crud.ReplyVO;

@Service("ReplyService")
public class ReplyServiceImpl  implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void insert(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReplyVO vo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReplyVO> getList(int article_id) {
		
		System.out.println("����� ServiceImpl�̰� replyDAO�� ȣ���Ұ��� "+replyDAO);
		
		return replyDAO.getList(article_id);
	}

}
