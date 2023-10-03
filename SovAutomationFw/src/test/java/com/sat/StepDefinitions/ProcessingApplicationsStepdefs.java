package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.Pages.Assessment_ET;
import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.GenericCases;
import com.sat.Pages.LoginPage;
import com.sat.Pages.Optimization;
import com.sat.Pages.SLATimer;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ProcessingApplicationsStepdefs {

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
	String workingDir = System.getProperty("user.dir");
	HashMap<String, String> map = new HashMap<String, String>();
	String LeadApplicant;

	@Then("user validates {string} field is appearing {int} times")
	public void user_validates_field_is_appearing_times(String string, Integer int1) throws Exception {

		System.out.println(driver.findElements(By.xpath("//label[text()='Additional Applicant']")).size());
		assertion.CheckAssertion(driver.findElements(By.xpath("//label[text()='Additional Applicant']")).size(), 3);

		LeadApplicant = driver.findElement(By.xpath(
				"//div[@data-id='parentcontactid.fieldControl-LookupResultsDropdown_parentcontactid_selected_tag']"))
				.getAttribute("textContent");
		map.put("LeadApplicant", LeadApplicant);

	}

	@Then("user enter the {string} fields")
	public void user_enter_the_fields(String string) throws Exception {

		Thread.sleep(4000);

		Properties ProcessingApplications = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ProcessingApplications.properties");

		System.out.println(ProcessingApplications.getProperty("AdditionalApplicant1"));
		System.out.println(ProcessingApplications.getProperty("AdditionalApplicant2"));
		System.out.println(ProcessingApplications.getProperty("AdditionalApplicant3"));

		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]"))
				.sendKeys(ProcessingApplications.getProperty("AdditionalApplicant1"));
		testutil.jsclick(
				driver.findElement(
						By.xpath("//*[text()='" + ProcessingApplications.getProperty("AdditionalApplicant1") + "']")),
				driver);

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]"))
				.sendKeys(ProcessingApplications.getProperty("AdditionalApplicant2"));
		Thread.sleep(4000);
		testutil.jsclick(
				driver.findElement(
						By.xpath("//*[text()='" + ProcessingApplications.getProperty("AdditionalApplicant2") + "']")),
				driver);

		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'" + string + "')])[1]"))
				.sendKeys(ProcessingApplications.getProperty("AdditionalApplicant3"));
		Thread.sleep(4000);
		testutil.jsclick(
				driver.findElement(
						By.xpath("//*[text()='" + ProcessingApplications.getProperty("AdditionalApplicant3") + "']")),
				driver);

	}

	@Then("user enter Bedroom Applied for field")
	public void user_enter_Bedroom_Applied_for_field() throws Exception {
		actions.click(driver.findElement(By.xpath("//input[@aria-label='Bedroom Applied for']"))).build().perform();
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[@aria-label='Bedroom Applied for']//button[@aria-label='Toggle menu']")), 5);
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='2']")), 5);
		Thread.sleep(2000);

	}
	
	@Then("user search Application Title for processing applications")
	public void user_search_Application_Title_processing_applications() throws IOException {
		 Properties ApplicationTitle = testutil.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/ProcessingApplications.properties");
		 
		 System.out.println(ApplicationTitle.getProperty("ApplicationTitle"));
		 
		 String name = ApplicationTitle.getProperty("ApplicationTitle");
		 
		 try {
				Thread.sleep(3000);
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
				contact.objsearchField.sendKeys(name, Keys.ENTER);
				Thread.sleep(3000);
				//String s = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")).getAttribute("textContent");
			//	actions.click(driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a"))).build().perform();
						
				Wait.untilPageLoadComplete(driver);
				Thread.sleep(3000);
				List<WebElement> li= driver.findElements(By.xpath("//*[text()='"+name+"']"));
				assertion.CheckAssertionTrue(!li.isEmpty(), name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Then("user enter Property Type field")
	public void user_enter_Property_Type_field() throws Exception {
		actions.click(driver.findElement(By.xpath("//input[@aria-label='Property Type']"))).build().perform();
		Thread.sleep(2000);
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		driver.findElement(By.xpath("//input[@aria-label='Property Type']")).sendKeys("Apartment");
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='Apartment']")), 5);
		Thread.sleep(2000);

	}
	
	@Then("user enter Name field as {string}")
	public void user_enter_Name_field(String child) throws Exception {
		actions.click(driver.findElement(By.xpath("//section[@data-id='quickCreateRoot']//*[@aria-label='Name']"))).build().perform();
		Thread.sleep(2000);
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		driver.findElement(By.xpath("//section[@data-id='quickCreateRoot']//*[@aria-label='Name']")).sendKeys(child);
		Thread.sleep(2000);

	}
	
	@Then("user enter Customer Name field as {string}")
	public void user_enter_customer_Name_field(String child) throws Exception {
		actions.click(driver.findElement(By.xpath("//section[@data-id='quickCreateRoot']//*[@aria-label='Customer Name(s)']"))).build().perform();
		Thread.sleep(2000);
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		driver.findElement(By.xpath("//section[@data-id='quickCreateRoot']//*[@aria-label='Customer Name(s)']")).sendKeys(child);
		Thread.sleep(2000);

	}
	
	

	@Then("user enter Property Position field")
	public void user_enter_Property_Position_field() throws Exception {
		actions.click(driver.findElement(By.xpath("//input[@aria-label='Property Position']"))).build().perform();
		Thread.sleep(2000);
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		driver.findElement(By.xpath("//input[@aria-label='Property Position']")).sendKeys("First Floor");
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='First Floor']")), 5);
		Thread.sleep(2000);

	}

	@Then("user enter values in HtB Application grid")
	public void user_enter_values_in_HtB_Application_grid() throws Exception {

		try {
			Thread.sleep(4000);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());

			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Using HtB']")),
					"Yes");
			Thread.sleep(2000);
			testutil.inputText(driver, "HtB Received", 10, currentdate);
			testutil.inputText(driver, "HtB Reference", 10, "Testing");
			Thread.sleep(2000);
			System.out.println(currentdate);
			// testutil.inputText(driver, "Date Preference Registered", 10, currentdate);

			driver.findElement(
					By.xpath("//input[@aria-label='Date of Date Preference Registered']//following-sibling::i"))
					.click();
			Thread.sleep(4000);
			// driver.findElement(By.xpath("//button[@aria-label='3, October,
			// 2022']//parent::td")).click();
			driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("user enter values in Financial Assessment grid")
	public void user_enter_values_in_Financial_Assessment_grid() {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());

			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='FA Received']")),
					"Yes");
			testutil.inputText(driver, "Date FA Received", 10, currentdate);
			Thread.sleep(2000);
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Meet Income Multiple Criteria?']")), "Yes");
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Meet Income Ratio Criteria?']")), "Yes");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("user enter values in Criteria grid")
	public void user_enter_values_in_Criteria_grid() throws Exception {
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Existing Accommodation']")), "Other");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Bedroom Need']")), "1");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Social Tenant']")),
				"Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='MOD']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Homeowner Status']")),
				"Yes");

		testutil.inputText(driver, "Number of Adults", 10, "2");
		testutil.inputText(driver, "Number of Children", 10, "2");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Tenure ']")), "IMR");

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Local Connection']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label='Local Connection']")).sendKeys("Work");
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")), 5);
		Thread.sleep(2000);
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='Work']")), 5);
		Thread.sleep(2000);

	}

	@Then("user validates Application Title")
	public void user_validates_Application_Title() throws Exception {
		String devname = driver.findElement(By.xpath(
				"//div[@data-id='po_development.fieldControl-LookupResultsDropdown_po_development_selected_tag']"))
				.getAttribute("textContent");
		map.put("Development", devname);

		String Expected = map.put("LeadApplicant", LeadApplicant) + " - " + map.put("Development", devname);
		System.out.println(Expected);

		assertion.CheckAssertion(driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title"),
				Expected);

	}

	@Then("user validate Application Status")
	public void user_validate_Application_Status() throws Exception {
		Thread.sleep(2000);
		assertion.CheckAssertion(
				driver.findElement(By.xpath("//select[@aria-label='Application Status']")).getAttribute("title"),
				"Active");

	}

	@Then("user validate Days Preference Registered")
	public void user_validate_Days_Preference_Registered() throws InterruptedException {
		Thread.sleep(2000);
		String DaysPreferenceRegistered = driver
				.findElement(By.xpath("//input[@aria-label='Days Preference Registered']")).getAttribute("title");
		Thread.sleep(2000);
		map.put("DaysPreferenceRegistered", DaysPreferenceRegistered);
		
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//input[@aria-label='Days Preference Registered']"))
				.getAttribute("title").contains(map.get("DaysPreferenceRegistered")), DaysPreferenceRegistered);

	}

	@Then("user validate Total Number in Household")
	public void user_validate_Total_Number_in_Household() throws Exception {
		String NumberofAdults = driver.findElement(By.xpath("//input[@aria-label='Number of Adults']"))
				.getAttribute("title");
		String NumberofChildren = driver.findElement(By.xpath("//input[@aria-label='Number of Children']"))
				.getAttribute("title");
		map.put("NumberofAdults", NumberofAdults);
		map.put("NumberofChildren", NumberofChildren);
		Integer expected = Integer.parseInt(NumberofAdults) + Integer.parseInt(NumberofChildren);
		String TotalNumberinHousehold = driver.findElement(By.xpath("//input[@aria-label='Total Number in Household']"))
				.getAttribute("title");
		map.put("TotalNumberinHousehold", TotalNumberinHousehold);
		assertion.CheckAssertion(Integer.parseInt(TotalNumberinHousehold), expected);

	}

	@Then("user validate Local Connection Score")
	public void user_validate_Local_Connection_Score() throws Exception {
		String LocalConnectionScore = driver.findElement(By.xpath("//select[@aria-label='Local Connection Score']"))
				.getAttribute("title");
		map.put("LocalConnectionScore", LocalConnectionScore);
		assertion.CheckAssertion(LocalConnectionScore, "Low");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//input[contains(@aria-label,'Date Preference Registered')]")));
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//select[@aria-label='Bedroom Need']")));
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//input[contains(@aria-label,'Local Connection')]")));

		actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'Local Connection')]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Local Connection')]")).sendKeys("Live");
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='Live']")), 5);

		// Scrolling down the page till the element is found

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Save']")));

		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(4000);

		String LocalConnectionScore1 = driver.findElement(By.xpath("//select[@aria-label='Local Connection Score']"))
				.getAttribute("title");
		System.out.println(LocalConnectionScore1);
		assertion.CheckAssertion(LocalConnectionScore1, "Medium");

		actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'Local Connection')]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Local Connection')]")).sendKeys("Family");
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='Family']")), 5);

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()='Save']")));
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(4000);
		String LocalConnectionScore2 = driver.findElement(By.xpath("//select[@aria-label='Local Connection Score']"))
				.getAttribute("title");
		assertion.CheckAssertion(LocalConnectionScore2, "High");

	}

	@Then("user clicks Application on BPF")
	public void user_clicks_Application_on_BPF() {
		try {
		//	driver.findElement(By.xpath("//li[contains(@aria-label,'Stage: Application')]")).click();
			driver.findElement(By.xpath("(//div[text()='Application'])[1]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects FA Status as {string}")
	public void user_selects_FA_Status_as(String string) {
		try {

			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("(//select[@aria-label='FA Status'])[2]")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects HtB Status as {string}")
	public void user_selects_HtB_Status_as(String string) {
		try {

			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("(//select[@aria-label='HtB Status'])[2]")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Meets Development Criteria as {string}")
	public void user_selects_Meets_Development_Criteria_as(String string) {
		try {

			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[contains(@aria-label,'Meets Development Criteria')]")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Application Complete as {string}")
	public void user_selects_Application_Complete_as(String string) {
		try {
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[contains(@aria-label,'Application Complete')]")), string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Allocated as {string}")
	public void user_selects_Allocated_as(String string) {
		try {
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[contains(@aria-label,'Allocated')]")), string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user validate Allocation tab is selected")
	public void user_validate_Allocation_tab_is_selected() throws IOException, InterruptedException {
		try {
			Thread.sleep(4000);
			String exp = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage: Allocation')]"))
					.getAttribute("ariaSelected");
			System.out.println(exp);
			assertion.CheckAssertion(exp, "true");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("user enter details in Allocation offer Grid")
	public void user_enter_details_in_Allocation_offer_Grid() throws IOException {

		try {
			Thread.sleep(2000);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());

			Properties PropertyOffered = testutil.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/ProcessingApplications.properties");

			System.out.println(PropertyOffered.getProperty("PropertyOffered"));

			testutil.inputText(driver, "First Allocation Contact", 10, currentdate);
			Thread.sleep(2000);
			testutil.inputText(driver, "AIP Received", 10, currentdate);
			Thread.sleep(4000);

			// cases.fillDetails("Property Offered",
			// PropertyOffered.getProperty("PropertyOffered"));

			driver.findElement(By.xpath("//input[@aria-label='Property Offered, Lookup']")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@aria-label='Search records for Property Offered, Lookup field']"))
//					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"(//div[@data-id='po_propertyoffered.fieldControl-LookupResultsDropdown_po_propertyoffered_infoContainer'])[1]"))
					.click();

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Then("user enter details in Financial Grid")
	public void user_enter_details_in_Financial_Grid() {

		try {
			Thread.sleep(2000);
			testutil.inputText(driver, "Income Multiple", 10, "5");
			testutil.inputText(driver, "Debt to Household Ratio %", 10, "5");
			testutil.inputText(driver, "Share Offered %", 10, "5");
			Thread.sleep(2000);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user enter details in Reservation Grid")
	public void user_enter_details_in_Reservation_Grid() {

		try {
			Thread.sleep(2000);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());

			testutil.inputText(driver, "Date Reservation Form Sent", 10, currentdate);
			testutil.inputText(driver, "Reservation Form Received", 10, currentdate);
			testutil.inputText(driver, "Declaration Form Received", 10, currentdate);
			testutil.inputText(driver, "Reservation Fee Received", 10, currentdate);
			testutil.inputText(driver, "Property Reserved Date", 10, currentdate);
			testutil.inputText(driver, "Fee Memo Sent", 10, currentdate);
			testutil.inputText(driver, "Reservation Fee", 10, "10");
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[contains(@aria-label,'Allocation Status')]")), "Allocated");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("user clicks Allocation on BPF")
	public void user_clicks_Allocation_on_BPF() {
		try {
			driver.findElement(By.xpath("//*[contains(@aria-label,'Stage: Allocation')]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user selects Property Offered to Customer as {string}")
	public void user_selects_Property_Offered_to_Customer_as(String string) {

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Property Offered to Customer')]")), string);

	}

	@Then("user selects AIP Accepted as {string}")
	public void user_selects_AIP_Accepted_as(String string) {
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'AIP Accepted')]")), string);

	}

	@Then("user selects Reservation Complete as {string}")
	public void user_selects_Reservation_Complete_as(String string) {
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Reservation Complete')]")), string);

	}

	@Then("user selects AML Started as {string}")
	public void user_selects_AML_Started_as(String string) {
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'AML Started')]")), string);

	}

	@Then("user validate {string} form is opened")
	public void user_validate_form_opened(String string) {
		try {
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@data-id='form-selector']"))
					.getAttribute("textContent").contains(string), string);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("user validate the fields are mapped from Summary tab")
	public void user_validate_the_fields_are_mapped_from_Summary_tab() throws IOException {

		try {

			Properties ProcessingApplications = testutil.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/ProcessingApplications.properties");

			System.out.println(ProcessingApplications.getProperty("AdditionalApplicant1"));
			System.out.println(ProcessingApplications.getProperty("AdditionalApplicant2"));
			System.out.println(ProcessingApplications.getProperty("AdditionalApplicant3"));

			Thread.sleep(2000);
			// Validation of Contact
			assertion.CheckAssertionTrue(driver.findElement(By.xpath(
					"//ul[@data-id='Applicants.parentcontactid.fieldControl-LookupResultsDropdown_parentcontactid_SelectedRecordList']"))
					.getAttribute("textContent").contains("Aaisha Tanvir"), "Aaisha Tanvir");

			// Number of Additional Applicants
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//select[@aria-label='Number of Additional Applicants']"))
							.getAttribute("title").contains("3"),
					"3");

			// Validation of First Additional Applicant
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("//ul[contains(@data-id,'po_firstadditionalapplicant_SelectedRecordList')]"))
					.getAttribute("textContent").contains(ProcessingApplications.getProperty("AdditionalApplicant1")),
					ProcessingApplications.getProperty("AdditionalApplicant1"));

			// Validation of Second Additional Applicant
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("//ul[contains(@data-id,'po_secondadditionalapplicant_SelectedRecordList')]"))
					.getAttribute("textContent").contains(ProcessingApplications.getProperty("AdditionalApplicant2")),
					ProcessingApplications.getProperty("AdditionalApplicant2"));

			// Validation of Third Additional Applicant
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("//ul[contains(@data-id,'po_thirdadditionalapplicant_SelectedRecordList')]"))
					.getAttribute("textContent").contains(ProcessingApplications.getProperty("AdditionalApplicant3")),
					ProcessingApplications.getProperty("AdditionalApplicant3"));

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("user enter the details in AML check grid")
	public void user_enter_the_details_in_AML_check_grid() throws InterruptedException {

		Thread.sleep(2000);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());

		testutil.inputText(driver, "Date of AML check", 10, currentdate);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Sale Type')]")), "Resale");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'AML Status')]")), "Passed");

		cases.fillDetails("Checked By", "D365 Test1");

	}

	@Then("user enter the details in Evidence Proof of ID grid")
	public void user_enter_the_details_in_Evidence_Proof_of_ID_grid() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(2000);
		// Scrolling down the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();",
//                driver.findElement(By.xpath("//textarea[@aria-label='Action taken to Mitigate Risk']")));
        Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Met Customer')]")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Evidence of ID')]")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Documents')]")), "Current signed passport");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Name Sign Off')]")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[contains(@aria-label,'Document')]")),
				"Electoral Register entry");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Address Sign Off')]")), "yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Certified')]")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Documents Certified By')]")), "Dcotor");

	}

	@Then("user enter the details in Source of Funds grid")
	public void user_enter_the_details_in_Source_of_Funds_grid() throws InterruptedException {

		testutil.inputText(driver, "Cash", 10, "50");
		testutil.inputText(driver, "Mortgage", 10, "50");

		actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'Evidence Provided')]"))).build()
				.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Evidence Provided')]")).sendKeys("Loan Letter");
		testutil.clickOn(driver, driver.findElement(By.xpath("//div[text()='Loan Letter']")), 5);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Funds Sign Off')]")), "Yes");

		testutil.inputText(driver, "Further Considerations", 10, "Test");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Credit Check')]")), "Passed");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Evidence Sufficient')]")), "Yes");

	}

	@Then("user validate the message Total percentage should be equal to {int}")
	public void user_validate_the_message_Total_percentage_should_be_equal_to(Integer int1)
			throws IOException, InterruptedException {

		testutil.inputText(driver, "Cash", 10, "50");
		testutil.inputText(driver, "Mortgage", 10, "10");
		actions.sendKeys(Keys.TAB);
		Thread.sleep(4000);

		assertion.CheckAssertion(
				driver.findElement(By.xpath("//*[@data-id='po_total_pc-error-message']")).getAttribute("textContent"),
				"Total (%): Total % should be equal to 100");

		Thread.sleep(4000);
		testutil.inputText(driver, "Mortgage", 10, "50");
		Thread.sleep(4000);

	}

	@Then("user validate Score as {string} and risk as {string} for the below combination")
	public void user_validate_Socre_as_and_risk_as_for_the_below_combination(String string, String string2,
			DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		List<List<String>> actual = dataTable.cells();
		System.out.println(actual.size());
		try {
			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			for (int j = 0; j < actual.size() - 1; j++) {
				String ProofofNameSignOff = data.get(j).get("Proof of Name Sign Off");
				String ProofofAddressSignOff = data.get(j).get("Proof of Address Sign Off");
				String ProofofFundsSignOff = data.get(j).get("Proof of Funds Sign Off");
				Thread.sleep(2000);
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Name Sign Off')]")),
						ProofofNameSignOff);
				Thread.sleep(2000);
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Address Sign Off')]")),
						ProofofAddressSignOff);
				Thread.sleep(2000);
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[contains(@aria-label,'Proof of Funds Sign Off')]")),
						ProofofFundsSignOff);
				Thread.sleep(2000);
			}

			String RiskScore = driver.findElement(By.xpath("//input[contains(@aria-label,'Risk Score')]"))
					.getAttribute("title");
			Thread.sleep(2000);
			String RiskStatus = driver.findElement(By.xpath("//select[contains(@aria-label,'Risk Status')]"))
					.getAttribute("title");
			Thread.sleep(2000);
			System.out.println(RiskScore);
			Thread.sleep(2000);
			System.out.println(RiskStatus);
			assertion.CheckAssertion(RiskScore, string);
			assertion.CheckAssertion(RiskStatus, string2);
		} catch (Exception ee) {
			System.out.println(ee);
			// ExtentCucumberAdapter.getCurrentStep().info(ee);
		}

	}

	@Then("user clicks AML on BPF")
	public void user_clicks_AML_on_BPF() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@aria-label,'Stage: AML')]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user clicks Post Completion on BPF")
	public void user_clicks_Post_Completion_on_BPF() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@aria-label,'Stage: Post Completion')]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validates AML Status is mapped from AML form")
	public void user_validates_AML_Status_is_mapped_from_AML_form() {

		try {
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("//*[@data-id='header_process_po_status.fieldControl-option-set-select']"))
					.getAttribute("title").contains("Passed"), "AML Status");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validate AML Risk Status is mapped from AML form")
	public void user_validate_AML_Risk_Status_is_mapped_from_AML_form() {

		try {
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath(
							"//*[@data-id=data-id='header_process_po_riskstatus.fieldControl-option-set-select']"))
					.getAttribute("title").contains("High"), "AML Risk Status");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validate the following grids are displayed in {string}")
	public void user_validate_the_following_grids_are_displayed(String string,
			io.cucumber.datatable.DataTable dataTable) {
		try {
			List<String> actual = dataTable.asList();
			System.out.println(" Size of the data table is : " + actual.size());
			for (int i = 0; i <= actual.size() - 1; i++) {
				Thread.sleep(4000);
				String expected = driver.findElement(By.xpath("//div[@aria-label='" + string + "']"))
						.getAttribute("outerText");
				System.out.println(expected);
				Thread.sleep(2000);
				assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("user enter the details in Reservation Key Milestones")
	public void user_enter_the_details_in_Reservation_Key_Milestones() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Date of MOS Sent']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Revised MOS Sent']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Draft Paperwork Received']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Draft Paperwork Approved']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'HtB Allocation Changed')]")), "Yes");

	}

	@Then("user enter the details in Conveyancing Key Milestones")
	public void user_enter_the_details_in_Conveyancing_Key_Milestones() throws InterruptedException {

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Searches Applied For')]")), "Yes");

		driver.findElement(By.xpath("//input[@aria-label='Date of First Enquiries Raised']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Enquiries Answered')]")), "Yes");
	}

	@Then("user enter the details in Mortgage Key Milestones")
	public void user_enter_the_details_in_Mortgage_Key_Milestones() throws InterruptedException {
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Mortgage Survey Booked')]")), "Yes");

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Survey Date']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Received']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Approved']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Expiry']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//button[@aria-label='Search records for Lender, Lookup field']")).click();
//		Thread.sleep(4000);
//		driver.findElement(
//				By.xpath("(//div[@data-id='po_lender.fieldControl-LookupResultsDropdown_po_lender_infoContainer'])[1]"))
//				.click();

		driver.findElement(By.xpath("//input[@aria-label='Lender, Lookup']")).click();
		Thread.sleep(4000);
		actions.sendKeys("Darlington Building Society").build().perform();
