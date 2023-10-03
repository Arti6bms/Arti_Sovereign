@UserStorySprint20
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @US33533 @TC43736-TC43735
  Scenario: US33533-TC43736-TC43735 of Sprint 20
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

  @CR43274 @TC42735
  Scenario: CR43274-TCTC42735 of Sprint 20
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user verifies "Case Closure Reason" list values
      | Customer Refusal | Works Completed | None Access | Property not suitable | Refused at design | Refused post survey | Tenancy Ended | Works ended by Contractor | Works ended by customer |

  @CR44715
  @TC45577_TC45575_TC45589_TC45576_TC45584_TC45687
  Scenario Outline: CR44715 Validate 'Customer Specialist - Home Ownership' queue is set as default queue for 'Customer Specialist - Home Ownership' team.
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  When user click on "Cases" under customer
  And user click on New Cases
  Then user fill all the details for "Customer" as "<CustomerName>"
  And user fill all the details for "Category" as "Enforcement (legal)"
  And user fill all the details for "Subcategory" as "Breach of Lease"
  Then user verifies "Case Closure Reason" list values
      | Action taken | Action withdrawn | Breach remedied | 
  And user enters description
  And user click on save button
  Then user validate case Owner as "Customer Specialist - Home Ownership"
  Then user clicks on "Customer Specialist - Home Ownership"
  Then user validate default queue name as "<Customer Specialist - Home Ownership>"
  
  Examples:
  | CustomerName |
  | Anthony Hudd |
  | Tina King    |
  
  