package com.insure.quote.testcase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import com.insure.quote.dao.InsuredDaoImpl;
import com.insure.quote.dao.InsuredDao;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.PolicyQuestions;
import com.insure.quote.exception.IQGSException;
public class InsuredTestcases {
	InsuredDao insured=new InsuredDaoImpl();
	@Test
	public void testaccountValidation() throws IQGSException  {
		assertEquals(true,insured.accountValidation("Rachana"));
	}
	@Test
	public void testgetLineOfBusinessIdByName() throws IQGSException  {
		assertEquals("Auto_01",insured.getLineOfBusinessIdByName("Business Auto"));
	}
	@Test
	public void testisUserExists() throws IQGSException  {
		assertEquals(true,insured.isUserExists("Vennela"));
	}
	@Test
	public void testaccountCreation() throws IQGSException  {
		Accounts account=new Accounts("BBQ","Kukatpally","Hyderabad","Telangana",12345,"Food_02","Rachana");
		int createaccount=insured.accountCreation(account);
		assertNotNull(createaccount);
	}
	@Test
	public void testgetAccountNumber() throws IQGSException  {
		assertEquals(1,insured.getAccountNumber("Rachana"));
	}
}
