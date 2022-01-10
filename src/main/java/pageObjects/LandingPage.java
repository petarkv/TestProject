package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector("#content > div:nth-child(1) > div:nth-child(1)");
	By navBar=By.cssSelector(".navbar-right");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

//	public WebElement getLogin()
//	{
//		return driver.findElement(signin);
//	}
	
	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		LoginPage logp=new LoginPage(driver);
		return logp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}

}