//		driver.findElement(By.xpath("//input[@aria-label='Lender, Lookup']"))
//				.sendKeys("HSBC UK Bank");
		Thread.sleep(4000);
		testutil.jsclick(driver.findElement(By.xpath("//*[text()='Darlington Building Society']")), driver);

		Thread.sleep(2000);
		testutil.inputText(driver, "Mortgage Payment", 10, "50");

		testutil.inputText(driver, "Term (Years)", 10, "50");

		testutil.inputText(driver, "Interest Rate %", 10, "50");

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[contains(@aria-label,'HtB ISA')]")),
				"Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Mortgage Clause Agreed')]")), "Yes");

	}

	@Then("user enter the details in Documents received")
	public void user_enter_the_details_in_Documents_received() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Date of Contract']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Lease']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Undertaking']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

	}

	@Then("user enter the details in Documents Checked")
	public void user_enter_the_details_in_Documents_Checked() throws InterruptedException {

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Checked']//*[@aria-label='Date of Contract']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Checked']//*[@aria-label='Date of Lease']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Checked']//*[@aria-label='Date of Undertaking']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

	}

	@Then("user enter the details in Documents Signed")
	public void user_enter_the_details_in_Documents_Signed() throws InterruptedException {

		// section[@aria-label='Documents Checked']//*[@aria-label='Date of
		// Contract']//following-sibling::i
		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Signed']//*[@aria-label='Date of Contract']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		// section[@aria-label='Documents Checked']//*[@aria-label='Date of
		// Lease']//following-sibling::i
		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Signed']//*[@aria-label='Date of Lease']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		// section[@aria-label='Documents Checked']//*[@aria-label='Date of
		// Undertaking']//following-sibling::i
		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Signed']//*[@aria-label='Date of Undertaking']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

	}

	@Then("user enter the details in Documents Returned")
	public void user_enter_the_details_in_Documents_Returned() throws InterruptedException {

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Returned']//*[@aria-label='Date of Contract']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Returned']//*[@aria-label='Date of Lease']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//section[@aria-label='Documents Returned']//*[@aria-label='Date of Undertaking']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

	}

	@Then("user enter the details in Post Completion Key Milestones")
	public void user_enter_the_details_in_Post_Completion_Key_Milestones() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Completion Date']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Notice Received']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Notice Returned']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Counterpart Lease Received']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of HtB Complete']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of CORE Updated']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Invoice Date']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		testutil.inputText(driver, "CORE ID", 10, "TEST CORE");

	}

	@Then("user enter the details in Exchange Key Milestones")
	public void user_enter_the_details_in_Exchange_Key_Milestones() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Date of Exchange Deadline']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Extended Exchange (1)']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Extended Exchange (2)']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(4000);

		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Deposit Received')]")), "Yes");
		Thread.sleep(2000);

		testutil.inputText(driver, "Exchange Deposit (£)", 10, "50");
		Thread.sleep(2000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Signed Documents Held')]")), "Yes");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Actual Exchange Date']//following-sibling::i"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(4000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Notice Served')]")), "Yes");

		actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'Extended Exchange (2) Reason')]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Extended Exchange (2) Reason')]"))
				.sendKeys("Mortgage Issues");
		testutil.clickOn(driver,
				driver.findElement(By
						.xpath("//label[@name='po_extendedexchange2reasonmsos-label']//div[text()='Mortgage Issues']")),
				5);

		actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'Extended Exchange (1) Reason')]")))
				.build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Extended Exchange (1) Reason')]"))
				.sendKeys("Searches");
		// testutil.clickOn(driver,
		// driver.findElement(By.xpath("//div[text()='Searches']")), 5);
		testutil.clickOn(driver, driver.findElement(
				By.xpath("//label[@name='po_extendedexchange1reasonmsos-label']//div[text()='Searches']")), 5);

	}

	@Then("user enter the details in Viewings")
	public void user_enter_the_details_in_Viewings() throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//input[@aria-label='Date of 1st Viewing Date']")).click();
		// driver.findElement(By.xpath("//div[@data-id='po_firstviewingdate.fieldControl._datecontrol-date-container']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Date of 1st Viewing Date']//following-sibling::i")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Follow Up Viewing Date']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Carpets Fitted Date']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Other Viewing Date']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Undertaking (Carpets) Received')]")),
				"Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Other Viewing')]")), "Yes");

		testutil.inputText(driver, "Other Viewing Reason", 10, "50");

	}

	@Then("user validate {string} field")
	public void user_validate_field(String string) {

		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//input[@aria-label='Weeks to Exchange']"))
				.getAttribute("title").contains("0"), string);

	}

	@Then("user clicks Conveyancing on BPF")
	public void user_clicks_Conveyancing_on_BPF() {

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(@aria-label,'Stage: Conveyancing')]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user enter the details in Conveyancing BPF field")
	public void user_enter_the_details_in_Conveyancing_BPF_field() throws InterruptedException {
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'MOS Sent?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Exchanged ?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Portal Account Setup ?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Completed ?')]")), "Yes");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@aria-label='Date of Exchange Deadline']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@aria-label='Date of Exchange Deadline']//following-sibling::i")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
//		Thread.sleep(2000);

	}

	@Then("user enter the details in Post Completion BPF field")
	public void user_enter_the_details_in_Post_Completion_BPF_field() throws InterruptedException {

		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Handover to Internal Teams ?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[contains(@aria-label,'CORE ?')]")),
				"Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'HtB Completed ?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Funds Received ?')]")), "Yes");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[contains(@aria-label,'Conveyancing Complete ?')]")), "Yes");
		Thread.sleep(2000);

	}

	@Then("user validate Post Completion stage is marked as Finished")
	public void user_validate_Post_Completion_stage_marked_Finished() throws InterruptedException {
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath(
				"//div[@data-id='MscrmControls.Containers.ProcessStageControl-businessProcessFlowFlyoutFooterContainer']"))
				.getAttribute("textContent").contains("Finished"), "Finished");
		Thread.sleep(2000);
	}

	@Then("user click on open opportunity")
	public void user_click_on_open_opportunity() throws InterruptedException {
		Thread.sleep(2000);
//		testutil.clickOn(driver, 
//		driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']")),10);
		testutil.jsclick(driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), driver);

	}

	@Then("user click on OK")
	public void user_click_on_OK() throws InterruptedException {
		Thread.sleep(500);
		testutil.jsclick(driver.findElement(By.xpath("//span[text()='OK']//parent::button")), driver);

	}

	@Then("user validate read only message")
	public void user_validate_read_only_message() throws IOException, InterruptedException {
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@id='notificationMessageAndButtons']"))
				.getAttribute("textContent").contains("Won"), "Read-only This record’s status: Won");
