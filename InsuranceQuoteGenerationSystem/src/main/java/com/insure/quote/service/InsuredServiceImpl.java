package com.insure.quote.service;
import java.util.List;
import com.insure.quote.dao.InsuredDao;
import com.insure.quote.dao.InsuredDaoImpl;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
public class InsuredServiceImpl implements InsuredService{
		InsuredDao insuredDao = new InsuredDaoImpl();
		@Override
		public String getLineOfBusinessIdByName(String busSegName) throws IQGSException {
			return insuredDao.getLineOfBusinessIdByName(busSegName);
		}
		@Override
		public boolean isUserExists(String userName) throws IQGSException {
			return insuredDao.isUserExists(userName);
		}
		@Override
		public int accountCreation(Accounts account) throws IQGSException {
			return insuredDao.accountCreation(account);
		}
		@Override
		public boolean accountValidation(String username) throws IQGSException {
			return insuredDao.accountValidation(username);
		}
		@Override
		public int getAccountNumber(String username) throws IQGSException {
			return insuredDao.getAccountNumber(username);
		}
		@Override
		public List<Policy> getInsuredPolicies(int accno) throws IQGSException {
			return insuredDao.getInsuredPolicies(accno);
		}
	}



