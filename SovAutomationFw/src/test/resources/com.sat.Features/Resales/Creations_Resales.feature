@ResalesHubRegressionTestCreation
Feature: Testing of Creations of Test Cases in Resales Hub Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Resales"

  @TC22871
  Scenario: TC_22871
    When user click on "Properties" under customer
    And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name
    Then user select any property
    Then user validate locked field
      | Development |
    When user click on "Asset Information" tab
     Then user validate the "ASSET DETAILS" section for below fields
      | Home Ownership Team |Property Manager|
      Then user validate the "ASSET DETAILS - Property Restrictions" section for below fields
      | Sovereign Percentage|Resident Percentage|S106 Details|Staircasing Restriction|
        When user click on "Property Sales" tab
         Then user validate the "Property Sales" section for below fields
      | Active Property Sale|
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

  @TC22870
  Scenario Outline: TC_22870
    When user click on "Properties" under customer
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
    Then user fill the details for primary contact as "<PrimaryContact>"
    Then user click on "More commands for Contact" in CONTACTS
    Then user clicks on "Add Existing Contact"
    Then user search for the Existing contact "<PrimaryContact>"
    Then user clicks on "Add"
    Then user validates that contact is showing in the contact grid list
    
    Examples:
    |PrimaryContact|
    #|Firstname Lastname| rw ds
    |TestF TestL|

  @TC_22873
  Scenario: TC_22873-C11737 - Validation of Creation of  a Task from Resales Hub
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user navigates to "Task for Interactive experience" form
    Then user fill details for "Task Category" as "Finance"
    Then user fill details for "Task Sub-Category" as "Service Charge"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    #And user Click on save and close
    Then user clicks on "Save & Close"
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline

  @TC_22879
  Scenario: TC_22879-C10675 - Validation of creation of a lead contact
    When user click on "Contacts" under customer
    Then user click on "New"
    And user validate the contact form is set to "Contact entity, Contact (Buyer)" Form
    Then user fill details for "Title" as "Mr"
    And user enter "TestF" in "First Name" text box
    And user enter "TestL" in "Last Name" text box
    Then user validate Contact Type is autopopulated as "New Contact"
    Then user fill details for "Customer Type" as "SL Lead"
    Then user click on "Save"
    Then user validates URN is auto populated
    		#Then user validates Active Preferences grid
    #
    Then user scroll down till "Pre-Application Details" present in page
    Then user fill all the details for "County" as "Avon"
    Then user fill all the details for "Local Authority Home" as "Bristol"
    Then user fill details for "Marital Status" as "Married"
    And user enter "Test" in "HtB Reference" text box
    Then user fill details for "Resale HTB Status" as "Registered"
    Then user fill all the details for "Employer Local Authority" as "Gloucestershire"
    Then user scroll down till "CORE Information" present in page
    Then user fill details for "MOD" as "Yes"
    Then user fill details for "Opt In" as "Yes"
    Then user click on "Save"
    #Then user scroll down till "Active Preferences" present in page
    Then user clicks on "More commands for Preference"
    Then user click on "New Preference"
    Then user verify "Preference Source" filed is mandatory
    Then user enters the New Preference Details
    Then user clicks on "Save & Close"
    Then user validate Preference is showing in Preference Grid

  @TC_22880
  Scenario: TC_22880-C10696 - Validation of Edit an existing Contact from "Resales Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "SL Lead Applicant" from drop down list
    When user search "Aaron Dowling" and click on contact name
    #And user validate the contact form is set to "Contact (Buyer)" Form
    Then user fill details for "Title" as "Dr"
    #Then user scroll down till "Pre-Application Details" present in page
    Then user scroll down till to Pre-Application Details section
    And user enter "TestCity" in "City" text box
    Then user click on "Save"

  @TC_22892
  Scenario: TC_22892-C10677 - Validation of Create activities from a Contact "Resales" hub
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    And user enter "Test" in "Subject" text box
    Then user click on save and close button
    Then user click on Ignore and Save button
    #Then user check the Appointment in the Timeline
   #		 #Then user open your phone call activity and clicking on Mark Complete with the tick mark
   #		 #And user verify the activity has updated to "Active" on the timeline
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Income"
    Then user fill details for "Task Sub-Category" as "Rent Statement"
    Then user enter Response Time and Description
    Then user click on save and close button
    And user verify the activity has updated to "Active" on the timeline
    Then user validate case Owner as "D365 Service Account"
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    And user click on plus icon on the timeline
    And user select "Phone Call" from timeline option
    And user enter "Test" in "Subject" text box
    And user enters description
    Then user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
    
  @TC_22876
  Scenario: TC_22876
    When user click on "Contacts" under customer
    Then user clicks "New"
    Then user enters field "Last Name"
    Then user click on "Save"
    Then user clicks "Related" Tab for selecting "Documents"
   When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Open Opportunities" from drop down list
    Then user select any Opportunity
    Then user clicks "Related" Tab for selecting "Documents"
    
     @TC_22872
  Scenario: TC_22872 need to develop
  When user click on "Properties" under customer
     And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name
    Then user select any property
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user click on "Save and Close"
     And user verify the activity has updated to "Active" on the timeline
  
  
         @TC_22899
  Scenario: TC_22886 need to develop
  
           @TC_22900
  Scenario: TC_22886 need to develop
  
  
   @TC_23498
    Scenario: TC_23498
       When user click on "Properties" under customer
     And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name for staircasing
    Then user select any property
    Then user click on "Asset Information" tab
    Then user scroll down "Lease Details" in page
    #Then user scroll down to till element is visible
    Then user set "Date of Lease Commencement Date" date
    Then user enter "Term of Lease" as "10"
    Then user validate the "Lease Expiry Date" field
    
    @CR29290
@TC38396_TC37802_TC37801
Scenario: US21574 Validate Auto Email is displayed when Advert Live Date is set on Property Sale Resale Form.
When user selects App "Resales"
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter "Advert Link (URL)" as "https://www.google.com"
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verify the auto popup title content
Then user click on close button in auto popup email
Then user click on "Summary" tab
And Refresh the timeline and find the phone call activity

 @CR29290
@TC_37803
Scenario: CR29290 : Validate Auto generated Advert Live Email  is Deleted and not displayed in Timeline on Property Sale Resale Form when Delete button is clicked.
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter "Advert Link (URL)" as "https://www.google.com"
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verify the auto popup title content
Then user clicks on "More commands for E-mail"
Then user delete the case
Then user clicks on "Delete" option
Then user click on "Summary" tab
And Refresh the timeline and find the phone call activity

@CR29290
@TC_38398
Scenario: US21574 CR29290
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verifies the auto popup is does not exist

@CR29290
@TC_34860
Scenario: Validate Email popup Preview is displayed when Date of Approval is set on Resale Application Form.
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
When user search "Jerrilee Shepherd" and click on contact name link
Then user clicks "Related" Tab for selecting "Applications"
Then user clicks on "New Application. Add New Application"
Then user validate Lead Application is mapped from Contact
Then user read the Property details
Then user fill all the details for "Property" as "90913, Flat 137 Sinclair Drive, Churchill Way West, Basingstoke, Hampshire, RG21 6AF"
Then user fill all the details for "Property Sale Form" as "RS000000000010"
Then user select "Sale Type Field" as "Resale"
Then user enter the details in Buyer Details section
Then user enter the details in Sellers Details section
Then user enter the details in Sovereign Stakeholder Details section
When user click on "Application" tab
Then user enter the details in Allocation Placement section
Then user verify the auto popup title content 

    
