package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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

public class Assessment_ETStepDefs {

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
	HashMap<String, String> maps = new HashMap<String, String>();

	@Then("user click on contact {string}")
	public void user_click_on_contact(String contactName) {
		try {
			testutil.clickOn(driver, driver.findElement(By.xpath("//a[@aria-label='" + contactName + "']")), 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user verifies Timeline Name as {string} and status as {string}")
	public void user_verifies_Timeline_status(String TimeLineName, String Status) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			System.out.println("User validating Task is closed");
			System.out.println(driver
					.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
					.getAttribute("outerText"));
			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
					.getAttribute("outerText").contains(Status), Status);

			assertion.CheckAssertionTrue(driver
					.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
					.getAttribute("outerText").contains(TimeLineName), TimeLineName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user creates New Contact")
	public void user_creates_New_Contact() throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

		testutil.inputText(driver, "First Name", 4, "Test First Name");
		testutil.inputText(driver, "Last Name", 4, "Test Last Name");
		testutil.inputText(driver, "Telephone (Mobile)", 4, "4444444444");
		testutil.inputText(driver, "Telephone (Home)", 4, "4444444445");

		String selectedValue = slatimer.Select_LookUpValue(assessment_ET.objContactType,
				assessment_ET.objNewContactItem, assessment_ET.objcontacttypeSelectedRecordList, "New Contact");
		System.out.println(selectedValue);

		testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")), 4);

	}

	@Then("user validates {string}")
	public void user_validates(String string) {
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//label[text()='" + string + "']")), string);

	}

	@Then("user validates {string} is mapped from contact as {string}")
	public void user_validates_is_mapped_from_contact(String string, String value) {
		try {
			assertion.CheckAssertion(
					driver.findElement(By.xpath("//input[@aria-label='" + string + "']")).getAttribute("title"), value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validates {string} is populated as {string}")
	public void user_validates_is_populated_as(String string, String string2) {
		try {
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("(//div[@data-preview_orientation='column'])[1]"))
					.getAttribute("textContent").contains(string2), string2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user enter {string} as {string}")
	public void user_enter_as(String string, String string2) {
		try {
			testutil.inputText(driver, string, 10, string2);
			Wait.untilPageLoadComplete(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validates Assessment Title as {string}")
	public void user_validates_Assessment_Title_as(String string) {
		try {
			actions.sendKeys(Keys.ESCAPE).build().perform();
			driver.navigate().refresh();
			// actions.sendKeys(Keys.CONTROL+"F5").build().perform();
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']"))
					.getAttribute("textContent").contains(string), string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate Assessment is showing in Assessment Grid")
	public void user_validate_Assessment_is_showing_in_Assessment_Grid() {
		try {
			String referralId = driver.findElement(By.xpath("//h1[@id='formHeaderTitle_1']")).getAttribute("title");
			testutil.jsclick(driver.findElement(By.xpath("//*[@aria-label='Press Enter to go back.']")), driver);
			Thread.sleep(2000);
			testutil.inputText(driver, "Referral Filter by keyword", 2, referralId);
			Thread.sleep(5000);
			// testutil.jsclick(driver.findElement(By.xpath("//*[@aria-label='Start
			// search']")), driver);
			System.out.println("clicked on start search");
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//a[@aria-label='" + referralId + "']")).isDisplayed(), referralId);

			// driver.findElement(By.xpath("//a[@aria-label='"+referralId+"']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user click on New Assessment")
	public void user_click_on_New_Assessment() {
		try {
			testutil.clickOn(driver, driver.findElement(By.xpath("//input[@aria-label='Assessment, Lookup']")), 2);
			testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='New Assessment']")), 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user will select ETO as {string}")
	public void user_will_select_ETO(String fieldvalue) throws Exception {
		try {
			Thread.sleep(1000);
			// action.moveToElement(slatimer.objCategoryField).build().perform();
			String selectedValue = slatimer.Select_LookUpValue(assessment_ET.objETO, assessment_ET.objETOItemvalue,
					assessment_ET.objetoSelectedRecordList, fieldvalue);
			System.out.println("selcted fieldValue  = " + selectedValue);
			Thread.sleep(2000);
			actions.sendKeys(Keys.ESCAPE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user fills all the fields in Contact Information Section")
	public void user_fills_all_the_fields_in_Contact_Information_Section() {
		try {
			// testutil.selectByVisibleText(driver, assessment_ET.objReasonforEnrolment,
			// "Find Work");
			cases.fillDetails("Source of Referral External", "22 Potters Wood");
			cases.fillDetails("Source of Referral Internal", "Julie Rush");
			testutil.selectByVisibleText(driver, assessment_ET.objSafeguardingStatementRead, "Yes");
			testutil.selectByVisibleText(driver, assessment_ET.objDemographicInfoCapturedforActiveH, "Yes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Background Information Section")
	public void user_fills_all_the_fields_in_Background_Information_Section(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				// select[@aria-label='Photo ID?']
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[@aria-label='" + actual.get(j) + "']")), "Yes");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Service Goals Section")
	public void user_fills_all_the_fields_in_Service_Goals_Section(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				Thread.sleep(2000);
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[@aria-label='" + actual.get(j) + "']")), "Yes");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Goal Setting Section")
	public void user_fills_all_the_fields_in_Goal_Setting_Section(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				testutil.inputText(driver, actual.get(j), 1, "Goal" + j);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Sector Choices Section")
	public void user_fills_all_the_fields_in_Sector_Choices_Section(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				// select[@aria-label='Photo ID?']
				Thread.sleep(1000);
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[@aria-label='" + actual.get(j) + "']")), "Yes");
			}
			testutil.inputText(driver, "Other", 1, "New Assessment");
			testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Contract Type']")),
					"Seasonal");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Rent Account Capture Section")
	public void user_fills_all_the_fields_in_Rent_Account_Capture_Section() {

		try {
			testutil.inputText(driver, "Date of Enrollment", 1, "24/08/2022");
			Thread.sleep(2000);
			testutil.inputText(driver, "Rent Account Status", 1, "45");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Sensitive Information Section")
	public void user_fills_all_the_fields_in_Sensitive_Information_Section(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				// select[@aria-label='Photo ID?']
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[@aria-label='" + actual.get(j) + "']")), "Yes");
			}
			testutil.inputText(driver, "Lone Parent Information", 1, "Test");
			testutil.inputText(driver, "Criminal Convictions/Cautions Information", 1, "Test");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user click on New Referral")
	public void user_click_new_referral() throws InterruptedException {
		System.out.println("User clicking New referral");
		testutil.jsclick(driver.findElement(By.xpath("//*[contains(@aria-label,'New Referral. Add New Referral')]")),
				driver);
		Thread.sleep(2000);
	}

	@Then("user click on more tabs")
	public void user_click_more_tabs() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("User clicking More Tabs");
		testutil.jsclick(driver.findElement(By.xpath("//*[contains(@aria-label,'More Tabs')]")), driver);
		Thread.sleep(2000);
	}

	@Then("user select {string}")
	public void user_select(String Menuitem) {
		try {
			genericCases.SelectRelatedTabMenuItem(Menuitem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user select Referrals under More Tabs")
	public void user_select_referrals_under_more_tabs() throws InterruptedException {
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//div[@aria-label='Referrals Related - Common']//span[text()='Referrals']"))
					.click();
		} catch (Exception e) {
		}

	}

	@Then("user validates Owner {string} and Created By as {string}")
	public void user_validates_Owner_D365_Service_Account_and_Created_By_as(String OwnerName, String CreateByName) {
		try {
			actions.moveToElement(driver.findElement(By.xpath("(//div[contains(@id,'timeline_record')])[1]"))).build()
					.perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@aria-label='Open Record']")).click();
			Thread.sleep(2000);
			testutil.jsclick(driver.findElement(By.xpath("//*[@aria-label='More Header Editable Fields']")), driver);
			System.out.println("User Clicked more header editable fields");
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//div[contains(@data-id,'ownerid-FieldSectionItemContainer')]"))
							.getAttribute("textContent").contains(OwnerName),
					OwnerName);
			// assertion.CheckAssertionTrue(
			// driver.findElement(By.xpath("//div[contains(@data-id,'createdby-FieldSectionItemContainer')]"))
			// .getAttribute("textContent").contains(CreateByName),
			// CreateByName);
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//ul[contains(@data-id,'header_modifiedby.fieldControl')]"))
							.getAttribute("textContent").contains(CreateByName),
					CreateByName);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user navigates to ETO Initial Assessment")
	public void user_navigates_to_ETO_Initial_Assessment() {
		try {
			contact.clicksOn("Press Enter to go back.");
			contact.clicksOn("Press Enter to go back.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks Final Assessment on BPF")
	public void user_clicks_Final_Assessment_on_BPF() {
		testutil.clickOn(driver, assessment_ET.objBPFFinalAssessment, 2);
	}

	@Then("user clicks Initial Assessment on BPF")
	public void user_clicks_Initial_Assessment_on_BPF1() {
		testutil.clickOn(driver, assessment_ET.objBPFInitialAssessment, 2);
	}

	@Then("user selects Final Assessment Complete as {string}")
	public void user_selects_Final_Assessment_Complete_as(String string) {
		try {
			testutil.selectByVisibleText(driver, assessment_ET.objFinalAssessmentComplete, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user selects Initial Assessment Complete as {string}")
	public void user_selects_Initial_Assessment_Complete_as1(String string) {
		try {
			testutil.selectByVisibleText(driver, assessment_ET.objInitialAssessmentComplete, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks Finish in BPF")
	public void user_clicks_Finish_in_Triage_Assessment_on_BPF() {
		try {
			Thread.sleep(2000);
			testutil.clickOn(driver, assessment_ET.objBPFFinish, 2);
			Thread.sleep(4000);
			// actions.click().build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user read the case title")
	public void readCaseTitle() {
		String caseTitle = driver.findElement(By.xpath("//input[@aria-label='Case Title']")).getAttribute("title");
		System.out.println("Case Title :- " + caseTitle);
		maps.put("casetitle", caseTitle);
		System.out.println("cas Title is - " + caseTitle);
	}
	
	 @Then("user search CaseTitle")
	 public void searchCaseTitle()
	 {
		 String name = maps.get("casetitle");
		 System.out.println(name);
		 try {
				Thread.sleep(3000);
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
				contact.objsearchField.sendKeys(name, Keys.ENTER);
				Wait.untilPageLoadComplete(driver);
				Thread.sleep(3000);
				List<WebElement> li= driver.findElements(By.xpath("//*[text()='"+name+"']"));
				//assertion.CheckAssertionTrue(!li.isEmpty(), name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 @Then("user validate if no records are displayed")
	 public void user_validate_if_no_records_are_displayed() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 String Expected = driver.findElement(By.xpath("//span[text()='No data available']")).getAttribute("outerText");
		 System.out.println(Expected);
		 assertion.CheckAssertionTrue(Expected.contains("No data available"), "No data available");
		
	 }
	 
	 @Then("user validate {string} view")
	 public void user_validate_view(String s)
	 {
		 String name = maps.get("casetitle");
		 System.out.println(name);
		 
		 String expected = driver.findElement(By.xpath("//span[text()='"+name+"']")).getAttribute("textContent");
		 
		 assertion.CheckAssertionTrue(name.contains(expected), name);
		 
		
	 }

}
