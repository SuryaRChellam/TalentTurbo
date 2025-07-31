package pg_obj_mdl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
			public RegisterPage(WebDriver driver)
			
			{
				super(driver);
				
			}
			
		@FindBy(xpath="//span[normalize-space()='Post Your Resume']")
		WebElement Resume;
		
		@FindBy(xpath="//input[@placeholder='First Name']")
		WebElement Firstname;
		
		@FindBy(xpath="//input[@placeholder='Email']")
		WebElement Email;
		
		@FindBy(xpath="//input[@placeholder='Password']")
		WebElement Password;
		
		@FindBy(xpath="(//input[@placeholder='Confirm Password'])[1]")
		WebElement Cnfm_Password;
		
		
		
		
		@SuppressWarnings("deprecation")
		public void setupDriver() {
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@FindBy(xpath="//a[normalize-space()='Register']")
		WebElement btnRegister;
		
		public void regBtn() {
			Resume.click();
		}
		
		public void entFname(String fn) {
			Firstname.sendKeys(fn);
		}
		
		public void entEm(String em) {
			Email.sendKeys(em);
		}
		
		public void entpw(String pw) {
			Password.sendKeys(pw);
		}
	
		public void entCpw(String Cpw) {
			Cnfm_Password.sendKeys(Cpw);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].blur();", Cnfm_Password);
		}
		
		public void clickReg() {
			btnRegister.click();
		}
		
		


}
