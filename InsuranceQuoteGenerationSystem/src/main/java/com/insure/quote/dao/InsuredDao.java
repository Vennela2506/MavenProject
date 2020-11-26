package com.insure.quote.dao;
import java.util.List;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
public interface InsuredDao {
	public boolean accountValidation(String username) throws IQGSException;	
	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws IQGSException;
	public boolean isUserExists(String userName) throws IQGSException;
	public int accountCreation(Accounts account) throws IQGSException;
	public List<Policy> getInsuredPolicies(int accno) throws IQGSException;
	public int getAccountNumber(String username) throws IQGSException;
}
