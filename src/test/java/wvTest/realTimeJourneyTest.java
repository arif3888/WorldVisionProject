package wvTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import WVtestCase.realTimeJourney;

import BasePack.baseClassPcrm;

public class realTimeJourneyTest extends baseClassPcrm {

	baseClassPcrm bi=new baseClassPcrm();
	@BeforeTest
	public void driver_set() throws InterruptedException
	{
		
		bi.driverSetupCrm();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		bi.close();
//	}
	
	@Test
	public void createRealTimeJourney() throws IOException, InterruptedException, AWTException
	{
		realTimeJourney journey= new realTimeJourney(driver);
		journey.selectMarketingModule();
		journey.switchArea();
		journey.selectJourneyEntity();
		journey.selectNewJourney();
		journey.clickSkipButton();
		journey.createJourney();
		journey.journeyDesign();
		journey.savePublish();
		
	}
}
