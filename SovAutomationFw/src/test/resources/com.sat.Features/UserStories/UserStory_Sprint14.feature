@Userstory14
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

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

  @CR36399 @TC37483_TC37490
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    And user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user select "Select all" Option in "Case Story Option" field and verifies All Selected Options are visible
    When user click on "Summary" tab
    And user click on save button
    Then user clicks on Customer field
    Then user verifies the "ASB" flag exists
    Then user verifies the Tool Tip of "ASB" flag
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user delete the case
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user verifies the "ASB" flag exists
    Then user verifies the Tool Tip of "ASB" flag does not exist
    Then user clicks on Account field
    Then user verifies the "ASB" flag exists
    Then user verifies the Tool Tip of "ASB" flag does not exist

  @CR36399 @TC37489
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    And user enters description
    And user click on save button
    When user click on "Summary" tab
    Then user click on More commands for Connection button
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Alleged Perpetrator"
    And user enters description
    And user click on save button
    Then user clicks on Back button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user select "Select all" Option in "Case Story Option" field and verifies All Selected Options are visible
    When user click on "Summary" tab
    And user click on save button
    Then user clicks on Customer field
    Then user verifies the "ASB Court Order" flag exists
    Then user verifies the Tool Tip of "ASB Court Order" flag
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user delete the case
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user verifies the "ASB Court Order" flag exists
    Then user verifies the Tool Tip of "ASB Court Order" flag does not exist

  @CR36399 @TC37628
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    And user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user select "Select all" Option in "Case Story Option" field and verifies All Selected Options are visible
    When user click on "Summary" tab
    And user click on save button
    Then user clicks on Customer field
    Then user verifies the "ASB" flag exists
    Then user verifies the Tool Tip of "ASB" flag
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user clicks on "Cancel Case"
    Then user click on "Confirm" button
    Then user clicks on Customer field
    Then user verifies the "ASB" flag exists
    Then user verifies the Tool Tip of "ASB" flag does not exist

  @CR36399 @TC37629
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    And user enters description
    And user click on save button
    When user click on "Summary" tab
    Then user click on More commands for Connection button
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Alleged Perpetrator"
    And user enters description
    And user click on save button
    Then user clicks on Back button
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user select "Select all" Option in "Case Story Option" field and verifies All Selected Options are visible
    When user click on "Summary" tab
    And user click on save button
    Then user clicks on Customer field
    Then user verifies the "ASB Court Order" flag exists
    Then user verifies the Tool Tip of "ASB Court Order" flag
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user clicks on "Cancel Case"
    Then user click on "Confirm" button
    Then user clicks on Customer field
    Then user verifies the "ASB Court Order" flag exists
    Then user verifies the Tool Tip of "ASB Court Order" flag does not exist

  @US36984 @TC37485
  Scenario: CR36399 of Sprint 14
    When user selects App "Customer Service Hub"
    When user click on "Flags" under customer
    Then user select one of Flag
    And user click on save button
    Then user select the flag from flag details grid
    Then user perform click on "Edit"
    Then user edit Flag Start Date
    And user click on save button
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies New Value field for new Flag Details in the audit details

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

  @US12162 @TC39554
  Scenario: US12162 of Sprint 15
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    And user enters description
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user click on save button
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "Medium"
    And user click on save button
    When user click on "Summary" tab
    Then user fill details for "Fraud Case Category" as "False Immigration Status"
     And user click on save button
    Then user validate "Risk Priority" is displayed as "Medium"
    
      @US12162 @TC39626
  Scenario: US12162 of Sprint 15
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    And user enters description
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user click on save button
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "Medium"
    And user click on save button
    Then user validate "Risk Priority" is displayed as "Medium"


  @US12162 @TC38981 @TC38982 @TC38983 @TC38984 @TC38986 @TC38988 @TC38991 @TC38992 @TC38993 @TC38994 @TC38996
  Scenario Outline: US12162 of Sprint 15
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    And user enters description
    Then user fill details for "Fraud Case Category" as "<FraudCaseCategory>"
    And user click on save button
    Then user validate "Risk Priority" is displayed as "<RiskPriority>"

    Examples: 
      | RiskPriority | FraudCaseCategory         |
      | High         | Abandonments              |
      | High         | Non Occupation            |
      | High         | Subletting                |
      | High         | False Housing Application |
      | High         | Key Selling               |
      | Medium       | Unlawful Assignment       |
      | Medium       | Illegal Mutual Exchange   |
      | Medium       | False Succession          |
      | Medium       | Multiple Tenancies        |
      | Medium       | Undisclosed Lodgers       |
      | Low          | False Immigration Status  |


@US38076 @Sprint14 @TC38484 
Scenario: US38076 of Sprint 14
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
   | CustomerName | OwnerFieldname      |
   | Jerrilee Shepherd  | East Admin Tenancy  |
   | Martin Bell  | West Admin Tenancy  |
   | Liam Donald  | South Admin Tenancy |
   | Laura Trim   | East Admin Tenancy  |

   


