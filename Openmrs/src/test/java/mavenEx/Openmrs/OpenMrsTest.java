package mavenEx.Openmrs;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mavenEx.Openmrs.pages.FindAPatientRecordPage;
import mavenEx.Openmrs.pages.HelperClass;
import mavenEx.Openmrs.pages.ManageServicesTypesPage;
import mavenEx.Openmrs.pages.OpenMrsRegPatientPage;
import mavenEx.util.BaseClass;

public class OpenMrsTest extends BaseClass {


	@Parameters({"pname","username","password"})
	@Test(priority=1, enabled=true)
	public void verifyFindPatient(String pname,String username,String password) 
	{
		HelperClass hc= new HelperClass(driver);
		FindAPatientRecordPage fppage= new FindAPatientRecordPage(driver);
		hc.login(username, password);
		fppage.navigateToFindAPatientPage();
		boolean result = fppage.findPatientRecord(pname);
		Assert.assertTrue(result);
		hc.logout();
	}

	@Parameters({"serviceName","username","password"})
	@Test(priority=2, enabled=false)
	public void verifyServiceType(String serviceName,String username,String password)
	{
		HelperClass hc= new HelperClass(driver);
		ManageServicesTypesPage mspage=new ManageServicesTypesPage(driver);
		hc.login(username, password);
		mspage.navigateToServiceTypePage();
		boolean result = mspage.findServiceType(serviceName);
		Assert.assertTrue(result);
		hc.logout();
	}

	@Parameters({"gName","mName","fName","dBirth","mBirth","yBirth","gender", "username","password"})
	@Test(priority=3,enabled=false)
	public void enterPatientDetails(String gName,
									String mName,
									String fName,
									String dBirth,
									String mBirth,
									String yBirth,
									String gender,
									String username,
									String password)
	{
		HelperClass hc= new HelperClass(driver);
		OpenMrsRegPatientPage rppage=new OpenMrsRegPatientPage(driver);
		hc.login(username, password);
		rppage.navigateToRegPatientPage();
		boolean result = rppage.enterPatientDetails(gName,mName,fName,dBirth,mBirth,yBirth,gender);
		Assert.assertTrue(result);
		hc.logout();
	}

}
