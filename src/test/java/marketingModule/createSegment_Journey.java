package marketingModule;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class createSegment_Journey {

	public WebDriver driver;
	public marketingFormPages marketing;
	public leadCreation leadCreation;
	public  Actions actions;
	  public  Wait<WebDriver> wait;
	  public JavascriptExecutor js;
	  
	   public createSegment_Journey (WebDriver driver) throws IOException
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
	   }
	   
	   //Segment
	   public static By customerArea = By.xpath("//li[@title='Customers']");
	   public static By segmentEntity = By.xpath("//li[@title='Segments']");
	   public static By staticSegment = By.xpath("//span[contains(text(),'New Static Segment')]");
	   public static By segmentName = By.xpath("//input[@aria-label='Name']");
	   public static By segmentDescription = By.xpath("//textarea[@aria-label='Description. Recommended.']");
	   public static By segmentTimeZone = By.xpath("//select[@aria-label='Time Zone']");
	   public static By saveBtn = By.xpath("//button[@aria-label='Save and Close']");
	   public static By addContact = By.xpath("//button[@aria-label='Add']");
	   public static By contactLookup = By.xpath("//input[@aria-label='Select record, Multiple Selection Lookup']");
	   public static By addBtnContact = By.xpath("//button[@id='lookupDialogSaveBtn']");
	   
	   //Customer Journey
	   public static By marketingExecutionArea = By.xpath("//div[@title='Marketing execution']");
	   public static By customerJourneyEntity = By.xpath("//div[@title='Customer journeys']");
	   public static By skipBtn = By.xpath("//button[@aria-label='Skip']");
	   public static By setAuditionPlusBtn = By.xpath("//span[@role='button'][contains(text(),'')]");
	   public static By selectSegment = By.xpath("//input[@title='Select to enter data']");
	   public static By addTile = By.xpath("//button[@title='Add tile']");
	   public static By tileSendEmail = By.xpath("/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[2]/ul[1]/ul[1]/div[2]/li[1]");
	   public static By emailLookUp = By.xpath("//input[@aria-label='Email, Lookup']");
	   public static By generalTab = By.xpath("//li[@title='General']");
	 
	   
	   
//****************************************************SEGMENT*************************************************************************************	   
	   
	   public  void selectMarketingModule() throws InterruptedException
	    {
	    	marketing.selectMarketingModule();
	    }
	    
	    public  void switchArea() throws InterruptedException
	    {
	    	
	    	js.executeScript("return document.readyState").equals("complete");
	    	Thread.sleep(7000);
	    	marketing.switchArea();
	    	marketing.clickCopilot();

	    }
	    public void selectCustomerArea() throws InterruptedException
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(customerArea)).click();
	    	 Thread.sleep(2000);
	    	
	    }
	    
	    public void selectSegementEntity()
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(segmentEntity)).click();
	    	
	    	
	    }
	    
	    public void clickNew() throws InterruptedException
	    {
	    	marketing.clickNewButton();
	    	Thread.sleep(2000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(staticSegment)).click();
	    }
	    
	    public void createSegmentDetails() throws InterruptedException
	    {
	    	WebElement nameDetails=wait.until(ExpectedConditions.visibilityOfElementLocated(segmentName));
	    	nameDetails.sendKeys("Arif Automate Segment" + RandomStringUtils.randomAlphabetic(5));
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(segmentDescription)).sendKeys("testing");
	    	
	    	WebElement selectTimeZone=wait.until(ExpectedConditions.visibilityOfElementLocated(segmentTimeZone));
	    	selectTimeZone.click();
	    	Thread.sleep(3000);
	    	Select select=new Select(selectTimeZone);
	    	 select.selectByVisibleText("(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi");
	    	//select.selectByValue("198");
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
	    	Thread.sleep(5000);
	    }
	    
	    public void addContactInSegment() throws InterruptedException
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(addContact)).click();
	    	
	    	WebElement lookUp=wait.until(ExpectedConditions.visibilityOfElementLocated(contactLookup));
	    	lookUp.sendKeys("Arif Ahmad");
	    	Thread.sleep(5000);
	    	lookUp.sendKeys(Keys.ENTER);
	    	Thread.sleep(3000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(addBtnContact)).click();
	    	
	    }
	    
	    public void goLiveClick()
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Go live']"))).click();
	    }
	    
	    
//*********************************************CUSTOMER JOURNEY************************************************************************	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
