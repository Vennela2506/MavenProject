package com.insure.quote.testcase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.awt.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.insure.quote.dao.AdminDaoImpl;
import com.insure.quote.dto.Accounts;
import com.insure.quote.dto.Policy;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
@SuppressWarnings("unused")
   public class AdminTestcases {
AdminDaoImpl dao=null;
   @Before
public void setUp() throws Exception {
dao=new AdminDaoImpl();
}
@After
public void tearDown() throws Exception {
dao=null;
}
@Test
public void testCreateAccount() {
Accounts accounts=new Accounts("BBQ", "Kukatpally", "Hyderabad", "Telengana", 12345, "Business Auto", "Rachana");
try {
int accountValidation = dao.accountCreation(accounts);
assertNotNull(accountValidation);
} catch (IQGSException e) {
System.out.println(e.getMessage());
}
}
@Test
public void testAddProfile() {
UserRole role1=new UserRole("Rachana", "Insured123", "Insured");
try {
int addProfileTest = dao.addUser(role1);
assertNotNull(addProfileTest);
} catch (IQGSException e) {
System.out.println(e.getMessage());
}
}
@Test
public void testUserExist() {
try {
boolean userExistTest = dao.isUserExists("Rachana");
assertTrue(userExistTest);
} catch (IQGSException e) {
e.printStackTrace();
}
}
@Test
public void testgetBusSegId() throws IQGSException{
assertEquals("Apartment",dao.getBusSegName("Home_03"));
}
@Test
public void testgetLineOfBusinessIdByName() throws IQGSException{
assertEquals("Food_02",dao.getLineOfBusinessIdByName("Restaurant"));
}
@Test
public void testcreatePolicy() throws IQGSException{
Policy pol=new Policy(1,1800,1);
int checkPolicy=dao.createPolicy(pol);
assertNotNull(checkPolicy);
}
@Test
public void testgetPolicies() throws IQGSException{
Policy policy=new Policy(4,1800,7);
int checkPolicy=dao.createPolicy(policy);
assertNotNull(checkPolicy);
}
}
