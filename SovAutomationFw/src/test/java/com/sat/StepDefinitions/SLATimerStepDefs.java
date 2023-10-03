package com.sat.StepDefinitions;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;
import com.sat.Pages.SLATimer;
import com.sat.Pages.ContactForm;
import com.sat.Pages.GenericCases;
import io.cucumber.java.en.Then;

public class SLATimerStepDefs {


	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();

	Testutil testUtil = new Testutil(driver);
	Actions action = new Actions(driver);
	SLATimer slatimer = new SLATimer(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);	
	GenericCases genericcases = new GenericCases(driver);
	  Assertions assertion = new Assertions(driver);
		 public ContactForm contact = new ContactForm(driver);



	@Then("user fill Safeguarding Type Category as {string}")
	public void user_fill_Safeguarding_Type_Category(String string) {
		testUtil.selectByVisibleText(driver, slatimer.objSafeguardingTypeCategory, string);

	}
	
	@Then("user fill Safeguarding Category as {string}")
	public void user_fill_Safeguarding_Category(String string) {
		testUtil.selectByVisibleText(driver, slatimer.objSafeguardingCaseCategory, string);

	}

	@Then("user will select Category as {string}")
	public void user_will_select_category(String fieldvalue) throws Exception {
		try {
			Thread.sleep(1000);
			//action.moveToElement(slatimer.objCategoryField).build().perform();					
			String selectedValue = slatimer.Select_LookUpValue(slatimer.objCategory, slatimer.objCategoryItemCustomer,slatimer.objcategorySelectedRecordList,fieldvalue );
			System.out.println("selcted fieldValue  = " + selectedValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	@Then("user will select Original Alerter as {string}")
	public void user_will_select_Original_Alerter(String fieldvalue) throws Exception {
		try {
			Thread.sleep(1000);
			//action.moveToElement(slatimer.objCategoryField).build().perform();
			String selectedValue = slatimer.Select_LookUpValue(slatimer.objOriginalAlerter, slatimer.objOriginalAlerterItemContractor,slatimer.objoriginalalerterSelectedRecordList,fieldvalue );
			System.out.println("selcted fieldValue  = " + selectedValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Then("user validate {string} tab")
	public void user_validate_tab(String string) throws Exception {
		try {
			Thread.sleep(2000);
			assertion.CheckAssertion(string, driver
					.findElement(By.xpath("//li[@aria-label='"+string+"']"))
					.getAttribute("outerText"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("user select {string} for two questions of Initial Risk Prioritisation Questions")
	public void user_select_for_two_the_questions_of_Initial_Risk_Prioritisation_Questions(String string) {
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ1, "No");
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ2, "Yes");
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ3, "Yes");
		
	}
	
	@Then("user select {string} for all questions of Initial Risk Prioritisation Questions")
	public void user_select_for_all_the_questions_of_Initial_Risk_Prioritisation_Questions(String string) {
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ1, "If Yes, call 999");
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ2, "Yes");
		testUtil.selectByVisibleText(driver, slatimer.objInitialRiskPrioritisationQ3, "Yes");
		
	}
	
	
	@Then("user verify {string} and {string} as {string} section in Summary Tab")
	public void user_verify_section_in_Summary_Tab(String string,String string2, String ResponseTime) throws Exception {
		try {
			Thread.sleep(5000);			

			action.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			Thread.sleep(2000);
			action.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			action.sendKeys(Keys.chord(Keys.TAB)).build().perform();
			action.sendKeys(Keys.chord(Keys.END)).build().perform();

			
			System.out.println("objResponseTime = "+slatimer.objResponseTime.getAttribute("title"));
			assertion.CheckAssertionTrue(slatimer.objResponseTime.getAttribute("title").contains(ResponseTime),ResponseTime);
			
			//To wait for element visible
			  WebDriverWait wait = new WebDriverWait(driver, 30);
			  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@aria-label='save status - Saved']")));
			
			 action.moveToElement(driver.findElement(By.xpath("//*[@aria-label='APPLICABLE SLA']"))).build().perform();
			 System.out.println(driver.findElement(By.xpath("//*[@aria-label='APPLICABLE SLA']")).getText());

			System.out.println("objSLAonTarget = "+slatimer.objSLAonTarget.getAttribute("title"));
			assertion.CheckAssertionTrue(slatimer.objSLAonTarget.getAttribute("title").contains("---"),"---");
			Thread.sleep(2000);
			System.out.println("objFirstResponseSLAStatus = "+slatimer.objFirstResponseSLAStatus.getAttribute("title"));
			assertion.CheckAssertionTrue(slatimer.objFirstResponseSLAStatus.getAttribute("title").contains("In Progress"),"In Progress");
			Thread.sleep(10000);
			
			LocalDate date = LocalDate.now();
			DayOfWeek dow = date.getDayOfWeek();
			System.out.println("Enum = " + dow);
			;
			//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@aria-label='Score']")));
			String tascore = driver.findElement(By.xpath("//*[@aria-label='Score']")).getAttribute("title");
			
			if (dow.toString()=="FRIDAY" ||  (Integer.parseInt(tascore)<25 && Integer.parseInt(tascore)>15)  ) 
			{			
			System.out.println("objFirstResponseIn =  " + slatimer.objFirstResponseIn.getAttribute("innerText"));
			assertion.CheckAssertionTrue(slatimer.objFirstResponseIn.getAttribute("innerText").contains("d"),"d");
			}
			else
			{			
			System.out.println("In else : objFirstResponseIn =  " + slatimer.objFirstResponseIn.getAttribute("innerText"));
			assertion.CheckAssertionTrue(slatimer.objFirstResponseIn.getAttribute("innerText").contains("h"),"h");
			}
			

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate {string} as {string} in Initial Risk Prioritisation tab")
	public void user_validate_in_Initial_Risk_Prioritisation_tab(String string,String string2) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(slatimer.objScore));
			assertion.CheckAssertion(string2, slatimer.objScore.getAttribute("defaultValue"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user validate {string} is displayed as {string}")
	public void user_validate_is_displayed_as(String string, String string2) throws InterruptedException {
		try {
			Thread.sleep(2500);
			assertion.CheckAssertionTrue(slatimer.objRiskPriority.getAttribute("textContent").contains(string2),string2);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	@Then("user verifies if {string} is set to {string}")
	public void user_verifies_if_is_set_to(String string, String string2) throws Exception {
		try {
			Thread.sleep(2000);
			assertion.CheckAssertionTrue(slatimer.objResponseTime.getAttribute("title").contains(string2),string2);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
    @Then("user wait for case to save")
	public void user_wait_for_case_to_save() throws Exception {
    	WebDriverWait wait = new WebDriverWait(driver, 15);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='save status - Saved']")));
    
    }
    
    @Then("user select {string} as {string}")
    public void user_select(String string,String string2) {
    	try {
    		Thread.sleep(1500);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@aria-label,'"+string+"')]")));
    		WebElement e = driver.findElement(By.xpath("//select[contains(@aria-label,'"+string+"')]"));
			Thread.sleep(1500);
			System.out.println("user selecting as = "+ string2);
			testUtil.selectByVisibleText(driver,e, string2);
			Thread.sleep(1000);
			//assertion.CheckAssertionTrue(e,string2);
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @Then("user validates {string} as {string}")
    public void user_validates(String fieldName, String fieldvalue) throws Exception {
    	
    	try {
    		System.out.println("user validating " + fieldName + " as " + fieldvalue );
    		Thread.sleep(2000);
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='" + fieldName + "']")));
    		  WebDriverWait wait = new WebDriverWait(driver, 10);
    		  //action.moveToElement(driver.findElement(By.xpath("//*[@aria-label='" + fieldName + "']"))).build().perform();
			assertion.CheckAssertion(driver.findElement(By.xpath("//*[@aria-label='" + fieldName + "']")).getAttribute("title"),fieldvalue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
	@Then("user selects {string} in field {string}")
	public void user_selects_dropdown_field(String fieldValue, String fieldName) {
		try {
			Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath("//select[@aria-label='"+fieldName+"']"));
			Thread.sleep(2000);
			testUtil.selectByVisibleText(driver, e, fieldValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user select sort newer to older arrow in Entered Queue")
    public void user_select_sort_newer_to_older_arrow_in_Entered_Queue() {
    	try {
    		driver.findElement(By.xpath("(//label[@class='ms-Label headerText-241'])[2]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[text()='Sort newer to older']")).click();
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
}