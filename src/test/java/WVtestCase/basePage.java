package WVtestCase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class basePage {

	
	public WebDriver driver;
	public Wait<WebDriver> wait;
	public WebDriverWait mywait;
	public Properties prop;
	public FileReader File;
	public refundPayment refund;
	
	
	public basePage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		 this.wait = new FluentWait<WebDriver>(driver)
	    	       .withTimeout(Duration.ofSeconds(50L))
	    	       .pollingEvery(Duration.ofSeconds(5L));
		 this.mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 File=new FileReader(".//src//test//resources//config.properties");
			prop=new Properties();
			prop.load(File);
			this.refund= new refundPayment(driver);
	}
}
