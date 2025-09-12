package wvTest;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import marketingModule.scoringModel;

public class scoringModelTest  extends baseClassPcrm{

baseClassPcrm bi=new baseClassPcrm();
    
	@BeforeTest
	public void driver_set()
	{
		
		bi.driverSetupCrm();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		bi.close();
//	}
	
	@Test
	public void createScoringModel() throws InterruptedException, IOException
	{
		scoringModel scoringModelObj= new scoringModel(driver);
		scoringModelObj.selectMarketingModule();
		scoringModelObj.switchArea();
		scoringModelObj.selectLeadManagement();
		scoringModelObj.selectScoringModelEntity();
		scoringModelObj.dragAndDrop();
		scoringModelObj.fillDetailConditionTool();
		scoringModelObj.clickPlus();
		scoringModelObj.gradesFill();
		scoringModelObj.nameFill() ;
	}

}
