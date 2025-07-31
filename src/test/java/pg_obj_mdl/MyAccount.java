package pg_obj_mdl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	public MyAccount(WebDriver driver)
	
	{
		super(driver);
		
	}
	@FindBy(xpath="(//a[@role='button'])[1]")
	WebElement username;
	
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement acctName;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logOut;
	
	public void acctnameClk() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", acctName);
		
		
	}
	
	public void logoutClk() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logOut);
		
		
	}

	
}
