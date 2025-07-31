package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.baseclass;

public class reportUtility implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
				
				repName = "Test-Report" + timeStamp + ".html";
				
				sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
				
				sparkReporter.config().setDocumentTitle("TalentTurbo Report");
				sparkReporter.config().setReportName("TalentTurbo Test results");
				sparkReporter.config().setTheme(Theme.STANDARD);
				
				extent = new ExtentReports();
				extent.attachReporter(sparkReporter);
				 
				extent.setSystemInfo("Application","talentturbo");
				extent.setSystemInfo("Module","Recruiter");
				extent.setSystemInfo("Sub Module","Candidate");
				extent.setSystemInfo("User Name",System.getProperty("user.name"));
				extent.setSystemInfo("Environment","QA");
				
				String os = testContext.getCurrentXmlTest().getParameter("os");
				extent.setSystemInfo("Operating System",os);
				
				String browser = testContext.getCurrentXmlTest().getParameter("browser");
				extent.setSystemInfo("Operating System",browser);
				
				List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
				if(!includedGroups.isEmpty()) {
					extent.setSystemInfo("Groups",includedGroups.toString());
				}
			}
	
			public void onTestSuccess(ITestResult result) {
				
				test = extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.PASS,result.getName()+"got executed");
			}
			
			public void onTestFailure(ITestResult result) {
				test = extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.FAIL,result.getName()+"got failed");
				test.log(Status.INFO,result.getThrowable().getMessage());
				
				try {
					String imgpath = new baseclass().captureScreen(result.getName());
					test.addScreenCaptureFromPath(imgpath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			public void onTestSkipped(ITestResult result) {
				
				test = extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.SKIP,result.getName()+"got skipped");
				test.log(Status.INFO,result.getThrowable().getMessage());
			}
			
			public void onFinish(ITestContext testContext) {
				extent.flush();
				
				String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
				File extentReport = new File(pathofExtentReport);
				
				try {
					Desktop.getDesktop().browse(extentReport.toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
	}

