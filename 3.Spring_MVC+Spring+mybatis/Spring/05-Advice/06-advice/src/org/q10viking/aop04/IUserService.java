package org.q10viking.aop04;

public interface IUserService {
	//主业务方法
	boolean check(String username,String password) throws UserException;

}
