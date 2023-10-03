@SalesHubRegressionTestNavigation
Feature: Testing of Navigation of Test Cases in Sales Hub Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Sales Hub"

  @TC22937
  Scenario: TC22937_C9015 - Validation of Sales Hub View left pane options
    Then verify all tabs are appearing on the "My Work" Form
      | Queues | Legacy 365 | Power Map | Activities | Dashboards |
    Then verify all tabs are appearing on the "Customers" Form
      | Accounts | Contacts |
    Then verify all tabs are appearing on the "Sales" Form
      | Developments | Applications |
    Then verify all tabs are appearing on the "Marketing" Form
      | Marketing Lists | Campaigns | PowerMailChimp | Campaigns |

  @TC22938
  Scenario: TC22938
   When user click on "Dashboards" under Site Map

  @TC22939
  Scenario: TC22939_C9019 - Validation of global Search on Sales Hub home page
    Then user enter "Julie Utting ; *Nathan ;Nathan Ball* " in global search text box and validate text

      @CR40120 @TC42761 @TC42760 @TC42759
  Scenario: CR40120 of Sprint 18
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