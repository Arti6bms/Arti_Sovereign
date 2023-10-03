package com.sat.Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class Outcome_ET {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	Assertions assertion = new Assertions(driver);
	Actions actions = new Actions(driver);
	private CasePage cases = new CasePage(driver);

	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	HashMap<String, String> dates = new HashMap<String, String>();
	String workingDir = System.getProperty("user.dir");
	Properties prop = new Properties();


	public Outcome_ET(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@aria-label='Number of Weeks Employed']")
	public WebElement objNumberofWeeksEmployed;

	public HashMap<String, String> enterDetailsJobSection() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());
		dates.put("StartDate", currentdate);

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +90);
		SimpleDateFormat sdfs = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdfs.format(cal.getTime());
		dates.put("EndDate", date);

		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@aria-label='Date of Job Outcome Claimed Date']")), 10,
				currentdate);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Date of Job Start Date']")), 10,
				currentdate);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Hourly Rate']")), 10, "3");
		Thread.sleep(3000);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Weekly Hours']")), 10, "4");
		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@data-id='po_job_title.fieldControl-text-box-text']")), 10,
				"Tester");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Date of Date Job Role Finished']")),
				10, date);

		return dates;

	}

	public void enterDetailsRentAccountCaptureSection() throws Exception {
		try {
			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@aria-label='Rent Account Status (Job Start)']")), 10, "5");

			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@aria-label='Rent Account Status (3months)']")), 10, "5");

			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@aria-label='Rent Account Status (6months)']")), 10, "5");

			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@aria-label='Rent Account Status (9months)']")), 10, "5");

			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@aria-label='Rent Account Status (12months)']")), 10, "5");

			actions.click().build().perform();
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Account Status (Job Start)')]"))
							.getAttribute("title"),
					"£5.00");
			Thread.sleep(2000);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Account Status (3months)')]"))
							.getAttribute("title"),
					"£5.00");
			Thread.sleep(2000);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Account Status (6months)')]"))
							.getAttribute("title"),
					"£5.00");
			Thread.sleep(5000);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Account Status (9months)')]"))
							.getAttribute("title"),
					"£5.00");
			Thread.sleep(5000);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Account Status (12months)')]"))
							.getAttribute("title"),
					"£5.00");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void EnterDetailsLicense_Affiliation_Registration_section() throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());
			
			Properties outcome = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Outcome.properties");
			System.out.println("LicenseAffiliationRegistrationType : " + outcome.getProperty("LicenseAffiliationRegistrationType"));

			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@aria-label='Date of License/ Affiliation/ Registration Start Date']")),
					0, currentdate);
			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@aria-label='Date of License/ Affiliation/ Registration Expiry Date']")),
					0, currentdate);
			testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Date of Date Expected']")), 0,
					currentdate);
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='First instance this FY add to Value Insight']")),
					"Yes");
			Thread.sleep(2000);
			cases.fillDetails("License/ Affiliation/ Registration Type", outcome.getProperty("LicenseAffiliationRegistrationType"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EnterDetailSustainment_ChecksSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Sustainment Checks')]")));

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Sustainment 3 Month Met']")), "Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Sustainment 6 Months Met']")), "Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Sustainment 9 Months Met']")), "Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Sustainment 12 Months Met']")), "Yes");
	}

	public void EnterDetailsTrainingSection(String string) throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());
		
		Properties ActiveETCase = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
		System.out.println("Type of Training : " + ActiveETCase.getProperty("TypeofTraining"));
		System.out.println("Provider : " + ActiveETCase.getProperty("Provider"));

		testutil.sendKeys(driver,
				driver.findElement(
						By.xpath("//input[@data-id='po_training_outcome_gained.fieldControl-date-time-input']")),
				10, currentdate);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Training Type']")),
				"Accredited Training");
		cases.fillDetails("Type of Training", ActiveETCase.getProperty("TypeofTraining"));
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Digital Skills Training']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Training Completed']")),
				"No");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Certificate Awarded']")), "No");
		
		cases.fillDetails("Provider", ActiveETCase.getProperty("Provider"));
		
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Level']")), "Level 1");

		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@data-id='po_datetrainingstarted.fieldControl-date-time-input']")),
				0, currentdate);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Claim Training Outcome on Skills For Work']")),
				"Yes");

		testutil.sendKeys(driver, driver.findElement(By.xpath(
				"//input[@data-id='po_datetrainingoutcomeclaimedonskillsforwork.fieldControl-date-time-input']")), 0,
				currentdate);

		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")), 0,
				currentdate);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Has Resident Achieved?']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Add to CV']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Evidence ']")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='First instance this FY add to Value Insight']")),
				"Yes");
	}

	public void validateGrid(String string, String s) {
		try {
			Thread.sleep(2000);
			
			System.out.println("Validating grid = " +string);

//			actions.click(
//					driver.findElement(By.xpath("//section[@aria-label='" + string + "']//*[text()='Outcome Type']")))
//					.build().perform();
			
			actions.click(
					driver.findElement(By.xpath("//section[@aria-label='" + string + "']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
					.build().perform();
			
			filterGrid(s);
			Thread.sleep(4000);
			System.out.println(string + " grid values are " + driver
					.findElement(By.xpath("//section[@aria-label='" + string + "']")).getAttribute("textContent"));
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='" + string + "']"))
					.getAttribute("textContent").contains(s), s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void filterGrid(String s)
	{
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='" + s + "']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
	}

	public void enterWellbeingSection() {
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Mental Health']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Confidence']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Control of Life']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Financial Comfort']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Able to Access Information']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Able to access the internet']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Able to pay for housing']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Has Resident Achieved?']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='First instance this FY add to Value Insight']")), "Yes");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(new Date());
		System.out.println(date);

		testutil.sendKeys(driver,
				driver.findElement(
						By.xpath("//input[@data-id='po_wellbeingoutcomegained.fieldControl-date-time-input']")),
				10, date);
		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")), 10,
				date);

	}

}
