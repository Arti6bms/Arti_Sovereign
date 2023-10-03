package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
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

public class ETCase_ETStepDefs {

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
	HashMap<String, String> ETcaseDetails = new HashMap<String, String>();
	HashMap<String, String> dates = new HashMap<String, String>();
	Outcome_ET outcome_et = new Outcome_ET(driver);
	ETCase_ET etCase_et = new ETCase_ET(driver);
	String workingDir = System.getProperty("user.dir");

	@Then("user search ET CASE")
	public void user_search_ET_CASE() throws IOException, InterruptedException {
		Properties AssessmentETCase = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
		System.out.println("ETCase : " + AssessmentETCase.getProperty("AssessmentETCase"));

		String name = AssessmentETCase.getProperty("AssessmentETCase");

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name, Keys.ENTER);

		Wait.untilPageLoadComplete(driver, 500);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='" + name + "']"))));
		testutil.jsclick(driver.findElement(By.xpath("//*[text()='" + name + "']")), driver);
		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver, 500);
	}

	@Then("user search Assessment Name")
	public void user_search_Assessment_Name() {
		try {

			Properties AssessmentName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
			System.out.println("ETCase : " + AssessmentName.getProperty("AssessmentName"));

			String name = AssessmentName.getProperty("AssessmentName");

			Thread.sleep(3000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
			contact.objsearchField.sendKeys(name, Keys.ENTER);
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			List<WebElement> li = driver.findElements(By.xpath("//*[text()='" + name + "']"));
			assertion.CheckAssertionTrue(!li.isEmpty(), name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user click on Assessment name")
	public void user_click_on_Assessment_name() throws IOException {
		try {
			Properties AssessmentName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
			System.out.println("ETCase : " + AssessmentName.getProperty("AssessmentName"));

			Thread.sleep(2000);
			testutil.jsclick(
					driver.findElement(By.xpath("//*[text()='" + AssessmentName.getProperty("AssessmentName") + "']")),
					driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user click on ET CASE")
	public void user_click_ET_CASE() {
		try {

			Properties AssessmentETCase = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
			System.out.println("ETCase : " + AssessmentETCase.getProperty("AssessmentETCase"));

			String option = AssessmentETCase.getProperty("AssessmentETCase");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//*[text()='" + option + "']")));
			System.out.println("Option is == " + option);
			Thread.sleep(3000);
			contact.clickOn(option);
			Thread.sleep(3000);
			List<WebElement> li = driver.findElements(By.xpath("//button[@aria-label='Confirm']"));
			if (li.size() != 0)
				testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Confirm']")), 1);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("read the Assessment details")
	public void read_the_Assessment_details() throws InterruptedException {

		assessmentDetails.put("Assessment",
				driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title"));
		System.out.println("Assessment Assessment is ::  " + assessmentDetails.get("Assessment"));

		assessmentDetails.put("ActionPlan", driver.findElement(By.xpath(
				"//ul[@data-id='po_action_planid.fieldControl-LookupResultsDropdown_po_action_planid_SelectedRecordList']"))
				.getAttribute("textContent"));
		System.out.println("Assessment ActionPlan is ::  " + assessmentDetails.get("ActionPlan"));

		assessmentDetails.put("ETCase",
				driver.findElement(By.xpath(
						"//ul[@data-id='po_etcase.fieldControl-LookupResultsDropdown_po_etcase_SelectedRecordList']"))
						.getAttribute("textContent"));
		System.out.println("Assessment ETCase is ::  " + assessmentDetails.get("ETCase"));

		Thread.sleep(3000);

		testutil.clickOn(driver,
				driver.findElement(By.xpath("//button[contains(@aria-label,'More Header Editable Fields')]")), 10);

		assessmentDetails.put("ContactAssessed", driver.findElement(By.xpath(
				"//ul[@data-id ='header_po_contactassessed.fieldControl-LookupResultsDropdown_po_contactassessed_SelectedRecordList']"))
				.getAttribute("textContent"));
		System.out.println("Assessment ContactAssessed is ::  " + assessmentDetails.get("ContactAssessed"));

		assessmentDetails.put("ModifiedBy", driver.findElement(By.xpath(
				"//ul[@data-id ='header_modifiedby.fieldControl-LookupResultsDropdown_modifiedby_SelectedRecordList']"))
				.getAttribute("textContent"));
		System.out.println("Assessment ModifiedBy is ::  " + assessmentDetails.get("ModifiedBy"));

		assessmentDetails.put("ETO",
				driver.findElement(By.xpath(
						"//ul[@data-id ='header_po_eto.fieldControl-LookupResultsDropdown_po_eto_SelectedRecordList']"))
						.getAttribute("textContent"));
		System.out.println("Assessment ETO is ::  " + assessmentDetails.get("ETO"));

		assessmentDetails.put("PersonReference",
				driver.findElement(
						By.xpath("//input[@data-id ='header_po_person_reference.fieldControl-text-box-text']"))
						.getAttribute("title"));
		System.out.println("Assessment PersonReference is ::  " + assessmentDetails.get("PersonReference"));

		assessmentDetails.put("MobilePhone",
				driver.findElement(By.xpath("//input[@data-id ='header_po_mobilephone.fieldControl-text-box-text']"))
						.getAttribute("title"));
		System.out.println("Assessment MobilePhone is ::  " + assessmentDetails.get("MobilePhone"));

		assessmentDetails.put("HomeNumber",
				driver.findElement(By.xpath("//input[@data-id ='header_po_homephone.fieldControl-text-box-text']"))
						.getAttribute("title"));
		System.out.println("Assessment HomeNumber is ::  " + assessmentDetails.get("HomeNumber"));

		assessmentDetails.put("ReasonforEnrolment",
				driver.findElement(
						By.xpath("//select[@data-id ='header_po_reasonforenrolment.fieldControl-option-set-select']"))
						.getAttribute("title"));
		System.out.println("Assessment ReasonforEnrolment is ::  " + assessmentDetails.get("ReasonforEnrolment"));

	}

	@Then("user validate the fields are mapped from Assessment")
	public void user_validate_the_fields_are_mapped_from_Assessment() {
		try {

			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//ul[contains(@data-id,'contact')]")).getAttribute("textContent")
							.contains(assessmentDetails.get("ContactAssessed")),
					assessmentDetails.get("ContactAssessed"));
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//ul[contains(@data-id,'eto')]"))
					.getAttribute("textContent").contains(assessmentDetails.get("ETO")), assessmentDetails.get("ETO"));
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//ul[contains(@data-id,'assessment')]")).getAttribute("textContent"),
					assessmentDetails.get("Assessment"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate Action plan associated to the Assessment is showing in the Action Plan Grid")
	public void user_validate_Action_plan_associated_to_the_Assessment_is_showing_in_the() throws IOException {
		try {
			String Expected = driver.findElement(By.xpath("//div[contains(@data-lp-id,'po_actionplan')]"))
					.getAttribute("textContent");
			assertion.CheckAssertionTrue(Expected.contains(assessmentDetails.get("ActionPlan")), "Action Plan Grid");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate the following grids are displayed")
	public void user_validate_the_following_grids_are_displayed(io.cucumber.datatable.DataTable dataTable) {
		try {
			List<String> actual = dataTable.asList();
			System.out.println(" Size of the data table is : " + actual.size());
			for (int i = 0; i <= actual.size() - 1; i++) {
				Thread.sleep(4000);
				String expected = driver.findElement(By.xpath("//div[@aria-label='Outcomes']"))
						.getAttribute("outerText");
				System.out.println(expected);
				Thread.sleep(2000);
				assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user click on any active ET Case name")
	public void user_click_on_ET_Case_name() throws IOException {
		try {
			Thread.sleep(2000);

			Properties ActiveETCase = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ETCase.properties");
			System.out.println("ETCase : " + ActiveETCase.getProperty("ActiveETCase"));

			contact.objsearchField.sendKeys(ActiveETCase.getProperty("ActiveETCase"), Keys.ENTER);

			testutil.jsclick(
					driver.findElement(By.xpath("//*[text()='" + ActiveETCase.getProperty("ActiveETCase") + "']")),
					driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user read the ETCaseContactName")
	public void user_read_the_ETCaseContactName_name() {
		try {

			ETcaseDetails.put("ETCaseContactName", driver.findElement(By.xpath(
					"//div[@data-id='po_contactname.fieldControl-LookupResultsDropdown_po_contactname_selected_tag']"))
					.getAttribute("textContent"));
			System.out.println("ETCaseContactName is ::  " + ETcaseDetails.get("ETCaseContactName"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user read the ETCaseContactName Phonenumber")
	public void user_read_the_ETCaseContactName_Phonenumber()
	{
		try {
			testutil.clickOn(driver, driver.findElement(By.xpath(
					"//div[@data-id='po_contactname.fieldControl-LookupResultsDropdown_po_contactname_selected_tag_text']")), 10);
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Gender']")));

			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Account']")));

			ETcaseDetails.put("MobileNumber",
				driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).getAttribute("title"));
System.out.println("MobileNumber is ::  " + ETcaseDetails.get("MobileNumber"));

Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Then("user validate ET Case Contact mobile Number is autopopulate in {string} under SMS Message Activity")
	public void user_validate_ET_Case_Contact_mobile_Number_is_autopopulate_in_Mobile_Phone_Number_under_under_SMS_Message_Activity(String string)
	{
		 System.out.println(ETcaseDetails.get("MobileNumber"));
			String val = driver
					.findElement(By.xpath("//input[@aria-label='Phone Number']"))
					.getAttribute("title");
			assertion.CheckAssertionTrue(ETcaseDetails.get("MobileNumber").contains(val),
					ETcaseDetails.get("MobileNumber"));
	}
	
	@Then("user validate ET Case Contact mobile Number is autopopulate in {string} under Phone Call Activity")
	public void user_validate_ET_Case_Contact_mobile_Number_is_autopopulate_in_Mobile_Phone_Number_under_Phone_Call_Activity(String string)
	{
		 System.out.println(ETcaseDetails.get("MobileNumber"));
			String val = driver
					.findElement(By.xpath("//input[@aria-label='Mobile Phone']"))
					.getAttribute("title");
			assertion.CheckAssertionTrue(ETcaseDetails.get("MobileNumber").contains(val),
					ETcaseDetails.get("MobileNumber"));
	}
	
	@Then("user validate ET Contacts name is autopopulate in {string} under Phone Call Activity")
	public void user_validate_Contact_TO_under_under_Phone_Call_Activity1(String string) {

		System.out.println(ETcaseDetails.get("ETCaseContactName"));
		String val = driver
				.findElement(By.xpath("//div[@data-id='to.fieldControl-LookupResultsDropdown_to_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ETcaseDetails.get("ETCaseContactName").contains(val),
				ETcaseDetails.get("ETCaseContactName"));

	}

	@Then("user read the ETCaseTitle")
	public void user_read_the_ETCaseTitle() {
		try {

			ETcaseDetails.put("ETCaseTitle",
					driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title"));
			System.out.println("ETCaseTitle is ::  " + ETcaseDetails.get("ETCaseTitle"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	@Then("user validate ETCase PhoneNumber is autopopulate in {string} under Phone Call Activity")
	public void user_validate_PhoneNumber_is_autopopulate_in_Phone_Number_under_Phone_Call_Activity(String string)
	{
		System.out.println( ETcaseDetails.get("PhoneNumber"));
		String val = driver
				.findElement(By.xpath("//input[@aria-label='Phone Number']"))
				.getAttribute("title");
		assertion.CheckAssertionTrue( ETcaseDetails.get("PhoneNumber").contains(val),
				ETcaseDetails.get("PhoneNumber"));
	}

	@Then("user validate Contact name is autopopulate in {string} under Email Activity")
	public void user_validate_TO_under_Email_Activity(String string) {

		System.out.println(ETcaseDetails.get("ETCaseContactName"));
		String val = driver
				.findElement(By.xpath("//*[@data-id='to.fieldControl-LookupResultsDropdown_to_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ETcaseDetails.get("ETCaseContactName").contains(val),
				ETcaseDetails.get("ETCaseContactName"));

	}

	@Then("user validate CaseTitle is autopopulate in {string} under Email Activity")
	public void user_validate_under_Email_Activity(String string) {

		System.out.println(ETcaseDetails.get("ETCaseTitle"));
		String val = driver.				
				findElement(By.xpath("//*[@data-id='regardingobjectid.fieldControl-LookupResultsDropdown_regardingobjectid_selected_tag']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ETcaseDetails.get("ETCaseTitle").contains(val), ETcaseDetails.get("ETCaseTitle"));

	}

	@Then("user validate {string} grid exist with following fields")
	public void user_validate_grid_exist_with_following_fields(String string, DataTable dataTable) {
		try {
			List<String> actual = dataTable.asList();
			System.out.println(" Size of the data table is : " + actual.size());
			Thread.sleep(2000);

			// Locating element by link text and store in variable "Element"
			WebElement Element = driver.findElement(By.xpath("//section[@aria-label='" + string + "']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i <= actual.size() - 1; i++) {
				String expected = driver.findElement(By.xpath("//div[@aria-label='Outcomes']"))
						.getAttribute("outerText");
				System.out.println(expected);
				Thread.sleep(2000);
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", Element);
				assertion.CheckAssertionTrue(expected.contains(actual.get(i)), actual.get(i));
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user creates {string} as {string}")
	public void user_creates_as_and_validates_in_grid(String string, String string2) throws Exception {
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//section[contains(@aria-label,'" + string2 + "')]")));
			testutil.clickOn(driver,
					driver.findElement(
							By.xpath("//section[contains(@aria-label,'" + string2 + "')]//*[text()='New Outcome']")),
					10);
			Thread.sleep(2000);
			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Outcome Type']")),
					string2);
			Thread.sleep(2000);
			System.out.println(string2);

			if (string2.contains("Job")) {
				System.out.println("executing job");
				dates = outcome_et.enterDetailsJobSection();
				outcome_et.enterDetailsRentAccountCaptureSection();
				outcome_et.EnterDetailSustainment_ChecksSection();
				System.out.println("job done");
			}

			if (string2.contains("Training")) {
				System.out.println("executing Training");
				outcome_et.EnterDetailsTrainingSection("Training Outcome");
			}

			if (string2.contains("Wellbeing")) {
				System.out.println("executing Wellbeing");
				outcome_et.enterWellbeingSection();
			}

			if (string2.contains("Work Placement")) {
				System.out.println("executing Wellbeing");
				etCase_et.enterDetailsWorkPlacementOutcomeSection();
			}

			if (string2.contains("Volunteering")) {
				System.out.println("executing Wellbeing");
				etCase_et.enterDetailsVolunteeringsection();
			}

			Thread.sleep(6000);
			Thread.sleep(4000);
//			if  (!driver.findElements(By.xpath("//button[@aria-label='Save and continue']")).isEmpty())
//				testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save and continue']")), 10);
//			else
//			if  (!driver.findElements(By.xpath("//button[@aria-label='Save (CTRL+S)']")).isEmpty())
			testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 10);
			
			Thread.sleep(5000);
			testutil.jsclick(driver.findElement(By.xpath("//button[@aria-label='Press Enter to go back.']")), driver);
			Thread.sleep(4000);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validates the Job Outcomes for {string}")
	public void user_validates_the_grid_(String string) throws Exception {
		actions.click(driver.findElement(
				By.xpath("//section[@aria-label='Job Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
				.build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Filter by value']")), string).build()
				.perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
		Thread.sleep(4000);
		System.out.println(string + " grid values are "
				+ driver.findElement(By.xpath("//section[@aria-label='Job Outcomes']")).getAttribute("textContent"));
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Job Outcomes']"))
				.getAttribute("textContent").contains(string), string);

	}

	@Then("user validates the Work Placement for {string}")
	public void user_validates_the_grid_Work_Placement(String string) throws Exception {

		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Work Placement Outcomes')]")));
		Thread.sleep(2000);
		// testutil.jsclick(driver.findElement(By.xpath("//section[@aria-label='Work
		// Placement Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")),
		// driver);
		actions.moveToElement(driver.findElement(By.xpath(
				"//section[@aria-label='Work Placement Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")));
		actions.click(driver.findElement(By.xpath(
				"//section[@aria-label='Work Placement Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
				.build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Filter by value']")), string).build()
				.perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
		Thread.sleep(2000);
		System.out.println(string + " grid values are " + driver
				.findElement(By.xpath("//section[@aria-label='Work Placement Outcomes']")).getAttribute("textContent"));
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Work Placement Outcomes']"))
				.getAttribute("textContent").contains(string), string);
	}

	@Then("user validates the Volunteering Outcomes for {string}")
	public void user_validates_the_Volunteering_Outcomes(String string) throws Exception {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Volunteering Outcomes')]")));
		Thread.sleep(2000);
		// testutil.jsclick(driver.findElement(By.xpath("//section[@aria-label='Work
		// Placement Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")),
		// driver);
		actions.moveToElement(driver.findElement(By.xpath(
				"//section[@aria-label='Volunteering Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")));
		actions.click(driver.findElement(By.xpath(
				"//section[@aria-label='Volunteering Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
				.build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Filter by value']")), string).build()
				.perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
		Thread.sleep(2000);
		System.out.println(string + " grid values are " + driver
				.findElement(By.xpath("//section[@aria-label='Volunteering Outcomes']")).getAttribute("textContent"));
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Volunteering Outcomes']"))
				.getAttribute("textContent").contains(string), string);
	}

	@Then("user validates the Training Outcomes for {string}")
	public void user_validates_the_Training_Outcomes(String string) throws Exception {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Training Outcomes')]")));
		Thread.sleep(2000);
		actions.moveToElement(driver.findElement(By.xpath(
				"//section[@aria-label='Training Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")));
		actions.click(driver.findElement(By
				.xpath("//section[@aria-label='Training Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
				.build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//span[text()='Accredited Training']"))).build().perform();
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
		Thread.sleep(2000);
		System.out.println(string + " grid values are " + driver
				.findElement(By.xpath("//section[@aria-label='Training Outcomes']")).getAttribute("textContent"));
		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Training Outcomes']"))
				.getAttribute("textContent").contains(string), string);

	}

	@Then("user validate the message {string}")
	public void user_validate_the_message(String string) {

		String Expected = driver.findElement(By.xpath("//*[@aria-labelledby='message-formReadOnlyNotification']"))
				.getAttribute("textContent");
		System.out.println("Expected is : " + Expected);
		System.out.println("Actual is : " + string);
		assertion.CheckAssertionTrue(Expected.contains(string), string);

	}

	@Then("user validate ET case Editable")
	public void user_validate_ET_case_Editable() {
		assertion.CheckAssertionTrue(
				driver.findElement(By.xpath("//button[contains(@title,'Deactivate')]")).isDisplayed(), "Deactivate");
	}

	@Then("user validate the fields in ET Case Reason for Closure")
	public void user_validate_the_fields_in_ET_Case_Reason_for_Closure() {

	}

	@Then("user validates the Wellbeing Outcomes grid")
	public void user_validates_the_Wellbeing_Outcomes_grid() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Wellbeing Outcomes')]")));
		Thread.sleep(2000);

		assertion.CheckAssertionTrue(driver.findElement(By.xpath(
				"//section[@aria-label='Wellbeing Outcomes']//div[@aria-rowindex='2']//div[@aria-colindex='3']")),
				workingDir);

	}

}
