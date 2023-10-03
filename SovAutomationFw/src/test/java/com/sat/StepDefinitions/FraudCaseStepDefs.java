package com.sat.StepDefinitions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;

import com.sat.Pages.CommonPages;
import com.sat.Pages.ContactForm;
import com.sat.Pages.FraudCase;
import com.sat.Pages.GenericCases;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FraudCaseStepDefs {
	
	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	FraudCase fraudCase = new FraudCase(driver);
	Testutil testUtil = new Testutil(driver);
	public ContactForm contact = new ContactForm(driver);
	CommonPages com = new CommonPages(driver);
	GenericCases genericCases = new GenericCases(driver);
	  Assertions assertion = new Assertions(driver);

		@Then("user Click on {string}")
		public void user_Click_on_New_Connection(String action) throws InterruptedException {
			fraudCase.clicOnNewConnection(action);
		}

	@Then("user fill details for {string} as {string}")
	public void user_fill_details_for(String field, String value) throws InterruptedException {
		fraudCase.selectFraudcategory(field, value);
		Thread.sleep(1500);
	}

	@Then("user scroll down to till element is visible")
	public void user_scroll_down_to_till_visible() {
		fraudCase.scrollDown();
	}

	@Then("user verifies {string} list values")
	public void user_verifies_list_values(String string, DataTable data) throws Exception {
		try {
			List<String> actual = data.asList();
			System.out.println(actual.size());
			Thread.sleep(2000);
			String listofvalues = genericCases.read_list_items(string);
			System.out.println("listofvalues = "+listofvalues);
			
			
			for (int i = 0; i <= actual.size() - 1; i++) {
				// System.out.println(actual.get(i));
				System.out.println("Actual is " + actual.get(i));
				Thread.sleep(1000);
				assertion.CheckAssertionTrue(listofvalues.contains(actual.get(i)),actual.get(i));				
				
				//assertion.CheckAssertionTrue(listofvalues.contains(actual.get(i)));				
				
			}
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	
	//@Then("user validate the views are not displayed")
	@Then ("user verifies {string} does not contains the below list")
	public void user_validate_the_views_not_displayed(String string ,DataTable table) {
		List<String> columnList = table.asList();
		Wait.untilPageLoadComplete(driver, 500);
		
		String expected = driver.findElement(By.xpath("//input[@aria-label='Case Closure Reason, Lookup']")).getAttribute("textContent");
System.out.println("expected is ::" + expected);
		for (int i = 0; i < columnList.size(); i++) {
			
			assertion.CheckAssertionTrue(expected!=(columnList.get(i)), columnList.get(i));
			
		}

	}
	@Then ("user verifies {string} field does not contains the below list")
	public void user_validate_the_list_not_displayed(String remoteditem ,DataTable table) {
		List<String> columnList = table.asList();
		Wait.untilPageLoadComplete(driver, 500);
		
		String expected = driver.findElement(By.xpath("//select[@aria-label='" + remoteditem + "']")).getAttribute("textContent");
System.out.println("expected is ::" + expected);
		for (int i = 0; i < columnList.size(); i++) {
			
			assertion.CheckAssertionTrue(expected!=(columnList.get(i)), columnList.get(i));
			
		}

	}

	@Then("user click on Tab {string} for selecting {string}")
	public void user_click_on_Tab_for(String tabname, String Value) throws Exception {
		Thread.sleep(2000);
		fraudCase.clickRelatedTab(tabname);
		Thread.sleep(2000);
		System.out.println(Value);
		fraudCase.SelectTabMenuItem(Value);
	}

	@Then("user verifies the fields are displayed in the Audit History")
	public void user_verifies_the_fields_displayed(DataTable data) throws InterruptedException {
		try {
			List<String> actual = data.asList();
			SoftAssert softAssert = new SoftAssert();
			Boolean isFilteronFieldDislayed = fraudCase.isFilteronFieldDislayed();
			Map<String, Boolean> map = fraudCase.isDatagridFieldDislayed(data);
			// Assert.assertTrue(isFilteronFieldDislayed);
			assertion.CheckAssertionTrue(isFilteronFieldDislayed,"");
			

			for (int i = 0; i <= actual.size() - 1; i++) {
				System.out.println(actual.get(i) + "=" + map.get(actual.get(i)));
				// Assert.assertEquals(true, map.get(actual.get(i)));
				// softAssert.assertEquals("true", map.get(actual.get(i)));

				assertion.CheckAssertionTrue(map.get(actual.get(i)),"");

			//	assertion.CheckAssertionTrue(map.get(actual.get(i)));
				// Validator.verifyTrue(true,map.get(actual.get(i)));
				// verifyTrue('testCase',isequal(true,map.get(actual.get(i))));
				// softAssert.assertThat(true).isEqualTo(map.get(actual.get(i)));
				softAssert.assertAll();
			}
		} catch (Exception e) {
		}
		// softAssert.assertAll();
	}

	@Then("user verifies New Value field for new Fraud Case in the audit details")
	public void user_verifies_New_Value_field_new_Fraud_Case_in_audit_details() throws InterruptedException {
		try {
			Integer actual = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ]")).size();

			System.out.println("length=" + actual);
			for (int i = 1; i <= actual; i++) {
				String st = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[4]"))
						.get(0).getAttribute("textContent");
				System.out.println(st);
				if (st == "Create") {
					// System.out.println("changed field -- " +
					// driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit'
					// ][\"+i+\"]/td[5]")).get(0).getAttribute("innerText"));
					System.out.println("old value -- "
							+ driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][\"+i+\"]/td[6]"))
									.get(0).getAttribute("innerText"));
					System.out.println("new value -- "
							+ driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][\"+i+\"]/td[7]"))
									.get(0).getAttribute("innerText"));
					assertion.CheckAssertionNull(
							driver.findElement(By.xpath("//*[@role='row' and @otypename ='audit' ][\"+i+\"]/td[7]")));
					// Assert.assertNull(
					// driver.findElement(By.xpath("//*[@role='row' and @otypename ='audit'
					// ][\"+i+\"]/td[7]"))
					// .getAttribute("innerText"));
				}
			}
		} catch (Exception e) {
		}
		;
		/*
		 * Integer intnooffields = driver .findElements(By.xpath(
		 * "//td/nobr[@title='Create']/parent::td/following-sibling::td[2]/nobr")).size(
		 * );
		 *
		 * System.out.println(intnooffields);
		 *
		 * for (int i = 0; i <= intnooffields - 1; i++) { System.out.println(
		 * driver.findElements(By.xpath(
		 * "//td/nobr[@title='Create']/parent::td/following-sibling::td[2]/nobr"))
		 * .get(i).getAttribute("innertext")); Assert.assertNull(
		 * driver.findElements(By.xpath(
		 * "//td/nobr[@title='Create']/parent::td/following-sibling::td[2]/nobr"))
		 * .get(i).getAttribute("innertext"));
		 */
	}

	@Then("user click on Tab {string}")
	public void user_click_on_Tab(String tabname) throws Exception {
		fraudCase.clickSummaryTab(tabname);
	}
