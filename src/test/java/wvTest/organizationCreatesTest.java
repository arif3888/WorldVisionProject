package wvTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import WVtestCase.organizationCreates;

//@Listeners(BasePack.MyListener.class)
public class organizationCreatesTest extends baseClassPcrm {
    
 
  

    @BeforeTest
    public void driver_set() throws InterruptedException, IOException {
        driverSetupCrm();
       
    }

    @AfterTest
    public void tearDown() {
        close();
    }

    @Test
    public void organizationCreates_test() throws InterruptedException, IOException {
    	organizationCreates orgCreate=new organizationCreates(driver);
        orgCreate.selectFundraisingAndEngagement();
        orgCreate.clickOrganizationEntity();
        orgCreate.clickNewButton();
        orgCreate.enterOrganizationDetails();
        orgCreate.selectMotivation("AAEMOTYPE-0109");
        orgCreate.selectEmail_Mobile(randomeString()+"@gmail.com",randomeNumber());
        orgCreate.enterAddressDetails("Sector 11","delhi","delhi","226016");
        orgCreate.selectCountry("Albania");
        orgCreate.selectBillingAddress();
        orgCreate.saveBtn();
    }


}

