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

public class ValidateTitle extends Base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Go to Home Page and maximize window");
	}
	
	@Test()
	public void validateAppTitle() throws IOException
	{		
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES Bre");  
		log.info("Successfully navigated");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
