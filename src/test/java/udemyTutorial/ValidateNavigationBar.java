package udemyTutorial;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test()
	public void basePageNavigation() throws IOException
	{
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());		
//		Assert.assertFalse(lp.getNavBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
