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

public class SalesflowStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();

	private CustomerPage accountpage = new CustomerPage(driver);
	private CasePage cases = new CasePage(driver);
	ContactForm contact = new ContactForm(driver);
	Actions action = new Actions(driver);
	  Assertions assertion = new Assertions(driver);
	  String workingDir = System.getProperty("user.dir");
	Testutil testutil = new Testutil(driver);
	HashMap<Integer, String> Goals = new HashMap<Integer, String>();
	
	@Then("user validate Apply Now Flag is displayed")
	public void user_validate_ApplyNow_Flag_is_displayed() {
		
		try {
			Thread.sleep(2000);
			
			//driver.navigate().refresh();
			Thread.sleep(4000);
			driver.switchTo().frame("WebResource_SalesStatusFlag");			
			Boolean b = driver.findElements(By.xpath("//td//img[contains(@src,'applynow')]")).size()!=0;
			System.out.println(b);
			assertion.CheckAssertionTrue(b, "Apply Now Flag");
			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	@Then("user sort the records from newer to older in Oppurtunities List")
	public void user_sort_the_records_from_newer_older_Oppurtunities_List()
	{
		try {
			Thread.sleep(3000);

			testutil.clickOn(driver, driver.findElement(By.xpath("//div[contains(text(),'Est. close')]")), 3);
			Thread.sleep(3000);
			testutil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Sort newer to older']")), 3);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user validate Completed Flag is displayed")
	public void user_validate_Completed_Flag_is_displayed() {
		
		try {
			Thread.sleep(2000);
			
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.switchTo().frame("WebResource_SalesStatusFlag");			
			Boolean b = driver.findElements(By.xpath("//td//img[contains(@src,'completed')]")).size()!=0;
			System.out.println(b);
			assertion.CheckAssertionTrue(b, "Completed Flag");
			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	@Then("user validate Reserved Flag is displayed")
	public void user_validate_Reserved_Flag_is_displayed() {
		
		try {
			Thread.sleep(2000);
			
			driver.navigate().refresh();
			Thread.sleep(4000);
			driver.switchTo().frame("WebResource_SalesStatusFlag");			
			Boolean b = driver.findElements(By.xpath("//td//img[contains(@src,'reserved')]")).size()!=0;
			System.out.println(b);
			assertion.CheckAssertionTrue(b, "Reserved Flag");
			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	
	@Then("user search Application Title")
	public void user_search_Application_Title() throws IOException {
		 Properties ApplicationTitle = testutil.readPropertiesFile(
					workingDir + "/src/main/java/com/sat/testData/Salesflow.properties");
		 
		System.out.println(ApplicationTitle.getProperty("ApplicationTitle"));
		 
		 String name = ApplicationTitle.getProperty("ApplicationTitle");
		 
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

}
