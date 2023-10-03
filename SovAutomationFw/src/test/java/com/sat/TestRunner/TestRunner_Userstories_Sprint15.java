package com.sat.TestRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.java.Scenario;



//	@RunWith(Cucumber.class)
	@CucumberOptions(
			features={"src/test/resources/com.sat.Features"},
			glue={"com.sat.StepDefinitions","com.sat.AppHooks"},
			monochrome=true,
			strict = true,
			plugin={"pretty",
					//"json:target/cucumber.json",
					"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
					//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					//"html:target/cucumber-reports/report.html"
					},
			//tags={"@schemesSearch,@accountSearch,@blockSearch,@neighborhoodsSearch,@schemesSearch,@contactsSearch,@dataProtectionSearch,@tenanciesSearch"})
			  tags= {"@TC39148"}
			)
			//tags= {"@TC_30612 or @TC_3455s9 or @TC_32401 or @TC_32402 or @TC_34552_TC_34555_29517_29526_29523_34560 "})
	//tags= {"@searchFunctionality or @CustomerEntitiesForm"})
	//tags={"@AutoRoutingFunctionality or @AutoRoutingFunctionalityTask or @GenericCasesFunctionality"})
//tags={"@Local&GlobalSearch or @CustomerEntitiesForm or @AutoRoutingFunctionalityPhone or @AutoRoutingFunctionalityTask or @GenericCasesFunctionality or @Block&SchemeCases"})

		public class TestRunner_Userstories_Sprint15 extends AbstractTestNGCucumberTests{

			@Override
			@DataProvider(parallel = false)
			public Object[][] scenarios() {
				return super.scenarios();

			}
	}
	
	