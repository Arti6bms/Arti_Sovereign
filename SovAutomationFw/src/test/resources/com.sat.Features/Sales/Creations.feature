@Creations_sales
Feature: Testing of Sales Creations

  Background: 
    Given User navigates to CRM login page
    When user selects App "Sales Hub"

  @TC_22941
  Scenario: TC_22941-C9035-Validation of Creation of a 3rd party Account from sales Hub
    Then user creates new contact
    When user click on "Accounts" under customer
    Then user click on "New"
    Then user navigates to "3rd Party Account Form" form
    And user fill all the details for "Account Type" as "3rd Party"
    Then user enters the details for "Account Name" as "Test Account Name"
    Then user select "SL Industry" as "Local Authority"
    Then user validates "Local Authority Nomination Requirement" section
    Then user select "LA to Nominate Buyer" as "Yes"
    Then user select "Register on Housing Register" as "Yes"
    Then user enters the address details
    Then user click on "Save"
    Then user validate "Test Account Name" is displayed in top ribbon
    Then user validate "CONTACTS" is displayed
    Then user validate "Recent Applications" is displayed
    Then user click on "More commands for Contact" in CONTACTS    
    Then user creates new contact    
    Then user clicks on "Press Enter to go back."
    Then user click on "More commands for Contact" in CONTACTS  
    Then user clicks on "Add Existing Contact" 
    Then user search for the Existing contact "ContactName" 
    Then user clicks on "Add"
    Then user validates that contact is showing in the contact grid list
    Then user click on "More commands for Application" in Recent Applications
    Then user clicks on "New Application. Add New Application"
    Then user clicks on "Save & Close"
    #Then user check the timeline for "SL"

  @TC_22942  
  Scenario: TC_22942-C9035-Validation of editing an existing Account from sales Hub
  #need to develop
  When user click on "Accounts" under customer
  Then user search SL Account Name as "Plot S.26 Waltham Grange"
  Then user navigates to "SL Property" form
  Then user selects "SL Property Type" as "Studio" in "SL Property" form
  
    @TC_22943
  Scenario: TC_22943-C9035-Validation of Creation of appointment from sales hub
  When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    When user search "Jevan Thomas" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
     And user enter "Test" in "Subject" text box
    Then user click on save and close button
    
  @TC_22952  
  Scenario: TC_22952-C9035-Validation of Creation of New marketing List
  #Cannot be automated
  When user click on "Marketing List" under customer
  

  @TC_22949 @TC_22951
  Scenario: TC_22949-C9039-Validation of Lead Contact and adding a preference to the lead
    When user click on "Contacts" under customer
    Then user click on "New"
    Then user navigates to "SL Contact Form" form
    Then user validates mandatory mark for below fields
      | Title | LastName | ContactType |
    Then user select "Title" as "Mr"
    Then user select "Customer Type" as "SL Lead"
    Then user enter "First Name" as "Firstname"
    Then user enter "Last Name" as "Lastname"
    Then user enter the address details
    Then user click on "Save"
    Then user validates URN is auto populated
    Then user validates Active Preferences grid
    Then user validates Applications grid
    Then user clicks on "More commands for Preference"
    Then user click on "New Preference"
    Then user verify "Preference Source" filed is mandatory 
    Then user enters the New Preference Details
    Then user clicks on "Save & Close"
    Then user validate Preference is showing in Preference Grid

 @TC_22944
  Scenario: TC_22944-C11733-Validation of Creation of Task from sales Hub
  When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Finance"
    Then user fill details for "Task Sub-Category" as "Service Charge"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user Click on save and close
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
