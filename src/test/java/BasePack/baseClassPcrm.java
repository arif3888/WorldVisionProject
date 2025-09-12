package BasePack;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClassPcrm {
	public static WebDriver driver;

	
	public void driverSetupCrm() throws InterruptedException 
	{
//         ChromeOptions options=new ChromeOptions();
//		  options.addArguments("--headless");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://pcrmqa.crm.dynamics.com/");
		// Implicit wait
		//driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		// Login to CRM application
		driver.findElement(
				By.xpath("//div[@aria-label='Sign in with arif.ahmad@consultant.wvi.org work or school account.']"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("arif.ahmad@consultant.wvi.org");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/form/div/div[3]/div/button"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Arif@1189");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/form/div/div[3]/div/button"))
				.click();
		Thread.sleep(15000);

	}

	
	public void close()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}
	
	public void driverSetupBC()
	{
		driver=new ChromeDriver();
		driver.get("https://businesscentral.dynamics.com/b951e030-af38-40d7-bd0b-fbed3c87653a/Sandbox ");
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		driver.manage().window().maximize();
	}
	
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	
}
