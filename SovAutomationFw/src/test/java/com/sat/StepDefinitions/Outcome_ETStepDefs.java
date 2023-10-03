package com.sat.StepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.Pages.Assessment_ET;
import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.GenericCases;
import com.sat.Pages.LoginPage;
import com.sat.Pages.Optimization;
import com.sat.Pages.Outcome_ET;
import com.sat.Pages.SLATimer;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class Outcome_ETStepDefs {

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
	HashMap<String, String> dates = new HashMap<String, String>();
	Outcome_ET outcome_et = new Outcome_ET(driver);

	@Then("user validate {string} is mapped from Assessment")
	public void user_validate_is_mapped_from_Assessment(String string) {

		try {
			Thread.sleep(3000);
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//select[@aria-label='Reason for Enrollment']"))
					.getAttribute("textContent").contains("Better Work"), "Better Work");
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("//ul[contains(@data-id,'po_assessmentid_SelectedRecordList')]"))
							.getAttribute("textContent").contains("Julie Utting ET Assessments"),
					"Julie Utting ET Assessments");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user sort the records from newer to older")
	public void user_sort_the_records_from_newer_to_older() {
		try {
			Thread.sleep(4000);

			testutil.clickOn(driver, driver.findElement(By.xpath("(//*[text()='Created On'])[1]")), 3);
			//actions.click(driver.findElement(By.xpath("(//div[@data-testid='columnHeader' and @role ='button'])[4]"))).build().perform();
			//testutil.clickOn(driver, driver.findElement(By.xpath("//div[@data-testid='columnHeader' and @role ='button']//div[@data-testid='createdon']")), 5);
			Thread.sleep(2000);
			System.out.println("clicked created on");
			testutil.clickOn(driver, driver.findElement(By.xpath("(//*[text()='Created On'])[1]")), 3);
			System.out.println("clicked created on");
			Thread.sleep(3000);
			testutil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Sort newer to older']")), 3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user click on Assessment name {string}")
	public void user_click_on_Assessment_name(String AssessmentName) {
		try {
			Thread.sleep(2000);
			testutil.jsclick(driver.findElement(By.xpath("//*[text()='" + AssessmentName + "']")), driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validates the field {string} when {string} is selected as {string}")
	public void user_validates_the_field(String string, String string1, String string2) {
		try {
			testutil.selectByVisibleText(driver,
					driver.findElement(By.xpath("//select[contains(@aria-label,'" + string1 + "')]")), string2);
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//label[text()='" + string + "']")), string);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user fills all the fields in Wellbeing Outcome Section")
	public void user_fills_all_the_fields_in_Wellbeing_Outcome_Section(io.cucumber.datatable.DataTable datatable) {
		List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {

			for (int j = 0; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				// select[@aria-label='Photo ID?']
				testutil.selectByVisibleText(driver,
						driver.findElement(By.xpath("//select[@aria-label='" + actual.get(j) + "']")), "Yes");

			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(new Date());
			System.out.println(date);
			
			if (driver.findElements(By.xpath("//input[@data-id='po_wellbeingoutcomegained.fieldControl-date-time-input']")).size()!=0)
			{
			testutil.sendKeys(driver,
					driver.findElement(
							By.xpath("//input[@data-id='po_wellbeingoutcomegained.fieldControl-date-time-input']")),
					0, date);
			}
			
			testutil.sendKeys(driver,
					driver.findElement(By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")), 0,
					date);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validates the Outcome {string} is showing in Outcome grid")
	public void user_validates_the_Outcome_is_showing_in_Outcome_grid(String string) {

		try {

			actions.click(
					driver.findElement(By.xpath("//div[@aria-label='Editable Grid']//button[text()='Outcome Type']")))
					.build().perform();
			actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
			actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
			Thread.sleep(2000);

			actions.click(driver.findElement(By.xpath("//span[contains(text(),'" + string + "')]//parent::label")))
					.build().perform();
			actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();

			Thread.sleep(4000);
			// assertion.CheckAssertionTrue(driver.findElement(By.xpath("
			// //*[@aria-rowindex='2']//*[@aria-colindex='4']"))
			// .getAttribute("textContent").contains("Julie Utting"), "Julie Utting");
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(driver.findElement(By.xpath(" //span[text()='" + string + "']"))
					.getAttribute("textContent").contains(string), string);

			// assertion.CheckAssertionTrue(driver.findElement(By.xpath("
			// //*[@aria-rowindex='2']//*[@aria-colindex='2']"))
			// .getAttribute("textContent").contains(string), string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user open the Outcome {string}")
	public void user_open_the_Outcome(String s) {

		try {
			Thread.sleep(3000);
			// actions.moveToElement(driver.findElement(By.xpath("//*[@aria-rowindex='2']//*[@aria-colindex='1']")))
			// .build().perform();
			System.out.println("opening outcome is " + s);
//			actions.click(driver.findElement(By.xpath("//div[@aria-label='Editable Grid']//button[text()='Outcome Type']"))).build().perform();
//			actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
//			actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
//			Thread.sleep(2000);
//			
//			actions.click(driver.findElement(By.xpath("//span[contains(text(),'"+s+"')]//parent::label"))).build().perform();
//			Thread.sleep(2000);
//			actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
//			Thread.sleep(2000);

			actions.click(driver.findElement(By.xpath("//span[text()='" + s + "']"))).build().perform();
			actions.click(driver.findElement(By.xpath("//button[@title='Navigate']"))).build().perform();
			Thread.sleep(5000);
//			for (int i=2;i<=6;i++)
//			{
//				//String S1 = driver.findElement(By.xpath("(//*[@aria-rowindex="+i+"]//*[@aria-colindex='2'])[3]"))
//						//.getAttribute("textContent");
//				String S1 = driver.findElement(By.xpath("//span[text()='"+s+"']")).getAttribute("textContent");
//				System.out.println("S1 = " + S1);
//				System.out.println("s = " + s);
//				if (S1.contains(s))
//						{
//					System.out.println("in IF condition");
//					actions.click(driver.findElement(By.xpath("//span[text()='"+s+"']"))).build().perform();
//
//					//actions.click(driver.findElement(By.xpath("(//*[@aria-rowindex='"+i+"']//*[@aria-colindex='1'])[3]")))
//					//.build().perform();
//			Thread.sleep(2000);
//			
//			actions.click(driver
//					.findElement(By.xpath("//button[@title='Navigate']"))).build().perform();
//			//actions.click(driver
//					//.findElement(By.xpath("//*[@aria-rowindex="+i+"]//*[@aria-colindex='1']//*[@title='Navigate']")))
//				//	.build().perform();
//			break;
//						}
//				else {
//					System.out.println("in else condition");
//				}
//				
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user removes {string} field data")
	public void user_removes_field_data(String string) {
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

//			// Scrolling down the page till the element is found
//			js.executeScript("arguments[0].scrollIntoView();",
//					driver.findElement(By.xpath("//label[contains(text(),'Type of Grant')]")));
//			
//			js.executeScript("arguments[0].scrollIntoView();",
//					driver.findElement(By.xpath("//label[contains(text(),'Type of Payment')]")));
//			
//			js.executeScript("arguments[0].scrollIntoView();",
//					driver.findElement(By.xpath("//label[contains(text(),'Date Grant Completed')]")));

			Thread.sleep(4000);
			testutil.sendKeys(driver, driver.findElement(By.xpath("//input[contains(@aria-label,'"+string+"')]")),
					3, string);
			actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'"+string+"')]"))).build().perform();
			actions.sendKeys(Keys.CONTROL+"A");
			actions.sendKeys(Keys.BACK_SPACE).build().perform();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Then("user removes {string} field")
	public void user_removes_field(String string) {
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//label[contains(text(),'Type of Grant')]")));
			
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//label[contains(text(),'Type of Payment')]")));
			
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(By.xpath("//label[contains(text(),'Date Grant Completed')]")));

			Thread.sleep(4000);
			testutil.sendKeys(driver, driver.findElement(By.xpath("//input[contains(@aria-label,'"+string+"')]")),
					3, string);
			actions.click(driver.findElement(By.xpath("//input[contains(@aria-label,'"+string+"')]"))).build().perform();
			actions.sendKeys(Keys.CONTROL+"A");
			actions.sendKeys(Keys.BACK_SPACE).build().perform();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user updates the {string} field to past date")
	public void user_updates_the_field_to_past_date(String string) {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(cal.getTime());
		testutil.sendKeys(driver,
				driver.findElement(By.xpath("//input[@data-id='po_dateexpected.fieldControl-date-time-input']")), 0,
				date);

	}

	@Then("user validate {string} grid for {string}")
	public void user_validate_grid(String string, String s) {
		outcome_et.validateGrid(string,s);

	}

	@Then("user deactivates the outcome {string}")
	public void user_deactivates_the_outcome(String s) {

		try {
			Thread.sleep(2000);
			// actions.moveToElement(driver.findElement(By.xpath("//*[@aria-rowindex='2']//*[@aria-colindex='1']")))
			// .build().perform();

			for (int i = 2; i <= 6; i++) {

				actions.click(driver
						.findElement(By.xpath("//div[@aria-label='Editable Grid']//button[text()='Outcome Type']")))
						.build().perform();
				actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
				actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
				Thread.sleep(2000);

				actions.click(driver.findElement(By.xpath("//span[contains(text(),'" + s + "')]//parent::label")))
						.build().perform();
				actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();

				Thread.sleep(2000);

				String S1 = driver.findElement(By.xpath("//span[text()='" + s + "']")).getAttribute("textContent");

				// String S1 =
				// driver.findElement(By.xpath("//*[@aria-rowindex="+i+"]//*[@aria-colindex='2']"))
				// .getAttribute("textContent");
				System.out.println("S1 = " + S1);
				System.out.println("s = " + s);
				if (S1.contains(s)) {
					System.out.println("in IF condition");
					// actions.click(driver.findElement(By.xpath("//*[@aria-rowindex='"+i+"']//*[@aria-colindex='1']")))
					// .build().perform();
					actions.click(driver.findElement(By.xpath("//span[text()='" + s + "']"))).build().perform();

					Thread.sleep(2000);
					actions.click(driver.findElement(By.xpath("//li[contains(@id,'Deactivate2')]"))).build().perform();
					Thread.sleep(4000);
					actions.moveToElement(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button")))
							.build().perform();

					actions.click(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button"))).build()
							.perform();
					break;
				} else {
					System.out.println("in else condition");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			actions.click(driver.findElement(By.xpath("//div[@aria-label='Select row 2']"))).build().perform();
//			Thread.sleep(4000);
//			actions.click(driver.findElement(By.xpath("//li[contains(@id,'Deactivate2')]"))).build().perform();
//			Thread.sleep(4000);
//			actions.moveToElement(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button"))).build()
//					.perform();
//
//			actions.click(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button"))).build().perform();
//
////			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button"))));
////			actions.moveToElement(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button"))).build().perform();
////			//testutil.jsclick(driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button")), driver);
////			Wait.untilPageLoadComplete(driver,5);;
////			//testutil.clickOn(driver, driver.findElement(By.xpath("//*[text()='Deactivate']/parent::button")), 3);
////			actions.click(driver.findElement(By.xpath("//span[text()='Deactivate']/parent::button"))).build().perform();
////			//testutil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Deactivate']")), 3);
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Then("user enters the details in {string} section")
	public void user_enters_the_details_in_section(String string) throws IOException {
		outcome_et.EnterDetailsTrainingSection(string);

	}

	@Then("user enters the details in License/ Affiliation/ Registration section")
	public void user_enters_the_details_in_License_Affiliation_Registration_section() throws Exception {
		outcome_et.EnterDetailsLicense_Affiliation_Registration_section();
	}

	@Then("user enter the details in Job Outcome")
	public void user_enter_the_details_in_Job_Outcome() throws Exception {
		dates = outcome_et.enterDetailsJobSection();
	}

	@Then("user enter the details in Rent Account Capture and validate")
	public void user_enter_the_details_in_Rent_Account_Capture() throws Exception {
		outcome_et.enterDetailsRentAccountCaptureSection();
	}

	@Then("user enter the details in Sustainment Checks")
	public void user_enter_the_details_in_Sustainment_Checks() {
		outcome_et.EnterDetailSustainment_ChecksSection();
	}

	@Then("user validates the {string} field is calculated correctly")
	public void user_validates_the_field_is_calculated_correctly(String string) throws Exception {
		try {
			driver.navigate().refresh();

			Date stdate = new SimpleDateFormat("dd/MM/yyyy").parse(dates.get("StartDate"));
			Date enddate = new SimpleDateFormat("dd/MM/yyyy").parse(dates.get("EndDate"));

			long differenceWeek = enddate.getTime() - stdate.getTime();
			int weekscount = (int) (TimeUnit.DAYS.convert(differenceWeek, TimeUnit.MILLISECONDS) / 5);
			// actions.sendKeys(Keys.TAB).build().perform();
			// actions.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			System.out.println("No of weeks are =  " + weekscount);
			Thread.sleep(5000);
			actions.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			actions.sendKeys(Keys.TAB);
			actions.sendKeys(Keys.TAB);
			actions.sendKeys(Keys.PAGE_DOWN);

			actions.moveToElement(driver.findElement(By.xpath("//label[text()='Hourly Rate']"))).build().perform();
			driver.findElement(By.xpath("//input[contains(@aria-label,'Hourly Rate')]")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			for (int i = 1; i <= 20; i++) {
				System.out.println("running for :" + i);
				actions.sendKeys(Keys.TAB).build().perform();
				if (driver.findElements(By.xpath("//label[text()='Number of Weeks Employed']")).size() != 0)

					break;
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// actions.moveToElement(driver.findElement(By.xpath("//label[text()='//label[text()='Job
			// Role Type]']"))).build().perform();

			assertion.CheckAssertion(String.valueOf(weekscount),
					(outcome_et.objNumberofWeeksEmployed.getAttribute("title")));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user vaidates the fields are locked")
	public void user_vaidates_the_fields_are_locked(DataTable datatable) {
		testutil.lockedUnlocked(datatable);
	}

}
