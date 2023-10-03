@FraudCases
Feature: Testing of Fraud Cases in Tenancy Management

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"

  @FraudCasesAllTestCases
  @TC29152_TC29158_TC29150_TC29135_TC29144
  Scenario: TC29152, TC29158, TC29150, TC29135, TC29144
    When user click on "Cases" under customer
    And user click on New Cases
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user enters description
    And user click on save button
    Then user fill details for "Fraud Case Category" as "Abandonments"
    Then user scroll down to till element is visible
    Then user verifies "Original Alerter" list values
      | Customer Contact | External Portal | HARS | Home Visits | Internal Portal | letters/Email | Other Departments - Lettings, Income, Property | RTB Application |
    And user fill all the details for "Original Alerter" as "External Portal"
    And user click on save button
    Then user scroll down to till element is visible
    Then user click on More commands for Connection button
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Case Contact"
    And user enters description
    Then user click on save and close button
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    Then user fill details for "Refered to DVLA?" as "Yes"
    Then user verifies the date stored for "Date of Date Refered to DVLA"
    Then user fill details for "Acknowledgement Received From DVLA?" as "Yes"
    Then user verifies the date stored for "Date of Date Acknowledgement Received From DVLA"
    Then user fill details for "Action Taken Forward DVLA Outcome" as "Evidence of Fraud"
    Then user fill details for "Refered to NAFN?" as "Yes"
    Then user verifies the date stored for "Date of Date Refered to NAFN"
    Then user fill details for "Acknowledgement Received From NAFN?" as "Yes"
    Then user verifies the date stored for "Date of Date Acknowledgement Received From NAFN"
    Then user fill details for "Action Taken Forward NAFN Outcome" as "Further checks required"
    And user fill all questions for FraudChecklist
    Then user fill details for "Action taken through further internal sources (i.e. Income)" as "Yes"
    Then user fill details for "Unlawful profit order obtained" as "Yes"
    And user click on save button
    Then user validates the case displayed
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies the fields are displayed in the Audit History
      | Changed Date | Changed By | Event | Changed Field | Old Value | New Value |
    Then user verifies New Value field for new Fraud Case in the audit details
    Then user click on Tab "Summary"
    Then user fill all the details for "Originating Neighbourhood" as "25 Redhills Close, Exeter"
    And user click on save button
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies New Value "25 Redhills Close, Exeter" field for updated Field "Originating Neighbourhood" in the audit details
    Then user remove the field "Originating Neighbourhood" value "25 Redhills Close, Exeter" is updating in Audit History
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies removed "25 Redhills Close, Exeter" field for updated Field "Originating Neighbourhood" in the audit details
    Then user click on Tab "Summary"
    Then user verifies "Case Closure Reason" list values
      | No Evidence of Fraud | Keys Surrendered | Evicted for Fraud | Evicted for Fraud/Profits Gained | Evicted for other tenancy breaches i.e. Arrears | Other intervention | Non Fraud Case Raised |
    And user fill all the details for "Case Closure Reason" as "No Evidence of Fraud"
    And user click on save button

  @FraudCasesCreation
  @TC29152
  Scenario: TC29152_Validation of Fraud case creation
    When user click on "Cases" under customer
    And user click on New Cases
     Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"   
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user enters description
    And user click on save button
    Then user click on save and close button
    Then user scroll down to till element is visible
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Case Contact"
    And user enters description
    Then user click on save and close button
    And user click on save button
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    Then user fill details for "Refered to DVLA?" as "Yes"
    Then user verifies the date stored for "Date of Date Refered to DVLA"
    Then user fill details for "Acknowledgement Received From DVLA?" as "Yes"
    Then user verifies the date stored for "Date of Date Acknowledgement Received From DVLA"
    Then user fill details for "Action Taken Forward DVLA Outcome" as "Evidence of Fraud"
    Then user fill details for "Refered to NAFN?" as "Yes"
    Then user verifies the date stored for "Date of Date Refered to NAFN"
    Then user fill details for "Acknowledgement Received From NAFN?" as "Yes"
    Then user verifies the date stored for "Date of Date Acknowledgement Received From NAFN"
    Then user fill details for "Action Taken Forward NAFN Outcome" as "Further checks required"
    And user fill all questions for FraudChecklist
    Then user fill details for "Action taken through further internal sources (i.e. Income)" as "Yes"
    Then user fill details for "Unlawful profit order obtained" as "Yes"
    And user click on save button
    Then user validates the case displayed

  @FraudCasesClosure
  @TC29158
  Scenario: TC29158_Validation  of Fraud case closure reasons
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user enters description
    And user click on save button
    Then user scroll down to till element is visible
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Case Contact"
    And user enters description
    And user click on save button
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    Then user fill details for "Refered to DVLA?" as "Yes"
    Then user fill details for "Acknowledgement Received From DVLA?" as "Yes"
    Then user fill details for "Action Taken Forward DVLA Outcome" as "Evidence of Fraud"
    Then user fill details for "Refered to NAFN?" as "Yes"
    Then user fill details for "Acknowledgement Received From NAFN?" as "Yes"
    Then user fill details for "Action Taken Forward NAFN Outcome" as "Further checks required"
    Then user verifies "Case Closure Reason" list values
      | No Evidence of Fraud | Keys Surrendered | Evicted for Fraud | Evicted for Fraud/Profits Gained | Evicted for other tenancy breaches i.e. Arrears | Other intervention | Non Fraud Case Raised |
    And user fill all the details for "Case Closure Reason" as "No Evidence of Fraud"
    And user click on save button

  @FraudCasesAudit
  @TC29150
  Scenario: TC29150_Validation of "Audit history" of Fraud case
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    Then user fill all the details for "Customer" as "James Green"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user enters description
    And user click on save button
    Then user scroll down to till element is visible
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Case Contact"
    And user enters description
    And user click on save button
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    Then user fill details for "Refered to DVLA?" as "Yes"
    Then user fill details for "Acknowledgement Received From DVLA?" as "Yes"
    Then user fill details for "Action Taken Forward DVLA Outcome" as "Evidence of Fraud"
    Then user fill details for "Refered to NAFN?" as "Yes"
    Then user fill details for "Acknowledgement Received From NAFN?" as "Yes"
    Then user fill details for "Action Taken Forward NAFN Outcome" as "Further checks required"
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies the fields are displayed in the Audit History
      | Changed Date | Changed By | Event | Changed Field | Old Value | New Value |
    Then user verifies New Value field for new Fraud Case in the audit details
    Then user click on Tab "Summary"
    Then user fill all the details for "Originating Neighbourhood" as "25 Redhills Close, Exeter"
    And user click on save button
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies New Value "25 Redhills Close, Exeter" field for updated Field "Originating Neighbourhood" in the audit details
     Then user remove the field "Originating Neighbourhood" value "25 Redhills Close, Exeter" is updating in Audit History
    And user click on Tab "Related" for selecting "Audit History"
    Then user verifies removed "25 Redhills Close, Exeter" field for updated Field "Originating Neighbourhood" in the audit details

  @FraudCasesAlerter
  @TC29135
  Scenario: TC29135_Validation of Fraud case creation and Original Alerter (Fraud Reporter details)
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Fraud"
    Then user fill details for "Fraud Case Category" as "Abandonments"
    And user enters description
    And user click on save button
    Then user scroll down to till element is visible
    Then user verifies "Original Alerter" list values
      | Customer Contact | External Portal | HARS | Home Visits | Internal Portal | letters/Email | Other Departments - Lettings, Income, Property | RTB Application |
    And user fill all the details for "Original Alerter" as "External Portal"
    And user click on save button
    Then user click on More commands for Connection button
    Then user clicks on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Case Contact"
    And user enters description
    Then user click on save and close button
    
