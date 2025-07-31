package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class baseclass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	

	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
		
		FileReader credentialFile = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(credentialFile);
		
		logger =LogManager.getLogger(this.getClass());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(p.getProperty("exe").equalsIgnoreCase("remote")) 
		
		{
			
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("Invalid OS");
				return;
			}

		
			switch(br.toLowerCase()) 
			{
			case "chrome": capabilities.setBrowserName("chrome");break;//driver=new ChromeDriver(); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;//driver=new EdgeDriver(); break;
			case "firefox" : capabilities.setBrowserName("firefox");break;//driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid br"); return;
			
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.0.237:5555/wd/hub"),capabilities);
	
		}
		
		if(p.getProperty("exe").equalsIgnoreCase("local")) 
		{


			switch(br.toLowerCase()) 
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid br"); return;
			
			}
	
		}
	 
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
		
	}
	
	public String rdmString() {
		String genrtdName = RandomStringUtils.randomAlphabetic(7);
		return genrtdName;
	}
	
	public String rdmNumber() {
		String genrtdNo = RandomStringUtils.randomNumeric(10);
		return genrtdNo;
	}
	
	public String rdmalpNum() {
		String genrtdemlUnm = RandomStringUtils.randomAlphanumeric(6);
		return genrtdemlUnm;
	}
	
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+ timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	

}




