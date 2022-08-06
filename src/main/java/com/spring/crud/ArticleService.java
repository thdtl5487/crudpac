package com.spring.crud;

import java.util.List;

public interface ArticleService {

	ArticleVO selectById(ArticleVO vo);
	
	void insert(ArticleVO vo);
	
	void update(ArticleVO vo);
	
	void delete(ArticleVO vo);
	
	List<ArticleVO> getList();
	
	ArticleVO selectFromList(ArticleVO vo);
	
	ArticleVO updateFromList(ArticleVO vo);

	void updateFromListActive(ArticleVO vo);
}
