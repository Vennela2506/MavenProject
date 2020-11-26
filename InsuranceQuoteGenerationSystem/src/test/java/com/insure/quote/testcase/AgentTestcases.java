package com.insure.quote.testcase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import com.insure.quote.dao.AgentDAO;
import com.insure.quote.dao.AgentDAOImpl;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
public class AgentTestcases {
	AgentDAO agent=new AgentDAOImpl();
	@Test
	public void testgetLineOfBusinessIdByName() throws IQGSException  {
		assertEquals("Auto_01",agent.getLineOfBusinessIdByName("Business Auto"));
	}
	@Test
	public void testisUserExists() throws IQGSException  {
		assertEquals(true,agent.isUserExists("Malavika"));
	}
	@Test
	public void testaccountCreation() throws IQGSException  {
		Accounts account=new Accounts("BBQ","Kukatpally","Hyderabad","Telangana",12345,"Food_02","Rachana");
		int createaccount=agent.accountCreation(account);
		assertNotNull(createaccount);
	}
	@Test
	public void testisAccountExists() throws IQGSException  {
		assertEquals(true,agent.isAccountExists(1));
	}
	@Test
	public void testaccountValidation() throws IQGSException  {
		assertEquals(true,agent.accountValidation("Varun"));
	}
	@Test
	public void testgetBusSegId() throws IQGSException  {
		assertEquals("Food_02",agent.getBusSegId(1));
	}
	@Test
	public void testcreatePolicy() throws IQGSException{
		Policy policy=new Policy(1,3600,1);
		int checkPolicy=agent.createPolicy(policy);
		assertNotNull(checkPolicy);
	}
	@Test
	public void testgetBusSegName() throws IQGSException  {
		assertEquals("Business Auto",agent.getBusSegName("Auto_01"));
	}
	@Test
	public void testgetAccountNumber() throws IQGSException  {
		assertEquals(1,agent.getAccountNumber("Rachana"));
	}
}
