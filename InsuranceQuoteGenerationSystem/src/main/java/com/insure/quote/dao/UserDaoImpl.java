package com.insure.quote.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.insure.quote.utils.AdminQueries;
import com.insure.quote.utils.DBQueries;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.utils.DataBaseConnection;
public class UserDaoImpl implements Userdao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public UserRole userLogin(String UserId, String Password)throws SQLException {
		conn=DataBaseConnection.getConnection();
			PreparedStatement pst=conn.prepareStatement(DBQueries.VALIDATEQUERY);
			pst.setString(1, UserId);
			pst.setString(2,Password);
			ResultSet res=pst.executeQuery();
			 UserRole user=null;
			 if(res.next()) {
				 user=new UserRole();
				 user.setUserName(res.getString(1));
				 user.setPassword(res.getString(2));
				 user.setRoleCode(res.getString("roleCode"));
			 }
			 conn.close();	
		return user;	
	}
	public boolean loginValidation(String username, String password) throws IQGSException {
		// TODO Auto-generated method stub
		
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(AdminQueries.VALIDATE_USER_QUERY);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				found = true;
				String name = rs.getString(1);
				String pwd = rs.getString(2);
			}
			else {
				System.out.println("no user");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());			}
		}
        return found;
	}
	}

