package com.insure.quote.service;
import java.util.List;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
public interface InsuredService {
	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException;
	public boolean isUserExists(String userName) throws IQGSException;
	public int accountCreation(Accounts account) throws IQGSException;
	public boolean accountValidation(String username) throws IQGSException;
	public int getAccountNumber(String username) throws IQGSException;
	public List<Policy> getInsuredPolicies(int accno) throws IQGSException;
}
