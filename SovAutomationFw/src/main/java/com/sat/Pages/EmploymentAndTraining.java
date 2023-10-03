package com.sat.Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class EmploymentAndTraining {
	
	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
    Testutil testutil = new Testutil(driver);
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    Assertions assertion = new Assertions(driver);
    
    @FindBy(xpath="//button[@aria-label='Mark Complete']")
    WebElement markComplete;
    
    @FindBy(xpath = "(//div[(contains(@class,'ag-cell ag-cell-not-inline-editing'))])[1]")
    WebElement assessment ;
    
    @FindBy(xpath="//*[text()='New Action']")
    WebElement newAction;
    
    @FindBy(xpath="(//i[@data-icon-name='Calendar'])[1]")
   	WebElement byWhenDate;
    
    @FindBy(xpath="(//i[@data-icon-name='Calendar'])[2]")
   	WebElement actualEddDate;
    
    @FindBy(xpath="//td[@aria-current='date']")
   	WebElement currentDate;
    
    @FindBy(xpath="//*[text()='Read-only  This record’s status: Completed']")
   	WebElement actionPlanStatus;
    
	@FindBy(xpath = "//button[@aria-label='More Header Editable Fields']")
	WebElement openActivity;
	
	@FindBy(xpath = "//li[contains(@aria-label,'Stage: Initial Assessment')]")
	public WebElement objBPFInitialAssessment;

	@FindBy(xpath = "//h2[@title='Referral']/parent::section/parent::div//label")
	public WebElement sectionValidation;
	
	@FindBy(xpath = "//*[text()='Learning and Training Information']")
	public WebElement validateField;
	
	
    
    public EmploymentAndTraining(WebDriver rdriver)
   	{
   		driver=rdriver;
   		PageFactory.initElements(rdriver,this);
   	}
    
    public void validateAutoPopulatedRefField()
    {
    	Wait.untilPageLoadComplete(driver, 500);
    	String expected=driver.findElement(By.xpath("//div[contains(text(),'REF--')]")).getText();
    	Wait.untilPageLoadComplete(driver, 500);
    	testutil.clickOn(driver,driver.findElement(By.xpath("//div[contains(text(),'REF--')]")),2);
    	Wait.untilPageLoadComplete(driver, 500);
    	String actual=driver.findElement(By.xpath("//h1[contains(@title,'REF--')]")).getAttribute("title");
    	Wait.untilPageLoadComplete(driver, 500);
    	Assert.assertEquals(actual, expected, "Value is not auto populated");
    }
    
    public void verifyField(String text)
    {
    	String actual=driver.findElement(By.xpath("//*[text()='"+text+"']")).getText();
    	Assert.assertEquals(actual, text, "Field is not Displayed");
    }
    
    public void verifySection(String section,DataTable datatable) throws InterruptedException {
		Thread.sleep(5000);
		List<List<String>> actual = datatable.cells();
		Wait.untilPageLoadComplete(driver, 300);
		List<WebElement> element = driver
				.findElements(By.xpath("//h2[@title='" + section + "']/parent::section/parent::div//label"));
		Wait.untilPageLoadComplete(driver, 300);
		try {
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < element.size(); j++) {
					System.out.println(element.get(j).getText());
					Wait.untilPageLoadComplete(driver, 300);
					Assert.assertEquals(actual.get(i).get(j), element.get(j).getText(), "Element is not Displayed");
					Wait.untilPageLoadComplete(driver, 300);

				}
			}
		} catch (Exception e) {
			System.out.println("EXception :" + e + " has occurered");
		}
	}
    
    public void clickOnMoreHeader()
    {
    	Wait.untilPageLoadComplete(driver,500);
    	openActivity.click();
    	Wait.untilPageLoadComplete(driver,500);
    }
    public void selectCurrentDate()
    {
   	 	Wait.untilPageLoadComplete(driver,500);
    	actualEddDate.click();
    	Wait.untilPageLoadComplete(driver,500);
    	currentDate.click();
    }
    
    public void verifyCompletedDate()
    {
    	//String expected=driver.findElement(By.xpath("//label[contains(@aria-label,'20/08/2022')]")).getAttribute("aria-label");
    	DateFormat indianFormat = new SimpleDateFormat("dd/MM/yyyy");
		indianFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Date timestamp = new Date(System.currentTimeMillis());
		String output = indianFormat.format(timestamp);
		System.out.println("Stored time :" + output);
    	
     String actual =driver.findElement(By.xpath("//input[@aria-label='Date of Actual End']")).getAttribute("value");
     try {
			assertion.CheckAssertion(actual,output);
		} catch (IOException e) {
			e.printStackTrace();
		}
    } 
    
    public void verifyReadOnlyActionPlan(String text)
    {
    	try {
			assertion.CheckAssertion(actionPlanStatus.getText(),text);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void doubleClick()
    {
    	Wait.untilPageLoadComplete(driver,500);
        wait.until(ExpectedConditions.elementToBeClickable(assessment));
        Wait.untilPageLoadComplete(driver,500);
        action.doubleClick(assessment).build().perform();
        Wait.untilPageLoadComplete(driver,500);
    }
    
    public void enterActionField(String value)
    {
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//input[@aria-label='"+value+"']")).sendKeys("test");
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void MarkAsCompleted()  {
    	Wait.untilPageLoadComplete(driver,500);
     	markComplete.click();
     	Wait.untilPageLoadComplete(driver,500);
     }

    public void developmentstatusflagValidation(String flag)
    {
    	try{
    		Wait.untilPageLoadComplete(driver,500);
    		Thread.sleep(2000);
    		driver.switchTo().frame(driver.findElement(By.id("WebResource_DevelopmentStatusFlag")));
    		Thread.sleep(2000);
    		Wait.untilPageLoadComplete(driver,500);
    		Boolean b= driver.findElement(By.xpath("//tr[@id='trStatusFlag']//img")).getAttribute("src").contains(flag.replace(" ","").trim().toLowerCase());
    		System.out.println(b);
    		assertion.CheckAssertionTrue(b,"flag "+flag+" does not exist");
    		driver.switchTo().defaultContent();
    		}
    		catch(InterruptedException e){
    		e.printStackTrace();}
    }
    public void salesstatusflagValidation(String flag)
    {
    	try{
    		Wait.untilPageLoadComplete(driver,500);
    		Thread.sleep(2000);
    		driver.switchTo().frame(driver.findElement(By.id("WebResource_SalesStatusFlag")));
    		Thread.sleep(2000);
    		Wait.untilPageLoadComplete(driver,500);
    		Boolean b= driver.findElement(By.xpath("//tr[@id='trStatusFlag']//img")).getAttribute("src").contains(flag.replace(" ","").trim().toLowerCase());
    		System.out.println(b);
    		assertion.CheckAssertionTrue(b,"flag "+flag+" does not exist");
    		driver.switchTo().defaultContent();
    		}
    		catch(InterruptedException e){
    		e.printStackTrace();}
    }
    public void applicationstatusflagValidation(String flag)
    {
    	try{
    		Wait.untilPageLoadComplete(driver,500);
    		Thread.sleep(2000);
    		driver.switchTo().frame(driver.findElement(By.id("WebResource_applicationstatusflags")));
    		Thread.sleep(2000);
    		Wait.untilPageLoadComplete(driver,500);
    		Boolean b= driver.findElement(By.xpath("//tr[@id='trStatusFlag']//img")).getAttribute("src").contains(flag.replace(" ","").trim().toLowerCase());
    		System.out.println(b);
    		assertion.CheckAssertionTrue(b,"flag "+flag+" does not exist");
    		driver.switchTo().defaultContent();
    		}
    		catch(InterruptedException e){
    		e.printStackTrace();}
    }
    public void enterVlaue(String textfield,String value)
    {
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//*[@aria-label='"+textfield+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//*[@aria-label='"+textfield+"']")).sendKeys(value);
    	Wait.untilPageLoadComplete(driver,500);
    }
    
    public void ValidatedContactBuyerForm(String text) throws InterruptedException
    {
    	try {
    	Wait.untilPageLoadComplete(driver,2500);
    	Thread.sleep(2000);
    	String formType=driver.findElement(By.xpath("//div[contains(@aria-label,'(Buyer)')]")).getAttribute("aria-label");
    	System.out.println("Contact Form Type is "+formType);
		
			assertion.CheckAssertion(formType,text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void validateAutoPopulatedyContactType(String value)
    {
    	try {
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//ul[contains(@data-id,'po_contacttype.fieldControl')]")));
        	Wait.untilPageLoadComplete(driver,500);
    	String actual=driver.findElement(By.xpath("//ul[contains(@data-id,'po_contacttype.fieldControl')]")).getText();
    	assertion.CheckAssertion(actual,value);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    
}


