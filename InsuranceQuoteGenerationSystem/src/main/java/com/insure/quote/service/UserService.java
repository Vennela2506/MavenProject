package com.insure.quote.service;
import java.sql.SQLException;

import com.insure.quote.exception.IQGSException;
import com.insure.quote.dto.UserRole;
public interface UserService {
	public UserRole userLogin(String UserId,String Password) throws SQLException;
	public boolean loginValidation(String username, String password) throws IQGSException;
}
