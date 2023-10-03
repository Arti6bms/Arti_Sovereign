package com.sat.StepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sat.Pages.Assessment_ET;
import com.sat.Pages.CasePage;
import com.sat.Pages.ContactForm;
import com.sat.Pages.FraudCase;
import com.sat.Pages.GenericCases;
import com.sat.Pages.Neighborhoods;
import com.sat.Pages.NewContacts;
import com.sat.Pages.Queue;
import com.sat.Pages.SLATimer;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class NeighborhoodsStepDefs {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	Neighborhoods neighborhoods = new Neighborhoods(driver);
	Testutil testutil = new Testutil(driver);
	public ContactForm contact = new ContactForm(driver);
	Actions actions = new Actions(driver);
	HashMap<Integer, String> casetitle = new HashMap<>();
	Queue queue = new Queue(driver);
	Properties prop = new Properties();
	String workingDir = System.getProperty("user.dir");
	NewContacts newContacts = new NewContacts(driver);
	Assertions assertion = new Assertions(driver);
	GenericCases genericCases = new GenericCases(driver);
	// CommonUtilStepDefs commonUtilStepDefs = new CommonUtilStepDefs(driver);
	FraudCase fraudCase = new FraudCase(driver);
	public CasePage cases = new CasePage(driver);
	SLATimer slatimer = new SLATimer(driver);
	Assessment_ET assessment_ET = new Assessment_ET(driver);
	HashMap<String, String> phone = new HashMap<>();

	@Then("user picks the Neighborhood name")
	public void user_picks_the_Neighborhood_name() {
		try {
			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			System.out.println(workingDir);
			Properties NeighborhoodName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Neighborhoods.properties");
			System.out.println("NeighborhoodName: " + NeighborhoodName.getProperty("NeighborhoodName"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='text']"))
					.sendKeys(NeighborhoodName.getProperty("NeighborhoodName"), Keys.ENTER);
			Wait.untilPageLoadComplete(driver);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			Thread.sleep(3000);

			assertion.CheckAssertionTrue(driver
					.findElements(By.xpath("//span[text()='" + NeighborhoodName.getProperty("NeighborhoodName") + "']"))
					.size() != 0, NeighborhoodName.getProperty("NeighborhoodName"));

			try {
				if (driver
						.findElements(
								By.xpath("//span[text()='" + NeighborhoodName.getProperty("NeighborhoodName") + "']"))
						.size() != 0) {
					System.out.println("in if");
					queue.clickOnQueue(NeighborhoodName.getProperty("NeighborhoodName"));
				} else {
					System.out.println("in else");
					// assertion.CheckAssertionTrue(driver.findElement(By.xpath("//span[text()='"+NeighborhoodName.getProperty("NeighborhoodName")+"']")),
					// NeighborhoodName.getProperty("NeighborhoodName"));
					// assertion.checkValueExists(NeighborhoodName.getProperty("NeighborhoodName"));
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block;
				// System.out.println("No search results for : " +
				// NeighborhoodName.getProperty("NeighborhoodName") );
				throw new NoSuchElementException(
						"No search results for : " + NeighborhoodName.getProperty("NeighborhoodName"));

			}

		} catch (Exception e) {
			System.out.println(e);
			// ExtentCucumberAdapter.getCurrentStep().info(e);
		}
	}

	@Then("user verifies following fields are mandatory")
	public void user_verifies_following_fields_are_mandatory(DataTable data) throws Exception {
		List<String> actual = data.asList();
		System.out.println("size = " + actual.size());

		for (int i = 0; i <= actual.size() - 1; i++) {
			int j = i + 1;
			System.out.println(i);
			Thread.sleep(2000);
			assertion.CheckAssertion(
					driver.findElement(By.xpath("(//*[contains(@id,'required-icon')]/parent::div/div/span)[" + j + "]"))
							.getAttribute("innerText"),
					actual.get(i));
			Thread.sleep(2000);
		}
	}

	@Then("user updates the {string}")
	public void user_updates_the_owner(String s) {
		try {
			Wait.untilPageLoadComplete(driver);
			String ownerName = neighborhoods.objOwnerfield.getAttribute("innerText");
			System.out.println("Contact Name = " + ownerName);

			Properties NeighborhoodName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Neighborhoods.properties");
			Thread.sleep(3000);
			actions.moveToElement(driver.findElement(
					By.xpath("//ul[@data-id='ownerid.fieldControl-LookupResultsDropdown_ownerid_SelectedRecordList']")))
					.build().perform();
			// Thread.sleep(3000);
			actions.click(driver.findElement(By.xpath("//button[contains(@aria-label, 'Delete " + ownerName + "')]")))
					.build().perform();

			neighborhoods.objOwnerLookupfield.click();
			Thread.sleep(1000);
			neighborhoods.objOwnerLookupfield.sendKeys(NeighborhoodName.getProperty("OwnerName"));

			Wait.untilPageLoadComplete(driver);
			driver.findElement(By.xpath("//span[text()='" + NeighborhoodName.getProperty("OwnerName") + "']")).click();

			queue.objSave.click();

			assertion.CheckAssertionTrue(neighborhoods.objOwnerfield.getAttribute("innerText")
					.contains(NeighborhoodName.getProperty("OwnerName")), NeighborhoodName.getProperty("OwnerName"));

//			assertion.CheckAssertion(neighborhoods.objOwnerfield.getAttribute("innerText"),
//					NeighborhoodName.getProperty("OwnerName"));

		} catch (

		Exception e) {
			System.out.println(e);
			// ExtentCucumberAdapter.getCurrentStep().info(e);
		}
	}

	@Then("user verifies neighborhood frequency")
	public void user_verifies_neighborhood_frequency(DataTable data) throws Exception {
		List<String> actual = data.asList();
		String frequencies = neighborhoods.objFrequencyfield.getAttribute("innerText");
		System.out.println(frequencies);
		String[] frequenciesSplit = frequencies.split("\n");
		if (actual.size() == frequenciesSplit.length) {
			for (int i = 0; i <= actual.size() - 1; i++) {
				System.out.println(actual.get(i) + "==" + frequenciesSplit[i]);
				assertion.CheckAssertion(actual.get(i), frequenciesSplit[i]);
				testutil.selectByVisibleText(driver, neighborhoods.objFrequencyfield, "<newold Value>");
			}
		}
	}

	@Then("user verifies the field {string}")
	public void user_verifies_(String fieldName, DataTable data) throws Exception {
		try {
			List<String> actual = data.asList();
			System.out.println(" Size of the data table is : " + actual.size());

			for (int i = 0; i <= actual.size() - 1; i++) {
				Thread.sleep(2000);
				System.out.println(actual.get(i) + " for " + i);
				actions.click(driver.findElement(By.xpath("//select[@aria-label='" + fieldName + "']"))).build()
						.perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//select[@aria-label='" + fieldName + "']")).sendKeys(actual.get(i));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//select[@aria-label='" + fieldName + "']")).click();
				Thread.sleep(2000);

				assertion.CheckAssertion(actual.get(i), driver
						.findElement(By.xpath("//select[@aria-label='" + fieldName + "']")).getAttribute("title"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate assets linked to that neighborhood")
	public void user_validate_assets_linked_to_that_neighborhood() throws Exception {

		Integer pagecount = 0;
		Thread.sleep(2000);

		String noofRowsinFirstpage = driver
				.findElement(By.xpath("//section[@data-id='tab_3_section_1']//div[@data-id='grid-container']"))
				.getAttribute("childElementCount");

//		String noofRowsinFirstpage = driver.findElement(By.xpath("//div[@ref='eContainer' and @role='rowgroup']"))
//				.getAttribute("childElementCount");

		Integer pp = Integer.parseInt(noofRowsinFirstpage);
		System.out.println("noofRowsinFirstpage : " + pp);

		System.out.println("page Num in " + driver
				.findElement(By.xpath("//span[contains(@class,'page')]//div[contains(@class,'screenReaderText')]"))
				.getText().replace("Page ", ""));

		String pagestatus = driver.findElement(By.xpath("(//div[@role= 'status'])[2]")).getAttribute("outerText");

		System.out.println("page status is " + pagestatus);

		String[] arr = pagestatus.split(" ");

		System.out.println(Integer.parseInt(arr[2]) + " and " + Integer.parseInt(arr[4]));

		Integer Totalpagecount = Integer.parseInt(arr[4]) % Integer.parseInt(arr[2]);

		System.out.println(Totalpagecount);
		Integer z = 0;

		// for (int i = 1; i < Totalpagecount; i++) {

		actions.moveToElement(driver.findElement(By.xpath("(//div[@role= 'status'])[2]"))).build().perform();

		for (int j = 1; j <= Integer.parseInt(arr[4]); j++) {

			Wait.untilPageLoadComplete(driver);
			// actions.moveToElement(driver.findElement(By.xpath("(//div[@ref='eContainer'
			// and @role='rowgroup']/div/div[2])[" + j + "]"))).build().perform();
			Thread.sleep(5000);
			// actions.click(driver.findElement(By.xpath("(//div[@ref='eContainer' and
			// @role='rowgroup']/div/div[2])[" + j + "]"))).build().perform();
			// *[@role='link']
			int x = j + 1;

			actions.click(driver.findElement(By.xpath("//div[@data-id='grid-container']//div[@aria-rowindex='" + x
					+ "']//div[@aria-colindex='2']//*[@role='link']"))).build().perform();

			// div[@data-id='grid-container']//div[@aria-rowindex='"+j+1+"']//div[@aria-colindex='"+j+1+"']//*[@role='link']

			// section[@data-id='tab_3_section_1']//div[@data-id='grid-container']//div[@x='2']

			// (//section[@data-id='tab_3_section_1']//div[@data-id='grid-container']//div//div[2]//*[@role='link'])[1]

//			actions.click(driver.findElement(
//					By.xpath("(//div[@ref='eContainer' and @role='rowgroup']/div/div[2])[" + j + "]//*[@role='link']")))
//					.build().perform();

			Wait.untilPageLoadComplete(driver);
			Thread.sleep(4000);
			// driver.findElement(By.xpath("//button[@title='Go back']")).wait(3000);

			Wait.untilPageLoadComplete(driver);
			Thread.sleep(3000);
			// System.out.println("Asset == "
			// +
			// driver.findElement(By.xpath("//div[@aria-label='Asset']")).getAttribute("textContent"));
			assertion.CheckAssertion("Asset",
					driver.findElement(By.xpath("//div[@aria-label='Asset']")).getAttribute("textContent"));
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@title='Go back']")).click();
			if (driver.findElements(By.xpath("//button[@aria-label='Discard changes']")).size() != 0)
				testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Discard changes']")), 10);
			System.out.println(j + " j is ::" + pp);
			System.out.println(z + " Z is ::" + pp);

			if (j >= pp) {
				z = z + 1;
				Thread.sleep(2000);
				actions.moveToElement(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).build()
						.perform();
				actions.click(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).build().perform();
				j = 0;
				Thread.sleep(2000);
//				String s = driver.findElement(By.xpath("//div[@ref='eContainer' and @role='rowgroup']"))
//						.getAttribute("childElementCount");
				String s = driver
						.findElement(By.xpath("//section[@data-id='tab_3_section_1']//div[@data-id='grid-container']"))
						.getAttribute("childElementCount");
				pp = Integer.parseInt(s);
				// System.out.println(z+"::"+pp);
			}

			if (z > 1 && z < Totalpagecount) {
				Thread.sleep(2000);
				System.out.println("inside if");

				for (int a = 1; a <= z; a++) {
					System.out.println("inside for");
					actions.moveToElement(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).build()
							.perform();
					actions.click(driver.findElement(By.xpath("//button[@aria-label = 'Next page']"))).build()
							.perform();
				}
			}
			if (z > Totalpagecount) {
				break;
			}
		}

	}

	// }

	@Then("user Click the + on the timeline and select {string}")
	public void user_Click_the_plus_on_the_timeline_and_select_appointment(String activity) throws Exception {
		try {
			Thread.sleep(5000);
//			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
//					driver.findElement(By.xpath("//button[@aria-label='Create a timeline record.']"))));
			testutil.clickOn(driver, neighborhoods.objCreatetimelinerecord, 10);

			String actual = driver.findElement(By.xpath("//li[@aria-label='" + activity + "']"))
					.getAttribute("outerText");
			System.out.println(actual);
			System.out.println(activity);
			assertion.CheckAssertionTrue(activity.contains(actual), actual);

			testutil.clickOn(driver, driver.findElement(By.xpath("//li[@aria-label='" + activity + "']")), 10);
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user Enter a {string}")
	public void user_enter_subject(String string) {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@aria-label='" + string + "']")).sendKeys(Keys.CONTROL + "A");
			driver.findElement(By.xpath("//input[@aria-label='" + string + "']")).sendKeys("Test Subject");
			Thread.sleep(3000);
			System.out.println("Value entered is : " + string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user Validate that the following fields are auto populated")
	public void user_Validate_that_the_following_fields_are_auto_populated(DataTable data) throws Exception {
		List<String> actual = data.asList();
		System.out.println(
				"Duration = " + driver.findElement(By.xpath("//input[@aria-label='Duration']")).getAttribute("title"));
		System.out.println("Appointment fixed = "
				+ driver.findElement(By.xpath("//select[contains(@aria-label,'Is appointment fixed time')]"))
						.getAttribute("title"));
		System.out.println("Regarding = " + driver
				.findElement(By.xpath("//div[@data-id='regardingobjectid.fieldControl-Lookup_regardingobjectid']"))
				.getAttribute("outerText"));

		actions.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		// actions.moveToElement(driver.findElement(By.xpath("//div[@data-preview_orientation='row'
		// and @data-id='isalldayevent']"))).build().perform();

		// System.out.println("All day event = " + driver
		// .findElement(By.xpath("//div[@data-id='isalldayevent.fieldControl-checkbox-container']"))
		// .getAttribute("title"));
		// System.out.println(
		// "VIP = " +
		// driver.findElement(By.xpath("//div[@data-id='po_vip.fieldControl-checkbox-container']"))
		// .getAttribute("title"));

	}

	@Then("user Save the appointment")
	public void user_Save_the_appointment() {
		try {
			Thread.sleep(2000);
			testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save and Close']")), 10);
//			if (driver.findElements(By.xpath("//button[contains(@data-id,'SaveAndClose')]")).size() != 0) {
//				testutil.clickOn(driver, driver.findElement(By.xpath("//button[contains(@data-id,'SaveAndClose')]")),
//						10);
//			} else {
//				
//				testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='Save and Close']")), 10);
//			}

			if (driver.findElements(By.xpath("//h1[@aria-label='Script Error']")).size() != 0)
				testutil.clickOn(driver, driver.findElement(By.xpath("//button[@aria-label='OK']")), 10);

			Thread.sleep(2000);

			if (driver.findElements(By.xpath("//h1[text()='Scheduling Alerts']")).size() != 0)
			{
				testutil.clickOn(driver,
						driver.findElement(By.xpath("//span[text()='Ignore And Save']//parent::button")), 10);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user Reopen the {string} from the timeline")
	public void user_Reopen_the_timeline(String s) throws Exception {
		Thread.sleep(6000);
		actions.moveToElement(driver.findElement(By.xpath("(//div[contains(@id,'timeline_record')])[1]"))).build()
				.perform();
		Thread.sleep(2000);

		if (driver.findElements(By.xpath("//a[@aria-label='Open Record']")).size() != 0) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@aria-label='Open Record']")).click();
		} else {
			driver.findElement(By.xpath("//*[@aria-label='Main actions']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Open Record']")).click();

		}

		// actions.click(driver.findElement(By.xpath("//a[@aria-label='Open
		// Record']"))).build().perform();

	}

	@Then("enter anything in the description box")
	public void enter_anything_in_the_description_box() throws Exception {
		try {
			Thread.sleep(3000);
			// iframe[@title="Description rich text editor"]
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Description rich text editor']")));
			// driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Description
			// rich text editor']")));
//			driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys("text");
//			driver.findElement(By.xpath("//textarea[@aria-label='Description']")).sendKeys(Keys.TAB);
			Thread.sleep(3000);
			actions.click(driver.findElement(By.xpath("//*[@title='Description rich text editor']"))).build().perform();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@title='Description rich text editor']")).sendKeys("text");
			driver.findElement(By.xpath("//*[@title='Description rich text editor']")).sendKeys(Keys.TAB);

			driver.switchTo().defaultContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user try to mark the appointment as close")
	public void user_try_to_mark_the_appointment_as_close() throws Exception {
		Thread.sleep(3000);
		System.out.println("in close appointment");
		if (driver.findElements(By.xpath("//button[@aria-label='Close Appointment']")).size() != 0) {
			System.out.println("Clickin if");
			driver.findElement(By.xpath("//button[@aria-label='Close Appointment']")).click();
		} else
		// (driver.findElements(By.xpath("//li[@title='More commands for
		// Appointment']")).size()!=0)
		{
			Thread.sleep(3000);
			System.out.println("Click More commands for Appointment");
			testutil.clickOn(driver,
					driver.findElement(By.xpath("//button[@aria-label='More commands for Appointment']")), 10);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Close Appointment']")).click();
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[text()='Close Appointment']/parent::button")).click();
		// driver.findElement(By.xpath("//span[text()='Save']")).click();

		System.out.println(
				driver.findElement(By.xpath("//h2[@data-id='errorDialog_subtitle']")).getAttribute("textContent"));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='OK']/parent::button")).click();

		// driver.findElement(By.xpath("//button[@aria-label='Close
		// Appointment']/span")).click();

		Thread.sleep(3000);

		// System.out.println(driver.findElement(By.xpath("//div[contains(@id,'dialogSubtitleContainer')]"))
		// .getAttribute("textContent"));
		// driver.findElement(By.xpath("//button[@data-id='errorOkButton']")).click();

	}

	@Then("user provide the Walkabout Rating and mark the appointment complete")
	public void user_provide_the_Walkabout_Rating_and_mark_the_appointment_complete() throws Exception {

		try {
			driver.findElement(By.xpath("//select[@aria-label='Rating']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@aria-label='Rating']")).sendKeys("1");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select[@aria-label='Rating']")).click();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath("//button[@aria-label='Close Appointment']")).size() != 0) {
				System.out.println("Clickin if");
				driver.findElement(By.xpath("//button[@aria-label='Close Appointment']")).click();
			} else {
				System.out.println("Click More commands for Appointment");
				testutil.clickOn(driver,
						driver.findElement(By.xpath("//button[@aria-label='More commands for Appointment']")), 10);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@aria-label='Close Appointment']")).click();
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[text()='Close Appointment']/parent::button")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@title='Go back']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies if {string} is closed")
	public void user_verifies_if_appointment_is_closed(String s) {
		try {
			System.out.println("User validating Task is closed");
			System.out.println(driver.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
					.getAttribute("outerText"));
			assertion.CheckAssertionTrue(
					driver.findElement(By.xpath("(//div[contains(@id,'timeline_record') and @role ='presentation'])[1]"))
							.getAttribute("outerText").contains("Closed"),
					"Closed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user verifies Timeline status")
	public void user_verifies_Timeline_status() {
		testutil.clickOn(driver, driver.findElement(By.xpath("//a[@aria-label='Julie Utting']")), 2);

	}

	@Then("user navigate to {string} view")
	public void user_navigate_to_view(String viewName) {

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='button' and contains(@id,'ViewSelector')]")).click();
			driver.findElement(By.xpath("//span[text()='" + viewName + "']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user validate Phone Number in the New Phone Call Form as empty")
	public void user_validate_Phone_Number_in_the_New_Phone_Call_Form() {
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//input[@aria-label='Phone Number']"))
				.getAttribute("textContent").isBlank(), "PhoneNumber");
	}

	@Then("user select one of active Case items")
	public void user_select_case_items() throws Exception {
		try {
			Thread.sleep(2000);
			Properties NeighborhoodName = testutil
					.readPropertiesFile(workingDir + "/src/main/java/com/sat/testData/Neighborhoods.properties");
			System.out.println("Active Neighborhood : " + NeighborhoodName.getProperty("ActiveCase"));
			String caseItem = NeighborhoodName.getProperty("ActiveCase");
			Thread.sleep(4000);
			testutil.sendKeys(driver,
					driver.findElement(By.xpath(
							"//input[@aria-label='Case Search this view' or @aria-label='Case Filter by keyword']")),
					10, caseItem);
			testutil.clickOn(driver, driver.findElement(By.xpath("//span[contains(@id,'quickFind')]")), 10);
			Thread.sleep(4000);
			assertion.CheckAssertionTrue(driver.findElements(
					// By.xpath("//div[@ref='eContainer']//div[@aria-RowIndex='2']//div[@aria-colindex='2']"))
					By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']")).size() != 0, caseItem);
			Thread.sleep(4000);
			testutil.clickOn(driver, driver.findElement(By.xpath("//div[@aria-RowIndex='2']//div[@aria-colindex='2']")),
					0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user selects {string}")
	public void user_selects_the_field(String fieldName) throws Exception {
		try {
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scrolling down the page till the element is found
	        js.executeScript("arguments[0].scrollIntoView();",
	                driver.findElement(By.xpath("//div[@data-id='po_neighbourhood']")));
		//	actions.moveToElement(driver.findElement(By.xpath("//div[@data-id='po_neighbourhood']"))).build().perform();
			Thread.sleep(2000);
			String s = (driver.findElement(By.xpath("//div[@data-id='po_neighbourhood']")).getAttribute("textContent"));
			String s1 = (driver.findElement(By.xpath(
					"//ul[@data-id='po_neighbourhood.fieldControl-LookupResultsDropdown_po_neighbourhood_SelectedRecordList']")))
							.getAttribute("textContent");
			casetitle.put(2, s1);
			System.out.println("fieldValue  = " + s);
			if (!s.contains("Lookup")) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@aria-label='Originating Neighbourhood, Lookup']")).click();
				driver.findElement(By.xpath("//span[text()='s1']")).click();
			} else {
				Thread.sleep(3000);
				Wait.waitUntilElementVisible(driver, driver.findElement(By.xpath(
						"//ul[@data-id='po_neighbourhood.fieldControl-LookupResultsDropdown_po_neighbourhood_SelectedRecordList']")));
				Thread.sleep(3000);
				actions.moveToElement(driver.findElement(By.xpath(
						"//ul[@data-id='po_neighbourhood.fieldControl-LookupResultsDropdown_po_neighbourhood_SelectedRecordList']")))
						.build().perform();
				Thread.sleep(1000);
				actions.click(driver.findElement(By.xpath("//button[@aria-label='Delete" + " " + s1 + "']"))).build()
						.perform();
				Thread.sleep(2000);
				cases.fillDetails("Originating Neighbourhood", s1);
				// driver.findElement(By.xpath("//input[@aria-label='Originating Neighbourhood,
				// Lookup']")).click();
				Thread.sleep(2000);
				// driver.findElement(By.xpath("//span[text()='s1']")).click();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("user Save the case")
	public void user_Save_the_case() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@aria-label='Save (CTRL+S)']")).click();
		casetitle.put(1, driver.findElement(By.xpath("//input[@aria-label='Case Title']")).getAttribute("title"));
	}

	@Then("user clicks the {string}")
	public void user_clicks_the_Neighbourhood(String s) throws Exception {
		Thread.sleep(4000);
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//

//		driver.findElement(By.xpath(
//				"//ul[@data-id='po_neighbourhood.fieldControl-LookupResultsDropdown_po_neighbourhood_SelectedRecordList']"))
//				.click();

		driver.findElement(By.xpath("//div[@aria-label='" + casetitle.get(2) + "']")).click();

	}

	@Then("user clicks {string} Tab for selecting {string}")
	public void user_clicks_Related_Tab_for_selecting_Cases(String tabname, String Menuitem) throws Exception {
		Thread.sleep(2000);
		fraudCase.clickRelatedTab(tabname);
		Thread.sleep(4000);
		assertion.CheckAssertionTrue(driver.findElements(By.xpath("//span[text()='" + Menuitem + "']")).size() != 0,
				Menuitem);
		Thread.sleep(1000);
		genericCases.SelectRelatedTabMenuItem(Menuitem);
		Thread.sleep(1000);
		System.out.println(casetitle.get(1));
	}
	
	@Then("user validate case record {string} is created under case item audit")
	public void user_validate_case_record_is_created_under_case_item_audit(String string) throws InterruptedException {
		Thread.sleep(1000);
		assertion.CheckAssertionTrue(driver.findElement(By.xpath("//a[@aria-label='Case Title']"))
				.getAttribute("textContent").contains(string), string);

	}
	
	@Then("user open New Application")
	public void user_open_New_Application() throws InterruptedException
	{
		System.out.println("User clicked : "+ "Create a new Application record.");
		testutil.jsclick(driver.findElement(By.xpath("//*[contains(@Title,'Create a new Application record')]")), driver);
		Thread.sleep(2000);
	}

	@Then("user validates that the case linked to walkabout is showing in the grid")
	public void user_validates_that_the_case_linked_to_walkabout_is_showing_in_the_grid() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(casetitle.get(1));
		driver.findElement(
				By.xpath("//input[@aria-label='Case Search this view' or @aria-label='Case Filter by keyword'] "))
				.sendKeys(casetitle.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Start search']")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@aria-colindex='2' and @role='gridcell' ]"))
				.getAttribute("outerText"));
		assertion.CheckAssertionTrue(casetitle.get(1).contains(driver
				.findElement(By.xpath("//*[@aria-colindex='2' and @role='gridcell' ]")).getAttribute("outerText")), "");
	}

}
