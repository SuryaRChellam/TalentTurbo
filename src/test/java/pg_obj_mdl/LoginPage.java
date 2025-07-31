package pg_obj_mdl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {
	
		public LoginPage(WebDriver driver)
		
		{
			super(driver);
			
		}
		
		@FindBy(xpath="//a[normalize-space()='Login']")
		WebElement LoginPage;
		
		@FindBy(xpath="//input[@name='email']")
		WebElement EmailFld;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement PassFld;
		
		@FindBy(xpath="//select[@name='userType']")
		WebElement UserFld;
		
		@FindBy(xpath="//button[normalize-space()='Login']")
		WebElement LoginBtn;
		
		
		
		
		
		public void loginPage() {
			LoginPage.click();
		}
		
		public void EmailFld(String email) {
			EmailFld.sendKeys(email);
		}
		
		public void PassFld(String password) {
			PassFld.sendKeys(password);
		}
		
		public void selectUserType(String userType) {
	        Select dropdown = new Select(UserFld);
	        dropdown.selectByVisibleText(userType);
	    }
		
		public void loginbtn() {
			LoginBtn.click();
		}
		
	}




