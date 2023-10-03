package com.sat.StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.sat.Pages.CasePage;
import com.sat.Pages.CustomerPage;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();

	private CustomerPage accountpage = new CustomerPage(driver);
	private CasePage cases = new CasePage(driver);
	Actions actions = new Actions(driver);
	Assertions assertion = new Assertions(driver);

	Testutil testUtil = new Testutil(driver);

		
	@When("user click on {string} under customer")
	public void user_click_on_under_customer(String tab) {
		try {
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (!driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).isEmpty())
				driver.findElement(By.xpath("//button[@aria-label='Discard changes']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			accountpage.entity(tab);
			System.out.println("User clicked on " + tab);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Dismiss")
	public void user_click_on_dismiss() {
		driver.findElement(By.xpath("//button[@aria-label='Dismiss']")).click();
		actions.sendKeys(Keys.SPACE).build().perform();

	}

	@When("user click on {string} under Site Map")
	public void user_click_on_under_SiteMap(String tab) {
		try {
			Thread.sleep(2500);
			accountpage.entity(tab);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user search SL Account Name as {string}")
	public void user_search_SL_Account_Name_as(String string) throws InterruptedException {
		System.out.println(string);
		String name = string;
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name, Keys.ENTER);

		Thread.sleep(2000);
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[text()='"
		// + name + "']"))));
		testUtil.jsclick(driver.findElement(By.xpath("//*[@aria-rowindex='2']//*[@aria-colindex='3']")), driver);
		actions.doubleClick(driver.findElement(By.xpath("//*[@aria-rowindex='2']//*[@aria-colindex='3']"))).build()
				.perform();

		Thread.sleep(3000);
		Wait.untilPageLoadComplete(driver, 500);
	}

	@Then("user fill all the details for {string} as {string}")
	public void user_fill_all_the_details(String field, String value) throws InterruptedException {
		try {
			Thread.sleep(2000);
			Wait.untilPageLoadComplete(driver, 8);
			cases.fillDetails(field, value);
			if (value.contains("ASB")) {
				Wait.untilPageLoadComplete(driver, 5);
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB, Keys.PAGE_DOWN);
				Wait.untilPageLoadComplete(driver, 5);
				Thread.sleep(2000);
				testUtil.jsclick(cases.Category("ASB Case Category"), driver);
				testUtil.selectByVisibleText(driver, cases.Category("ASB Case Category"), "Noise");
				Thread.sleep(2000);
				cases.Category("ASB Type").click();
				testUtil.selectByVisibleText(driver, cases.Category("ASB Type"), "Music");
				System.out.println("fille field = " + field);
			}
			// String val = field.toLowerCase();
			// String exepected=
			// driver.findElement(By.xpath("//div[contains(@data-id,'ResultsDropdown_po_"+val+"_selected_tag')]")).getAttribute("textContent");
			// System.out.println(exepected);
			// assertion.CheckAssertionTrue(exepected.contains(value), exepected);

		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on discard button")
	public void click_discard_button() {
		if (driver.findElements(By.xpath("//*[text()='Discard changes']/parent::button")).size() != 0) {
			actions.moveToElement(driver.findElement(By.xpath("//*[text()='Discard changes']/parent::button"))).build()
					.perform();
			actions.click(driver.findElement(By.xpath("//*[text()='Discard changes']/parent::button"))).build()
					.perform();
		}
	}

	@Then("user click on save and continue button")
	public void click_Saveandcontinue_button() {
		if (driver.findElements(By.xpath("//*[text()='Save and continue']/parent::button")).size() != 0) {
			actions.moveToElement(driver.findElement(By.xpath("//*[text()='Save and continue']/parent::button")))
					.build().perform();
			actions.click(driver.findElement(By.xpath("//*[text()='Save and continue']/parent::button"))).build()
					.perform();
		}
	}

	@Then("user fill all the details for {string}")
	public void user_fill_all_the_details_for_PrefferedProperty(String string) {
		driver.findElement(By.xpath("//input[@aria-label='Preferred Property, Lookup']")).click();
		driver.findElement(By.xpath(
				"	//div[@data-id='po_preferredproperty.fieldControl-LookupResultsDropdown_po_preferredproperty_microsoftIcon_new_container']"))
				.click();
		driver.findElement(By.xpath("//input[@aria-label='Account Name']")).sendKeys("Test");
		driver.findElement(By.xpath("//button[@aria-label='Save and Close']")).click();

	}

	@Then("user enter the details for Subcategory as {string}")
	public void user_enter_the_details_for_Subcategory(String fieldvalue) throws InterruptedException {

		driver.findElement(By.xpath("//input[contains(@aria-label,'Subcategory, Lookup')]")).click();
		Thread.sleep(1500);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Subcategory, Lookup']")), fieldvalue).build()
				.perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();

	}

	@Then("user fill all the details for Stage 1 Complaint Specialist as {string}")
	public void user_fill_all_the_details_for_Stage_1_Complaint_Specialist_as(String fieldvalue)
			throws InterruptedException {

		// if (driver.findElements(By.xpath("//span[text()='Discard
		// changes']//parent::button")).size()!=0)
		// testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Discard
		// changes']//parent::button")), 10);

		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@aria-label='Complaint Ownership']")));

		actions.moveToElement(driver.findElement(By.xpath("//section[@aria-label='Complaint Ownership']"))).build()
				.perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Stage 1: Complaint Specialist, Lookup')]")).click();
		Thread.sleep(1500);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Stage 1: Complaint Specialist, Lookup']")),
				fieldvalue).build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();
	}

	@Then("user fill all the details for Stage 2 Complaint Specialist as {string}")
	public void user_fill_all_the_details_for_Stage_2_Complaint_Specialist_as(String fieldvalue)
			throws InterruptedException {

		if (driver.findElements(By.xpath("//span[text()='Discard changes']//parent::button")).size() != 0)
			testUtil.clickOn(driver, driver.findElement(By.xpath("//span[text()='Discard changes']//parent::button")),
					10);
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//section[@aria-label='Complaint Ownership']")));

		actions.moveToElement(driver.findElement(By.xpath("//section[@aria-label='Complaint Ownership']"))).build()
				.perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[contains(@aria-label,'Stage 2: Complaint Specialist, Lookup')]")).click();
		Thread.sleep(1500);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Stage 2: Complaint Specialist, Lookup']")),
				fieldvalue).build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();
	}

	@Then("user fill all the details for Service Area as {string}")
	public void user_fill_all_the_details_for_Service_Area_as(String fieldvalue) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@aria-label,'Service Area, Lookup')]")).click();
		Thread.sleep(1500);
		actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Service Area, Lookup']")), fieldvalue)
				.build().perform();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[contains(@aria-label,'" + fieldvalue + "')]")).click();
	}

	@When("user click on {string} under Service")
	public void user_click_on_under_service(String tab) {
		try {
			accountpage.entity(tab);
			Wait.untilPageLoadComplete(driver, 5);
			System.out.println("user clicked on tab : " + tab);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}
	}

	@And("user verify left side pane under customer")
	public void user_verify_left_side_pane_under_customer() throws InterruptedException {
		try {
			accountpage.verifyleftsidepane();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}
	}

	@And("user click on Drop Down List")
	public void user_click_on_drop_Down_List() {
		try {
			Thread.sleep(1500);
			accountpage.clickonDropdownList();
			System.out.println("user clicked on down arrow");
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user validate the views")
	public void user_validate_the_views(DataTable table) {
		List<String> columnList = table.asList();
		Wait.untilPageLoadComplete(driver, 500);
		
		String expected = driver.findElement(By.xpath("//div[@aria-label='Views']")).getAttribute("textContent");

		for (int i = 0; i < columnList.size(); i++) {
			
			assertion.CheckAssertionTrue(expected.contains(columnList.get(i)), columnList.get(i));
			
		}

	}
	
	@Then("user validate the views are not displayed")
	public void user_validate_the_views_not_displayed(DataTable table) {
		List<String> columnList = table.asList();
		Wait.untilPageLoadComplete(driver, 500);
		
		String expected = driver.findElement(By.xpath("//div[@aria-label='Views']")).getAttribute("textContent");
System.out.println("expected is ::" + expected);
		for (int i = 0; i < columnList.size(); i++) {
			
			assertion.CheckAssertionTrue(expected!=(columnList.get(i)), columnList.get(i));
			
		}

	}

	@And("user click on Case Item Audit Drop Down List")
	public void user_click_on_Case_Item_Audit_Drop_Down_List() {
		try {
			Thread.sleep(1500);
			accountpage.clickonCaseItemAuditDropdownList();
			System.out.println("user clicked on down arrow");
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@And("user click on Case Drop Down List")
	public void user_click_on_Casedrop_Down_List() {
		try {
			accountpage.clickonCaseDropdownList();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}
	}

	@And("user select {string} from drop down list")
	public void user_select_from_drop_down_list(String option) throws InterruptedException {
		try {
			accountpage.clickonAllAccount(option);
			Wait.untilPageLoadComplete(driver, 5);
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[text()='"+option+"']")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (!driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).isEmpty())
				driver.findElement(By.xpath("//button[@aria-label='Discard changes']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("user selects : " + option);
		}

		catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
	
	

	@Then("user filters {string} cases on {string} column")
	public void user_filter_cases(String Filterby, String columnName) {
		actions.click(driver.findElement(By.xpath("//*[text()='" + columnName + "']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='Filter by']"))).build().perform();
		actions.click(driver.findElement(By.xpath("//div[@aria-label='Filter by value']"))).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		actions.click(driver.findElement(By.xpath("//span[contains(text(),'" + Filterby + "')]//parent::label")))
				.build().perform();
		actions.sendKeys(Keys.ESCAPE).build().perform();
		actions.click(driver.findElement(By.xpath("//span[text()='Apply']"))).build().perform();
	}

	@Then("user selects record with status {string}")
	public void user_selects_record(String s) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testUtil.jsclick(driver.findElement(By.xpath("(//*[text()='" + s + "'])[1]")), driver);

		actions.click(driver.findElement(By.xpath("//div[@aria-rowindex='2']//div[@aria-colindex='2']"))).build()
				.perform();

	}

	@And("user select {string} from drop down")
	public void user_select_from_drop_down(String option) throws InterruptedException {
		try {
			accountpage.clickonQueue(option);
			Wait.untilPageLoadComplete(driver, 5);
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}
	}

	@When("user select a queue filter {string}")
	public void user_select_a_queue_filter(String filter) throws InterruptedException {
		try {
			accountpage.selectQueueFilter(filter);
			Wait.untilPageLoadComplete(driver, 5);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}
	}

	@Then("user enter {string} in search text box and validate text")
	public void user_enter_text_in_search_text_box(String SearchText) throws InterruptedException {
		try {
			accountpage.Entertextinsearch(SearchText);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}

	}

	@Then("user enter {string} in global search text box and validate text")
	public void user_enter_text_in_global_search_text_box(String SearchText) throws InterruptedException {
		try {
			accountpage.enterTextInGlobalSearch(SearchText);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}

	}

	@And("user click on search icon")
	public void user_click_on_search_icon() {
		try {
			accountpage.clickonsearchicon();
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}

	}

	@Then("search result is display{string}")
	public void search_result_is_display(String searchtext) {
		try {
			accountpage.verifysearchresult(searchtext);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");

		}

	}

	@Then("user click on Blocks entity and verify local search")
	public void user_click_on_Blocks_entity_and_verify_local_search(DataTable dataTable) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Blocks']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Neighborhoods entity and verify local search")
	public void user_click_on_Neighborhoods_entity_and_verify_local_search(DataTable dataTable)
			throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Neighborhoods']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Schemes entity and verify local search")
	public void user_click_on_Schemes_entity_and_verify_local_search(DataTable dataTable) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Schemes']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}

	}

	@Then("user click on Contacts entity and verify local search")
	public void user_click_on_Contacts_entity_and_verify_local_search(DataTable dataTable) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Contacts']")).click();
			Thread.sleep(2000);
			accountpage.clickonDropdownList();
			driver.findElement(By.xpath("//*[text()='All Contacts']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Data Protection entity and verify local search")
	public void user_click_on_Data_Protection_entity_and_verify_local_search(DataTable dataTable)
			throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Data Protection']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Tenancies and verify local search")
	public void user_click_on_Tenancies_and_verify_local_search(DataTable dataTable) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//div[@title='Tenancies']")).click();
			Thread.sleep(2000);
			accountpage.localSearch(dataTable);
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}

	@Then("user click on Knowledge Articles and verify local search")
	public void user_click_on_Knowledge_Articles_and_verify_local_search(DataTable dataTable) {

	}

	@Then("user fill the details for primary contact as {string}")
	public void user_fill(String string) throws InterruptedException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//input[@aria-label='Primary Contact, Lookup']")));
		actions.click(driver.findElement(By.xpath("//input[@aria-label='Primary Contact, Lookup']"))).build().perform();
		Thread.sleep(1000);
		// actions.sendKeys(driver.findElement(By.xpath("//input[@aria-label='Primary
		// Contact, Lookup']")), string).build().perform();

		actions.click(driver.findElement(By.xpath("//li[@aria-label='" + string + "']"))).build().perform();
		Thread.sleep(2000);
	}

	@Then("user fill the details for Quick create {string} field as {string}")
	public void user_fill_the_details_for_Quick_create_as(String fieldvalue, String value) throws InterruptedException {
		driver.findElement(By.xpath("(//input[@aria-label='" + fieldvalue + "'])[2]")).click();
		Thread.sleep(1500);
		actions.sendKeys(driver.findElement(By.xpath("(//input[@aria-label='" + fieldvalue + "'])[2]")), value).build()
				.perform();
		Thread.sleep(1500);
		// driver.findElement(By.xpath("//li[contains(@aria-label,'"+fieldvalue+"')]")).click();
	}

	@Then("user verify the Test additional popup")
	public void user_verify_the_Test_additional_popup() throws InterruptedException {
		try {
			Thread.sleep(2000);
			String Expected = "Test Additional link";
			WebElement Actual = driver.findElement(By.xpath("//h1[@aria-label='Test Additional link']"));
			Assert.assertEquals(Expected, Actual.getText());
			System.out.println(Actual.getText());
		} catch (Exception e) {
			System.out.println("Exception :" + e + " has occurred");
		}
	}
}
