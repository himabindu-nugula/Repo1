package mavenEx.Openmrs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	WebDriver driver;
public HelperClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}



public void login(String username, String password) {

	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("Inpatient Ward")).click();
	driver.findElement(By.id("loginButton")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}



public void logout()
{
	driver.findElement(By.cssSelector(".logout>a")).click();
}

	
}
