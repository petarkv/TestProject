package udemyTutorial;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Email, String Password, String tekst) throws IOException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		LandingPage lp=new LandingPage(driver);
		LoginPage logp = lp.getLogin();
		
//		LoginPage logp=new LoginPage(driver);
		logp.getEmail().sendKeys(Email);
		logp.getPassword().sendKeys(Password);
//		System.out.println(tekst);
		log.info(tekst);
		logp.getLogin().click();
		ForgotPassword fpass = logp.forgotPassword();
		fpass.getEmail().sendKeys("novipass");
		fpass.sendMeInstructions().click();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Rows stands for how many different data types test should run
		// Column stands for how many values per each test
		Object[][] data=new Object[2][3];
		// 0th row
		data[0][0]="nonrestricteduser@test.com";
		data[0][1]="123456";
		data[0][2]="Non Restricted User";
		
		// 1th row
		data[1][0]="restricteduser@test.com";
		data[1][1]="654321";
		data[1][2]="Restricted User";
		
		return data;
	}

}
