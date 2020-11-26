package com.insure.quote.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyDetails;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.utils.AdminQueries;
import com.insure.quote.utils.DataBaseConnection;
import com.insure.quote.utils.InsuredDbQueries;
public class InsuredDaoImpl implements InsuredDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public boolean accountValidation(String username) throws IQGSException {
		boolean found = false;
		try {
			conn=DataBaseConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(InsuredDbQueries.VALIDATE_ACCOUNT_QUERY);
			pst.setString(1, username);			
			rs = pst.executeQuery();
			if(rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
        return found;
	}	
	@Override
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws IQGSException {
		String businessSegmentId = null;
		boolean found = false;
		try {
			conn=DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.GET_LOB_NAME);
			pst.setString(1, lineOfBusinessName);	
			rs = pst.executeQuery();
			found = rs.next();
			if(found == true) {
				businessSegmentId = rs.getString(1);				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return businessSegmentId;
	}		
	@Override
	public boolean isUserExists(String userName) throws IQGSException {
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.USER_EXISTS);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
        return found;
	}
	@Override
	public int accountCreation(Accounts account) throws IQGSException {
		int isInserted = 0;
		try {
			conn=DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.ACCOUNT_CREATION);
			pst.setString(1, account.getInsuredName());
			pst.setString(2, account.getInsuredStreet());
			pst.setString(3, account.getInsuredCity());
			pst.setString(4, account.getInsuredState());
			pst.setInt(5, account.getInsuredZip());
			pst.setString(6, account.getLineOfBusiness());
			pst.setString(7, account.getUserName());			
			isInserted = pst.executeUpdate();			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}	
		return isInserted;
	}
	@Override
	public List<Policy> getInsuredPolicies(int accno) throws IQGSException {
		List<Policy> policies = new ArrayList<Policy>();
		Policy policy;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.GET_INSURED_POLICY);	
			pst.setInt(1, accno);
			rs = pst.executeQuery();
			while(rs.next()) {
				policy = new Policy();
				policy.setPolicyNumber(rs.getInt(1));
				policy.setPolicyPremium(rs.getDouble(2));
				policy.setAccNumber(rs.getInt(3));
				policies.add(policy);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				pst.close();
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}		
		return policies;
}
	@Override
	public int getAccountNumber(String username) throws IQGSException {
		int accNo = 0;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(InsuredDbQueries.GET_ACCOUNT_NUMBER);
			pst.setString(1, username);			
			rs = pst.executeQuery();
			if(rs.next()) {				
				accNo = rs.getInt(1);				
			}
			else {
				System.out.println("No Account so please create one");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
			} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());			}
		}
        return accNo;
	}	
}



