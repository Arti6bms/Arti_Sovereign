package com.sat.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;

public class PhoneCallsFunctionality {
	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
    Testutil testutil = new Testutil(driver);
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Optimization omptimization = new Optimization(driver);
    Assertions assertion = new Assertions(driver);
    
    @FindBy(xpath="//button[@aria-label='Create a timeline record.']")
	WebElement plusIcon;
    @FindBy(xpath="//input[@aria-label='Mobile Phone']")
	WebElement phoneTextBox;
    @FindBy(xpath="//*[text()='Mobile Phone']/parent::span/parent::div/parent::div/following-sibling::div//*[contains(@class,'NewPhoneCall-symbol')]")
   	WebElement phoneSymbol;
    @FindBy(xpath="//input[@aria-label='Subject']")
   	WebElement subject;
    @FindBy(xpath="//*[text()='Communities']")
   	WebElement phoneCategory;
    @FindBy(xpath="//*[text()='Incoming']")
   	WebElement direction;
    
    @FindBy(xpath="//textarea[@aria-label='Description']")
   	WebElement description;
    @FindBy(xpath="(//textarea[@aria-label='Description'])[2]")
   	WebElement descriptionCases;
    @FindBy(xpath="//*[text()='Save and Close' or text()='Save & Close']")
   	WebElement saveAndClose;
    //@FindBy(xpath="//*[text()='---Test Phone Number']/parent::div/parent::div/parent::div")
    @FindBy(xpath="(//*[text()='Active'])[1]")
   	WebElement mouseHover;
    @FindBy(xpath="(//a[@title='Open Record'])[1]")
    WebElement openRecord;
    @FindBy(xpath="//button[@aria-label='Mark Complete']")
    WebElement markComplete;
    @FindBy(xpath="//div[text()='Phone Call']")
    WebElement timeLineOption;
    @FindBy(xpath="//input[@aria-label='First Time Resolution']")
    WebElement checkBox;
    @FindBy(xpath="//button[@aria-label='Enter a note...']")
    WebElement clickEnterNote;
    @FindBy(xpath="//input[@aria-label='Title']")
    WebElement enterTitle;
    @FindBy(xpath="//html/body[@aria-label='Press ALT 0 for help']")
    WebElement enterText;
    @FindBy(xpath="//button[@aria-label='Add note']")
    WebElement clickAddNote;
    
    @FindBy(xpath="//select[@aria-label='Response Time']")
    WebElement responseTime;
    @FindBy(xpath="//*[text()='Routine (5 Working Days)']")
    WebElement responseTimeValue;
    @FindBy(xpath="//button[@aria-label='More Header Fields']")
    WebElement openActivity;
    @FindBy(xpath="//button[contains(@id,'selected_tag_delete')]")
    WebElement removeOwnerName;
    @FindBy(xpath="//*[text()='Owner']/parent::span/parent::div/parent::div/following-sibling::div") //(//div[text()='Arti Kumari'])[2]
    WebElement ownerLookup;
  
