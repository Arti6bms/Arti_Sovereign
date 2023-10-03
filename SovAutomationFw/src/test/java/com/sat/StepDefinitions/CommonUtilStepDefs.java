package com.sat.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import com.sat.Pages.CommonPages;
import com.sat.Pages.ContactForm;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonUtilStepDefs {

	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
	private CommonPages common = new CommonPages(driver);
	Testutil testUtil = new Testutil(driver);
	public static String output = "";
	private ContactForm contact = new ContactForm(driver);
	Actions action = new Actions(driver);
	Assertions assertion = new Assertions(driver);

//	public CommonUtilStepDefs(WebDriver driver) {
//		this.driver = driver;
//		}
	@Then("user selects {string} as {string}")
	public void user_selects_with(String label, String option) throws InterruptedException {
		common.selectLabelWithOption(label, option);
		Wait.untilPageLoadComplete(driver);
	}

	@When("user filters {string} as {string} with {string}")
	public void user_filters_with(String filter, String option, String filterOption) throws InterruptedException {
		user_selects_with(filter, option);
		common.selectFilterWithOption(filterOption);
	}
	
	@Then("user click on save button")
	public void user_click_on_save_button() throws InterruptedException {
		try {
			Thread.sleep(2500);
			contact.clickOnSave();	
			Thread.sleep(9000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on save and close button")
	public void user_click_on_save_and_close_button() throws InterruptedException {
		try {
			contact.clickOnSaveAndClose();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user click on saveclose button")
	public void user_click_on_saveclose_button() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//li[contains(@id,'queue')]//button[@aria-label='Save & Close']")).click();
			

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user click on Save and continue button")
	public void Save_and_continue_click() throws InterruptedException
	{
	if (driver.findElements(By.xpath("//span[text()='Save and continue']//parent::button")).size() != 0)
		testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Save and continue']//parent::button")),
				10);
	Thread.sleep(2000);
	}
	
	@Then("user click on Discard changes button")
	public void DiscardChanges_click() throws InterruptedException
	{
	if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
		testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")),
				10);
	Thread.sleep(2000);
	}

	
	
	@Then("user click on Ignore and Save button")
	public void user_click_on_Ignore_and_Save_button()
	{
		if (driver.findElements(By.xpath("//h1[text()='Scheduling Alerts']")).size() != 0);
		{
			testUtil.clickOn(driver,
					driver.findElement(By.xpath("//span[text()='Ignore And Save']//parent::button")), 10);
		}
	}
	
	@Then("user click on {string}")
	public void user_click_on_(String option) throws InterruptedException {
		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//*[text()='" + option + "']")));
			System.out.println("Option is == " + option);
			Thread.sleep(1000);
			contact.clickOn(option);
			Thread.sleep(1000);
			
			List<WebElement> li = driver.findElements(By.xpath("//button[@aria-label='Confirm']"));
			if (li.size() != 0)
				testUtil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Confirm']")), 1);
			
			Thread.sleep(1000);
			System.out.println("user clicked on : " + option);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on {string} button")
	public void user_click_on_button(String option) throws InterruptedException {
		try {
			System.out.println("Option is == " + option);
			Thread.sleep(3000);
			testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='" + option + "']")), 10);
			// contact.clickOn(option);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user clicks on {string}")
	public void user_clicks_on_(String option) throws InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			if (driver.findElements(By.xpath("//button[@aria-label='More commands for Action Plan']")).size() != 0) {
				driver.findElement(By.xpath("//button[@aria-label='More commands for Action Plan']")).click();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
			contact.clicksOn(option);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	 @Then("user validate Add additional link option is available")
	 public void  user_validate_Add_additional_link_option_is_available() throws InterruptedException
	 {
		 Thread.sleep(4000);
		 assertion.CheckAssertionTrue(driver.findElements(By.xpath("//*[contains(@aria-label,'Add additional link')]")).size() != 0,"Add additional link");
		 Thread.sleep(6000);
		 action.sendKeys(Keys.ESCAPE).build().perform();
		 action.sendKeys(Keys.ESCAPE).build().perform();
	 }
	
	 @Then("user validate child links are not displayed for selected chain information")
	 public void user_validate_child_links_are_not_displayed_for_selected_chain_information()
	 {
		 assertion.CheckAssertionTrue(driver.findElements(By.xpath("//section[@aria-label='Child Chain Information']//span[text()='No data available.']")).size() != 0,"No data available.");

	 }
	 
	@And("user clicks on locality queue {string}")
	public void user_clicks_on_locality_queue(String string)
	{
		System.out.println("User clicked : "+ string);
		
		testUtil.jsclick(driver.findElement(By.xpath("//a[contains(@aria-label,'<"+ string + ">')]")), driver);
	}
	
	@And("user clicks on {string} option")
	public void user_clicks_on_option(String option) throws InterruptedException {
		try {
			Thread.sleep(2000);			
			Wait.untilPageLoadComplete(driver,500);
			System.out.println("User clicked : "+ option);
			
			Thread.sleep(2000);		
			testUtil.jsclick(driver.findElement(By.xpath("//*[contains(@aria-label,'" + option + "')]")), driver);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@And("user perform click on {string}")
	public void user_performs_clicks_on_(String option) throws InterruptedException {
		try {			
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver,500);
			System.out.println("User clicked : "+ option);
			testUtil.jsclick(driver.findElement(By.xpath("//*[contains(@aria-label,'" + option + "')]")), driver);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on refresh button")
	public void user_click_on_refresh_button() throws InterruptedException {
		try {
			contact.clickOnRefresh();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("User validates the text {string}")
	public void user_validates_text(String text) throws InterruptedException {
		try {
			contact.validateText(text);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user validate the Chain information grid records are showing based on created date")
	public void user_validate_the_Chain_information_grid_records_are_showing_based_on_created_date()
	{
		String expected = driver.findElement(By.xpath("//div[@aria-rowindex='3']//div[@aria-colindex='2']")).getAttribute("title");
assertion.CheckAssertionTrue(expected.contains("Julie"), expected);
	}
	
	@Then("user validate the child Chain information grid records are showing based on created date")
	public void user_validate_the_child_Chain_information_grid_records_are_showing_based_on_created_date()
	{
		String expected = driver.findElement(By.xpath("(//div[@aria-rowindex='3']//div[@aria-colindex='2'])[2]")).getAttribute("title");
assertion.CheckAssertionTrue(expected.contains("add Julie Utting 2"), expected);
	}
	
	

	@Then("User validates the text {string} not present")
	public void user_validates_text_not_present(String text) throws InterruptedException {
		try {
			contact.validateTextNotPresent(text);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Back button")
	public void user_click_on_back_button() throws InterruptedException {
		try {
			contact.clickOnBack();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	@Then("user read the Task title")
	public void user_read_the_Task_title() throws InterruptedException {
		String title = contact.readTaskTitle();
		System.out.println(title);
	}
	
	@And("user search for the task title")
	public void user_search_for_the_task_title() throws InterruptedException {
		String taskTitle = contact.getTaskTitle();
		System.out.println(taskTitle);
//		driver.findElement(By.xpath("//input[@aria-label='Queue Item Filter by keyword']")).sendKeys(taskTitle);
//		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(taskTitle, Keys.ENTER);
		Thread.sleep(2000);
		Thread.sleep(2000);
		System.out.println("clicked Entered Queue");
		testUtil.clickOn(driver, driver.findElement(By.xpath("(//*[text()='Entered Queue'])[1]")), 3);
		testUtil.clickOn(driver, driver.findElement(By.xpath("(//*[text()='Entered Queue'])[1]")), 3);
		System.out.println("Entered Queue");
		
		testUtil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Sort newer to older']")), 3);
		Thread.sleep(3000);
		testUtil.jsclick(driver.findElement(By.xpath("//*[text()='" + taskTitle + "']")), driver);
		Thread.sleep(3000);
		
	}
}
