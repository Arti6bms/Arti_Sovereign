package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import com.sat.Pages.GenericCases;
import com.sat.Pages.LoginPage;
import com.sat.Pages.Optimization;
import com.sat.Pages.SLATimer;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Then;

public class Potential_ETStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	LoginPage loginpage = new LoginPage(driver);
	Testutil testutil = new Testutil(driver);
	Assertions assertion = new Assertions(driver);
	Actions actions = new Actions(driver);
	Assessment_ET assessment_ET = new Assessment_ET(driver);
	SLATimer slatimer = new SLATimer(driver);
	CasePage cases = new CasePage(driver);
	Optimization omptimization = new Optimization(driver);
	GenericCases genericCases = new GenericCases(driver);
	ContactForm contact = new ContactForm(driver);
	String workingDir = System.getProperty("user.dir");
	
	
	@Then("user select Outcome Type as Job")
	public void user_select_Outcome_Type_Job() throws InterruptedException
	{
		actions.click(driver.findElement(By.xpath("//select[@aria-label='Outcome Type']"))).build().perform();
		Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//select[@aria-label='Outcome Type']//option[text()='Job']")).click();


	}

	
	 @Then("user search Opportunity Name")
	 public void  user_search_Opportunity_Name()
	 {
	
	try {
		Properties OpportunityName = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Potential_ET.properties");
		System.out.println("Opportunity Name : " + OpportunityName.getProperty("OpportunityName"));
		
		String name = OpportunityName.getProperty("OpportunityName");
		
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


	@Then("user click on Potential name")
	public void user_click_on_Potential_name() throws IOException {
		try {
			Properties OpportunityName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Potential_ET.properties");
			System.out.println("Opportunity Name : " + OpportunityName.getProperty("OpportunityName"));
			
			Thread.sleep(2000);
			testutil.jsclick(driver.findElement(By.xpath("//*[text()='" + OpportunityName.getProperty("OpportunityName") + "']")), driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validates the {string} Potential is showing in Outcome Management grid")
	public void user_validates_the_Potential_is_showing_in_Outcome_Management_grid(String s) {
		try {
			
			Properties OpportunityName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Potential_ET.properties");
			System.out.println("Opportunity Name : " + OpportunityName.getProperty("OpportunityName"));
			
			String string = s+"-"+OpportunityName.getProperty("OpportunityName");

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//section[contains(@aria-label,'Potential Outcomes')]")));
			Thread.sleep(2000);
			actions.moveToElement(driver.findElement(By.xpath(
					"//section[@aria-label='Potential Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")));
			actions.click(driver.findElement(By.xpath(
					"//section[@aria-label='Potential Outcomes']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
					.build().perform();
			Thread.sleep(2000);
			actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
			Thread.sleep(2000);
			actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Filter by value']")), string).build()
					.perform();
			Thread.sleep(2000);
			actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
			Thread.sleep(2000);
			System.out.println(string + " grid values are " + driver
					.findElement(By.xpath("//section[@aria-label='Potential Outcomes']")).getAttribute("textContent"));
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='Potential Outcomes']"))
					.getAttribute("textContent").contains(string), string);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user enters the details in Training Outcome section for potential")
	public void user_enters_the_details_Training_section_for_potential() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String currentdate = sdf.format(new Date());
		Thread.sleep(3000);
		
		Properties TypeOfTraining = testutil
				.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Potential_ET.properties");
		System.out.println("Type Of Training : " + TypeOfTraining.getProperty("TypeOfTraining"));
		
		
		testutil.sendKeys(driver,
				driver.findElement(
						By.xpath("//input[@data-id='po_trainingoutcomegained.fieldControl-date-time-input']")),
				0, currentdate);
		Thread.sleep(3000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Training Type']")),
				"Accredited Training");
		Thread.sleep(3000);
		cases.fillDetails("Type of Training", TypeOfTraining.getProperty("TypeOfTraining"));
		Thread.sleep(3000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Digital Training']")),
				"Yes");
		Thread.sleep(3000);
	}

	@Then("user enters the details in Job Outcome section for potential")
	public void user_enters_the_details_Job_section_for_potential() throws Exception {
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Job Contract Type']")),
				"Full Time");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//select[@aria-label='Job Contract Duration']")),
				"Permanent");
		Thread.sleep(2000);
		testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Weekly Hours']")),0, "3");
		Thread.sleep(2000);
		testutil.selectByVisibleText(driver,driver.findElement(By.xpath("//select[@aria-label='Salary Range']")),"£5001-£10,000");
		Thread.sleep(2000);
		cases.fillDetails("Job Company Name", "3 T Finance");
		Thread.sleep(2000);
		testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Job Title']")),0, "Manager");

		//aria-label="Job Contract Duration"
	}
	
	 @Then("user enters the details in Work Placement Outcome section for potential")
		public void user_enters_the_details_Work_Placement_section_for_potential() throws Exception {
			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Placement Company Name']")),10, "WorkPlacement");

	 }
	 
	 @Then("user enters the details in Volunteering Outcome section for potential")
		public void user_enters_the_details_Volunteering_section_for_potential() throws Exception {
			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Volunteering Company Name']")),0, "Volunteering");

	 }
	 
	 @Then("user enters the details in LicenseAffiliationRegistration Outcome section for potential")
		public void user_enters_the_details_LicenseAffiliationRegistration_section_for_potential() throws Exception {
			Properties LicenseAffiliationRegistrationType = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Potential_ET.properties");
			System.out.println("LicenseAffiliationRegistration Type : " + LicenseAffiliationRegistrationType.getProperty("LicenseAffiliationRegistrationType"));
		 
		 cases.fillDetails("License/ Affiliation/ Registration Type", LicenseAffiliationRegistrationType.getProperty("LicenseAffiliationRegistrationType"));
	 }

	 @Then("user enters the details in MaD Programme Outcome section for potential")
		public void user_enters_the_details_MaDProgramme_section_for_potential() throws Exception {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String currentdate = sdf.format(new Date());
			Thread.sleep(3000);
			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")),
					10, currentdate);
			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Role ']")),10, "Manager");

			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Number of hours']")),10, "5");

			}
	 
	 @Then("user enters the details in Equipment Grant Outcome section for potential")
		public void user_enters_the_details_EquipmentGrant_section_for_potential() throws Exception {
		
			testutil.selectByVisibleText(driver, 
					driver.findElement(By.xpath("//select[@aria-label='Type of Equipment Available']")),"Laptop");			
			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@aria-label='Maximum Number per Customer ']")),
					10, "5");
			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Value per unit ']")),10, "5");

			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Number of units ']")),10, "5");

			}
	 
	 @Then("user enters the details in Financial Grant Outcome section for potential")
		public void user_enters_the_details_FinancialGrant_section_for_potential() throws Exception {
		
			Thread.sleep(3000);
			
			
			
			testutil.selectByVisibleText(driver, 
					driver.findElement(By.xpath("//select[@aria-label='Type of Funding Applied For']")),"Sovereign Grant");
			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@aria-label='Amount of Grant Available']")),
					10, "5");
			testutil.selectByVisibleText(driver, 
					driver.findElement(By.xpath("//select[@aria-label='Grant Category']")),"Other");
			
			
			testutil.sendKeys(driver,driver.findElement(By.xpath("//input[@aria-label='Individual Grant Cap']")),10, "5");

			}

}
