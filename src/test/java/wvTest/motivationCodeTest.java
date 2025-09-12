package wvTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.motivationCode;


public class motivationCodeTest extends baseClassPcrm  {
	

     
	@BeforeTest
	public void driver_set() throws InterruptedException
	{
		
		driverSetupCrm();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		close();
//	}

	@Test
	public void motivation_code() throws InterruptedException
	{
		motivationCode MVC=new motivationCode(driver);
		MVC.selectFundraisingAndEngagement();
		MVC.switchToFundraisingArea();
		MVC.clickMotivationTypes();
		MVC.clickNewButton();
		MVC.enterName();
		MVC.selectChannel();
		MVC.save();
	}
}
