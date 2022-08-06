package com.spring.crud.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.crud.ArticleVO;

@Repository
public class ArticleDAO {
	
	// Mybatis ÅÛÇÃ¸´ È°¿ë
	private SqlSessionTemplate mybatis;
	
	@Autowired
	public ArticleDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
//	public void insert(ArticleVO vo) {
//		mybatis.insert("ArticleDAO.insert", vo);
//	}
	public void insert(ArticleVO vo) {
		mybatis.insert("ArticleDAO.insert", vo);
	}
	
	public ArticleVO selectById(ArticleVO vo) {
		return (ArticleVO) mybatis.selectOne("ArticleDAO.selectById", vo);
	}
	
	public void update(ArticleVO vo) {
		mybatis.update("ArticleDAO.update", vo);
	}
	
	public void delete(ArticleVO vo) {
		mybatis.delete("ArticleDAO.delete", vo);
	}
	
	public List<ArticleVO> getList(){
		return mybatis.selectList("ArticleDAO.getList");
	}
	
//	public ArticleVO selectFromList(int id) {
//		return (ArticleVO)mybatis.selectOne("ArticleDAO.selectFromList", id);
//	}
	public ArticleVO selectFromList(ArticleVO vo) {
		return (ArticleVO)mybatis.selectOne("ArticleDAO.selectFromList", vo);
	}
	
	public ArticleVO updateFromList(ArticleVO vo) {
		return (ArticleVO)mybatis.selectOne("ArticleDAO.selectFromList", vo); 
	}
	
	public void updateFromListActive(ArticleVO vo) {
		mybatis.update("ArticleDAO.updateFromListActive", vo);
	}
}
