package org.q10viking.dao;

import org.q10viking.beans.Student;

public interface IStudentDao {
	Student selectStudentById(int sid);
}
