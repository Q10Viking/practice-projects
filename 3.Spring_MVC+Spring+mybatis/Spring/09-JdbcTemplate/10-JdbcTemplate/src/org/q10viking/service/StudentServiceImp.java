package org.q10viking.service;

import java.util.List;

import org.q10viking.beans.Student;
import org.q10viking.dao.IStudentDao;


public class StudentServiceImp implements IStudentService {

	private IStudentDao dao;
	
	//以便使用容器进行属性注入
	public IStudentDao getDao() {
		return dao;
	}

	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
			dao.insertStudent(student);
		
	}

	@Override
	public void removeById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

	@Override
	public List<String> findAllStudentsNames() {
		List<String> list = dao.selectAllStudentsNames();
		return list;
	}

	@Override
	public String findStudentNameById(int id) {
		String name = dao.selectStudentNameById(id);
		return name;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> list = dao.selectAllStudents();
		return list;
	}

	@Override
	public Student findStudentById(int id) {
		Student student = dao.selectStudentById(id);
		return student;
	}

}
