package wvTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.campaignCreation11;

public class campaignCreationTest extends baseClassPcrm {
	

    
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
	public void Create_Campaign() throws InterruptedException {
		
		campaignCreation11 campaignPage = new campaignCreation11(driver);
		  campaignPage.selectFundraisingAndEngagement();
	        campaignPage.switchToFundraisingArea();
	        campaignPage.clickCampaign();
	        campaignPage.clickNewButton();
	        campaignPage.enterName();
	        campaignPage.save();
	        campaignPage.savedStatusValidation("test passed:Campaign is created","test failed:Campaign is not created");
	        
//	        campaignPage.addNewMotivation();
//	        campaignPage.selectChannel();
//	        campaignPage.selectSubChannel();
//	        campaignPage.clickMotivationTypes();
//	        campaignPage.save();
//	        campaignPage.savedStatusValidation("test passed:Motivation is created","test failed:Motivation is not created");
	}
}