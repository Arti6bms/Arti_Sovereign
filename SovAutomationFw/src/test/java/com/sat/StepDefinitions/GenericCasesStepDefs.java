package com.sat.StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.Pages.ContactForm;
import com.sat.Pages.GenericCases;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenericCasesStepDefs {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();

	GenericCases genericCases = new GenericCases(driver);
	Testutil testUtil = new Testutil(driver);
	Assertions assertion = new Assertions(driver);
	String strCasetitle, strCaseNumber;
	String[] strcaseTitleSplit;
	Actions action = new Actions(driver);
	public ContactForm contact = new ContactForm(driver);
	Map<String, String> map = new HashMap<String, String>();
	String workingDir = System.getProperty("user.dir");

	@Given("user click on New Cases")
	public void user_click_on_New_Cases() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).size() != 0)
			driver.findElement(By.xpath("//button[@aria-label='Discard changes']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		genericCases.clickOnNewCases();
		System.out.println("User clicked on new cases");
	}

	@Then("user enter all mandatory fields")
	public void user_enter_all_mandatory_fields() {
		genericCases.enterMandatoryFields();
	}

	@Then("user change risk priority and status")
	public void user_change_risk_priority_and_status() {
		genericCases.changeRiskPriority();
	}

	@And("user validate case title,owner name and an auto post has been created on the case timeline")
	public void user_validate_an_auto_post_has_been_created_on_the_case_timeline() throws InterruptedException {
		System.out.println("validatingAutoPostAndCaseTitle");
		genericCases.validateAutoPostAndCaseTitle();
		Thread.sleep(3000);
	}

	@When("user search Case Title and click on contact name link")
	public void user_search_Case_Title_click_on_any_contact_name_link() throws InterruptedException {
		try {
			genericCases.SearchandClickoncontactname();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user click on Dashboard Drop Down List")
	public void user_click_on_Dashboard_drop_Down_List() {

		genericCases.clickOndashboardDropDownList();
	}

	@Then("user validate owner name and assign to me")
	public void user_click_on_Add_button() throws InterruptedException {
		genericCases.validateuser();
	}

	@Then("user select any record")
	public void user_select_any_record() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='3']//a")).click();

	}

	@Then("user validate case notification in their queue")
	public void user_validate_case_notification_in_their_queue() throws InterruptedException {
		genericCases.validateCaseNotification();
	}

	@Then("user Hover on the first appointment click on the Close Activity\\(tick mark)")
	public void user_Hover_on_the_first_appointment_click_on_the_Close_Activity_tick_mark()
			throws InterruptedException {
		genericCases.closeActivity();
	}

	@Then("user Select State as {string} and Status {string} and click on Close Appointment")
	public void user_Select_State_as_and_Status_and_click_on_Close_Appointment(String state, String status)
			throws InterruptedException {
		genericCases.selectStateAndStatus(state, status);
	}

	@Then("user Select State as {string} and click on Close Appointment")
	public void user_Select_State_as_and_click_on_Close_Appointment(String state) throws InterruptedException {
		genericCases.selectState(state);
	}

	@Then("user click on closed appointment record from timeline validates the text")
	public void user_click_on_closed_appointment_record_from_timeline() throws InterruptedException {
		genericCases.openAppointmentAndVerify();
	}

	@Then("user select case monitored as Yes and enter manager")
	public void user_select_case_monitored_as_Yes_and_enter_manager() {
		genericCases.selectCaseMonitoredAndManager();
	}

	@Then("user clear case monitored and manager")
	public void user_clear_case_monitored_and_manager() throws InterruptedException {
		genericCases.clearCaseMonitoredAndManager();
	}

	@Then("user verify case monitored as No")
	public void user_verify_case_monitored_as_No() throws InterruptedException {
		genericCases.verifyCaseMonitoredAsNo();
	}

	@Then("user refresh page")
	public void user_refresh_page() throws InterruptedException {
		genericCases.refreshPage();
	}

	@Then("user open activity enter outcome and Complete with the tick mark")
	public void user_open_activity_enter_outcome_and_Complete_with_the_tick_mark() throws InterruptedException {
		genericCases.enterOutcomeAndComplete();
	}

	@Then("user enter cutomer,category and subcategory")
	public void user_enter_cutomer_category_and_subcategory() {
		genericCases.enterCategorySubcategory();
	}

	@Then("Validate the fields have been hidden from the case form")
	public void validate_the_fields_have_been_hidden_from_the_case_form(DataTable dataTable) {
		genericCases.validateHiddenField(dataTable);
	}

	@Then("user validate the case title")
	public void user_validate_the_case_title_as(DataTable datatable) {
		List<String> actual = datatable.asList();
		try {
			strCasetitle = genericCases.getCaseTitleTextValue();
			strCaseNumber = genericCases.getCaseNumberTextValue();
			System.out.println("case number returned is= " + strCaseNumber);
			

			strcaseTitleSplit = strCasetitle.split(",", -2);
			Integer casetitlelength = strcaseTitleSplit.length;
			System.out.println("case title returned is= " + strCasetitle);
			map.put("strCasetitle", strCasetitle);
			System.out.println("Length of case title:- " + casetitlelength);
			String ExpectedValue = actual.get(0) + ", " + actual.get(1) + "," + strcaseTitleSplit[casetitlelength - 1];
			System.out.println("Actual is :" + strCasetitle);
			System.out.println("Expected is :" + ExpectedValue);
			assertion.CheckAssertion(strCaseNumber.trim(), strcaseTitleSplit[casetitlelength - 1].trim());
			// Assert.assertEquals(strCaseNumber.trim(),
			// strcaseTitleSplit[casetitlelength-1].trim());
			// Assert.assertEquals(strCasetitle, ExpectedValue);
			assertion.CheckAssertion(strCasetitle, ExpectedValue);
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	@Then("user search Case Title")
	public void user_search_Case_Title() throws IOException {
		Properties ReadProperties = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Complaints.properties");

		map.get("strCasetitle");
		System.out.println(map.get("strCasetitle"));
		
		System.out.println(ReadProperties.getProperty("CaseTitle"));

		String name = ReadProperties.getProperty("CaseTitle");

		try {
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
	
	@Then("user select any Case Title")
	public void user_select_any_property() {

		try {
			Thread.sleep(2000);
			String PropertName = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a"))
					.getAttribute("textContent");
			map.put("PropertName", PropertName);

			Thread.sleep(2000);
			testUtil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validate case Owner as {string}")
	public void the_case_Owner_should(String actualOwnerName) throws InterruptedException {
		genericCases.validateOwnerName(actualOwnerName);
	}
	
	@Then("user validate default queue name as {string}")
	public void the_default_Queue_name(String actualdefaultQueueName) throws InterruptedException {
		genericCases.validateDefaultQueueName(actualdefaultQueueName);
		System.out.println("Default queue value exist");
	}

	@Then("user verify the Customer as {string}")
	public void user_verify_the_Customer_as(String customer) {
		genericCases.validateCustomerField(customer);
	}

	@Then("user enter Safeguarding Case Category,Safeguarding Type Category and description")
	public void user_enter_Safeguarding_Case_Category_Safeguarding_Type_Category_and_description() {
		genericCases.enterSafeguardingCaseType();
	}

	@Then("user verify the Asset, Local Authority & Area office has populated")
	public void user_verify_the_Asset_Local_Authority_Area_office_has_populated() {
	}

	@Then("user Click on Initial Risk Prioritisation tab & complete the {int} questions")
	public void user_Click_on_Initial_Risk_Prioritisation_tab_complete_the_questions(Integer int1) {
	}

	@Then("user verifies {string} field exists")
	public void user_verifies_field_exists(String fieldName) {
		Boolean fieldExistsOrNot = genericCases.fieldExistsOrNot(fieldName);
		System.out.println(fieldExistsOrNot);
	}

	@Then("user validate {string} grid is displayed on the Case form")
	public void user_validate_Witness_grid_is_displayed_on_the_Case_form(String gridname)
			throws NumberFormatException, Exception {
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='" + gridname + "']")));

			System.out.println("result = " + driver.findElements(By.xpath("//h3[text()='" + gridname + "']")).size());
			assertion.CheckAssertion(Integer.parseInt("1"),
					driver.findElements(By.xpath("//h3[text()='" + gridname + "']")).size());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user Navigate to Witness grid and click More options and Click on + New Connection")
	public void user_Navigate_to_Witness_grid_and_click_More_options_and_Click_on_New_Connection() {

		genericCases.objMoreCommands.click();
		genericCases.objNewConnection.click();

	}

	@Then("user validates if created ASB Connection record is displayed in Witnesses Grid")
	public void user_validates_if_created_ASB_Connection_record_is_displayed_in_Witnesses_Grid() {
		try {
			driver.findElement(By.xpath("//button[@title='Go back']")).click();
			contact.clickOnTab("Summary");
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.xpath("//*[@aria-label='Witness Connections']//li[1]"))).build()
					.perform();
			System.out.println(driver.findElement(By.xpath("//*[@aria-label='Witness Connections']//li[1]"))
					.getAttribute("innerText"));
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//*[@aria-label='Witness Connections']//li[1]"))
					.getAttribute("innerText").contains("Jerrilee Shepherd"), "Jerrilee Shepherd");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies {string} value exists")
	public void user_verifies_value_exists(String value) {
		
		Boolean fieldExistsOrNot = genericCases.fieldExistsOrNot(value);
		System.out.println(fieldExistsOrNot);
	}

}
