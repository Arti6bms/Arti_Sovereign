@UserStorySprint19
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @CR40046 @TC43034
  Scenario: CR40046-TC43034 of Sprint 19
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    Then user clicks "Related" Tab for selecting "CaseItemAudit"
    Then user validate case record "Case Title" is created under case item audit

  @CR40046 @TC43041
  Scenario: CR40046-TC43041 of Sprint 19
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - Inactive Cases"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Case Title | Category (Case Title) | Subcategory (Case Title) | Case Number (Case Title) | Risk Priority | Modified On(Case) | Modified By(case) | Created On (Case Title) | Created By (Case Title) | Owner (Case Title) | Status (Case Title) | Status Reason (Case Title) | Created On | Created By |

  @CR40046 @TC43058
  Scenario: CR40046-TC43058 of Sprint 19
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    #Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Case Story Generated as "Yes"
    Then user clicks Finish in BPF
    Then user read the case title
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on "Reactivate Case"
    Then user click on "Reactivate" button
    Then user clicks "Related" Tab for selecting "CaseItemAudit"
    And user click on Case Item Audit Drop Down List
    And user select "Case Risk Audit - Active Cases" from drop down list
    Then user validate "Case Risk Audit - Active Cases" view

  @CR40046 @TC43039
  Scenario: CR40046-TC43039 of Sprint 19
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Case Story Generated as "Yes"
    Then user clicks Finish in BPF
    Then user read the case title
    Then user click on "Cancel Case"
    Then user validate read only message as "This record’s status: Canceled"
    Then user clicks "Related" Tab for selecting "CaseItemAudit"
    And user click on Case Item Audit Drop Down List
    And user select "Case Risk Audit - Inactive Cases" from drop down list
    Then user validate "Case Risk Audit - Inactive Cases" view

  @CR40046 @TC43040
  Scenario: CR40046-TC43040 of Sprint 19
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Case Story Generated as "Yes"
    Then user clicks Finish in BPF
    Then user read the case title
    Then user click on More commands for Case button
    Then user delete the case
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    Then user search CaseTitle
    Then user validate if no records are displayed
    
      @CR40046 @TC43038
  Scenario: CR40046-TC43038 of Sprint 19
   When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user selects Case Story Generated as "Yes"
    Then user clicks Finish in BPF
    Then user read the case title
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
     Then user validate read only message as "This record’s status: Resolved"
    Then user clicks "Related" Tab for selecting "CaseItemAudit"
    And user click on Case Item Audit Drop Down List
    And user select "Case Risk Audit - Inactive Cases" from drop down list
    Then user validate "Case Risk Audit - Inactive Cases" view
    
    
