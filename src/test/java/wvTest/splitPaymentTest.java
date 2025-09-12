package wvTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import WVtestCase.splitPayment;

import BasePack.baseClassPcrm;

public class splitPaymentTest extends baseClassPcrm {

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
	public void split_payment() throws InterruptedException, IOException
	{
		splitPayment sp=new splitPayment(driver);
		//sp.splitPay();
		sp.BC_split();
		sp.verify_splitBtn();
		sp.verify_splitFunctionality();
		sp.verify_post();
		
		
	}
}
