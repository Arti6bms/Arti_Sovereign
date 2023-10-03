 @DCP
Feature: Testing of DCP in Tenancy Management

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
 
 @DCP
  Scenario: TC_28355-C8832-Validation of Generate Letters
    When user click on "Cases" under Service
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search "ASB Legal (NOSP, Injunction, Court), Adrian Woodhead, CAS-09444-V7Y8W3" and click on contact name link
    Then user click on three dots appearing top most right corner on the "Case" form
    And user select "Create Document" from the top menu option
    Then user select template "ASB Action Plan 2.docx" and click next button
    And user click on refresh button
    Then user click on Tab "Summary"
    And user edit document
    Then user attached updated document
    And user save note
    Then user verify updated attached document