package wvTest;



import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import marketingModule.leadCreation;

import BasePack.baseClassPcrm;

public class leadCreationTest extends baseClassPcrm{

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
	public void createLead() throws IOException, InterruptedException
	{
		leadCreation leadCreationTest= new leadCreation(driver);
		
		leadCreationTest.selectMarketingModule();
		leadCreationTest.switchArea();
		leadCreationTest.selectLeadManagement();
		leadCreationTest.selectLeadEntity();
		leadCreationTest.fillSummaryForm();
		leadCreationTest.inquiryBtn();
		leadCreationTest.saveBtn();
		
	}
	
	

}
