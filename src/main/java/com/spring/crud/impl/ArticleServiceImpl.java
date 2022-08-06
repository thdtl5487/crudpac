package com.spring.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.ArticleService;
import com.spring.crud.ArticleVO;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public ArticleVO selectById(ArticleVO vo) {
		return articleDAO.selectById(vo);
	}

	@Override
	public void insert(ArticleVO vo) {
		articleDAO.insert(vo);
	}

	@Override
	public void update(ArticleVO vo) {
		articleDAO.update(vo);
	}

	@Override
	public void delete(ArticleVO vo) {
		articleDAO.delete(vo);
	}

	@Override
	public List<ArticleVO> getList() {
		return articleDAO.getList();
	}

	@Override
	public ArticleVO selectFromList(ArticleVO vo) {
		return articleDAO.selectFromList(vo);
	}
//	@Override
//	public ArticleVO selectFromList(int id) {
//		return articleDAO.selectFromList(id);
//	}

	@Override
	public ArticleVO updateFromList(ArticleVO vo) {
		return articleDAO.selectFromList(vo);
	}

	@Override
	public void updateFromListActive(ArticleVO vo) {
		articleDAO.updateFromListActive(vo);
	}
}
