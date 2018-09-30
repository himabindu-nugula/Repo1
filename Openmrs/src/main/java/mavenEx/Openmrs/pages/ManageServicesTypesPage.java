package mavenEx.Openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageServicesTypesPage {

	WebDriver driver;
	public ManageServicesTypesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void navigateToServiceTypePage()
	{
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
	}

	public boolean findServiceType(String serviceName)
	{
		boolean serFound=false;
		List<WebElement> pageList= driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
		System.out.println("Number of pages: " + pageList.size());
		outer:
			for(int i=0; i<pageList.size(); i++)
			{
				pageList= driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
				pageList.get(i).click();
				List<WebElement> serviceList= driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-of-type(1)"));

				for (int j=0; j<serviceList.size(); j++)
				{
					if(serviceList.get(j).getText().contains(serviceName))
					{
						pageList= driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
						System.out.println("*******Service "+serviceName+" Found in page: "+ pageList.get(i).getText());
						serFound=true;
						break outer;
					}
				}

			}
		return serFound;
	}



}
