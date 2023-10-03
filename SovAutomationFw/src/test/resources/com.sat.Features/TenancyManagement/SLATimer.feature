@SLA_TIMER
@Tenancy
Feature: Testing of SLA_TIMER

  @TC_30612
  Scenario: TC_30612-US 5978: Validation of SLA - Tenancy Management - Safeguarding Case SLA Risk Priority - Critical
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  When user click on "Cases" under customer
  And user click on New Cases
  Then user fill all the details for "Customer" as "Jerrilee Shepherd"
  And user will select Category as "Customer"
  And user fill all the details for "Subcategory" as "Safeguarding"
  And user fill Safeguarding Category as "Adult"
  And user fill Safeguarding Type Category as "Financial"
  #Then user validate "Full Risk Prioritisation" tab
  And user enters description
  Then user will select Original Alerter as "Contractor"
  #When user click on "Initial Risk Prioritisation" tab
  Then user select "Yes" for all questions of Initial Risk Prioritisation Questions
  Then user click on "Save"
  Then user verify "Applicable SLA" and "Response Time" as "Safeguarding Priority 1" section in Summary Tab
  When user click on "Initial Risk Prioritisation" tab
  Then user validate "Initial Risk Prioritisation score" as "55" in Initial Risk Prioritisation tab
  Then user validate "Risk Priority" is displayed as "Critical"
  
  @TC_30668
  Scenario: TC_US 5978: Validation of SLA6t - Tenancy Management - Safeguarding Case SLA Risk Priority as Highand SLA breach
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
  When user click on "Cases" under customer
  #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
  And user click on New Cases
  Then user fill all the details for "Customer" as "Jerrilee Shepherd"
  And user will select Category as "Customer"
  And user fill all the details for "Subcategory" as "Safeguarding"
  And user fill Safeguarding Category as "Adult"
  And user fill Safeguarding Type Category as "Domestic Abuse"
  And user fill Safeguarding Type Category as "Financial"
  Then user validate "Full Risk Prioritisation" tab
  And user enters description
  Then user will select Original Alerter as "Contractor"
  When user click on "Initial Risk Prioritisation" tab
  Then user select "Yes" for two questions of Initial Risk Prioritisation Questions
  Then user click on "Save"
  #Then user wait for case to save
  When user click on "Initial Risk Prioritisation" tab
 	#Then user validate "Initial Risk Prioritisation score" as "25" in Initial Risk Prioritisation tab
  Then user validate "Risk Priority" is displayed as "High"
  
  @TC28315_TC28316
  Scenario: C10722-Validation of  case closer and Reactivate functionality
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  When user click on "Cases" under customer
  And user click on New Cases
  Then user fill all the details for "Customer" as "James Green"
  And user will select Category as "Customer"
  And user fill all the details for "Subcategory" as "Safeguarding"
  And user fill Safeguarding Category as "Adult"
  And user fill Safeguarding Type Category as "Domestic Abuse"
  And user fill Safeguarding Type Category as "Financial"
  Then user validate "Full Risk Prioritisation" tab
  And user enters description
  Then user will select Original Alerter as "Contractor"
  When user click on "Initial Risk Prioritisation" tab
  Then user select "Yes" for two questions of Initial Risk Prioritisation Questions
  Then user click on "Save"
  And user fill all the details for "Case Closure Reason" as "No action needed/taken"
  Then user select Alerter checkbox
  Then user click on "Save"
  And user select Assign from the top menu option
  Then user clicks on Assign button
  Then user click on "OK" button
  And user clicks on "More commands for Case"
  Then user click on "Resolve Case"
  Then user enters the details for "Resolution" as "Test"
  Then user click on "Resolve" button
  Then User validates the text "Read-only This record’s status: Resolved"
  Then user click on refresh button
  Then user click on Reactivate Case
  Then user click on "Reactivate" button
  
  @TC_32401
  Scenario: TC_32401_Validation of SLA - Tenancy Management - ASB Case SLA Timer 48 Hrs
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  When user click on "Cases" under customer
  And user click on New Cases
  Then user fill all the details for "Customer" as "Jerrilee Shepherd"
  And user fill all the details for "Category" as "Enforcement (legal)"
  And user fill all the details for "Subcategory" as "ASB"
  And user enters description
  Then user click on "Save"
 Then user validate "Triage Assessment" tab
 When user click on "Triage Assessment" tab
  Then user fills the Triage Assessment Questions
  Then user click on "Save"
  Then user validates "TA Score" as "15"
  Then user click on "Triage Assessment"
  Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
  Then user validates "Response Time" as "ASB Priority 2 - 48 Hours (working)"
  When user click on "Summary" tab
  Then user verify "Applicable SLA" and "Response Time" as "ASB Priority 2 - 48 Hours (working)" section in Summary Tab
  
  @TC_32402_TC32320_TC34553
  Scenario: TC_32402_Validation of SLA - Tenancy Management - ASB Case SLA Timer 24Hrs
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user selects "Harassment / Intimidation" in field "ASB Case Category"
    Then user selects "Verbal abuse" in field "ASB Type"
    And user enters description
    Then user click on "Save"    
    Then user validate "Triage Assessment" tab
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    Then user fills the Triage Assessment Questions for score 33
    Then user click on "Save"
    Then user validates "TA Score" as "33"
    Then user click on "Triage Assessment"
    Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
    Then user validates "Response Time" as "ASB Priority 1 - 24 Hours (working)"
    When user click on "Summary" tab
    Then user verify "Applicable SLA" and "Response Time" as "ASB Priority 1 - 24 Hours (working)" section in Summary Tab
    Then user validate "Risk Priority" is displayed as "High"
    
    @TC_32403
  Scenario: TC_32403_Validation of SLA - Tenancy Management - ASB Case SLA Timer 5days
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"

    @TC_32322
  Scenario: TC_32322_Validate Risk Status is set to ‘Low’ when TA Scoring  Value is >= 7 and <=10 of ASB Case.
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user selects "Noise" in field "ASB Case Category"
    Then user selects "Music" in field "ASB Type"
    And user enters description
    Then user click on "Save"    
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions for score 10
    Then user click on "Save"
    Then user validates "TA Score" as "10"
    Then user click on "Triage Assessment"
    Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
    Then user validates "Response Time" as "ASB Priority 3 - 72 Hours (working)"
    When user click on "Summary" tab
    Then user validate "Risk Priority" is displayed as "Low"
    
    @TC_32323
  Scenario: TC_32323 Validate Risk Status is set to 'Not ASB - Signpost' when the TA Scoring  Value is <7 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user selects "Noise" in field "ASB Case Category"
    Then user selects "Music" in field "ASB Type"
    And user enters description
    Then user click on "Save"    
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions for score <7
    Then user click on "Save"
    Then user validates "TA Score" as "2"
    Then user click on "Triage Assessment"
    Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
    Then user validates "Response Time" as "Not ASB - Signpost"
    When user click on "Summary" tab
    Then user validate "Risk Priority" is displayed as "Not ASB - Signpost"
    
    @TC_32330
  Scenario: TC_32330 Validate Risk Status is set to ‘Medium’ when the TA Scoring > 10 and < 25 of ASB Case.
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user selects "Harassment / Intimidation" in field "ASB Case Category"
    Then user selects "Verbal abuse" in field "ASB Type"
    And user enters description
    Then user click on "Save"    
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions for score >10
    Then user click on "Save"
    Then user validates "TA Score" as "15"
    Then user click on "Triage Assessment"
    Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
    Then user validates "Response Time" as "ASB Priority 2 - 48 Hours (working)"
    When user click on "Summary" tab
    Then user validate "Risk Priority" is displayed as "Medium"
    
    @TC_32270
    Scenario: US21062 Validate  TA Score is Populated for ASB Category
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user selects "Harassment / Intimidation" in field "ASB Case Category"
    Then user selects "Verbal abuse" in field "ASB Type"
    And user enters description
    Then user click on "Save"    
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions for score 25
    Then user click on "Save"
    Then user validates "TA Score" as "25"
    Then user click on "Triage Assessment"
    Then user select "Triage Assessment Complete" as "Yes"
    Then user clicks Next Stage in BPF
    Then user validates "Response Time" as "ASB Priority 1 - 24 Hours (working)"
    When user click on "Summary" tab
    Then user validate "Risk Priority" is displayed as "High"
    