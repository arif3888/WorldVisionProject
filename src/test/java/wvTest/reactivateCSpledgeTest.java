package wvTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.reactivateCSpledge;

public class reactivateCSpledgeTest extends baseClassPcrm{
	
	
    
	@BeforeTest
	public void driver_set() throws InterruptedException
	{
		
		driverSetupCrm();
	}
	
	@AfterTest
	public void tearDown()
	{
		close();
	}

	@Test
	public void reactivateCS_pledge() throws InterruptedException
	{
		reactivateCSpledge RCS=new reactivateCSpledge(driver);
		
		RCS.selectFundraisingAndEngagement();
		//RCS.clickCopilot();
		RCS.clickPledgeEntity();
		
		RCS.selectAllPledge();
		RCS.filterPledgeById("Pl-1136");
		RCS.selectFirstPledge();
		RCS.clickReactivateButton();
		RCS.selectDate("19-07-2024");;
		RCS.clickYes();
		RCS.activeStatusValidation();
		
		
		
		
	}
}
