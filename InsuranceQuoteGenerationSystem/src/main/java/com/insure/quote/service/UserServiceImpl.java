package com.insure.quote.service;
import java.sql.SQLException;
import com.insure.quote.dao.UserDaoImpl;
import com.insure.quote.dao.Userdao;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
public class UserServiceImpl implements UserService {
	private Userdao dao=new UserDaoImpl();
	@Override
	public UserRole userLogin(String UserId, String Password) throws SQLException {
		UserRole user=dao.userLogin(UserId,Password);
		return user;
	}
	@Override
	public boolean loginValidation(String username, String password) throws IQGSException {
		return dao.loginValidation(username, password);
	}
}
