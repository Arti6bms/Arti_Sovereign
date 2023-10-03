@UserStorySprint18
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @CR40120 @TC42761 @TC42760 @TC42759
  Scenario: CR40120 of Sprint 18
    When user selects App "Sales Hub"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
     Then user clicks on "More commands for Preference"
    Then user click on "New Preference"
    Then user validate locked field
      | Created On |
    Then user enters the New Preference Details
    Then user click on "Save"
    Then user verifies the date stored for "Date of Created On"
