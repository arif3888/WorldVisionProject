package wvTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.baseClassPcrm;
import businessCentral.refundPayment;

public class refundPaymentTest extends baseClassPcrm{

	baseClassPcrm bi=new baseClassPcrm();

	@BeforeTest
	public void driver_setup()
	{
		
		bi.driverSetupBC();
	}
	
//	@AfterTest
//	public void tearDown()
//	{
//		bi.close();
//	}
	
	
	@Test
	public void refund_payment() throws InterruptedException, IOException
	{
		refundPayment RFP=new refundPayment(driver);
		RFP.clickSignInButton();
		RFP.switchToFrame();
		RFP.clickPostedEntries();
		RFP.clickDonationLedgerEntries();
		RFP.clickFilter();
		RFP.selectFilterType();
		RFP.enterPledgeId();
		RFP.enterFilterInput();
		RFP.clickCorrectionButton();
		RFP.clickRefundButton();
		RFP.enterReasonForReversal();
		//RFP.selectDate();
		RFP.clickOriginalEntry();
		RFP.clickPostReverse();
		RFP.clickYes();
		RFP.validateSuccessMessage();
	}
	
	
}

