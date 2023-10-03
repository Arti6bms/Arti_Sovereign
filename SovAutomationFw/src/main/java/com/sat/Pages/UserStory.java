package com.sat.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

public class UserStory {
	
	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
    Testutil testutil = new Testutil(driver);
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 20);
    
    @FindBy(xpath="//select[@aria-label='PEEPs Type']")
    WebElement objPeepsType;
    @FindBy(xpath = "//select[@aria-label='PEEPs Type']//option")
    WebElement objDropdwresults;
    
    public UserStory(WebDriver rdriver)
   	{
   		driver=rdriver;
   		PageFactory.initElements(rdriver,this);
   	}
    
    public String validateListValue(String field)
    {
   		Wait.untilPageLoadComplete(driver,500);
    	driver.findElement(By.xpath("//select[@aria-label='"+field+"']")).click();
    	Wait.untilPageLoadComplete(driver,500);
      String expected= driver.findElement(By.xpath("//select[@aria-label='"+field+"']//option")).getAttribute("innerText");
      System.out.println("Expected : "+expected); 
      return expected;
    }
    public String validateLockedField(String field)
    {
    String actual=driver.findElement(By.xpath("//div[contains(@aria-label,'Locked "+field+"')]")).getAttribute("aria-label");
    return actual;
    }
    
    public void validateAutoPopulatedField()
    {
    	String actual=driver.findElement(By.xpath("//div[@title='Speen']")).getText();
    	Wait.untilPageLoadComplete(driver,500);
        testutil.clickOn(driver, driver.findElement(By.xpath("//div[@title='Speen']")), 2);
        Wait.untilPageLoadComplete(driver,500);
        String expected=driver.findElement(By.xpath("//input[@title='Speen']")).getAttribute("title");
        Assert.assertEquals(actual, expected,"Value is not auto populated");
    }

}
