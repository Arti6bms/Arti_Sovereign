package com.sat.StepDefinitions;

import java.awt.Desktop.Action;
import java.io.IOException;
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

import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.CustomerPage;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActionPlanStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();

	private CustomerPage accountpage = new CustomerPage(driver);
	private CasePage cases = new CasePage(driver);
	ContactForm contact = new ContactForm(driver);
	Actions action = new Actions(driver);
	  Assertions assertion = new Assertions(driver);
	  String workingDir = System.getProperty("user.dir");
	Testutil testUtil = new Testutil(driver);
	HashMap<Integer, String> Goals = new HashMap<Integer, String>();

	
	 @Then("user read the Goal Setting question")
	 public void user_read_Goal_Setting_question() 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//section[@aria-label='Goal Setting']")));
		 
		 
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			
			Goals.put(1,driver.findElement(By.xpath("//input[@aria-label='What is your goal?']")).getAttribute("title") );
		 Goals.put(2,driver.findElement(By.xpath("//input[@aria-label='Support for Goal?']")).getAttribute("title") );
		 
		 Goals.put(3,driver.findElement(By.xpath("//input[@aria-label='Way of Working?']")).getAttribute("title") );
		 Goals.put(4,driver.findElement(By.xpath("//input[contains(@aria-label,'Goal: 6 Weeks')]")).getAttribute("title") );
		 action.sendKeys(Keys.PAGE_DOWN).build().perform();
		 Goals.put(5,driver.findElement(By.xpath("//input[contains(@aria-label,'Goal: 6 Months')]")).getAttribute("title") );
		 Goals.put(6,driver.findElement(By.xpath("//input[@aria-label='Goal: 3 Years']")).getAttribute("title") );

		 
	 }

	@When("user click on {string} under {string}")
	public void user_click_on_under_customer(String tab, String section) {
		try {
			if (!driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).isEmpty())
				driver.findElement(By.xpath("//button[@aria-label='Discard changes']")).click();
			accountpage.entity(tab);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user pick active Assessment")
	public void user_select_searched_Assessment_in_Assessment_form() {
		try {
			
			
			Properties AssessmentName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ActionPlan_ET.properties");
			System.out.println("AssessmentName : " + AssessmentName.getProperty("AssessmentName"));
			System.out.println("AssessmentName is : " + AssessmentName.getProperty("AssessmentName"));
			
			contact.objsearchField.sendKeys(AssessmentName.getProperty("AssessmentName"), Keys.ENTER);

			Wait.untilPageLoadComplete(driver);
			driver.findElement(By.xpath("//a[contains(@aria-label,'" + AssessmentName.getProperty("AssessmentName") + "')]")).click();
			Thread.sleep(3000);
		} catch (Exception ee) {
			System.out.println(ee);
			// ExtentCucumberAdapter.getCurrentStep().info(ee);
		}
	}

	@When("user enters the {string} details")
	public void user_enters_the_details(String string, DataTable datatable) {
		List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
		List<List<String>> actual = datatable.cells();
		System.out.println(actual.size());
		try {
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			for (int j = 0; j < actual.size() - 1; j++) {
				String GoalSetting = data.get(j).get("Goal Setting");
				System.out.println("Goal is : " + GoalSetting);
				testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[contains(@aria-label,'"+GoalSetting+"')]")), 3, "TEST");
					
			}
		}
	catch(

	Exception ee)
	{
		System.out.println(ee);
		// ExtentCucumberAdapter.getCurrentStep().info(ee);
	}

}
	@Then("user validates {string} section in {string} are mapped from Assessment")
	public void user_validates_in_are_mapped_from_assessment(String string, String string2,DataTable datatable) {
		
		List<Map<String, String>> data = datatable.asMaps(String.class, String.class);
		List<List<String>> actual = datatable.cells();
		System.out.println(actual.size());
		try {
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			for (int j = 0; j < actual.size() - 1; j++) {
				String GoalSetting = data.get(j).get("Goal Setting");
				System.out.println("Goal is : " + GoalSetting);
				assertion.CheckAssertion(driver.findElement(By.xpath("//input[contains(@aria-label,'"+GoalSetting+"')]")).getAttribute("title"), Goals.get(j+1));
					
			}
		}
	catch(

	Exception ee)
	{
		System.out.println(ee);
		// ExtentCucumberAdapter.getCurrentStep().info(ee);
	}
	   
	}

	@Then("user enters Action field in {string} Quick Create form")
	public void user_enters_Action_field_in_Quick_Create_form(String string) {
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Action']"))));

			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Action']")), 3, "TEST_ACTION");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user enters ByWhen field in {string} Quick Create form")
	public void user_enters_By_When_field_in_Quick_Create_form(String string) {
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@aria-describedby,'TextFieldDescription')]"))));

			testUtil.sendKeys(driver, driver.findElement(By.xpath("//input[contains(@aria-describedby,'TextFieldDescription')]")), 3, "11/08/2022");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user validates the {string} is showing in Action Grid")
	public void user_validates_the_New_Action_is_showing_in_Action_Grid(String actionName) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@aria-label='Actions']"))));

			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Actions']")).getAttribute("textContent").contains(actionName), actionName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 @Then("user click on ActionPlan link")
	 public void  user_click_on_ActionPlan_link() throws IOException
	 {
		 Wait.untilPageLoadComplete(driver,500);
		 
		 Properties AssessmentName = testUtil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/ActionPlan_ET.properties");
			System.out.println("AssessmentName : " + AssessmentName.getProperty("AssessmentName"));
			System.out.println("AssessmentName is : " + AssessmentName.getProperty("AssessmentName"));
			
			String actionplan[] = AssessmentName.getProperty("AssessmentName").split("ET Assessments");
			System.out.println(actionplan[0]);
			String APLink =actionplan[0].trim().concat("-AP");
			
			WebElement e = driver.findElement(By.xpath("//div[contains(@title,'"+APLink+"')]"));
			//div[@data-id='po_action_planid.fieldControl-Lookup_po_action_planid' and contains(@title,'Sabrina Bajwa')]
			//div[@data-id='po_action_planid.fieldControl-Lookup_po_action_planid' and contains(@title,'Sabrina Bajwa')]
			
	        testUtil.clickOn(driver, e, 2);
	        Wait.untilPageLoadComplete(driver,500);
	 }
	 
	 
	 @Then("user validates Download link is available for Export To PDF")
	 public void user_validates_Download_link_is_available_for_Export_To_PDF() {
	 assertion.CheckAssertionTrue(driver.findElement(By.xpath("//span[text()='Download']")), "Download Option");
	 
	 }

}
