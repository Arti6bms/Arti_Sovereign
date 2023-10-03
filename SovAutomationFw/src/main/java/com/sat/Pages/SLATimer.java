package com.sat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class SLATimer {

	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public SLATimer(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//section[@aria-label='APPLICABLE SLA']/div/div/div/div[1]
	
	@FindBy(xpath = "//*[@aria-label='SLA on Target']")
	public WebElement objSLAonTarget;
	
	@FindBy(xpath = "//select[@aria-label='First Response SLA Status']")
	public WebElement objFirstResponseSLAStatus;
	
	@FindBy(xpath = "//*[contains(@data-lp-id,'First_Response_In')]//following::label[@title='Time remaining to complete the action']")
	public WebElement objFirstResponseIn;	
	
	
	@FindBy(xpath = "//select[@aria-label='Response Time']")
	public WebElement objResponseTime;
	
	
	@FindBy(xpath = "//label[text()='First response in']")
	public WebElement objFirstResponseInLabel;
	
	@FindBy(xpath = "//h2[@title='APPLICABLE SLA']")
	public WebElement objAPPLICABLESLASection;
	
	
	
	@FindBy(xpath = "//div[@id='headerControlsList_2']//div")
	public WebElement objRiskPriority;
	

	@FindBy(xpath = "//input[@aria-label='Score']")
	public WebElement objScore;


	@FindBy(xpath = "//div[contains(@data-id,'po_category')]")
	public WebElement objcategorySelectedRecordList;

	//@FindBy(xpath = "//ul[@data-id='po_category.fieldControl-LookupResultsDropdown_po_category_SelectedRecordList']")
	//public WebElement objcategorySelectedRecordList;
	
	@FindBy(xpath = "//div[contains(@data-id,'po_originalalerter')]")
	public WebElement objoriginalalerterSelectedRecordList;

	//@FindBy(xpath = "//ul[@data-id='po_originalalerter.fieldControl-LookupResultsDropdown_po_originalalerter_SelectedRecordList']")
	//public WebElement objoriginalalerterSelectedRecordList;

	@FindBy(xpath = "//select[@aria-label='1. Is there an immediate danger to customer or others?']")
	public WebElement objInitialRiskPrioritisationQ1;

	@FindBy(xpath = "//select[@aria-label='2. Does the customer need the emergency services?']")
	public WebElement objInitialRiskPrioritisationQ2;

	@FindBy(xpath = "//select[@aria-label='3. Do you believe the person is being abused or neglected by someone else']")
	public WebElement objInitialRiskPrioritisationQ3;

	@FindBy(xpath = "//input[@aria-label='Category, Lookup']")
	public WebElement objCategory;

	@FindBy(xpath = "//input[@aria-label='Original Alerter, Lookup']")
	public WebElement objOriginalAlerter;

	@FindBy(xpath = "//div[@data-id='po_category']")
	public WebElement objCategoryField;

	@FindBy(xpath = "//li[@aria-label='Full Risk Prioritisation']")
	public WebElement objTabFullRiskPrioritisation;
	
	@FindBy(xpath = "//select[@aria-label='Triage Assessment Complete']")
	public WebElement objTriageAssessmentComplete;
	
	
	@FindBy(xpath = "//input[@aria-label='TA Score']")
	public WebElement objTAScore;
	
	@FindBy(xpath = "//span[text()='Customer']")
	public WebElement objCategoryItemCustomer;

	@FindBy(xpath = "//span[text()='Contractor']")
	public WebElement objOriginalAlerterItemContractor;

	@FindBy(xpath = "//select[@aria-label='Safeguarding Type Category']")
	public WebElement objSafeguardingTypeCategory;

	@FindBy(xpath = "//select[@aria-label='Safeguarding Case Category']")
	public WebElement objSafeguardingCaseCategory;

	public String Select_LookUpValue(WebElement eFieldname, WebElement eFieldValue,
			WebElement eRecordList, String fieldValue) throws Exception {
		Thread.sleep(1000);
		action.moveToElement(eRecordList).build().perform();
		Thread.sleep(1000);
		String type = (eFieldname.getAttribute("textContent"));
		System.out.println("fieldValue  = " + type);
		if (!type.contains("Lookup")) {
			Thread.sleep(1000);
			eFieldname.click();
			eFieldname.sendKeys(fieldValue);
			eFieldValue.click();
		} else {
			Thread.sleep(1000);
			action.moveToElement(eRecordList).build().perform();
			Thread.sleep(1000);
			action.click(driver.findElement(By.xpath("//button[@aria-label='Delete" + fieldValue + "']"))).build()
					.perform();
			Thread.sleep(1000);
			eFieldname.click();
			Thread.sleep(1000);
			eFieldname.sendKeys(fieldValue);
			Thread.sleep(1000);
			eFieldValue.click();
		}

		return eRecordList.getAttribute("textContent");
	}

}
