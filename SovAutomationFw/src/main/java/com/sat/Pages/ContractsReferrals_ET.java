package com.sat.Pages;

import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class ContractsReferrals_ET {
	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	Neighborhoods neighborhoods = new Neighborhoods(driver);
	Testutil testutil = new Testutil(driver);
	public ContactForm contact = new ContactForm(driver);
	Actions action = new Actions(driver);
	HashMap<Integer, String> casetitle = new HashMap<>();
	Queue queue = new Queue(driver);
	Properties prop = new Properties();
	String workingDir = System.getProperty("user.dir");
	NewContacts newContacts = new NewContacts(driver);
	Assertions assertion = new Assertions(driver);
	GenericCases genericCases = new GenericCases(driver);
	FraudCase fraudCase = new FraudCase(driver);
	String ExpContactDetails,ExpPreApplicantDetails;

	public ContractsReferrals_ET(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@data-id='header_ownerid.fieldControl-LookupResultsDropdown_ownerid_selected_tag_text']")
	public WebElement objOwnerFieldValue;

	@FindBy(xpath = "//div[@data-id='po_contacttype.fieldControl-LookupResultsDropdown_po_contacttype_selected_tag_text']")
	public WebElement objcontacttype;

	@FindBy(xpath = "//span[text()='Contact (Resident Form)']")
	public WebElement objFormtypeContactResidentForm;

	@FindBy(xpath = "//span[text()='Contact (Non Resident/Partner Form)']")
	public WebElement objFormtypeContactNonResidentPartnerForm;

	@FindBy(xpath = "//button[@aria-label='New']")
	public WebElement objnewContact;
			
	@FindBy(xpath = "//select[@aria-label='Title']")
	public	WebElement objTitle;
	
	@FindBy(xpath = "//input[@aria-label='First Name']")
	public	WebElement objFirstName;
	
	@FindBy(xpath = "//input[@aria-label='Last Name']")
	public	WebElement objLastName;
	
	@FindBy(xpath = "//input[@aria-label='Email']")
	public	WebElement objEmail;
	
	@FindBy(xpath = "//input[@aria-label='Telephone (Home)']")
	public	WebElement objTelephoneHome;
	
	@FindBy(xpath = "//input[@aria-label='Telephone (Mobile)']")
	public	WebElement objTelephoneMobile;
	
	@FindBy(xpath = "//select[@aria-label='Contact Preferences']")
	public	WebElement objContactPreferences;
	
	@FindBy(xpath = "//select[@aria-label='ET Customer Type']")
	public	WebElement objETCustomerType;
	
	@FindBy(xpath = "//input[@aria-label='URN']")
	public	WebElement objURN;
	
	@FindBy(xpath = "//input[@aria-label='Alert Flag']")
	public	WebElement objAlertFlag;
	
	@FindBy(xpath = "//button[@aria-label='Toggle menu']")
	public WebElement objAlertflagActionsMenu;
	
	@FindBy(xpath = "//div[text()='Safeguarding']")
	public WebElement objAlertFlagMenuItem;
	
	@FindBy(xpath = "//select[@aria-label='Gender']")
	public	WebElement objGender;
	
	@FindBy(xpath = "//input[@aria-label='National Insurance Number']")
	public	WebElement objNationalInsuranceNumber;
	
	@FindBy(xpath = "//input[@aria-label='Date of Date of Birth']")
	public	WebElement objDateofBirth;
	

	
	
	

	
	
	public void clickOnNewContact() throws InterruptedException {
		try {
			testutil.jsclick(objnewContact, driver);
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver);
		} catch (Exception e) {
		}
		;
	}


		
	
		

}
