@ResalesHubRegressionTestNavigation
Feature: Testing of Navigation of Test Cases in Resales Hub Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Resales"

  @TC22866
  Scenario: TC22866_C10666 -Validation of Resales Hub View
    Then verify all tabs are appearing on the "My Work" Form
      | Dashboards | Activities | Queues | Calendar | PowerMap | Legacy D365 Link | Sovereign Website |
    Then verify all tabs are appearing on the "Customer Management" Form
      | Contacts | Property Sale | Applications | Penningtons Case Portal |
    Then verify all tabs are appearing on the "Property" Form
      | Properties |
    Then verify all tabs are appearing on the "Marketing" Form
      | Marketing Lists | Campaigns | Power Mail Chimp |

  @TC22867
  Scenario: TC22867
    #need to develop
    When user click on "Dashboards" under customer

  @TC22868
  Scenario: TC22868_C9019-Validation of "Search" functionality in Resale Hub - Quick Search/Local Search/Global Search
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    Then user enter "*Charlotte Emms ; Jamie Hines" in search text box and validate text
    When user click on "Property" under customer
    And user click on Drop Down List
    And user select "Active Property Sale" from drop down list
    Then user enter "100015,12 Rumney Penrose Road, Stoke Gifford, Bristol, Avon, BS16 1RA ; Lambs Field" in search text box and validate text
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities" from drop down list
    Then user enter "*Aleksandrs *;Ted Tester - Martin Street Test 1000" in search text box and validate text
    Then user enter "Charlotte Emms*;Julie Utting ;100001, 36 Silks Way, Andover, Hampshire, SP11 6UU;100001, 36 Silks Way*;Flat C20*" in global search text box and validate text
  #Final- Regression pack for optimisation (ID: 33411)
  #@TC31015
  #Scenario: TC31015_US21527 : Validate Changes of Fields and Sections under Summary Tab of Resale Application
    #When user click on "Contacts" under customer
    #And user click on Drop Down List
    #And user select "Active Contacts" from drop down list
    #When user search "Abdulla Sharif" and click on contact name link
    #When user click on "Application" tab
    #And user click on "New Application"
    #Then verify all section under tab
      #| Property | Buyer Details |
    #Then user validate "Property" field is display
    #Then user validate "Property Sale Form" field is display
    #Then user fill all the details for "Property Sale Form" as "RS000000000041"
    #Then user scroll down till "Sellers Details" present in page
    #Then user verified the "Sellers Details" section for below fields
      #| Legal Tenancy Name | Resales Repossession? | Executor? |
    #Then user scroll down till "Buyer Details" present in page
    #Then user verify "Buyers Solicitor" filed is Locked
    #Then user verify "Buyers Solicitor Contact" filed is Locked
    #Then user scroll down till "Seller Solicitor" present in page
    #Then user verify "Seller Solicitor" filed is Locked
    #Then user verify "Seller Solicitor Contact" filed is Locked
    
    


