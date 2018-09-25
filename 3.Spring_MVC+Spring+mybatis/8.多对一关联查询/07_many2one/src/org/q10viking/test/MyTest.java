package org.q10viking.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.q10viking.beans.Country;
import org.q10viking.beans.Minister;
import org.q10viking.dao.CountryDao;
import org.q10viking.dao.MinisterDao;
import org.q10viking.utils.MyBatisUtils;
import java.util.List;
public class MyTest {
	
	private SqlSession sqlSession;
	private MinisterDao dao;
	@Before
	public void before() {
		sqlSession = MyBatisUtils.getSqlSession();
		dao = sqlSession.getMapper(MinisterDao.class);
	}
	
	@After
	public void after() {
		sqlSession.close();
	}
	
	//一对多关联查询
/*	@Test
	public void test01() {
		Country country = dao.selectCountryById(1);
		System.out.print(country);
	}*/
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
	
	//多对一查询 多表连接查询
/*	@Test
	public void test02() {
		Minister minister = dao.selectMinisterByMid(4);
		System.out.print(minister);
	}*/
	/*
		[DEBUG] ==>  Preparing: SELECT mid,mname,cid,cname FROM minister,country WHERE countryId=cid and mid=? 
		[DEBUG] ==> Parameters: 4(Integer)
		[TRACE] <==    Columns: mid, mname, cid, cname
		[TRACE] <==        Row: 4, Duker, 2, China
		[DEBUG] <==      Total: 1
		Minister [mid=4, mname=Duker, country=Country [cid=2, cname=China]]
	*/
	
	
	//多对一查询，多表单独查询
	@Test
	public void test03() {
		Minister minister = dao.selectMinisterByMid(3);
		System.out.print(minister);
	}
	/*
		[DEBUG] ==>  Preparing: SELECT mid,mname,countryId FROM minister WHERE mid=? 
		[DEBUG] ==> Parameters: 3(Integer)
		[TRACE] <==    Columns: mid, mname, countryId
		[TRACE] <==        Row: 3, Cater, 2
		[DEBUG] ====>  Preparing: SELECT cid,cname FROM country WHERE cid=? 
		[DEBUG] ====> Parameters: 2(Integer)
		[TRACE] <====    Columns: cid, cname
		[TRACE] <====        Row: 2, China
		[DEBUG] <====      Total: 1
		[DEBUG] <==      Total: 1
		Minister [mid=3, mname=Cater, country=Country [cid=2, cname=China]]
	*/
	
					
}
