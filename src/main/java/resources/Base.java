package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
//		BasicConfigurator.configure();
		prop=new Properties();
//		FileInputStream fis=new FileInputStream("C:\\Users\\Petar\\eclipse-workspace2019\\"
//				+ "PetarProject\\src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("firefox")) 
		{
			// firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Petar\\MozillaFirefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			// chrome
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\ChromeDriver\\chromedriver.exe");
//			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			// IE
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