#@tag1
#Scenario: Validation of "Audit history" of Fraud case
#Given User navigates to CRM login page
#When user selects App "Customer Service Hub"
#Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
#When user click on "Cases" under customer
#Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
#And user click on New Cases
#Then user scroll down "CASE DETAILS" in page
#Then user fill all the details for "Customer" as "Jerrilee Shepherd"
#Then user fill all the details for "Category" as "Enforcement (legal)"
#Then user fill all the details for "Subcategory" as "Fraud"
#Then user enters description
#Then user verifies "Fraud Case Category" list values
#|Abandonments|Non Occupation|Subletting|False Housing Application|Key Selling|Unlawful Assignment|Illegal Mutual Exchange|False Succession|Multiple Tenancies|Undisclosed Lodgers|False Immigration Status|
#Then user fill details for "Fraud Case Category" as "Abandonments"
#Then user checks tab "Fraud Check List" exists
#Then user clicks Fraud Check List Tab
#Then user verifies the fields in Fraud Check List tab
#|Reported before|First stage checklist completed|Evidence to progress investigations|Discuss findings with HSM|NAFN check|Evidence of Fraud (NAFN)|DVLA Check|Evidence of Fraud (DVLA)|Legal Action started|Tenancy surrendered|Tenancy surrendered repossessed|


