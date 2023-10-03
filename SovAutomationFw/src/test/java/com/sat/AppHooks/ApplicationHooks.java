package com.sat.AppHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.sat.testbase.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
//import com.sat.Recording.MyScreenRecorder;
public class ApplicationHooks extends TestBase {

	Properties prop;
	TestBase testbase = new TestBase();	
	WebDriver driver = TestBase.getDriver();
	

//	public ApplicationHooks(TestBase driverFactory )
//	{
//		this.driverFactory=driverFactory;
//	}

	@Before(order = 0)
	public void launchbrowser() throws Exception {
		// String browsername= prop.getProperty("browser");
		// driverFactory=new TestBase();
	//	testbase.startRecording();
//		MyScreenRecorder.startRecording("launchbrowser");
		testbase.initialization();
		// driverFactory.UrlLaunch();
		

	}

	@After(order = 0)
	public void QuitBrowser() throws Exception {	
		
		//driver.close();
	//	testbase.QuitBrowser();
	//	testbase.stopRecording();
//		MyScreenRecorder.stopRecording();
		// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		 Runtime.getRuntime().exec("taskkill /F /IM OpenJDK Platform binary /T");
	}

	@After(order = 2)
	public void generateAllureReport() {
		// TestBase.driver.quit();
		try {

			testbase.generateAllureReport();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	@After(order=1)
	public void teardown(Scenario scenario)	
	{
			
		if(scenario.isFailed())
		{
			String screenshotname=scenario.getName().replaceAll(" ","_");
			//byte[] sourcepath=screenshot();
			//scenario.attach(sourcepath, "image/png", screenshotname);
			}
	}

}
