package org.q10viking.service;

import java.util.ArrayList;
import java.util.List;

import org.q10viking.beans.Student;
import org.q10viking.dao.IStudentDao;

public class StudentServiceImp implements IStudentService {

	private IStudentDao dao;
	
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
	public void removeStudentById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void modifyStudent(Student student) {
		dao.updateStudent(student);
	}

	@Override
	public List<String> findAllStudentsNames() {
		List<Student> list = this.findAllStudents();
		List<String> names = new ArrayList();
		for(Student stu: list) {
			names.add(stu.getName());
		}
		return names;
	}

	@Override
	public String findStudentNameById(int id) {
		Student student = this.findStudentById(id);
		return student.getName();
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

	@Override
	public void testSpring() {
		System.out.println("Spring能完成Bean管理的基本工作");
	}

}
