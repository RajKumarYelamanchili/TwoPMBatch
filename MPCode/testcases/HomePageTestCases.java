package testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;

public class HomePageTestCases extends TestBase {
	final Logger logger = (Logger) LogManager.getLogger(HomePageTestCases.class);
	@Test
	void TC_01_verifySignInButton() throws InterruptedException
	{
		
		ExtentTest test = extent.createTest("TC_01_verifySignInButton");
		test.log(Status.INFO,"chrome launched");
		logger.info("url opened");
		
		homePageObj.getSignInButton().click();
		test.log(Status.INFO,"SignIn button clicked for extent report");
		 logger.info("sign in button clicked for log");
		Thread.sleep(2000);
	}
	@Test
	void TC_01_verifyContactUsButton() throws InterruptedException
	{
		
		ExtentTest test = extent.createTest("TC_01_verifyContactUsButton");
		test.log(Status.INFO,"chrome launched");
		logger.info("url opened");
		
		homePageObj.getSignInButton().click();
		test.log(Status.INFO,"Contact Us button clicked for extent report");
		 logger.info("Contact Us button clicked for log");
		Thread.sleep(2000);
	}
}
