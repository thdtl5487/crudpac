package com.spring.crud;

import java.util.List;

public interface ReplyService {
	
	List<ReplyVO> getList(int article_id);
	
	void insert(ReplyVO vo);
	
	void delete(ReplyVO vo);
	
	void update(ReplyVO vo);
	
}
