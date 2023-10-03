package com.sat.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class ETCase_ET {

	WebDriver driver = TestBase.getDriver();
	TestBase testbase = new TestBase();
	Testutil testutil = new Testutil(driver);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	String listofvalues;
	SLATimer slatimer = new SLATimer(driver);
	Optimization omptimization = new Optimization(driver);
	Assertions assertion = new Assertions(driver);
	
	public ETCase_ET(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterDetailsWorkPlacementOutcomeSection()
	{
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Work Placement Company']")), 10, "WorkPlacement");
		//testutil.inputText(driver, "Work Placement Company", 10, "WorkPlacement");
		
	}
	
	public void enterDetailsVolunteeringsection()
	{
		testutil.sendKeys(driver, driver.findElement(By.xpath("//input[@aria-label='Volunteering Company']")), 10, "VolunteeringCompany");
		//testutil.inputText(driver, "Volunteering Company", 10, "VolunteeringCompany");

	}
	
	public void checkGrid(String string , String s)
	{
		try {
			Thread.sleep(2000);

//			actions.click(
//					driver.findElement(By.xpath("//section[@aria-label='" + string + "']//*[text()='Outcome Type']")))
//					.build().perform();
			
			action.click(
					driver.findElement(By.xpath("//section[@aria-label='" + string + "']//div[@aria-rowindex='1']//div[@aria-colindex='2']")))
					.build().perform();
			
			action.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
			action.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
			//action.sendKeys(null, null)
			//sendkeys(driver.findElement(By.xpath("//span[text()='" + s + "']"))).build().perform();
			action.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
			
			
			Thread.sleep(4000);
			System.out.println(string + " grid values are " + driver
					.findElement(By.xpath("//section[@aria-label='" + string + "']")).getAttribute("textContent"));
			assertion.CheckAssertionTrue(driver.findElement(By.xpath("//section[@aria-label='" + string + "']"))
					.getAttribute("textContent").contains(s), s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}