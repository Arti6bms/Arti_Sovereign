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
import com.sat.Pages.FraudCase;
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

public class ProcessingApplicationsStepdefsResales {

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
	FraudCase fraudCase = new FraudCase(driver);

	@Then("user select any contact")
	public void user_select_any_contact() {
		try {
			Thread.sleep(500);
			LeadApplicant = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']"))
					.getAttribute("textContent");
			Thread.sleep(1000);
			map.put("LeadApplicant", LeadApplicant);
			System.out.println("Expected Lead Applicant = " + map.get("LeadApplicant"));
			actions.doubleClick(driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']")))
					.build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user validate Application Title")
	public void user_validate_Application_Title() {

	}

	@Then("user select Opportunity")
	public void user_select_any_Opportunity() {

		try {
			Thread.sleep(500);
			LeadApplicant = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']"))
					.getAttribute("textContent");
			Thread.sleep(500);
			map.put("LeadApplicant", LeadApplicant);
			System.out.println("Expected Lead Applicant = " + map.get("LeadApplicant"));

			Thread.sleep(500);
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user validate Lead Application is mapped from Contact")
	public void user_validate_Lead_Application_is_mapped_from_Contact() throws IOException {

		try {
			Thread.sleep(3000);
			String Actual = driver.findElement(By.xpath("(//div[@id='headerControlsList_3']//a)[1]"))
					.getAttribute("textContent");
			System.out.println(Actual + "=" + map.get("LeadApplicant"));
			assertion.CheckAssertionTrue(map.get("LeadApplicant").contains(Actual), Actual);
			//assertion.CheckAssertion(Actual, map.get("LeadApplicant"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user enter the details in Buyer Details section")
	public void user_enter_the_details_in_Buyer_Details_section() throws IOException, InterruptedException {
		Properties ProcessingApplicationsResale = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");
		Thread.sleep(1000);
		System.out.println(ProcessingApplicationsResale.getProperty("FinancialAdvisor"));
		cases.fillDetails("Financial Advisor", ProcessingApplicationsResale.getProperty("FinancialAdvisor"));
		Thread.sleep(1000);

		map.put("Financial Advisor", ProcessingApplicationsResale.getProperty("FinancialAdvisor"));

		driver.findElement(By.xpath("//input[@aria-label='Financial Advisor Contact, Lookup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//li[@aria-label='" + ProcessingApplicationsResale.getProperty("FinancialAdvisorContact") + "']"))
				.click();

		Thread.sleep(500);

		map.put("Property", driver.findElement(By.xpath(
				"//ul[@data-id='po_property.fieldControl-LookupResultsDropdown_po_property_SelectedRecordList']"))
				.getAttribute("textContent"));
		Thread.sleep(500);

		map.put("Financial Advisor Contact", ProcessingApplicationsResale.getProperty("FinancialAdvisorContact"));
		Thread.sleep(1000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Number of Additional Applicants']")), "1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'Additional Applicant')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[contains(@aria-label,'Additional Applicant')])[1]"))
				.sendKeys(ProcessingApplicationsResale.getProperty("AdditionalApplicant"));
		testutil.jsclick(
				driver.findElement(By.xpath(
						"//*[text()='" + ProcessingApplicationsResale.getProperty("AdditionalApplicant") + "']")),
				driver);

		String leadApplicant = driver.findElement(By.xpath(
				"//div[@data-id='parentcontactid.fieldControl-LookupResultsDropdown_parentcontactid_selected_tag_text']"))
				.getAttribute("textContent");

		String NumberofAdditionalApplicants = driver
				.findElement(By.xpath("//select[@aria-label='Number of Additional Applicants']"))
				.getAttribute("textContent");

		String AdditionalApplicant = driver.findElement(By.xpath(
				"//ul[@data-id='po_firstadditionalapplicant.fieldControl-LookupResultsDropdown_po_firstadditionalapplicant_SelectedRecordList']"))
				.getAttribute("textContent");

		map.put("Lead Applicant", leadApplicant);
		map.put("Number of Additional Applicants", NumberofAdditionalApplicants);
		map.put("Additional Applicant", AdditionalApplicant);

	}

	@Then("user enter the details in Sellers Details section")
	public void user_enter_the_details_in_Sellers_Details_section() throws IOException, InterruptedException {

		Properties ProcessingApplicationsResale = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");

//		actions.click(driver.findElement(By.xpath("//input[@aria-label='Tenant, Lookup']"))).build().perform();
//		Thread.sleep(2000);
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("Tenant") + "']"))).build()
//				.perform();
//		Thread.sleep(2000);

//		actions.click(driver.findElement(By.xpath("//input[@aria-label='Joint Tenant, Lookup']"))).build().perform();
//		Thread.sleep(2000);
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("Tenant") + "']"))).build()
//				.perform();
//		Thread.sleep(2000);

//		actions.click(driver.findElement(By.xpath("//input[@aria-label='Primary Contact, Lookup']"))).build().perform();
//		Thread.sleep(2000);
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("PrimaryContact") + "']")))
//				.build().perform();
//		Thread.sleep(2000);

	}

	@Then("user enter the details in Sovereign Stakeholder Details section")
	public void user_enter_the_details_in_Sovereign_Stakeholder_Details_section()
			throws IOException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'Sovereign Stakeholder Details')]")));

		Properties ProcessingApplicationsResale = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");

		cases.fillDetails("Sale Progressor", ProcessingApplicationsResale.getProperty("SaleProgressor"));
		Thread.sleep(1000);
		cases.fillDetails("Sovereign Legal Contact", ProcessingApplicationsResale.getProperty("SovereignLegalContact"));
		Thread.sleep(1000);

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Sovereign Solicitor, Lookup']"))).build()
				.perform();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//input[@aria-label='Sovereign Solicitor, Lookup']")).sendKeys("Test Solicitor");
		
		Thread.sleep(1000);	
		actions.click(driver.findElement(By.xpath("//span[text()='New Account']"))).build()
		.perform();
