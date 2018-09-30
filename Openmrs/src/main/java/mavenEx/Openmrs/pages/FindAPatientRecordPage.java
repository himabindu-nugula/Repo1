package mavenEx.Openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindAPatientRecordPage {

	WebDriver driver;
	public FindAPatientRecordPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void navigateToFindAPatientPage()
	{
		driver.findElement(By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
	}

	public boolean findPatientRecord(String pname)
	{
		//driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
		driver.findElement(By.id("patient-search")).sendKeys(pname);
		String actual = driver.findElement(By.xpath("//table[@id='patient-search-results-table']//tr/td[2]")).getText();
		System.out.println("Actual Value is: "+ actual);
		boolean result=actual.trim().equals(pname);
		return result;
	}
}
