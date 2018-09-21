package org.q10viking.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory sqlSession;

	public static SqlSession getSqlSession() {
		try {
			//1. 加载主配置文件	
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			
			if (sqlSession==null) {
				//2. 创建SqlSessionFactory对象
				sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
			}
			//3.创建SqlSession
			return sqlSession.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
