package com.sat.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class FraudCase {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@FindBy(xpath = "//*[text()='New Connection']")
	WebElement newconnection;
	@FindBy(xpath = "//select[contains(@aria-label,'Fraud Case Category')]")
	WebElement FraudCaseCategory;

	@FindBy(xpath = "//option[text()='Abandonments']")
	WebElement fraudCaseValue;

	@FindBy(xpath = "//span[text()='Audit History']")
	WebElement objAuditHistoryTabmenuItem;

	@FindBy(xpath = "//li[@aria-label='Audit History']")
	WebElement objAuditHistoryTab;

	// @FindBy(xpath = "//li[@aria-label='Summary']")
	@FindBy(xpath = "//li[text()='Summary']")
	// li[text()='Summary']
	WebElement objTabSummary;

	@FindBy(xpath = "//li[@aria-label='Related']")
	WebElement objTabRelated;

	@FindBy(xpath = "//ul[@aria-label='Lookup results']")
	WebElement objLookupresults;

	@FindBy(xpath = "//label[text()='Changed Date']")
	WebElement objChangedDate;

	@FindBy(xpath = "//label[text()='Changed By']")
	WebElement objChangedBy;

	@FindBy(xpath = "//label[text()='Event']")
	WebElement objEvent;

	@FindBy(xpath = "//label[text()='Changed Field']")
	WebElement objChangedField;

	@FindBy(xpath = "//label[text()='Old Value']")
	WebElement objOldValue;

	@FindBy(xpath = "//label[text()='New Value']")
	WebElement objNewValue;

	@FindBy(xpath = "//label[text()='Filter on:']")
	WebElement objFilteron;
	public By fraudCheckListQns = By.xpath("//div[@aria-label='Fraud Check List']//div/div/div/div/select");
	@FindBy(xpath = "//h1[contains(@id,'formHeader')]")
	public WebElement caseTitle;
	@FindBy(xpath = "(//div[contains(@id,'customer')][@aria-label])")
	WebElement getCustomerValue;
	@FindBy(xpath = "(//div[contains(@id,'subcategory')][@aria-label])")
	WebElement getSubCategoryValue;
	@FindBy(xpath = "(//div[contains(@id,'asset.')][@aria-label])")
	WebElement getAssetValue;
	@FindBy(xpath = "//input[@aria-label='Case Number']")
	WebElement getCaseNumber;

	String listofvalues;

	@FindBy(xpath = "//input[contains(@aria-label,'Case Closure Reason, Lookup')]")
	WebElement objCaseClosureReasonLookup;

	@FindBy(xpath = "//button[@aria-label='Search records for Original Alerter, Lookup field']") // input[contains(@aria-label,'Original
																									// Alerter,
																									// Lookup')]")
	WebElement objOriginalAlerterLookup;

	@FindBy(xpath = "//select[@aria-label='PEEPs Type']")
	WebElement objPeepsType;

//  @FindBy(xpath="")
//  WebElement ;

	public FraudCase(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void selectTab(String tab) {
		try {
			Wait.untilPageLoadComplete(driver, 200);
			Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//li[@aria-label='" + tab + "']")), 20);
			driver.findElement(By.xpath("//li[@aria-label='" + tab + "']")).click();
		} catch (Exception e) {
		}
		;
	}

	public String getHeaderTitle() {
		return caseTitle.getAttribute("title");
	}

	public String getCaseTitle() {
		String subCategory = getSubCategoryValue.getAttribute("aria-label");
		String customer = getCustomerValue.getAttribute("aria-label");
		String asset = getAssetValue.getAttribute("aria-label");
		String casenumber = getCaseNumber.getAttribute("title");
		System.out.println(
				"getCaseTitle " + subCategory.concat(",") + customer.concat(",") + asset.concat(",") + casenumber);
		return subCategory.concat(",") + customer.concat(",") + asset.concat(",") + casenumber;
	}

	public String getDate(String field) {
		String date = driver.findElement(By.xpath("//input[@aria-label='" + field + "']")).getAttribute("value");
		return date;
	}

	public void clicOnNewConnection(String action) throws InterruptedException {
		try {
			Wait.untilPageLoadComplete(driver, 500);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='" + action + "']")).click();
			Thread.sleep(3000);
			Wait.untilPageLoadComplete(driver, 200);
		} catch (Exception e) {
		}
		;
	}

	public void selectFraudcategory(String field, String Val) throws InterruptedException {
		try {
			// Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(By.xpath("//*[contains(@aria-label,'" + field + "')]")));
			Wait.untilPageLoadComplete(driver, 500);
			// Thread.sleep(3000);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//select[contains(@aria-label,'" + field + "')]")).click();
			// Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//select[contains(@aria-label,'" + field + "')]")).sendKeys(Val);
			// Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElement(By.xpath("//select[contains(@aria-label,'" + field + "')]")).click();
			// Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 500);
		} catch (Exception e) {
		}
		;
	}

	public void scrollDown() {
		try {
			Wait.untilPageLoadComplete(driver, 200);
		//	driver.findElement(By.xpath("//textarea[@aria-label='Description']")).click();
			Wait.untilPageLoadComplete(driver, 200);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN, Keys.PAGE_DOWN,
					Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN);
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		;
	}

	// Mahesh Code
	public void clickRelatedTab(String tabname) throws Exception {
		Thread.sleep(2000);
		Wait.untilPageLoadComplete(driver);
		System.out.println(tabname);
		try {
			objTabRelated.click();
		} catch (Exception e) {
		}
		;
		Thread.sleep(3000);
	}

	public void SelectTabMenuItem(String tabmenuitem) throws Exception {
		Wait.untilPageLoadComplete(driver);
		Thread.sleep(2000);
		try {
			driver.findElements(By.xpath("//span[text()='" + tabmenuitem + "']")).get(0).click();
		} catch (Exception e) {
		}
		;
		Thread.sleep(2000);
	}

	public Boolean isFilteronFieldDislayed() throws ElementNotVisibleException {
		try {
			// testutil.switchToFrame("audit_iframe");
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='audit_iframe']")));
			Boolean isFieldDisplayed = objFilteron.isDisplayed();
			return isFieldDisplayed;
		} catch (Exception e) {
			return false;
		}
	}

	public Map<String, Boolean> isDatagridFieldDislayed(DataTable data) throws ElementNotVisibleException {
		List<String> gridfieldName = data.asList();
		Map<String, Boolean> lstFields = new HashMap<>();
		first: for (int i = 0; i <= gridfieldName.size() - 1; i++) {
			switch (gridfieldName.get(i)) {
			case "Changed Date":
				System.out.println(gridfieldName.get(i));
				lstFields.put(gridfieldName.get(i), objChangedDate.isDisplayed());
				continue first;
			case "Changed By":
				lstFields.put(gridfieldName.get(i), objChangedBy.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			case "Event":
				lstFields.put(gridfieldName.get(i), objEvent.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			case "Changed Field":
				lstFields.put(gridfieldName.get(i), objChangedField.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			case "Old Value":
				lstFields.put(gridfieldName.get(i), objOldValue.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			case "New Value":
				lstFields.put(gridfieldName.get(i), objNewValue.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			case "New Values":
				lstFields.put(gridfieldName.get(i), objNewValue.isDisplayed());
				System.out.println(gridfieldName.get(i));
				continue first;
			default:
				lstFields.put(gridfieldName.get(i), false);
				continue first;
			}
		}
		return lstFields;
	}

	public void clickSummaryTab(String tabname) throws Exception {
		try {
			Wait.untilPageLoadComplete(driver);
			System.out.println(tabname);
			driver.switchTo().defaultContent();
			objTabSummary.click();
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		;
	}

	public String read_list_items(String listName) throws InterruptedException {
		switch (listName) {
		case "Case Closure Reason":
			objCaseClosureReasonLookup.click();
			driver.findElements(
					By.xpath("//button[@aria-label='Search records for Case Closure Reason, Lookup field']")).get(0)
					.click();
			listofvalues = objLookupresults.getAttribute("innerText");
			System.out.println(listofvalues);

		case "Original Alerter":
			Wait.untilPageLoadComplete(driver, 500);
			objOriginalAlerterLookup.click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElements(By.xpath("//button[@aria-label='Search records for Original Alerter, Lookup field']"))
					.get(0).click();
			Wait.untilPageLoadComplete(driver, 500);
			listofvalues = objLookupresults.getAttribute("innerText");
			System.out.println(listofvalues);

		case "PEEPs Type":
			Wait.untilPageLoadComplete(driver, 500);
			objPeepsType.click();
			Wait.untilPageLoadComplete(driver, 500);
			driver.findElements(By.xpath("//select[@aria-label='PEEPs Type']")).get(0).click();
			Wait.untilPageLoadComplete(driver, 500);
			listofvalues = objLookupresults.getAttribute("innerText");
			System.out.println(listofvalues);

		}
		return listofvalues;
	}

}
