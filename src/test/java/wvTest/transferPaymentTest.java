package wvTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import businessCentral.transferPayment;
import BasePack.baseClassPcrm;

public class transferPaymentTest extends baseClassPcrm{

	baseClassPcrm bi=new baseClassPcrm();

	@BeforeTest
	public void driver_setup()
	{
		
		bi.driverSetupBC();
	}
	
	@AfterTest
	public void tearDown()
	{
		bi.close();
	}
	
	@Test
	public void transfer_payment() throws InterruptedException, IOException
	{
		transferPayment TF=new transferPayment(driver);
		TF.BC_correctionTab();
		TF.verify_transfer();
		TF.verify_rebooking();
		TF.verify_post();
		
	}
}
