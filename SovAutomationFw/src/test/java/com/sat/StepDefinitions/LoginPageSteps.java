package com.sat.StepDefinitions;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.sat.Pages.LoginPage;
import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testUtil.Wait;
import com.sat.testbase.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;

public class LoginPageSteps {

	TestBase testbase = new TestBase();
	WebDriver driver = TestBase.getDriver();
	LoginPage loginpage = new LoginPage(driver);
	Testutil testUtil = new Testutil(driver);
	Assertions assertion = new Assertions(driver);
	Actions actions = new Actions(driver);
	public Properties prop;
	
	

	@Given("User navigates to CRM login page")
	@Description("User navigates to CRM login page")
	public void user_navigates_to_CRM_login_page() throws Exception {
		try {
			System.out.println("Opening Sovereign Login Page");
			Thread.sleep(2000);
			testbase.UrlLaunch();
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/sat/config/config.properties");
			prop.load(ip);
			String s = prop.getProperty("UserLoginRequired");
			if (s.trim().contentEquals("Yes")) {
				Thread.sleep(2000);
				Wait.untilPageLoadComplete(driver);

				List<WebElement> userProfile = driver
						.findElements(By.xpath("//button//div[@class='mectrl_profilepic mectrl_profilepic_initials']"));
				if (!userProfile.isEmpty()) {
					driver.findElement(By.xpath("//button//div[@class='mectrl_profilepic mectrl_profilepic_initials']"))
							.click();
					//// actions.click(driver
					// .findElement(By.xpath("//button//div[@class='mectrl_profilepic
					//// mectrl_profilepic_initials']")))
					// .build().perform();
					Thread.sleep(2000);
					actions.click(driver.findElement(By.xpath("//button[text()='Sign out']"))).build().perform();
					Thread.sleep(2000);
				}

				Wait.untilPageLoadComplete(driver);
				List<WebElement> useAnotherAccount = driver.findElements(loginpage.useAnotherAccount);
				List<WebElement> username = driver.findElements(loginpage.emailid);

				if (!useAnotherAccount.isEmpty())
					driver.findElement(loginpage.useAnotherAccount).click();

				user_enters_valid_username(prop.getProperty("userid"));
				click_on_Next_button();
				user_enter_valid_password(prop.getProperty("pwd"));
				loginpage.clickonsignin();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @And ("Verify title of login page")

	@When("user enters valid username {string}")
	public void user_enters_valid_username(String userid) throws InterruptedException {
		loginpage.enteruserid(userid);
		Thread.sleep(3000);

	}

	@And("Click on Next button")
	public void click_on_Next_button() {
		loginpage.clickonNext();

	}

	@When("user enter valid password {string}")
	public void user_enter_valid_password(String pwd) {
		loginpage.enterpassword(pwd);

	}

	@And("click on signin")
	public void clicks_on_signin() {
		loginpage.clickonsignin();

	}

	@And("Click on yes")
	public void click_on_yes() {
		loginpage.clickonYes();

	}

	@Then("user is navigated to {string} form")
	public void user_is_navigated_to_page(String exceptedtitle) {
		try {
			driver.findElement(By.xpath("//div[@data-id=\"form-selector\"]")).click();
			driver.findElement(By.xpath("//span[text()='SHA Tenancy Management Account Form']")).click();
			Thread.sleep(1000);
			//			String title = loginpage.GetLoginPageTitle();
//			assertion.CheckAssertion(exceptedtitle, title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user selects App {string}")
	public void user_selects_App(String appname) throws InterruptedException {
//		testUtil.switchToFrame("AppLandingPage");
//		loginpage.GetApp(appname).click();
//		driver.switchTo().defaultContent();

		// testUtil.switchToFrame("AppLandingPage");

		try {
			Thread.sleep(4000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='AppLandingPage']")));
			Thread.sleep(4000);
			loginpage.GetApp(appname).click();
			driver.switchTo().defaultContent();
			System.out.println("user opened : " + appname);
			
			
	
			Thread.sleep(2000);
		} catch (Exception E) {
			System.out.println(E);
		}

	}

}
