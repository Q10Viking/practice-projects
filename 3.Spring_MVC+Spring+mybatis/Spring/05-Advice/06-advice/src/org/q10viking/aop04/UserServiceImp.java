package org.q10viking.aop04;

public class UserServiceImp implements IUserService {

	@Override
	public boolean check(String username, String password) throws UserException {
		if(!"Q10Viking".equals(username)) {
			throw new UsernameException("用户名有误");
		}
		
		if(!"iloveyou".equals(password)) {
			throw new PasswordException("密码有误");
		}
		
		return true;
	}

}
