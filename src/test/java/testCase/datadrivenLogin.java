package testCase;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pg_obj_mdl.BasePage;
import pg_obj_mdl.LoginPage;
import pg_obj_mdl.MyAccount;
import testBase.baseclass;
//import utilities.DataProviderUtility;

public class datadrivenLogin extends baseclass{
	
	//@Test(dataProvider="DataDriven",dataProviderClass=DataProviderUtility.class)
	public void opnLoginpage(String email,String password,String usertype) {
		/*LoginPage lp = new LoginPage(driver);
		lp.loginPage();
		logger.info("Login page loading");
		lp.EmailFld(email);//(p.getProperty("email"));
		lp.PassFld(password);//(p.getProperty("password"));
		
		//String userType = p.getProperty("usertype");
		lp.selectUserType(usertype);
		logger.info("Credentials entered");
		lp.loginbtn();
	
		/*MyAccount myA = new MyAccount(driver);
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(20));
		myA.acctnameClk();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		myA.logoutClk();*/
		
	}
	
	}
	

	
