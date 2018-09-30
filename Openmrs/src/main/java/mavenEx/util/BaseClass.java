package mavenEx.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	

	 protected WebDriver driver;
	@Parameters({"url","browserType"})
	@BeforeTest
	public void launchApplication(String url,String browserType)
	{
		switch(browserType) 
		{	
			case "FF":
				System.out.println("in FF");
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "IE":
				System.out.println("in IE");
				System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				//zoom set to 100%
				//Enabled protected mode for all the zones..
				break;
			case "CH":
				System.out.println("in CH");
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
