package wvTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import marketingModule.marketingFormPages;

public class marketingForm_PagesTest extends baseClassPcrm {
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
	public void Create_internetMarketing() throws InterruptedException {
		
		marketingFormPages marketingFormPagesTest = new marketingFormPages(driver);
		
		marketingFormPagesTest.selectMarketingModule();
		//marketingFormPagesTest.refresh();
		marketingFormPagesTest.switchArea();
		marketingFormPagesTest.clickCopilot();
		marketingFormPagesTest.selectInternetMarketing();
		marketingFormPagesTest.selectMarketingForms();
		marketingFormPagesTest.clickNewButton();
		marketingFormPagesTest.selectTemplate("subscription form");
		marketingFormPagesTest.fillFormDetails("Arif_Automation");
		String formName = marketingFormPagesTest.getFormName();
        System.out.println("name is "+ formName);
		marketingFormPagesTest.saveForm();
		marketingFormPagesTest.goLiveForm();
	        
	        marketingFormPagesTest.selectMarketingPages();
	        marketingFormPagesTest.clickNewButton();
	        marketingFormPagesTest.clickSkipButton();
	        marketingFormPagesTest.clickFormTool();
	        marketingFormPagesTest.switchToDesignerCanvas();
	        marketingFormPagesTest.clickAddTool();
	        marketingFormPagesTest.switchToDefaultContent();
	       marketingFormPagesTest.insertMarketingForm(formName);
	        marketingFormPagesTest.fillPageDetails();
	        marketingFormPagesTest.savePage();
	        marketingFormPagesTest.goLivePage();
	        
		

	        
	} 

}
