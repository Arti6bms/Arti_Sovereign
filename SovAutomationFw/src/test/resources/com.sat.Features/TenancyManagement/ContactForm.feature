@CustomerForm
Feature: Testing for Contact Form in Tenancy Management

  @TC28278_C8798
  Scenario: TC28278_C8798-Validation of Contact Form
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then verify all tabs are appearing on the Contact Form
      | Summary | Correspondence | Data Protection | Tenancies | Rent Accounts | Conflicts Tab | Related |
    When user click on "Summary" tab
    Then verify all section under tab
      | Summary | GENERAL INFORMATION | TIMELINE | Flags |
    #And verify Locked fields under GENERAL INFORMATION section
    #And verify Unlocked fields under GENERAL INFORMATION section
    #Then verify filter options on the timeline
    When user click on "Correspondence" tab
    Then verify all section under tab
      | Correspondence | MAIN ADDRESS | CORRESPONDENCE ADDRESS | EMERGENCY CONTACTS | AUTHORITY TO DISCUSS THESE ACCOUNTS |
    Then click on New Emergency Contact
    And user click on save and close button
    Then user scroll down "MAIN ADDRESS" in page
    Then click on New Contact
    And user click on save and close button
    When user click on "Data Protection" tab
    And verify all section "DATA PROTECTION DETAILS" under Data Protection tab
    And click on New Data Protection link
    Then verify all section under tab
      | General | CUSTOMER INFORMATION | DATA PROTECTION QUESTIONS | ACCOUNT INFORMATION |
    And user click on save and close button
    When user click on "Tenancies" tab
    Then user open "Miss J Shepherd" Form
    And user click on save and close button
    When user click on "Rent Accounts" tab
    Then user open "Flat- Flat 25 Odiham Drive, Newbury ,RG14 1GA" Form
    And user click on save and close button
    When user click on "Conflicts Tab" tab
    When user click on "Related" tab
    #Then user upload document
    
  @TC28281_C8800
  Scenario: TC28281_C8800-Validation of Blocks Form
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Blocks" under customer
    #Then user is navigated to "Blocks Active Blocks - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Blocks" from drop down list
    When user search "100012, Block 34/36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" and click on contact name
    Then verify all tabs are appearing on the "Block Form" Form
      | General | Assets | Repair Cases | Related |
    When user click on "General" tab
    Then verify all section under tab
      | General | Main Address | Timeline |
    When user click on "Assets" tab
    Then user open "154967, 34 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" Form
    And user click on Back button
    When user click on "Repair Cases" tab
    When user click on "Related" tab
    
   @TC28367_C8800
  Scenario: TC28367_C8800 -Validation of Scheme Form
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Schemes" under customer
    #Then user is navigated to "Schemes Active Scheme's - Dynamics 365" page
    And user click on Drop Down List
    And user select "Default" from drop down list
    When user search "159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF" and click on contact name
    Then verify all tabs are appearing on the "Scheme Form" Form
      | General | Blocks | Assets | Repair Cases | Related |
    #When click on "General" tab
    Then verify all section under tab
      | General | Main Address | Timeline |
    When user click on "Blocks" tab
    When user click on "Assets" tab
    When user click on "Repair Cases" tab
    When user click on "Related" tab
    
    @AssetForm
  Scenario: TC28280_C8799 -Validation of Asset Form
   Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Accounts" under customer
    #Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "Assets" from drop down list
    When user search "93960, 23 Odiham Drive, Speen, Newbury, Berkshire, RG14 1GA" and click on contact name
    Then verify all tabs are appearing on the "Account Form" Form
      | Summary | Asset Information | Tenancy Information | Repair Cases | Rent Account | Related |
    When user click on "Summary" tab
    Then verify all section under tab
      |Summary|ACCOUNT INFORMATION| ASSET INFORMATION |TIMELINE|Flags|MAIN ADDRESS|CORRESPONDENCE ADDRESS |
    When user click on "Asset Information" tab
    Then verify all section under tab
      | Asset Information | ASSET DETAILS | ASSET ADDRESS | Rent Account |
    When user click on "Tenancy Information" tab
    Then user open "Miss J Utting" Form
     And user click on save and close button
    When user click on "Repair Cases" tab
    When user click on "Rent Account" tab
    Then user open "House- 23 Odiham Drive, Newbury ,RG14 1GA" Form
     And user click on save and close button
    When user click on "Related" tab
    
    @HouseholdGroupForm
  Scenario: TC28279_C11542 -Validation of Household Group  Form
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user scroll down "GENERAL INFORMATION" in page
    Then user Scroll down to Account field and click on the address hyperlink 
   #Then user is navigated to "Account:SHA Tenancy Management Account Form" page
     Then verify all tabs are appearing on the "Account Form" Form
      | Summary | Household Group Information | SMS Contact Information | SMS Tenancy Information | SMS Asset Information | Related |
    Then verify all section under tab
      | Summary | ACCOUNT INFORMATION | TIMELINE | Flags | MAIN ADDRESS | CORRESPONDENCE ADDRESS |
    #And verify Locked fields under GENERAL INFORMATION section
    #And verify Unlocked fields under GENERAL INFORMATION section
    When user click on "Household Group Information" tab
    Then verify all section under tab
      | Household Group Information | HOUSEHOLD GROUP DETAILS | HOUSEHOLD GROUP CONTACTS | ASSETS |
      Then user scroll down "HOUSEHOLD GROUP DETAILS" in page
    Then click on New Contact
    And user click on save and close button
     Then user scroll down "HOUSEHOLD GROUP DETAILS" in page
    Then click on New Account
    When user click on "SMS Contact Information" tab
    Then verify all section under tab
   |SMS Contact Information|CONTACT 1: GENERAL INFORMATION|CONTACT 2: GENERAL INFORMATION|CONTACT 1: MAIN ADDRESS|CONTACT 1: CORRESPONDENCE ADDRESS|CONTACT 2: CORRESPONDENCE ADDRESS|
    When user click on "SMS Tenancy Information" tab
    Then verify all section under tab
    |SMS Tenancy Information|Tenancy 1|Tenancy 2|
    When user click on "SMS Asset Information" tab
    Then verify all section under tab
    |SMS Asset Information|ASSET 1 DETAILS|ASSET 1 DETAILS|
    When user click on "Related" tab

    #Examples: 
      #| App_Name             | Tab      | Options      |
      #| Customer Service Hub | Contacts | All Contacts |
      
    @US27111 @TC37601 
		Scenario:US27111
		When user selects App "Customer Service Hub"
		When user click on "Contacts" under customer
		Then user navigate to "All Contacts" view
		When user search "Julie Utting" and click on contact name link
		And user click on plus icon on the timeline
		And user select "Task" from timeline option
		Then user fill details for "Task Category" as "Housing Management"
		Then user fill details for "Task Sub-Category" as "Assisted Gardening"
		
		
		@CR_33989
		@TC35888_TC35889
		Scenario Outline:CR33989
		 When user selects App "<Hub>"
		 When user click on "Contacts" under customer
		 Then user navigate to "All Contacts" view
		 When user search "Jerrilee Shepherd" and click on contact name link
		 And user click on plus icon on the timeline
		 And user select "Task" from timeline option
		 Then user enter Response Time and Description
		 And user Click on save and close
		 Then user open created task
		 Then user verify the Queue Item Details as Customer Contact Admin
		
		Examples:
		| Hub             |
		| Sales Hub |
		
		@TC37603_TC37605_TC37604_TC37602
		Scenario Outline: US27111 of Sprint 14
		When user selects App "Customer Service Hub"
		When user click on "Contacts" under customer
		Then user navigate to "All Contacts" view
		When user search "<Contact>" and click on contact name
		And user click on plus icon on the timeline
		And user select "Task" from timeline option
		Then user fill details for "Task Category" as "Housing Management"
		Then user fill details for "Task Sub-Category" as "Assisted Gardening"
		Then user enter Response Time and Description
		And user click on save button
		Then user verify the Owner as "<OwnerFieldname>"
		
		Examples:
		| Contact | OwnerFieldname      |
		| Jerrilee Shepherd| East Admin Tenancy  |
		| Martin Bell| West Admin Tenancy  |
		| Liam Donald| South Admin Tenancy |
		| Laura Trim| East Admin Tenancy  |
		
		@CR37097 @Sprint13
  	Scenario: CR37097 of Sprint 10
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    Then user clicks on "New" contact
    Then user navigate to the Preferred Language field
    Then user verifies the field "Preferred Language"
      | Nepali | Macedonian | Lithuanian | Estonian |
      
    @CR14171 @Sprint13
  	@TC33088_TC34655_TC34657_TC34653_TC34651_TC34656_TC34658
  	Scenario Outline: CR14171 of Sprint 11
    When user selects App "<Hub>"
    When user click on "Contacts" under customer
    Then user navigate to "Active Contacts" view
    Then user select one of active Contact
    Then user enter the Mobile Phone which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the Mobile Phone starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid Mobile Phone starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"
    Then user enter the Mobile Phone 2 which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the Mobile Phone 2 starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid Mobile Phone 2 starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"

    Examples: 
      | Hub                     |
      | Employment and Training |
      | Customer Service Hub    |
      | Resales                 |
      
   	@CR14171 @Sprint13
  	@TC34654
  	Scenario: CR14171 of Sprint 11
    When user selects App "Sales Hub"
    When user click on "Contacts" under customer
    Then user navigate to "Active Contacts" view
    Then user select one of active Contact
    Then user enter the mobilephone which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the mobilephone starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid mobilephone starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"
      
      @CR34599 @TC38736
  Scenario: CR34599 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Income"
    Then user fill details for "Task Sub-Category" as "Rent Statement"
    Then user enter Response Time and Description
    And user click on save button
    Then user verify the Owner as "Income Admin"
    
    @CR30777 @TC38734
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Income"
    Then user fill details for "Task Sub-Category" as "Rent Card"
    Then user enter Response Time and Description
    And user click on save button
    Then user verify the Owner as "Income Admin"
    
    
    @US38076 @Sprint14 @TC38484
    Scenario: US38076 of Sprint 14
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
		When user click on "Contacts" under customer
		Then user navigate to "All Contacts" view
    When user search "Julie Utting" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Housing Management"
    Then user fill details for "Task Sub-Category" as "Customer Refusal"


