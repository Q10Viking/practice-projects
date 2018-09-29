package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.Country;
import org.q10viking.beans.Minister;
import org.q10viking.dao.CountryDao;
import org.q10viking.utils.MyBatisUtils;
import java.util.List;
import java.util.Set;
public class MyTest {
	
	private SqlSession sqlSession;
	private CountryDao dao;
	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(CountryDao.class);
	}
	
	@After
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void test01() {
		Country country = dao.selectCountryById(1);
		System.out.print(country.getCname());
		
		//测试深度延迟加载
		Set<Minister> mins = country.getMinisters();
		System.out.print(mins.size());
	}
	/*
		[DEBUG] ==>  Preparing: SELECT cid,cname,mid,mname FROM country,minister WHERE cid=countryid and cid = ? 
		[DEBUG] ==> Parameters: 1(Integer)
		[TRACE] <==    Columns: cid, cname, mid, mname
		[TRACE] <==        Row: 1, USA, 1, Amy
		[TRACE] <==        Row: 1, USA, 2, Bob
		[DEBUG] <==      Total: 2
		Country [cid=1, cname=USA, ministers=[Minister [mid=2, mname=Bob], Minister [mid=1, mname=Amy]]]
	*/
	/*
		[DEBUG] ==>  Preparing: SELECT cid,cname FROM country WHERE cid=? 
		[DEBUG] ==> Parameters: 1(Integer)
		[TRACE] <==    Columns: cid, cname
		[TRACE] <==        Row: 1, USA
		[DEBUG] ====>  Preparing: SELECT mid,mname FROM minister WHERE countryId=? 
		[DEBUG] ====> Parameters: 1(Integer)
		[TRACE] <====    Columns: mid, mname
		[TRACE] <====        Row: 1, Amy
		[TRACE] <====        Row: 2, Bob
		[DEBUG] <====      Total: 2
		[DEBUG] <==      Total: 1
		Country [cid=1, cname=USA, ministers=[Minister [mid=2, mname=Bob], Minister [mid=1, mname=Amy]]]
	*/
					
}
