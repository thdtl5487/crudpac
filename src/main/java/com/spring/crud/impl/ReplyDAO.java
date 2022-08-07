package com.spring.crud.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.crud.ReplyVO;

@Repository
public class ReplyDAO {
	
	private SqlSessionTemplate mybatis;
	
	@Autowired
	public ReplyDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public List<ReplyVO> getList(@Param("article_id") int article_id){
		
//		mybatis = new SqlSessionTemplate(sqlSessionFactory sqlfac) {} 
		
		return mybatis.selectList("ReplyDAO.getList", article_id);
	}
}
