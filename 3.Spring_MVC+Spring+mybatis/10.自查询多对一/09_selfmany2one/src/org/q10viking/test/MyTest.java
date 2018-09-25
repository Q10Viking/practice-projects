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
	//查询父栏目
	@Test
	public void test01() {
		NewsLabel news = dao.selectParentByParentId(9);
		System.out.println(news);
	}
/*	
	[DEBUG] ==>  Preparing: SELECT id,name,pid FROM Newslabel WHERE id=? 
	[DEBUG] ==> Parameters: 9(Integer)
	[TRACE] <==    Columns: id, name, pid
	[TRACE] <==        Row: 9, 青岛双星, 4
	[DEBUG] ====>  Preparing: SELECT id,name,pid FROM Newslabel WHERE id=? 
	[DEBUG] ====> Parameters: 4(Integer)
	[TRACE] <====    Columns: id, name, pid
	[TRACE] <====        Row: 4, CBN, 2
	[DEBUG] ======>  Preparing: SELECT id,name,pid FROM Newslabel WHERE id=? 
	[DEBUG] ======> Parameters: 2(Integer)
	[TRACE] <======    Columns: id, name, pid
	[TRACE] <======        Row: 2, 体育新闻, 0
	[DEBUG] ========>  Preparing: SELECT id,name,pid FROM Newslabel WHERE id=? 
	[DEBUG] ========> Parameters: 0(Integer)
	[DEBUG] <========      Total: 0
	[DEBUG] <======      Total: 1
	[DEBUG] <====      Total: 1
	[DEBUG] <==      Total: 1
	NewsLabel [id=9, name=青岛双星, parent=NewsLabel [id=4, name=CBN, parent=NewsLabel [id=2, name=体育新闻, parent=null]]]
	*/		
					
}
