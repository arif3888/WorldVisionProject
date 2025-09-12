package WVtestCase;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class motivationCode {

    public WebDriver driver;
    public WebDriverWait mywait;
    public Wait<WebDriver> wait;
    
    public motivationCode(WebDriver driver) {
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
    public By motivationBtn = By.xpath("//*[@id='sitemap-entity-NewSubArea_e3222871']/div/div/div[2]");
    public By newButton = By.xpath("//button[@aria-label='New']");
    public By nameField = By.xpath("//input[@aria-label='Name']");
    public By channelField = By.xpath("//input[@aria-label='Channel, Lookup']");
    public By channelSelect = By.xpath("//li[@aria-label='AKCHANNEL1, 10/10/2022 9:21 PM']");
    public By saveButton = By.xpath("//button[@aria-label='Save (CTRL+S)']");
    private By doneButton = By.xpath("//button[@title='Done']");

    public void selectFundraisingAndEngagement() {
    	driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(frame1)));
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(fundraisingEngagement)).click();
        
    }
   
    public void switchToFundraisingArea() {
    	driver.navigate().refresh();
        WebElement switchArea = wait.until(ExpectedConditions.presenceOfElementLocated(areaBtn));
        switchArea.click();
        WebElement area = wait.until(ExpectedConditions.presenceOfElementLocated(configuration));
        area.click();
    }

    public void clickMotivationTypes() {
        WebElement motivationType = mywait.until(ExpectedConditions.presenceOfElementLocated(motivationBtn));
        motivationType.click();
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

    public void selectChannel() throws InterruptedException {
        WebElement channel = mywait.until(ExpectedConditions.visibilityOfElementLocated(channelField));
        channel.click();
        channel.sendKeys(Keys.ENTER);
        
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Advanced']/span"))).click();
        Thread.sleep(3000);
        List<WebElement> lookUpMotiveChannels = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ag-center-cols-container']/div")));
        String selectedChannels="AKCHANNEL1";
        for (WebElement listChannel : lookUpMotiveChannels) {
			
			if (listChannel.getText().contains(selectedChannels)) {

				listChannel.click();
				 Thread.sleep(3000);
				System.out.println("Channel is selected");
				break;
			}
			}
        WebElement doneButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doneButton));
		doneButtonElement.click();
//        WebElement channelSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(channelSelect));
//        channelSelectElement.click();
//        Thread.sleep(3000);
    }

    public void save() {
        driver.findElement(saveButton).click();
    }
}
