package businessCentral;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import WVtestCase.basePage;

public class transferPayment extends basePage {

//	public WebDriver driver;
//	public Wait<WebDriver> wait;
//	public Properties prop;
//	public FileReader File;
//	public refundPayment refund;
	

	public transferPayment(WebDriver driver) throws IOException  {
//		this.driver = driver;
//		this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50L))
//				.pollingEvery(Duration.ofSeconds(5L));
//	 File=new FileReader(".//src//test//resources//config.properties");
//		prop=new Properties();
//		prop.load(File);
//		this.refund= new refundPayment(driver);
		super(driver);  //calling from basePage
	}

	public void BC_correctionTab() throws InterruptedException {
		// getting methods from refund payment
		refund.clickSignInButton();
		refund.switchToFrame();
		refund.clickPostedEntries();
		refund.clickDonationLedgerEntries();
		refund.clickFilter();
		refund.selectFilterType();
		refund.enterPledgeId();
		refund.enterFilterInput();
		refund.clickCorrectionButton();
	}

	public void verify_transfer() {

		// click on Transfer button
		WebElement transferBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Transfer']")));
		transferBtn.click();
		try {
			WebElement notCompleteStateBox = driver.findElement(By.xpath("//div[contains(@class,'dialog two')]"));
			if (notCompleteStateBox.isDisplayed()) {
				System.out.println("Status of the Entry is not completed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
//		else {
//			Assert.assertTrue(true);
//		}
	}

	public void verify_rebooking() throws InterruptedException {

		// select rebooking to
		//String rebookingValue = "Pledge";
		WebElement rebookingTo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/select")));
		rebookingTo.click();
		Thread.sleep(2000);
		Select select = new Select(rebookingTo);
		select.selectByVisibleText(prop.getProperty("rebookingValue"));
		Thread.sleep(2000);

		String rebookingType = rebookingTo.getAttribute("title");
		System.out.println("Rebookingto :" + rebookingType);

		if (rebookingType.equals("Pledge")) {
			// select transfer reason
			WebElement transferReason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/input")));
			transferReason.click();
			transferReason.sendKeys("TRANSFER");
			transferReason.sendKeys(Keys.ENTER);

			// selecting donor
			String donorId = "USAO-CNT-113386";
			WebElement donorIDBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/input")));
			donorIDBox.click();
			donorIDBox.sendKeys(donorId);
			donorIDBox.sendKeys(Keys.ENTER);

			// select pledge id
			//String pledgeIdTransfer = "Pl-7859"; // change pledge id on which you want to transfer
			WebElement pledgeIdBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[4]/div/input")));
			pledgeIdBox.click();
			pledgeIdBox.sendKeys(prop.getProperty("pledge_id_2"));
			pledgeIdBox.sendKeys(Keys.ENTER);
		}

		else if (rebookingType.equals("One-time Payment without Pledge")) {
			// select transfer reason
			WebElement transferReason = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/input")));
			transferReason.click();
			transferReason.sendKeys("TRANSFER");
			transferReason.sendKeys(Keys.ENTER);

			// selecting donor
			String donorId = "USAO-CNT-113386";
			WebElement donorIDBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/input")));
			donorIDBox.click();
			donorIDBox.sendKeys(donorId);
			donorIDBox.sendKeys(Keys.ENTER);

			// motivation code
			String motivationCode = "AKMOTTYPE1-0002";
			WebElement motivatioCodeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[8]/div/input")));
			motivatioCodeBox.click();
			motivatioCodeBox.sendKeys(motivationCode);
			motivatioCodeBox.sendKeys(Keys.ENTER);

			// Designation code
			String designationCode = "0001";
			WebElement designationCodeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[9]/div/input")));
			designationCodeBox.click();
			designationCodeBox.sendKeys(designationCode);
			designationCodeBox.sendKeys(Keys.ENTER);
		}

	}

	public void verify_post() {
		// click post
		WebElement postBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Post']")));
		postBtn.click();
		WebElement yesClick = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Yes')]//parent::button")));
		yesClick.click();

		// on sucess validation
		WebElement successfulValidation = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[@title='Donation has been reposted/transfered successfully.']")));

		String onSuccessText = successfulValidation.getText();
		System.out.println(onSuccessText + " is the message");
		Assert.assertEquals(onSuccessText, "Donation has been reposted/transfered successfully.");

	}

}