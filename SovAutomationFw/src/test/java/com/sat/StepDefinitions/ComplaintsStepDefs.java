package com.sat.StepDefinitions;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.sat.Pages.ContactForm;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Then;

public class ComplaintsStepDefs {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	public ContactForm contact = new ContactForm(driver);
	Testutil testUtil = new Testutil(driver);
	Actions action = new Actions(driver);
	Assertions assertion = new Assertions(driver);
	String workingDir = System.getProperty("user.dir");

	@Then("user enter the details in Failure Reason If Other please specify field")
	public void user_enter_the_details_in_Failure_Reason_If_Other_please_specify_field() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@data-id='po_otherfailurereason.fieldControl-text-box-text']")).click();
		action.sendKeys("Test").build().perform();
		Thread.sleep(2000);
	}

	@Then("user enter the details in Root Cause Reason If Other please specify field")
	public void user_enter_the_details_in_Root_Cause_Reason_If_Other_please_specify_field()
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@data-id='po_otherreason.fieldControl-text-box-text']")).click();
		action.sendKeys("Test").build().perform();
		Thread.sleep(2000);
	}

	@Then("user enter the details for Root Cause Type as {string}")
	public void user_enter_the_details_for_Root_Cause_Type_as(String fieldvalue) throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Root Cause Type, Lookup')]")).click();
		Thread.sleep(1500);
		action.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Root Cause Type, Lookup']")), fieldvalue)
				.build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();
	}

	@Then("user enter the details for for Root Cause Reason as {string}")
	public void user_enter_the_details_for_for_Root_Cause_Reason_as(String fieldvalue) throws InterruptedException {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Root Cause Reason, Lookup')]")).click();
		Thread.sleep(1500);
		action.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Root Cause Reason, Lookup']")), fieldvalue)
				.build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();
	}

	@Then("user check Stage {int} Complaint Acknowledged field")
	public void user_check_Stage_Complaint_Acknowledged_field(Integer int1) throws InterruptedException {
		Thread.sleep(1500);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Contact Preferences']"))).build().perform();
//		driver.findElement(
//				By.xpath("//div[@data-id='po_stage" + int1 + "complaintacknowledged.fieldControl-checkbox-container']"))
//				.click();
		driver.findElement(
				By.xpath("//input[@aria-label='Stage "+ int1 + ": Complaint Acknowledged']"))
				.click();

		
	}

	@Then("user validate locked field")
	public void user_validate_locked_field(io.cucumber.datatable.DataTable datatable) throws InterruptedException {
		List<String> actual = datatable.asList();
		System.out.println("Size :" + datatable.asList().size());
		try {
			for (int j = 0; j < datatable.asList().size(); j++) {
				Thread.sleep(1500);
				System.out.println(actual.get(j));
				List<WebElement> field = driver.findElements(By.xpath("//label[text()='" + actual.get(j)
						+ "']/ancestor::div[contains(@id,'FieldSectionItemContainer')]"));
				if (!field.isEmpty()) {
					// Checking for locked fields
					List<WebElement> locked = driver.findElements(By.xpath("//label[text()='" + actual.get(j)
							+ "']/ancestor::div[contains(@id,'FieldSectionItemContainer')]/div/div[contains(@id,'locked')]"));
					if (!locked.isEmpty())
						System.out.println("Locked field :" + actual.get(j));
					else
						System.out.println("Unlocked field :" + actual.get(j));
				}
			}
			Thread.sleep(1500);
		} catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	@Then("user validate the Timeline for case email customer confirmation")
	public void user_validate_the_Timeline_for_case_email_customer_confirmation() {

		String Actual = driver
				.findElement(By.xpath("//div[@data-id='notescontrol-timelinewallContextualEmailBodynotescontrol']//li"))
				.getAttribute("textContent");
		// "Auto-post: Case Complaints, Jerrilee Shepherd, Flat 25 Odiham Drive,
		// Newbury, RG14 1GA, CAS-15782-X0X5D7 created by Maheshwar Poloju for Contact
		// Jerrilee Shepherd"

		String Expected = driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']//h1"))
				.getAttribute("title");
		System.out.println("Expected : " + Expected);
		System.out.println("Actual : " + Actual);

		assertion.CheckAssertionTrue(Actual.contains(Expected), Expected);

	}

	@Then("user validate the Alert message {string}")
	public void user_validate_the_Alert_message(String string) throws InterruptedException {
		Thread.sleep(3500);
		Alert promptAlert = driver.switchTo().alert();
		String s = driver.switchTo().alert().getText();
		System.out.println(s);
		Thread.sleep(3500);
		promptAlert.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(3500);
		assertion.CheckAssertionTrue(s.contains(string), s);

	}

	@Then("user validate the Timeline for resolved case email customer confirmation")
	public void user_validate_the_Timeline_for_resolved_case_email_customer_confirmation() {

		String Actual = driver
				.findElement(By.xpath("//div[@data-id='notescontrol-timelinewallContextualEmailBodynotescontrol']//li"))
				.getAttribute("textContent");
		String Expected = driver.findElement(By.xpath("//div[@data-lp-id='form-header-title']//h1"))
				.getAttribute("title");
		System.out.println("Expected : " + Expected);
		System.out.println("Actual : " + Actual);

		assertion.CheckAssertionTrue(Actual.contains(Expected), Expected);

	}

	@Then("user click on Resolve Case")
	public void user_click_on_ResolveCase() {
		try {
			String option = "Resolve Case";
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//*[text()='" + option + "']")));
			System.out.println("Option is == " + option);
			Thread.sleep(3000);
			contact.clickOn(option);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}

	}
	
	@Then("user click on Reactivate Case")
	public void user_click_on_ReactivateCase() {
		try {
			String option = "Reactivate Case";
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//*[text()='" + option + "']")));
			System.out.println("Option is == " + option);
			Thread.sleep(3000);
			contact.clickOn(option);
			Thread.sleep(3000);

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}

	}
	
	@Then("user validate Complaints Stage field is set to {string}")
	public void user_validate_Complaints_Stage_field_is_set_to(String string) throws InterruptedException
	{
		Thread.sleep(3000);
		String Actual = driver.findElement(By.xpath("//select[@aria-label='Complaints Stage']")).getAttribute("title");
		System.out.println(Actual);
		
		assertion.CheckAssertionTrue(Actual.contains(string), Actual);
		
	}

}