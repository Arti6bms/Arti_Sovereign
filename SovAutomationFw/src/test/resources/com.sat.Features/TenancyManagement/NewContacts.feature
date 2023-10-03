@NewContacts
Feature: Testing of New Contacts Cases in Tenancy Management

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"

  @ExistingContactCreation
  Scenario: TC28287_C11546-Validation of an existing Contact Creation
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on New Contact
    Then user verify "Contact Type" filed is mandatory
    Then user verify "Last Name" filed is mandatory
    And user fill all the details for "Contact Type" as "Existing Contact"
    Then user click on "Save"
    Then user verify red error message on top of the Contact
    And user verify all fields should be locked in both Summary and Correspondence tabs
    And user verify unable to save the data

    
    @ThirdPartyContactCreation
  Scenario: TC28283_C8801-Validation of Third Party Contact Creation
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on New Contact
    Then user verify "Contact Type" filed is mandatory
    And user fill all the details for "Contact Type" as "3rd Party"
    #Then user validates mandatory mark for below fields
    #|Password|Title|First Name|Last Name|Date of Birth|Email|Home Phone|Mobile Phone|Mobile Phone 2|Work Phone|Email Address 1|Email Address 2|
    Then user fill the General Information fields in contact form
    When user click on "Correspondence" tab
    Then user fill the address details in Correspondence tab
    Then user click on "Save"
    Then user enter "*Lastname" in global search text box and validate text
    
    @NewContactCreation
    Scenario: TC28284-Validation of New Contact creation
    When user click on "Contacts" under customer
    And user click on New Contact
    Then user verify "Contact Type" filed is mandatory
    And user fill all the details for "Contact Type" as "New Contact"
    #Then user validates mandatory mark for below fields
    #|Password|Title|First Name|Last Name|Date of Birth|Email|Home Phone|Mobile Phone|Mobile Phone 2|Work Phone|Email Address 1|Email Address 2|
    Then user fill the General Information fields in contact form
    When user click on "Correspondence" tab
    Then user fill the address details in Correspondence tab
    Then user click on "Save"
    Then user enter "*Lastname" in global search text box and validate text
    
    @StatutoryContactCreation
    Scenario: TC28285-Validation of Statutory Contact creation 
    When user click on "Contacts" under customer
    And user click on New Contact
    Then user verify "Contact Type" filed is mandatory
    And user fill all the details for "Contact Type" as "Statutory Sharing Contact"
    #Then user validates mandatory mark for below fields
    #|Password|Title|First Name|Last Name|Date of Birth|Email|Home Phone|Mobile Phone|Mobile Phone 2|Work Phone|Email Address 1|Email Address 2|
    Then user fill the General Information fields in contact form
    When user click on "Correspondence" tab
    Then user fill the address details in Correspondence tab
    Then user click on "Save"
    Then user enter "*Lastname" in global search text box and validate text
    
    
    @AnonymousContactCreation
    Scenario: TC28286-Validation of Anonymous Contact creation 
    When user click on "Contacts" under customer
    And user click on New Contact
    Then user verify "Contact Type" filed is mandatory
    And user fill all the details for "Contact Type" as "Anonymous Contact"
    Then user click on "Save"
    
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
    