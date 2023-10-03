package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.sat.Pages.Assessment_ET;
import com.sat.Pages.CasePage;
import com.sat.Pages.CommonPages;
import com.sat.Pages.ContactForm;
import com.sat.Pages.Creations;
import com.sat.Pages.CustomerPage;
import com.sat.Pages.ETCase_ET;
import com.sat.Pages.GenericCases;
import com.sat.Pages.LoginPage;
import com.sat.Pages.Optimization;
import com.sat.Pages.Outcome_ET;
import com.sat.Pages.SLATimer;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class CreationsStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	LoginPage loginpage = new LoginPage(driver);
	Testutil testutil = new Testutil(driver);
	Assertions assertion = new Assertions(driver);
	Actions actions = new Actions(driver);
	Assessment_ET assessment_ET = new Assessment_ET(driver);
	SLATimer slatimer = new SLATimer(driver);
	private CasePage cases = new CasePage(driver);
	Optimization omptimization = new Optimization(driver);
	GenericCases genericCases = new GenericCases(driver);
	private ContactForm contact = new ContactForm(driver);
	HashMap<String, String> assessmentDetails = new HashMap<String, String>();
	HashMap<String, String> dates = new HashMap<String, String>();
	Outcome_ET outcome_et = new Outcome_ET(driver);
	ETCase_ET etCase_et = new ETCase_ET(driver);
	Creations creations = new Creations(driver);
	CustomerPage accountpage = new CustomerPage(driver);
	String ContactName = "";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String workingDir = System.getProperty("user.dir");
	private CommonPages common = new CommonPages(driver);

	@Then("user navigates to {string} form")
	public void user_navigates_to_form(String string) throws Exception {
		// Thread.sleep(2000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']")));

		driver.findElement(By.xpath("//div[@data-id='form-selector']")).click();
		driver.findElement(By.xpath("//li[@aria-label='" + string + "']")).click();
		if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
			testutil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")),
					10);
		Thread.sleep(2000);


	}
	
	@Then("user selects {string} as {string} in {string} form")
	public void  user_selects_as_in_for(String label,String option,String string3) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Street 2']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Local Authority (SL)']")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Tenure']")));
		actions.click(driver.findElement(By.xpath("//label[text()='Tenure']"))).build().perform();
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//select[contains(@aria-label,'"+label+"')]"));
		Thread.sleep(2000);
		System.out.println("user selecting as = "+ option);
		testutil.selectByVisibleText(driver,e, option);
		Thread.sleep(2000);
		//assertion.CheckAssertionTrue(e,string2);
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.ENTER);
	}

	@Then("user validates {string} section")
	public void user_validates_section(String string) throws Exception {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@aria-label='" + string + "']")));
	}

	@Then("user enters the address details")
	public void user_enters_the_address_details() {

		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Street 1']")), 5, "Street1");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Street 2']")), 5, "Street2");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Town']")), 5, "Town");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='County']")), 5, "India");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Postcode']")), 5, "12345");

	}

	@Then("user validate {string} is displayed in top ribbon")
	public void user_validate_is_displayed_on_the_form_header(String string) throws Exception {
		Thread.sleep(8000);
		System.out.println("Expected = " +string);
		System.out.println("Actual = "+ driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']")).getAttribute("textContent"));
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']"))
				.getAttribute("textContent").contains(string), string);
		
	}

	@Then("user validate {string} is displayed")
	public void user_validate_is_displayed(String string) throws Exception {
		Thread.sleep(2000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",
	     driver.findElement(By.xpath("//input[@aria-label='Postcode']")));
		
		Thread.sleep(2000);
		
		
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@data-id='SUMMARY_TAB_section_6']")).getAttribute("textContent").contains(string),
				string);

		
