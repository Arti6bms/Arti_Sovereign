package com.sat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class Assessment_ET {
	
	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public Assessment_ET(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@aria-label='ETO, Lookup']")
	public WebElement objETO;
	
	@FindBy(xpath = "//button[@aria-label='Finish']")
	public WebElement objBPFFinish;
	
	@FindBy(xpath = "//*[contains(@aria-label,'Stage: Final Assessment')]")
	public WebElement objBPFFinalAssessment;
	
	@FindBy(xpath = "//*[contains(@aria-label,'Stage: Initial Assessment')]")
	public WebElement objBPFInitialAssessment;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Final Assessment Complete')]")
	public WebElement objFinalAssessmentComplete;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Initial Assessment Complete')]")
	public WebElement objInitialAssessmentComplete;
	
	@FindBy(xpath = "//span[text()='Abdoulie Jeng']")
	public WebElement objETOItemvalue;
	
	@FindBy(xpath = "//div[contains(@data-id,'po_eto')]")
	public WebElement objetoSelectedRecordList;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Lone Parent')]")
	public WebElement objLoneParent;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Reason for Enrolment')]")
	public WebElement objReasonforEnrolment;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Safeguarding Statement Read')]")
	public WebElement objSafeguardingStatementRead;
	
	@FindBy(xpath = "//select[contains(@aria-label,'Demographic Info Captured for ActiveH')]")
	public WebElement objDemographicInfoCapturedforActiveH;
	
	@FindBy(xpath = "//input[@aria-label='Contact Type, Lookup']")
	public WebElement objContactType;
	
	@FindBy(xpath = "//span[text()='New Contact']")
	public WebElement objNewContactItem;
	
	@FindBy(xpath = "//div[contains(@data-id,'po_contacttype')]")
	public WebElement objcontacttypeSelectedRecordList;
	

}
