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
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class refundPayment  {  

    public WebDriver driver;
    public Wait<WebDriver> wait;
    public Properties prop;
	public FileReader File;

    public refundPayment(WebDriver driver) throws IOException {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50L))
                .pollingEvery(Duration.ofSeconds(5L));
        File=new FileReader(".//src//test//resources//config.properties");
		prop=new Properties();
		prop.load(File);
    }

    public By signInButton = By.xpath("//div[@aria-label='Sign in with arif.ahmad@consultant.wvi.org work or school account.']");
    public By frameLocator = By.xpath("//iframe[@class='designer-client-frame']");
    public By postedEntriesLocator = By.xpath("//a[@title='View the posting history for donations.']");
    public By donationLedgerEntriesLocator = By.xpath("//span[@aria-label='Donation Ledger Entries']");
    public By filterClickLocator = By.xpath("//i[@data-icon-name='Filter']");
    public By filterTypeLocator = By.xpath("//button[@aria-label='Add a new filter on a field']");
    public static By enterPledgeIdListLocator = By.xpath("//input[contains(@id,'ComboBox')]");
    public By filterInputBoxLocator = By.xpath("//div[@controlname='Pledge ID']//input");
    public By correctionBtnLocator = By.xpath("//span[@aria-label='Correction']");
    public By refundBtnLocator = By.xpath("//button[@aria-label='Reverse/Refund']");
    public By reasonReversalLocator = By.xpath("/html/body/div[2]/div[4]/form/main/div[2]/div[6]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/input");
    public By selectDateLocator = By.xpath("//input[@title='Type the date in the format dd-MM-yyyy']");
    public By originalEntryLocator = By.xpath("//span[contains(text(),'Original Entry')]");
    public By postReverseLocator = By.xpath("//button[@aria-label='Post Reverse']//span");
    public By selectYesLocator = By.xpath("//span[contains(text(),'Yes')]");
    public By successfulValidationLocator = By.xpath("//p[@title='Donation has been canceled/refunded successfully.']");
    public static By dialogBox = By.xpath("//div[contains(@class,'dialog two')]");
  

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void switchToFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(frameLocator));
        driver.switchTo().frame(frame);
    }

    public void clickPostedEntries() {
        WebElement postedEntries = wait.until(ExpectedConditions.visibilityOfElementLocated(postedEntriesLocator));
        postedEntries.click();
    }

    public void clickDonationLedgerEntries() {
        WebElement donationLedgerEntries = wait.until(ExpectedConditions.visibilityOfElementLocated(donationLedgerEntriesLocator));
        donationLedgerEntries.click();
    }

    public void clickFilter() {
        WebElement filterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(filterClickLocator));
        filterClick.click();
    }

    public void selectFilterType() throws InterruptedException {
        WebElement filterType = wait.until(ExpectedConditions.visibilityOfElementLocated(filterTypeLocator));
        filterType.click();
        Thread.sleep(2000);
    }

    public void enterPledgeId() throws InterruptedException {
        WebElement enterPledgeIdList = wait.until(ExpectedConditions.visibilityOfElementLocated(enterPledgeIdListLocator));
        enterPledgeIdList.sendKeys("Pledge Id");
        enterPledgeIdList.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void enterFilterInput() throws InterruptedException {
        WebElement filterInputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(filterInputBoxLocator));
        filterInputBox.sendKeys(prop.getProperty("pledge_id_refund"));
        filterInputBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void clickCorrectionButton() {
        WebElement correctionBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(correctionBtnLocator));
        correctionBtn.click();
    }

    public void clickRefundButton() {
        WebElement refundBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(refundBtnLocator));
        refundBtn.click();
        WebElement notCompleteStateBox = driver.findElement(dialogBox);
        if(notCompleteStateBox.isDisplayed())
        {
        	System.out.println("Status of the Entry is not completed");
        	Assert.assertTrue(false);
        }
        else
        {
        	Assert.assertTrue(true);
        }
      
    }

    public void enterReasonForReversal() throws InterruptedException {
        WebElement reasonReversal = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonReversalLocator));
        reasonReversal.sendKeys("REFUND");
        Thread.sleep(4000);
        reasonReversal.click();
    }

    public void selectDate() {
        WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDateLocator));
        selectDate.sendKeys("18-07-2025");
    }

    public void clickOriginalEntry() {
        WebElement originalEntry = wait.until(ExpectedConditions.visibilityOfElementLocated(originalEntryLocator));
        originalEntry.click();
    }

    public void clickPostReverse() throws InterruptedException {
        WebElement postReverse = wait.until(ExpectedConditions.elementToBeClickable(postReverseLocator));
        postReverse.click();
        Thread.sleep(3000);
    }

    public void clickYes() throws InterruptedException {
        WebElement selectYes = wait.until(ExpectedConditions.visibilityOfElementLocated(selectYesLocator));
        selectYes.click();
        Thread.sleep(2000);
    }

    public void validateSuccessMessage() {
        WebElement successfulValidation = wait.until(ExpectedConditions.visibilityOfElementLocated(successfulValidationLocator));
        String onSuccessText = successfulValidation.getText();
        System.out.println(onSuccessText + " is the message");
        Assert.assertEquals(onSuccessText, "Donation has been canceled/refunded successfully.");
    }


}

