package wvTest;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.cancelCSpledge;
public class cancelCSpledgeTest extends baseClassPcrm{
	
	
	
    
	@BeforeTest
	public void driver_set() throws InterruptedException
	{
		
		
		driverSetupCrm();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		bi.close();
//	}

	@Test
	public void cancelCS_pledge() throws InterruptedException, IOException
	{
		cancelCSpledge cancelPage=new cancelCSpledge(driver);
		cancelPage.selectFundraisingAndEngagement();
        cancelPage.clickPledge();
       // cancelPage.clickCopilot();
        cancelPage.selectAllPledge();
        cancelPage.filterPledgeById("Pl-1136");
        
        cancelPage.selectFirstPledge();
        cancelPage.cancelPledge();
        cancelPage.selectCancelReason();
        cancelPage.save();
	}
}
