package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.Action;

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
import com.sat.Pages.FraudCase;
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

public class ProcessingApplicationsStepdefsResalesStaircasing {

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
	String workingDir = System.getProperty("user.dir");
	HashMap<String, String> map = new HashMap<String, String>();
	String LeadApplicant;
	FraudCase fraudCase = new FraudCase(driver);

	@Then("user select any Active Contact")
	public void user_select_any_Active_Contact() {
		try {
			Thread.sleep(2000);
			String PropertName = driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']//a"))
					.getAttribute("textContent");
			map.put("PropertName", PropertName);
			Thread.sleep(2000);
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='3']//a")), 10);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Then("user search Contact Name")
	public void user_search_Contact_Name() throws IOException {
		Properties ApplicationTitle = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResalesStaircasing.properties");

		System.out.println(ApplicationTitle.getProperty("ActiveContactName"));
		String name = ApplicationTitle.getProperty("ActiveContactName");

		try {
			Thread.sleep(3000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
			contact.objsearchField.sendKeys(name, Keys.ENTER);
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			List<WebElement> li = driver.findElements(By.xpath("//*[text()='" + name + "']"));
			assertion.CheckAssertionTrue(!li.isEmpty(), name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Then("user select {string} form")
	public void user_select_form(String string) throws InterruptedException {	
		
		testutil.jsclick(driver.findElement(By.xpath("//div[@data-id='form-selector']")), driver);
		Thread.sleep(1000);
		testutil.jsclick(driver.findElement(By.xpath("//span[text()='Staircasing Application']")), driver);
		Thread.sleep(1000);
		
//		if (!driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).isEmpty())
//			driver.findElement(By.xpath("//button[@aria-label='Discard changes']")).click();
//		
		if (!driver.findElements(By.xpath("//button[@aria-label='OK']")).isEmpty())
			driver.findElement(By.xpath("//button[@aria-label='OK']")).click();
	}
	
	@Then("user search Property Name for staircasing")
	public void user_search_Application_Title_staircasing() throws IOException {
		Properties ApplicationTitle = testutil.readPropertiesFile(
				workingDir + "/src/main/java/com/sat/testData/ProcessingApplicationsResalesStaircasing.properties");

		System.out.println(ApplicationTitle.getProperty("PropertyName"));

		String name = ApplicationTitle.getProperty("PropertyName");

		try {
			Thread.sleep(3000);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(contact.objsearchField));
			contact.objsearchField.sendKeys(name, Keys.ENTER);
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			List<WebElement> li = driver.findElements(By.xpath("//*[text()='" + name + "']"));
			assertion.CheckAssertionTrue(!li.isEmpty(), name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@Then("user enter the value in {string} as {string}")
    public void user_enter_the_value_in_as(String string, String string2) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling down the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();",
//                driver.findElement(By.xpath("//input[contains(@aria-label,'"+string+"')]")));

 

        //actions.sendKeys(Keys.CONTROL, Keys.END).build().perform();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN,Keys.PAGE_DOWN);

        testutil.inputText(driver, string, 10, string2);

    }
	@Then("user clicks Internal Checks on BPF")
    public void user_clicks_Internal_Checks_on_BPF() {
          // driver.findElement(By.xpath("//span[text()='Refresh']")).click();
        try {
            Thread.sleep(2000);
         // driver.findElement(By.xpath("//li[contains(@aria-label,'Stage: Internal Checks')]")).click();
            driver.findElement(By.xpath("(//div[text()='Internal Checks'])[1]")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Then("user validate {string} is {int} weeks from {string} date")
	public void user_validate_is_weeks_from_date(String string, Integer int1, String string2) throws InterruptedException, IOException {
	 Thread.sleep(1500);
	final Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, +56);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String date = sdf.format(cal.getTime());
	String DateofInstruction = driver.findElement(By.xpath("//input[@data-id='po_dateofinstruction.fieldControl-date-time-input']")).getAttribute("defaultValue");
	Thread.sleep(1500);
	String ForecastedCompletion = driver.findElement(By.xpath("//input[@data-id='po_proposedcompletiondate.fieldControl-date-time-input']")).getAttribute("defaultValue");
	System.out.println(DateofInstruction);
	System.out.println(ForecastedCompletion);
	System.out.println(date);
    assertion.CheckAssertion(date, ForecastedCompletion);
	}
	@Then("user enter the details in {string} section")
    public void user_enter_the_details_in_section(String string) {

    }
	
	@Then("user clicks Authority To Proceed on BPF")
    public void user_clicks_AuthorityToProceed_on_BPF() {
        try {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(@aria-label,'Stage: Authority To Proceed')]")).click();
        } catch (Exception e) {


            e.printStackTrace();
        }
	}
	
	 @Then("user select Valuation Approved checkbox")
	 public void  user_select_Valuation_Approved_checkbox() throws InterruptedException
	 {
		 Thread.sleep(1000);
		 actions.click(driver.findElement(By.xpath("//select[contains(@aria-label,'Valuation Approved')]"))).build().perform();
		 
	 }
	 
	 @Then("user select Alerter checkbox")
	 public void  user_select_Alerter_checkbox() throws InterruptedException
	 {
		 Thread.sleep(1000);
		 actions.click(driver.findElement(By.xpath("//input[@aria-label='Have you updated the Alerter you have actioned the case']"))).build().perform();
		 
	 }

	@Then("user selects Conveyancing Complete as {string}")
    public void user_selects_Conveyancing_Complete_as(String string) {
        try {
            Thread.sleep(500);
            testutil.selectByVisibleText(driver, driver.findElement(By.xpath("//input[@aria-label='Conveyancing Complete ?']")),
                    string);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

	@Then ("user set Date of Instruction date")
	public void user_set_Date_of_Instruction_Date() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@data-id='header_process_po_dateofinstruction.fieldControl._datecontrol-date-container']//child::input[@aria-label='Date of Date of Instruction']//following-sibling::i")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@aria-selected='true']")).click();

	}

}