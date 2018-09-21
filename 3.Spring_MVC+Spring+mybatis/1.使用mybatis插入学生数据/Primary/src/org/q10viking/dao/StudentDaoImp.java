package org.q10viking.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.q10viking.beans.Student;
import org.q10viking.utils.MyBatisUtils;

public class StudentDaoImp implements IStudentDao {
	
	private SqlSession sqlSession;

	@Override
	public void insertStu(Student student) {
		try {

			sqlSession = MyBatisUtils.getSqlSession();
			//4.相关操作
			sqlSession.insert("insertStudent", student);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				//这里涉及到事物提交，以及脏数据的处理
				sqlSession.close();
			}
		}	
	}
}
