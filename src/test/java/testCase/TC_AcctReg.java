package testCase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pg_obj_mdl.RegisterPage;
import testBase.baseclass;

public class TC_AcctReg extends baseclass {
	
	
	@Test(groups={"sanity","master"} )
	public void opnReg(){
		RegisterPage reg = new RegisterPage(driver);
		
		reg.regBtn();
		logger.info("Reg Starts");
		String pss = rdmalpNum();
		reg.entFname(rdmString());
		reg.entEm(rdmString()+"@gmail.com");
		reg.entpw(pss);
		reg.entCpw(pss);
        logger.info("Details Entered");
		

	}

}
