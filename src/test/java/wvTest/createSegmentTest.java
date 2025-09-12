package wvTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.createSegment_Journey;


public class createSegmentTest extends baseClassPcrm {


	@BeforeTest
	public void driver_set() throws InterruptedException
	{
		
		driverSetupCrm();
	}
	

	
	@Test
	public void createSegment() throws IOException, InterruptedException
	{
		createSegment_Journey segment= new createSegment_Journey(driver);
		segment.selectMarketingModule();
		segment.switchArea();
		segment.selectCustomerArea();
		segment.selectSegementEntity();
		segment.clickNew();
		segment.createSegmentDetails();
		segment.addContactInSegment();
		segment.goLiveClick();

	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		close();
	}
}
