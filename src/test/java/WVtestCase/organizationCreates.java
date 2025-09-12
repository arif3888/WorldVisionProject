package WVtestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class organizationCreates extends basePage {



	public organizationCreates(WebDriver driver) throws IOException {

		super(driver);
	}

	// Locators
	private By frame1 = By.xpath("//iframe[@id='AppLandingPage']");
	private By fundraisingEngagement = By.xpath("//a[@title='Fundraising and Engagement']");
	private By organizationEntity = By.xpath("//li[@aria-label='Organizations']");
	private By newButton = By.xpath("//button[@aria-label='New']");
	private By organizationName = By.xpath("//input[@aria-label='Organization Name']");
	private By motivationCode = By.xpath("//input[@aria-label='Motivation Code, Lookup']");
	private By motivationList = By.xpath("//li[@aria-label='AKMOTTYPE1-0002, 123']");
	private By contactDetailsSection = By.xpath("//section[@aria-label='CONTACT DETAILS']");
	private By emailField = By.xpath("//input[@aria-label='Email ']");
	private By mobileField = By.xpath("//input[@aria-label='Mobile Phone No']");
	private By addressDetailsTab = By.xpath("//li[@aria-label='Address Details']");
	private By address1Field = By.xpath("//input[@aria-label='Address 1: Street 1']");
	private By city1Field = By.xpath("//input[@aria-label='Address 1: City']");
	private By stateField = By.xpath("//input[@aria-label='Address 1: State/Province']");
	private By zipField = By.xpath("//input[@aria-label='Address 1: ZIP/Postal Code']");
	private By countryField = By.xpath("//input[@aria-label='Address 1: Country , Lookup']");
	private By countryLookup = By.xpath(
			"//span[@data-id='wv_address1_country.fieldControl-LookupResultsDropdown_wv_address1_country_advlookup']");
	private By countryList = By.xpath("//div[@class='ag-center-cols-container']/div");
	private By doneButton = By.xpath("//button[@title='Done']");
	private By billingAddressDropdown = By.xpath("//button[@aria-label='Is billing address same as primary address']");

	public By savedVisibleText = By.xpath("//span[@aria-label='Save status - Saved']");
	public static By copilotBtn = By.xpath("//button[@aria-label='Copilot' and @tabindex='0']");

	// Methods
	public void selectFundraisingAndEngagement() {

		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(frame1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(fundraisingEngagement)).click();
	}

	public void clickOrganizationEntity() throws InterruptedException {

		driver.navigate().refresh();

		WebElement organization = wait.until(ExpectedConditions.visibilityOfElementLocated(organizationEntity));
		organization.click();

	}

	public void clickNewButton() throws InterruptedException {
		driver.findElement(newButton).click();
		Thread.sleep(2000);

		// click AI
		WebElement AIbutton = mywait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='headerBodyContainer']/child::button")));
		AIbutton.click();
		// System.out.println("Ai is clicked");

	}

	public void enterOrganizationDetails() throws InterruptedException {
		WebElement organization = mywait.until(ExpectedConditions.visibilityOfElementLocated(organizationName));
		organization.sendKeys("Arif" + RandomStringUtils.randomAlphabetic(3));

	}

//selecting motivation
	public void selectMotivation(String selectedMotivation) {
		try {
			WebElement motiveCode = wait.until(ExpectedConditions.visibilityOfElementLocated(motivationCode));
			motiveCode.click();
			motiveCode.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(
					"//span[@data-id='wv_motivationid.fieldControl-LookupResultsDropdown_wv_motivationid_advlookup']"))
					.click(); // click advancelookup

			List<WebElement> lookUpMotiveCode = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryList));
	
			for (WebElement listMotive : lookUpMotiveCode) {
				
				if (listMotive.getText().contains(selectedMotivation)) {

					listMotive.click();
					System.out.println("Motivation is selected");
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Motivation code not found");
		}

		WebElement doneButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doneButton));
		doneButtonElement.click();
	}

	public void selectEmail_Mobile(String emal,String mob) {
		WebElement contactDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(contactDetailsSection));
		Actions act = new Actions(driver);
		act.moveToElement(contactDetail).perform();

		try {
			Thread.sleep(2000);
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
			Thread.sleep(2000);
			email.sendKeys(emal);
			//email.sendKeys(RandomStringUtils.randomAlphabetic(6) + "@gmail.com");
		} catch (Exception e) {
			System.out.println("Email not located");
		}

		try {
			WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
			Thread.sleep(2000);
			mobile.sendKeys(mob);
			//mobile.sendKeys(RandomStringUtils.randomNumeric(10));
		} catch (Exception e) {
			System.out.println("Mobile not found");
		}
	}

	public void enterAddressDetails(String address,String city,String state,String zip) throws InterruptedException {
		WebElement addres = wait.until(ExpectedConditions.visibilityOfElementLocated(addressDetailsTab));
		addres.click();

		WebElement address1 = wait.until(ExpectedConditions.visibilityOfElementLocated(address1Field));
		address1.sendKeys(address);

		WebElement city1 = wait.until(ExpectedConditions.visibilityOfElementLocated(city1Field));
		city1.sendKeys(city);

		WebElement state1 = wait.until(ExpectedConditions.visibilityOfElementLocated(stateField));
		state1.sendKeys(state);

		WebElement zip1 = wait.until(ExpectedConditions.visibilityOfElementLocated(zipField));
		zip1.sendKeys(zip);

		

		
	}

	public void selectCountry(String actCountry) throws InterruptedException {
		
		WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(countryField));
		country.click();
		country.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement lookUp = wait.until(ExpectedConditions.visibilityOfElementLocated(countryLookup));
		lookUp.click();
		
		List<WebElement> countryListElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryList));

		for (WebElement countryName : countryListElements) {
			if (countryName.getText().equals(actCountry)) {
				countryName.click();
				System.out.println("Country is selected");
				break;
			}
		}

		// click done button
		Thread.sleep(3000);
		WebElement doneButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doneButton));
		doneButtonElement.click();
		Thread.sleep(3000);
	}

	public void selectBillingAddress() throws InterruptedException {
		WebElement dropDownAddress2 = wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddressDropdown));
		dropDownAddress2.click();
		// clicked yes
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@role='listbox']/child::div/child::div[2]"))).click();

	}

	public void saveBtn() {
		campaignCreation11 camp1 = new campaignCreation11(driver);
		camp1.save();
		WebElement activeStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(savedVisibleText));

		if (activeStatus.isDisplayed()) {
			System.out.println("Oragnization is created");
			Assert.assertTrue(true);
		} else {
			System.out.println(" Organization is not created");
			Assert.assertFalse(false);
		}
	}

}