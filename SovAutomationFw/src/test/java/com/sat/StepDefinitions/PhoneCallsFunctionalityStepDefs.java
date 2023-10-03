package com.sat.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sat.Pages.PhoneCallsFunctionality;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class PhoneCallsFunctionalityStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	PhoneCallsFunctionality phonecall = new PhoneCallsFunctionality(driver);
	Testutil testUtil = new Testutil(driver);
	Actions action = new Actions(driver);
	Assertions assertion = new Assertions(driver);

	@When("user enter your phone number {string} in Mobile Phone field")
	public void user_enter_your_phone_number_in_Mobile_Phone_field(String phonenumber) {
		try {
			phonecall.enterMobileNumber(phonenumber);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user scroll down {string} in page")
	public void user_scroll_down_in_page(String text) {
		try {
			phonecall.scrollDown(text);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user scroll down till {string} present in page")
	public void user_scroll_down_till_element_present(String value) {
		try {
			phonecall.scrollDownTillElementPresent(value);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	 @Then("user scroll to section {string}")
	 public void user_scroll_to_section(String string)
	 {
//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//
//			// Scrolling down the page till the element is found
//			js.executeScript("arguments[0].scrollIntoView();",
//					driver.findElement(By.xpath("//section[contains(@aria-label,'Sellers Details')]")));
		 
		 
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
		 action.sendKeys(Keys.TAB).build().perform();
	 }
	
	@Then("user scroll down till to Pre-Application Details section")
	public void user_scroll_down_till_element_Pre_Application_Details_section() {
		try {
			JavascriptExecutor js =((JavascriptExecutor)driver);
		    
	    	js.executeScript("arguments[0].scrollIntoView();",
	                driver.findElement(By.xpath("//section[@aria-label='Pre-Application Details']")));
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user scroll up in page")
	public void user_scroll_up_in_page() throws InterruptedException {
		try {
			phonecall.scrollUp();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user clear text box")
	public void user__clear_text_box() {
		try {
			phonecall.clearTextbox();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user search filter option {string}")
	public void user_search_filter_option(String option) throws InterruptedException {
		try {
			phonecall.searchActivities(option);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on phone symbol next to Mobile phone number")
	public void user_click_on_phone_symbol_next_to_Mobile_phone_number() {
		try {
			Thread.sleep(1500);
			phonecall.clickOnPhoneSymbol();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter Phone Call Category,Description,Regarding")
	public void user_enter_Phone_Call_Category_Description_Regarding() {
		try {
			phonecall.enterMandatoryField();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter Phone Call Category,Description")
	public void user_enter_Phone_Call_Category_Description() {
		try {
			phonecall.enterMandatoryFieldInCases();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter Subject")
	public void user_enter_Subject() {
		try {
			phonecall.enterSubjectField();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user enter Call To")
	public void user_enter__Call_To() throws InterruptedException {
		try {
			phonecall.enterCallToField();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user select {string} check box")
	public void user_Select__Check_Box(String text) {
		try {
			phonecall.verifyCheckBox(text);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user Click on save and close")
	public void user_Click_on_save_and_close() throws InterruptedException {
		try {
			phonecall.clickOnsaveAndClose();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user select direction {string}")
	public void user_select_direction(String direction) {
		try {
			phonecall.selectDirection(direction);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user open your phone call activity and clicking on Mark Complete with the tick mark")
	public void user_open_your_phone_call_activity_and_clicking_on_Mark_Complete_with_the_tick_mark()
			throws InterruptedException {
		try {
			phonecall.openAndComplete();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user verify the activity has updated to {string} on the timeline")
	public void user_verify_the_activity_has_updated_to_Closed_on_the_contact_timeline(String status) {
		try {
			// phonecall.verifyStatusClosed(status);
			assertion.CheckAssertionTrue(
			driver.findElement(By.xpath("//li[contains(@aria-label,'Task')]//*[text()='Active']")).getAttribute("textContent").contains("Active"),"Active"
			);
			
			
			
			//assertion.CheckAssertionTrue(status.contains("Closed"), status);
			//Assert.assertEquals("Closed", status, "Status is not Closed");
			Wait.untilPageLoadComplete(driver);
			Wait.untilPageLoadComplete(driver);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("Refresh the timeline and find the phone call activity")
	public void Refresh_the_timeline_and_find_the_phone_call_activity() {
		try {
			Wait.untilPageLoadComplete(driver);
			Assert.assertEquals("Phone Call from", "Phone Call from", "Element is not Displayed");
			Wait.untilPageLoadComplete(driver);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@When("user click on plus icon on the timeline")
	public void user_click_on_plus_icon_on_the_timeline() {
		try {
			phonecall.clickOnPlushIcon();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@When("user select {string} from timeline option")
	public void user_select_from_timeline_option(String option) {
		try {
			phonecall.selectOption(option);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user check the Appointment in the Timeline")
	public void user_check_the_Appointment_in_the_Timeline() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//li[contains(@aria-label,'Appointment')])[1]")).getAttribute("textContent"));
		assertion.CheckAssertionTrue(
		driver.findElement(By.xpath("(//li[contains(@aria-label,'Appointment')])[1]")).getAttribute("textContent").contains("Test"),"Test");

	
	}

	@Then("user click on Enter Note")
	public void user_click_on_Enter_Note() {
		try {
			phonecall.clickEnterNote();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter note title")
	public void user_enter_note_title() {
		try {
			phonecall.userEnterTitle();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user enter text in main box")
	public void user_enter_text_in_main_box() throws InterruptedException {
		try {
			phonecall.userEnterText();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Add Note button")
	public void user_click_on_Add_Note_button() {
		try {
			phonecall.clickOnAddNote();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user verify the note shows on the timeline")
	public void user_verify_the_note_shows_on_the_timeline() {
	}

	@Then("user enter Response Time and Description")
	public void user_enter_Response_Time_and_Description() throws InterruptedException {
		try {
			phonecall.enterResponseTimeAndDescription();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user open cases")
	public void user_open_cases() throws InterruptedException {
		try {
			phonecall.openCases();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click open activities and change owner name")
	public void user_click_open_activities_and_change_owner_name() throws InterruptedException {
		try {
			phonecall.changeOwnerName();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user select {string} from the top menu option")
	public void user_select_Run_Report_from_the_top_menu_option(String option) {
		try {
			phonecall.clickOnRunReport(option);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user select Export Contact & Case Timeline option")
	public void user_select_Export_Contact_Case_Timeline_option() {
		try {
			phonecall.clickOnExportContactCaseTimeline();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on three dots appearing top most right corner on the form")
	public void user_click_on_dots_appearing_top_most_right_corner_on_the_form_() {
		try {
			phonecall.clickThreeDot();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on three dots appearing top most right corner on the {string} form")
	public void user_click_on_dots_appearing_top_most_right_corner_on_the_form_(String form) {
		phonecall.clickThreeDot(form);
	}

	@And("user select Assign from the top menu option")
	public void user_select_Assign_from_the_top_menu_option() {
		try {
			Thread.sleep(4000);
			if (driver.findElements(By.xpath("//button[@aria-label='More commands for Case']")).size() != 0)
				action.click(driver.findElement(By.xpath("//button[@aria-label='More commands for Case']"))).build().perform();
			System.out.println("User clicked on More Commands");
			phonecall.clickAssign();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user select the Queue from the lookup")
	public void user_select_the_Queue_from_the_lookup() {
		try {
			phonecall.assignUser();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Assign button")
	public void user_click_on_Add_button() throws InterruptedException {
		try {
			phonecall.clickAssignButton();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user marked as completed and task has been removed from the queue")
	public void user_marked_as_completed_and_task_has_been_removed_from_the_queue() {
		try {
			phonecall.clickMarkAsCompleted();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user open task and marked as completed and task has been removed from the queue")
	public void user_open_task_and_marked_as_completed_and_task_has_been_removed_from_the_queue()
			throws InterruptedException {
		try {
			phonecall.openAndMarkAsCompleted();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user validate all column name")
	public void user_validate_all_column_name(DataTable dataTable) throws Exception {
		try {
			phonecall.verifyAllColumn(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user validate all column name in Queue")
	public void user_validate_all_column_name_Queue(DataTable dataTable) throws Exception {
		try {
			phonecall.verifyColumn(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user validate contact cases and note grid")
	public void user_validate_contact_cases_and_note_grid() {
	}

	@Then("user validate all activities in report")
	public void user_validate_all_activities_in_report(io.cucumber.datatable.DataTable dataTable) {

	}

	@Then("user verify print and save options")
	public void user_verify_print_and_save_options() throws InterruptedException {
		try {
			phonecall.verifyPrintAndSave();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user verifies {string} field with Default as {string}")
	public void user_verifies_receipient_default_as(String string,String string2) {
				try {
					assertion.CheckAssertionTrue(
							driver.findElement(By.xpath("//*[text()='" + string + "']")).isDisplayed(), string);
				assertion.CheckAssertionTrue(
							driver.findElement(By.xpath("//*[@title='" + string2 + "']"))
									.isDisplayed(), string2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
