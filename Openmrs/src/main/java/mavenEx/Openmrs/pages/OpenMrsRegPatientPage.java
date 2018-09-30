package mavenEx.Openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OpenMrsRegPatientPage {

	WebDriver driver;

	public OpenMrsRegPatientPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public boolean enterPatientDetails(
			String gName,
			String mName,
			String fName,
			String dBirth,
			String mBirth,
			String yBirth,
			String gender)
	{
		//****Registering a patient details
		boolean entered=false;
		driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[1]/ul/li[1]")).click();
		driver.findElement(By.cssSelector("[name='givenName']")).sendKeys(gName);
		driver.findElement(By.cssSelector("[name='middleName']")).sendKeys(mName);
		driver.findElement(By.cssSelector("[name='familyName']")).sendKeys(fName);
		System.out.println("****Entered Name details");
		driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[1]/ul/li[2]")).click();
		if(gender.equals("male"))
		{
		driver.findElement(By.xpath(".//*[@id='gender-field']/option[1]")).click();
		}
		else
		{
			driver.findElement(By.xpath(".//*[@id='gender-field']/option[2]")).click();	
		}
		System.out.println("****Entered Gender details");
		driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[1]/ul/li[3]")).click();
		driver.findElement(By.xpath(".//*[@id='birthdateDay-field']")).sendKeys(dBirth);
		driver.findElement(By.xpath(".//*[@id='birthdateMonth-field']")).click();
		driver.findElement(By.xpath(".//*[@id='birthdateMonth-field']/option[4]")).click();
		driver.findElement(By.xpath(".//*[@id='birthdateYear-field']")).sendKeys(yBirth);
		System.out.println("****Entered DOB details");
		driver.findElement(By.xpath(".//*[@id='formBreadcrumb']/li[2]")).click();
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		System.out.println("****Submitted the details");
		entered=true;
		return entered;
			}

	public void navigateToRegPatientPage()
	{
	driver.findElement(By.cssSelector("#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
	}
	/*@Test
	public void searchServiceType()
	{
		login();
		driver.findElement(By.cssSelector("#appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.cssSelector("#appointmentschedulingui-manageAppointmentTypes-app")).click();
		String expected= "Urology";
		List<WebElement> pages = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
		int sPage=pages.size();
		outer:
			for (int j=0; j<sPage; j++)
			{
				pages.get(j).click();
				List<WebElement> e = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable']/tbody/tr/td[1]"));
				int size=e.size();
				System.out.println("Size of e: "+ size);

				for (int i=0; i<size;i++)
				{
					String sName = e.get(i).getText();
					System.out.println("Service Name: "+ sName);
					if (expected.equals(sName))
					{
						System.out.println("********Service Found");
						break outer;
					}

				}

			}
		logout();
	}
*/

	/*public void login()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org");
		//****login
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void logout()
	{
		driver.quit();
	}
*/
}
