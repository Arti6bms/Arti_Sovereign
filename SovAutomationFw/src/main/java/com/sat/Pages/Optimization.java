package com.sat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class Optimization {

	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	Testutil testutil = new Testutil(driver);

	@FindBy(xpath = "//input[@aria-label='Name']")
	public WebElement objName;

	@FindBy(xpath = "//textarea[@aria-label='Q1. Tell us what is going on?']")
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
	
	@FindBy(xpath = "//input[@aria-label='Select Characteristic']")
	public WebElement objSelectCharacteristic;
	
	

	@FindBy(xpath = "//input[contains(@aria-label,'Q7')]")
	public WebElement objWhoBeenAffectedbyThis;

	@FindBy(xpath = "//select[contains(@aria-label,'Q8')]")
	public WebElement objDoYouHaveAnySupportNeeds;

	@FindBy(xpath = "//select[contains(@aria-label,'Q9')]")
	public WebElement objHaveYouCalledUsBeforeAboutThis;

	@FindBy(xpath = "//input[contains(@aria-label,'Q10')]")
	public WebElement objWhatHaveYouTriedBeforeCallingUs;

	@FindBy(xpath = "//input[contains(@aria-label,'Q11')]")
	public WebElement objWhatDoYouThinkWillSortTheProblem;

	@FindBy(xpath = "//input[contains(@aria-label,'Q12')]")
	public WebElement objAgreedActions;

	@FindBy(xpath = "//input[contains(@aria-label,'Case Story Option')]")
	public WebElement objCaseStoryOption;

	@FindBy(xpath = "//select[contains(@aria-label,'Triage Assessment Complete')]")
	public WebElement objTriageAssessmentComplete;

	@FindBy(xpath = "//select[@aria-label='Action Plan Generated']")
	public WebElement objActionPlanGenerated;
	
	@FindBy(xpath = "//select[@aria-label='Case Story Generated']")
	public WebElement objCaseStoryGenerated;

	@FindBy(xpath = "//button[@aria-label='Toggle menu']")
	public WebElement objAgreedActionsMenu;
	
	@FindBy(xpath = "//div[@aria-label='Q12. Agreed Actions']//button[@aria-label='Toggle menu']")
	public WebElement objAgreedActionsToggleMenu;
	
	@FindBy(xpath = "//div[@aria-label='Q15a. Does the Customer have additional needs']//button[@aria-label='Toggle menu']")
	public WebElement obj15aToggleMenu;
	
	@FindBy(xpath = "//div[@aria-label='Q10. What have you tried before calling us?']//button[@aria-label='Toggle menu']")
	public WebElement obj10ToggleMenu;	

	@FindBy(xpath = "//div[text()='Signpost to agency and close case']")
	public WebElement objAgreedActionsMenuItem;
	
	@FindBy(xpath = "//div[text()='Refer to Coaching (HO/ASBO)']")
	public WebElement objAgreedActionsNew;
	
	@FindBy(xpath = "//div[text()='GP Support']")
	public WebElement obj15a;
	
	
	@FindBy(xpath = "//div[text()='Contacted Police']")
	public WebElement obj10;
	
	@FindBy(xpath = "//div[text()='Select all']")
	public WebElement objSelectall;

	@FindBy(xpath = "//div[text()='Select all']")
	public WebElement objcaseOptionMenuItemSelectAll;

	@FindBy(xpath = "//select[contains(@aria-label,'Q13')]")
	public WebElement objSafeguardingReferraltobeConsidered;

	@FindBy(xpath = "//select[contains(@aria-label,'Q14')]")
	public WebElement objDAReferralMade;

	@FindBy(xpath = "//select[contains(@aria-label,'Q15')]")
	public WebElement objCustomerHaveAdditionalNeedstoConsider;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Q15a')]")
	public WebElement objDoestheCustomerhaveadditionalneeds;	


	@FindBy(xpath = "//*[contains(@aria-label,'Stage: Triage Assessment')]")
	public WebElement objBPFTriageAssessment;

	@FindBy(xpath = "//*[contains(@aria-label,'Stage: Action Plan')]")
	public WebElement objBPFActionPlan;

	@FindBy(xpath = "//button[@aria-label='Next Stage']")
	public WebElement objBPFNextStage;

	@FindBy(xpath = "//button[@aria-label='More commands for ASB Incident']")
	public WebElement objMoreCommandsforASBIncident;

	@FindBy(xpath = "//button[@aria-label='New Action. Add New Action']")
	public WebElement objButtonNewAction;

	@FindBy(xpath = "//input[@aria-label='Action']")
	public WebElement objAction;

	@FindBy(xpath = "//button[contains(@title,'Add New ASB Incident')]")
	public WebElement objAddNewASBIncident;

	@FindBy(xpath = "//section[@aria-label='ASB Incident']")
	public WebElement objASBIncident;

	//@FindBy(xpath = "//section[@aria-label='ASB Incident']//*[@ref='eContainer' and @role='rowgroup']")
	@FindBy(xpath = "//section[@aria-label='ASB Incident']//*[@data-id='grid-container']")	
	public WebElement objASBIncidentRowCount;

	//@FindBy(xpath = "//section[@aria-label='Action']//*[@ref='eContainer' and @role='rowgroup']")
	@FindBy(xpath = "//section[@aria-label='Action']//*[@data-id='grid-container']")
	public WebElement objActionRowCount;

	@FindBy(xpath = "(//section[@aria-label='ASB Incident']//*[@aria-colindex='2'])[2]")
	public WebElement objASBIncidentFirstNameLink;

	@FindBy(xpath = "(//section[@aria-label='Action']//*[@aria-colindex='2'])[2]")
	public WebElement objActionFirstNameLink;

	@FindBy(xpath = "(//section[@aria-label='Action']//*[@aria-rowindex='1'])[2]")
	public WebElement objActionGridFieldNames;

	@FindBy(xpath = "//div[@aria-label='General']")
	public WebElement objNewActionSection;

	@FindBy(xpath = "//button[@aria-label='Deactivate']")
	public WebElement objButtonDeactivate;

	@FindBy(xpath = "//button[@aria-label='Mark Complete']")
	public WebElement objButtonMarkComplete;

	@FindBy(xpath = "//span[text()='Deactivate']/parent::button")
	public WebElement objdialogButtonDeactivate;

	@FindBy(xpath = "//button[@aria-label='Press Enter to go back.']")
	public WebElement objBackButton;

	@FindBy(xpath = "//div[@data-id='po_telluswhatisgoingon']//span[@role='presentation']")
	public WebElement objTelluswhatisgoingonQTooltip;

	@FindBy(xpath = "//button[@aria-label='Word Templates']")
	public WebElement objWordTemplates;

	@FindBy(xpath = "//button[@aria-label='More commands for Case']")
	public WebElement objMorecommandsforCase;
	
	@FindBy(xpath = "//button[@aria-label='More commands for Connection']")
	public WebElement objMorecommandsforConnection;
	
	@FindBy(xpath = "//button[@aria-label='More commands for Contact']")
	public WebElement objMorecommandsforContact;

	@FindBy(xpath = "//button[@aria-label='TenMan Action Plan']")
	public WebElement objTenManActionPlanWordTemplates;
	
	@FindBy(xpath = "//div[@data-id='customerid.fieldControl-LookupResultsDropdown_customerid_selected_tag']")
	public WebElement objCustomerField;
	

	@FindBy(xpath = "//ul[@data-id='parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_SelectedRecordList']")
	public WebElement objAccountField;
	
	@FindBy(xpath = "//*[text()='Account']")
	public WebElement objAccount;
		
	@FindBy(xpath = "//div[@id='alertsflags']")
	public WebElement objalertsflagsASB;
	
	@FindBy(xpath = "//div[@title='Risk']//*[@id ='ASBCourtOrder']")
	public WebElement objalertsflagsASBCourtOrder;	
	
	@FindBy(xpath = "//tr//td//div[contains(@id,'assistedgardening')]")
	public WebElement objAssistedGardening;	
	
	@FindBy(xpath = "//tr//td//div[contains(@id,'antisocialbehaviour')]")
	public WebElement objantisocialbehaviour;	
	
	@FindBy(xpath = "//tr//td//div[contains(@id,'ASBCourtOrder')]")
	public WebElement objASBCourtOrder;	
	
	@FindBy(xpath = "//tr//td//div[contains(@id,'HousingForOlderPeople')]")
	public WebElement objHousingForOlderPeople;
	
	
	@FindBy(xpath = "//input[@aria-label='Case Number']")
	public WebElement objCaseNumber;
	
	@FindBy(xpath= "//input[@aria-label='Date of ABA']")
	public WebElement objDateofABA;
	
	@FindBy(xpath= "//input[@aria-label='Date of Banding Assessment Panel']")
	public WebElement objDateBandingAssessment;
	
	@FindBy(xpath= "//input[@aria-label='Date of CBT referral']")
	public WebElement objDateofCBTReferral;
	
	@FindBy(xpath= "//input[@aria-label='Date of Committal']")
	public WebElement objDateofCommittal;
	
	@FindBy(xpath= "//input[@aria-label='Date of Community Protection Notice']")
	public WebElement objDateofCommunity;
	
	@FindBy(xpath= "//input[@aria-label='Date of Community Protection Warning']")
	public WebElement objDateofCommunityWarning;
	
	@FindBy(xpath= "//input[@aria-label='Date of Community Trigger']")
	public WebElement objDateofTrigger;
	
	@FindBy(xpath= "//input[@aria-label='Date of Criminal Behaviour Order']")
	public WebElement objDateofCriminal;
	
	@FindBy(xpath= "//input[@aria-label='Date of Demoted Tenancy']")
	public WebElement objDateofDemotedTenancy;
	
	@FindBy(xpath= "//input[@aria-label='Date of Dog Control Order']")
	public WebElement objDateofDogControl;
	
	@FindBy(xpath= "//input[@aria-label='Date of Eviction']")
	public WebElement objDateofEviction;
	
	@FindBy(xpath= "//input[@aria-label='Date of Final warning']")
	public WebElement objDateofFinalWarning;
	
	@FindBy(xpath= "//input[@aria-label='Date of Full Closure']")
	public WebElement objDateofFullclosure;
	
	@FindBy(xpath= "//input[@aria-label='Date of Initial Visit (HO or ASBO)']")
	public WebElement objDateofInitialvisit;
	
	@FindBy(xpath= "//input[@aria-label='Date of Injunction']")
	public WebElement objDateofInjunction;
	
	@FindBy(xpath= "//input[@aria-label='Date of Internal Transfer']")
	public WebElement objDateofInternalTransfer;
	
	@FindBy(xpath= "//input[@aria-label='Date of Living together fund']")
	public WebElement objDateofLivingfund;
	
	@FindBy(xpath= "//input[@aria-label='Date of Mediation']")
	public WebElement objDateofMediation;
	
	@FindBy(xpath= "//input[@aria-label='Date of Noise Abatement Order']")
	public WebElement objDateofNoiseAbatement;
	
	@FindBy(xpath= "//input[@aria-label='Date of NOSP served']")
	public WebElement objDateofNOSPserved;
	
	@FindBy(xpath= "//input[@aria-label='Date of NTQ served']")
	public WebElement objDateofNTQserved;
	
	@FindBy(xpath= "//input[@aria-label='Date of Partial Closure']")
	public WebElement objDateofPartialClosure;
	
	@FindBy(xpath= "//input[@aria-label='Date of Possession']")
	public WebElement objDateofPossession;
	
	@FindBy(xpath= "//input[@aria-label='Date of Property Abandoned']")
	public WebElement objDateofPropertyAbandoned;
	
	@FindBy(xpath= "//input[@aria-label='Date of Referral to Safe Partnerships']")
	public WebElement objDateofReferral;
	
	@FindBy(xpath= "//input[@aria-label='Date of Referral to Womankind']")
	public WebElement objDateofReferraltoWomankind;
	
	@FindBy(xpath= "//input[@aria-label='Date of Section 21 Served']")
	public WebElement objDateofSection;
	
	@FindBy(xpath= "//input[@aria-label='Date of Signposted to Domestic Abuse specialist']")
	public WebElement objDateofSignpostedDomesticAbuse;
	
	@FindBy(xpath= "//input[@aria-label='Date of Signposted to Mental Health team']")
	public WebElement objDateofSignpostedMental;
	
	@FindBy(xpath= "//input[@aria-label='Date of Signposted to Police']")
	public WebElement objDateofSignpostedPolice;
	
	@FindBy(xpath= "//input[@aria-label='Date of Signposted to Social Services']")
	public WebElement objDateofSignpostedSocialServices;
	
	@FindBy(xpath= "//input[@aria-label='Date of Solicitors Letter']")
	public WebElement objSolicitorsLetter;
	
	@FindBy(xpath= "//input[@aria-label='Date of Tenancy caution']")
	public WebElement objDateofTenancycaution;
	
	@FindBy(xpath= "//input[@aria-label='Date of SPO granted']")
	public WebElement objDateofSPOgranted;
	
	@FindBy(xpath= "//input[@aria-label='Date of Tenant ended tenancy']")
	public WebElement objDateofTenantendedtenancy;
	
	@FindBy(xpath= "//input[@aria-label='Date of Undertaking']")
	public WebElement objDateofUndertaking;
	
	@FindBy(xpath= "//input[@aria-label='Date of Warning - 1st']")
	public WebElement objDateofWarning1st;
	
	@FindBy(xpath= "//input[@aria-label='Date of Warning - 2nd']")
	public WebElement objDateofWarning2nd;
	
	
	public String ValidateFieldExists(WebDriver driver1, WebElement element, int timeout) {
		new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOfAllElements(element));
		System.out.println("Expected string" + element.getAttribute("outerText"));
		return element.getAttribute("outerText");
	}

	public Optimization(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}




	
	public String getCaseNumber(WebDriver driver, WebElement element)
	{
	return element.getAttribute("defaultValue");
	}

}