//		assertion.CheckAssertionTrue(driver.findElements(By.xpath("//h3[text()='" + string + "']")).size() != 0,
//				string);

	}

	@Then("user click on {string} in CONTACTS")
	public void user_click_on_in_CONTACTS(String string) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@data-id='SUMMARY_TAB_section_6']")));
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='More commands for Contact']")), 10);
	}

	@Then("user search for the Existing contact {string}")
	public void user_search_for_the_Existing_contact(String string) throws InterruptedException {
		
		 actions.click(driver.findElement(By.xpath("//input[@aria-label='Select record, Multiple Selection Lookup']"))).build().perform();
			Thread.sleep(2000);
			actions.click(driver.findElement(
					By.xpath("//li[@aria-label='"+ContactName+"'] | //li[contains(@aria-label,'"+ContactName+"')]")))
					.build().perform();
			Thread.sleep(2000);  
			
			
		//cases.fillDetails("Select record", string);
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Add']")), 10);
		List<WebElement> lis = driver.findElements(By.xpath("//button[@aria-label='OK']"));
		if (lis.size() != 0)
			testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='OK']")), 1);

	}

	@Then("user click on {string} in Recent Applications")
	public void user_click_on_in_CONTACTS_RecentApplication(String string) throws Exception {

		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='" + string + "']")), 10);
	}

	@Then("user creates new contact")
	public void user_creates_new_contact() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

		accountpage.entity("Contacts");
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='New']")), 10);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Title']")), "Ms");
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='First Name']")), 10,
				"firstName" + timeStamp);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Last Name']")), 10,
				"lastName" + timeStamp);
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save & Close']")), 10);
		ContactName = "firstName" + timeStamp + " lastName" + timeStamp;
	}

	@Then("user validates that contact is showing in the contact grid list")
	public void user_validates_that_contact_is_showing_in_the_contact_grid_list() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@data-id='SUMMARY_TAB_section_6']")));
		Thread.sleep(2000);

		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//span[text()='" + ContactName + "']")), ContactName);

	}

	@Then("user check the timeline for {string}")
	public void user_check_the_timeline_for(String string) {

		assertion.CheckAssertionTrue(
				driver.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
						.getAttribute("outerText").contains(string),
				string);
	}

	@Then("user validates mandatory mark for below fields")
	public void user_validates_mandatory_mark_for_below_fields(DataTable dataTable) {

		List<String> actual = dataTable.asList();
		System.out.println(" Size of the data table is : " + actual.size());
		System.out.println(driver.findElements(By.xpath("//*[text()='*']")).size());
		for (int i = 0; i <= actual.size() - 1; i++) {
			assertion.CheckAssertionTrue(driver
					.findElements(
							By.xpath("//div[contains(@data-id,'" + actual.get(i).toLowerCase() + "')]//*[text()='*']"))
					.size() != 0, actual.get(i));
		}

	}

	@Then("user enter the address details")
	public void user_enter_the_address_details() throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@aria-label='Applicant Details']")));
		Thread.sleep(2000);

		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Street 1']")), 10, "Street1");

		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='City']")), 10, "Hyderabad");

		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='ZIP/Postal Code']")), 10, "500066");

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Marital Status']")),
				"Single");

		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Reservation Refund Amount (£)']")),
				10, "500066");

	}

	@Then("user validates URN is auto populated")
	public void user_validates_URN_is_auto_populated() {

		assertion.CheckAssertionTrue(!driver.findElement(By.xpath("(//div[@data-preview_orientation='column']//div)[1]"))
				.getAttribute("textContent").isEmpty(), "");

	}

	@Then("user validates Active Preferences grid")
	public void user_validates_grid() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//div[@aria-label='Active Preferences']")));
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(
				driver.findElements(By.xpath("//div[@aria-label='Active Preferences']")).size() != 0, "");
	}

	@Then("user validates Applications grid")
	public void user_validates_Applications_grid() {
		assertion.CheckAssertionTrue(driver.findElements(By.xpath("//h3[text()='Applications']")).size() != 0,
				"Applications");

	}

	@Then("user enters the New Preference Details")
	public void user_enters_the_New_Preference_Details() throws Exception {

		Properties Creations = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Creations.properties");

		System.out.println("PreferenceSource is : " + Creations.getProperty("PreferenceSource"));
		System.out.println("Development is : " + Creations.getProperty("Development"));
		System.out.println("Town is : " + Creations.getProperty("Town"));
		System.out.println("County is : " + Creations.getProperty("County"));
		System.out.println("Property is : " + Creations.getProperty("Property"));
		System.out.println("SLPropertyType is : " + Creations.getProperty("SLPropertyType"));
		System.out.println("NumberofBedrooms is : " + Creations.getProperty("NumberofBedrooms"));
		System.out.println("Tenure is : " + Creations.getProperty("Tenure"));
		
		cases.fillDetails("Preference Source", Creations.getProperty("PreferenceSource"));
		//cases.fillDetails("Development", Creations.getProperty("Development"));
		cases.fillDetails("Town (SL)", Creations.getProperty("Town"));
		cases.fillDetails("County (SL)", Creations.getProperty("County"));
		cases.fillDetails("Property", Creations.getProperty("Property"));

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='SL Property Type']")),
				Creations.getProperty("SLPropertyType"));
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Tenure']")),
				Creations.getProperty("Tenure"));

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Number of Bedrooms']"))).build().perform();
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='2']")), 5);
		Thread.sleep(2000);

	}

	@Then("user validate Preference is showing in Preference Grid")
	public void Preference_showing_preference_grid() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		assertion.CheckAssertion(
				driver.findElement(By.xpath("//span[@title='Go to home page']")).getAttribute("textConent"),
				"Firstname Lastname");

	}

	@Then("user clicks {string}")
	public void user_clicks(String string) throws InterruptedException {

		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//button[@aria-label='New']"))).build().perform();

	}

	@Then("user enters field {string}")
	public void user_enters_field(String string) throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String val = string + timeStamp;
		Thread.sleep(2000);
		actions.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(2000);
		actions.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Last Name']")), 0, val);

	}

	@Then("user validates {string} grid")
	public void user_validates_grid(String grid) {
		assertion.CheckAssertionTrue(driver.findElements(By.xpath("//h3[text()='"+grid+"']")).size() != 0,
				"grid");

	}
}
