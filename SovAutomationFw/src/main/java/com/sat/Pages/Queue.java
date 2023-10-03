package com.sat.Pages;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class Queue {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	GenericCases genericCases = new GenericCases(driver);
	Assertions assertion = new Assertions(driver);

	WebDriverWait wait = new WebDriverWait(driver, 20);
	String listofvalues;
	boolean ExpectedobjName;
	HashMap<Integer, String> itemsListPickedFromQueue = new HashMap<>();

	@FindBy(xpath = "//div[text()='Select all']")
	public WebElement selectAll;
	// Queue

	public Queue(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[text()='Save']")
	public WebElement objSave;
	@FindBy(xpath = "//input[@aria-label='Regarding, Lookup']")
	public WebElement objRegardingLookupfield;

	// DCP TestCases
	@FindBy(xpath = "//*[@class='symbolFont Edit-symbol pa-vo ']")
	WebElement editDocument;

	@FindBy(xpath = "(//*[@class='symbolFont Attach-symbol pa-cp pa-cl '])[2]")
	WebElement attachDocument;

	@FindBy(xpath = "//button[@aria-label='Save']")
	WebElement saveNote;

//ASBCases-Optimisation

	@FindBy(xpath = "//input[@aria-label='Name']")
	public WebElement objName;

	@FindBy(xpath = "//input[@aria-label='Q1. Tell us what is going on?']")
	public WebElement objTellUsWhatisGoingOn;

	@FindBy(xpath = "//input[contains(@aria-label,'Q2')]")
	public WebElement objWhosInvolved;

	@FindBy(xpath = "//input[@aria-label='Date of Q3. When Did it Start?']")
	public WebElement objWhenDiditStart;

	@FindBy(xpath = "//select[@aria-label='Q4. How often is this happening?']")
	public WebElement objHowOftenisThisHappening;

	@FindBy(xpath = "//input[contains(@aria-label,'Q5')]")
	public WebElement objCanYouThinkWhyThisisHappening;

	@FindBy(xpath = "//select[contains(@aria-label,'Q6')]")
	public WebElement objIsThisaProtectedCharacteristic;

	@FindBy(xpath = "//input[contains(@aria-label,'Q7')]")
	public WebElement objWhoBeenAffectedbyThis;

	@FindBy(xpath = "//select[contains(@aria-label,'Q8')]")
	public WebElement objDoYouHaveAnySupportNeeds;

	@FindBy(xpath = "//select[contains(@aria-label,'Q9')]")
	public WebElement objHaveYouCalledUsBeforeAboutThis;

	@FindBy(xpath = "//select[contains(@aria-label,'Q10')]")
	public WebElement objWhatHaveYouTriedBeforeCallingUs;

	@FindBy(xpath = "//input[contains(@aria-label,'Q11')]")
	public WebElement objWhatDoYouThinkWillSortTheProblem;

	@FindBy(xpath = "//input[contains(@aria-label,'Q12')]")
	public WebElement objAgreedActions;

	@FindBy(xpath = "//input[contains(@aria-label,'Case Story Option')]")
	public WebElement caseStoryOptions;

	@FindBy(xpath = "//button[@aria-label='Toggle menu']")
	public WebElement objAgreedActionsMenu;

	@FindBy(xpath = "(//button[@aria-label='Toggle menu'])")
	public WebElement caseStoryToggleMenu;
	@FindBy(xpath = "//input[@aria-label='Case Number']")
	public WebElement objCaseNumber;

	@FindBy(xpath = "//div[@id='antisocialbehaviour']")
	public WebElement objantisocialbehaviour;
	@FindBy(xpath = "//div[text()='Signpost to agency and close case']")
	public WebElement objAgreedActionsMenuItem;

	@FindBy(xpath = "//select[contains(@aria-label,'Q13')]")
	public WebElement objSafeguardingReferraltobeConsidered;

	@FindBy(xpath = "//select[contains(@aria-label,'Q14')]")
	public WebElement objDAReferralMade;

	@FindBy(xpath = "//select[contains(@aria-label,'Q15')]")
	public WebElement objCustomerHaveAdditionalNeedstoConsider;

	@FindBy(xpath = "//li[contains(@aria-label,'Stage: Triage Assessment')]")
	public WebElement objBPFTriageAssessment;
	@FindBy(xpath = "//button[@aria-label='Next Stage']")
	public WebElement objBPFNextStage;
	@FindBy(xpath = "//select[@aria-label='Action Plan Generated']")
	public WebElement objActionPlanGenerated;
	@FindBy(xpath = "//select[@aria-label='Triage Assessment Complete']")
	public WebElement objTriageAssessmentComplete;
	@FindBy(xpath = "//li[contains(@aria-label,'Stage: Action Plan')]")
	public WebElement objBPFActionPlan;
	@FindBy(xpath = "//div[@id='alertsflags']")
	public WebElement objalertsflagsASB;

	@FindBy(xpath = "//button[@aria-label='More commands for Connection']")
	public WebElement threeDotForConnection;

	public void clickMoreConnection() {
		Wait.untilPageLoadComplete(driver, 500);
		threeDotForConnection.click();
		Wait.untilPageLoadComplete(driver, 500);
	}

	public void clickViewsQueues(WebElement E) throws Exception {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			testutil.jsclick(E, driver);
			//E.click();

		} catch (Exception ee) {
			System.out.println(ee);
		}
	}

	public void selectTemplate(String template) {
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ptm_lookupDialogIframe']")));
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//div[text()='" + template + "']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().defaultContent();

		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		// driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='ClientApiFrame_id-1292']")));
		Wait.untilPageLoadComplete(driver, 500);
		testutil.selectOptionUsingValue(driver, "docx");
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//input[@id='cbxAttach']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		testutil.selectOptionUsingValue(driver, "as note");
		Wait.untilPageLoadComplete(driver, 500);
		// driver.switchTo().defaultContent();

		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Wait.untilPageLoadComplete(driver, 800);
		driver.findElement(By.xpath("//*[text()='Finish']")).click();
		Wait.untilPageLoadComplete(driver, 500);

	}

	public void editDocumet() {
		Wait.untilPageLoadComplete(driver, 500);
		action.moveToElement(editDocument).build().perform();
		Wait.untilPageLoadComplete(driver, 500);
		// wait.until(ExpectedConditions.elementToBeClickable(openRecord));
		testutil.jsclick(editDocument, driver);
		Wait.untilPageLoadComplete(driver, 500);
	}

	public void saveNote() {
		Wait.untilPageLoadComplete(driver, 500);
		saveNote.click();
		Wait.untilPageLoadComplete(driver, 500);
	}
	// ASB Optimization Test Cases

	public void fieldDisable(String field) {
		// boolean
		// value=driver.findElement(By.xpath("//li[text()='"+field+"']")).isDisplayed();

		assertTrue(driver.findElements(By.xpath("//li[text()='" + field + "']")).isEmpty());
//	 if(value)
//		 System.out.println(field+"is display in system");
//	 else
//		 System.out.println(field+"is not display in system");
	}

	public void clickOnAdvanceFind() {
		Wait.untilPageLoadComplete(driver, 800);
		driver.findElement(By.xpath("//button[@aria-label='Advanced Find']")).click();
		Wait.untilPageLoadComplete(driver, 900);
	}

	public void setQueryParameters() throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			Thread.sleep(3000);
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// Select Category

		driver.switchTo().frame("contentIFrame0");
		Wait.untilPageLoadComplete(driver, 500);
		WebElement select = driver.findElement(By.xpath("//span[text()='Select']"));
		action.moveToElement(select).build().perform();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//select[@aria-label='SelectInputBehavior']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		testutil.selectOptionUsingValue(driver, "Category");
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//span[text()='Enter Value']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//img[@title='Click to select a value for Category.']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("InlineDialog_Iframe");
		driver.findElement(By.xpath("//input[@id='crmGrid_findCriteria' and @title='Search for records']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//input[@id='crmGrid_findCriteria' and @title='Search for records']"))
				.sendKeys("Enforcement (legal)");
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//img[@id='crmGrid_findCriteriaImg' and @title='Start search']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//td[@aria-label='Checkbox of Record1 unchecked']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//button[@id='btnAdd']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//button[@id='butBegin']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().defaultContent();

		// Select Sub Category

		driver.switchTo().frame("contentIFrame0");
		Wait.untilPageLoadComplete(driver, 500);
		action.moveToElement(select).build().perform();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("(//select[@aria-label='SelectInputBehavior'])[2]")).click();
		Wait.untilPageLoadComplete(driver, 500);
		// testutil.selectOptionUsingValue(driver,"Subcategory");
		driver.findElement(By.xpath("(//select[@aria-label='SelectInputBehavior'])[2]")).sendKeys("Subcategory");
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("(//select[@aria-label='SelectInputBehavior'])[2]")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//span[text()='Enter Value']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//img[@title='Click to select a value for Subcategory.']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("InlineDialog_Iframe");
		driver.findElement(By.xpath("//input[@id='crmGrid_findCriteria' and @title='Search for records']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//input[@id='crmGrid_findCriteria' and @title='Search for records']"))
				.sendKeys("ASB");
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//img[@id='crmGrid_findCriteriaImg' and @title='Start search']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//td[@aria-label='Checkbox of Record1 unchecked']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//button[@id='btnAdd']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//button[@id='butBegin']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.switchTo().defaultContent();

		// Click on Search Result
		driver.findElement(By.xpath("//a[@id='Mscrm.AdvancedFind.Groups.Show.Results-Large']")).click();
		Wait.untilPageLoadComplete(driver, 500);
	}

	public void clickOnLink() {
//		//tbody[@role='none']//tr[2]//td[3] 
		driver.switchTo().frame("contentIFrame0");
		WebElement link = driver.findElement(By.xpath("//tbody"));
		Wait.untilPageLoadComplete(driver, 2000);
		action.moveToElement(link).build().perform();
		System.out.println("After moving elements");
		Wait.untilPageLoadComplete(driver, 2000);
		driver.switchTo().frame("resultFrame");
		Wait.untilPageLoadComplete(driver, 2000);
		driver.findElement(By.xpath("(//a[@class='ms-crm-List-Link'])[3]")).click();
		Wait.untilPageLoadComplete(driver, 2000);
		driver.switchTo().defaultContent();
	}

	public void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			Wait.untilPageLoadComplete(driver, 2000);
			driver.switchTo().window(winHandle);
		}
		Wait.untilPageLoadComplete(driver, 2000);
		driver.manage().window().maximize();
		Wait.untilPageLoadComplete(driver, 2000);

	}

	public void verifyCheckBox() {
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("(//button[@aria-label='Toggle menu'])")).click();
		Wait.untilPageLoadComplete(driver, 500);

		if ((selectAll).isEnabled()) {
			System.out.println("Multi select Option field is clickable");
		} else {
			System.out.println("Multi select Option field is not clickable");
		}