Thread.sleep(1000);		
		
driver.findElement(By.xpath("//button[@aria-label='Save and Close']")).click();
		
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("SovereignSolicitor") + "']")))
//				.build().perform();
//		Thread.sleep(1000);

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Sovereign Solicitor Contact, Lookup']")))
				.build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@aria-label='Sovereign Solicitor Contact, Lookup']")).sendKeys("TestContactName");

//		actions.click(driver.findElement(By.xpath(
//				"//li[@aria-label='" + ProcessingApplicationsResale.getProperty("SovereignSolicitorContact") + "']")))
//				.build().perform();
//		Thread.sleep(1000);

	}

	@Then("user enter the details in Information section")
	public void user_enter_the_details_in_Information_section() throws InterruptedException {
		Thread.sleep(500);
		testutil.sendKeys(driver, driver.findElement(By.xpath("//textarea[@aria-label='Important Information']")), 10,
				"Test");
		Thread.sleep(500);

	}

	@Then("user enter the details in Assessment section")
	public void user_enter_the_details_in_Assessment_section() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Date Application Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@aria-label='Date of Date Application Processed']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Date FA Received']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Date FA Reviewed']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of DIP Received']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Application Status']")),
				"Complete");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Is Applicant Purchasing Additional Shares']")),
				"Yes");

		testutil.inputText(driver, "Income Multiple", 10, "10");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Meet Income Multiple Criteria?']")), "Yes");

		testutil.inputText(driver, "Income Ratio %", 10, "40");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Meet Income Ratio Criteria?']")), "Yes");

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Have They Viewed The Property']")), "Yes");

	}

	@Then("user enter the details in Allocation Placement section")
	public void user_enter_the_details_in_Allocation_Placement_section() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//input[@aria-label='Date of Interest registered in property']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		testutil.inputText(driver, "LA Allocation Place", 10, "10");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Meets Criteria']")),
				"Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Able To Approve']")),
				"Yes");
		driver.findElement(By.xpath("//input[@aria-label='Date of Date of Approval']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Date Application Re-opened']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

	}

	@Then("user enter the details in Criteria section")
	public void user_enter_the_details_in_Criteria_section() throws InterruptedException {

		Thread.sleep(500);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='MOD']")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Existing Accommodation']")), "Other");
		testutil.inputText(driver, "Number of Adults", 10, "4");

		testutil.inputText(driver, "Number of Children", 10, "4");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Resale Local Connection']")), "Live");
		Thread.sleep(500);

	}

	@Then("user read the Property details")
	public void user_read_the_Property_details() throws Exception {
		
		Properties ProcessingApplicationsResale = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");

		//cases.fillDetails("Property Sale Form", "RS000000000010"); //rw
		//cases.fillDetails("Property Sale Form", "RS000000000207"); //ds
		cases.fillDetails("Property Sale Form", ProcessingApplicationsResale.getProperty("PropertySaleForm")); //shaqauqa
		
		
		Thread.sleep(500);

		actions.click(driver.findElement(By.xpath(
				"//div[@data-id='po_propertysaleform.fieldControl-LookupResultsDropdown_po_propertysaleform_selected_tag_text']")))
				.build().perform();
		if (driver.findElements(By.xpath("//*[text()='Discard changes']/parent::button")).size() != 0) {
			actions.moveToElement(driver.findElement(By.xpath("//*[text()='Discard changes']/parent::button"))).build()
					.perform();
			actions.click(driver.findElement(By.xpath("//*[text()='Discard changes']/parent::button"))).build()
					.perform();
		}

		actions.click(driver.findElement(By.xpath("//li[@aria-label='Valuation & Internal Checks']"))).build()
				.perform();

		String LeaseExpiryDate = driver.findElement(By.xpath("//input[@aria-label='Date of Lease Expiry Date']"))
				.getAttribute("defaultValue");

		String RemainingTermonLease = driver.findElement(By.xpath("//input[@aria-label='Remaining Term on Lease']"))
				.getAttribute("defaultValue");

		map.put("Lease Expiry Date", LeaseExpiryDate);
		map.put("Remaining Lease Term", RemainingTermonLease);

		System.out.println("LeaseExpiryDate :: " + map.get("Lease Expiry Date"));
		System.out.println("RemainingTermonLease :: " + map.get("Remaining Lease Term"));

		contact.clicksOn("Press Enter to go back.");

	}

	@Then("user validate {string} is mapped from {string}")
	public void user_validate_is_mapped_from(String string, String string2) throws IOException, InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='" + string + "']")));

		System.out.println("Checking :  " + string);

		Thread.sleep(3000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//input[contains(@aria-label,'" + string + "')]"))
				.getAttribute("defaultValue").contains(map.get(string)), map.get(string));
	}

	@Then("user validate Remaining Lease Term is mapped from {string}")
	public void user_validate_RemainingLeaseTerm_is_mapped_from(String string)
			throws IOException, InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='Remaining Lease Term']")));

		System.out.println("Checking :   Remaining Lease Term");

		// Thread.sleep(5000);
		assertion.CheckAssertionTrue(
				driver.findElement(By.xpath("//input[contains(@aria-label,'Remaining Lease Term')]"))
						.getAttribute("defaultValue").contains(map.get("Remaining Lease Term")),
				map.get("Remaining Lease Term"));

	}

	@Then("user validate {string} field when below values are selected in {string}")
	public void user_validate_field_when_below_values_are_selected_in(String string, String string2,
			DataTable dataTable) throws InterruptedException {

		List<String> actual = dataTable.asList();
		System.out.println(" Size of the data table is : " + actual.size());
		// System.out.println(driver.findElements(By.xpath("//*[text()='*']")).size());
		for (int i = 0; i <= actual.size() - 1; i++) {

			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Application Status']")), actual.get(i));
			Thread.sleep(1000);

			assertion.CheckAssertionTrue(driver.findElements(By.xpath("//label[text()='Notes']")).size() != 0, string);
			Thread.sleep(1000);

		}

	}

	@Then("user validate {string}")
	public void user_validate(String string) throws NumberFormatException, Exception {
		Thread.sleep(1000);
		String FullPurchasePrice = driver.findElement(By.xpath("//input[contains(@aria-label,'Full Purchase Price')]"))
				.getAttribute("title");
		Thread.sleep(1000);
		testutil.inputText(driver, "Share Requested", 0, "50");
		Thread.sleep(1000);
		testutil.clickOn(driver, 
				driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)'] | //button[contains(@title,'Save (CTRL+S)')]")), 10);
		Thread.sleep(1000);
		String SharePrice = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Share Price. Last saved value')]"))
				.getAttribute("title");

		System.out.println(FullPurchasePrice);
		System.out.println(SharePrice);

		String[] arrOfFullPurchasePrice = FullPurchasePrice.split("£", 2);
		String[] arrOfSharePrice = SharePrice.split("£", 2);

		System.out.println(arrOfFullPurchasePrice[1]);
		System.out.println(arrOfSharePrice[1]);

		String output2 = arrOfFullPurchasePrice[1].replaceAll("[-,]", "");
		String[] arrOfoutputvarrOfFullPurchasePrice = output2.split(".", 2);

		String output = arrOfSharePrice[1].replaceAll("[-,]", "");
		String[] arrOfoutputarrOfSharePrice = output.split(".", 2);

		System.out.println("output2 = " + output2);
		System.out.println("output = " + output);

		System.out.println(arrOfoutputarrOfSharePrice[1]);
		System.out.println(arrOfoutputvarrOfFullPurchasePrice[1]);

		float sPrice = Float.parseFloat(output);
		float fpPrice = Float.parseFloat(output2);

		System.out.println("fpPrice = " + fpPrice / 2);
		System.out.println("sPrice = " + sPrice);

		String strfpPrice = String.valueOf(fpPrice / 2);
		String strsPrice = String.valueOf(sPrice);

		assertion.CheckAssertion(strfpPrice, strsPrice);

	}

	@Then("user validate {string} field when {string} is selected as {string}")
	public void user_validate_field_when_is_selected_as(String string, String string2, String string3)
			throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='" + string2 + "']")));

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='" + string2 + "']")),
				string3);
		Thread.sleep(1000);

		assertion.CheckAssertionTrue(driver.findElements(By.xpath("//label[text()='" + string + "']")).size() != 0,
				string);

	}

	@Then("user validate {string} field is total of {string} and {string}")
	public void user_validate_field_is_total_of_and(String string, String string2, String string3) throws Exception {

		String NumberofAdults = driver.findElement(By.xpath("//input[@aria-label='Number of Adults']"))
				.getAttribute("title");
		String NumberofChildren = driver.findElement(By.xpath("//input[@aria-label='Number of Children']"))
				.getAttribute("title");

		String TotalNumberinHousehold = driver.findElement(By.xpath("//input[@aria-label='Total Number in Household']"))
				.getAttribute("title");

		Integer Actual = Integer.parseInt(NumberofAdults) + Integer.parseInt(NumberofChildren);
		Integer Expected = Integer.parseInt(TotalNumberinHousehold);

		assertion.CheckAssertion(Expected, Actual);

	}

	@Then("user validate {string} is mapped from {string} Tab")
	public void user_validate_is_mapped_from_Tab(String string, String string2) throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='" + string + "']")));

		String s = string.replaceAll("[ ]", "");
		String s2 = s.toLowerCase();
		System.out.println(s2);

		String Expected = driver.findElement(By.xpath("//ul[contains(@data-id,'" + s2 + "')]"))
				.getAttribute("textContent");

		System.out.println(map.get(string));
		System.out.println(Expected);
		// assertion.CheckAssertionTrue(Expected.contains(map.get(string)), Expected);
		assertion.CheckAssertion(map.get(string), Expected);
	}

	@Then("user validate {string} is mapped from Summary Tab")
	public void user_validate_is_mapped_from_Summary_Tab(String string) throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//label[text()='" + string + "']")));

		String s = string.replaceAll("[ ]", "");
		String s2 = s.toLowerCase();
		System.out.println(s2);

		String Expected = driver.findElement(By.xpath("//select[contains(@data-id,'" + s2 + "')]"))
				.getAttribute("textContent");

		System.out.println(map.get(string));
		System.out.println(Expected);
		// assertion.CheckAssertionTrue(Expected.contains(map.get(string)), Expected);
		assertion.CheckAssertion(map.get(string), Expected);
	}

	@Then("user Validates AML stage on BPF")
	public void user_clicks_AML_on_BPF() {
		try {
			Thread.sleep(500);
			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//li[contains(@aria-label,'Stage: AML')]")).size() != 0, "AML Stage");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user Validates Authority To Proceed stage on BPF")
    public void user_clicks_AuthorityToProceed_on_BPF() {
        try {
            Thread.sleep(2500);
            assertion.CheckAssertionTrue(
                    driver.findElements(By.xpath("//li[contains(@aria-label,'Stage: Authority To Proceed')]")).size() != 0, "Authority To Proceed");

        } catch (Exception e) 
        {

            e.printStackTrace();
        }
    }
	
	@Then("user Validates Conveyancing stage on BPF")
    public void user_clicks_Conveyancing_on_BPF() {
        try {
            Thread.sleep(500);
            assertion.CheckAssertionTrue(
                    driver.findElements(By.xpath("//li[contains(@aria-label,'Stage: Authority To Proceed')]")).size() != 0, "AML Stage");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
	
	@Then("user clicks on Create")
	public void user_clicks_on_Create() {

		testutil.clickOn(driver,
				driver.findElement(By
						.xpath("//button[@data-id='MscrmControls.Containers.ProcessStageControl-CreateNewContainer']")),
				0);

	}

	@Then("user enter the details in Questionnaire section")
	public void user_enter_the_details_in_Questionnaire_section() throws InterruptedException {
		Thread.sleep(500);

		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Getting a Mortgage?']")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Using Approved IFA?']")), "Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Using Approved Solicitor?']")), "Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Satisfied with ID?']")),
				"Yes");
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='HtB Deposit Match?']")),
				"Yes");
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Source Funds Total Correct?']")), "Yes");

		Thread.sleep(500);
	}

	@Then("user enter the details in Risk section")
	public void user_enter_the_details_in_Risk_section() throws InterruptedException {
		Thread.sleep(500);
		testutil.inputText(driver, "Reason", 0, "Test");
		Thread.sleep(500);
		testutil.inputText(driver, "Action taken to Mitigate Risk", 0, "Test");

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Referred Date']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		testutil.inputText(driver, "Review Comments", 0, "Test");

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Sign off Date']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

//Signed off by

	}

	@Then("user enter the details in AML Signature section")
	public void user_enter_the_details_in_AML_Signature_section() {

	}

	@Then("user validate below fields are hidden")
	public void user_validate_below_fields_are_hidden(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		Thread.sleep(1000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='AML Risk Status']")),
				"Low");
		Thread.sleep(500);
		testutil.lockedUnlocked(dataTable);
		Thread.sleep(500);
	}

	@Then("user enter the details in Reservation section")
	public void user_enter_the_details_in_Reservation_section() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Property Matched on HTB']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Date Reservation Form Sent']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Reservation Form Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		map.put("Reservation Form Received",
				driver.findElement(By.xpath("//input[@aria-label='Date of Reservation Form Received']"))
						.getAttribute("defaultValue"));

		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//input[@aria-label='Date of Date Simultaneous Resale Reservation Form Sent']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//input[@aria-label='Date of Date Simultaneous Resale Reservation Form Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Reservation Fee Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@aria-label='Date of Property Reserved Date']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Fee Memo Sent']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Payment Made']")),
				"Yes");
		testutil.inputText(driver, "Reservation Fee (£)", 0, "10");
		map.put("ReservationFee", "10");
		testutil.inputText(driver, "Reason Payment Not Made", 0, "Test");

	}

	@Then("user enter the details in Memorandum of Sale")
	public void user_enter_the_details_in_Memorandum_of_Sale() throws InterruptedException, IOException {

		driver.findElement(
				By.xpath("//input[@aria-label='Date of Seller Solicitor Details Requested']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		driver.findElement(
				By.xpath("//input[@aria-label='Date of  Seller Solicitor Details Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		driver.findElement(
				By.xpath("//input[@aria-label='Date of Buyers Solicitor Details Requested']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//input[@aria-label='Date of Buyer Solicitor Details Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@aria-label='Date of MOS Sent']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

		Properties ProcessingApplicationsResale = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");

		System.out.println(ProcessingApplicationsResale.getProperty("SellerSolicitor"));

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Seller Solicitor, Lookup']"))).build()
				.perform();
		Thread.sleep(500);
		
		actions.click(driver.findElement(
				By.xpath("//li[@aria-label='Test Solicitor']")))
				.build().perform();
		Thread.sleep(1000);

		actions.click(driver.findElement(By.xpath("//input[@aria-label='Seller Solicitor Contact, Lookup']"))).build()
				.perform();
		Thread.sleep(500);
		actions.click(driver.findElement(By.xpath(
				"//li[@aria-label='" + ProcessingApplicationsResale.getProperty("SellerSolicitorContact") + "']")))
				.build().perform();
		Thread.sleep(1000);

//		actions.click(driver.findElement(By.xpath("//input[@aria-label='Buyers Solicitor, Lookup']"))).build()
//				.perform();
//		Thread.sleep(500);		
//		actions.sendKeys(ProcessingApplicationsResale.getProperty("BuyersSolicitor")).build().perform();
//		Thread.sleep(500);
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("BuyersSolicitor") + "']")))
//				.build().perform();
//		Thread.sleep(1000);
//		
//		actions.click(driver.findElement(By.xpath("//input[@aria-label='Buyers Solicitor Contact, Lookup']"))).build()
//				.perform();
//		Thread.sleep(500);
//		actions.click(driver.findElement(
//				By.xpath("//li[@aria-label='" + ProcessingApplicationsResale.getProperty("BuyersSolicitorContact") + "']")))
//				.build().perform();
//		Thread.sleep(1000);

	}

	@Then("user clicks Reservation on BPF")
	public void user_clicks_Reservation_on_BPF() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[contains(@aria-label,'Stage: Reservation')]")).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user enters Reservation Fee Received")
	public void user_enters_Reservation_Fee_Received() throws InterruptedException {
		driver.findElement(By.xpath(
				"//section[@aria-label='Reservation']//input[@aria-label='Date of Reservation Fee Received']//following-sibling::i"))
				.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(2500);
	}

	@Then("user enters MOS Sent")
	public void user_enters_MOS_Sent() throws InterruptedException {
		driver.findElement(By.xpath("//input[@aria-label='Date of MOS Sent']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);
	}

	@Then("user enter the details in Resale Fees Seller")
	public void user_enter_the_details_in_Resale_Fees_Seller() throws InterruptedException {
		testutil.inputText(driver, "Days Owed in Month", 10, "10");
		driver.findElement(By.xpath("//input[@aria-label='Date of LPE1 Date Sent']//following-sibling::i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

		testutil.inputText(driver, "Arrears", 10, "10");
		testutil.inputText(driver, "Other Fees", 10, "5");

	}

	@Then("user enter the details in Resale Fees Buyer")
	public void user_enter_the_details_in_Resale_Fees_Buyer() {
		testutil.inputText(driver, "Days Remaining In Month", 10, "5");
		testutil.inputText(driver, "Mortgage Approval Fee", 10, "5");
		testutil.inputText(driver, "Notice of Transfer", 10, "5");
		testutil.inputText(driver, "Notice of Mortgage", 10, "5");
		testutil.inputText(driver, "Certificate of Compliance", 10, "5");
		testutil.inputText(driver, "Deed of Covenant", 10, "5");
		testutil.inputText(driver, "Any Other Fees", 10, "5");
		testutil.inputText(driver, "Any Other Fees Amount", 10, "5");
	}

	@Then("user enter the details in Completion Statement")
	public void user_enter_the_details_in_Completion_Statement() throws InterruptedException {
		testutil.inputText(driver, "Days in Month of Completion", 10, "5");
		Thread.sleep(1000);
		testutil.selectByVisibleText(driver,
				driver.findElement(By.xpath("//select[@aria-label='Completion Statement Requested ']")), "Yes");

		driver.findElement(By.xpath("//input[@aria-label='Date of Completion Statement Issued']//following-sibling::i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='Date of Predicted Completion Date ']//following-sibling::i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

		driver.findElement(
				By.xpath("//input[@aria-label='Date of Revised Completion Statement Issued']//following-sibling::i"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(1000);

	}

	@Then("user validate Rent Amount Owed field")
	public void user_validate_Rent_Amount_Owed_field() throws InterruptedException {

		String TotalChargeinMonth = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Total Charge in Month')]")).getAttribute("title");

		String DaysinMonthofCompletion = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Days in Month of Completion')]"))
				.getAttribute("title");

		String DaysOwedinMonth = driver.findElement(By.xpath("//input[contains(@aria-label,'Days Owed in Month')]"))
				.getAttribute("title");

		String[] arrOfTotalChargeinMonth = TotalChargeinMonth.split("£", 2);

		System.out.println(arrOfTotalChargeinMonth[1]);

		String output2 = arrOfTotalChargeinMonth[1].replaceAll("[-,]", "");
		// String[] arrOfoutputvarrOfTotalChargeinMonth = output2.split(".", 2);

		System.out.println("output2 = " + output2);

		// System.out.println(arrOfoutputvarrOfTotalChargeinMonth[1]);

		float TChargeinMonth = Float.parseFloat(output2);

		System.out.println(TChargeinMonth);
		System.out.println(Integer.parseInt(DaysinMonthofCompletion));
		System.out.println(Integer.parseInt(DaysOwedinMonth));

		Integer Actual = (int) (TChargeinMonth / (Integer.parseInt(DaysinMonthofCompletion))
				* Integer.parseInt(DaysOwedinMonth));
		testutil.jsclick(driver.findElement(By.xpath("//*[text()='Save']")), driver);
		Thread.sleep(5000);
		String Expected = driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Amount Owed')]"))
				.getAttribute("title");
		System.out.println("Expected : " + Expected);
		System.out.println("Actual : " + Actual);
		assertion.CheckAssertionTrue(Expected.contains(String.valueOf(Actual)), Expected);

	}

	@Then("user validate Total Seller field")
	public void user_validate_Total_Seller_field() throws InterruptedException {
		Thread.sleep(2000);
		String RentAmountOwed = driver.findElement(By.xpath("//input[contains(@aria-label,'Rent Amount Owed')]"))
				.getAttribute("title");
		String Arrears = driver.findElement(By.xpath("//input[contains(@aria-label,'Arrears')]")).getAttribute("title");
		String Adminfee = driver.findElement(By.xpath("//input[contains(@aria-label,'Admin Fee')]"))
				.getAttribute("title");
		String LPE1Fee = driver.findElement(By.xpath("//input[contains(@aria-label,'LPE1 Fee')]"))
				.getAttribute("title");
		String OtherFees = driver.findElement(By.xpath("//input[contains(@aria-label,'Other Fees')]"))
				.getAttribute("title");
		Thread.sleep(2500);
		String TotalSeller = driver.findElement(By.xpath("//input[contains(@aria-label,'Total (Seller)')]"))
				.getAttribute("title");

		String[] arrOfRentAmountOwed = RentAmountOwed.split("£", 2);
		System.out.println(arrOfRentAmountOwed[1]);

		String[] arrOfArrears = Arrears.split("£", 2);
		System.out.println(arrOfArrears[1]);

		String[] arrOfAdminfee = Adminfee.split("£", 2);
		System.out.println(arrOfAdminfee[1]);

		String[] arrOfLPE1Fee = LPE1Fee.split("£", 2);
		System.out.println(arrOfLPE1Fee[1]);

		String[] arrOfOtherFees = OtherFees.split("£", 2);
		System.out.println(arrOfOtherFees[1]);

		String[] arrOfTotalSeller = TotalSeller.split("£", 2);
		System.out.println(arrOfTotalSeller[1]);

		String output2 = arrOfRentAmountOwed[1].replaceAll("[-,]", "");
		String OarrOfArrears = arrOfArrears[1].replaceAll("[-,]", "");
		String OarrOfAdminfee = arrOfAdminfee[1].replaceAll("[-,]", "");
		String OarrOfLPE1Fee = arrOfLPE1Fee[1].replaceAll("[-,]", "");
		String OarrOfOtherFees = arrOfOtherFees[1].replaceAll("[-,]", "");
		String OarrOfTotalSeller = arrOfTotalSeller[1].replaceAll("[-,]", "");

		float OORentAmountOwed = Float.parseFloat(output2);
		float OOarrOfArrears = Float.parseFloat(OarrOfArrears);
		float OOarrOfAdminfee = Float.parseFloat(OarrOfAdminfee);
		float OOarrOfLPE1Fee = Float.parseFloat(OarrOfLPE1Fee);
		float OOarrOfOtherFees = Float.parseFloat(OarrOfOtherFees);
		float OOarrOfTotalSeller = Float.parseFloat(OarrOfTotalSeller);

		System.out.println("sPRentAmountOwedrice = " + OORentAmountOwed);
		System.out.println((OOarrOfArrears));
		System.out.println((OOarrOfAdminfee));
		System.out.println((OOarrOfLPE1Fee));
		System.out.println((OOarrOfOtherFees));
		System.out.println((OOarrOfTotalSeller));
		System.out.println(("=============="));

		Float Actual = ((OORentAmountOwed) + (OOarrOfArrears) + (OOarrOfAdminfee) + (OOarrOfLPE1Fee)
				+ (OOarrOfOtherFees));

		System.out.println(OOarrOfTotalSeller);
		System.out.println(Actual);

		assertion.CheckAssertionTrue(String.valueOf(OOarrOfTotalSeller).contains(String.valueOf(Actual)),
				OarrOfTotalSeller);

	}

	@Then("user validate Current Month Rent Owed field")
	public void user_validate_Current_Month_Rent_Owed_field() {

		String CurrentMonthRentOwed = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Current Month Rent Owed')]"))
				.getAttribute("title");

		String TotalChargeinMonth = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Total Charge in Month (incl. Service Charge)')]"))
				.getAttribute("title");
		String DaysinMonthofCompletion = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Days in Month of Completion')]"))
				.getAttribute("title");
		String DaysRemainingInMonth = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Days Remaining In Month')]"))
				.getAttribute("title");

		String[] arrCurrentMonthRentOwed = CurrentMonthRentOwed.split("£", 2);
		System.out.println(arrCurrentMonthRentOwed[1]);

		String[] arrTotalChargeinMonth = TotalChargeinMonth.split("£", 2);
		System.out.println(arrTotalChargeinMonth[1]);

		String OarrCurrentMonthRentOwed = arrCurrentMonthRentOwed[1].replaceAll("[-,]", "");
		String OTotalChargeinMonth = arrTotalChargeinMonth[1].replaceAll("[-,]", "");

		float OOarrCurrentMonthRentOwed = Float.parseFloat(OarrCurrentMonthRentOwed);
		float OOTotalChargeinMonth = Float.parseFloat(OTotalChargeinMonth);

		// Integer Expected = Integer.parseInt(OarrCurrentMonthRentOwed);
//		Integer Actual = Integer.parseInt(TotalChargeinMonth)
//				/ (Integer.parseInt(DaysinMonthofCompletion) * Integer.parseInt(DaysRemainingInMonth));

		Integer Actual = (int) ((OOTotalChargeinMonth) / (Integer.parseInt(DaysinMonthofCompletion))
				* Integer.parseInt(DaysRemainingInMonth));

		System.out.println(OOarrCurrentMonthRentOwed);
		System.out.println(Actual);

		assertion.CheckAssertionTrue(String.valueOf(OOarrCurrentMonthRentOwed).contains(String.valueOf(Actual)),
				String.valueOf(OOarrCurrentMonthRentOwed));

	}

	@Then("user validate Total buyer field")
	public void user_validate_Total_buyer_field() {
		String CurrentMonthRentOwed = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Current Month Rent Owed')]"))
				.getAttribute("title");

		String TotalChargeinMonth = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Total Charge in Month (incl. Service Charge)')]"))
				.getAttribute("title");
		String MortgageApprovalFee = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Mortgage Approval Fee')]")).getAttribute("title");

		String NoticeofTransfer = driver.findElement(By.xpath("//input[contains(@aria-label,'Notice of Transfer')]"))
				.getAttribute("title");

		String NoticeofMortgage = driver.findElement(By.xpath("//input[contains(@aria-label,'Notice of Mortgage')]"))
				.getAttribute("title");

		String CertificateofCompliance = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Certificate of Compliance')]"))
				.getAttribute("title");

		String DeedofCovenant = driver.findElement(By.xpath("//input[contains(@aria-label,'Deed of Covenant')]"))
				.getAttribute("title");

		String AnyOtherFeesAmount = driver
				.findElement(By.xpath("//input[contains(@aria-label,'Any Other Fees Amount')]")).getAttribute("title");

		map.get("ReservationFee");
		System.out.println("======================================");

		System.out.println(CurrentMonthRentOwed);
		System.out.println(TotalChargeinMonth);
		System.out.println(MortgageApprovalFee);
		System.out.println(NoticeofTransfer);
		System.out.println(NoticeofMortgage);
		System.out.println(CertificateofCompliance);
		System.out.println(DeedofCovenant);
		System.out.println(AnyOtherFeesAmount);
		System.out.println(map.get("ReservationFee"));

		String ReservationFee = map.get("ReservationFee");

//		String[] arrReservationFee = ReservationFee.split("£", 2);
//		System.out.println(arrReservationFee[1]);
//		String OarrReservationFee = arrReservationFee[1].replaceAll("[-,]", "");
		float OOarrReservationFee = Float.parseFloat(ReservationFee);
		System.out.println(map.get("OOarrReservationFee"));

		String[] arrAnyOtherFeesAmount = AnyOtherFeesAmount.split("£", 2);
		System.out.println(arrAnyOtherFeesAmount[1]);
		String OarrAnyOtherFeesAmount = arrAnyOtherFeesAmount[1].replaceAll("[-,]", "");
		float OOarrAnyOtherFeesAmount = Float.parseFloat(OarrAnyOtherFeesAmount);

		String[] arrDeedofCovenant = DeedofCovenant.split("£", 2);
		System.out.println(arrDeedofCovenant[1]);
		String OarrDeedofCovenant = arrDeedofCovenant[1].replaceAll("[-,]", "");
		float OOarrDeedofCovenant = Float.parseFloat(OarrDeedofCovenant);

		String[] arrCertificateofCompliance = CertificateofCompliance.split("£", 2);
		System.out.println(arrCertificateofCompliance[1]);
		String OarrCertificateofCompliance = arrCertificateofCompliance[1].replaceAll("[-,]", "");
		float OOarrCertificateofCompliance = Float.parseFloat(OarrCertificateofCompliance);

		String[] arrCurrentMonthRentOwed = CurrentMonthRentOwed.split("£", 2);
		System.out.println(arrCurrentMonthRentOwed[1]);
		String OarrCurrentMonthRentOwed = arrCurrentMonthRentOwed[1].replaceAll("[-,]", "");
		float OOarrCurrentMonthRentOwed = Float.parseFloat(OarrCurrentMonthRentOwed);

		String[] arrOfTotalChargeinMonth = TotalChargeinMonth.split("£", 2);
		System.out.println(arrOfTotalChargeinMonth[1]);
		String OarrOfTotalChargeinMonth = arrOfTotalChargeinMonth[1].replaceAll("[-,]", "");
		float OOarrOfTotalChargeinMonth = Float.parseFloat(OarrOfTotalChargeinMonth);

		String[] arrMortgageApprovalFee = MortgageApprovalFee.split("£", 2);
		System.out.println(arrCurrentMonthRentOwed[1]);
		String OarrMortgageApprovalFee = arrMortgageApprovalFee[1].replaceAll("[-,]", "");
		float OOarrMortgageApprovalFee = Float.parseFloat(OarrMortgageApprovalFee);

		String[] arrNoticeofTransfer = NoticeofTransfer.split("£", 2);
		System.out.println(arrNoticeofTransfer[1]);
		String OarrNoticeofTransfer = arrNoticeofTransfer[1].replaceAll("[-,]", "");
		float OOarrNoticeofTransfer = Float.parseFloat(OarrNoticeofTransfer);

		String[] arrNoticeofMortgage = NoticeofMortgage.split("£", 2);
		System.out.println(arrNoticeofMortgage[1]);
		String OarrNoticeofMortgage = arrNoticeofMortgage[1].replaceAll("[-,]", "");
		float OOarrNoticeofMortgage = Float.parseFloat(OarrNoticeofMortgage);

		Integer Actual = (int) ((OOarrCurrentMonthRentOwed + OOarrOfTotalChargeinMonth + OOarrMortgageApprovalFee
				+ OOarrNoticeofTransfer + OOarrNoticeofMortgage + OOarrAnyOtherFeesAmount + OOarrDeedofCovenant
				+ OOarrCertificateofCompliance) - OOarrReservationFee);
//				+NoticeofMortgage
//				+CertificateofCompliance
//				+DeedofCovenant
//				+AnyOtherFeesAmount)-Integer.parseInt(map.get("ReservationFee"));

		String Expected = driver.findElement(By.xpath("//input[contains(@aria-label,'Total. Last saved value')]"))
				.getAttribute("title");
		String[] arrExpected = Expected.split("£", 2);
		System.out.println(arrExpected[1]);
		String OarrExpected = arrExpected[1].replaceAll("[-,]", "");
		float OOarrExpected = Float.parseFloat(OarrExpected);

		System.out.println(Actual);
		System.out.println(OOarrExpected);

		assertion.CheckAssertionTrue(String.valueOf(OOarrExpected).contains(String.valueOf(Actual)),
				String.valueOf(OOarrExpected));

	}

	@Then("user validate Reservation Form Received is mapped from {string} Tab")
	public void user_validate_Reservation_Form_Received_is_mapped_from_summary_Tab(String string) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(
				"//label[@id='header_process_po_reservationformreceived-header_process_po_reservationformreceived-field-label']")));

		String s = string.replaceAll("[ ]", "");
		String s2 = s.toLowerCase();
		System.out.println(s2);

		String Expected = driver.findElement(By.xpath("//div[contains(@data-id,'" + s2 + "')]"))
				.getAttribute("textContent");

		System.out.println(map.get(string));
		System.out.println(Expected);
		// assertion.CheckAssertionTrue(Expected.contains(map.get(string)), Expected);
		assertion.CheckAssertion(map.get(string), Expected);
	}

	@Then("user set {string} date")
	public void user_set_date(String string) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[contains(@aria-label,'" + string + "')]//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

	}

	@Then("user enter the details in Completion and Handover information")
	public void user_enter_the_details_in_Completion_and_Handover_information() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Completion Date']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(
				By.xpath("//input[@aria-label='Date of Internal Handover Memo Issued']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of HtB Complete']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of CORE Complete']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		testutil.inputText(driver, "CORE ID", 10, "Test");

	}

	@Then("user enter the details in Post Completion Documentation")
	public void user_enter_the_details_in_Post_Completion_Documentation() throws InterruptedException {

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Notice Received']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Notice Returned']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(
				By.xpath("//input[@aria-label='Date of Certificate of Compliance Requested']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(
				By.xpath("//input[@aria-label='Date of Certificate of Compliance Returned']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Deed of Covenant Requested']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Deed of Covenant Returned']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

	}

	@Then("user enter the details in Fee Confirmation")
	public void user_enter_the_details_in_Fee_Confirmation() throws InterruptedException {

		testutil.inputText(driver, "Sellers Fees Outstanding", 10, "7");
		testutil.inputText(driver, "Buyers Fees Outstanding", 10, "8");

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Sellers Fees Chased']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Sellers Fees Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Buyers Fees Chased']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@aria-label='Date of Buyers Fees Received']//following-sibling::i"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();
		Thread.sleep(500);

	}

	@Then("user validates Sovereign Requirement Section is not displayed under Post Completion Requirement tab")
	public void user_validates_Sovereign_Requirement_Section_is_not_displayed_under_Post_Completion_Requirement_tab() {

	}

	@Then("user validates Total fees seller is displayed under Post Completion Requirement tab")
	public void user_validates_Total_fees_seller_is_displayed_under_Post_Completion_Requirement_tab() {

	}

	@Then("user validates Total fees buyer is displayed under Post Completion Requirement tab")
	public void user_validates_Total_fees_buyer_is_displayed_under_Post_Completion_Requirement_tab() {

	}

	@Then("user validates Fee Confirmation Section is displayed under Post Completion Requirement tab")
	public void user_validates_Fee_Confirmation_Section_is_displayed_under_Post_Completion_Requirement_tab() {

	}

	@Then("user validates Post Completion Documentation Section is displayed under Post Completion Requirement tab")
	public void user_validates_Post_Completion_Documentation_Section_is_displayed_under_Post_Completion_Requirement_tab() {

	}

	@Then("user selects Completed as {string}")
	public void user_selects_Completed_as(String string) {
		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Completed ?']")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Handover to Internal Teams as {string}")
	public void user_selects_Handover_to_Internal_Teams_sas(String string) {
		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Handover to Internal Teams ?']")), string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects CORE as {string}")
	public void user_selects_CORE_as(String string) {
		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='CORE ?']")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects HtB Completed as {string}")
	public void user_selects_HtB_Completed_as(String string) {
		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='HtB Completed?']")),
					string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Funds Received as {string}")
	public void user_selects_Funds_Received_as(String string) {

		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Funds Received ?']")), string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user selects Post Completion Tasks Completed as {string}")
	public void user_selects_Post_Completion_Tasks_Completed_as(String string) {

		try {
			Thread.sleep(500);
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[@aria-label='Post Completion Tasks Completed?']")), string);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user search Property Name")
	public void user_search_Application_Title() throws IOException {
		Properties ApplicationTitle = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResales.properties");

		System.out.println(ApplicationTitle.getProperty("PropertyName"));

		String name = ApplicationTitle.getProperty("PropertyName");

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

	@Then("user select any property")
	public void user_select_any_property() {

		try {
			Thread.sleep(2000);
			String PropertName = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']//a"))
					.getAttribute("textContent");
			map.put("PropertName", PropertName);

			Thread.sleep(2000);
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user select any Rent Account Record")
	public void user_select_any_Rent_Account_Record() {

		try {
			Thread.sleep(2000);
			String RentAccountName = driver
					.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a"))
					.getAttribute("textContent");
			map.put("RentAccountName", RentAccountName);

			Thread.sleep(2000);
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Then("user read the {string} and {string} from {string} section")
	public void user_read_the_and_from_section(String string, String string2, String string3) throws InterruptedException {
		
		Thread.sleep(2000);

		String CurrentMonthlyRent = driver.findElement(By.xpath("//input[contains(@aria-label,'" + string + "')]"))
				.getAttribute("title");
		map.put("CurrentMonthlyRent", CurrentMonthlyRent);
		System.out.println(CurrentMonthlyRent);

		String CurrentMonthlyServiceCharge = driver
				.findElement(By.xpath("//input[contains(@aria-label,'" + string2 + "')]")).getAttribute("title");
		map.put("CurrentMonthlyServiceCharge", CurrentMonthlyServiceCharge);
		System.out.println(CurrentMonthlyServiceCharge);

	}

	@Then("user read the {string} and {string} charges from {string} Section")
	public void user_read_the_and_charges_from_Section(String string, String string2, String string3) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[contains(@aria-label,'CHARGES')]")));

		for (int i = 2; i < 10; i++) {
			if (driver.findElements(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='2']//a"))
					.size() != 0) {
				System.out.println(driver.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='2']//a"))
						.getAttribute("textContent"));
				if (driver.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='2']//a"))
						.getAttribute("textContent").contains("Rent")) 
				{
					
					

					String name = driver
							.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='7']"))
							.getAttribute("textContent");

					System.out.println(name);
					map.put("RentCharge", name);
				}
				if (driver.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='2']//a"))
						.getAttribute("textContent").contains("Other")) 
				{

					String name = driver
							.findElement(By.xpath("//div[@aria-rowindex='" + i + "']//div[@aria-colindex='7']"))
							.getAttribute("textContent");

					System.out.println(name);
					map.put("OtherCharge"+i, name);
				}
			}

		} 
	
		

	}
	
	@Then("user validate {string} and {string}")
	public void user_validate_and(String string, String string2) throws InterruptedException {	
		Thread.sleep(2000);
		System.out.println("=============================");
		System.out.println(map.get("CurrentMonthlyRent"));
		System.out.println(map.get("CurrentMonthlyServiceCharge"));
		System.out.println(map.get("OtherCharge2"));
		System.out.println(map.get("OtherCharge3"));
		System.out.println(map.get("RentCharge"));
		System.out.println("=============================");
		
		String[] arrCurrentMonthlyRent = map.get("CurrentMonthlyRent").split("£", 2);
		System.out.println(arrCurrentMonthlyRent[1]);
		
		String[] arrCurrentMonthlyServiceCharge = map.get("CurrentMonthlyServiceCharge").split("£", 2);
		System.out.println(arrCurrentMonthlyServiceCharge[1]);
		
		String[] arrOtherCharge2 = map.get("OtherCharge2").split("£", 2);
		System.out.println(arrOtherCharge2[1]);
		
		String[] arrOtherCharge3 = map.get("OtherCharge3").split("£", 2);
		System.out.println(arrOtherCharge3[1]);
		
		String[] arrRentCharge = map.get("RentCharge").split("£", 2);
		System.out.println(arrRentCharge[1]);
		
		
		String OarrOtherCharge2 = arrOtherCharge2[1].replaceAll("[-,]", "");
		float OOarrOtherCharge2 = Float.parseFloat(OarrOtherCharge2);
		
		String OarrOtherCharge3 = arrOtherCharge3[1].replaceAll("[-,]", "");
		float OOarrOtherCharge3 = Float.parseFloat(OarrOtherCharge3);
		
		Float exp = OOarrOtherCharge2+OOarrOtherCharge3;
		
				assertion.CheckAssertionTrue(arrCurrentMonthlyServiceCharge[1].contains(String.valueOf(exp)),
						arrCurrentMonthlyServiceCharge[1]);
				Thread.sleep(1000);
				
				assertion.CheckAssertionTrue(arrCurrentMonthlyRent[1].contains(String.valueOf(arrRentCharge[1])),
						arrCurrentMonthlyRent[1]);
		
		
	}
	
	@Then("user enters details in New Charge Section")
	public void user_enters_details_in_New_Charge_Section() throws InterruptedException {
		Thread.sleep(500);
		testutil.inputText(driver, "Name", 10, "Rent Test");
		testutil.inputText(driver, "Charge Group Value", 10, "5");
		Thread.sleep(500);
	   
	}

}
