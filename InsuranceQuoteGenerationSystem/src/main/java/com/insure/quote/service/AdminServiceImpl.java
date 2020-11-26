package com.insure.quote.service;
import java.util.List;
import com.insure.quote.dao.AdminDaoImpl;
import com.insure.quote.dao.AdminDao;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
public class AdminServiceImpl implements AdminService {
AdminDaoImpl adminDao = new AdminDaoImpl ();
@Override
public int addUser(UserRole userRole) throws IQGSException {
return adminDao.addUser(userRole);
}
@Override
public int accountCreation(Accounts account) throws IQGSException {
return adminDao.accountCreation(account);
}
@Override
public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
return adminDao.getLineOfBusinessIdByName(busSegName);
}
@Override
public boolean isUserExists(String userName) throws IQGSException {
return adminDao.isUserExists(userName);
}
@Override
public String getBusSegId(int accNumber) throws IQGSException {
return adminDao.getBusSegId(accNumber);
}
@Override
public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws IQGSException {
return adminDao.getPolicyQuestions(busSegId);
}
@Override
public int getPolicyPremiumAmount(int sumOfWeightages) throws IQGSException {
return adminDao.getPolicyPremiumAmount(sumOfWeightages);
}
@Override
public int createPolicy(Policy policy) throws IQGSException {
return adminDao.createPolicy(policy);
}
@Override
public int getPolicyNumber() throws IQGSException {
return adminDao.getPolicyNumber();
}
@Override
public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
throws IQGSException {
adminDao.addPolicyDetails(polNumber, questionIds, selectedAnswers);
}
@Override
public List<Policy> getPolicies() throws IQGSException {
return adminDao.getPolicies();
}
@Override
public Accounts getAccountDetails(int accNumber) throws IQGSException {
return adminDao.getAccountDetails(accNumber);
}
@Override
public String getBusSegName(String lineOfBusiness) throws IQGSException {
return adminDao.getBusSegName(lineOfBusiness);
}
@Override
public Double getPolicyPremium(int polNum) throws IQGSException {
return adminDao.getPolicyPremium(polNum);
}
@Override
public List<String> getSelectedAnswers(int polNum) throws IQGSException {
return adminDao.getSelectedAnswers(polNum);
}
@Override
public boolean accountValidation(String userName) throws IQGSException {
	return adminDao.accountValidation(userName);
}
}
