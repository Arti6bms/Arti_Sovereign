package com.sat.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sat.testbase.TestBase;

public class Neighborhoods {
	
	TestBase testbase = new TestBase();
	WebDriver driver= TestBase.getDriver();
	
	@FindBy(xpath = "//div[@data-id='ownerid.fieldControl-LookupResultsDropdown_ownerid_selected_tag']")
	public WebElement objOwnerfield;
	
	@FindBy(xpath = "//button[@aria-label='Create a timeline record.']")
	public WebElement objCreatetimelinerecord;
	
	
	@FindBy(xpath = "//input[@aria-label='Owner, Lookup']")
	public WebElement objOwnerLookupfield;
	
	@FindBy(xpath = "//input[@aria-label='Originating Neighbourhood, Lookup']")
	public WebElement objOriginatingNeighbourhoodLookup;
	
	@FindBy(xpath = "//ul[contains(@data-id,'po_neighbourhood')]")
	public WebElement objpo_neighbourhoodfield;
	
	@FindBy(xpath = "//div[@data-id='po_neighbourhood']")
	public WebElement objpo_neighbourhoodfieldfull;
	
	@FindBy(xpath = "//select[@aria-label='Walkabout Frequency']")
	public WebElement objFrequencyfield;
	
	@FindBy(xpath = "//ul[@data-id='po_neighbourhood.fieldControl-LookupResultsDropdown_po_neighbourhood_SelectedRecordList']")
	public WebElement objneighbourhoodLookup;
	
	@FindBy(xpath = "//span[text()='ZZ Poole 11 (Arndale Court)']")
	public WebElement objOriginatingNeighbItemvalue;
	

	

	
	
	
	public Neighborhoods(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public String checkFieldValueisBlank(String fieldName)
	{
		//return(driver.findElement(By.xpath("//input[@aria-label='Name']")).getAttribute("title").isBlank());
		return(driver.findElement(By.xpath("//input[@aria-label='Name']")).getAttribute("title"));
	
	}
	
	public String getFieldvalue(String fieldName)
	{
		return(driver.findElement(By.xpath("//input[@aria-label='Name']")).getAttribute("title"));
		
	}
	
	

}
