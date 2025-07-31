package testCase;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.utility01;


public class ddlogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.talentturbo.us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		String filepath=System.getProperty("user.dir")+"\\testdata\\LD.xlsx";
		
		int rn=utility01.getRowCount(filepath,"LD");
		
		for(int i=1;i<=rn;i++) {
			String email=utility01.getCellData(filepath,"LD",i,0);
			String password=utility01.getCellData(filepath,"LD",i,1);
			String usertype=utility01.getCellData(filepath,"LD",i,2);
			
					
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			Select typeUser=new Select(driver.findElement(By.xpath("//select[@name='userType']")));
			typeUser.selectByVisibleText(usertype);
			
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			Thread.sleep(20000);
			String username=driver.findElement(By.xpath("(//a[@role='button'])[1]")).getText();
			System.out.println(username);
			Thread.sleep(20000);
			WebElement dd=driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",dd);
			Thread.sleep(20000);
			WebElement lo=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
			js.executeScript("arguments[0].click();",lo);
			driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
			}
		driver.quit();
	
	}

}
