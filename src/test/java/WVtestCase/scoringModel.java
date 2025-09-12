package WVtestCase;

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
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;


public class scoringModel {
	
	public WebDriver driver;
	public marketingFormPages marketing;
	public  Actions actions;
	  public  Wait<WebDriver> wait;
	  public JavascriptExecutor js;
	  
	  

    public scoringModel(WebDriver driver) {
    	//super(driver);
    	   this.driver = driver;
          // this.mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
           this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50L))
                   .pollingEvery(Duration.ofSeconds(5L));
    	this.marketing=new marketingFormPages(driver);
    	this.actions=new Actions(driver);
    	this.js = (JavascriptExecutor) driver;
    	
    }

    public static By leadManagement = By.xpath("//li[@aria-label='Lead management']");
    public static By scroingModelEntity = By.xpath("//li[@title='Scoring models']");
    public static By conditionDrag = By.xpath("//li[@title='Condition']");
    public static By plusAdd = By.xpath("//button[@title=' Add ']");
    public static By plusCanvasDesign = By.xpath("//div[@id='canvas']/div");
    public static By plusAction = By.xpath("//li[@title='Add new Action']");
    public static By plusCondition = By.xpath("//li[@title='Add new Condition']");
    public static By displayNamefirst = By.xpath("//input[@id='ruleNameTextEdit']");
    public static By tileButton = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]/button[1]/span[1]");
    public static By clickUntitledCondition = By.xpath("//*[@id=\"detail-container-root_2\"]/ul/li/div"); 
    public static By displayName = By.xpath("//*[@id=\"nameTextEdit\"]");
    public static By entityField = By.xpath("//*[@id=\"entityPickerTextEdit\"]");
    public static By frequency = By.xpath("//select[@id='qualifier-valueDropDown']");
    public static By count = By.xpath("//*[@id=\"qualifier-countNumberEdit\"]");
    public static By dateRange=By.xpath("//*[@id=\"time-dimension-periodDropDown\"]");
    public static By rangeDay=By.xpath("//div[@class='property-page-elements property-pages__time-dimension--custom']//select[@id='time-dimension-periodDropDown']");
    public static By field=By.xpath("//select[contains(@id,'fieldPicker')]");
    public static By value=By.xpath("//input[@aria-label='Message, Lookup']");
    public static By plusOnCanvas=By.xpath("//div[@id='canvas']/div[2]");
    public static By scoreUpdateAction=By.xpath("//*[@id=\"action-valueNumberEdit\"]");
    public static By gradesTab=By.xpath("//*[@title=\"Grades\"]");
    public static By newBtnGrades=By.xpath("//*[@id=\"button1\"]");
    public static By gradesName=By.xpath("//*[@id=\"grade-nameTextEdit\"]");
    public static By gradesFrom=By.xpath("//*[@id=\"grade-fromNumberEdit\"]");
    public static By gradesTo=By.xpath("//*[@id=\"grade-toNumberEdit\"]");
    public static By nameHeader=By.xpath("//button[@title='More Header Editable Fields']");
    public static By name=By.xpath("//input[@aria-label='Name']");
    public static By saveBtn=By.xpath("//button[@title='Save' and @tabindex='-1']");
    public static By liveBtn=By.xpath("//button[@aria-label='Go live model']");

 
 

    
    
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
    public void selectLeadManagement() throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(leadManagement)).click();
    	 Thread.sleep(2000);
    	
    }
    
    public void selectScoringModelEntity()
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(scroingModelEntity)).click();
    	marketing.clickNewButton();
    }
    
    public void dragAndDrop()
    {
    	 WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionDrag));
         WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(plusCanvasDesign));
         
         actions.dragAndDrop(sourceElement, targetElement).perform();
    }
    
    public void fillDetailConditionTool() throws InterruptedException
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(displayNamefirst)).sendKeys("Send Email");
  	    wait.until(ExpectedConditions.visibilityOfElementLocated(tileButton)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(clickUntitledCondition)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(displayName)).sendKeys("If leads has received the email.");
    	
    	
//    	WebElement dropdownEntity= wait.until(ExpectedConditions.visibilityOfElementLocated(entityField));
//    	dropdownEntity.click();
//    	dropdownEntity.sendKeys("Email delivered");
    	
    	
    	// Wait for the dropdown entity to be visible
    	WebElement dropdownEntity = wait.until(ExpectedConditions.visibilityOfElementLocated(entityField));
    	
    	// Assert that the dropdown entity is displayed
    	Assert.assertTrue(dropdownEntity.isDisplayed(), "Dropdown entity is not visible");
    	
    	// Click on the dropdown entity
    	dropdownEntity.click();
    	
    	// Send keys to the dropdown entity
    	dropdownEntity.sendKeys("Email delivered");
    	js.executeScript("return document.readyState").equals("complete");
    	
    	
    	Thread.sleep(8000);
    	dropdownEntity.sendKeys(Keys.ENTER);
    	
    	// Verify that the text "Email delivered" has been entered
    	String enteredText = dropdownEntity.getAttribute("value");
    	Assert.assertEquals(enteredText, "Email delivered", "The text entered in the dropdown entity is incorrect");
    	
  
    	WebElement frequencyField=wait.until(ExpectedConditions.visibilityOfElementLocated(frequency));
    	frequencyField.click();
    	Thread.sleep(3000);
    	frequencyField.sendKeys("At least");
    	Thread.sleep(4000);
    	frequencyField.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	
    	
   	    WebElement countField=wait.until(ExpectedConditions.visibilityOfElementLocated(count));
    	countField.click();
    	countField.sendKeys("1");
    	Thread.sleep(1000);
    	
    	WebElement dateRangeField=wait.until(ExpectedConditions.visibilityOfElementLocated(dateRange));
    	dateRangeField.click();
    	dateRangeField.sendKeys("Custom");
    	dateRangeField.sendKeys(Keys.ENTER);
    	
    	WebElement dayRange=wait.until(ExpectedConditions.visibilityOfElementLocated(rangeDay));
    	dayRange.sendKeys("day");
    	Thread.sleep(2000);
    	

    	
    	actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
    	Thread.sleep(3000);


    	WebElement fieldValue=wait.until(ExpectedConditions.presenceOfElementLocated(field));
        fieldValue.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@id,'fieldPicker')]/option[6]"))).click();
    	Thread.sleep(2000);
    	fieldValue.click();

    	
    	
    	WebElement valueMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(value));
    	valueMessage.click();
    	Thread.sleep(5000);
    	valueMessage.sendKeys("Email 1nk (Blank)");
    	Thread.sleep(5000);
    	
    	valueMessage.sendKeys(Keys.ENTER);
   
    }
    
    public void clickPlus()
    {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(plusAdd)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(plusAction)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(plusOnCanvas)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(scoreUpdateAction)).sendKeys("10");
    }
    
    public void gradesFill()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(gradesTab)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnGrades)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(gradesName)).sendKeys("Cold Lead");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(gradesFrom)).sendKeys("0");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(gradesTo)).sendKeys("249");
    }
    
    public void nameFill() throws InterruptedException
    {
    	wait.until(ExpectedConditions.elementToBeClickable(nameHeader)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(name)).sendKeys("Arif Automations" + " " + RandomStringUtils.randomAlphabetic(5));
    	driver.findElement(saveBtn).click();
    	
    	Thread.sleep(5000);
    	driver.findElement(liveBtn).click();
    }
}
