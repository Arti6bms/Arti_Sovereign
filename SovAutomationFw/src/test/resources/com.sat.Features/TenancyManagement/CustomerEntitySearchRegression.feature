@CustomerEntitySearch
@Tenancy
Feature: Testing of Local/Quick Search for Customer Entities and Global Search in Tenancy Management

  @searchFunctionality
  Scenario: TC28373_C8797 - Validation of Local/Quick Search for Accounts,Blocks,Neighborhoods,Schemes,Contacts,Data Protection,Tenancies
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user verify left side pane under customer
    When user click on "Accounts" under customer
    #Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Accounts" from drop down list
    Then user enter "3 T Finance;Blackboard Financial *;01590 666666" in search text box and validate text
    When user click on "Blocks" under customer
    #Then user is navigated to "Blocks Active Blocks - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Blocks" from drop down list
    Then user enter "* Swindon*;1001*;*Shared*" in search text box and validate text
    When user click on "Neighborhoods" under customer
    #Then user is navigated to "Neighborhoods Active Neighborhoods - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Neighborhoods" from drop down list
    Then user enter "* Princess Road * ; Abingdon * ; * Torquay" in search text box and validate text
    When user click on "Schemes" under customer
    #Then user is navigated to "Schemes Active Scheme's - Dynamics 365" page
    And user click on Drop Down List
    And user select "Default" from drop down list
    Then user enter "159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF ; * Roseland *" in search text box and validate text
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    Then user enter "Jamie Hines ; * Alan ; youngmsk@hotmail.co.uk ; 02423423432*" in search text box and validate text
		When user click on "Data Protection" under customer
    #Then user is navigated to "Data Protection Active Data Protection - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Data Protection" from drop down list
    Then user enter "Data Protection for A Reidy on 29/06/2020 15:09 ; * Edmonds * ; *Abby*" in search text box and validate text
    When user click on "Tenancies" under customer
    #Then user is navigated to "Tenancies Active Tenancies - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Tenancies" from drop down list
    Then user enter "87848, Flat 4 1 Glenmore Road, Salisbury, Wiltshire, SP1 3HF ; 9213842 ; 87848* ; * Fisher *" in search text box and validate text
   	Then user enter "Julie Utting ; *Smith ; 26844, 40 Prospect Road " in global search text box and validate text
      
