package WVtestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class realTimeJourney {

	public WebDriver driver;
	public marketingFormPages marketing;
	public leadCreation leadCreation;
	public  Actions actions;
	  public  Wait<WebDriver> wait;
	  public JavascriptExecutor js;
	  public Robot robot;
	  
	   public realTimeJourney(WebDriver driver) throws IOException, AWTException
	   {
			//super(driver);
    	   this.driver = driver;
          // this.mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
           this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50L))
                   .pollingEvery(Duration.ofSeconds(5L));
    	this.marketing=new marketingFormPages(driver);
    	this.leadCreation=new leadCreation(driver);
    	this.actions=new Actions(driver);
    	this.js = (JavascriptExecutor) driver;
    	robot=new Robot();
	   }
	   
	   
	   public static By engagementArea = By.xpath("//div[@title='Engagement']");
	   public static By journeyEntity = By.xpath("//div[@title='Journeys']");
	   public static By newJourneyBtn = By.xpath("//button[@aria-label='New journey']");
	   public static By skipBtn = By.xpath("//span[contains(text(),'Skip and create from blank')]");
	   public static By segmentBasedSelection = By.xpath("//*[@id=\"createjourneydialog\"]/div[1]/div/div[3]/div/div/div[2]/div/div/div[1]/label");
	   public static By selectSegmentLookUp = By.xpath("//input[@aria-label='Select a segment undefined, Lookup']");
	   public static By staticAudienceFrequency = By.xpath("//span[contains(@id,'OneTime')]");
	   public static By editBtn = By.xpath("//button[@aria-label='Edit']");
	   public static By timeZone = By.xpath("//input[@aria-label='Select a timezone']");
	   public static By startDate =By.xpath("//div[@aria-label='Start']//div[contains(@data-testid,'journey-start')]//div[@aria-label='Start']");
	   public static By startTime = By.xpath("//button[@aria-label='Start time']");
	   public static By createBtn = By.xpath("//button[@data-testid='create-journey-button']//span[contains(text(),'Create')]");
	   public static By addActionBtn = By.xpath("//button[@title='Add an action']");
	   public static By clickEmail = By.xpath("//div[@aria-label='Email Send an email']");
	   public static By selectEmailLookup = By.xpath("//input[@aria-label='Select email undefined, Lookup']");
	   public static By saveBtn = By.xpath("//i[@data-icon-name='Save']");
	   public static By publishBtn = By.xpath("//button[@aria-live='polite']");
	 
	 
	 

	   public  void selectMarketingModule() throws InterruptedException
	    {
	    	marketing.selectMarketingModule();
	    }
	    
	    public  void switchArea() throws InterruptedException
	    {
	    	
	    	js.executeScript("return document.readyState").equals("complete");
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(engagementArea)).click();
	    	marketing.clickCopilot();

	    }
	    

	    public void selectJourneyEntity() {
	        WebElement journeyentity=wait.until(ExpectedConditions.visibilityOfElementLocated(journeyEntity));
	        Assert.assertTrue(journeyentity.isDisplayed(), "Journey entity is not visible");
	        journeyentity.click();
	    }

	    public void selectNewJourney() {
	        js.executeScript("return document.readyState").equals("complete");
	       
	        WebElement newJourney=wait.until(ExpectedConditions.visibilityOfElementLocated(newJourneyBtn));
	        Assert.assertTrue(newJourney.isDisplayed(), "New journey button is not clicked");
	        newJourney.click();
	       
	    }

	    public void clickSkipButton() throws InterruptedException {
	        WebElement skip=wait.until(ExpectedConditions.visibilityOfElementLocated(skipBtn));
	        Assert.assertTrue(skip.isDisplayed(), "Skip button is not clicked");
	        skip.click();
	    }

	    public void createJourney() throws InterruptedException {
	        js.executeScript("return document.readyState").equals("complete");
	        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'TextField')]")));
	        name.click();
	        Assert.assertTrue(name.isDisplayed(), "Name input field is not visible");
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(4000);
	        
	        WebElement segmentSelect=wait.until(ExpectedConditions.visibilityOfElementLocated(segmentBasedSelection));
	        Assert.assertTrue(segmentSelect.isDisplayed(), "Segment based selection is not visible");
	        segmentSelect.click();
	        Thread.sleep(3000);

	        js.executeScript("return document.readyState").equals("complete");
	        WebElement segment = wait.until(ExpectedConditions.visibilityOfElementLocated(selectSegmentLookUp));
	        Assert.assertTrue(segment.isDisplayed(), "Segment lookup is not visible");
	        segment.click();
	        Thread.sleep(4000);
	        segment.sendKeys("ticktick");
	        Thread.sleep(3000);
	        segment.sendKeys(Keys.ENTER);

	        WebElement edit=wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn));
	        Assert.assertTrue(edit.isDisplayed(), "Edit button is not clicked");
	        edit.click();
	        js.executeScript("return document.readyState").equals("complete");

	        WebElement time = wait.until(ExpectedConditions.visibilityOfElementLocated(timeZone));
	        Thread.sleep(5000);
	        Assert.assertTrue(time.isDisplayed(), "Time zone input field is not visible");
	        time.click();
	        Thread.sleep(4000);
	        time.sendKeys("(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi");
	        Thread.sleep(4000);
	        time.sendKeys(Keys.ENTER);

	        Thread.sleep(10000);

	        WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(startDate));
	        Assert.assertTrue(date.isDisplayed(), "Start date input field is not visible");
	        date.click();
	        Thread.sleep(3000);
	        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='17']")));
	        actions.moveToElement(calendar);
	        Assert.assertTrue(calendar.isDisplayed(), "Calendar date is not selected");
	        actions.click().perform();
	        

	        WebElement time1 = wait.until(ExpectedConditions.visibilityOfElementLocated(startTime));
	        time1.click();
	        Assert.assertTrue(time1.isDisplayed(), "Start time input field is not visible");
	        Thread.sleep(3000);
	        time1.sendKeys("6:00 PM");
	        Thread.sleep(4000);
	        time1.sendKeys(Keys.ENTER);

	        wait.until(ExpectedConditions.visibilityOfElementLocated(createBtn)).click();
	        
	    }

	    public void journeyDesign() throws InterruptedException {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Exit')]"))).click();
	        

	        WebElement add=wait.until(ExpectedConditions.visibilityOfElementLocated(addActionBtn));
	        Assert.assertTrue(add.isDisplayed(), "Add action button is not clicked");
	        add.click();
	        
	        WebElement selectEmail=wait.until(ExpectedConditions.visibilityOfElementLocated(clickEmail));
	        Assert.assertTrue(selectEmail.isDisplayed(), "Email template is not visible");
	        selectEmail.click();
	        
	      
				WebElement emailSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(selectEmailLookup));
				Assert.assertTrue(emailSelect.isDisplayed(), "Email lookup is not visible");
				emailSelect.sendKeys("Arif Emaill Automate");
				Thread.sleep(6000);
				emailSelect.sendKeys(Keys.ENTER);
				
				Thread.sleep(8000);
//				String enteredText = emailSelect.getAttribute("title");
//				
//				Assert.assertEquals(enteredText, "The text entered is incorrect");
			

	        
	    }

	    public void savePublish() throws InterruptedException {
	    	Thread.sleep(4000);
	        WebElement save1=wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
	       
//	        Assert.assertTrue(save.isDisplayed(), "Save button is not visible");
	        save1.click();
	        Thread.sleep(5000);
	        WebElement publish=wait.until(ExpectedConditions.visibilityOfElementLocated(publishBtn));
	        publish.click();
	       
	        Thread.sleep(3000);
	        WebElement skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Skip')]")));
	        Assert.assertTrue(skip.isDisplayed(), "publish button is not clicked");
	        skip.click();
	    }


	}