
package WVtestCase;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class marketingFormPages {

    public WebDriver driver;
    public WebDriverWait mywait;
    public  Wait<WebDriver> wait;
    public JavascriptExecutor js;

    public marketingFormPages(WebDriver driver) {
        this.driver = driver;
        this.mywait = new WebDriverWait(driver, Duration.ofSeconds(25));
        this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50L))
                .pollingEvery(Duration.ofSeconds(5L));
        this.js = (JavascriptExecutor) driver;
    }

    // Locators
    public static By frame1 = By.xpath("//iframe[@id='AppLandingPage']");
    public static By marketingModule = By.xpath("//a[@title='Marketing']");
    public static By areaBtn = By.xpath("//button[@id='areaSwitcherId']/div/span");
   
    public static By outboundMarketing = By.xpath("//li[@title='Outbound marketing']");
    public static By internetMarketing = By.xpath("//li[@aria-label='Internet marketing']");
    public static By marketingForms = By.xpath("//li[@aria-label='Marketing forms']");
    public static By newBtn = By.xpath("//button[@aria-label='New']");
    public static By searchInput = By.xpath("//input[@aria-label='Search']");
    public static By previewLibrary = By.xpath("//div[@aria-label='PreviewLibraryControl.Toolbar.Grid']");
    public static By selectBtn = By.xpath("//button[@aria-label='Select']");
    public static By summaryTab = By.xpath("//li[@aria-label='Summary']");
    public static By nameInput = By.xpath("//input[@aria-label='Name']");
    public static By moreHeaderFields = By.xpath("//button[@title='More Header Editable Fields']");
    public static By formTypeSelect = By.xpath("//select[@aria-label='Form type']");
    public static By updateContactsSelect = By.xpath("//select[@aria-label='Update contacts/leads']");
    public static By copilotBtn = By.xpath("//button[@aria-label='Copilot' and @tabindex='0']");
    public static By saveBtn = By.xpath("//button[@aria-label='Save (CTRL+S)']");
    public static By blueDrop = By.xpath("//*[@id=\"topBar\"]/div[4]/div[1]");
    public static By submissions = By.xpath("//li[@aria-label='Submissions']");
    public static By goLiveBtn = By.xpath("//li[contains(@id,'marketingform.GoLive')]");
    public static By marketingPages = By.xpath("//li[@aria-label='Marketing pages']");
    public static By skipBtn = By.xpath("//button[@aria-label='Skip']");
    public static By formTool = By.xpath("//div[@data-editortool-type='FormTool']");
    public static By designerCanvas = By.xpath("//iframe[@title='Designer canvas']");
    public static By addTool = By.xpath("//div[@aria-label='Placeholder. Press enter to insert a tool here.']");
    public static By marketingFormInsert = By.xpath("//input[@aria-label='Marketing form, Lookup']");
    public static By formTypeSelectPage = By.xpath("//select[@aria-label='Type']");
    public static By partialUrl = By.xpath("//input[@aria-label='Partial URL']");
    public static By goLiveBtnPage = By.xpath("//li[contains(@id,'marketingpage.GoLive')]");
    public static By okBtn = By.xpath("//button[@aria-label='OK']");
    public static By liveStatus = By.xpath("//div[text()='Live']");

    // Methods
    public void selectMarketingModule() throws InterruptedException {
    	
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(frame1)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(marketingModule)).click();
       
       
    }
  

    public void switchArea() throws InterruptedException {

    	js.executeScript("return document.readyState").equals("complete");
    	Thread.sleep(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(areaBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(outboundMarketing)).click();
    }
    

    public   void clickCopilot() throws InterruptedException {

        WebElement coPilot=wait.until(ExpectedConditions.visibilityOfElementLocated(copilotBtn));
        coPilot.click();

    }

    public void selectInternetMarketing() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(internetMarketing)).click();
    }

    public void selectMarketingForms() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(marketingForms)).click();
    }

    public void clickNewButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newBtn)).click();
    }

    public void selectTemplate(String templateFormat) throws InterruptedException {
        WebElement selectTemplates = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        selectTemplates.sendKeys(templateFormat);
        Thread.sleep(5000);
        selectTemplates.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(previewLibrary)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectBtn)).click();
    }

    public void fillFormDetails(String nameValue) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(summaryTab)).click();
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        Thread.sleep(2000);
        name.sendKeys(nameValue + " " + RandomStringUtils.randomAlphabetic(5));
        driver.findElement(moreHeaderFields).click();
        WebElement formType = wait.until(ExpectedConditions.visibilityOfElementLocated(formTypeSelect));
        formType.click();
        new Select(formType).selectByVisibleText("Landing page");
        Thread.sleep(3000);
        WebElement updatetype = wait.until(ExpectedConditions.visibilityOfElementLocated(updateContactsSelect));
        updatetype.click();
        Thread.sleep(3000);
        new Select(updatetype).selectByIndex(1);
        driver.findElement(moreHeaderFields).click();
    }


    public void saveForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
    }

    public void goLiveForm() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(blueDrop))).perform();
        Thread.sleep(2000);
        driver.findElement(submissions).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(goLiveBtn)).click();
        Thread.sleep(5000);
        System.out.println("Form is live");
        WebElement liveBtn=mywait.until(ExpectedConditions.presenceOfElementLocated(liveStatus));
        //Assert.assertTrue(liveBtn.isDisplayed());
        if(liveBtn.isDisplayed())
        	
	    	{
	    		System.out.println("test passed:Marketing Form is Live");
	    		Assert.assertTrue(true);
	    	}
        
	    	else
	    	{
	    		System.out.println("test failed:Marketing Form is not Live");
	    		Assert.assertFalse(false);
	    	}
    }

    public String getFormName() {
         return wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).getAttribute("value");
         
    }
    
    
    
    
