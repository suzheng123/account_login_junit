package mockito_test_account_login.account_login;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest extends TestCase {

	private AccountDao accountDao;
	private HttpServletRequest request;
	private AccountLoginController accountLoginController;
	
	@Before
	public void setUp() {
		this.accountDao = Mockito.mock(AccountDao.class);
		this.request = Mockito.mock(HttpServletRequest.class);
		this.accountLoginController = new AccountLoginController(accountDao);
	}
	
	@Test
	public void testLoginSuccess() {
		Account account = new Account();
		Mockito.when(request.getParameter("username")).thenReturn("bana");
		Mockito.when(request.getParameter("password")).thenReturn("bana123");
		Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);
		
		assertEquals(accountLoginController.login(request), "/login");
	}
	
}
