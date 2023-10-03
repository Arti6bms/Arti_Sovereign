@SalesHubRegressionTestStatusFlags
Feature: Testing of Navigation of Test Cases in Sales Hub Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Sales Hub"

  @TC23167
  Scenario: TC23167_C9037 - Validation of New Account--Sales Status and Handover Status Flags
    When user click on "Accounts" under customer
    Then user creates the new contact
    Then user scroll down "Property Address" in page
    Then user scroll down "Property Details" in page
    Then user verify all the "Sales Status" list values
      | New Plot | Coming Soon | Apply Now | Under Allocation | Early Bird Reservation | Reserved | Completed | Stock | With Agent | Property On hold |
    Then user fill details for "Sales Status" as "New Plot"
    And user enter "2" in "Remaining Term on Lease" text box
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    Then user scroll down "Property Details" in page
    Then user validate "New Scheme" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Coming Soon"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Coming Soon" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Apply Now"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Apply Now" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Under Allocation "
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Under Allocation " Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Early Bird Reservation"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Early Bird Reservation" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Reserved"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Reserved" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Completed"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Completed" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Stock"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "Stock" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "With Agent"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    #Then user validate "With Agent" Sales Status flag is displayed
    Then user fill details for "Sales Status" as "Property On hold"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Property Address" in page
    Then user validate "Property On hold" Sales Status flag is displayed

  @TC23168
  Scenario: TC23168_C9077 - Validation of Development Status Flags in Sales Hub
    When user click on "Developments" under customer
    And user click on Drop Down List
    And user select "Active Developments" from drop down list
    When user search "Bow Farm" and click on contact name link
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user verify all the "Marketing Status" list values
      | New Scheme | Coming Soon | Apply Now | Under Allocation | Fully Allocated | Stock |
    Then user fill details for "Marketing Status" as "New Scheme"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "New Scheme" Development Status flag is displayed
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user fill details for "Marketing Status" as "Coming Soon"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "Coming Soon" Development Status flag is displayed
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user fill details for "Marketing Status" as "Apply Now"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "Apply Now" Development Status flag is displayed
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user fill details for "Marketing Status" as "Under Allocation"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "Under Allocation" Development Status flag is displayed
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user fill details for "Marketing Status" as "Fully Allocated"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "Fully Allocated" Development Status flag is displayed
    When user click on "Marketing" tab
    Then user scroll down "Details" in page
    Then user fill details for "Marketing Status" as "Stock"
    And user click on save button
    Then user click on refresh button
    Then user scroll down "Development Details" in page
    Then user validate "Stock" Development Status flag is displayed

  @TC23174
  Scenario: TC23174_C9923 - Validation of Application Flags
    When user click on "Applications" under customer
    Then user creates the new contact
    When user click on "Application" tab
    Then user verify all the "Application Status" list values
      | Active | Complete | Incomplete | Pending Information |
    Then user fill details for "Application Status" as "Active"
    And user click on save button
    Then user click on refresh button
    When user click on "Application" tab
    Then user scroll down "Application  Details" in page						
    #Then user validate "Active" Application Status flag is displayed
    Then user fill details for "Application Status" as "Complete"
    And user click on save button
    Then user click on refresh button
    When user click on "Application" tab
    Then user scroll down "Application  Details" in page
    #Then user validate "Complete" Application Status flag is displayed
    Then user fill details for "Application Status" as "Incomplete"
    And user click on save button
    Then user click on refresh button
    When user click on "Application" tab
    Then user scroll down "Application  Details" in page
    #Then user validate "Incomplete" Application Status flag is displayed
    Then user fill details for "Application Status" as "Pending Information"
    And user click on save button
    Then user click on refresh button
    When user click on "Application" tab
    Then user scroll down "Application  Details" in page
    #Then user validate "Pending Information" Application Status flag is displayed
