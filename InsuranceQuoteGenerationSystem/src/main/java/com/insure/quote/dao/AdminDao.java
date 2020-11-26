package com.insure.quote.dao;
import java.util.List;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
public interface AdminDao {
	public boolean accountValidation(String userName) throws IQGSException;
	public int addUser(UserRole userRole) throws IQGSException;	
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws IQGSException;
	public boolean isUserExists(String userName) throws IQGSException;	
	public int accountCreation(Accounts account) throws IQGSException;	
	public String getBusSegId(int accNumber) throws IQGSException;	
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException;	
	public Integer createPolicy(Policy policy) throws IQGSException;	
	public Integer getPolicyNumber() throws IQGSException;	
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws IQGSException;	
	public List<Policy> getPolicies() throws IQGSException;	
	public Accounts getAccountDetails(Integer accNumber) throws IQGSException;	
	public String getBusSegName(String busSegId) throws IQGSException;
	public Double getPolicyPremium(Integer polNum) throws IQGSException;
	public List<String> getSelectedAnswers(int polNum) throws IQGSException;
	public Integer getPolicyPremiumAmount(Integer sumOfWeightages) throws IQGSException;
	}

	