//		boolean isDisplayed = selectAll.isDisplayed();
//
//		// performing click operation if element is displayed
//		if (isDisplayed == true) {
//			Wait.untilPageLoadComplete(driver,500);
//			selectAll.click();
//			Wait.untilPageLoadComplete(driver,500);
//		}
	}

	public void validateListValues(String string, DataTable dataTable) {
		List<String> expectedDropDownValues = dataTable.asList();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("(//button[@aria-label='Toggle menu'])")).click();
		Wait.untilPageLoadComplete(driver, 500);
		List<WebElement> actualDropDownValues = driver
				.findElements(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']//li//label"));
		for (int i = 0; i <= actualDropDownValues.size() - 1; i++) {
			System.out.println("Actual Values:-" + actualDropDownValues.get(i).getAttribute("title"));
			System.out.println("Expected Values:-" + expectedDropDownValues.get(i));
			Wait.untilPageLoadComplete(driver, 500);
			Assert.assertEquals(actualDropDownValues.get(i).getAttribute("title"), expectedDropDownValues.get(i),
					"Element is not Displayed");
			Wait.untilPageLoadComplete(driver, 500);
		}
	}

//		 public void selectMultipleOptions()
//			{
//			 Wait.untilPageLoadComplete(driver,500);
//				driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
//				Wait.untilPageLoadComplete(driver,500);
////				selectAll.click();
////				Wait.untilPageLoadComplete(driver,500);
//				List<WebElement> actualDropDownValues= driver.findElements(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']//li//label"));
//				for(int i=0;i<=actualDropDownValues.size()-1;i++) {
//					 Wait.untilPageLoadComplete(driver,500);
//					actualDropDownValues.get(i).click();
//					 Wait.untilPageLoadComplete(driver,500);
//					if(i==5) {
//						System.out.println("Multiple options selected");
//						break;
//				}}
////				Wait.untilPageLoadComplete(driver,500);
////				driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
////				Wait.untilPageLoadComplete(driver,500);
//				
//			}
	public void verifyTopFiveOptions() {
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("(//button[@aria-label='Toggle menu'])")).click();
		Wait.untilPageLoadComplete(driver, 500);
		boolean isDisplayed = selectAll.isDisplayed();
		// performing click operation if element is displayed
		if (isDisplayed == true) {
			Wait.untilPageLoadComplete(driver, 500);
			selectAll.click();
			Wait.untilPageLoadComplete(driver, 900);
		}
		Wait.untilPageLoadComplete(driver, 900);
		driver.findElement(By.xpath("(//button[@aria-label='Toggle menu'])")).click();
		Wait.untilPageLoadComplete(driver, 900);
		List<WebElement> actualDropDownValues = driver
				.findElements(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']//li//label"));
		String title = driver.findElement(By.xpath("//div[@class='msos-selecteditems-container']"))
				.getAttribute("title");
		for (int i = 0; i <= actualDropDownValues.size() - 1; i++) {
			Wait.untilPageLoadComplete(driver, 900);
			Assert.assertTrue(title.contains(actualDropDownValues.get(i).getAttribute("title")));
			if (i == 4) {
				System.out.println("Top Five options Verified");
				break;
			}
		}
	}

	public void verifyNumberCount() {
//			 Wait.untilPageLoadComplete(driver,500);
//				driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
//				Wait.untilPageLoadComplete(driver,500);
//					selectAll.click();
//					Wait.untilPageLoadComplete(driver,500);
//				driver.findElement(By.xpath("//button[@aria-label='Toggle menu']")).click();
		Wait.untilPageLoadComplete(driver, 500);
		driver.findElement(By.xpath("//button[contains(@aria-label,'Show')]")).click();
		Wait.untilPageLoadComplete(driver, 500);
		List<WebElement> actualDropDownValues = driver
				.findElements(By.xpath("//ul[@aria-labelledby='po_casestoryoptionmsos-no-of-Items']//li//label"));
		String values = driver.findElement(By.xpath("//ul[@class='msos-selecteditems msos-current-selection-normal']"))
				.getAttribute("innerText");
		for (int i = 0; i <= actualDropDownValues.size() - 1; i++) {
			Assert.assertTrue(values.contains(actualDropDownValues.get(i).getAttribute("title")));
		}
	}

	public String getCaseNumber(WebDriver driver, WebElement element) {
		return element.getAttribute("defaultValue");
	}

	@FindBy(xpath = "//div[@data-id='regardingobjectid.fieldControl-Lookup_regardingobjectid']")
	public WebElement objRegardingfield;

	@FindBy(xpath = "//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']")
	public WebElement objOriginalQueueTitle;

	@FindBy(xpath = "//div[@class='ag-center-cols-container']")
	public WebElement objOriginalQueueItemsContainer;

	@FindBy(xpath = "//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='4']")
	public WebElement objOriginalQueueWorkedBy;

	@FindBy(xpath = "//span[text()='<Resales>']")
	public WebElement objQueueNameLink;

	@FindBy(xpath = "//span[text()='Release']")
	public WebElement objReleaseButton;

	@FindBy(xpath = "//button[@aria-label='Release' and @data-id='confirmButton']")
	public WebElement objReleaseConfirmButton;

	@FindBy(xpath = "//div[@data-id='grid-container' and @role='rowgroup' ]")
	public WebElement objPickedQueueItemsRows1;
	
	@FindBy(xpath = "//div[@data-id='grid-container']")
	public WebElement objPickedQueueItemsRows;
	
	

	@FindBy(xpath = "//button[@title='Go back']")
	public WebElement objGoBack;

	@FindBy(xpath = "//div[@ref='eContainer' and @role='rowgroup' ]")
	public WebElement objQueueItemsRows;

	@FindBy(xpath = "//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='1']")
	public WebElement objSelectPickedItem1;
	
	@FindBy(xpath = "//div[@data-id='grid-container']//div[@aria-RowIndex='2']//div[@aria-colindex='1']")
	public WebElement objSelectPickedItem;

	@FindBy(xpath = "//span[text()='Items I am working on']")
	public WebElement objItemsIamworkingon;

	@FindBy(xpath = "//button[@aria-label='Pick']")
	public WebElement objButtonPick;

	@FindBy(xpath = "//li[@title='More commands for Queue Item']")
	public WebElement objMoreCommandsforQueueItem;

	@FindBy(xpath = "//span[text()='Pick']")
	public WebElement objPick;

	@FindBy(xpath = "//span[@aria-label='Toggle selection of all rows']")
	public WebElement objSelectallRows;
	
	@FindBy(xpath = "//section[@data-id='QueueItems']//input[@aria-label='Toggle selection of all rows']")
	public WebElement objSelectallQueues;
	

	@FindBy(xpath = "//input[@aria-label='Select a queue filter']")
	public WebElement objInputSelectQueueFilter;

	@FindBy(xpath = "//li[@data-text='All Queues']")
	public WebElement objSelectAllQueueinFilter;

	@FindBy(xpath = "//div[@aria-label='Select a queue filter']")
	public WebElement objSelectQueueFilter;

	@FindBy(xpath = "//span[text()='All Items']")
	public WebElement objSelectAllItemsQueue;

	@FindBy(xpath = "//i[@data-icon-name='ChevronDown' and contains(@class,'Button-menuIcon')]")
	public WebElement objMyViews;

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			// ExtentCucumberAdapter.getCurrentStep().info(fnfe);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			// ExtentCucumberAdapter.getCurrentStep().info(ioe);
		} finally {
			fis.close();
		}
		return prop;
	}

	public void clickOnQueue(String Queuename) throws Exception {
		try {
			System.out.println("parameter value is " + Queuename);

			Wait.untilPageLoadComplete(driver);
			driver.findElement(By.xpath("//span[text()='" + Queuename + "']")).click();
			Thread.sleep(3000);
		} catch (Exception ee) {
			System.out.println(ee);
			// ExtentCucumberAdapter.getCurrentStep().info(ee);
		}
	}

	public HashMap<Integer, String> readWorkedbyfield(String userName) throws Exception {

		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			String intRowCount = objQueueItemsRows.getAttribute("childElementCount");
			System.out.println(intRowCount);
			System.out.println("userName is - " + userName);

			int workedBY = Integer.parseInt(intRowCount);

			for (int i = 2; i < workedBY + 2; i++) {
				Thread.sleep(2000);
				itemsListPickedFromQueue.put(i,
						driver.findElement(By.xpath(
								"//div[@ref='eContainer']//div[@aria-RowIndex='" + i + "']//div[@aria-colindex='2']"))
								.getAttribute("textContent"));

				System.out.println("Item :" + itemsListPickedFromQueue.get(i));

				Thread.sleep(3000);

				System.out.println("Worked By = " + driver
						.findElement(By.xpath(
								"//div[@ref='eContainer']//div[@aria-RowIndex='" + i + "']//div[@aria-colindex='4']"))
						.getAttribute("textContent"));

				assertion.CheckAssertion(userName,
						driver.findElement(By.xpath(
								"//div[@ref='eContainer']//div[@aria-RowIndex='" + i + "']//div[@aria-colindex='4']"))
								.getAttribute("textContent"));

				// AssertJUnit.assertEquals(userName,
				// driver.findElement(By.xpath(
				// "//div[@ref='eContainer']//div[@aria-RowIndex='" + i +
				// "']//div[@aria-colindex='4']"))
				// .getAttribute("textContent"));

			}
		} catch (Exception ee) {
			// ExtentCucumberAdapter.getCurrentStep().info(ee);
		}

		return itemsListPickedFromQueue;
	}
}
