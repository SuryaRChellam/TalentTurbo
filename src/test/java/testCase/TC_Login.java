package testCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pg_obj_mdl.LoginPage;
import pg_obj_mdl.MyAccount;
import testBase.baseclass;

public class TC_Login extends baseclass {
	
	@Test(groups={"regression","master"} )
	public void opnLoginpage() {
	LoginPage lp = new LoginPage(driver);
	lp.loginPage();
	logger.info("Login page loading");
	lp.EmailFld(p.getProperty("email"));
	lp.PassFld(p.getProperty("password"));
	
	String userType = p.getProperty("usertype");
	lp.selectUserType(userType);
	logger.info("Credentials entered");
	lp.loginbtn();
	
	MyAccount myA = new MyAccount(driver);
	WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(20));
	myA.acctnameClk();
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	myA.logoutClk();

	}

}