    @FindBy(xpath="//button[@aria-label='More commands for Task']")
    WebElement threeDot;
    @FindBy(xpath="//*[text()='Assign']")
    WebElement assign;
    @FindBy(xpath="//*[text()='Run Report']")
    WebElement runReport;
    @FindBy(xpath="//*[text()='Export Contact and Case Timeline']")
    WebElement export;
    @FindBy(xpath="//button[@aria-label='More commands for Contact']")
  WebElement threeDotContact;
    @FindBy(xpath="//button[@aria-label='Assign']")
    WebElement assignButton;
    @FindBy(xpath="//div[@class='NormalButton']/table[@title='Print']//*[contains(@class,'print')]") //div[@class='NormalButton']/table[@title='Print']")
    WebElement print;
    @FindBy(xpath="//p[text()='Cancel']")
    WebElement printCancel;
    @FindBy(xpath="//span[@class='glyphui glyphui-downarrow']")
    WebElement saveDropDown;
    @FindBy(xpath="//a[@title='Excel']")
    WebElement selectExcel;

    
    
    
    public PhoneCallsFunctionality(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
    public void clickThreeDot() {
    	Wait.untilPageLoadComplete(driver,500);
    	threeDot.click();
    	Wait.untilPageLoadComplete(driver,500);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickThreeDot(String page) {
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//button[@aria-label='More commands for "+page+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    }
   
    public void clickAssign() throws InterruptedException {
    	Thread.sleep(2000);
    	assign.click();
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickOnRunReport() {
    	threeDotContact.click();
    	Wait.untilPageLoadComplete(driver,500);
    	runReport.click();
    	Wait.untilPageLoadComplete(driver,500);}
    
    
    public void clickOnRunReport(String option) {
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//*[text()='"+option+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickOnExportContactCaseTimeline() {
    	export.click();
    	Wait.untilPageLoadComplete(driver,500);
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void verifyAllColumn(DataTable datatable) throws Exception
    {
    	Wait.untilPageLoadComplete(driver,500);
    	//testutil.selectFrame("resultFrame");
    	//testutil.switchToFrame("resultFrame");
    	new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("resultFrame")));
    	Thread.sleep(3000);
    	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    	System.out.println("Size :" +tabs.size());
    	driver.switchTo().window(tabs.get(1));
    	System.out.println("Title of Tab" +driver.getTitle());
    	List<List<String>> actual = datatable.cells();
    	List<WebElement> element=driver.findElements(By.xpath("//*[text()='Type']/parent::div/parent::td/parent::tr/td/div/div"));
    	try {
    	for(int i=0;i<1;i++)
    	{
    		for(int j=0;j<element.size();j++)
    		{		
    		System.out.println(element.get(j).getText());
    		Wait.untilPageLoadComplete(driver,500);
    		Assert.assertEquals(actual.get(i).get(j),element.get(j).getText(),"Element is not Displayed");
    		Wait.untilPageLoadComplete(driver,500);
    		}
    		
    	}}
    	catch(Exception e)
    	{
    		System.out.println("EXception :"+e+" has occurered");
    	}
     }
    
    public void verifyColumn(DataTable datatable) throws Exception
    {
    	List<String> actual = datatable.asList();
		System.out.println(actual.size());
		try {
			for (int j = 1; j <= actual.size() - 1; j++) {
				System.out.println(j);
				System.out.println("Field Name is : " + actual.get(j));
				String expectedResult = omptimization.ValidateFieldExists(driver, driver.findElement(
						By.xpath("(//div[@class='ag-header ag-pivot-off']//*[@aria-rowindex='1'])[2]")), 5);
				assertion.CheckAssertionTrue(expectedResult.contains(actual.get(j)), actual.get(j));
			}}
    	catch(Exception e)
    	{
    		System.out.println("EXception :"+e+" has occurered");
    	}
     }
    
    public void verifyPrintAndSave() throws InterruptedException
    {
    	Wait.untilPageLoadComplete(driver,500);
    	//wait.until(ExpectedConditions.elementToBeClickable(print));
    	testutil.jsclick(print, driver);
    	Thread.sleep(5000);
    	Wait.untilPageLoadComplete(driver,500);
    	wait.until(ExpectedConditions.elementToBeClickable(printCancel));
    	testutil.jsclick(printCancel, driver);
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	wait.until(ExpectedConditions.elementToBeClickable(saveDropDown));
    	testutil.jsclick(saveDropDown, driver);
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	wait.until(ExpectedConditions.elementToBeClickable(selectExcel));
    	testutil.jsclick(selectExcel, driver);
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void assignUser() {
    	driver.findElement(By.xpath("//div[@title='Me']")).click();
    	driver.findElement(By.xpath("//option[text()='User or team']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    	WebElement team= driver.findElement(By.xpath("//input[@aria-label='User or team, Lookup']"));
    	Wait.untilPageLoadComplete(driver,500);
    	action.moveToElement(team).click().build().perform();
    	Wait.untilPageLoadComplete(driver,500);
    	//driver.findElement(By.xpath("//button[@aria-label='Search records for User or team, Lookup field']")).click();
    	team.sendKeys("East Housing Response");
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//li[@aria-label='East Housing Response']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    	Wait.elementToBeClickable(driver, driver.findElement(By.xpath("//*[text()='Assign']/parent::button")), 40);
    	driver.findElement(By.xpath("//*[text()='Assign']/parent::button")).click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickAssignButton() throws InterruptedException {
//    	Wait.untilPageLoadComplete(driver,500);
//    	wait.until(ExpectedConditions.elementToBeClickable(assignButton));
    	//testutil.jsclick(assignButton, driver);
    	assignButton.click();
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickMarkAsCompleted() {
    	driver.findElement(By.xpath("(//div[(contains(@class,'ag-cell ag-cell-not-inline-editing ag-cell-normal-height no'))])[1]")).click();
    	Wait.untilPageLoadComplete(driver,500);
    	markComplete.click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void openAndMarkAsCompleted() throws InterruptedException {
       WebElement task=driver.findElement(By.xpath("(//div[(contains(@class,'ag-cell ag-cell-not-inline-editing ag-cell-normal-height no'))])[1]"));
       Thread.sleep(2000);
       wait.until(ExpectedConditions.elementToBeClickable(task));
       action.doubleClick(task).build().perform();
    	Thread.sleep(2000);
       Wait.untilPageLoadComplete(driver,500);
    	markComplete.click();
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    
    public void enterResponseTimeAndDescription() throws InterruptedException
    {
    	wait.until(ExpectedConditions.elementToBeClickable(responseTime));
    	responseTime.click();
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	wait.until(ExpectedConditions.elementToBeClickable(responseTimeValue));
    	responseTimeValue.click();
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	description.sendKeys("Test");
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void changeOwnerName() throws InterruptedException
    {
    	openActivity.click();
    	Wait.untilPageLoadComplete(driver,500);
    	Thread.sleep(2000);
    	action.moveToElement(ownerLookup).build().perform();;
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	removeOwnerName.click();
    	Thread.sleep(2000);
        WebElement search=driver.findElement(By.xpath("//button[@aria-label='Search records for Owner, Lookup field']"));    	
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(search)));
		wait.until(ExpectedConditions.elementToBeClickable(search));
    	testutil.jsclick(search,driver);
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//li[@aria-label='Accounts Receivable']")).click();
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	openActivity.click();
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void clickEnterNote()
    {
    	clickEnterNote.click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void userEnterTitle()
    {
    	enterTitle.sendKeys("Test Title");
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void userEnterText() throws InterruptedException
    {
    	testutil.switchToFrame("cke_wysiwyg_frame cke_reset");
    	Thread.sleep(3000);
    	testutil.switchToFrame("fullPageContentEditorFrame");
    	Thread.sleep(3000);
    	//testutil.switchToFrame(enterText);
    	//enterTitle.sendKeys(Keys.TAB);
    	Wait.untilPageLoadComplete(driver,500);
    	enterText.click();
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	enterText.sendKeys("Test Note");
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	driver.switchTo().defaultContent();
    }
    public void clickOnAddNote()
    {
    	clickAddNote.click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void clickOnPlushIcon() throws InterruptedException
    {
    	Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	plusIcon.click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void verifyCheckBox(String text)
    {
    	Wait.untilPageLoadComplete(driver,500);
		
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@aria-label='"+text+"']"))));
    	testutil.jsclick(driver.findElement(By.xpath("//input[@aria-label='"+text+"']")),driver);
      Wait.untilPageLoadComplete(driver,500);
    }
    public void selectOption(String option)
    {
    	driver.findElement(By.xpath("//div[text()='"+option+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void scrollDown(String text)
    {
    	driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN);
    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN);
    	Wait.untilPageLoadComplete(driver,500);
	    
    }
    public void scrollDownTillElementPresent(String text)
    {
    	JavascriptExecutor js =((JavascriptExecutor)driver);
    
    	js.executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.xpath("//input[@aria-label='Post Code']")));
    	Wait.untilPageLoadComplete(driver,500);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[text()='"+text+"']")));
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void scrollUp() throws InterruptedException
    {
   	//driver.findElement(By.xpath("//li[text()='Summary']")).click();
   //	Wait.untilPageLoadComplete(driver,500);
//WebElement ele= driver.findElement(By.xpath("//*[text()='TIMELINE']"));
//JavascriptExecutor js =((JavascriptExecutor)driver);
//js.executeScript("arguments[0].scrollIntoView(true);", ele);
    	Wait.untilPageLoadComplete(driver,500);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']"))));
		testutil.jsclick(driver.findElement(By.xpath("//input[@aria-label='Mobile Phone']")),driver);
		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver,500);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_UP,Keys.PAGE_UP);
		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver,500);
    }
    public void clearTextbox()
    {
    	phoneTextBox.sendKeys(Keys.CONTROL + "a");
    	phoneTextBox.sendKeys(Keys.DELETE);
    	// phoneTextBox.clear();
	     Wait.untilPageLoadComplete(driver,500);
	     
    }
    
    public void enterMobileNumber(String number)
    {
    	
    	phoneTextBox.sendKeys(number);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void clickOnPhoneSymbol()
    {
    	phoneSymbol.click();
    	Wait.untilPageLoadComplete(driver,500);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void enterMandatoryField()
    {
    	Wait.untilPageLoadComplete(driver,500);
    	phoneCategory.click();
    	Wait.untilPageLoadComplete(driver,500);
    	description.sendKeys("Test Phone Number");
    	Wait.untilPageLoadComplete(driver,500);
        	
    }
    public void enterMandatoryFieldInCases()
    {
    	Wait.untilPageLoadComplete(driver,500);
    	phoneCategory.click();
    	Wait.untilPageLoadComplete(driver,500);
    	descriptionCases.sendKeys("Test Phone Number");
    	Wait.untilPageLoadComplete(driver,500);
        	
    }
    public void enterSubjectField()
    {
    	subject.sendKeys("test");
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void enterCallToField() throws InterruptedException
    {  
    	WebElement callTo= driver.findElement(By.xpath("//input[@aria-label='Call To, Multiple Selection Lookup']"));
    	callTo.click();
	Wait.untilPageLoadComplete(driver,500);
	callTo.sendKeys("Alton Williams");
	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//li[@aria-label='Alton Williams']")).click();
    	Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void selectDirection(String direction)
    {
    	driver.findElement(By.xpath("//*[text()='"+direction+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void clickOnsaveAndClose() throws InterruptedException
    {
    	Wait.untilPageLoadComplete(driver,500);
		testutil.jsclick(saveAndClose, driver);
		Thread.sleep(8000);
		Wait.untilPageLoadComplete(driver, 300);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		List<WebElement> saving = driver.findElements(By.xpath("//*[@role='alert'][text()='Saving...']"));
		if (saving.size() != 0)
			wait.until(ExpectedConditions
					.invisibilityOf(driver.findElement(By.xpath("//*[@role='alert'][text()='Saving...']"))));
    	
//    	Wait.untilPageLoadComplete(driver,500);
//    	saveAndClose.click();
//    	Thread.sleep(5000);
//    	driver.navigate().refresh();
//    	Thread.sleep(5000);
//    	Wait.untilPageLoadComplete(driver,500);
    }
    public void searchActivities(String option) throws InterruptedException
    {
    	    	//clicking on filter icon
    	Wait.untilPageLoadComplete(driver,500);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='No filter applied. Select to open or close filter pane.']"))));
    			driver.findElement(By.xpath("//button[@title='No filter applied. Select to open or close filter pane.']")).click();
    			Thread.sleep(2000);
    			//Selecting Phone Call checkbox
    			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//label[text()='Activity type']"))));
    			driver.findElement(By.xpath("//label[text()='Activity type']")).click();
    			Thread.sleep(2000);
    			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+option+"')]"))));
    			driver.findElement(By.xpath("//span[contains(text(),'"+option+"')]")).click();
    			Thread.sleep(2000);
    			//closing on filter icon
    			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@title='Close filters']"))));
    			driver.findElement(By.xpath("//button[@title='Close filters']")).click();
    			Thread.sleep(2000);
    }
    public void openAndComplete() throws InterruptedException
    {
    	//WebDriverWait wait = new WebDriverWait(driver, 20);
    	//wait.until(ExpectedConditions.elementToBeClickable(mouseHover));
   	 Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    	action.moveToElement(mouseHover).build().perform();
   	 Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	// wait.until(ExpectedConditions.elementToBeClickable(openRecord));
    	testutil.jsclick(openRecord, driver);
    	 Thread.sleep(3000);
    	Wait.untilPageLoadComplete(driver,500);
    	markComplete.click();
    	 Thread.sleep(2000);
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void openCases() throws InterruptedException
    {
     	Wait.untilPageLoadComplete(driver,500);
    	 action.moveToElement(mouseHover).build().perform();
      	 Thread.sleep(3000);
     	Wait.untilPageLoadComplete(driver,500);
     	 wait.until(ExpectedConditions.elementToBeClickable(openRecord));
        openRecord.click();
     	 Thread.sleep(3000);
     	Wait.untilPageLoadComplete(driver,500);
    }
}