@TC38485_TC38486_TC38488_TC38490
Scenario Outline: US38076 of Sprint 14
Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
   When user click on "Contacts" under customer
   Then user navigate to "All Contacts" view
   When user search "<CustomerName>" and click on contact name link
   And user click on plus icon on the timeline
   And user select "Task" from timeline option
   Then user fill details for "Task Category" as "Housing Management"
   Then user fill details for "Task Sub-Category" as "Customer Refusal"
   Then user enter Response Time and Description
   And user click on save button
   Then user verify the Owner as "<OwnerFieldname>"
		Examples:
		| CustomerName | OwnerFieldname      |
		| Jerrilee Shepherd  | East Admin Tenancy  |
		| Martin Bell  | West Admin Tenancy  |
		| Liam Donald  | South Admin Tenancy |
		| Laura Trim   | East Admin Tenancy  |


@US33533 @TC43736-TC43735
Scenario: US33533-TC43736-TC43735 of Sprint 20
Given User navigates to CRM login page
When user selects App "Customer Service Hub"
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
Then user select one of active Contact
Then user read the ContactName
Then user Click the + on the timeline and select "Task Activity"
Then user fill details for "Task Category" as "Repairs and Maintenance"
Then user verifies the field "Task Sub-Category"
| Cleaning |
Then user fill details for "Task Sub-Category" as "Cleaning"
Then user fill details for "Response Time" as "Routine (5 Working Days)"
And user enters description
And user click on save button
Then user read the Task title
Then user validate the Queue Item Details "Cleaning"


 @CR37097 @Sprint13
  Scenario: CR37097 of Sprint 10
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    Then user clicks on "New" contact
    Then user navigate to the Preferred Language field
    Then user verifies the field "Preferred Language"
      | Nepali | Macedonian | Lithuanian | Estonian |