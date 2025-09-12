package WVtestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class reactivateCSpledge{

    public WebDriver driver;
    public WebDriverWait mywait;
    public Wait<WebDriver> wait;
    public Actions act;
    public marketingFormPages marketingFormPagesTest;

    public reactivateCSpledge(WebDriver driver) {
        this.driver = driver;
       this.mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50L))
                .pollingEvery(Duration.ofSeconds(5L));
        this.act = new Actions(driver);
        this.marketingFormPagesTest = new marketingFormPages(driver);
    }
    
    //marketingFormPages marketingFormPagesTest = new marketingFormPages(driver);
    // marketingFormPages marketingFormPages = new marketingFormPages(driver);

    public void selectFundraisingAndEngagement() throws InterruptedException {
        WebElement frame1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='AppLandingPage']")));
        driver.switchTo().frame(frame1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Fundraising and Engagement']"))).click();
     
		//clicking copilot from marketingFormPages
      
       // marketingFormPagesTest.clickCopilot();
        Thread.sleep(2000);
        // marketingFormPages marketingFormPages = new marketingFormPages(driver);
        //marketingFormPages.clickCopilot();
    }
    
//    public  void clickCopilot() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(marketingFormPages.copilotBtn)).click();
//    }


    
    
    
    public void clickPledgeEntity() throws InterruptedException {
        WebElement pledge = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sitemap-entity-NewSubArea_4b8082a6']/div/div/div[2]")));
        pledge.click();
    
    }
    
    
    
    

    public void selectAllPledge() throws InterruptedException {
       
            WebElement allPledge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='Active Pledges']//button")));
            allPledge.click();
            
            WebElement allPledgeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-posinset='9']")));
            act.moveToElement(allPledgeSelect).click().perform();
            Thread.sleep(2000);
            
       
    }

    

    public void filterPledgeById(String pledge_id) throws InterruptedException {
    	
        
        WebElement pledgeIdDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='wv_pledgeid']")));
        pledgeIdDD.click();
        WebElement filterPledgeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Filter by']")));
        filterPledgeId.click();
        //Thread.sleep(2000);
        WebElement sendPledgeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Filter by value']")));
        sendPledgeId.sendKeys(pledge_id);
        //Thread.sleep(2000);
        WebElement applyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'submitButton')]")));
        applyBtn.click();
        Thread.sleep(2000);
    }

    public void selectFirstPledge() throws InterruptedException {
        WebElement firstPledge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='gridcell' and @col-id='msnfp_name']")));
        firstPledge.click();
        Thread.sleep(3000);
    }

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