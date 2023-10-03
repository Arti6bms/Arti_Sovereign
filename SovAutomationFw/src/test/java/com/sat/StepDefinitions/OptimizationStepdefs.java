package com.sat.StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.hc.core5.reactor.AbstractIOSessionPool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.CustomerPage;
import com.sat.Pages.GenericCases;
import com.sat.Pages.Optimization;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class OptimizationStepdefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	GenericCases genericCases = new GenericCases(driver);
	public ContactForm contact = new ContactForm(driver);
	private CustomerPage accountpage = new CustomerPage(driver);
	WebDriverWait w = new WebDriverWait(driver, 5);
	Actions actions = new Actions(driver);
	Assertions assertion = new Assertions(driver);
	Testutil testUtil = new Testutil(driver);
	Optimization omptimization = new Optimization(driver);
	private CasePage cases = new CasePage(driver);
	String caseNumber;

	@Then("user select active Case items")
	public void user_select_case_items() throws Exception {
		try {
			Thread.sleep(2000);

			String caseItem = caseNumber;
			Thread.sleep(4000);
			testUtil.sendKeys(driver,
					driver.findElement(By.xpath(
							"//input[@aria-label='Case Search this view' or @aria-label='Case Filter by keyword']")),
					10, caseItem);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[contains(@id,'quickFind')]")), 10);
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(driver.findElements(
					// By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']"))
					By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']")).size() != 0, caseItem);
			Thread.sleep(4000);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']")),
					0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user navigate to ASB Incident Grid and Click on New ASB Incident")
	public void click_on_New_ASB_Incident_Button() {

		try {
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objMoreCommandsforASBIncident, 2);
			// driver.findElement(By.xpath("//button[@aria-label='More commands for ASB
			// Incident']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(@title,'Add New ASB Incident')]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate the below fields are displayed on the {string}")
	public void user_validate_the_below_fields_are_displayed_on_the(DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println("size of the list is : " + actual.size());
		try {
			for (int i = 0; i <= actual.size() - 1; i++) {
				Thread.sleep(1000);
				System.out.println("for iteration '" + i + "'value is : " + actual.get(i));
				// System.out.println(driver.findElement(By.xpath("//section[@aria-label='General']")).getAttribute("outerText"));
				System.out.println(((driver.findElement(By.xpath("//section[@aria-label='General']"))
						.getAttribute("textContent").split(":"))[i] + "==" + actual.get(i)));
				Thread.sleep(1000);
				assertion
						.CheckAssertionTrue(
								(driver.findElement(By.xpath("//section[@aria-label='General']"))
										.getAttribute("textContent").split(":"))[i].contains(actual.get(i)),
								actual.get(i));
			}

		} catch (Exception e) {
		}
	}

	@Then("user enter value in {string} text field")
	public void user_enter_value_text_field(String fieldName) {
		testUtil.sendKeys(driver, omptimization.objName, 1, "Testing_1");
	}

	@Then("user fills the Triage Assessment Questions")
	public void user_fills_the_Triage_Assessment_Questions() {
		try {
			System.out.println("user fills the Triage Assessment Questions");
			testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
			testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
			testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "01/06/2022");
			testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening, "Daily");
			testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
			testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "No");
			testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
			testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "Yes");
			testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
			testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
			// testUtil.sendKeys(driver, omptimization.objAgreedActions, 2, "Select all");
			// testUtil.clickOn(driver, omptimization.objAgreedActions, 1);
			Thread.sleep(2000);
			actions.click(omptimization.objAgreedActions).build().perform();
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objAgreedActionsMenu, 5);
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER);
			testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "Yes");
			testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "Yes");
			testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "No");
			actions.click().build().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user fills the Triage Assessment Questions for score 33")
	public void user_fills_the_Triage_Assessment_Questions_33() {
		try {
			System.out.println("user fills the Triage Assessment Questions");
			testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
			testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
			testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "01/06/2022");
			testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening, "Daily");
			testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
			testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "Yes");
			actions.click(omptimization.objSelectCharacteristic).build().perform();
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objAgreedActionsMenu, 5);
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objSelectall, 5);
			Thread.sleep(2000);
			// actions.sendKeys(Keys.TAB);
			actions.sendKeys(Keys.ENTER);
			testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
			testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "Yes");
			testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "Yes");

			// testUtil.selectByVisibleText(driver,
			// omptimization.objWhatHaveYouTriedBeforeCallingUs, "Contacted Police");
			actions.click(omptimization.objWhatHaveYouTriedBeforeCallingUs).build().perform();
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.obj10ToggleMenu, 5);
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.obj10, 5);
			actions.sendKeys(Keys.ENTER);
			actions.sendKeys(Keys.ESCAPE);
			actions.click(omptimization.objWhatDoYouThinkWillSortTheProblem).build().perform();
			testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
			// testUtil.sendKeys(driver, omptimization.objAgreedActions, 2, "Select all");
			// testUtil.clickOn(driver, omptimization.objAgreedActions, 1);
			// =====================
			Thread.sleep(2000);
			actions.click(omptimization.objAgreedActions).build().perform();
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objAgreedActionsToggleMenu, 5);
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objSelectall, 5);
			Thread.sleep(2000);
