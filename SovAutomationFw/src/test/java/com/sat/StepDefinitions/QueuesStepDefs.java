package com.sat.StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.sat.Pages.ContactForm;
import com.sat.Pages.CustomerPage;
import com.sat.Pages.GenericCases;
import com.sat.Pages.Queue;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class QueuesStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	GenericCases genericCases = new GenericCases(driver);
	public ContactForm contact = new ContactForm(driver);
	private CustomerPage accountpage = new CustomerPage(driver);
	Testutil testUtil = new Testutil(driver);
	Map<String, String> userdetails = new HashMap<String, String>();

	WebDriverWait w = new WebDriverWait(driver, 5);
	Actions actions = new Actions(driver);
	HashMap<Integer, String> itemsListPickedFromQueue = new HashMap<>();
	Queue queue = new Queue(driver);
	Properties prop = new Properties();
	String workingDir = System.getProperty("user.dir");

	Assertions assertion = new Assertions(driver);

	String TotalQueuesPicked;
	String caseNumber;

	@Then("user Open {string} and {string}")
	public void user_Open(String string, String string2) throws Exception {

		queue.clickViewsQueues(queue.objMyViews);
		queue.clickViewsQueues(queue.objSelectAllItemsQueue);
		queue.clickViewsQueues(queue.objSelectQueueFilter);
		queue.clickViewsQueues(queue.objSelectAllQueueinFilter);
		assertion.CheckAssertion("All Queues", queue.objInputSelectQueueFilter.getAttribute("title"));
	}

	@Then("user select a queue with multiple items")
	public void user_select_a_queue_with_multiple_items() throws Exception {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			System.out.println(workingDir);
			Properties QueueName = Queue
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Queues.properties");
			System.out.println("QueueName: " + QueueName.getProperty("QueueName"));
			queue.clickOnQueue(QueueName.getProperty("QueueName"));
		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}
	}

	@Then("user select the queue from the QUEUE ITEMS section")
	public void user_select_the_queue_from_the_QUEUE_ITEMS_section() throws Exception {

		actions.click(driver.findElement(
				By.xpath("//section[@data-id='QueueItems']//input[@aria-label='Select or deselect the row']"))).build()
				.perform();
		// testUtil.jsclick(, driver);

		// driver.findElement(By.xpath("//span[contains(text(),'Repairs and
		// Maintenance')]")).click();
		// queue.clickOnQueue("");
	}
	
	@Then("user validate the Queue Item Details {string}")
	public void user_validate_the_Queue_Item_Details(String string)
	{
		try {
			Thread.sleep(3000);
			System.out.println("Expected = " + string);
			System.out.println("Actual = " + driver.findElement(
					By.xpath("(//div[@data-id='form-header']//a)[3]")).getAttribute("textContent"));
			assertion.CheckAssertionTrue(
			driver.findElement(
					By.xpath("(//div[@data-id='form-header']//a)[3]")).getAttribute("textContent").contains(string),string);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	 @Then("user validate the Queue is not set as {string}")
		public void user_validate_the_Queue_isnot_set(String string) throws IOException
		{
		 String exp =driver.findElement(
					By.xpath("(//div[@data-id='form-header']//a)[3]")).getAttribute("textContent");
			
		 assertion.CheckAssertionFalse(!exp.contains(string), string);
		}

	@Then("user Select multiple items")
	public void user_Select_multiple_items() throws Exception {
		queue.clickViewsQueues(queue.objSelectallQueues);
	}

	@Then("user click {} on the top ribbon")
	public void user_click_pick_in_ribbon(String topRibbonele) throws Exception {
		Thread.sleep(1000);
		queue.clickViewsQueues(queue.objMoreCommandsforQueueItem);
		Thread.sleep(1000);
		queue.clickViewsQueues(queue.objPick);
	}

	@Then("user click on Pick in new window")
	public void user_click_on_Pick_in_new_window() throws Exception {
		queue.clickViewsQueues(queue.objButtonPick);
	}

	@Then("user Validate that user name is showing in Worked By column")
	public void user_Validate_that_user_name_is_showing_in_Worked_By_column() throws Exception {
		try {
			Properties UserName = Queue
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Queues.properties");
			System.out.println("UserName: " + UserName.getProperty("UserName"));

			itemsListPickedFromQueue = queue.readWorkedbyfield(UserName.getProperty("UserName"));
		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}
	}

	@Then("user Validate that user name is showing in Worked By column for localities")
	public void user_Validate_that_user_name_is_showing_in_Worked_By_column_localities() throws Exception {
		try {
			System.out.println(System.getProperty("user.dir"));
			testUtil.jsclick(driver.findElement(By.xpath("//button[contains(@aria-label,'Account manager')]")), driver);
			String userName = driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']"))
					.getAttribute("textContent");

			System.out.println(userName);
			userdetails.put("userName", userName);
			actions.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//*[@row-index='0']//div[@aria-colindex='4']"))
					.getAttribute("textContent"));
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//*[@row-index='0']//div[@aria-colindex='4']"))
					.getAttribute("textContent").contains(userName), userName);

		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}
	}

	@Then("user change the selection from {string} to {string}")
	public void user_change_the_selection_from_to(String string, String string2) throws Exception {
		queue.clickViewsQueues(queue.objGoBack);
		queue.clickViewsQueues(queue.objMyViews);
		queue.clickViewsQueues(queue.objItemsIamworkingon);
	}

	@Then("user verifies if items picked in this list are visible")
	public void user_verifies_if_items_picked_in_this_queue_are_visible() throws Exception {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(2000);
			TotalQueuesPicked = queue.objPickedQueueItemsRows.getAttribute("childElementCount");
			System.out.println(TotalQueuesPicked);
			System.out.println("Size of map is:- " + itemsListPickedFromQueue.size());
			for (int i = 2; i <= itemsListPickedFromQueue.size() + 1; i++) {
				Wait.untilPageLoadComplete(driver);
				Thread.sleep(3000);
				System.out.println(i);
				System.out.println(itemsListPickedFromQueue.get(i) + "="
						+ driver.findElement(By.xpath(
								"//div[@data-id='grid-container']//div[@aria-RowIndex='" + i + "']//div[@aria-colindex='2']"))
								.getAttribute("textContent"));

				assertion.CheckAssertion(itemsListPickedFromQueue.get(i),
						driver.findElement(By.xpath(
								"//div[@data-id='grid-container']//div[@aria-RowIndex='" + i + "']//div[@aria-colindex='2']"))
								.getAttribute("textContent"));

				// AssertJUnit.assertEquals(itemsListPickedFromQueue.get(i),
				// driver.findElement(By.xpath(
				// "//div[@ref='eContainer']//div[@aria-RowIndex='" + i +
				// "']//div[@aria-colindex='2']"))
				// .getAttribute("textContent"));

			}
		} catch (Exception e) {
			System.out.println(e);
			// ExtentCucumberAdapter.addTestStepLog(e);
		}
	}

	@Then("user select one of picked items")
	public void user_select_one_of_picked_items() throws Exception {
		queue.clickViewsQueues(queue.objSelectPickedItem);
	}

	@Then("user will click {string}")
	public void user_will_click(String string) throws Exception {
		queue.clickViewsQueues(queue.objReleaseButton);
		queue.clickViewsQueues(queue.objReleaseConfirmButton);
	}

	@Then("user verifies released item is removed from {string}")
	public void user_verifies_released_item_is_removed_from(String string) throws Exception {

		// try {
		Thread.sleep(5000);
		String TotalQueuesPickedAfterRelease = queue.objPickedQueueItemsRows.getAttribute("childElementCount");
		System.out.println(Integer.parseInt(TotalQueuesPickedAfterRelease));
		System.out.println(Integer.parseInt(TotalQueuesPicked) - 1);
		Thread.sleep(2000);
		assertion.CheckAssertion(Integer.parseInt(TotalQueuesPickedAfterRelease),
				Integer.parseInt(TotalQueuesPicked) - 1);
		// } catch (Exception e) {
		// System.out.println(e);
		// //ExtentCucumberAdapter.getCurrentStep().info(e);
		// }

	}

	@Then("user verifies that name has been removed from the {string} column in its original queue{string}")
	public void user_verifies_that_name_has_been_removed_from_the_column_in_its_original_queue(String string,
			String name) throws Exception {

		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='" + name + "']")).click();
			w.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']")));

			System.out.println("Worked By = " + queue.objOriginalQueueWorkedBy.getAttribute("textContent"));
			// AssertJUnit.assertEquals(queue.objOriginalQueueWorkedBy.getAttribute("textContent"),
			// "");
			assertion.CheckAssertion(queue.objOriginalQueueWorkedBy.getAttribute("textContent"), "");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	@Then("user open the item in the original queue")
	public void user_open_the_item_in_the_original_queue() throws Exception {
		try {
			String i = queue.objOriginalQueueItemsContainer.getAttribute("childElementCount");
			if (Integer.parseInt(i) == 0) {
			} else {
				queue.clickViewsQueues(queue.objOriginalQueueTitle);
			}
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("user updates the {string} field with contact {string}")
	public void user_updates_the_field_with_contact(String string, String string2) throws Exception {

		try {
			Wait.untilPageLoadComplete(driver);
			Boolean selectedValue = queue.objRegardingfield.getAttribute("innerText").isEmpty();

			String contactName = queue.objRegardingfield.getAttribute("innerText");
			System.out.println("Contact Name = " + contactName);
			System.out.println("Inner text = " + selectedValue);

			if (selectedValue == true) {
				Thread.sleep(2000);
				queue.objRegardingLookupfield.click();
				Wait.untilPageLoadComplete(driver);

				driver.findElement(By.xpath("//span[text()='" + string2 + "']")).click();
				Thread.sleep(2000);
			} else {
				Thread.sleep(2000);

				actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='" + contactName + "']"))).build()
						.perform();
				actions.click(
						driver.findElement(By.xpath("//button[contains(@aria-label, 'Delete " + contactName + "')]")))
						.build().perform();

				queue.objRegardingLookupfield.click();
				Wait.untilPageLoadComplete(driver);
				driver.findElement(By.xpath("//span[text()='" + string2 + "']")).click();

			}

			queue.objSave.click();
		} catch (Exception e) {
			System.out.println(e);
			//// ExtentCucumberAdapter.getCurrentStep().info(e);
		}

	}

	@Then("user verifies the item is in the contact timeline")
	public void user_verifies_the_item_is_in_the_contacts_timeline() throws Exception {

		Properties contactName1 = Queue
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Queues.properties");
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@aria-label='" + contactName1.getProperty("contactName") + "']"))
					.click();
			System.out.println("QueueName: " + contactName1.getProperty("contactName"));
			String conName = contactName1.getProperty("contactName");
			// WebElement contname = driver.findElement(
			// By.xpath("//li[@aria-label='Auto-post on " +
			// contactName1.getProperty("contactName") + "']"));
			System.out.println("Email trigger = " + driver
					.findElement(By
							.xpath("//li[@aria-label='Auto-post on " + contactName1.getProperty("contactName") + "']"))
					.isDisplayed());
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//li[@aria-label='Auto-post on " + conName + "']")), conName);

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Then("user navigate back to the Queue and Select item and remove from queue")
	public void user_navigate_back_to_the_Queue_and_Select_item_and_remove_from_queue() throws Exception {
		accountpage.entity("Queues");
		queue.objMyViews.click();
		queue.objItemsIamworkingon.click();
		Wait.untilPageLoadComplete(driver);
		queue.objInputSelectQueueFilter.click();
		queue.objSelectAllQueueinFilter.click();

		driver.findElement(By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='1']"))
				.click();

		driver.findElement(By.xpath("//span[text()='Remove']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Remove' and @data-id='confirmButton']")).click();
		Thread.sleep(2000);

		String TotalQueuesPickedBeforeRemoval = driver
				.findElement(By.xpath("//div[@ref='eContainer' and @role='rowgroup' ]"))
				.getAttribute("childElementCount");

		Thread.sleep(2500);
		String TotalQueuesPickedAfterRemove = driver
				.findElement(By.xpath("//div[@ref='eContainer' and @role='rowgroup' ]"))
				.getAttribute("childElementCount");
		System.out.println(TotalQueuesPickedAfterRemove);
		System.out.println(Integer.parseInt(TotalQueuesPickedBeforeRemoval) - 1);
		AssertJUnit.assertEquals(Integer.parseInt(TotalQueuesPickedAfterRemove),
				Integer.parseInt(TotalQueuesPickedBeforeRemoval) - 1);

	}

	@Then("user select template {string} and click next button")
	public void user_select_template_and_click_next_button(String template) {
		queue.selectTemplate(template);
	}

	@Then("user edit document")
	public void user_edit_document() {
		queue.editDocumet();
	}

	@Then("user attached updated document")
	public void user_attached_updated_document() {
	}

	@Then("user save note")
	public void user_save_note() {
		queue.saveNote();
	}

	@Then("user verify updated attached document")
	public void user_verify_updated_attached_document() {
	}

	@Then("user validate {string} Tabs are hidden")
	public void user_validate_Tabs_are_hidden(String string) {
		queue.fieldDisable(string);
	}

	@Then("user click on  Advanced Find option From the tool bar")
	public void user_click_on_Advanced_Find_option_From_the_tool_bar() {
		queue.clickOnAdvanceFind();
	}

	@Then("user Set Query Parameters in Advance Find and Click on Results button")
	public void user_Set_Query_Parameters_in_Advance_Find_and_Click_on_Results_button() throws InterruptedException {
		queue.setQueryParameters();
	}

	@Then("user click on link from list")
	public void user_click_on_link_from_list() {
		Wait.untilPageLoadComplete(driver, 2000);
		queue.clickOnLink();
	}

	@Then("user switch to next window")
	public void user_switch_to_next_window() {
		Wait.untilPageLoadComplete(driver, 2000);
		queue.switchToNewWindow();
	}

	@Then("user validate Case Story Multi select Option field is displayed under Case Story Tab")
	public void user_validate_Case_Story_Multi_select_Option_field_is_displayed_under_Case_Story_Tab() {
		queue.verifyCheckBox();
	}

	@Then("user validate {string} drop down list values")
	public void user_validate_drop_down_list_values(String string, DataTable dataTable) {
		queue.validateListValues(string, dataTable);

	}

	@Then("user validate Multiple options are selected in Case Story option field Under Case Story Tab")
	public void user_validate_Multiple_options_are_selected_in_Case_Story_option_field_Under_Case_Story_Tab() {
		// queue.selectMultipleOptions();
	}

	@Then("user select all Option and verify displayed with Top {int} options and remaining displayed Number Count")
	public void user_select_all_Option_and_verify_displayed_with_Top_options_and_remaining_displayed_Number_Count(
			Integer int1) {
		queue.verifyTopFiveOptions();
	}

	@Then("user click on the Number Count in Case Story Option field and Validate")
	public void user_click_on_the_Number_Count_in_Case_Story_Option_field_and_Validate() {
		queue.verifyNumberCount();
	}

	@And("user click on three dot for more connection")
	public void user_click_on_three_dot_for_more_connection() {
		Wait.untilPageLoadComplete(driver, 2000);
		queue.clickMoreConnection();
	}

	@Then("user select Case Story Option as {string}")
	public void user_select_Case_Story_Option_as(String value) throws InterruptedException {
		Wait.untilPageLoadComplete(driver, 500);
		actions.click(queue.caseStoryOptions).build().perform();
		Wait.untilPageLoadComplete(driver, 500);
		Thread.sleep(2000);
		testUtil.clickOn(driver, queue.caseStoryToggleMenu, 1);
		Thread.sleep(2000);
		// testUtil.clickOn(driver,
		// driver.findElement(By.xpath("//div[text()='"+value+"']")),1);
		// testUtil.clickOn(driver, queue.objAgreedActionsMenuItem, 1);
		Thread.sleep(2000);
	}

	@And("user click on {string} link")
	public void user_clicks_on_link(String contact) {
		Wait.untilPageLoadComplete(driver, 500);
		testUtil.clickOn(driver, driver.findElement(By.xpath("//div[@title='" + contact + "']")), 2);
		Wait.untilPageLoadComplete(driver, 500);
	}

//	 @Then("user verifies the Tool Tip of {string} flag")
//	    public void customer_verifies_the_Tool_Tip_of_flag_in_Tab(String string) {
//	        try {
//	        	caseNumber = queue.getCaseNumber(driver, queue.objCaseNumber);
//	            // if (string =="ASB") {
//	            System.out.println("*in side if : " + string);
//	            System.out.println("case Number is = " + caseNumber);
//	            // System.out.println("Tool tip is = " +
//	            // omptimization.objantisocialbehaviour.getAttribute("title"));
//	            Thread.sleep(2000);
//	            assertion.CheckAssertionTrue(queue.objantisocialbehaviour.getAttribute("title").contains(caseNumber));
//	            driver.switchTo().defaultContent();
//	            // }
//	        } catch (InterruptedException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	        }
//	    }
}
