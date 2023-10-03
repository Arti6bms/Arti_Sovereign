package com.sat.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class NewContacts {
	

	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
    Testutil testutil = new Testutil(driver);
    Actions action = new Actions(driver);
    GenericCases genericCases = new GenericCases(driver);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    public ContactForm contact = new ContactForm(driver);
    Assertions assertion = new Assertions(driver);
    
    @FindBy(xpath="//*[text()='New']")
    WebElement newContact;
    @FindBy(xpath="//*[text()='You cannot use the contact type Existing Contact, please select another']")
    WebElement errorMessage;
    @FindBy(xpath="//*[text()='Contact Type: Required fields must be filled in.']")
    WebElement contactTypeMand;
    public NewContacts(WebDriver rdriver)
   	{
   		driver=rdriver;
   		PageFactory.initElements(rdriver,this);
   	}
    public void unableToSaveData() throws InterruptedException
    {
    	contact.clickOnSave();
    	String unsave=driver.findElement(By.xpath("//*[text()='- Unsaved']")).getText();
    	Assert.assertEquals(unsave,"- Unsaved"  ,"User unable to save the data");
//    	if(driver.findElement(By.xpath("//*[text()='Save']")).isEnabled())
//    	System.out.println("Element is clickable");
//    	else
//    	System.out.println("Element is not clickable");
    	
    }
    
    public void userValidateErrorMessage()
    {
    	Assert.assertEquals(errorMessage.getText(),"You cannot use the contact type Existing Contact, please select another");
    }
    
    public void userValidateMandatoryField(String expectedField) throws InterruptedException, Exception{
    	contact.clickOnSave();
    	String text=driver.findElement(By.xpath("//*[text()='"+expectedField+": Required fields must be filled in.']")).getText();
    	String[] ActualField=text.split(":");
    	System.out.println("Actual Mandatory field is :"+ActualField[0]);
    	//Assert.assertEquals(ActualField[0].concat("Required fields must be filled in."),expectedField.concat("Required fields must be filled in."),"Fields Are not Mandatory");
    	assertion.CheckAssertion(ActualField[0].concat("Required fields must be filled in."),expectedField.concat("Required fields must be filled in."));

    }
    
    public void clickOnNewContact() throws InterruptedException
	{
		testutil.jsclick(newContact, driver);
		Thread.sleep(2000);
		Wait.untilPageLoadComplete(driver,500);
	}
    
    public void verifyMandatory(String string) throws Exception {
    	SoftAssert softassert = new SoftAssert();
    	Wait.untilPageLoadComplete(driver,500);
    	softassert.assertEquals(driver.findElement(By.xpath("//*[contains(@id,'required-icon')]/parent::div/div/span")).getAttribute("title").contains(string), "The field " + string + " is not present");
    	//assertion.CheckAssertion(driver.findElement(By.xpath("(//*[contains(@id,'required-icon')]/parent::div/div/span)[1]")).getAttribute("innerText"), string);

    	}

}