//	@Then("user fill all the details for {string} as {string}")
//	public void user_fill_all_the_details(String field,String value) throws InterruptedException {
//	Wait.untilPageLoadComplete(driver);
//	cases.fillDetails(field,value);
//	if(value.contains("ASB"))
//	{
//	Wait.untilPageLoadComplete(driver);
//	driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB,Keys.PAGE_DOWN);
//	Wait.untilPageLoadComplete(driver);
//	testUtil.jsclick(cases.Category("ASB Case Category"), driver);
//	testUtil.selectByVisibleText(driver, cases.Category("ASB Case Category"), "Noise");
//	Thread.sleep(2000);
//	cases.Category("ASB Type").click();
//	testUtil.selectByVisibleText(driver, cases.Category("ASB Type"), "Music");
//	}}	

	@Then("user verifies New Value {string} field for updated Field {string} in the audit details")
	public void user_verifies_New_Value_field_for_updated_Fraud_Case_in_the_audit_details(String newvalue,
			String updatedField) throws Exception {
		System.out.println("updating update");
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='audit_iframe']")));
			Wait.untilPageLoadComplete(driver);
			System.out.println(
					"inner" + driver.findElement(By.xpath("//tr[@otypename='audit']")).getAttribute("innertext"));

			Thread.sleep(2000);
			Integer ii = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ]")).size();
			System.out.println(ii);
			for (int i = 1; i <= ii; i++) {
				System.out.println(
						driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[5]"))
								.get(0).getAttribute("innerText"));
				String s = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[5]"))
						.get(0).getAttribute("innerText");
				String strExpected = "No No    No No";
				strExpected = strExpected.trim(); 
				System.out.println(updatedField);
				if (s == updatedField) {
					System.out.println("assertion for old value");
					String strOldValue = driver
							.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[6]")).get(0)
							.getAttribute("textContent");
					System.out.println("Old Value = " + strOldValue);

					assertion.CheckAssertionTrue(strOldValue.contains("No"),"No");
					//Assert.assertTrue(strOldValue.contains("No"));
					System.out.println("assertion for New value");
					String strNewValue = driver
							.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[7]")).get(0)
							.getAttribute("textContent");
					System.out.println("New Value = " + strNewValue);
					assertion.CheckAssertionTrue(strNewValue.contains(newvalue),newvalue);

					//Assert.assertTrue(strNewValue.contains(newvalue));
				}
			}
		} catch (Exception e) {
		}
		;
	}

	@Then("user remove the field {string} value {string} is updating in Audit History")
	public void user_verifies_removed_field_value_updating_Audit_History(String ss, String value) throws Exception {
		try {fraudCase.clickSummaryTab("Summary");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@aria-label='" + value + "']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//button[contains(@aria-label, '" + value + "')]"))).build()
				.perform();
		contact.clickOnSave();
		}catch(Exception e) {};
	}

	@Then("user verifies removed {string} field for updated Field {string} in the audit details")
	public void user_verifies_removed_field__in_the_audit_history(String newvalue, String updatedField)
			throws Exception {
		try {System.out.println("checking remove field");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='audit_iframe']")));
		Wait.untilPageLoadComplete(driver);
		System.out
				.println("inner" + driver.findElement(By.xpath("//tr[@otypename='audit']")).getAttribute("innertext"));
		Thread.sleep(1000);
		Integer ii = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ]")).size();
		System.out.println(ii);
		for (int i = 1; i <= ii; i++) {
			System.out
					.println(driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[5]"))
							.get(0).getAttribute("innerText"));
			String s = driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[5]"))
					.get(0).getAttribute("innerText");
			String strExpected = " ";
			strExpected = strExpected.trim();
			System.out.println(newvalue);
			if (s == updatedField) {
				System.out.println("assertion for old value");
				assertion.CheckAssertion(newvalue, driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[6]"))
								.get(0).getAttribute("textContent"));
				//Assert.assertEquals(newvalue,
						//driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[6]"))
								//.get(0).getAttribute("textContent"));
				System.out.println("assertion for New value");
				assertion.CheckAssertion(strExpected, driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[7]"))
						.get(0).getAttribute("textContent"));
				//Assert.assertEquals(strExpected,
						//driver.findElements(By.xpath("//*[@role='row' and @otypename ='audit' ][" + i + "]/td[7]"))
								//.get(0).getAttribute("textContent"));
			}
		}}catch(Exception e) {}
	}

	@Then("user verifies the date stored for {string}")
	public void user_verifies_date_stored(String field) {
		//SoftAssert softassert = new SoftAssert();
		try {DateFormat indianFormat = new SimpleDateFormat("dd/MM/yyyy");
		indianFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Date timestamp = new Date(System.currentTimeMillis());
		String output = indianFormat.format(timestamp);
		System.out.println("Stored time :" + output);
		String date = fraudCase.getDate(field);
		assertion.CheckAssertion(output, date);
		//softassert.assertEquals(output, date, "The date populated is " + output + " instead of " + date);
	}catch(Exception e) {}
	}

	@And("user fill all questions for FraudChecklist")
	public void user_fill_all_questions_for_FraudChecklist() {
		fraudCase.selectTab("Fraud Check List");
		com.answer_all_questions(fraudCase.fraudCheckListQns);
	}

	@Then("user validates the case displayed")
	public void user_validates_the_case_displayed() {
		try {fraudCase.selectTab("Summary");
		System.out.println("getheadertitle " + fraudCase.getHeaderTitle());
		String[] casevalid = fraudCase.getHeaderTitle().split(",");
		for (int i = 0; i < casevalid.length; i++) {
			//Assert.assertTrue(fraudCase.getCaseTitle().contains(casevalid[i].trim()),
					//"Case Header doesn't contain " + casevalid[i]);		

			assertion.CheckAssertionTrue(fraudCase.getCaseTitle().contains(casevalid[i].trim()),casevalid[i].trim());}
			//assertion.CheckAssertionTrue(fraudCase.getCaseTitle().contains(casevalid[i].trim()));}
	}catch(Exception e) {};
	}
}
