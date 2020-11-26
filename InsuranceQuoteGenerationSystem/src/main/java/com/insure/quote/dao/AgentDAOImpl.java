package com.insure.quote.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyDetails;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.utils.AdminQueries;
import com.insure.quote.utils.AgentDBQueries;
import com.insure.quote.utils.DataBaseConnection;
public class AgentDAOImpl implements AgentDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
		String businessSegmentId = null;
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement(AgentDBQueries.GET_LOB_NAME);
			pst.setString(1, busSegName);		
			ResultSet rs= pst.executeQuery();
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
			PreparedStatement pst= conn.prepareStatement(AdminQueries.USER_EXISTS);
			pst.setString(1, userName);
			ResultSet rs= pst.executeQuery();
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
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AdminQueries.ACCOUNT_CREATION);
			pst.setString(1, account.getInsuredName());
			pst.setString(2, account.getInsuredStreet());
			pst.setString(3, account.getInsuredCity());
			pst.setString(4, account.getInsuredState());
			pst.setInt(5, account.getInsuredZip());
			pst.setString(6, account.getLineOfBusiness());
			pst.setString(7, account.getUserName());			
			isInserted = pst.executeUpdate();			
		} catch (SQLException e) {
			conn = DataBaseConnection.getConnection();
		} 		
		return isInserted;
	}
	@Override
	public boolean accountValidation(String userName) throws IQGSException {
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.VALIDATE_ACCOUNT_QUERY);
			pst.setString(1, userName);		
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
			found =true;
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
	public boolean isAccountExists(int accNumber) throws IQGSException {
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.VALIDATE_ACCOUNT);
			pst.setInt(1, accNumber);			
			ResultSet rs= pst.executeQuery();
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
	public String getBusSegId(int accNumber) throws IQGSException {
		String busSegId = null;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_BUS_SEG_ID);
			pst.setInt(1, accNumber);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				busSegId = rs.getString(1);
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
        return busSegId;
	}
	@Override
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {		
		List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
		conn = DataBaseConnection.getConnection();
		try {
		PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_QUESTIONS);
			pst.setString(1, busSegId);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				PolicyQuestions polQues = new PolicyQuestions();
				polQues.setPolQuesId(rs.getString(1));
				polQues.setPolQuesSeq(rs.getInt(2));
				polQues.setBusSegId(rs.getString(3));
				polQues.setPolQuesDesc(rs.getString(4));
				polQues.setPolQuesAns1(rs.getString(5));
				polQues.setPolQuesAns1Weightage(rs.getInt(6));
				polQues.setPolQuesAns2(rs.getString(7));
				polQues.setPolQuesAns2Weightage(rs.getInt(8));
				polQues.setPolQuesAns3(rs.getString(9));
				polQues.setPolQuesAns3Weightage(rs.getInt(10));
				policyQuestions.add(polQues);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return policyQuestions;
	}
	@Override
	public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
		int preAmt = 0;
		boolean found = false;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_PREMIUM);
			pst.setDouble(1, sumOfWeightages);
			ResultSet rs= pst.executeQuery();
			found = rs.next();
			if(found == true) {
				preAmt = rs.getInt(1);
			}			
			if(rs.next()) {
				preAmt = rs.getInt(4);
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
		return preAmt;
	}
	@Override
	public int createPolicy(Policy policy) throws IQGSException {
		int isInserted = 0;
		try
		{
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.CREATE_POLICY);
			pst.setDouble(1, policy.getPolicyPremium());
			pst.setInt(2, policy.getAccNumber());
			isInserted = pst.executeUpdate();
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
		return isInserted;
	}
	@Override
	public int getPolicyNumber() throws IQGSException {
		int polNumber = 0;
		boolean found = false;
		try
		{
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_NUMBER);	
			ResultSet rs= pst.executeQuery();
			found = rs.next();
			if(found == true) {
				polNumber = rs.getInt(1);
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
		return polNumber;
	}
	@Override
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
			throws IQGSException {
		try
		{
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.ADD_POLICY_DETAILS);	
			for(int i = 0; i < questionIds.size(); i++) {
				pst.setInt(1, polNumber);
				pst.setString(2, questionIds.get(i));
				pst.setString(3, selectedAnswers.get(i));
				pst.executeUpdate();
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
	}
	@Override
	public List<Policy> getPolicies(int accNumber) throws IQGSException {		
		List<Policy> policies = new ArrayList<Policy>();
		Policy policy;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICIES);		
			pst.setInt(1,accNumber);
			ResultSet rs= pst.executeQuery();
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
	public Accounts getAccountDetails(int accNumber) throws IQGSException {
		Accounts account = new Accounts();
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_ACCOUNT_DETAILS);	
			pst.setInt(1, accNumber);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				account.setAccountNumber(rs.getInt(1));
				account.setInsuredName(rs.getString(2));
				account.setInsuredStreet(rs.getString(3));
				account.setInsuredCity(rs.getString(4));
				account.setInsuredState(rs.getString(5));
				account.setInsuredZip(rs.getInt(6));
				account.setLineOfBusiness(rs.getString(7));		
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
		return account;
	}
	@Override
	public String getBusSegName(String lineOfBusiness) throws IQGSException {
		String busSegName = null;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_BUS_SEG_NAME);
			pst.setString(1, lineOfBusiness);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				busSegName = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());			}
		}		
		return busSegName;
	}
	@Override
	public Double getPolicyPremium(int polNum) throws IQGSException {
		Double polPremium = 0.0;
		try {
			conn = DataBaseConnection.getConnection();
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_POLICY_PREMIUM);
			pst.setInt(1, polNum);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				polPremium = rs.getDouble(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
			} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());			}
		}
		return polPremium;
	}
	@Override
	public List<String> getSelectedAnswers(int polNum) throws IQGSException {
		List<String> selectedAns = new ArrayList<String>();
		PolicyDetails details = null;
		boolean isFound = false;
		conn = DataBaseConnection.getConnection();
		try {			
			PreparedStatement pst= conn.prepareStatement(AgentDBQueries.GET_SELECTED_ANSWERS);
			pst.setInt(1, polNum);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				selectedAns.add(rs.getString(1));
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
		return selectedAns;
	}
	@Override
	public int getAccountNumber(String userName) throws IQGSException {
		int accNo = 0;
		try {
			conn = DataBaseConnection.getConnection();
			pst = conn.prepareStatement(AgentDBQueries.GET_ACCOUNT_NUMBER);
			pst.setString(1, userName);			
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
				System.out.println(e.getMessage());			
				}
		}
        return accNo;
	}	
}
