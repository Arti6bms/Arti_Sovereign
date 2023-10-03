package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class GenericCases {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	String listofvalues;
	SLATimer slatimer = new SLATimer(driver);
	Optimization omptimization = new Optimization(driver);
	Assertions assertion = new Assertions(driver);
	HashMap<String, String> maps = new HashMap<String, String>();

	@FindBy(xpath = "//ul[@aria-label='Connection Commands']")
	public WebElement objMoreCommands;

	@FindBy(xpath = "//button[@aria-label='New Connection']")
	public WebElement objNewConnection;

	@FindBy(xpath = "//select[@aria-label='ASB Case Category']")
	public WebElement objASBCaseCategory;

	@FindBy(xpath = "//select[@aria-label='HIT Case Types']")
	WebElement objHITCaseTypes;

	@FindBy(xpath = "//select[@aria-label='PEEPs Type']")
	WebElement objPeepsType;

	@FindBy(xpath = "//select[@aria-label='Region']")
	WebElement objRegion;

	@FindBy(xpath = "//button[@aria-label='Search records for Original Alerter, Lookup field'] | //input[contains(@aria-label,'Original Alerter, Lookup')]") 
	// input[contains(@aria-label,'Original Alerter, Lookup')]")
	WebElement objOriginalAlerterLookup;

	@FindBy(xpath = "//ul[@aria-label='Lookup results']")
	WebElement objLookupresults;

	@FindBy(xpath = "//input[contains(@aria-label,'Case Closure Reason, Lookup')]")
	WebElement objCaseClosureReasonLookup;

	@FindBy(xpath = "//input[@aria-label='Case Title']")
	WebElement labelCaseTitle;
	@FindBy(xpath = "//input[@aria-label='Case Number']")
	WebElement labelCaseNumber;

	@FindBy(xpath = "//*[text()='New Case']")
	WebElement newCases;
	@FindBy(xpath = "//input[@aria-label='Customer, Lookup']")
	WebElement customer;
	@FindBy(xpath = "//span[text()='Julie Utting']")
	WebElement customerName;
	@FindBy(xpath = "//input[@aria-label='Category, Lookup']")
	WebElement category;
	@FindBy(xpath = "//li[@aria-label='CAT-01002, Building (Dwelling)']")
	WebElement categoryName;
	@FindBy(xpath = "//input[@aria-label='Subcategory, Lookup']")
	WebElement subcategory;
	@FindBy(xpath = "//li[@aria-label='CAT-01024, Adaptations']")
	WebElement subcategoryName;
	@FindBy(xpath = "//textarea[@aria-label='Description']")
	WebElement description;
	@FindBy(xpath = "//button[@aria-label='More Header Fields']")
	WebElement openActivity;
	@FindBy(xpath = "//select[@aria-label='Risk Priority']")
	WebElement riskPriority;
	@FindBy(xpath = "//div[@aria-label='Status']/span")
	WebElement status;
	@FindBy(xpath = "//li[text()='In Progress']")
	WebElement statudValue;
	@FindBy(xpath = "//div[contains(@title,'Housing Advice and Resolution Service')]")
	WebElement ownerName;
	@FindBy(xpath = "(//*[text()='Active'])[1]")
	WebElement mouseHover;
	@FindBy(xpath = "(//button[@title='Close Activity'])[1]")
	WebElement closeActivity;
	@FindBy(xpath = "//span[contains(@class,'symbolFont ChevronDownMed-symbol  ')]")
	WebElement dashboardDropDownList;
	@FindBy(xpath = "//*[text()='Assign']/parent::button")
	WebElement assignButton;
	@FindBy(xpath = "//div[@aria-label='Select a queue filter']")
	WebElement userDropDown;
	@FindBy(xpath = "//li[text()='<East Housing Response>']")
	WebElement selectUser;
	@FindBy(xpath = "(//a[@title='Open Record'])[1]")
	WebElement openRecord;
	@FindBy(xpath = "//button[@aria-label='Mark Complete']")
	WebElement markComplete;
	@FindBy(xpath = "//select[@aria-label='Safeguarding Type Category']")
	WebElement safeguardingType;
	@FindBy(xpath = "//select[@aria-label='Safeguarding Case Category']")
	WebElement safeguardingCase;

	public GenericCases(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public String checkIsblank(WebElement e) {
		// return (e.getAttribute("innerText").isBlank());
		return (e.getAttribute("innerText"));
	}

	public String getInnertext(WebElement e) {
		return (e.getAttribute("innerText"));
	}

	public void moveToElement(WebElement e) {
		action.moveToElement(e).build().perform();
	}

	public String getTextContent(WebElement e) {
		return (e.getAttribute("innerText"));
	}

	public String read_list_items(String listName) throws InterruptedException {

		System.out.println("list checking is = " + listName);
		switch (listName) {
		case "Case Closure Reason":
			try {

				System.out.println("in side Case Closure Reason");
				// Thread.sleep(2000);
				objCaseClosureReasonLookup.click();
				// Thread.sleep(2000);
				driver.findElement(
						By.xpath("//button[@aria-label='Search records for Case Closure Reason, Lookup field']"))
						.click();
				// Thread.sleep(2000);
				listofvalues = objLookupresults.getAttribute("innerText");

				// driver.findElement(By.xpath("//div[@aria-label='Summary']")).click();

				System.out.println(listofvalues);
				action.sendKeys(Keys.ESCAPE).build().perform();
				action.sendKeys(Keys.TAB).build().perform();
				System.out.println("End Case Closure Reason");
			} catch (Exception e) {
			}
			return listofvalues;

		case "Original Alerter":
			System.out.println("in side Original Alerter");
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
			objOriginalAlerterLookup.click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElements(By.xpath("//button[@aria-label='Search records for Original Alerter, Lookup field']"))
					.get(0).click();
			Wait.untilPageLoadComplete(driver, 500);
			listofvalues = objLookupresults.getAttribute("innerText");
			System.out.println(listofvalues);
			return listofvalues;

		case "PEEPs Type":
			Wait.untilPageLoadComplete(driver, 500);
			objPeepsType.click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElements(By.xpath("//select[@aria-label='PEEPs Type']")).get(0).click();
			Wait.untilPageLoadComplete(driver, 500);
			listofvalues = objLookupresults.getAttribute("innerText");
			System.out.println(listofvalues);
			return listofvalues;

		case "HIT Case Types":
			Wait.untilPageLoadComplete(driver, 500);
			objHITCaseTypes.click();
			Wait.untilPageLoadComplete(driver, 1000);
			listofvalues = driver.findElement(By.xpath("//select[@aria-label='HIT Case Types']"))
					.getAttribute("outerText");
			System.out.println(listofvalues);
			return listofvalues;
		case "Q4. How often is this happening?":
			// Wait.untilPageLoadComplete(driver, 1000);
			System.out.println("How often is this happening case");
			// omptimization.objHowOftenisThisHappening.click();
			return omptimization.objHowOftenisThisHappening.getAttribute("innerText");
		case "Q10. What have you tried before calling us?":
			Thread.sleep(2000);
			action.sendKeys(Keys.TAB).build().perform();
			System.out.println("What have you tried before calling us");
			action.moveToElement(omptimization.objHaveYouCalledUsBeforeAboutThis).build().perform();
			Wait.untilPageLoadComplete(driver, 2000);
			testutil.selectByVisibleText(driver, omptimization.objHaveYouCalledUsBeforeAboutThis, "Yes");
			omptimization.objWhatHaveYouTriedBeforeCallingUs.click();
			driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
			String exp = driver.findElement(By.xpath("//div[@class='msos-selection-container']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return exp;
		case "Q12. Agreed Actions":
			Wait.untilPageLoadComplete(driver, 500);
			Thread.sleep(2000);
			System.out.println("Agreed Actions");
			action.click(driver.findElement(By.xpath("//div[@aria-controls='po_agreedactions_i']"))).build().perform();
			driver.findElement(
					By.xpath("//div[@aria-controls='po_agreedactions_i']//button[@aria-label='Toggle menu']")).click();
			String expv = driver
					.findElement(By.xpath(
							"//div[@aria-controls='po_agreedactions_i']//div[@class='msos-selection-container']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expv;
		case "Q15a Does the Customer have Additional Needs":
			Wait.untilPageLoadComplete(driver, 500);
			System.out.println("in Does the Customer have additional needs");
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			action.moveToElement(driver.findElement(By.xpath("//label[contains(text(),'Q15')]"))).build().perform();
			testutil.selectByVisibleText(driver, omptimization.objCustomerHaveAdditionalNeedstoConsider, "Yes");
			Thread.sleep(2000);
			// assertion.CheckAssertionTrue(driver.findElement(By.xpath("//label[contains(text(),'Does
			// the Customer have additional needs')]")).isDisplayed());

			if (driver.findElement(By.xpath("//label[contains(text(),'Does the Customer have additional needs')]"))
					.isDisplayed()) {
				driver.findElement(By.xpath(
						"//div[@aria-controls='po_doesthecustomerhaveadditionalneeds_i']//button[@aria-label='Toggle menu']"))
						.click();
			}
			String expQ15a = driver.findElement(By.xpath(
					"//div[@aria-controls='po_doesthecustomerhaveadditionalneeds_i']//div[@class='msos-selection-container']"))
					.getAttribute("innerText");
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expQ15a;
		case "Response Time":
			Wait.untilPageLoadComplete(driver, 500);
			System.out.println("Response Time");
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			driver.findElement(By.xpath("(//select[@aria-label='Response Time'])[2]")).click();
			String expResponseTime = driver.findElement(By.xpath("//select[@aria-label='Response Time']"))
					.getAttribute("innerText");
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expResponseTime;
		case "Select Characteristic":
			Wait.untilPageLoadComplete(driver, 500);
			System.out.println("Select Characteristic");
			testutil.selectByVisibleText(driver, omptimization.objIsThisaProtectedCharacteristic, "Yes");
			driver.findElement(By.xpath("//input[@aria-label='Select Characteristic']")).click();
			driver.findElement(
					By.xpath("//div[@aria-controls='po_targetedreason_i']//button[@aria-label='Toggle menu']")).click();
			String expCharec = driver.findElement(By.xpath(
					"//div[@aria-controls='po_targetedreason_i']//ul[@aria-labelledby='po_targetedreasonmsos-no-of-Items']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expCharec;
		case "Action Plan":
			Wait.untilPageLoadComplete(driver, 500);
			String ExpActionPlan = driver.findElement(By.xpath("//div[@aria-label='Action Plan']"))
					.getAttribute("innerText");
			return ExpActionPlan;
		case "Action Plan Customer Requirements":
			Wait.untilPageLoadComplete(driver, 500);
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			action.moveToElement(driver.findElement(By.xpath("//h2[text()='Action Plan Customer Requirements']")))
					.build().perform();
			String ExpActionPlanCustomerRequirements = driver
					.findElement(By.xpath("//section[@aria-label='Action Plan Customer Requirements']"))
					.getAttribute("innerText");
			return ExpActionPlanCustomerRequirements;
		case "Action Plan Sovereign Requirements":
			Wait.untilPageLoadComplete(driver, 500);
			String ExpActionPlanSovereignRequirements = driver
					.findElement(By.xpath("//section[@aria-label='Action Plan Sovereign Requirements']"))
					.getAttribute("innerText");
			return ExpActionPlanSovereignRequirements;			
		case "ASB Case Category":
			Thread.sleep(4000);
			driver.findElement(By.xpath("//select[@aria-label='ASB Case Category']"))
					.click();
			Thread.sleep(2000);
			String expASBCaseCategory = driver
					.findElement(By.xpath("//select[@aria-label='ASB Case Category']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expASBCaseCategory;
		case "ASB Type":
			Thread.sleep(4000);
			driver.findElement(By.xpath("//select[@aria-label='ASB Type']"))
					.click();
			Thread.sleep(2000);
			String expASBType = driver
					.findElement(By.xpath("//select[@aria-label='ASB Type']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expASBType;
		case "Case Story Option":
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='po_casestoryoption_ledit']")).click();
			driver.findElement(By.xpath("//input[@id='po_casestoryoption_ledit']")).click();
			driver.findElement(By.xpath("//input[@id='po_casestoryoption_ledit']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@aria-label='Case Story Option']//button[@aria-label='Toggle menu']"))
					.click();
			Thread.sleep(2000);
			String expCaseStoryOption = driver
					.findElement(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']"))
					.getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expCaseStoryOption;
		// input[@id='po_casestoryoption_ledit']//*[@class="msos-caret-container"]//*[@aria-label='Toggle
		// menu']
		case "Contact Details":
			Thread.sleep(2000);
			action.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			action.sendKeys(Keys.TAB);
			action.moveToElement(driver.findElement(By.xpath("//label[text()='URN']"))).build().perform();
			Thread.sleep(2000);
			// action.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(2000);
			return driver.findElement(By.xpath("//section[@aria-label='Contact Details']")).getAttribute("textContent");
		case "Pre Applicant Details":
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.xpath("//h2[@title='Pre Applicant Details']"))).build()
					.perform();
			action.moveToElement(driver.findElement(By.xpath("//label[text()='City']"))).build().perform();
			action.moveToElement(driver.findElement(By.xpath("//label[text()='Country']"))).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Pre Applicant Details']"))
					.getAttribute("textContent");
		case "Ethnicity":

			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.xpath("//label[text()='Income']"))).build().perform();
			new WebDriverWait(driver, 10).until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//select[@aria-label='Ethnicity ']"))));
			return driver.findElement(By.xpath("//select[@aria-label='Ethnicity ']")).getAttribute("textContent");
		case "Preferred Language":
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.xpath("//select[@aria-label='Ethnicity ']"))).build().perform();
			return driver.findElement(By.xpath("//select[@aria-label='Preferred Language']"))
					.getAttribute("textContent");

		case "Religion":
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.xpath("//select[@aria-label='Preferred Language']"))).build()
					.perform();
			return driver.findElement(By.xpath("//select[@aria-label='Religion ']")).getAttribute("textContent");
		case "Sexuality":
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.xpath("//select[@aria-label='Religion ']"))).build().perform();
			return driver.findElement(By.xpath("//select[@aria-label='Sexuality']")).getAttribute("textContent");
		case "MARKETING":
			return driver.findElement(By.xpath("//section[@aria-label='MARKETING']")).getAttribute("textContent");
		case "Reason for Referral":
			return driver.findElement(By.xpath("//select[@aria-label='Reason for Referral']"))
					.getAttribute("textContent");
		case "Contact Information":
			return driver.findElement(By.xpath("//section[@aria-label='Contact Information']"))
					.getAttribute("textContent");
		case "Sector Choices":
			action.moveToElement(driver.findElement(By.xpath("//h2[@title='Sector Choices']"))).build().perform();
			Thread.sleep(4000);
			return driver.findElement(By.xpath("//section[@aria-label='Sector Choices']")).getAttribute("textContent");
		case "Contract Type":
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Contract Type']")).getAttribute("textContent");
		case "Sensitive Information":
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Sensitive Information']"))
					.getAttribute("textContent");
		case "Background Information":
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Background Information']"))
					.getAttribute("textContent");
		case "Rent Account Capture":
			action.sendKeys(Keys.CONTROL, Keys.END).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Rent Account Capture']"))
					.getAttribute("textContent");
		case "Wellbeing Outcome":
			return driver.findElement(By.xpath("//section[@aria-label='Wellbeing Outcome']"))
					.getAttribute("textContent");
		case "Outcome Details":
			return driver.findElement(By.xpath("//section[@aria-label='Outcome Details']")).getAttribute("textContent");
		case "Training Outcome":
			action.moveToElement(
					driver.findElement(By.xpath("//label[text()='Claim Training Outcome on Skills For Work']"))).build()
					.perform();
			Thread.sleep(2000);
			return driver.findElement(By.xpath("//section[@aria-label='Training Outcome']"))
					.getAttribute("textContent");
		case "Next Outcome Details":
			return driver.findElement(By.xpath("//section[@aria-label='Outcome Details']")).getAttribute("textContent");
		case "License/ Affiliation/ Registration":
			return driver.findElement(By.xpath("//section[@aria-label='License/ Affiliation/ Registration']"))
					.getAttribute("textContent");
		case "Outcome Type":
			return driver.findElement(By.xpath("//section[@aria-label='Outcome Type']")).getAttribute("textContent");
		case "Job Outcome":
			action.sendKeys(Keys.CONTROL, Keys.PAGE_DOWN).build().perform();
			action.moveToElement(driver.findElement(By.xpath("//label[text()='Job Role Type']"))).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Job Outcome']")).getAttribute("textContent");
		case "Sustainment Checks":
			action.sendKeys(Keys.CONTROL, Keys.DOWN).build().perform();
			return driver.findElement(By.xpath("//section[@aria-label='Sustainment Checks']"))
					.getAttribute("textContent");
		case "Details":
			return driver.findElement(By.xpath("//section[@aria-label='Details']")).getAttribute("textContent");
		case "Contact Other Agencies":
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='po_contactotheragenc_ledit']")).click();
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//div[@aria-label='Contact Other Agencies']//button[@aria-label='Toggle menu']")).click();
			Thread.sleep(2000);
			String expContactOtherAgencies = driver
					.findElement(By.xpath("(//div[@class='msos-selection-container'])[1]")).getAttribute("innerText");
			Thread.sleep(2000);
			action.sendKeys(Keys.ESCAPE).build().perform();
			return expContactOtherAgencies;
		case "ASSET DETAILS":
			return driver.findElement(By.xpath("//section[@aria-label='ASSET DETAILS']")).getAttribute("textContent");
		case "ASSET DETAILS - Property Restrictions":
			return driver.findElement(By.xpath("//section[@aria-label='ASSET DETAILS - Property Restrictions']")).getAttribute("textContent");
		case "Property Sales":
			return driver.findElement(By.xpath("//section[@aria-label='Property Sales']")).getAttribute("textContent");
		default:
			return listofvalues;

		}
		// return listofvalues;
	}

	public void clickOndashboardDropDownList() {

		try {
			dashboardDropDownList.click();
		} catch (Exception e) {
		}
		;

		Wait.untilPageLoadComplete(driver, 500);
	}

	public void validateuser() {
		try {
			assignButton.click();
		} catch (Exception e) {
		}
		;
		Wait.untilPageLoadComplete(driver, 500);
	}

	public void validateCaseNotification() {
		try {
			userDropDown.click();

			Wait.untilPageLoadComplete(driver, 500);
			selectUser.click();
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void closeActivity() throws InterruptedException {
		try {
			Wait.untilPageLoadComplete(driver, 500);
			action.moveToElement(mouseHover).build().perform();
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 500);
			// wait.until(ExpectedConditions.elementToBeClickable(openRecord));
			testutil.jsclick(closeActivity, driver);
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		;
	}

	public void selectStateAndStatus(String state, String status) throws InterruptedException {
		try {
			testutil.selectOptionUsingValue(driver, state);
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
			testutil.selectOptionUsingValue(driver, status);
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 200);
			driver.findElement(By.xpath("//*[text()='Close Appointment']/parent::button")).click();
			Wait.untilPageLoadComplete(driver, 500);
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		;
	}

	public void selectState(String state) throws InterruptedException {
		try {
			Wait.untilPageLoadComplete(driver, 200);

			testutil.selectOptionUsingValue(driver, state);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//*[text()='Close Appointment']/parent::button")).click();
			Wait.untilPageLoadComplete(driver, 500);
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		;

	}

	public void openAppointmentAndVerify() throws InterruptedException {
		try {
			WebElement mouseHover = driver.findElement(By.xpath("(//*[text()='Closed'])[1]"));
			Wait.untilPageLoadComplete(driver, 500);
			action.moveToElement(mouseHover).build().perform();
			Thread.sleep(3000);
			Wait.untilPageLoadComplete(driver, 500);
			testutil.jsclick(openRecord, driver);
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
//     WebElement message=driver.findElement(By.xpath("//*[text()='Read-only  This record’s status: Canceled']"));
//    Assert.assertEquals(message.getText(),"Read-only  This record’s status: Canceled");
//    //Assert.assertEquals(message.getText(),(message.getText().contains("Read-only  This record’s status: Canceled")));
//    Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@title='Go back']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		;

	}

	public void validateText(String text) throws InterruptedException {
		try {
			SoftAssert softassert = new SoftAssert();

			List<WebElement> actualText = driver.findElements(By.xpath("//*[text()='" + text + "']"));
			Wait.untilPageLoadComplete(driver, 500);
			softassert.assertTrue(!actualText.isEmpty(), "The text " + text + " is present");
			driver.findElement(By.xpath("//button[@title='Go back']")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		;

	}

	public void clearCaseMonitoredAndManager() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//*[text()='CASE DETAILS']")).click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
					Keys.PAGE_DOWN, Keys.PAGE_DOWN);
			Wait.untilPageLoadComplete(driver, 500);
			WebElement monitored = driver.findElement(By.xpath("//select[@aria-label='Case Monitored']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", monitored);
			monitored.click();
			Wait.untilPageLoadComplete(driver, 500);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//select[@aria-label='Case Monitored']//*[text()='Yes']")).click();
			WebElement manager = driver.findElement(By.xpath("//div[text()='Berni Tomkins']"));
			action.moveToElement(manager).build().perform();
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//button[@aria-label='Delete Berni Tomkins']")).click();
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void selectCaseMonitoredAndManager() {
		try {
			WebElement monitored = driver.findElement(By.xpath("//select[@aria-label='Case Monitored']"));
			monitored.click();
			Wait.untilPageLoadComplete(driver, 500);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//select[@aria-label='Case Monitored']//*[text()='Yes']")).click();
			Wait.untilPageLoadComplete(driver, 500);
			Wait.untilPageLoadComplete(driver, 500);
			WebElement manager = driver.findElement(By.xpath("//input[@aria-label='Manager, Lookup']"));
			manager.click();
			Wait.untilPageLoadComplete(driver, 500);
			manager.sendKeys("Berni Tomkins");
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//*[text()='Berni Tomkins']")).click();
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;

	}

	public void enterOutcomeAndComplete() throws InterruptedException {
		try {
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[text()='Refresh']")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Wait.untilPageLoadComplete(driver, 500);
			action.moveToElement(mouseHover).build().perform();
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 500);
			// wait.until(ExpectedConditions.elementToBeClickable(openRecord));
			testutil.jsclick(openRecord, driver);
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//textarea[@aria-label='Outcome']")).sendKeys("test");
			Thread.sleep(2000);
			markComplete.click();
			Thread.sleep(5000);
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;

	}

	public void refreshPage() throws InterruptedException {
		try {
			Thread.sleep(9000);
			driver.navigate().refresh();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		;
	}

	public void verifyCaseMonitoredAsNo() throws InterruptedException {
		try {
			Thread.sleep(9000);
			driver.findElement(By.xpath("//*[text()='Refresh']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[text()='CASE DETAILS']")).click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
					Keys.PAGE_DOWN, Keys.PAGE_DOWN);
			Wait.untilPageLoadComplete(driver, 500);
			WebElement monitored = driver.findElement(By.xpath("//select[@aria-label='Case Monitored']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", monitored);
			String caseMonitored = monitored.getAttribute("title");
			Wait.untilPageLoadComplete(driver, 500);
			System.out.println("Case Monitored :- " + caseMonitored);
			Assert.assertTrue(caseMonitored.contains("No"));
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void clickOnNewCases() throws InterruptedException {
		try {
			testutil.jsclick(newCases, driver);
			Thread.sleep(2000);
			
		} catch (Exception e) {
		}
		;
	}

	public void enterMandatoryFields() {
		customer.click();
		Wait.untilPageLoadComplete(driver, 500);
		customer.sendKeys("Julie Utting");
		Wait.untilPageLoadComplete(driver, 500);
		customerName.click();
		Wait.untilPageLoadComplete(driver, 500);
		category.click();
		Wait.untilPageLoadComplete(driver, 500);
		category.sendKeys("CAT-01002");
		Wait.untilPageLoadComplete(driver, 500);
		categoryName.click();
		Wait.untilPageLoadComplete(driver, 500);
		subcategory.click();
		Wait.untilPageLoadComplete(driver, 500);
		subcategory.sendKeys("CAT-01024");
		Wait.untilPageLoadComplete(driver, 500);
		subcategoryName.click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN);
		Wait.untilPageLoadComplete(driver, 500);
		description.sendKeys("Test");
		Wait.untilPageLoadComplete(driver, 500);
	}

	public void enterCategorySubcategory() {
		try {
			customer.click();
			Wait.untilPageLoadComplete(driver, 500);
			customer.sendKeys("Julie Utting");
			Wait.untilPageLoadComplete(driver, 500);
			customerName.click();
			Wait.untilPageLoadComplete(driver, 500);
			category.click();
			Wait.untilPageLoadComplete(driver, 500);
			category.sendKeys("Customer ");
			Wait.untilPageLoadComplete(driver, 500);
			categoryName.click();
			Wait.untilPageLoadComplete(driver, 500);
			subcategory.click();
			Wait.untilPageLoadComplete(driver, 500);
			subcategory.sendKeys("Safeguarding");
			Wait.untilPageLoadComplete(driver, 500);
			subcategoryName.click();
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void enterSafeguardingCaseType() {
		try {
			safeguardingCase.click();
			Wait.untilPageLoadComplete(driver, 500);
			testutil.selectOptionUsingValue(driver, "Adult");
			Wait.untilPageLoadComplete(driver, 500);
			safeguardingType.click();
			testutil.selectOptionUsingValue(driver, "Financial");
			Wait.untilPageLoadComplete(driver, 500);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN);
			Wait.untilPageLoadComplete(driver, 500);
			description.sendKeys("Test");
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void changeRiskPriority() {
		try {
			openActivity.click();
			Wait.untilPageLoadComplete(driver, 500);
			riskPriority.click();
			Wait.untilPageLoadComplete(driver, 500);
			riskPriority.sendKeys("High");
			Wait.untilPageLoadComplete(driver, 500);
			status.click();
			Wait.untilPageLoadComplete(driver, 500);
			statudValue.click();
			Wait.untilPageLoadComplete(driver, 500);
			openActivity.click();
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void validateAutoPostAndCaseTitle() throws InterruptedException {
		try {
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);

			String autopost = driver
					.findElement(By.xpath("//label[contains(@data-id,'notescontrol-timeline_record_header_title')]"))
					.getAttribute("innerText");
			System.out.println(autopost);
			assertion.CheckAssertion(autopost, "Auto-post:");
			// Assert.assertEquals(autopost.getText(), "Auto-post on");

			Wait.untilPageLoadComplete(driver, 500);
			// WebElement caseTitle=
			// driver.findElement(By.xpath("//input[contains(@title,'Adaptations, Julie
			// Utting, 23 Odiham Drive, Newbury, RG14 1GA')]"));
			String caseTitle = driver.findElement(By.xpath("//input[@aria-label='Case Title']")).getAttribute("title");
			System.out.println("Case Title :- " + caseTitle);
			maps.put("casetitle", caseTitle);
			System.out.println("cas Title is - " + caseTitle);
			WebElement heading = driver.findElement(
					By.xpath("//h1[contains(@title,'Adaptations, Julie Utting, 23 Odiham Drive, Newbury, RG14 1GA')]"));
			System.out.println("Heading :- " + heading.getText());
			assertion.CheckAssertionTrue(
					caseTitle.contains("Adaptations, Julie Utting, 23 Odiham Drive, Newbury, RG14 1GA, CAS-"),
					caseTitle);

//			Assert.assertTrue(
//					caseTitle.contains("Adaptations, Julie Utting, 23 Odiham Drive, Newbury, RG14 1GA, CAS-"));
			Wait.untilPageLoadComplete(driver, 500);

			openActivity.click();
			Wait.untilPageLoadComplete(driver, 500);
			assertion.CheckAssertion(ownerName.getText(), "Housing Advice and Resolution Service");
			// Assert.assertEquals(ownerName.getText(), "Housing Advice and Resolution
			// Service");
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void SearchandClickoncontactname() throws InterruptedException {
		System.out.println(maps.get("casetitle"));
		String name = maps.get("casetitle");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name, Keys.ENTER);
		Wait.untilPageLoadComplete(driver, 500);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='" + name + "']"))));
		testutil.jsclick(driver.findElement(By.xpath("//*[text()='" + name + "']")), driver);
		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver, 500);

	}

	public void validateCustomerField(String customerName) {
		try {
			WebElement customer = driver.findElement(By.xpath("//div[text()='Block & Scheme Case Contact']"));
			Wait.untilPageLoadComplete(driver, 500);
			Assert.assertEquals(customer.getText(), customerName);
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void validateHiddenField(DataTable datatable) {
		List<String> actual = datatable.asList();
		// Set implict wait to 0
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			for (int i = 0; i <= actual.size() - 1; i++) {
				System.out.println(actual.get(i));
				// System.out.println(driver.findElements(By.xpath("//span[@title='" +
				// actual.get(i) + "']")).isEmpty());
				assertTrue(driver.findElements(By.xpath("//span[@title='" + actual.get(i) + "']")).isEmpty());
				// Assert.assertNotEquals(actual.get(i),
				// driver.findElements(By.xpath("//span[@title='" + actual.get(i) + "']")));
			}
		} catch (Exception e) {
		}
		// Revert back to default value of implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String getCaseTitleTextValue() throws InterruptedException {
		return labelCaseTitle.getAttribute("title");
	}

	public String getCaseNumberTextValue() throws InterruptedException {
		return labelCaseNumber.getAttribute("title");
	}

	public void validateOwnerName(String actualOwnerName) throws InterruptedException {
		try {
			Wait.implicitwait();
			openActivity.click();
			Wait.implicitwait();
			String exceptedOwnerName = driver.findElement(By.xpath("//div[contains(@title,'" + actualOwnerName + "')]"))
					.getText();
			System.out.println("Owner Name := " + exceptedOwnerName);
			Wait.implicitwait();
			Assert.assertEquals(actualOwnerName, exceptedOwnerName, "Owner Name Mismatch");
			Wait.implicitwait();
		} catch (Exception e) {
		}
		;
	}
	
	public void validateDefaultQueueName(String actualdefaultQueueName) throws InterruptedException {
		try {
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//a[@aria-label='" + actualdefaultQueueName + "')]"))
					.getAttribute("textContent").contains(actualdefaultQueueName)
					|| driver.findElement(By.xpath("//a[@aria-label='" + actualdefaultQueueName + "')]")).getAttribute("textContent")
							.contains(actualdefaultQueueName),
							actualdefaultQueueName);
		} catch (Exception e) {
		}
		;
	}

	public void SelectRelatedTabMenuItem(String tabmenuitem) throws Exception {
		Wait.untilPageLoadComplete(driver, 500);
		Thread.sleep(2000);
		try {
			
			driver.findElement(By.xpath("//div[contains(@aria-label,'Related - Common')]//*[text()='"+tabmenuitem+"']")).click();
			//driver.findElement(By.xpath("//span[text()='" + tabmenuitem + "']")).click();
		} catch (Exception e) {
		}
		;
		Thread.sleep(2000);
	}

	public boolean fieldExistsOrNot(String fieldName) {
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@title='" + fieldName + "']")).isDisplayed();
	}

}
