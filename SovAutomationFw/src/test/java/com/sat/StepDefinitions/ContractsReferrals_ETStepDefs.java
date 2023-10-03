package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.ContractsReferrals_ET;
import com.sat.Pages.CustomerPage;
import com.sat.Pages.GenericCases;
import com.sat.Pages.Queue;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContractsReferrals_ETStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	ContractsReferrals_ET contractsreferrals = new ContractsReferrals_ET(driver);
	GenericCases genericCases = new GenericCases(driver);
	public ContactForm contact = new ContactForm(driver);
	private CustomerPage accountpage = new CustomerPage(driver);
	WebDriverWait w = new WebDriverWait(driver, 5);
	Actions actions = new Actions(driver);
	HashMap<Integer, String> itemsListPickedFromQueue = new HashMap<>();
	Queue queue = new Queue(driver);
	Properties prop = new Properties();
	String workingDir = System.getProperty("user.dir");
	Assertions assertion = new Assertions(driver);
	private CasePage casepage = new CasePage(driver);
	Testutil testUtil = new Testutil(driver);
	private CasePage cases = new CasePage(driver);
	 HashMap<Integer, String> contactDetails = new HashMap<>();
	 HashMap<String, String> ReferralTitleDetails = new HashMap<String, String>();
	 
	 @When("user search Existing contact name")
		public void user_search_Existing_contact_name() throws InterruptedException {
			try {
				

				Properties ExistingContactName = testUtil
						.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ContractsReferrals_ET.properties");
				System.out.println("ExistingContactName : " + ExistingContactName.getProperty("ExistingContactName"));
				System.out.println("ExistingContactName is : " + ExistingContactName.getProperty("ExistingContactName"));
				String name =ExistingContactName.getProperty("ExistingContactName");
				
				Thread.sleep(3000);
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
				contact.objsearchField.sendKeys(name, Keys.ENTER);
				Wait.untilPageLoadComplete(driver);
				Thread.sleep(3000);
				List<WebElement> li= driver.findElements(By.xpath("//*[text()='"+name+"']"));
				assertion.CheckAssertionTrue(!li.isEmpty(), name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 
	 @When("user search New contact name")
		public void user_search_New_contact_name() throws InterruptedException {
			try {
				

				Properties NewContactName = testUtil
						.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ContractsReferrals_ET.properties");
				System.out.println("NewContactName : " + NewContactName.getProperty("NewContactName"));
				System.out.println("NewContactName is : " + NewContactName.getProperty("NewContactName"));
				String name =NewContactName.getProperty("NewContactName");
				
				Thread.sleep(3000);
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
				contact.objsearchField.sendKeys(name, Keys.ENTER);
				Wait.untilPageLoadComplete(driver);
				Thread.sleep(3000);
				List<WebElement> li= driver.findElements(By.xpath("//*[text()='"+name+"']"));
				assertion.CheckAssertionTrue(!li.isEmpty(), name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	@Then("user select Existing contact name in contact form")
	public void user_select_Existing_contact_name_in_contact_form() {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			System.out.println(workingDir);
			Properties ContactName = Queue.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/ContractsReferrals_ET.properties");
			System.out.println("ExistingContactName: " + ContactName.getProperty("ExistingContactName"));
			queue.clickOnQueue(ContactName.getProperty("ExistingContactName"));
		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}

	}

	@Then("user select New contact name in contact form")
	public void user_select_New_contact_name_in_contact_form() {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			System.out.println(workingDir);
			Properties ContactName = Queue.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/ContractsReferrals_ET.properties");
			System.out.println("NewContactName: " + ContactName.getProperty("NewContactName"));
			queue.clickOnQueue(ContactName.getProperty("NewContactName"));
		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}

	}

	@Then("user validates the {string} as {string}")
	public void user_validates_the(String string, String expectedValue) {
		try {
			System.out.println("expectedValue is : " + expectedValue);
			System.out.println("Actual value is : " + contractsreferrals.objcontacttype.getAttribute("textContent"));
			assertion.CheckAssertion(expectedValue, contractsreferrals.objcontacttype.getAttribute("textContent"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validates form type as {string}")
	public void user_validates_form_type_as(String formname) {
		try {
			if (formname == "Contact (Resident Form)")
				assertion.CheckAssertionTrue(contractsreferrals.objFormtypeContactResidentForm
						.getAttribute("textContent").contains(formname), formname);
			if (formname == "Contact (Non Resident/Partner Form)")
				assertion.CheckAssertionTrue(contractsreferrals.objFormtypeContactNonResidentPartnerForm
						.getAttribute("textContent").contains(formname), formname);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks on Assign button")
	public void user_clicks_on_Assign_button() {
		casepage.clickOnAssign();

	}

	@Then("user validates {string} as {string} in {string}")
	public void user_validate_in_Initial_Risk_Prioritisation_tab(String string, String string2, String strin3) {
		try {
			System.out.println("user validates the Owner Field as : " + string2);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contractsreferrals.objOwnerFieldValue));
			assertion.CheckAssertion(string2, contractsreferrals.objOwnerFieldValue.getAttribute("textContent"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user creates the new contact")
	public void user_creates_the_new_contact() {
		try {
			contractsreferrals.clickOnNewContact();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user fills all the fields in Contact Details Section")
	public void user_fills_all_the_fields_in_Section() {

		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			// testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
			// testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "01/06/1982");
			testUtil.selectByVisibleText(driver, contractsreferrals.objTitle, "Dr");
			testUtil.sendKeys(driver, contractsreferrals.objFirstName, 1, "FirstName"+timeStamp);
			testUtil.sendKeys(driver, contractsreferrals.objLastName, 1, "LastName"+timeStamp);
			testUtil.sendKeys(driver, contractsreferrals.objEmail, 1, "LastName"+timeStamp+"@gmail.com");
			testUtil.sendKeys(driver, contractsreferrals.objTelephoneHome, 1, "LastName"+timeStamp+"@gmail.com");
			testUtil.sendKeys(driver, contractsreferrals.objTelephoneMobile, 1, "LastName"+timeStamp+"@gmail.com");
			cases.fillDetails("Contact Type", "New Contact");
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			actions.sendKeys(Keys.ENTER).build().perform();
			testUtil.selectByVisibleText(driver, contractsreferrals.objContactPreferences, "Email");
			testUtil.selectByVisibleText(driver, contractsreferrals.objETCustomerType, "ET Partner");
			testUtil.sendKeys(driver, contractsreferrals.objURN, 1, "1010110");
			actions.click(contractsreferrals.objAlertFlag).build().perform();
			testUtil.clickOn(driver, contractsreferrals.objAlertflagActionsMenu, 1);
			Thread.sleep(2000);
			testUtil.clickOn(driver, contractsreferrals.objAlertFlagMenuItem, 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Pre Applicant Details Section")
	public void user_fills_all_the_fields_in_Pre_Applicant_Details_Section() {
		try {
			testUtil.inputText(driver, "Street 1", 1, "Street1");
			testUtil.inputText(driver, "Street 2", 1, "Street2");
			testUtil.inputText(driver, "Street 3", 1, "Street3");
			testUtil.inputText(driver, "City", 1, "City");
			testUtil.inputText(driver, "Town", 1, "Town");
			testUtil.inputText(driver, "Post Code", 1, "12345");
			testUtil.inputText(driver, "Country", 1, "India");
			cases.fillDetails("County", "London");
			cases.fillDetails("Local Authority Home", "BANES");
			testUtil.inputText(driver, "Date of Date of Birth", 1, "01/06/1982");
			testUtil.selectText(driver, "Gender", "Male");
			testUtil.inputText(driver, "National Insurance Number", 1,"ABCD1234");
			testUtil.inputText(driver, "Income", 1, "100000");
			testUtil.selectText(driver, "Employment Status", "Full Time");
			cases.fillDetails("Employer Local Authority", "Bristol");
			testUtil.selectText(driver, "Ethnicity ", "Mixed - Other");
			testUtil.selectText(driver, "Preferred Language", "Hindi");
			testUtil.selectText(driver, "Religion ", "Hinduism");
			testUtil.selectText(driver, "Sexuality", "Asexual");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Then("user validates {string} is displayed on top of the form")
	public void user_validates_is_displayed_on_top_of_the_form(String string) {
			
		try {
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("textContent").contains("FirstName"), string);
		} catch (Exception e) {
		}
		}



	@Then("user validates {string} field is calculated correctly")
	public void user_validates_field_is_calculated_correctly(String string) {
		try {
			assertion.CheckAssertion(driver.findElement(By.xpath("//input[@aria-label='Age']")).getAttribute("title"),"40");
		} catch (Exception e) {

	}

	}

	@Then("user validates {string} field")
	public void user_validates_field(String string) {
		try {
			assertion.CheckAssertion(driver.findElement(By.xpath("//label[text()='National Insurance Number']")).getAttribute("textContent"),string);
		} catch (Exception e) {

	}

	}
	
	@Then("user enters value as {string} in {string}")
	public void user_enters_value_as_in(String string, String string2) {
	   try {
		testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='"+string2+"']")), 0, string);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Then("user select one of active Referral items {string} and read the Contact details")
	public void user_select_one_of_active_Referral_items(String string) {
		
		try {
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='2']//div[@aria-colindex='4']"))));
	
		
			contactDetails.put(1,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='5']")).getAttribute("textContent"));
			contactDetails.put(2,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='6']")).getAttribute("textContent"));
			contactDetails.put(3,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='7']")).getAttribute("textContent"));
			contactDetails.put(4,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='8']")).getAttribute("textContent"));
			System.out.println(contactDetails);
			//testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='3']//div[@aria-colindex='4']")), 5);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='4']")), 5);

			
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Then("user enters {string} as {string}")
	public void user_enters_as(String string,String string2)
	{
		driver.findElement(By.xpath("//textarea[@aria-label='"+string+"']")).sendKeys(string2);

	}
	
	
	
	
	@Then("user select one of active Referral")
	public void user_select_one_of_active_Referral() {
		
		try {
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='2']//div[@aria-colindex='2']"))));
	
			testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='2']//div[@aria-colindex='2']")), 5);

//			contactDetails.put(1,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='5']")).getAttribute("textContent"));
//			contactDetails.put(2,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='6']")).getAttribute("textContent"));
//			contactDetails.put(3,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='7']")).getAttribute("textContent"));
//			contactDetails.put(4,driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='8']")).getAttribute("textContent"));
//			System.out.println(contactDetails);
//			//testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='3']//div[@aria-colindex='4']")), 5);
//			testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-RowIndex='3']//div[@aria-colindex='4']")), 5);

			
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Then("user validate SMS Message in Timeline")
	public void user_validate_SMS_Message_in_Timeline()
	{
		
	String Exp= driver.findElement(By.xpath("(//li[contains(@aria-label,'SMS Message')])[1] ")).getAttribute("textContent");
	System.out.println(Exp);
	
	assertion.CheckAssertionTrue(Exp.contains("SMS Automation"), Exp);
	
	}
	
	@Then("user validate Email Message in Timeline")
	public void user_validate_Email_Message_in_Timeline()
	{
		String Exp= driver.findElement(By.xpath("(//li[contains(@aria-label,'E-mail')])[1] ")).getAttribute("textContent");
		System.out.println(Exp);
		
		assertion.CheckAssertionTrue(Exp.contains("Automation Subject"), Exp);
	}
	
	 
	
	@Then("user read the ReferralTitle")
	public void user_read_the_ReferralTitle() {
		try {

			ReferralTitleDetails.put("ReferralTitle",
					driver.findElement(By.xpath("//h1[@data-id='header_title']")).getAttribute("title"));
			System.out.println("Referral Title is ::  " + ReferralTitleDetails.get("ReferralTitle"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user read the ReferralName")
	public void user_read_the_referralName() {
		try {

			ReferralTitleDetails.put("ReferralName",
					driver.findElement(By.xpath("//div[@data-id='po_contactname.fieldControl-LookupResultsDropdown_po_contactname_selected_tag_text']")).getAttribute("title"));
			System.out.println("Referral name is ::  " + ReferralTitleDetails.get("ReferralName"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user read the ReferralPhoneNumber")
	public void user_read_the_ReferralPhoneNumber() {
		try {

			ReferralTitleDetails.put("PhoneNumber",
					driver.findElement(By.xpath("//input[@aria-label='ContactNumber']")).getAttribute("title"));
			System.out.println("PhoneNumber is ::  " + ReferralTitleDetails.get("PhoneNumber"));

			Thread.sleep(3000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user validate ReferralTitle is autopopulate in {string} under Email Activity")
	public void user_validate_under_Email_Activity(String string) {
System.out.println(ReferralTitleDetails.get("ReferralTitle"));
		String val = driver.				
				findElement(By.xpath("//*[@data-id='regardingobjectid.fieldControl-LookupResultsDropdown_regardingobjectid_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ReferralTitleDetails.get("ReferralTitle").contains(val),ReferralTitleDetails.get("ReferralTitle"));

	}
	
	@Then("user validate Referral mobile Number is autopopulate in {string} under SMS Message Activity")
	 public void user_validate_Contact_mobile_Number_is_autopopulate_in_Mobile_Phone_Number_under_SMS_Message_Activity(String string)
	 {
		 System.out.println(ReferralTitleDetails.get("PhoneNumber"));
			String val = driver
					.findElement(By.xpath("//input[@aria-label='Phone Number']"))
					.getAttribute("title");
			assertion.CheckAssertionTrue(ReferralTitleDetails.get("PhoneNumber").contains(val),
					ReferralTitleDetails.get("PhoneNumber"));
		 
	 }
	
	
	@Then("user validate Referal Contact name is autopopulate in {string} under Email Activity")
	public void user_validate_TO_under_Email_Activity(String string) {

		System.out.println(ReferralTitleDetails.get("ReferralName"));
		String val = driver
				.findElement(By.xpath("//*[@data-id='to.fieldControl-LookupResultsDropdown_to_selected_tag_text']"))
				.getAttribute("textContent");
		assertion.CheckAssertionTrue(ReferralTitleDetails.get("ReferralName").contains(val),
				ReferralTitleDetails.get("ReferralName"));

	}
	
	@Then("user validate PhoneNumber is autopopulate in {string} under Phone Call Activity")
	public void user_validate_PhoneNumber_is_autopopulate_in_Phone_Number_under_Phone_Call_Activity(String string)
	{
		System.out.println( ReferralTitleDetails.get("PhoneNumber"));
		String val = driver
				.findElement(By.xpath("//input[@aria-label='Phone Number']"))
				.getAttribute("title");
		assertion.CheckAssertionTrue( ReferralTitleDetails.get("PhoneNumber").contains(val),
				ReferralTitleDetails.get("PhoneNumber"));
	}
	
	@Then("user click on {string} from {string} option")
	public void user_click_on_from_option(String string, String Moretabs) {
		try {
			Thread.sleep(5000);
			contact.clicksOn(Moretabs);
			actions.sendKeys(Keys.TAB).build().perform();
			//actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			testUtil.jsclick(driver.findElement(By.xpath("(//*[text()='" + string + "'])[2]")), driver);
	
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	
	@Then("user validates the following fields are mapped from contact")
	public void user_validates_the_following_as_mapped_from_contact(DataTable dataTable) throws Exception {
		try {
			List<String> actual = dataTable.asList();
			System.out.println(actual.size());
			
			
			for (int i = 0; i <= actual.size() - 1; i++) {
				// System.out.println(actual.get(i));
				System.out.println(actual.get(i));
				Thread.sleep(1000);
					assertion.CheckAssertion(driver.findElement(By.xpath("//*[@aria-label='" +actual.get(i) + "']")).getAttribute("title"),contactDetails.get(i+1));				
						
				
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Then("user clicks on More Header Fields")
	public void user_clicks_on_More_Header_Fields() throws Exception
	{
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//button[contains(@aria-label,'More Header Fields')]")).click();
		driver.findElement(By.xpath("//button[contains(@aria-label,'More Header Editable Fields')]")).click();
		
	}
	
	
}