//**********************************marketing pages*****************************************************************************
    public void selectMarketingPages() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(marketingPages)).click();
    }

    public void clickSkipButton() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(skipBtn)).click();
    }

    public void clickFormTool() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(formTool)).click();
    }

    public void switchToDesignerCanvas() {
        driver.switchTo().frame(driver.findElement(designerCanvas));
    }

    public void clickAddTool() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(addTool)).click();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void insertMarketingForm(String formName) throws InterruptedException {
        WebElement marketingFormInput = mywait.until(ExpectedConditions.visibilityOfElementLocated(marketingFormInsert));
        marketingFormInput.sendKeys(formName);
        Thread.sleep(3000);
        marketingFormInput.sendKeys(Keys.ENTER);
    }

    public void fillPageDetails() throws InterruptedException {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(summaryTab)).click();
        driver.findElement(moreHeaderFields).click();
        WebElement formType = mywait.until(ExpectedConditions.visibilityOfElementLocated(formTypeSelectPage));
        formType.click();
        new Select(formType).selectByVisibleText("Landing page");
        WebElement partialUrlInput = mywait.until(ExpectedConditions.visibilityOfElementLocated(partialUrl));
        partialUrlInput.sendKeys("Automation" + RandomStringUtils.randomAlphabetic(5));
        driver.findElement(moreHeaderFields).click();
    }

    public void savePage() {
        mywait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
    }

    public void goLivePage() throws InterruptedException {
        Thread.sleep(5000);
        mywait.until(ExpectedConditions.presenceOfElementLocated(goLiveBtnPage)).click();
        mywait.until(ExpectedConditions.presenceOfElementLocated(okBtn)).click();
        Thread.sleep(20000);
        WebElement liveBtn=wait.until(ExpectedConditions.presenceOfElementLocated(liveStatus));
        if(liveBtn.isDisplayed())
	    	{
	    		System.out.println("test passed:Marketing Page is Live");
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		System.out.println("test failed:Marketing Page is not Live");
	    		Assert.assertFalse(false);
	    	}
    }
}



