package base;


import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;
import pages.SignInPage;
import utilities.ReadConfig;
import utilities.TestListenerClass;

@Listeners({TestListenerClass.class})
public class TestBase implements ITestListener{
	
public WebDriver driver;
ReadConfig readConfig = new ReadConfig();

  protected HomePage homePageObj;
  protected SignInPage signInPageObj;
  
	public static Logger logger;
	
	protected ExtentReports extent;
  ExtentSparkReporter sparkReporter;
  ExtentTest test;
	
  


  @BeforeSuite
  public void beforeSuite()
  {
  	extent = new ExtentReports();
  	sparkReporter = new ExtentSparkReporter("report.html");
  	extent.attachReporter(sparkReporter);
  }
  
  @AfterSuite
  public void afterSuite()
  {
    extent.flush();
  }
  
  @BeforeTest
  public void startTest() {
  	
              sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//test-output//Extentreport.html");
              extent.attachReporter(sparkReporter);
              extent.setSystemInfo("Facebook", "Login");
              extent.setSystemInfo("Env", "QA");
              extent.setSystemInfo("Build", "1.0.1");
              extent.setSystemInfo("Browser", "Chrome");
  }
	
  @Parameters("browser")
  @BeforeMethod
  public void setUp(String br)
  {
	  if (br.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		  driver = new ChromeDriver();
	  }
	  else if(br.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
		  driver = new FirefoxDriver();
	  }
  	  
  	 String baseURL = readConfig.getApplicationURL();
  	 driver.get(baseURL);
  	   	 
  	 homePageObj = new HomePage(driver);
  //	 signInPageObj=new SignInPage(driver);
  	  
  }
  
  @AfterMethod
  public void teardown()
  {
	  driver.close();
	  logger.info("sign in button clicked for log");
  }
  
}
