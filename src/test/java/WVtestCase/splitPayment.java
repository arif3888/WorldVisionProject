


package WVtestCase;

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
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

//import WVtestCase.basePage;

public class splitPayment 
{
	

public WebDriver driver;
public refundPayment refund;
public transferPayment transfer;
public Wait<WebDriver> wait; 
public FileReader File;
public Properties prop;
	
	
	public splitPayment(WebDriver driver) throws IOException 
	{
       
       this.wait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(50L))
               .pollingEvery(Duration.ofSeconds(5L));
		this.refund= new refundPayment(driver);
		 File=new FileReader(".//src//test//resources//config.properties");
			prop=new Properties();
			prop.load(File);
	}

	public void BC_split() throws InterruptedException {
		
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
				
	public void verify_splitBtn()
	{
				//click Split button
				WebElement splitBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Split']")));
				splitBtn.click();
				//check if pledge id is in complete status
				try {
					WebElement notCompleteStateBox = driver.findElement(By.xpath("//div[contains(@class,'dialog two')]"));
					if (notCompleteStateBox.isDisplayed()) {
						System.out.println("Status of the Entry is not completed");
						Assert.assertTrue(false);
					}
				} catch (Exception e) {

					Assert.assertTrue(true);
				}
			      

	}
	
	
	public void verify_splitFunctionality() throws InterruptedException
	{
				//click split reason
				WebElement splitReason= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Choose a value for Split reason']//following::input[1]")));
				splitReason.click();
				splitReason.sendKeys("SPLITED");
				Thread.sleep(2000);
				splitReason.sendKeys(Keys.ENTER);
				

				
				//check first row amount  (Amount LCY)
				WebElement firstRowAmount= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@controlname='Amount (LCY)']//span")));
				firstRowAmount.click();
				
				String rowAmount=firstRowAmount.getAttribute("title");
				System.out.println(rowAmount);
				
				double number = Double.parseDouble(rowAmount);
				double result = number / 2;
				
				//System.out.println(result);
				String strResult = String.valueOf(result);
				 System.out.println(strResult);
				 
				
				 
				//change amount value
				//JavascriptExecutor jse = (JavascriptExecutor)driver;
				WebElement enterAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[contains(@id,\"b\") and contains(@class,\"1876560088\")])[5]")));
				enterAmount.click();
				//jse.executeScript("arguments[0].scrollIntoView(true);", enterAmount);
				
				Thread.sleep(3000);
				
				enterAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
				Thread.sleep(2000);
				//jse.executeScript("arguments[0].value='250'", enterAmount);
				enterAmount.sendKeys(strResult);
				
				
					//click next row
			WebElement nextRow= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/form/main/div[2]/div[7]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[1]")));
			nextRow.click();
			

            
         WebElement nextRowPledge= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/form/main/div[2]/div[7]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[13]/input")));
          nextRowPledge.click();
          nextRowPledge.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
          Thread.sleep(2000);
			nextRowPledge.sendKeys(prop.getProperty("pledgeId_split_second"));//Enter pledge id with whom you want to split
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
				By.xpath("//p[@title='Donation has been splitted successfully.']")));

		String onSuccessText = successfulValidation.getText();
		System.out.println(onSuccessText + " is the message");
		Assert.assertEquals(onSuccessText, "Donation has been splitted successfully.");

	}
	

	
}

