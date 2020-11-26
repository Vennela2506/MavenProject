package com.insure.quote.service;
import java.util.List;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;

public interface AdminService {
	public boolean accountValidation(String userName) throws IQGSException;
		public int addUser(UserRole userRole) throws IQGSException;
		public int accountCreation(Accounts account) throws IQGSException;
		public String getLineOfBusinessIdByName(String busSegName) throws IQGSException;
		public boolean isUserExists(String userName) throws IQGSException;
		public String getBusSegId(int accNumber) throws IQGSException;
		public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException;
		public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException;
		public int createPolicy(Policy policy) throws IQGSException;
		public int getPolicyNumber() throws IQGSException;
		public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws IQGSException;
		public List<Policy> getPolicies() throws IQGSException;
		public Accounts getAccountDetails(int accNumber) throws IQGSException;
		public String getBusSegName(String lineOfBusiness) throws IQGSException;
		public Double getPolicyPremium(int polNum) throws IQGSException;
		public List<String> getSelectedAnswers(int polNum) throws IQGSException;
	}

	

