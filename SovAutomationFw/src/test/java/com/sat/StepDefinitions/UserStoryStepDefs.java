package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.Pages.ContactForm;
import com.sat.Pages.Optimization;
import com.sat.Pages.PhoneCallsFunctionality;
import com.sat.Pages.UserStory;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Log;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class UserStoryStepDefs {
	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	UserStory userStory = new UserStory(driver);
	Testutil testUtil = new Testutil(driver);
	Assertions assertion = new Assertions(driver);
	Actions actions = new Actions(driver);
	String workingDir = System.getProperty("user.dir");
	ContactForm contact = new ContactForm(driver);
	HashMap<String, String> phone = new HashMap<>();
	HashMap<String, String> ContactDetails = new HashMap<>();
	Optimization optimization = new Optimization(driver);
	PhoneCallsFunctionality phonecall = new PhoneCallsFunctionality(driver);
	Map<String, String> userdetails = new HashMap<String, String>();

	@Then("user verify {string} filed is Locked")
	public void user_verify_filed_is_Locked(String string) {
		String actual = userStory.validateLockedField(string);
		System.out.println("Locked Field : " + actual);
		assertion.CheckAssertionTrue(actual.contains("Locked"), "");

	}

	@Then("user delete the case")
	public void user_delete_case_() throws InterruptedException {
		try {
			String option = "Delete";
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//span[text()='" + option + "']")));
			System.out.println("Option is == " + option);
			Thread.sleep(3000);
			contact.clickOn(option);
			Thread.sleep(3000);
			List<WebElement> li = driver.findElements(By.xpath("//button[@aria-label='Delete']"));
			if (li.size() != 0)
				testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Delete']")), 1);
			Thread.sleep(6000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on More commands for Contact button")
	public void user_click_on_contact_button() {
		try {
			testUtil.clickOn(driver, optimization.objMorecommandsforContact, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verify all the {string} list values")
	public void user_verify_all_the_list_value(String field, DataTable dataTable) {
		try {
			List<String> actual = dataTable.asList();
			String expected = userStory.validateListValue(field);
			System.out.println("Expected : " + expected);
			// String[] arrlstValues = listofvalues.split("\\n");
			System.out.println(actual.size());
			for (int i = 0; i <= actual.size() - 1; i++) {
				// System.out.println(actual.get(i));
				System.out.println("Actual : " + actual.get(i));
				Wait.untilPageLoadComplete(driver, 500);
				Assert.assertTrue(expected.contains(actual.get(i)));
				Wait.untilPageLoadComplete(driver, 200);
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("user validate Originating Neighbourhood fields is auto populated")
	public void user_validate_Originating_Neighbourhood_fields_is_auto_populated() {
		userStory.validateAutoPopulatedField();
	}

	@Then("user verify the new values as {string} and {string} in {string}")
	public void user_verify_the_and(String string, String string2, String string3) {

		try {
			Thread.sleep(5000);
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='audit_iframe']")));
			String expected = driver.findElement(By.xpath("//*[@role='row' and @otypename ='audit' ][1]/td[7]"))
					.getAttribute("textContent");

			// walkabouts
			assertion.CheckAssertionTrue(expected.contains(string), string);

			// rating
			assertion.CheckAssertionTrue(expected.contains(string2), string2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate {string} field as {string}")
	public void user_validate_field_as(String string, String string2) throws IOException {
		String expected = driver.findElement(By.xpath("//input[@aria-label='Date of Walkabout Completion Date']"))
				.getAttribute("defaultValue");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());
		assertion.CheckAssertion(expected, currentdate);
	}

	@Then("user verify the Owner as {string}")
	public void user_verify_the_Owner_as(String string) throws IOException, InterruptedException {
		Thread.sleep(1500);

		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@id='headerControlsList_3']//a"))
				.getAttribute("textContent").contains(string)
				|| driver.findElement(By.xpath("//div[@id='headerControlsList_3']")).getAttribute("textContent")
						.contains(string),
				string);
	}

	@Then("user verify all the lookup values in {string}")
	public void user_verify_all_the_lookup_values_in(String string, io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<String> actual = dataTable.asList();

		// String[] arrlstValues = listofvalues.split("\\n");
		System.out.println(actual.size());
		for (int i = 0; i <= actual.size() - 1; i++) {
			// System.out.println(actual.get(i));
			System.out.println("Actual : " + actual.get(i));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@aria-label='Case Closure Reason, Lookup']")).click();
			Thread.sleep(1500);
			actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Case Closure Reason, Lookup']")),
					actual.get(i)).build().perform();
			Thread.sleep(1500);
			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//li[@aria-label='" + actual.get(i) + "']")).size() != 0,
					actual.get(i));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@aria-label='Case Closure Reason, Lookup']"))
					.sendKeys(Keys.CONTROL + "A");
			Thread.sleep(1500);
			actions.sendKeys(Keys.BACK_SPACE).build().perform();
		}

	}

	@Then("user search Referral Name having Mobile Phone")
	public void user_search_Referral_Name_having_Mobile_Phone() {
		try {

			Properties ReferralName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("ETCase : " + ReferralName.getProperty("ReferralName_MobilePhone"));

			String name = ReferralName.getProperty("ReferralName_MobilePhone");

			Thread.sleep(3000);
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

	@Then("user search Referral Name having Mobile Phone 2")
	public void user_search_Referral_Name_having_Mobile_Phone2() {
		try {

			Properties ReferralName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("ETCase : " + ReferralName.getProperty("ReferralName_MobilePhone2"));

			String name = ReferralName.getProperty("ReferralName_MobilePhone2");

			Thread.sleep(3000);
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

	@Then("user search Referral Name having Home Phone")
	public void user_search_Referral_Name_having_Home_Phone() {
		try {

			Properties ReferralName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("ETCase : " + ReferralName.getProperty("ReferralName_HomePhone"));

			String name = ReferralName.getProperty("ReferralName_HomePhone");

			Thread.sleep(3000);
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

	@Then("user search Referral Name having Work Phone")
	public void user_search_Referral_Name_having_Work_Phone() {
		try {

			Properties ReferralName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("ETCase : " + ReferralName.getProperty("ReferralName_WorkPhone"));

			String name = ReferralName.getProperty("ReferralName_WorkPhone");

			Thread.sleep(3000);
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

	@Then("user click on Referral name")
	public void user_click_on_Assessment_name() throws IOException {
		try {

			Thread.sleep(2000);
			testUtil.jsclick(driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")),
					driver);
			System.out.println("Clicked on referral name");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user Click on Contact link")
	public void user_Click_on_Contact_link() throws InterruptedException {
		// actions.moveToElement(driver.findElement(By.xpath("//ul[@data-id='po_contactname.fieldControl-LookupResultsDropdown_po_contactname_SelectedRecordList']"))).build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//ul[contains(@data-id,'SelectedRecordList')]"))).build()
				.perform();

		Thread.sleep(2000);

		// testUtil.jsclick(driver.findElement(By.xpath("//*[@data-id='po_contactname.fieldControl-LookupResultsDropdown_po_contactname_selected_tag']")),
		// driver);
		testUtil.jsclick(driver.findElement(By.xpath("//*[contains(@data-id,'selected_tag')]")), driver);

		System.out.println("Clicked on Contact Link");

		Thread.sleep(2000);

	}

	@Then("user clear the {string} field")
	public void user_clear_the_field(String string) throws InterruptedException {
		driver.findElement(By.xpath("//input[@aria-label='" + string + "']")).sendKeys(Keys.CONTROL + "A");
		Thread.sleep(2000);
		actions.sendKeys(Keys.BACK_SPACE).build().perform();
	}

	@Then("user read the phone numbers")
	public void user_read_the_phone_numbers() throws InterruptedException {
		actions.click(driver.findElement(By.xpath("//h2[@title='GENERAL INFORMATION']"))).build().perform();
		Thread.sleep(3000);
		actions.click(driver.findElement(By.xpath("//label[text()='Title']"))).build().perform();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Age']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Account']")));

//		for (int i = 0; i <= 15; i++) {
//			Thread.sleep(1500);
//			actions.sendKeys(Keys.TAB).build().perform();
//			//actions.sendKeys(Keys.END).build().perform();
//			Thread.sleep(2000);
//		}

		Thread.sleep(2000);
		phone.put("Mobile Phone",
				driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).getAttribute("title"));
		phone.get("Mobile Phone");
		phone.put("Home Phone",
				driver.findElement(By.xpath("//input[@aria-label='Home Phone']")).getAttribute("title"));

		phone.put("Mobile Phone2",
				driver.findElement(By.xpath("//input[@aria-label='Mobile Phone 2']")).getAttribute("title"));

		phone.put("Work Phone",
				driver.findElement(By.xpath("//input[@aria-label='Work Phone']")).getAttribute("title"));

		System.out.println("User reading Mobile Phone Number");
		System.out.println(phone.get("Mobile Phone"));

		System.out.println("User reading Home Phone Number");
		System.out.println(phone.get("Home Phone"));

		System.out.println("User reading Mobile Phone Number 2");
		System.out.println(phone.get("Mobile Phone2"));

		System.out.println("User reading Work Phone Number");
		System.out.println(phone.get("Work Phone"));
	}

	@Then("user validate the phone number is displayed correctly when Mobile Phone exists")
	public void user_validate_the_phone_number_is_displayed_correctly() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@aria-label='SMS Message']")).sendKeys("smstext");
		Thread.sleep(4000);
		String s = driver.findElement(By.xpath("//input[@data-id='posms_phonenumber.fieldControl-text-box-text']"))
				.getAttribute("title");
		System.out.println("Actual Phone Number is : " + s);
		Thread.sleep(4000);

		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 10);
		Thread.sleep(4000);

		System.out.println("Expected Phone Number is : " + phone.get("Mobile Phone"));

		assertion.CheckAssertionTrue(s.contains(phone.get("Mobile Phone")), s);

	}

	@Then("user validate the phone number is displayed correctly when Mobile Phone 2 exists")
	public void user_validate_the_phone_number_is_displayed_correctly2() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@aria-label='SMS Message']")).sendKeys("smstext");
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 10);
		String s = driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title");
		System.out.println(s);
		phone.put("Phone Number",
				driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title"));
		System.out.println(phone.get("Phone Number"));
		assertion.CheckAssertionTrue(phone.get("Phone Number").contains(phone.get("Mobile Phone2")), s);

	}

	@Then("user validate the phone number is displayed correctly when Home Phone exists")
	public void user_validate_the_phone_number_is_displayed_correctly_home_mobile() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@aria-label='SMS Message']")).sendKeys("smstext");
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 10);
		String s = driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title");
		System.out.println(s);
		phone.put("Phone Number",
				driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title"));
		System.out.println(phone.get("Phone Number"));
		assertion.CheckAssertionTrue(phone.get("Phone Number").contains(phone.get("Home Phone")), s);

	}

	@Then("user validate the phone number is displayed correctly when Work Phone exists")
	public void user_validate_the_phone_number_is_displayed_correctly_Work_mobile() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@aria-label='SMS Message']")).sendKeys("smstext");
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 10);
		String s = driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title");
		System.out.println(s);
		phone.put("Phone Number",
				driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title"));
		System.out.println(phone.get("Phone Number"));
		assertion.CheckAssertionTrue(phone.get("Phone Number").contains(phone.get("Home Phone")), s);
		Thread.sleep(2000);
	}

	@Then("user Save the {string}")
	public void user_Save_the(String string) throws InterruptedException {
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save and Close']")), 10);
	}

	@Then("user validate Walkabout Frequency as {string}")
	public void user_validate_Walkabout_Frequency_as(String string) throws InterruptedException {
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//select[@aria-label='Walkabout Frequency']"))
				.getAttribute("title");
		System.out.println(actual);
		assertion.CheckAssertionTrue(actual.contains(string), string);
		Thread.sleep(2000);

	}

	@Then("user validate Walkabout Completion Date as current date")
	public void user_validate_Walkabout_Completion_Date_as_current_date() throws InterruptedException {
		Thread.sleep(2000);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());
		System.out.println(currentdate);

		String actual = driver.findElement(By.xpath("//input[@aria-label='Date of Walkabout Completion Date']"))
				.getAttribute("defaultValue");
		assertion.CheckAssertionTrue(actual.contains(currentdate), currentdate);
	}

	@Then("user validates {string} Question contains {string}")
	public void user_validates_Question_contains(String string, String string2) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Q3. When Did it Start?']")));

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Q6. Is this a protected characteristic?']")));

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Q9. Have you called us before about this?']")));

		Thread.sleep(2000);
		actions.click(optimization.objAgreedActions).build().perform();
		Thread.sleep(2000);
		testUtil.clickOn(driver, optimization.objAgreedActionsMenu, 5);
		Thread.sleep(2000);
		testUtil.clickOn(driver, optimization.objAgreedActionsNew, 5);
		Thread.sleep(2000);

		assertion.CheckAssertionTrue(driver
				.findElements(
						By.xpath("//input[@aria-label='Q12. Agreed Actions. Selected: Refer to Coaching (HO/ASBO)']"))
				.size() != 0, string2);

	}

	@Then("user clicks on {string} contact")
	public void user_clicks_on_New_contact(String string) throws InterruptedException {
		Thread.sleep(2000);
		actions.click(driver.findElement(By.xpath("//ul[@aria-label='Contact Commands']//button[@aria-label='New']")))
				.build().perform();
		Thread.sleep(2000);
	}

	@Then("user navigate to the Preferred Language field")
	public void user_navigate_to_the_field() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='First Name']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Age']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Email']")));

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Home Phone']")));

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Email Address 1']")));

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Preferred Language']")));
	}

	@Then("user select one of active Contact")
	public void user_select_Contact_items() throws Exception {
		try {
			Thread.sleep(2000);
			Properties ActiveContact = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("Active ActiveContact : " + ActiveContact.getProperty("ActiveContact"));
			String ActiveContactname = ActiveContact.getProperty("ActiveContact");
			Thread.sleep(4000);
			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Contact Filter by keyword']")),
					10, ActiveContactname);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[contains(@id,'quickFind')]")), 10);
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(driver.findElements(
					// By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']"))
					By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='3']//a")).size() != 0, ActiveContactname);
			Thread.sleep(4000);
			testUtil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='3']//a")), 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user select one of active Account")
	public void user_select_Account_items() throws Exception {
		try {
			Thread.sleep(2000);
			Properties ActiveAccount = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("Active ActiveAccount : " + ActiveAccount.getProperty("ActiveAccount"));
			String ActiveAccountname = ActiveAccount.getProperty("ActiveAccount");
			Thread.sleep(4000);
			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Account Filter by keyword']")),
					10, ActiveAccountname);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[contains(@id,'quickFind')]")), 10);
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(driver.findElements(
					// By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']"))
					By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='3']//a")).size() != 0, ActiveAccountname);
			Thread.sleep(4000);
			testUtil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='3']//a")), 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user read the ContactName")
	public void user_read_the_ContactName() {
		try {

			ContactDetails.put("ContactName",
					driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title"));
			System.out.println("ContactName is ::  " + ContactDetails.get("ContactName"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user read the ContactMobileNumber")
	public void user_read_the_ContactMobileNumber() {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//label[text()='Gender']")));

			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//label[text()='Account']")));

			ContactDetails.put("MobileNumber",
					driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).getAttribute("title"));
			System.out.println("MobileNumber is ::  " + ContactDetails.get("MobileNumber"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate Contacts name is autopopulate in {string} under Phone Call Activity")
	public void user_validate_Contact_TO_under_under_Phone_Call_Activity1(String string) {

		System.out.println(ContactDetails.get("ContactName"));
		String val = driver
				.findElement(By.xpath("//div[@data-id='to.fieldControl-LookupResultsDropdown_to_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ContactDetails.get("ContactName").contains(val),
				ContactDetails.get("ContactName"));

	}

	@Then("user validate Contact mobile Number is autopopulate in {string} under Phone Call Activity")
	public void user_validate_Contact_mobile_Number_is_autopopulate_in_Mobile_Phone_Number_unde_Phone_Call_Activity(
			String string) {
		System.out.println(ContactDetails.get("MobileNumber"));
		String val = driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")).getAttribute("title");
		assertion.CheckAssertionTrue(ContactDetails.get("MobileNumber").contains(val),
				ContactDetails.get("MobileNumber"));

	}

	@Then("user validate Contact mobile Number is autopopulate in {string} under SMS Message Activity")
	public void user_validate_Contact_mobile_Number_is_autopopulate_in_Mobile_Phone_Number_under_SMS_Message_Activity(
			String string) {
		System.out.println(ContactDetails.get("MobileNumber"));
		String val = driver.findElement(By.xpath("//input[@aria-label='Phone Number']")).getAttribute("title");
		assertion.CheckAssertionTrue(ContactDetails.get("MobileNumber").contains(val),
				ContactDetails.get("MobileNumber"));

	}

	@Then("user validate Contacts name is autopopulate in {string} under Email Activity")
	public void user_validate_Contact_TO_under_Email_Activity1(String string) {

		System.out.println(ContactDetails.get("ContactName"));
		String val = driver
				.findElement(By.xpath("//*[@data-id='to.fieldControl-LookupResultsDropdown_to_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ContactDetails.get("ContactName").contains(val),
				ContactDetails.get("ContactName"));

	}

	@Then("user enter the Mobile Phone which does not starts with {int} or +")
	public void user_validate_that_Mobile_Phone_starts_with_or(Integer int1)
			throws IOException, InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Gender']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Account']")));

		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println("Active MobilePhone : " + MobilePhone.getProperty("MobilePhone"));
		String invMobilePhone = MobilePhone.getProperty("MobilePhone");

		testUtil.inputText(driver, "Mobile Phone", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user enter the Mobile Phone starting with {int} having greater than {int} numbers")
	public void user_validate_that_Mobile_Phone_starting_with_must_allow_only_numbers_only(Integer int1, Integer int2)
			throws IOException {

		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("MobilePhonestartingWith07morethan11"));
		String invMobilePhone = MobilePhone.getProperty("MobilePhonestartingWith07morethan11");

		testUtil.inputText(driver, "Mobile Phone", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user enter the invalid Mobile Phone starting with +")
	public void user_validate_that_Mobile_Phone_starting_with_should_take_values_between_to_only() throws IOException {
		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("InvalidMobilePhonestartingWith+"));
		String invMobilePhone = MobilePhone.getProperty("InvalidMobilePhonestartingWith+");

		testUtil.inputText(driver, "Mobile Phone", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user enter the Mobile Phone 2 which does not starts with {int} or +")
	public void user_validate_that_Mobile_Phone2_starts_with_or(Integer int1)
			throws IOException, InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Gender']")));

		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Account']")));

		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println("Active MobilePhone : " + MobilePhone.getProperty("MobilePhone2"));
		String invMobilePhone = MobilePhone.getProperty("MobilePhone2");

		testUtil.inputText(driver, "Mobile Phone 2", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user enter the Mobile Phone 2 starting with {int} having greater than {int} numbers")
	public void user_validate_that_Mobile_Phone2_starting_with_must_allow_only_numbers_only(Integer int1, Integer int2)
			throws IOException {

		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("MobilePhone2startingWith07morethan11"));
		String invMobilePhone = MobilePhone.getProperty("MobilePhone2startingWith07morethan11");

		testUtil.inputText(driver, "Mobile Phone 2", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user enter the invalid Mobile Phone 2 starting with +")
	public void user_validate_that_Mobile_Phone2_starting_with_should_take_values_between_to_only() throws IOException {
		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("InvalidMobilePhone2startingWith+"));
		String invMobilePhone = MobilePhone.getProperty("InvalidMobilePhone2startingWith+");

		testUtil.inputText(driver, "Mobile Phone 2", 10, invMobilePhone);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);

	}

	@Then("user validate {string} as {string}")
	public void user_validate_as(String string, String string2) throws InterruptedException {
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//div[@id='headerControlsList_2']//div[7]"))
				.getAttribute("textContent");
		System.out.println("Actual  = " + actual);
		System.out.println("Expceted  = " + string2);
		assertion.CheckAssertionTrue(actual.contains(string2), actual);
		Thread.sleep(2000);
	}

	@Then("user enter the mobilephone which does not starts with {int} or +")
	public void user_enter_the_Telephone_Mobile_which_does_not_starts_with_or(Integer int1)
			throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Title']")));

		// js.executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(By.xpath("//label[text()='Gender']")));

		// js.executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(By.xpath("//label[text()='Account']")));

		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println("Active MobilePhone : " + MobilePhone.getProperty("MobilePhone"));
		String invMobilePhone = MobilePhone.getProperty("MobilePhone");
		Thread.sleep(4000);
		actions.sendKeys(driver.findElement(By.xpath("//div[@data-id='mobilephone.fieldControl-phone-container']")),
				invMobilePhone).build().perform();

		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);
		Thread.sleep(2000);
	}

	@Then("user enter the mobilephone starting with {int} having greater than {int} numbers")
	public void user_enter_the_Telephone_Mobile_starting_with_having_greater_than_numbers(Integer int1, Integer int2)
			throws IOException, InterruptedException {
		Thread.sleep(4000);
		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("MobilePhonestartingWith07morethan11"));
		Thread.sleep(4000);
		String invMobilePhone = MobilePhone.getProperty("MobilePhonestartingWith07morethan11");

		Thread.sleep(4000);
		System.out.println(invMobilePhone);
		testUtil.inputText(driver, "Telephone (Mobile)", 10, invMobilePhone);
//		actions.sendKeys(driver.findElement(By.xpath("//div[@data-id='mobilephone.fieldControl-phone-container']")),
//				invMobilePhone).build().perform();

		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);
		Thread.sleep(4000);
	}

	@Then("user enter the invalid mobilephone starting with +")
	public void user_enter_the_invalid_Telephone_Mobile_starting_with() throws IOException, InterruptedException {
		Thread.sleep(2000);
		Properties MobilePhone = testUtil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
		System.out.println(" MobilePhone : " + MobilePhone.getProperty("InvalidMobilePhone2startingWith+"));
		String invMobilePhone = MobilePhone.getProperty("InvalidMobilePhone2startingWith+");
		Thread.sleep(4000);
		actions.sendKeys(driver.findElement(By.xpath("//div[@data-id='mobilephone.fieldControl-phone-container']")),
				invMobilePhone).build().perform();
		Thread.sleep(4000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Save']")), 10);
	}

	@Then("user add the Team {string}")
	public void user_add_the_Team(String string) throws InterruptedException {

		System.out.println(System.getProperty("user"));

		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Settings']")), 10);
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Advanced Settings']")), 10);
		Thread.sleep(8000);

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				testUtil.clickOn(driver, driver.findElement(By.xpath("//*[@id='TabSettings']/a")), 10);
				Thread.sleep(2000);
				testUtil.clickOn(driver, driver.findElement(By.xpath(
						"//a[@title='Security: Add users, plus access settings for security roles, fields, and business units.']")),
						10);
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
				testUtil.clickOn(driver, driver.findElement(By.xpath("//tr//td//a[text()='Users']")), 10);
				Thread.sleep(4000);
				// driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ViewArea']")));
				Thread.sleep(4000);
				driver.findElement(By.xpath("//input[@title='Search for records']")).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath("//input[@title='Search for records']")).sendKeys("Maheshwar Poloju");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td//a[@title='Start search']")).click();
				Thread.sleep(2000);
				testUtil.clickOn(driver, driver.findElement(By.xpath("//*[@title='Maheshwar Poloju']//span")), 10);

				testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()=' Join Teams ']")), 10);
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='InlineDialog_Iframe']")));

				driver.findElement(By.xpath("//input[@title='Search for records']")).click();
				driver.findElement(By.xpath("//input[@title='Search for records']")).sendKeys(string);
				driver.findElement(By.xpath("//td//a[@title='Start search']")).click();
				Thread.sleep(2000);

				actions.moveToElement(
						driver.findElement(By.xpath("//input[@title='Select/clear all records on this page']")));
				Thread.sleep(2000);
				actions.click(driver.findElement(By.xpath("//input[@title='Select/clear all records on this page']")))
						.build().perform();
				Thread.sleep(2000);
				actions.click(driver.findElement(By.xpath("//button[text()='Select']"))).build().perform();
				Thread.sleep(2000);
				actions.click(driver.findElement(By.xpath("//button[text()='Add']"))).build().perform();
				driver.close();
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);

	}

	@Then("user delete the Team {string}")
	public void user_delete_the_Team(String string) throws InterruptedException {
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Settings']")), 10);
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Advanced Settings']")), 10);
		Thread.sleep(8000);

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				testUtil.clickOn(driver, driver.findElement(By.xpath("//*[@id='TabSettings']/a")), 10);
				Thread.sleep(2000);
				testUtil.clickOn(driver, driver.findElement(By.xpath(
						"//a[@title='Security: Add users, plus access settings for security roles, fields, and business units.']")),
						10);
				Thread.sleep(4000);
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
				testUtil.clickOn(driver, driver.findElement(By.xpath("//tr//td//a[text()='Users']")), 10);
				Thread.sleep(4000);
				// driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ViewArea']")));
				Thread.sleep(4000);
				driver.findElement(By.xpath("//input[@title='Search for records']")).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath("//input[@title='Search for records']")).sendKeys("Maheshwar Poloju");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//td//a[@title='Start search']")).click();
				Thread.sleep(2000);
				testUtil.clickOn(driver, driver.findElement(By.xpath("//*[@title='Maheshwar Poloju']//span")), 10);

				Thread.sleep(2000);
				// driver.switchTo().defaultContent();

				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));

				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//table[@name='teams information']"))).build()
						.perform();
//				List<WebElement> allElements = driver.findElements(By.xpath("//*"));
//
//				Thread.sleep(2000);
//				for(WebElement e : allElements) {
//					  System.out.println(e.getText());
//					}
				testUtil.clickOn(driver, driver.findElement(By.xpath("//a[@title='Delete']")), 10);

			}
		}
	}

	@Then("user verify all the lookup values in Subcategory")
	public void user_verify_all_the_lookup_values_in_subCategory(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		List<String> actual = dataTable.asList();

		// String[] arrlstValues = listofvalues.split("\\n");
		System.out.println(actual.size());
		for (int i = 0; i <= actual.size() - 1; i++) {
			// System.out.println(actual.get(i));
			System.out.println("Actual : " + actual.get(i));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@aria-label='Subcategory, Lookup']")).click();
			Thread.sleep(1500);
			actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Subcategory, Lookup']")), actual.get(i))
					.build().perform();
			Thread.sleep(1500);
			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//li[contains(@aria-label,'" + actual.get(i) + "')]")).size() != 0,
					actual.get(i));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//input[@aria-label='Subcategory, Lookup']")).sendKeys(Keys.CONTROL + "A");
			Thread.sleep(1500);
			actions.sendKeys(Keys.BACK_SPACE).build().perform();
		}

	}

	@Then("user validate Subcategory field is mandatory")
	public void user_validate_Subcategory_field_is_mandatory() throws InterruptedException {

		assertion.CheckAssertionTrue(
				driver.findElements(By.xpath("//span[text()='Subcategory : Required fields must be filled in.']"))
						.size() != 0,
				"Subcategory : Required fields must be filled in.");

	}

	@Then("user validate {string} case")
	public void user_validate_case(String string) throws InterruptedException {
		Thread.sleep(1500);
		assertion.CheckAssertionTrue(
				driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title").contains(string),
				string);

	}

	@Then("user click on More commands for Connection button")
	public void user_click_on_button() {
		try {
			testUtil.clickOn(driver, optimization.objMorecommandsforConnection, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user enter Alleged Perpetrator field")
	public void user_enter_Alleged_Perpetrator_field() {

	}

	@Then("user select one of Flag")
	public void user_select_flag() throws Exception {
		try {
			Thread.sleep(2000);
			Properties FlagName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Userstories.properties");
			System.out.println("Active FlagName : " + FlagName.getProperty("FlagName"));
			String FlagNames = FlagName.getProperty("FlagName");
			Thread.sleep(4000);
			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Flags Filter by keyword']")),
					10, FlagNames);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[contains(@id,'quickFind')]")), 10);
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']//a")).size() != 0,
					FlagNames);
			Thread.sleep(4000);
			testUtil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']//a")), 0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user select the flag from flag details grid")
	public void user_select_the_flag_from_flag_details_grid() {

		testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='1']")), 0);

	}

	@Then("user edit Flag Start Date")
	public void user_edit_Flag_Start_Date() throws InterruptedException {

		driver.findElement(By.xpath("//input[@aria-label='Date of Flag Start Date']//following-sibling::i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2000);
	}

	@Then("user verifies New Value field for new Flag Details in the audit details")
	public void user_verifies_New_Value_field_for_new_Flag_Details_in_the_audit_details() {
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='audit_iframe']")));
			Integer actual = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ]")).size();
			System.out.println("length is :: " + actual);
			// System.out.println(driver.findElement(By.xpath("//*[@role='row' and
			// @otypename ='audit' ][1]/td[4]")).getAttribute("textContent"));

			Thread.sleep(2000);

			String st = driver.findElement(By.xpath("//*[@role='row' and @otypename ='audit' ][1]/td[4]"))
					.getAttribute("textContent");
			System.out.println("Event Type is :: " + st);

			System.out.println("old value -- "
					+ driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][1]/td[6]")).get(0)
							.getAttribute("innerText"));
			System.out.println("new value -- "
					+ driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][1]/td[7]")).get(0)
							.getAttribute("innerText"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());
			System.out.println(currentdate);

			String val = "27/01/2023";

			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][1]/td[7]")).get(0)
							.getAttribute("innerText").contains(val),
					val);

			driver.switchTo().defaultContent();
		} catch (Exception e) {
		}
	}

	// Thangam
	@Then("user verify the Queue Item Details as Customer Contact Admin")
	public void user_verify_the_Queue_Item_Details_as_Customer_Contact_Admin()
			throws IOException, InterruptedException {
		Thread.sleep(1500);
		assertion.CheckAssertionTrue(
				driver.findElement(By.xpath("(//a[contains(@aria-label,'Customer Contact Admin')])[2]"))
						.getAttribute("textContent").contains("Customer Contact Admin")
						|| driver.findElement(By.xpath("//div[@id='headerControlsList_5']")).getAttribute("textContent")
								.contains("Customer Contact Admin"),

				"Customer Contact Admin");
	}

	@Then("user open created task")
	public void user_open_created_task() throws InterruptedException {
		try {
			phonecall.openCases();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user clicks on Queue Item Details link")
	public void user_clicks_on_Queue_Item_Details_link() {
		try {
			Thread.sleep(1000);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//a[@aria-label='<Customer Contact Admin>']")), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("user verifies the closed task {string} is does not exist in Queue items")
	public void user_verifies_closed_task_doesnot_exist_in_queue_items(String str) throws InterruptedException {
		List<WebElement> task = driver
				.findElements(By.xpath("//*[contains(text(),'CAS-963280-P2W3N7, undefined, Rebecca Hudson,')]"));
		if (task.size() > 0) {
			System.out.println("Task ID: " + str + " is present. ");
		} else {
			System.out.println("Task ID: " + str + " is not present. ");
		}
	}

	@Then("user select Look Up field under Advanced Find")
	public void user_select_field_under_Advanced_Find() throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// driver.switchTo().window(child_window);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']")).click();

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']//*[text()='CaseItemAudit']")).click();

		driver.switchTo().defaultContent();

	}
	
	@Then("user select Look for field {string} under Advanced Find")
	public void user_select_under_Advanced_Find(String string) throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// driver.switchTo().window(child_window);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']")).click();

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']//*[text()='"+string+"']")).click();

		driver.switchTo().defaultContent();

	}
	
	 @Then("user click on select in Advanced find to select {string}")
	 public void user_click_on_select_in_Advanced_find(String string)
	 {
		 
		 try {
			for (String winHandle : driver.getWindowHandles()) {
					Thread.sleep(1000);
					driver.switchTo().window(winHandle);
				}
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);

				// driver.switchTo().window(child_window);
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
			 driver.findElement(By.xpath("//span[text()='Select']")).click();
			 Thread.sleep(1000);
			 //driver.findElement(By.xpath("//select[@aria-label='SelectInputBehavior']")).click();
			 //driver.findElement(By.xpath("//select[@aria-label='SelectInputBehavior']")).click();
			 
			
			 driver.findElement(By.xpath("//span[@class='ms-crm-AdvFind-EmptyField']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//span[@class='ms-crm-AdvFind-EmptyField']//option[@nameattr='po_"+string+"name']")).click();	
			
			 driver.findElement(By.xpath("//span[@class='ms-crm-AdvFind-ClientControl']//div[@title = 'Enter Value']")).click();
			 driver.findElement(By.xpath("//label[@for='crmGrid_findCriteria']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//tr[@gridid='crmGrid']//input[@title='Search for records']")).sendKeys("Enforcement (legal)");
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//tr[@gridid='crmGrid']//img[@title='Start search']")).click();
			 driver.findElement(By.xpath("//tr[@aria-owns='crmGridtitle_Headercategory']//td//img[@title='Select/clear all records on this page']")).click();
			
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//button[@onclick='addItems();']")).click();
			 driver.findElement(By.xpath("//button[@id='butBegin']")).click();
			 
			
			 
			 
			 
			
			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 
	 @Then("user click on select in Advanced find to select subcategory")
	 public void user_click_on_select_in_Advanced_find_subcategory(String string)
	 {
		 
		 try {
			for (String winHandle : driver.getWindowHandles()) {
					Thread.sleep(1000);
					driver.switchTo().window(winHandle);
				}
				Thread.sleep(1000);
				driver.manage().window().maximize();
				Thread.sleep(1000);

				// driver.switchTo().window(child_window);
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
			 driver.findElement(By.xpath("//span[text()='Select']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//select[@aria-label='SelectInputBehavior']")).click();
			 driver.findElement(By.xpath("//option[@nameattr='subcategory')]")).click();	
			
			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

	@Then("user select Use Saved View field under Advanced Find")
	public void user_select_Use_Saved_View_field_under_Advanced_Find() throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// driver.switchTo().window(child_window);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
		driver.findElement(By.xpath("//select[@name='savedQuerySelector']")).click();
		driver.findElement(By.xpath("//select[@name='savedQuerySelector']//*[text()='Case Risk Audit - Active Cases']"))
				.click();

		driver.switchTo().defaultContent();

	}

	@Then("user click on Results under Advanced Find")
	public void user_click_on_Results_under_Advanced_Find() throws InterruptedException {

		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));

		driver.findElement(By.xpath("(//span[@id='Mscrm.AdvancedFind.Groups.Show-Large']//a)[3]")).click();

		driver.switchTo().defaultContent();

	}

	@Then("user validate below coloumn names are available")
	public void user_validate_below_coloumn_names_are_available(DataTable dataTable) throws InterruptedException {
		List<String> expectedDropDownValues = dataTable.asList();
		Wait.untilPageLoadComplete(driver, 500);

		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='resultFrame']")));

		int j =2;
		for (int i = 0; i <= expectedDropDownValues.size() - 1; i++) {

			System.out.println("Expected = " + expectedDropDownValues.get(i));
		
			System.out.println(j);
			
			System.out.println("Actual = " + driver.findElement(By.xpath("(//table[@primaryfieldname='po_name']//tr//th[@scope='col'])["+j+"]"))
			.getAttribute("textContent"));

			Thread.sleep(2000);
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("(//table[@primaryfieldname='po_name']//tr//th[@scope='col'])["+j+"]"))
							.getAttribute("textContent").contains(expectedDropDownValues.get(i)),
					expectedDropDownValues.get(i));

			
			j =j+1;
		}
		driver.switchTo().defaultContent();

	}

	@Then("user verifies the auto popup is does not exist")
	public void user_verifies_auto_popup_doesnot_exist() throws InterruptedException {
		List<WebElement> popup = driver.findElements(By.xpath("//div[@id='defaultDialogChromeView-4']"));
		if (popup.size() > 0) {
			System.out.println("Auto popup is displayed. ");
		} else {
			System.out.println("Auto popup is not displayed. ");
		}
	}

	@Then("user click on close button in auto popup email")
	public void user_click_on_back_button() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//button[@id='defaultDialogChromeCloseIconButton-4' and @aria-label='Close']"))
					.click();
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user verify the auto popup title content")
	public void user_verify_autopopup_title_content() {
		String Expected = "Your Advert is Live! - 100000, 35 Silks Way, Andover, Hampshire, SP11 6UU (Primary Progressor: ﻿)";
		WebElement Actual = driver.findElement(By.xpath(
				"//h1[contains(@aria-label,'Your Advert is Live! - 100000, 35 Silks Way, Andover, Hampshire')]"));
		Assert.assertEquals(Expected, Actual.getText());
		System.out.println(Actual.getText());
	}

	@Then("user enter all mandatory fields in Valuation & Internal Checks tab")
	public void user_enter_all_mandatory_fields_in_valuation_Internal_checks_tab() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//select[@aria-label='Advert Live']")).sendKeys("Yes");
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//div[@data-id='po_nominationends.fieldControl._datecontrol-date-container']//child::input[@aria-label='Date of Nomination Ends']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 	Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//select[@aria-label='Nomination Period']")));
		driver.findElement(By.xpath("//select[@aria-label='Nomination Period']")).sendKeys("5");
		Thread.sleep(500);
		//js.executeScript("arguments[0].scrollIntoView();",
		//driver.findElement(By.xpath("//input[@aria-label='Admin Fee']")));
		driver.findElement(By.xpath("//input[@aria-label='Admin Fee']")).sendKeys("2000");
		driver.findElement(By.xpath(
				"//div[@data-id='po_dateadvertlive.fieldControl._datecontrol-date-container']//child::input[@aria-label='Date of Date Advert Live']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
	}
	
	@And("user selects first record")
	public void user_selects_first_record() throws InterruptedException {
		Thread.sleep(2500);
		testUtil.clickOn(driver,driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2'] | //div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), 10);
		Thread.sleep(500);
		
	}
	
	@Then("user select Use Saved View field under Advanced Find for {string}")
	public void user_select_Use_Saved_View_field_under_Advanced_Find(String string) throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// driver.switchTo().window(child_window);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
		driver.findElement(By.xpath("//select[@name='savedQuerySelector']")).click();
		driver.findElement(By.xpath("//select[@name='savedQuerySelector']//*[text()='"+string+"']"))
				.click();

		driver.switchTo().defaultContent();
}
	
	@Then("user select Look Up field under Advanced Find of NeighbourhoodItemAudit")
	public void user_select_field_under_Advanced_Find_NeighbourhoodItemAudit() throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// driver.switchTo().window(child_window);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']")).click();

		driver.findElement(By.xpath("//select[@name='slctPrimaryEntity']//*[text()='NeighbourhoodItemAudit']")).click();

		driver.switchTo().defaultContent();
	}
	
	@Then("user read Account Login Name")
	public void user_read_Account_Login_Name() throws InterruptedException {

	System.out.println(System.getProperty("user.dir"));
	testUtil.jsclick(driver.findElement(By.xpath("//button[contains(@aria-label,'Account manager')]")), driver);
	String userName = driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']"))
			.getAttribute("textContent");
	Log.info(userName);
	userdetails.put("userName", userName);
	actions.sendKeys(Keys.TAB).build().perform();
	Thread.sleep(2000);
	System.out.println(userdetails.get("userName"));

	}


	@Then("user validate the Modified By Case field")
	public void user_validate_the_Modified_By_Case_field() throws InterruptedException {

		Wait.untilPageLoadComplete(driver, 500);


		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(1000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='contentIFrame0']")));
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='resultFrame']")));

		Log.info("Actual = " + driver.findElement(By.xpath("//table[@primaryfieldname='po_name']//tr[1]//td[8]"))
				.getAttribute("textContent"));





		Thread.sleep(2000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//table[@primaryfieldname='po_name']//tr[1]//td[8]"))
				.getAttribute("textContent").contains(userdetails.get("userName")), "userName");

		driver.switchTo().defaultContent();

	}
	
	@And("user selects first record in additional link chain")
	public void user_selects_first_record_additional_link() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//h3[text()='Additional links in chain']")));
		Thread.sleep(1000);
		testUtil.clickOn(driver,
				driver.findElement(By.xpath("(//div[@aria-rowindex='2']//div[@aria-colindex='2'])[2]")), 10);
		Thread.sleep(500);
	}
	
}
