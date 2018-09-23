package org.q10viking.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.q10viking.beans.Student;
import org.q10viking.utils.MyBatisUtils;

public class StudentDaoImp implements IStudentDao {
	
	private SqlSession sqlSession;

	@Override
	public void insertStudent(Student student) {
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

	@Override
	public void insertStudentCatchId(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.insert("insertStudentCatchId",student);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.delete("deleteStudentById", id);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.update("updateStudent", student);
			sqlSession.commit();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students=null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//将结果存储到students中
			students=sqlSession.selectList("selectAllStudents");
			
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}

	@Override
	public Map<String, Object> selectAllStudentsMap() {
		Map<String,Object> map = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			map = sqlSession.selectMap("selectAllStudents", "name");
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return map;
	}

	@Override
	public Student selectStudentById(int id) {
		Student student=null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			student = (Student)sqlSession.selectOne("selectStudentById",id);
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return student;
	}

	@Override
	public List<Student> selectStudentsByName(String name) {
		//模糊查询
		List<Student> students=null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			students = sqlSession.selectList("selectStudentsByName",name);
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return students;
	}
	
	
}
