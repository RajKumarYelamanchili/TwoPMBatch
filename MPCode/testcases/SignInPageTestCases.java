package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.TestBase;

public class SignInPageTestCases extends TestBase{
	

		final Logger logger = (Logger) LogManager.getLogger(SignInPageTestCases.class);
		@Test
		void TC_01_verifyTextCreateAccount() throws InterruptedException
		{
			
			ExtentTest test = extent.createTest("TC_01_verifyTextCreateAccount");
			test.log(Status.INFO,"chrome launched");
			logger.info("url opened");
			
			homePageObj.getSignInButton().click();
			test.log(Status.INFO,"SignIn button clicked for extent report");
			 logger.info("sign in button clicked for log");
			Thread.sleep(2000);
			
			String expected = "Please enter your email address to create an account.";
			String actual = signInPageObj.getCreateAccountText().getText();
			test.log(Status.INFO,"got text for extent report");
			 logger.info("got text for log");
			Assert.assertEquals(actual, expected,"NOT MATCHING");
			
		}
		
	}



