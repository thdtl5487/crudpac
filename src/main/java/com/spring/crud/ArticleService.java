package com.spring.crud;

import java.util.List;

public interface ArticleService {

	ArticleVO selectById(ArticleVO vo); // 현재 사용안함
	
	void insert(ArticleVO vo); // 현재 사용안함
	
	void update(ArticleVO vo); // 현재 사용안함
	
	void delete(ArticleVO vo); // 현재 사용안함
	
	List<ArticleVO> getList();
	
	ArticleVO selectFromList(ArticleVO vo);
	
	ArticleVO updateFromList(ArticleVO vo);

	void updateFromListActive(ArticleVO vo);
}