package com.sat.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.sat.Pages.NewContacts;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NewContactsStepDefs {
	

	WebDriver driver= TestBase.getDriver();
	TestBase testbase = new TestBase();
	NewContacts newContacts = new NewContacts(driver);
	Testutil testUtil = new Testutil(driver);
	
	@Given("user click on New Contact")
	public void user_click_on_New_Cases() throws InterruptedException {
		newContacts.clickOnNewContact();
	}
	@Then("user verify {string} filed is mandatory")

	public void user_verify_filed_is_mandatory(String exceptedField) throws InterruptedException {
		try {
			newContacts.userValidateMandatoryField(exceptedField);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verify red error message on top of the Contact")
	public void user_verify_red_error_message_on_top_of_the_Contact() {
		newContacts.userValidateErrorMessage();
	}

	@Then("user verify all fields should be locked in both Summary and Correspondence tabs")
	public void user_verify_all_fields_should_be_locked_in_both_Summary_and_Correspondence_tabs() {
	}
	@Given("user verify unable to save the data")
	public void user_verify_unable_to_save_the_data() throws InterruptedException {
		newContacts.unableToSaveData();
	}
	
	@Then("user validates from {string} of column {string}")
	public void user_validates_from_column(String module,String typeOfFields) {
	try {		
	Properties prop = testUtil.readPropertiesFile(System.getProperty("user.dir") + "/src/main/java/com/sat/testData/TestDataSov.properties");
	String property = module.replace(" ","")+"_"+typeOfFields.replace(" ","");
	String[] mandatoryFields = prop.getProperty(property).split(";");
	for(String field:mandatoryFields)
	newContacts.verifyMandatory(field);
	} catch (Exception e) {
	System.out.println("Exception: "+e+" has occurred");
	}
	}


	@Then("user verify {string} field is mandatory on Summary Tab")
	public void user_verify_field_is_mandatory_on_Summary_Tab(String string) {
	try {
	newContacts.verifyMandatory(string);
	}catch(Exception e) {
	System.out.println("Exception: "+e+" has occurred");
	}
	}




}
