package com.insure.quote.dao;
import java.sql.SQLException;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
public interface Userdao {
	public UserRole userLogin(String UserId,String Password) throws SQLException ;
	public boolean loginValidation(String username, String password) throws IQGSException;
}


