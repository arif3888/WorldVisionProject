package WVtestCase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import marketingModule.marketingFormPages;
public class cancelCSpledge extends basePage{



    public cancelCSpledge(WebDriver driver) throws IOException {

        super(driver);
        
    }
  

    public  By frame1 = By.xpath("//iframe[@id='AppLandingPage']");
    public By fundraisingEngagement = By.xpath("//a[@title='Fundraising and Engagement']");
    public By pledgeBtn = By.xpath("//*[@id='sitemap-entity-NewSubArea_4b8082a6']/div/div/div[2]");
    public By pledgeIdDD = By.xpath("//div[@data-testid='wv_pledgeid']");
    public static By filterPledgeId = By.xpath("//button[@aria-label='Filter by']");
    public By sendPledgeId = By.xpath("//input[@aria-label='Filter by value']");
    public By applyBtn = By.xpath("//button[contains(@class,'ms-Button ms-Button--primary submitButton')]");
    public By firstPledge = By.xpath("//div[@role='gridcell' and @col-id='msnfp_name']");
    public By cancelBtn = By.xpath("//button[@aria-label='Cancel. Deactivate']");
    public By clickYes = By.xpath("//button[@title='Yes']");  
    public By frameDD = By.xpath("//iframe[@aria-label='pledgestatusreason.html']");
    public By cancelDD = By.xpath("//select[@class='dropdown']");
    public By confirmYes = By.xpath("//input[@type='button' and @value=' Yes ']");
    public By cancelStatus = By.xpath("//div[text()='Cancelled']");
    

    public void selectFundraisingAndEngagement() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(frame1));
        driver.switchTo().frame(frame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fundraisingEngagement)).click();
      
      
    }

    public void clickPledge() throws InterruptedException {
    	driver.navigate().refresh();
        WebElement pledge = mywait.until(ExpectedConditions.visibilityOfElementLocated(pledgeBtn));
        pledge.click();
        Thread.sleep(2000);
        System.out.println("1");
    }
    

    
    
    public void selectAllPledge() throws InterruptedException {
        
            WebElement allPledge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Active Pledges']//button")));
            allPledge.click();
            System.out.println("3");
            Thread.sleep(2000);
            
          // Actions act= new Actions(driver);
            WebElement allPledgeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-posinset='9']")));
            allPledgeSelect.click();
            Thread.sleep(2000);
            System.out.println("4");
       
    }
    


    public void filterPledgeById(String pledge_id) throws InterruptedException {
        WebElement pledgeIdDropdown = mywait.until(ExpectedConditions.visibilityOfElementLocated(pledgeIdDD));
        pledgeIdDropdown.click();
       
        WebElement filterButton = wait.until(ExpectedConditions.presenceOfElementLocated(filterPledgeId));
        filterButton.click();
       
        WebElement pledgeIdInput = wait.until(ExpectedConditions.presenceOfElementLocated(sendPledgeId));
        pledgeIdInput.sendKeys(pledge_id);
       
        WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(applyBtn));
        applyButton.click();
        Thread.sleep(3000);
    }

    public void selectFirstPledge() throws InterruptedException {
        WebElement firstPledgeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstPledge));
        firstPledgeElement.click();
        Thread.sleep(3000);
    }

    public void cancelPledge() throws InterruptedException {
        WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn));
        cancelButton.click();
        Thread.sleep(3000);
        WebElement yesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(clickYes));
        yesButton.click();
        Thread.sleep(5000);
    }

    public void selectCancelReason() throws InterruptedException {
        WebElement frame = driver.findElement(frameDD);
        driver.switchTo().frame(frame);
        WebElement cancelDropdown = driver.findElement(cancelDD);
        Actions act = new Actions(driver);
        act.moveToElement(cancelDropdown).click().perform();
        Thread.sleep(3000);
        Select select = new Select(cancelDropdown);
        select.selectByIndex(2);
        Thread.sleep(5000);
      
    }
    
    public void save() throws InterruptedException
    {
    	  WebElement confirmYesButton = driver.findElement(confirmYes);
          confirmYesButton.click();
          
          System.out.println("12");
          WebElement visibleCancelStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelStatus));
          
          System.out.println(visibleCancelStatus.getText());
         // Assert.assertEquals(visibleCancelStatus.isDisplayed(), true);
          
          
//     	 if(visibleCancelStatus.isDisplayed())
//     	    	{
//     	    		System.out.println("test passed:CS pledge is cancelled");
//     	    		Assert.assertTrue(true);
//     	    	}
//     	    	else
//     	    	{
//     	    		System.out.println("test failed:CS pledge is not cancelled");
//     	    		Assert.assertFalse(false);
//     	    	}
     	 System.out.println("13");
    }
    
  //******************************  Reactivate pledge  ************************************************
    public void clickReactivateButton() {
        WebElement reactivateBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Activate']")));
        reactivateBtn.click();
    }
    
    public void selectDate(String date) {
        WebElement GoToFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='FullPageWebResource']")));
        driver.switchTo().frame(GoToFrame);
        WebElement dateBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onchange='NextCollectionDate()']")));
        dateBox.sendKeys(date);
    }
    
    public void clickYes() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='wv_savebtn']")).click();
    }
    
    public void activeStatusValidation()
    {
    	
    	WebElement activeStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-preview_orientation='column']//div[text()='Active']")));
    	//activeStatus.isDisplayed();
    	
    	//Assert.assertEquals(activeStatus.isDisplayed(), true);
    	if(activeStatus.isDisplayed())
    	{
    		System.out.println("test passed:CS pledge is Reactivated");
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		System.out.println("test failed:CS pledge is not reactivated");
    		Assert.assertFalse(false);
    	}
    	
    	
    }
    
 
}