//		assertion.CheckAssertion(
//				driver.findElement(By.xpath("//div[@id='notificationMessageAndButtons']")).getAttribute("textContent"),
//				"Read-only This record’s status: Won");

	}
	
	@Then("user validate read only message as {string}")
	public void user_validate_read_only_message_as(String string) throws IOException, InterruptedException {
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@id='notificationMessageAndButtons']"))
				.getAttribute("textContent").contains(string), string);
//		assertion.CheckAssertion(
//				driver.findElement(By.xpath("//div[@id='notificationMessageAndButtons']")).getAttribute("textContent"),
//				"Read-only This record’s status: Won");

	}

	@Then("user select any Opportunity")
	public void user_select_any_Opportunity() {

		try {
			Thread.sleep(2000);
			LeadApplicant = driver.findElement(By.xpath(
					"//div[@aria-rowindex='2']//div[@aria-colindex='2']//a"))
					.getAttribute("textContent");
			map.put("LeadApplicant", LeadApplicant);
			
			Thread.sleep(2000);
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user enter Completion Date")
	public void user_enter_Completion_Date() {

		try {
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@aria-label='Date of Completion Date']//following-sibling::i"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("user clicks on Property Offered value link")
	public void user_clicks_on_Property_Offered_value_link() {

		try {
			Thread.sleep(4000);
			testutil.clickOn(driver, driver.findElement(By.xpath(
					"//div[@data-id='po_propertyoffered.fieldControl-LookupResultsDropdown_po_propertyoffered_selected_tag']")),
					10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validate the Sales Status field value as {string}")
	public void user_validate_the_Sales_Status_field_value(String s) throws IOException {
		try {
			Thread.sleep(4000);

			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//select[@aria-label='Sales Status']")).getAttribute("title"), s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user enter the Property Offered")
	public void user_enter_the_Property_Offered() {
		try {
			Thread.sleep(2000);
			if (driver
					.findElements(
							By.xpath("//div[@data-id='po_propertyoffered.fieldControl-Lookup_po_propertyoffered']//ul"))
					.size() == 0) {
				System.out.println("Entering Property Offered value");
				driver.findElement(By.xpath("//input[@aria-label='Property Offered, Lookup']")).click();
				Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.xpath(
						"(//div[@data-id='po_propertyoffered.fieldControl-LookupResultsDropdown_po_propertyoffered_infoContainer'])[1]"))
						.click();
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("user enter Property Reserved Date")
	public void user_enter_Property_Reserved_Date() {
		try {
			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, +30);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(cal.getTime());
			
			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			testutil.inputText(driver, "Property Reserved Date", 10, date);
			Thread.sleep(4000);
			
			
			
		
//			testutil.sendKeys(driver,
//					driver.findElement(By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")), 0,
//					date);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user enter the details in Mortgage Key Milestones section")
	public void user_enter_the_details_in_Mortgage_Key_Milestones_section() throws InterruptedException {
		
		

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Received']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Approved']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Mortgage Offer Sent to Solicitor']//following-sibling::i"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);


		cases.fillDetails("Lender", "Darlington Building Society");
//		driver.findElement(By.xpath("//input[@aria-label='Lender, Lookup']")).click();
//		Thread.sleep(4000);
//		actions.sendKeys("Darlington Building Society").build().perform();
////		driver.findElement(By.xpath("//input[@aria-label='Lender, Lookup']"))
////				.sendKeys("HSBC UK Bank");
//		Thread.sleep(4000);
//		testutil.jsclick(driver.findElement(By.xpath("//*[text()='Darlington Building Society']")), driver);

		Thread.sleep(2000);
		
		
		testutil.inputText(driver, "Mortgage Payment", 10, "50");

	

	}

}
