package com.sat.StepDefinitions;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.EmploymentAndTraining;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class EmploymentAndTrainingStepsDefs {
	
	 WebDriver driver= TestBase.getDriver();
		TestBase testbase = new TestBase();	
		 public ContactForm contact = new ContactForm(driver);
		 Testutil testutil = new Testutil(driver);
		 public EmploymentAndTraining et = new EmploymentAndTraining(driver);
		 Assertions assertion = new Assertions(driver);
		 Actions actions = new Actions(driver);
		 String workingDir = System.getProperty("user.dir");
		 private CasePage cases = new CasePage(driver);


		 @Then("user select radio button and double click on assessment")
		 public void user_select_radio_button_and_double_click_on_assessment() {
					 driver.findElement(
	                    By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='1']")).click();
					 et.doubleClick();
		 }
		 
		 @And("user select Actual End Date")
		 public void user_select_Actual_End_Date() {
			 et.selectCurrentDate();
		 }
		 @And("user validate completed date of action plan")
		 public void user_validate_completion_date_of_action_plan() {
			 et.verifyCompletedDate();
		 }
		 
		 @And("user validate action plan should be read only {string}")
		 public void user_validate_action_plan_should_be_read_only(String text) {
			 et.verifyReadOnlyActionPlan(text);
			 
		 }
		 
		 @Then("user click on Mark Complete with the tick mark")
		 public void user_click_on_Mark_Complete_with_the_tick_mark() {
			 et.MarkAsCompleted();
		 }

		 @Then("user enter {string}")
		 public void user_enter(String string) {
			 et.enterActionField(string);
			 
		 }
		 @Then("user verified the {string} section for below fields")
		 public void user_verified_the_section_for_below_field(String string,DataTable datatable) {
			 try {
				et.verifySection(string,datatable);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 @Then("user click on More Header fields icon")
		 public void user_click_on_More_Header_fields_icon() {
			 et.clickOnMoreHeader();
		 }
		 
		 @Then("user validate {string} field is display")
		 public void user_validate_field_is_display(String string) {
			 et.verifyField(string);
		 }
		
		 @Then("user velidate Referral filed is auto populated")
			public void user_validate_Referral_fields_is_auto_populated()
			{
			 et.validateAutoPopulatedRefField();
			} 
		 @Then("user validate {string} Development Status flag is displayed")
			public void user_validate_flag_is_Development_displayed(String flag)
			{
			 et.developmentstatusflagValidation(flag);
			}
		 @Then("user validate {string} Sales Status flag is displayed")
			public void user_validate_flag_is_sales_displayed(String flag)
			{
			 et.salesstatusflagValidation(flag);
			} 
		 @Then("user validate {string} Application Status flag is displayed")
			public void user_validate_flag_is_Application_displayed(String flag)
			{
			 et.applicationstatusflagValidation(flag);
			} 
		 @And("user enter {string} in {string} text box")
			public void user_enter_value_in_text_box(String value,String textfield)
			{
			 et.enterVlaue(textfield, value);
			} 
		 
		 @And("user validate the contact form is set to {string} Form")
			public void user_validate_contact_form_is_set_to_buyer(String textfield) throws InterruptedException
			{
			 et.ValidatedContactBuyerForm(textfield);
			} 
		 @Then("user validate Contact Type is autopopulated as {string}")
			public void user_validate_Contact_Type_autopupulated_as(String value)
			{
			 et.validateAutoPopulatedyContactType(value);
			} 
		

			
}
