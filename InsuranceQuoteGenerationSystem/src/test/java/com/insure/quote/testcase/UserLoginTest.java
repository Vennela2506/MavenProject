package com.insure.quote.testcase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import org.junit.Test;
import com.insure.quote.dao.UserDaoImpl;
import com.insure.quote.dao.Userdao;
import com.insure.quote.dto.UserRole;
import com.insure.quote.exception.IQGSException;
public class UserLoginTest {
	Userdao userdao=new UserDaoImpl();
	@Test
	public void testloginValidate() throws IQGSException  {
		assertEquals(true,userdao.loginValidation("Vennela","Admin123"));
	}
	@Test
	public void testuserLogin()throws IQGSException, SQLException  {
		UserRole checkUser=userdao.userLogin("Vennela","Admin123");
		assertNotNull(checkUser);
	}
	}

