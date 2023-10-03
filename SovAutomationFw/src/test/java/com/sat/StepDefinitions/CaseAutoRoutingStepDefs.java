package com.sat.StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaseAutoRoutingStepDefs {


	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
	private ContactForm contact = new ContactForm(driver);
	Testutil testUtil = new Testutil(driver);
	private CasePage cases = new CasePage(driver);
	Assertions assertion = new Assertions(driver);


	private ArrayList<String> caseNumbers = new ArrayList<String>();

	@And("user navigates to {string}")
	public void user_navigates_to(String tab) {
		Wait.untilPageLoadComplete(driver);
		List<WebElement> ele = driver.findElements(By.xpath("//li[text()='" + tab + "']"));
		if (ele.size() != 0)
			testUtil.jsclick(driver.findElement(By.xpath("//li[text()='" + tab + "']")), driver);
	}

	@Then("user answers all the questions")
	public void answer_all_questions() {
		List<WebElement> questions = driver.findElements(cases.initialVictimQuestions);
		for (int i = 0; i < questions.size(); i++) {
			questions.get(i).click();
			testUtil.selectByVisibleText(driver, questions.get(i), "Yes");
		}
	}

	@Then("Validate Owner as {string}")
	public void validate_the_owner(String owner) {
		SoftAssert softassert = new SoftAssert();
		String actualOwner = cases.getOwnerFromTheCreatedcase();
		Wait.untilPageLoadComplete(driver);
		softassert.assertEquals(actualOwner, owner, "The Owner is " + actualOwner + " instead of " + owner);
		// softassert.assertAll();
	}
	
	@Then("user validate Case Owner as {string}")
	public void validate_case_owner(String caseowner)
	{
		assertion.CheckAssertionTrue(!driver.findElements(By.xpath("//a[contains(@aria-label,'" + caseowner + "')]")).isEmpty(), caseowner);
				
	}
	
	
	
	@Then("user validate default queue as {string}")
	public void validate_default_queue(String queuename)
	{
		assertion.CheckAssertionTrue(!driver.findElements(By.xpath("//a[contains(@aria-label,'" + queuename + "')]")).isEmpty(), queuename);
		
	}

	@And("Assign Owner to {string}")
	public void assign_the_owner(String owner) throws Exception {
		contact.clickOn("Assign");
		contact.clicksOn("Assign To");
		testUtil.selectOptionUsingValue(driver, owner);
		Wait.untilPageLoadComplete(driver);
		cases.clickOnAssign();
	}

	@Then("Validate Queue as {string}")
	public void validate_the_queue(String queue) {
//		SoftAssert softassert = new SoftAssert();
		String actualQueue = cases.getQueueFromTheCreatedcase();
		System.out.println(actualQueue);
		Wait.untilPageLoadComplete(driver);
		assertion.CheckAssertionTrue(actualQueue.contains(queue), actualQueue);
		//softassert.assertEquals(actualQueue, queue, "The Owner is " + actualQueue + " instead of " + queue);
		// softassert.assertAll();
	}

	@When("user saves the case Number")
	public void user_saves_the_case_Number() throws InterruptedException {
		Thread.sleep(1000);
		user_navigates_to("Summary");
		String caseNumber = cases.getCaseNumber();
		caseNumbers.add(caseNumber);
		System.out.println(caseNumbers);
	}

	@When("user search {string}")
	public void user_search(String name) throws InterruptedException {
		try {
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
	
	@And("user selects first record with status {string}")
	public void user_selects_first_record(String status) {
		testUtil.jsclick(driver.findElement(By.xpath("(//label[text()='"+status+"']//ancestor::div[@col-id='statecode']/parent::div//a)[1]")),driver);
	}
	
	@Then("User validates the created case numbers in the selected Queue")
	public void user_validates_created_case_numbers() {
		try {
			boolean isPresent = false;
			for (int i = 0; i < caseNumbers.size(); i++) {
				List<WebElement> ele = driver
						.findElements(By.xpath("//*[contains(text(),'" + caseNumbers.get(i) + "')]/parent::a"));
				if (ele.size() != 0)
					isPresent = true;
				Assert.assertTrue(isPresent, "CaseNumber " + caseNumbers.get(i) + "is not present");
			}
		} catch (Exception e) {
			System.out.println("Exception " + e + " has occurred");
		}
	}

	@When("User enters details to Resolve Case")
	public void user_enters_details_to_resolve_case() throws Exception {
		contact.clicksOnAndSendText("Resolution", "test");
		contact.clickOn("Resolve");
		WebDriverWait wait = new WebDriverWait(driver, 120);
	//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[text()='Processing...']"))));
	}
	
	@Then("user verify the case Owner as {string}")
	public void user_verify_the_case_Owner_as(String actualOwnerName) throws IOException, InterruptedException {
		try {
			String exceptedOwnerName = driver.findElement(By.xpath("//a[@aria-label='" +actualOwnerName+ "']"))
					.getText();
			System.out.println("Owner Name : " + exceptedOwnerName);
			Wait.implicitwait();
			Assert.assertEquals(actualOwnerName, exceptedOwnerName, "Owner Name Mismatch");
			Wait.implicitwait();
		} catch (Exception e) {
		}
	}
}