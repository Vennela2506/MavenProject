package com.insure.quote.service;
import java.sql.ResultSet;
import java.util.List;
import com.insure.quote.dao.AgentDAO;
import com.insure.quote.dao.AgentDAOImpl;
import com.insure.quote.dao.AgentDAO;
import com.insure.quote.exception.IQGSException;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyDetails;
import com.insure.quote.dto.PolicyQuestions;
public class AgentServiceImpl implements AgentService {
	AgentDAO agentDao = new AgentDAOImpl();
	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
		return agentDao.getLineOfBusinessIdByName(busSegName);
	}
	@Override
	public boolean isUserExists(String userName) throws IQGSException {
		return agentDao.isUserExists(userName);
	}
	@Override
	public int accountCreation(Accounts account) throws IQGSException {
		return agentDao.accountCreation(account);
	}
	@Override
	public boolean accountValidation(String userName) throws IQGSException {
		return agentDao.accountValidation(userName);
	}
	@Override
	public boolean isAccountExists(int accNumber) throws IQGSException {
		return agentDao.isAccountExists(accNumber);
	}
	@Override
	public String getBusSegId(int accNumber) throws IQGSException {
		return agentDao.getBusSegId(accNumber);
	}
	@Override
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {
		return agentDao.getPolicyQuestions(busSegId);
	}
	@Override
	public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
		return agentDao.getPolicyPremiumAmount(sumOfWeightages);
	}
	@Override
	public int createPolicy(Policy policy) throws IQGSException {
		return agentDao.createPolicy(policy);
	}
	@Override
	public int getPolicyNumber() throws IQGSException {
		return agentDao.getPolicyNumber();
	}
	@Override
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws IQGSException {
		agentDao.addPolicyDetails(polNumber,questionIds,selectedAnswers);
	}
	@Override
	public List<Policy> getPolicies(int accNumber) throws IQGSException {		
		return agentDao.getPolicies(accNumber);
	}
	@Override
	public Accounts getAccountDetails(int accNumber) throws IQGSException {
		return agentDao.getAccountDetails(accNumber);
	}
	@Override
	public String getBusSegName(String lineOfBusiness) throws IQGSException {
		return agentDao.getBusSegName(lineOfBusiness);
	}
	@Override
	public Double getPolicyPremium(int polNum) throws IQGSException {
				return agentDao.getPolicyPremium(polNum);
	}
	@Override
	public List<String> getSelectedAnswers(int polNum) throws IQGSException {
		return agentDao.getSelectedAnswers(polNum);
	}
	@Override
	public int getAccountNumber(String userName) throws IQGSException {
		return agentDao.getAccountNumber(userName);
	}
}