//			testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
//			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER);
			testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "Yes");
			Thread.sleep(2000);
			testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "Yes");
			Thread.sleep(2000);
			testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "Yes");
			Thread.sleep(2000);
			actions.click(omptimization.objDoestheCustomerhaveadditionalneeds).build().perform();
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.obj15aToggleMenu, 5);
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.obj15a, 5);
			actions.sendKeys(Keys.ENTER);
			// testUtil.selectByVisibleText(driver,
			// omptimization.objDoestheCustomerhaveadditionalneeds, "GP Support");
			// actions.click().build().perform();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		@Then("user fills the Triage Assessment Questions for score 10")
		public void user_fills_the_Triage_Assessment_Questions_Low_Priority() {
			try {
				System.out.println("user fills the Triage Assessment Questions");
				testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
				testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
				testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "05/04/2023");
				testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening,"Most Weeks");
				testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
				testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "No");
				actions.sendKeys(Keys.ENTER);
				testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
				testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "No");
				testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
				actions.sendKeys(Keys.ENTER);
				actions.click(omptimization.objWhatDoYouThinkWillSortTheProblem).build().perform();
				testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
				Thread.sleep(2000);
				actions.click(omptimization.objAgreedActions).build().perform();
				Thread.sleep(2000);
				testUtil.clickOn(driver, omptimization.objAgreedActionsToggleMenu, 5);
				Thread.sleep(2000);
				testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
				Thread.sleep(2000);
				actions.sendKeys(Keys.ENTER);
				actions.sendKeys(Keys.ESCAPE);
				testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "No");
				Thread.sleep(2000);
				testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "No");
				Thread.sleep(2000);
				testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "No");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			@Then("user fills the Triage Assessment Questions for score <7")
			public void user_fills_the_Triage_Assessment_Questions_Not_ASB_Signpost_Priority() {
				try {
					System.out.println("user fills the Triage Assessment Questions");
					testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
					testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
					testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "05/04/2023");
					testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening,"Only Once");
					testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
					testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "No");
					actions.sendKeys(Keys.ENTER);
					testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
					testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "No");
					testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
					actions.sendKeys(Keys.ENTER);
					actions.click(omptimization.objWhatDoYouThinkWillSortTheProblem).build().perform();
					testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
					Thread.sleep(2000);
					actions.click(omptimization.objAgreedActions).build().perform();
					Thread.sleep(2000);
					testUtil.clickOn(driver, omptimization.objAgreedActionsToggleMenu, 5);
					Thread.sleep(2000);
					testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER);
					actions.sendKeys(Keys.ESCAPE);
					testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "No");
					Thread.sleep(2000);
					testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "No");
					Thread.sleep(2000);
					testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "No");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }

			@Then("user fills the Triage Assessment Questions for score >10")
			public void user_fills_the_Triage_Assessment_Questions_Medium_Priority() {
				try {
					System.out.println("user fills the Triage Assessment Questions");
					testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
					testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
					testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "05/04/2023");
					testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening,"Most Days");
					testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
					testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "No");
					actions.sendKeys(Keys.ENTER);
					testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
					testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "No");
					testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
					actions.sendKeys(Keys.ENTER);
					actions.click(omptimization.objWhatDoYouThinkWillSortTheProblem).build().perform();
					testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
					Thread.sleep(2000);
					actions.click(omptimization.objAgreedActions).build().perform();
					Thread.sleep(2000);
					testUtil.clickOn(driver, omptimization.objAgreedActionsToggleMenu, 5);
					Thread.sleep(2000);
					testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
					Thread.sleep(2000);
					actions.sendKeys(Keys.ENTER);
					actions.sendKeys(Keys.ESCAPE);
					testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "No");
					Thread.sleep(2000);
					testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "No");
					Thread.sleep(2000);
					testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "No");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
			
	@Then("user clicks Triage Assessment on BPF")
	public void user_clicks_Triage_Assessment_on_BPF() {
		try {
			testUtil.clickOn(driver, omptimization.objBPFTriageAssessment, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks Action Plan on BPF")
	public void user_clicks_Action_Plan_on_BPF() {
		testUtil.clickOn(driver, omptimization.objBPFActionPlan, 10);
	}

	@Then("user click on More commands for Case button")
	public void user_click_on_button() {
		try {
			testUtil.clickOn(driver, omptimization.objMorecommandsforCase, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks Next Stage in BPF")
	public void user_clicks_Next_Stage_in_Triage_Assessment_on_BPF() {
		try {
			Thread.sleep(2000);
			testUtil.clickOn(driver, omptimization.objBPFNextStage, 10);
			Thread.sleep(2000);
			// actions.click().build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user navigate to ASB Incident Grid and enter the details in ASB Incident form and click on save and close button")
	public void user_enter_the_details_in_ASB_Incident_and_click_on_save_and_close_button(DataTable datatable)
			throws Exception {
		List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
		List<List<String>> actual = datatable.cells();
		System.out.println(actual.size());
		try {

			for (int j = 0; j < actual.size() - 1; j++) {
				System.out.println("incident created for :: " + j);
				String Name = data.get(j).get("Name");
				System.out.println("Name is : " + Name);
				Thread.sleep(2000);
				String Regarding = data.get(j).get("Regarding");
				System.out.println("Regarding is : " + Regarding);

				// actions.moveToElement(omptimization.objASBIncident).build().perform();
				// Thread.sleep(2000);
				actions.moveToElement(omptimization.objMoreCommandsforASBIncident).build().perform();
				Thread.sleep(2000);
				testUtil.clickOn(driver, omptimization.objMoreCommandsforASBIncident, 5);
				// Thread.sleep(2000);

				testUtil.clickOn(driver, omptimization.objAddNewASBIncident, 8);
				// Thread.sleep(2000);

				testUtil.sendKeys(driver, omptimization.objName, 5, data.get(j).get("Name"));
				testUtil.sendKeys(driver, omptimization.objName, 5, data.get(j).get("Name"));
				// Thread.sleep(2000);
				cases.fillDetails("Regarding", data.get(j).get("Regarding"));
				Thread.sleep(2000);
				contact.description();
				contact.clickOnSaveAndClose();

			}

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurered");
		}

	}

	@Then("user validate more than one ASB Incident can be added to the Grid")
	public void user_validate_more_than_one_ASB_Incident_can_be_added_to_the_Grid() throws Exception {

		try {
			Thread.sleep(3000);
			System.out.println(
					"rows in asb are : " + omptimization.objASBIncidentRowCount.getAttribute("childElementCount"));

			assertion.CheckAssertion(Integer.toString(2),
					omptimization.objASBIncidentRowCount.getAttribute("childElementCount"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate Active and Inactive Records are Displayed in ASB Incident grid")
	public void user_validate_Active_and_Inactive_Records_are_Displayed_in_ASB_Incident_grid() {

		try {
			testUtil.clickOn(driver, omptimization.objASBIncidentFirstNameLink, 8);
			driver.findElement(By.xpath("//span[text()='Max']")).click();
			testUtil.clickOn(driver, omptimization.objButtonDeactivate, 3);
			testUtil.clickOn(driver, omptimization.objdialogButtonDeactivate, 3);
			testUtil.clickOn(driver, omptimization.objBackButton, 3);
			System.out.println(
					"rows in asb are : " + omptimization.objASBIncidentRowCount.getAttribute("childElementCount"));

			assertion.CheckAssertion(Integer.toString(2),
					omptimization.objASBIncidentRowCount.getAttribute("childElementCount"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate Active and Inactive Records are Displayed in Action Plan grid")
	public void user_validate_Active_and_Inactive_Records_are_Displayed_in_Action_Plan_grid() throws Exception {
		try {
			Thread.sleep(5000);
			System.out.println("Current step is : " + Allure.getLifecycle().getCurrentTestCaseOrStep());
			testUtil.clickOn(driver, omptimization.objActionFirstNameLink, 10);
			Thread.sleep(5000);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Action2']")), 10);
			Thread.sleep(5000);
			testUtil.clickOn(driver, omptimization.objButtonMarkComplete, 10);
			Thread.sleep(5000);
			// testUtil.clickOn(driver, omptimization.objdialogButtonDeactivate, 3);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", omptimization.objBackButton);
			Thread.sleep(2000);

			// driver.findElement(By.xpath("//button[@title='Go back']")).click();

			driver.findElement(By.xpath("//li[@aria-label='Action Plan']")).click();

			Thread.sleep(5000);

			// testUtil.clickOn(driver, omptimization.objBackButton, 10);
			System.out.println(
					"rows in Action grid are : " + omptimization.objActionRowCount.getAttribute("childElementCount"));

			assertion.CheckAssertion(Integer.toString(2),
					omptimization.objActionRowCount.getAttribute("childElementCount"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate Records are displayed from Newest to Oldest order in Action Plan grid of Case")
	public void user_validate_Records_are_displayed_from_Newest_to_Oldest_order_in_Action_Plan_grid_of_Case() {
		try {
			assertion.CheckAssertion("Action2", omptimization.objActionFirstNameLink.getAttribute("outerText"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks on Back button")
	public void user_clicks_on_Back_button() {
		try {
			Thread.sleep(4000);
			testUtil.clickOn(driver, omptimization.objBackButton, 5);
			if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
				testUtil.clickOn(driver,
						driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")), 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then ("user click on discard changes")
	public void discard_changes_click()
	{
		if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
		{
		testUtil.clickOn(driver,
				driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")), 10);
		}
}


	@Then("user navigate to Action Grid and enter the details in Action Plan form and click on save and verifies description and close button")
	public void user_navigate_to_Action_Grid_and_enter_the_details_in_Action_Plan_form_and_click_on_save_and_close_button(
			DataTable datatable) {
		List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
		List<List<String>> actual = datatable.cells();
		System.out.println(actual.size());
		try {

			for (int j = 0; j < actual.size() - 1; j++) {
				String Action = data.get(j).get("Action");
				System.out.println("Action is : " + Action);

				Thread.sleep(3000);
				actions.moveToElement(omptimization.objButtonNewAction).build().perform();
				testUtil.clickOn(driver, omptimization.objButtonNewAction, 3);
				Thread.sleep(1000);
				omptimization.objAction.sendKeys(Keys.CONTROL + "A");
				Thread.sleep(3000);
				testUtil.sendKeys(driver, omptimization.objAction, 3, data.get(j).get("Action"));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys(Keys.CONTROL + "A");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys(
						"1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
				Thread.sleep(1000);
				contact.clickOnSave();
				assertion.CheckAssertion("2500", driver.findElement(By.xpath("//textarea[@aria-label='Description']"))
						.getAttribute("textLength"));
				testUtil.clickOn(driver, omptimization.objBackButton, 3);
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurered");
		}

	}

	@Then("user validate more than one Action can be added to the Grid")
	public void user_validate_more_than_one_Action_can_be_added_to_the_Grid() {
		try {
			System.out
					.println("rows in asb are : " + omptimization.objActionRowCount.getAttribute("childElementCount"));

			assertion.CheckAssertion(Integer.toString(2),
					omptimization.objActionRowCount.getAttribute("childElementCount"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate the {string} section for below fields")
	public void user_validate_the_section_for_below_fields(String string, DataTable datatable) {
		// List<Map<String, String>> data = datatable.asMaps(String.class,
		// String.class);

		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		actions.moveToElement(driver.findElement(By.xpath("//*[@aria-label='" + string + "']"))).build()
				.perform();
		String expectedResult = omptimization.ValidateFieldExists(driver,
				driver.findElement(By.xpath("//*[@aria-label='" + string + "']")), 5);

		try {
			String listofvalues = genericCases.read_list_items(string);
			System.out.println("Size of the list = " + (actual.size() - 1));
			System.out.println("listofvalues = " + listofvalues);

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				Thread.sleep(3000);
				assertion.CheckAssertionTrue(listofvalues.contains(actual.get(j)), actual.get(j));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate the {string} grid for below fields")
	public void user_validate_the_grid_for_below_fields(String string, io.cucumber.datatable.DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {
			for (int j = 1; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				String expectedResult = omptimization.ValidateFieldExists(driver, driver.findElement(
						By.xpath("(//section[@aria-label='" + string + "']//*[@aria-rowindex='1'])[2]")), 5);
				assertion.CheckAssertionTrue(expectedResult.contains(actual.get(j)), actual.get(j));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user Navigate to Action Plan and Click on +New Action button")
	public void user_Navigate_to_Action_Plan_and_Click_on_New_Action_button() {
		try {
			actions.moveToElement(omptimization.objButtonNewAction).build().perform();
			testUtil.clickOn(driver, omptimization.objButtonNewAction, 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies Description field accept 2500 Characters on Action Plan")
	public void user_verifies_Description_field_accept_2500_Characters_on_Action_Plan() {
		try {
			driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys(
					"1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

			contact.clickOnSave();
			assertion.CheckAssertion("2500",
					driver.findElement(By.xpath("//textarea[@aria-label='Description']")).getAttribute("textLength"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user select {string} options in {string} field")
	public void user_select_options_in(String string, String string2) {
		try {
			actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'" + string2 + "')]"))).build()
					.perform();
			Thread.sleep(5000);
			testUtil.clickOn(driver,
					driver.findElement(
							By.xpath("//div[@aria-label='Contact Other Agencies']//button[@aria-label='Toggle menu']")),
					1);
			Thread.sleep(5000);
			String actual = driver.findElement(By.xpath("(//div[@class='msos-selection-container'])[1]"))
					.getAttribute("childElementCount");
			System.out.println(actual);
			testUtil.clickOn(driver, driver.findElement(By.xpath("(//div[text()='" + string + "'])[1]")), 1);
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{	
		e.printStackTrace();
		}
	}

	@Then("Validate the Action Plan Quick Create form for below fields")
	public void validate_the_Quick_Create_form_for_below_fields(io.cucumber.datatable.DataTable datatable)
			throws InterruptedException {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		Thread.sleep(2000);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@data-id='form-selector']")), 10);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='TenMan Actions']")), 10);

		try {
			for (int j = 0; j <= actual.size() - 1; j++) {
				Thread.sleep(2000);
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				String expectedResult = omptimization.ValidateFieldExists(driver, omptimization.objNewActionSection, 5);
				System.out.println("expectedResultContents = " + expectedResult);
				Thread.sleep(2000);
				assertion.CheckAssertionTrue(expectedResult.contains(actual.get(j)), actual.get(j));
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies the tool tip for {string}")
	public void user_verifies_the_tool_tip(String s) {
		try {
			String toolTipText = testUtil.getTooltip(driver, omptimization.objTelluswhatisgoingonQTooltip, 3);
			System.out.println("Tool tip is :: " + toolTipText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies the questions in {string} section")
	public void user_verifies_the_questions_in_section(String string, DataTable datatable) {

		try {
			List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
			List<List<String>> actual = datatable.cells();
			System.out.println(actual.size());
			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Q12')]"))).build().perform();
			List<WebElement> Questions = testUtil.getchildElements(driver,
					driver.findElement(By.xpath("//section[@id='tab_12_section_1_2']")), 3);
			for (int j = 0; j < actual.size() - 1; j++) {
				System.out.println("Question at :: " + j);
				String QName = data.get(j).get("Questions");
				System.out.println(QName);
				assertion.CheckAssertionTrue(Questions.get(0).getText().contains(data.get(j).get("Questions")),
						data.get(j).get("Questions"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("user verifies {string} section")
	public void user_verifies_section(String string, io.cucumber.datatable.DataTable datatable) {
		try {
			List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
			List<List<String>> actual = datatable.cells();
			System.out.println(actual.size());
			actions.sendKeys(Keys.TAB).build().perform();
			actions.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			Thread.sleep(1000);
			// actions.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Q12')]"))).build().perform();
			List<WebElement> Fields = testUtil.getchildElements(driver,
					driver.findElement(By.xpath("//section[@aria-label='Triage Assessment Score and Outcome']")), 3);
			System.out.println(Fields.get(0).getText());
			for (int j = 0; j < actual.size() - 1; j++) {
				System.out.println("Fields at :: " + j);
				String FieldName = data.get(j).get("FieldName");
				System.out.println(FieldName);
				assertion.CheckAssertionTrue(Fields.get(0).getText().contains(data.get(j).get("FieldName")),
						data.get(j).get("FieldName"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies {string}")
	public void user_verifies(String string) {
		try {
			testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "Yes");
			// driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
			// String exp =
			// driver.findElement(By.xpath("//div[@class='msos-selection-container']")).click()
			driver.findElement(By.xpath(
					"//div[@aria-controls='po_whathaveyoutriedbeforecallingus_i']//button[@aria-label='Toggle menu']"))
					.click();
			driver.findElement(By.xpath("//div[text()='None']")).click();
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//label[text()='If none, any reason why?']")).isDisplayed(), "");

			testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(
					driver.findElements(By.xpath("//label[text()='If none, any reason why?']")).isEmpty(), "");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user selects Triage Assessment Complete as {string}")
	public void user_selects_Triage_Assessment_Complete_as(String string) {
		try {
			testUtil.selectByVisibleText(driver, omptimization.objTriageAssessmentComplete, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user selects Action Plan Generated as {string}")
	public void user_selects_ActionPlanGenerated_as(String string) {
		try {
			Thread.sleep(2000);
			testUtil.selectByVisibleText(driver, omptimization.objActionPlanGenerated, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Then("user selects Case Story Generated as {string}")
	public void user_selects_CaseStoryGenerated_as(String string) {
		try {
			Thread.sleep(2000);
			testUtil.selectByVisibleText(driver, omptimization.objCaseStoryGenerated, string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user verifies the below sections are available on {string} tab")
	public void user_verifies_the_below_sections_are_available_on_tab(String string, DataTable datatable) {

	}

	@Then("user select {string} Option in {string} field and verifies All Selected Options are visible")
	public void user_select_Option_in(String string, String string2) {
		try {
			actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'" + string2 + "')]"))).build()
					.perform();
			Thread.sleep(5000);
			testUtil.clickOn(driver, driver.findElement(
					By.xpath("//div[@aria-label='Case Story Option']//button[@aria-label='Toggle menu']")), 1);
			Thread.sleep(5000);
			String actual = driver.findElement(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']"))
					.getAttribute("childElementCount");
			System.out.println(actual);
			testUtil.clickOn(driver, driver.findElement(By.xpath("(//div[text()='" + string + "'])[3]")), 1);
			Thread.sleep(2000);
			// actions.sendKeys(Keys.ESCAPE).build().perform();

			Thread.sleep(2000);
//			actions.moveToElement(driver.findElement(By.xpath("//div[@class='msos-selecteditems-toggle-container']")))
//					.build().perform();
			actions.sendKeys(Keys.ESCAPE).build().perform();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("(//button[contains(text(),'+')])[3]")).click();
			// actions.moveToElement(driver.findElement(By.xpath(
			// "//input[@id='po_casestoryoption_ledit')]"))).build().perform();
			System.out
					.println(driver.findElement(By.xpath("//ul[@aria-label ='Selected values for Case Story Option']"))
							.getAttribute("childElementCount"));
			String Expected = driver.findElement(By.xpath("//ul[@aria-label ='Selected values for Case Story Option']"))
					.getAttribute("childElementCount");

			assertion.CheckAssertion(actual, Expected);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user verifies ASB Case form Contain Stages as mentioned below")
	public void user_verifies_ASB_Case_form_Contain_Stages_as_mentioned_below(DataTable dataTable) {
		try {
			List<String> actual = dataTable.asList();
			System.out.println(actual.size());
			String Expectedstring = driver
					.findElement(By.xpath(
							"//div[@data-id='MscrmControls.Containers.ProcessBreadCrumb-processHeaderContainer']"))
					.getAttribute("innerText");
			System.out.println(Expectedstring);

			for (int i = 0; i <= actual.size() - 1; i++) {
				assertion.CheckAssertionTrue(Expectedstring.contains(actual.get(i)), actual.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user verifies {string} BPF Stage has {string} field with Default as No")
	public void user_verifies_Triage_Assessment_BPF_Stage_has_below_field_with_Default_as_No(String string,
			String string2) {
		try {
//			driver.findElement(
//					By.xpath("//ul[@aria-label='Business Process Flow']//li[contains(@aria-label,'" + string + "')]")).click();
			driver.findElement(
					By.xpath("//ul[@aria-label='Business Process Flow']//div[text()='" + string + "']")).click();
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//label[text()='" + string2 + "']")).isDisplayed(), string2);
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//div[@title='No' and contains(@data-id,'header_process_po')]"))
							.isDisplayed(),
					"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks on Customer field")
	public void user_clicks_on_Customer_field() {
		try {
			Thread.sleep(2000);
			caseNumber = omptimization.getCaseNumber(driver, omptimization.objCaseNumber);
			String s = omptimization.objCustomerField.getAttribute("textContent");
//			 testUtil.clickOn(driver,driver.findElement(By.xpath("//div[@title='"+s+"']//ancestor::span")),10);
			 driver.findElement(By.xpath("//div[@title='"+s+"']")).click();
	//		testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@aria-label='Jerrilee Shepherd']")), 10);
	//		Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies the {string} flag exists")
	public void customer_verifies_the_flag_in_Tab(String string) {
		try {
			Thread.sleep(5000);
			// Wait.untilPageLoadComplete(driver);
			// To wait for element visible
			// driver.navigate().refresh();
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
					Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.xpath("//iframe[contains(@id,'WebResource')]")));

			WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@id,'WebResource')]"));
			Thread.sleep(4000);
			driver.switchTo().frame(iframeElement);
			Thread.sleep(4000);
			if (string == "ASB") {
				System.out.println(omptimization.objalertsflagsASB.isDisplayed());
				assertion.CheckAssertionTrue(omptimization.objalertsflagsASB.isDisplayed(), "ASB Flag");
				Thread.sleep(4000);
			}
			if (string == "ASB Court Order") {
				System.out.println(omptimization.objalertsflagsASBCourtOrder.isDisplayed());
				assertion.CheckAssertionTrue(omptimization.objalertsflagsASBCourtOrder.isDisplayed(),
						"ASB Court Order Flag");
				Thread.sleep(4000);
			}
			if (string == "Assisted Gardening") {
				System.out.println(omptimization.objAssistedGardening.isDisplayed());
				assertion.CheckAssertionTrue(omptimization.objAssistedGardening.isDisplayed(), "Assisted Gardening Flag");
				Thread.sleep(4000);
			}
			if (string == "HOP") {
//				System.out.println(omptimization.objHousingForOlderPeople.isDisplayed());
//				assertion.CheckAssertionTrue(omptimization.objHousingForOlderPeople.isDisplayed(), "HOP");
//				Thread.sleep(4000);
				WebElement flagImageElement = omptimization.objHousingForOlderPeople;
				String flagImageUrl = flagImageElement.getAttribute("src");
				System.out.println("Flag image URL: " + flagImageUrl);
				Assert.assertTrue(flagImageUrl.contains("po_HousingForOlderPeople"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user verifies the Tool Tip of {string} flag")
	public void customer_verifies_the_Tool_Tip_of_flag_in_Tab(String string) {
		try {
			// if (string =="ASB") {
			System.out.println("verifying the tool tip : " + string);
			System.out.println("Verifying the case Number is = " + caseNumber);
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			if (string == "ASB") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objantisocialbehaviour);
				Thread.sleep(2000);
				String s = omptimization.objantisocialbehaviour.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(s.contains(caseNumber), caseNumber);
			}

			if (string == "ASB Court Order") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objASBCourtOrder);
				Thread.sleep(2000);
				String s = omptimization.objASBCourtOrder.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(s.contains(caseNumber), caseNumber);
			}
			if (string == "Assisted Gardening") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objAssistedGardening);
				Thread.sleep(2000);
				String s = omptimization.objAssistedGardening.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(s.contains(caseNumber), caseNumber);
			}
			if (string == "HOP") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objHousingForOlderPeople);
				Thread.sleep(2000);
				String s = omptimization.objHousingForOlderPeople.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(s.contains(caseNumber), caseNumber);
			}
			driver.switchTo().defaultContent();
			// }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies the Tool Tip of {string} flag does not exist")
	public void customer_verifies_the_Tool_Tip_of_flag_in_Tab_doesnotexist(String string) {
		try {
			// if (string =="ASB") {
			System.out.println("verifying the tool tip : " + string);
			System.out.println("Verifying the case Number is = " + caseNumber);
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			if (string == "ASB") {

				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objantisocialbehaviour);
				Thread.sleep(2000);
				String s = omptimization.objantisocialbehaviour.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(!s.contains(caseNumber), caseNumber);
			}

			if (string == "ASB Court Order") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objASBCourtOrder);
				Thread.sleep(2000);
				String s = omptimization.objASBCourtOrder.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(!s.contains(caseNumber), caseNumber);
			}
			if (string == "Assited Gardening") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objAssistedGardening);
				Thread.sleep(2000);
				String s = omptimization.objAssistedGardening.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(!s.contains(caseNumber), caseNumber);
			}
			if (string == "HOP") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objHousingForOlderPeople);
				Thread.sleep(2000);
				String s = omptimization.objHousingForOlderPeople.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(!s.contains(caseNumber), caseNumber);
			}
			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies the Tool Tip of {string} flag after case is resolved")
	public void customer_verifies_the_Tool_Tip_of_flag_in_Tab_safter_case_is_resolved(String string)
			throws InterruptedException {
		// if (string =="ASB") {
		Thread.sleep(5000);
		System.out.println("Verifying tool tip after case is resolved for  : " + string);
		System.out.println("case Number is = " + caseNumber);
		driver.navigate().refresh();
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@id,'WebResource')]"));
		Thread.sleep(4000);
		driver.switchTo().frame(iframeElement);
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", omptimization.objantisocialbehaviour);
		Thread.sleep(7000);
		String s = omptimization.objantisocialbehaviour.getAttribute("title");
		System.out.println(s);

		// System.out.println("Tool tip is = " +
		// omptimization.objantisocialbehaviour.getAttribute("title"));
		// div[@id='antisocialbehaviour']//parent::td
		System.out.println(" doesnot contain value : "
				+ !omptimization.objantisocialbehaviour.getAttribute("title").contains(caseNumber));
		assertion.CheckAssertionFalse(!omptimization.objantisocialbehaviour.getAttribute("title").contains(caseNumber),
				caseNumber);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);

		// }
	}
	
	@Then("user verifies the {string} flag does not exist")
	public void user_verifies_the_flag_does_not_exist(String string) {
		try {
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
					Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions
//					.presenceOfAllElementsLocatedBy(By.xpath("//iframe[contains(@id,'WebResource')]")));

//			WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@id,'WebResource')]"));
	//		driver.switchTo().frame(iframeElement);
			Thread.sleep(4000);
			if (string == "Assited Gardening") {
				// Scrolling down the page till the element is found
				js.executeScript("arguments[0].scrollIntoView();", omptimization.objAssistedGardening);
				Thread.sleep(2000);
				String s = omptimization.objAssistedGardening.getAttribute("title");
				System.out.println(s);
				assertion.CheckAssertionTrue(!omptimization.objAssistedGardening.isDisplayed(), "Assisted Gardening Flag");
			}
			if (string == "HOP") {
				// Scrolling down the page till the element is found
//				js.executeScript("arguments[0].scrollIntoView();", omptimization.objHousingForOlderPeople);
//				Thread.sleep(2000);
//				String s = omptimization.objHousingForOlderPeople.getAttribute("title");
//				System.out.println(s);
//				assertion.CheckAssertionTrue(!omptimization.objHousingForOlderPeople.isDisplayed(), "HOP Flag");
				WebElement flagImageElement = omptimization.objHousingForOlderPeople;
				String flagImageUrl = flagImageElement.getAttribute("src");
				System.out.println("Flag image URL: " + flagImageUrl);

				Assert.assertTrue(flagImageUrl.contains("po_HousingForOlderPeople"));
			}
			driver.switchTo().defaultContent();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	@Then("user clicks on Account field")
	public void user_clicks_on_Account_field() {
		try {

			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			// actions.moveToElement(omptimization.objAccount).build().perform();
			// actions.click(omptimization.objAccountField).build().perform();
			testUtil.clickOn(driver, omptimization.objAccountField, 10);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user clicks on HOUSEHOLD GROUP CONTACT")
	public void user_clicks_on_HOUSEHOLD_GROUP_CONTACT() {
		try {
			testUtil.clickOn(driver, driver.findElement(By.xpath("//h2[text()='HOUSEHOLD GROUP CONTACTS']")), 10);
			Thread.sleep(2000);

			String exp = driver
					.findElement(
							By.xpath("(//section[@aria-label='HOUSEHOLD GROUP CONTACTS']//*[@aria-colindex='2'])[3]"))
					.getAttribute("textContent");

			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='" + exp + "']")), 10);
			// testUtil.clickOn(driver,
			// driver.findElement(By.xpath("(//section[@aria-label='HOUSEHOLD GROUP
			// CONTACTS']//*[@aria-colindex='2'])[3]")), 10);
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
				testUtil.clickOn(driver,
						driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")), 10);
			actions.doubleClick().build().perform();
			Thread.sleep(2000);
			driver.navigate().refresh();
			// actions.sendKeys(Keys.CONTROL+"F5");
			// driver.navigate().refresh();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Then("user click on {string} button")
//	public void user_click_on_resolve_button(String string) {
//		try {
//			Thread.sleep(2000);
//			System.out.println("user click on confirm button");
//			if (driver.findElement(By.xpath("//button[@aria-label='Confirm']")).isDisplayed()) {
//			testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Confirm']")), 5);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	@Then("user enters the details for {string} as {string}")
	public void user_enters_the_details_for_as(String string, String string2) {
		try {
			Thread.sleep(2000);
			System.out.println("user Enters :  " + string);

			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='" + string + "']")), 5,
					string2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user fills the Case Story options date fields")
	public void user_fills_the_Case_Story_options_date_fields() {
		try {
			System.out.println("user fills the Case Story options date fields");
			testUtil.sendKeys(driver, omptimization.objDateofABA, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateBandingAssessment, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofCBTReferral, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofCommittal, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofCommunity, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofCommunityWarning, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofTrigger, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofCriminal, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofDemotedTenancy, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofDogControl, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofEviction, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofFinalWarning, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofFullclosure, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofInitialvisit, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofInjunction, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofInternalTransfer, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofLivingfund, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofMediation, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofNoiseAbatement, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofNOSPserved, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofNTQserved, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofPartialClosure, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofPossession, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofPropertyAbandoned, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofReferral, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofReferraltoWomankind, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSection, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSignpostedDomesticAbuse, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSignpostedMental, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSignpostedPolice, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSignpostedSocialServices, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objSolicitorsLetter, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofTenancycaution, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofSPOgranted, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofTenantendedtenancy, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofUndertaking, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofWarning1st, 1, "19/04/2023");
			testUtil.sendKeys(driver, omptimization.objDateofWarning2nd, 1, "19/04/2023");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("user deselect {string} Option in {string} field and verifies All deselected Options are invisible")
	public void user_deselect_Option_in (String string, String string2) throws InterruptedException{
	try {
			actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'" + string2 + "')]"))).build()
					.perform();
			Thread.sleep(5000);
			testUtil.clickOn(driver, driver.findElement(
					By.xpath("//div[@aria-label='Case Story Option']//button[@aria-label='Toggle menu']")), 1);
			Thread.sleep(5000);
			String actual = driver.findElement(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']"))
					.getAttribute("childElementCount");
			System.out.println(actual);
			testUtil.clickOn(driver, driver.findElement(By.xpath("(//div[text()='" + string + "'])[3]")), 1);
			Thread.sleep(2000);
			actions.sendKeys(Keys.ESCAPE).build().perform();
	 	System.out.println("All case story option is deselected");
		List<WebElement> Datefield = driver
					.findElements(By.xpath("//input[@aria-label='Date of ABA']"));
			if (Datefield.size() > 0) {
				System.out.println("Date of ABA is present");
			} else {
				System.out.println("Date of ABA is not present");
			}
		}
	 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	@Then("user fills the Triage Assessment Questions for score 25")
	public void user_fills_the_Triage_Assessment_Questions_High_Priority() {
	try {
		System.out.println("user fills the Triage Assessment Questions");
		testUtil.sendKeys(driver, omptimization.objTellUsWhatisGoingOn, 1, "Answer1");
		testUtil.sendKeys(driver, omptimization.objWhosInvolved, 1, "Answer2");
		testUtil.sendKeys(driver, omptimization.objWhenDiditStart, 1, "05/04/2023");
		testUtil.selectByVisibleText(driver, omptimization.objHowOftenisThisHappening,"Most Days");
		testUtil.sendKeys(driver, omptimization.objCanYouThinkWhyThisisHappening, 1, "Answer5");
		testUtil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "Yes");
			actions.sendKeys(Keys.ENTER);
		testUtil.sendKeys(driver, omptimization.objWhoBeenAffectedbyThis, 1, "tester");
		testUtil.selectByVisibleText(driver, omptimization.objDoYouHaveAnySupportNeeds, "No");
		testUtil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "No");
		actions.sendKeys(Keys.ENTER);
		actions.click(omptimization.objWhatDoYouThinkWillSortTheProblem).build().perform();
		testUtil.sendKeys(driver, omptimization.objWhatDoYouThinkWillSortTheProblem, 1, "testing");
		Thread.sleep(2000);
		actions.click(omptimization.objAgreedActions).build().perform();
		Thread.sleep(2000);
		testUtil.clickOn(driver, omptimization.objAgreedActionsToggleMenu, 5);
		Thread.sleep(2000);
		testUtil.clickOn(driver, omptimization.objAgreedActionsMenuItem, 5);
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER);
		actions.sendKeys(Keys.ESCAPE);
		testUtil.selectByVisibleText(driver, omptimization.objSafeguardingReferraltobeConsidered, "No");
		Thread.sleep(2000);
		testUtil.selectByVisibleText(driver, omptimization.objDAReferralMade, "No");
		Thread.sleep(2000);
		testUtil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "No");
		Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
}

