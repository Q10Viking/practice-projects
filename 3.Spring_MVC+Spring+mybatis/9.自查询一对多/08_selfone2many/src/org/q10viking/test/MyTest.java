package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.NewsLabel;
import org.q10viking.dao.INewsLabelDao;
import org.q10viking.utils.MyBatisUtils;
import java.util.List;
public class MyTest {
	
	private SqlSession sqlSession;
	private INewsLabelDao dao;
	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(INewsLabelDao.class);
	}
	
	@After
	public void after() {
		sqlSession.close();
	}
	//查询所有子孙元素不包括自己
/*	@Test
	public void test01() {
		List<NewsLabel> news = dao.selectChildrenByParentId(1);
		
		for(NewsLabel n: news) {
			System.out.println(n);
		}
	}*/
	/*
	[DEBUG] ==>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
	[DEBUG] ==> Parameters: 1(Integer)
	[TRACE] <==    Columns: id, name
	[TRACE] <==        Row: 10, 港台明星
	[DEBUG] ====>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
	[DEBUG] ====> Parameters: 10(Integer)
	[DEBUG] <====      Total: 0
	[TRACE] <==        Row: 11, 内地影视
	[DEBUG] ====>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
	[DEBUG] ====> Parameters: 11(Integer)
	[DEBUG] <====      Total: 0
	[DEBUG] <==      Total: 2
	NewsLabel [id=10, name=港台明星, children=[]]
	NewsLabel [id=11, name=内地影视, children=[]]
	*/
					
	//查询所有子孙元素包括自己
	@Test
	public void test02() {
		List<NewsLabel> news = dao.selectNewsLabelById(1);
		for(NewsLabel n: news) {
			System.out.println(n);
		}
	}
	/*
		[DEBUG] ==>  Preparing: SELECT id,name FROM Newslabel WHERE id=? 
		[DEBUG] ==> Parameters: 1(Integer)
		[TRACE] <==    Columns: id, name
		[TRACE] <==        Row: 1, 娱乐新闻
		[DEBUG] ====>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
		[DEBUG] ====> Parameters: 1(Integer)
		[TRACE] <====    Columns: id, name
		[TRACE] <====        Row: 10, 港台明星
		[DEBUG] ======>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
		[DEBUG] ======> Parameters: 10(Integer)
		[DEBUG] <======      Total: 0
		[TRACE] <====        Row: 11, 内地影视
		[DEBUG] ======>  Preparing: SELECT id,name FROM Newslabel WHERE pid=? 
		[DEBUG] ======> Parameters: 11(Integer)
		[DEBUG] <======      Total: 0
		[DEBUG] <====      Total: 2
		[DEBUG] <==      Total: 1
		NewsLabel [id=1, name=娱乐新闻, children=[NewsLabel [id=11, name=内地影视, children=[]], NewsLabel [id=10, name=港台明星, children=[]]]]
	*/
}
