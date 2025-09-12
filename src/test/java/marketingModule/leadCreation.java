package marketingModule;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import WVtestCase.basePage;

public class leadCreation extends basePage {
	
	public WebDriver driver;
	public marketingFormPages marketing;
	  public JavascriptExecutor js;
	  
    public leadCreation(WebDriver driver) throws IOException {
    	super(driver);
    	this.marketing=new marketingFormPages(driver);
    	this.js = (JavascriptExecutor) driver;
    }
    
    //Locators
    public static By leadManagement = By.xpath("//li[@aria-label='Lead management']");
    public static By leadEntity = By.xpath("//div[@title='Leads']");
    public static By threeDots= By.xpath("//button[@id='OverflowButton_button4_lead$button']");
    public static By readOnlyGrid= By.xpath("//button[@title='Read Only Grid']");
    public static By topic= By.xpath("//input[@aria-label='Topic']");
    public static By firstName= By.xpath("//input[@aria-label='First Name']");
    public static By lastName= By.xpath("//input[@aria-label='Last Name']"); 
    public static By mobilePhone= By.xpath("//input[@aria-label='Mobile Phone']");
    public static By Email= By.xpath("//input[@aria-label='Email']");
    public static By inquiry= By.xpath("//div[@title='Inquiry'][1]");
    public static By existingContact= By.xpath("//input[@aria-label='Existing Contact?, Lookup']");
    //public static By contactName1= By.xpath("//li[@aria-label='USAO-CNT-113430, Arif Ahmad']");
  
    
    
    public  void selectMarketingModule() throws InterruptedException
    {
    	marketing.selectMarketingModule();
    }
    
    public  void switchArea() throws InterruptedException
    {
    	js.executeScript("return document.readyState").equals("complete");
    	//Thread.sleep(3000);
    	marketing.switchArea();
    	js.executeScript("return document.readyState").equals("complete");
    	marketing.clickCopilot();
    }
		
    public void selectLeadManagement()
    {
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(leadManagement)).click();
    }
    
    public void selectLeadEntity()
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(leadEntity)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(readOnlyGrid)).click();
    	marketing.clickNewButton();
    }
    
    public void fillSummaryForm() throws InterruptedException
    {
    	 WebElement topicField = wait.until(ExpectedConditions.visibilityOfElementLocated(topic));
    	 topicField.sendKeys("Automate check" + RandomStringUtils.randomAlphabetic(5));
    	 Thread.sleep(1000);
    	 
    	 WebElement firtsNamefield = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
    	 firtsNamefield.sendKeys(RandomStringUtils.randomAlphabetic(5));
    	 Thread.sleep(1000);
    	 
    	 WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
    	 lastNameField.sendKeys(RandomStringUtils.randomAlphabetic(5));
    	 Thread.sleep(1000);
    	 
    	 WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobilePhone));
    	 mobileField.sendKeys(RandomStringUtils.randomNumeric(10));
    	 Thread.sleep(1000);
    	 
    	 WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
    	 emailField.sendKeys(RandomStringUtils.randomAlphabetic(6) + "@gmail.com");
    	 Thread.sleep(1000);
    	 
    }
    
    public void inquiryBtn() throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(inquiry)).click();
        WebElement contact=wait.until(ExpectedConditions.visibilityOfElementLocated(existingContact));
        contact.sendKeys("Arif Ahmad");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@aria-label='USAO-CNT-113430, Arif Ahmad']"))).click();

      
        
    }
    
    public void saveBtn()
    {
    	marketing.savePage();
    }
		
	

}
