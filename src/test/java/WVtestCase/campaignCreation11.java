package WVtestCase;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import marketingModule.marketingFormPages;

public class campaignCreation11 {

    public WebDriver driver;
    public WebDriverWait mywait;
    public Wait<WebDriver> wait;

    public campaignCreation11(WebDriver driver) {
        this.driver = driver;
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(50L))
                        .pollingEvery(Duration.ofSeconds(5L));
    }

    public By frame1 = By.xpath("//iframe[@id='AppLandingPage']");
    public By fundraisingEngagement = By.xpath("//a[@title='Fundraising and Engagement']");
    public By areaBtn = By.xpath("//button[@id='areaSwitcherId']");
    public By configuration = By.xpath("//li[@title='Fundraising']");
    public By campaignBtn = By.xpath("//*[@id='sitemap-entity-NewSubArea_bc4af8aa']/div/div/div[2]");
    public By newButton = By.xpath("//button[@aria-label='New']");
    public By nameField = By.xpath("//input[@aria-label='Name']");
    public By saveButton = By.xpath("//button[@aria-label='Save (CTRL+S)']");
    public By newMotivationButton = By.xpath("//button[@aria-label='New Motivation']");
    public By channelField = By.xpath("//input[@aria-label='Channel, Lookup']");
    public By channelSelect = By.xpath("//li[@aria-label='AKCHANNEL1, 10/10/2022 9:21 PM']");
    public By subChannelField = By.xpath("//input[@aria-label='Sub-Channel, Lookup']");
    public By motivationTypeField = By.xpath("//input[@aria-label='Motivation Type, Lookup']");
    public By subChannelSelect = By.xpath("//li[@aria-label='AKSUBCHAN1, AKCHANNEL1']");
    public By motivationSelect = By.xpath("//li[@aria-label='AKMOTTYPE1, 10/10/2022 9:22 PM']");
    public By saveStatusCampaign = By.xpath("//span[@aria-label='Save status - Saved']");
  
  
  

    public void selectFundraisingAndEngagement() {
    	
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(frame1)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fundraisingEngagement)).click();
    }

    public void switchToFundraisingArea() throws InterruptedException {

    	driver.navigate().refresh();
    	
        WebElement switchArea = wait.until(ExpectedConditions.presenceOfElementLocated(areaBtn));
 
        switchArea.click();

        WebElement area = wait.until(ExpectedConditions.visibilityOfElementLocated(configuration));
        area.click();
        
//        marketingFormPages marketingFormPages = new marketingFormPages(driver);
 //       marketingFormPages.clickCopilot();
     
    }

    public void clickCampaign() {
        WebElement campaignClick = wait.until(ExpectedConditions.visibilityOfElementLocated(campaignBtn));
        campaignClick.click();
    }

    public void clickNewButton() {
        driver.findElement(newButton).click();
        WebElement AIbutton = mywait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='headerBodyContainer']/child::button")));
		AIbutton.click();
    }

    public void enterName() {
        WebElement name = mywait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        name.sendKeys("Arif" + RandomStringUtils.randomAlphabetic(3));
    }

    public void save() {
        driver.findElement(saveButton).click();
        
    }
    
    public void savedStatusValidation(String value1 , String value2)
    {
    	 WebElement activeStatus = mywait.until(ExpectedConditions.visibilityOfElementLocated(saveStatusCampaign));
    	 
    	 if(activeStatus.isDisplayed())
    	    	{
    	    		System.out.println(value1);
    	    		Assert.assertTrue(true);
    	    	}
    	    	else
    	    	{
    	    		System.out.println(value2);
    	    		Assert.assertFalse(false);
    	    	}
         //Assert.assertEquals(activeStatus.isDisplayed(), true);
    }

    public void addNewMotivation() throws InterruptedException {
        driver.findElement(newMotivationButton).click();
        Thread.sleep(3000);
    }

    public void selectChannel() throws InterruptedException {
        WebElement channel = mywait.until(ExpectedConditions.visibilityOfElementLocated(channelField));
        channel.click();
        channel.sendKeys(Keys.ENTER);
        WebElement channelSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(channelSelect));
        channelSelectElement.click();
        Thread.sleep(3000);
    }

    public void selectSubChannel() throws InterruptedException {
        WebElement subChannel = mywait.until(ExpectedConditions.visibilityOfElementLocated(subChannelField));
        subChannel.click();
        subChannel.sendKeys("AKSUBCHAN1");
        Thread.sleep(3000);
        WebElement subChannelSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subChannelSelect));
        subChannelSelectElement.click();
        
       // System.out.println(subChannel.getText());
        
        
        //subChannel.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void clickMotivationTypes() throws InterruptedException {
        WebElement motivationType = mywait.until(ExpectedConditions.presenceOfElementLocated(motivationTypeField));
        motivationType.click();
        motivationType.sendKeys("AKMOTTYPE1");
        Thread.sleep(3000);
        WebElement motivationTypeSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(motivationSelect));
        motivationTypeSelectElement.click();
        
    }
}

