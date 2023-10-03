@ActionPlans
Feature: Testing of Regression Test Cases in Employment and Training Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    #Then user is navigated to "My Work Dashboard - Dynamics 365" page
    
  @TC23319
  Scenario: TC23319-C11767-Validation of add action to an action plan form final assessment tab in assessment
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    When user click on "Assessment" under "CaseManagement"
    Then user pick active Assessment
    #Then user select "- Carpenter ET" Assessment in Assessment form    
     When user click on "ETO Initial Assessment" tab
     #Then user read the Goal Setting
    When user click on "Final Assessment" tab
    #When user click on "William Davis-AP" link
    When user click on ActionPlan link
    Then user validates "Goal Setting" section in "Action Plan Details" are mapped from Assessment
      | Goal Setting       |
      | What is your goal? |
      | Support for Goal?  |
      | Way of Working?    |
      | Goal: 6 Weeks      |
      | Goal: 6 Months     |
      | Goal: 3 Years      |
    Then user Navigate to Action Plan and Click on +New Action button
    Then user enters Action field in "Action Plan" Quick Create form
    Then user enters ByWhen field in "Action Plan" Quick Create form
  And user Click on save and close
  Then user validates the "TEST_ACTION" is showing in Action Grid
  
  @TC23320
  Scenario: TC23320-C11763-Validation of sending an Action Plan to customer - Employment and Training Hub
    When user click on "Assessment" under "CaseManagement"
    Then user pick active Assessment
   # Then user select "Gemma Green ET Assessments" Assessment in Assessment form     
    When user click on "Final Assessment" tab
    When user click on ActionPlan link
    Then user clicks on "Export to PDF. Launch Export to PDF Dialog"
    Then user validates Download link is available for Export To PDF
    
   

  @TC23321
  Scenario: TC23321_C11766-Validation of Complete / Close Actions - Employment and Training Hub
    When user click on "Assessment" under customer
    #Then user is navigated to "Assessments Active Assessments - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Assessments" from drop down list
    Then user search "- Carpenter ET Assessments"
    And user select radio button and double click on assessment
    When user click on "Final Assessment" tab
    When user click on "- Carpenter-AP" link
    And user select radio button and double click on assessment
    And user select Actual End Date
    And user click on save button
    Then user click on Mark Complete with the tick mark
    And user validate completed date of action plan
    And user select radio button and double click on assessment
    And user validate action plan should be read only "Read-only This record’s status: Completed"

  @TC23322
  Scenario: TC23322_C11765-Validation of Actions Plan Logic -Triage Assessments - Employment and Training Hub
    When user click on "Assessment" under customer
    #Then user is navigated to "Assessments Active Assessments - Dynamics 365" page
    Then user creates the new contact
    And user click on More Header fields icon
    And user fill all the details for "Contact Assessed" as "- Carpenter"
    And user fill all the details for "ETO" as "# adm_aday"
    When user click on "Triage Assessment" tab
    Then user fill details for "Photo ID?" as "No"
    Then user fill details for "Driving License" as "No"
    Then user fill details for "Passport" as "No"
    Then user fill details for "Provisional Driving License" as "No"
    Then user fill details for "Other forms of ID?" as "No"
    Then user fill details for "mBirth Certificate" as "No"
    Then user fill details for "Work Permit" as "No"
    Then user fill details for "References" as "No"
    Then user fill details for "Bank Account?" as "No"
    Then user fill details for "Right to Work in UK?" as "No"
    Then user fill details for "Appropriate Email Address?" as "No"
    Then user fill details for "Phone Number in Use?" as "No"
    Then user fill details for "Help with Childcare?" as "Yes"
    Then user fill details for "Access to Reliable Transport?" as "No"
     And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    And user click on save button
    Then user clicks Initial Assessment on BPF
    Then user selects Initial Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    And user click on save button
    Then user click on refresh button
    When user click on "- Carpenter-AP" link
    Then user verifies the questions in "Action" section
      |Action                                        |
      | Support to obtain 2 references for work                   |
      | Support to obtain active phone number                            |
      | Support to obtain additional ID                           |
      | Support to obtain appropriate email address                |
      | Support to obtain bank account          |
      | Support to obtain childcare          |
      | Support to obtain Photo ID                  |
      | Support to obtain reliable travel options               |
      | Support to obtain Right to Work in UK        |
   Then user click on Back button  
   When user click on "Triage Assessment" tab 
   Then user fill details for "Photo ID?" as "Yes"
    Then user fill details for "Driving License" as "Yes"
    Then user fill details for "Passport" as "Yes"
    Then user fill details for "Provisional Driving License" as "Yes"
    Then user fill details for "Other forms of ID?" as "Yes"
    Then user fill details for "mBirth Certificate" as "Yes"
    Then user fill details for "Work Permit" as "Yes"
    Then user fill details for "References" as "Yes"
    Then user fill details for "Bank Account?" as "Yes"
    Then user fill details for "Right to Work in UK?" as "Yes"
    Then user fill details for "Appropriate Email Address?" as "Yes"
    Then user fill details for "Phone Number in Use?" as "Yes"
    Then user fill details for "Help with Childcare?" as "No"
    Then user fill details for "Access to Reliable Transport?" as "Yes"
     And user click on save button
     When user click on "Final Assessment" tab
     Then user click on refresh button
    When user click on "- Carpenter-AP" link
     Then user verifies the questions in "Action" section
      |Action                                        |
      | Support to obtain 2 references for work                   |
      | Support to obtain active phone number                            |
      | Support to obtain additional ID                           |
      | Support to obtain appropriate email address                |
      | Support to obtain bank account          |
      | Support to obtain childcare          |
      | Support to obtain Photo ID                  |
      | Support to obtain reliable travel options               |
      | Support to obtain Right to Work in UK        |
    
 
 @TC23323
  Scenario: TC23323_C11787-Validation of Action Plan Logic - Initial Assessment - Employment and Training Hub
    When user click on "Assessment" under customer
    #Then user is navigated to "Assessments Active Assessments - Dynamics 365" page
    Then user creates the new contact
    And user click on More Header fields icon
    And user fill all the details for "Contact Assessed" as "Julie Utting"
    And user fill all the details for "ETO" as "# adm_jscaplehorn"
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    When user click on "ETO Initial Assessment" tab
    Then user fill details for "Find Work" as "No"
    Then user fill details for "Better Work" as "No"
    Then user fill details for "Access Training" as "No"
    Then user fill details for "Business Start Up" as "No"
    Then user fill details for "What is your goal?" as "test"
    Then user fill details for "Goal: 6 Months" as "test"
    Then user fill details for "Help with Learning/Training?" as "Yes"
    Then user fill details for "Disability/Health Conditions?" as "Yes"
    Then user fill details for "Help with Building Confidence?" as "Yes"
    Then user fill details for "Job Applications" as "Yes"
    Then user fill details for "Interviews" as "Yes"
    Then user fill details for "IT Training" as "Yes"
    Then user fill details for "Functional Skills" as "Yes"
    Then user fill details for "Vocational Skills" as "Yes"
    Then user fill details for "Volunteering/ Work Placement" as "Yes"
    Then user fill details for "Help Financing Tenancy?" as "Yes"
    Then user fill details for "Know how much to earn?" as "Yes"
    Then user fill details for "Help with Money Matters?" as "Yes"
    Then user fill details for "Social Media/ Video Conferencing?" as "Yes"
    Then user fill details for "Internet Access?" as "Yes"
    Then user fill details for "Access to a Device?" as "Yes"
    Then user fill details for "IT Programmes?" as "Yes"
    Then user clicks Initial Assessment on BPF
    Then user selects Initial Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    And user click on save button
    When user click on "Final Assessment" tab
    Then user click on refresh button
    When user click on "Julie Utting-AP" link
    Then user verifies the questions in "Action" section
    |Action                                        |
    |Discuss Better Off Calculation and identify if a TSA referral is needed|
    |Discuss options for Functional Skills Training|
    |Discuss options for increasing access to an IT device|
    |Discuss options for increasing access to the internet|
    |Discuss options for IT Training|
    |Discuss options for support with social media/ video conferencing|
    |Discuss options for Vocational Training|
    |Discuss options for Work Placement or Volunteering opportunities|
    |Discuss support available for Interview Skills|
    |Discuss support available for looking and applying for jobs|
    |Discuss support required for confidence building|
    |Discuss support required for disabilities/ health conditions|
    |Discuss support required for learning and training|
    |Discuss tenancy finance support needs and identify if a TSA referral is needed|
    |Identify IT support and/or training needs|
    |Identify support required for money matters and identify if a TSA referral is needed|
    
    
    
    