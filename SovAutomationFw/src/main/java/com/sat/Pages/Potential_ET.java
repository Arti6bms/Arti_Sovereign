package com.sat.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sat.testUtil.Assertions;
import com.sat.testUtil.Testutil;
import com.sat.testbase.TestBase;

public class Potential_ET {


		WebDriver driver = TestBase.getDriver();
		TestBase testbase = new TestBase();
		Testutil testutil = new Testutil(driver);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String listofvalues;
		SLATimer slatimer = new SLATimer(driver);
		Optimization omptimization = new Optimization(driver);
		Assertions assertion = new Assertions(driver);
		
		public Potential_ET(WebDriver driver) {
			this.driver = driver;
		}
	
}
