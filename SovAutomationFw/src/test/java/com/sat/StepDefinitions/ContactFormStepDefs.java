package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.ContractsReferrals_ET;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactFormStepDefs {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	private ContactForm contact = new ContactForm(driver);
	Testutil testUtil = new Testutil(driver);
	private CasePage casepage = new CasePage(driver);
	Assertions assertion = new Assertions(driver);
	Map map = new HashMap();
	String workingDir = System.getProperty("user.dir");
	ContractsReferrals_ET contractsreferrals = new ContractsReferrals_ET(driver);
	private CasePage cases = new CasePage(driver);

	@When("user search {string} and click on contact name link")
	public void cick_on_any_contact_name_link(String name) throws InterruptedException {
		try {
			Properties SLLeadApplicant = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Creations.properties");
			System.out.println(SLLeadApplicant.getProperty("SLLeadApplicant"));
			Thread.sleep(1500);
			contact.Clickoncontactname(SLLeadApplicant.getProperty("SLLeadApplicant"));
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@When("user search {string} and click on contact name")
	public void cick_on_any_contact_name(String name) throws InterruptedException {
		try {
			Thread.sleep(1500);
			contact.Clickoncontactname(name);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("verify all tabs are appearing on the Contact Form")
	public void verify_all_tabs_are_appearing_on_the_Contact_Form(DataTable datatable) {
		try {
			contact.verifyalltab(datatable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("verify all sections under {string} tab")
	public void verify_all_sections_under_tab(String string, DataTable datatable)
			throws InterruptedException, IOException {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());

		for (int j = 0; j <= actual.size() - 1; j++) {
			System.out.println(j);
			System.out.println("Section Name is : " + actual.get(j));
			Thread.sleep(3000);
			String expected = driver.findElement(By.xpath("//h2[@title='" + actual.get(j) + "']"))
					.getAttribute("textContent");
			Thread.sleep(3000);
			assertion.CheckAssertion(actual.get(j), expected);

		}

	}

	@When("user click on {string} tab")
	public void click_on_tab(String tab) {
		try {
			Thread.sleep(2500);
			System.out.println("Tab to click is : " + tab);
			contact.clickOnTab(tab);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user validate the {string} field")
	public void user_validate_the_field(String string) throws NumberFormatException, Exception
	{
		Thread.sleep(1500);
		String LeaseCommencementDate =  driver.findElement(By.xpath("//input[@aria-label='Date of Lease Commencement Date']")).getAttribute("defaultValue");
		Thread.sleep(1500);
		String LeaseExpiryDate =  driver.findElement(By.xpath("//input[@aria-label='Date of Lease Expiry Date']")).getAttribute("defaultValue");

		System.out.println("LeaseCommencementDate is :: " + LeaseCommencementDate);
		
		System.out.println("LeaseExpiryDate is :: " + LeaseExpiryDate);
		
		//int number = Integer.parseInt(LeaseCommencementDate)+10;
		
		String[] s = LeaseCommencementDate.split("/",2);
		String[] s2 = s[1].split("/",2);
		System.out.println(s2[1]);
		
		String[] s1 = LeaseExpiryDate.split("/",2);
		String[] s3 = s1[1].split("/",2);
		System.out.println(s3[1]);
		
	System.out.println(Integer.parseInt(s3[1]));
	System.out.println(Integer.parseInt(s2[1])+10);
		
	//assertion.CheckAssertion(Integer.parseInt(s3[1]), Integer.parseInt(s[1])+10);
		
		

	}
	
	@Then("user clicks on Application under Related tab")
	public void user_clicks_on_Application_under_Related_tab() throws InterruptedException	
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Applications Related - Common']//span[text()='Applications']")).click();
		
		
	}

	@Then("verify Locked and unlocked fields under section")
	public void verify_Locked_unlocked_fields_under_section(DataTable datatable) {
		try {
			contact.lockedUnlocked(datatable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("verify Unlocked fields under GENERAL INFORMATION section")
	public void verify_Unlocked_fields_under_GENERAL_INFORMATION_section() {
	}

	@Then("verify filter options on the timeline")
	public void verify_filter_options_on_the_timeline() throws InterruptedException {
		try {
			contact.filterOfTimeline();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("click on New Emergency Contact")
	public void click_on_New_Emergency_Contact() throws InterruptedException {
		try {
			contact.clickOnNewEmergencyContact();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}

	}

	@Then("click on New Contact")
	public void click_on_New_Contact() throws InterruptedException {
		try {
			contact.clickOnNewContact();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("click on New Account")
	public void click_on_New_Account() throws InterruptedException {
		try {
			contact.clickOnNewAccount();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("verify all section {string} under Data Protection tab")
	public void verify_all_section_DATA_PROTECTION_DETAILS_under_Data_Protection_tab(String pageheading) {
		try {
			contact.verifyheading(pageheading);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("click on New Data Protection link")
	public void click_on_New_Data_Protection_link() throws InterruptedException {
		try {
			contact.clickOnNewDataProtection();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("verify all section under tab")
	public void verify_all_section_under_General_tab(DataTable dataTable) throws InterruptedException {
		try {
			contact.verifySectiOnOfTab(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	

	@Then("user open {string} Form")
	public void user_open_Form(String text) throws InterruptedException {
		try {
			contact.openForm(text);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on confirm button")
	public void user_click_on_confirm_button() throws InterruptedException {
		try {
			contact.clickOnConfirm();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter description")
	public void user_enter_description() {
		try {
			contact.enterDescription();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enters description")
	public void user_enters_description() throws Exception {
		try {
			contact.description();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	// textarea[@aria-label='Description']
	@Then("user upload document")
	public void user_upload_document() throws InterruptedException, AWTException {
		try {
			WebElement element = driver.findElement(By.xpath("//li[text()='Related']"));
			element.click();
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			// Actions action = new Actions(driver);
			// WebElement element= driver.findElement(By.xpath("//li[@title='Documents']"));
			// action.moveToElement().click().perform();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}

	}

	@Then("verify all tabs are appearing on the {string} Form")
	public void verify_all_tabs_are_appearing_on_the_Form(String form, DataTable data) throws InterruptedException {
		Thread.sleep(1000);
		List<String> actual = data.asList();
		System.out.println(" Size of the data table is : " + actual.size());
		Thread.sleep(2000);
		String Expected = driver.findElement(By.xpath("//ul[@aria-label='" + form + "']"))
				.getAttribute("textContent");
		System.out.println(Expected);

		try {
			for (int i = 0; i <= actual.size() - 1; i++) {
				assertion.CheckAssertionTrue(Expected.contains(actual.get(i)), actual.get(i));
			}
		} catch (Exception e) {
			System.out.println("EXception :" + e + " has occurered");
		}
	}

	@Then("user Scroll down to Account field and click on the address hyperlink")
	public void user_click_on_the_address_hyperlink_and_open_Household_Group_Form()
			throws InterruptedException, AWTException {
		try {
			contact.clickOnAccountHyperlink();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user fill the General Information fields in contact form")
    public void user_fill_General_Information_fields_in_contact_form()
    {
		testUtil.sendKeys(driver, contact.objPassword, 1, "test123");
		testUtil.selectByVisibleText(driver, contractsreferrals.objTitle, "Dr");
		testUtil.sendKeys(driver, contractsreferrals.objFirstName, 1, "FirstName");
		testUtil.sendKeys(driver, contractsreferrals.objLastName, 1, "LastName");
		testUtil.sendKeys(driver, contractsreferrals.objDateofBirth, 1, "01/06/1994");
		testUtil.sendKeys(driver, contact.objAge, 1,"29" );
		testUtil.selectText(driver,"Gender", "Male");
		testUtil.sendKeys(driver, contact.objRelationship, 1,"TENANT");
		testUtil.sendKeys(driver, contractsreferrals.objEmail, 1, "LastName"+"@gmail.com");
		testUtil.sendKeys(driver, contact.objHomePhone, 1, "07263782724");
		testUtil.sendKeys(driver, contact.objMobilePhone, 1, "07263782725");
		testUtil.sendKeys(driver, contact.objMobilePhone2, 1, "07263782726" );
		testUtil.sendKeys(driver, contact.objWorkPhone, 1, "07263782727");
    }
	
	@Then("user fill the address details in Correspondence tab")
	public void user_fill_address_details_in_Correspondence()
	{
		try {
			testUtil.inputText(driver, "Street 1", 1, "Street1");
			testUtil.inputText(driver, "Street 2", 1, "Street2");
			testUtil.inputText(driver, "Street 3", 1, "Street3");
			testUtil.inputText(driver, "City", 1, "City");
			testUtil.inputText(driver, "Town", 1, "Town");
			testUtil.inputText(driver, "Post Code", 1, "12345");
			testUtil.inputText(driver, "Country", 1, "India");
			cases.fillDetails("County", "London");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

