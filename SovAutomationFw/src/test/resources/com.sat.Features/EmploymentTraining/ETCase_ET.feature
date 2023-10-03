@ETCase
Feature: Testing of ETCase in Employment and Training

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"

  @TC_23335
  Scenario: TC_23335-C11764-Validation of View the ET Case
    When user click on "Assessment" under customer
   Then user search Assessment Name
    Then user sort the records from newer to older
    Then user click on Assessment name
    Then read the Assessment details
    When user click on "Final Assessment" tab
    Then user click on ET CASE
    Then user validate the fields are mapped from Assessment
    Then user validate Action plan associated to the Assessment is showing in the Action Plan Grid

  @TC_23336
  Scenario: TC_23336-C11777-Validation of View Outcomes
    When user click on "ET Case" under customer
    #When user search "- Carpenter ET Case"
    Then user click on any active ET Case name
    When user click on "Outcomes" tab
    Then user validate the following grids are displayed
      | Job Outcomes | Training Outcomes | Wellbeing Outcome | Work Placement Outcomes | Volunteering Outcomes |
    Then user validate "Equipment Grant" grid exist with following fields
      | Type of Equipment | Equipment Grant Awarded | Equipment Date Grant Completed |
    Then user validate "Financial Grant" grid exist with following fields
      | Type of Funding Applied For | Amount of Funding Applied For | Type of Grant | Amount Awarded | Date Grant Completed |
    Then user validate "Licence/Affiliation Grant" grid exist with following fields
      | License/ Affiliation/ Registration Type | License/ Affiliation/ Registration Start Date | License/ Affiliation/ Registration Expiry Date |
    Then user validate "External Provider Programme" grid exist with following fields
      | External Provider | Date referred | Support Offered |
    Then user validate "Saving to Customer" grid exist with following fields
      | Outcome Name | Date Captured | Income Generated | Debt Reduced or Written Off | Overall Annual Saving | Rent Account at Date of Capture |
   Then user creates "Outcome Type" as "Job"
    Then user creates "Outcome Type" as "Training"
    Then user creates "Outcome Type" as "Wellbeing"
    Then user creates "Outcome Type" as "Work Placement"
    Then user creates "Outcome Type" as "Volunteering"
    Then user validates the Job Outcomes for "Tester"
    Then user validates the Work Placement for "WorkPlacement"
    Then user validates the Volunteering Outcomes for "VolunteeringCompany"
    Then user validates the Training Outcomes for "Accredited Training"
    Then user validates the Wellbeing Outcomes grid

  @TC_23338
  Scenario: TC_23338-C11783-Validation of Close and Reopen of as case Employement and Training
    When user click on "ET Case" under customer
    #When user search "- Carpenter ET Case"
    Then user click on any active ET Case name
    Then user clicks on "More Header Editable Fields"
    Then user select "ET Case Reason for Closure" as "Deceased"
    Then user clicks on "Deactivate"
    Then user validate the message "This record’s status: Inactive"
    Then user clicks on "Activate"
    Then user validate ET case Editable
    Then user clicks on "More Header Editable Fields"
    Then user verifies the field "ET Case Reason for Closure"
      | Moved away | Disengaged | Prison | Deceased | Requested Closure | No Further Support Required |
      
      @TC_23337
  Scenario: TC_23337-C11786-Validation of Creation of an Appointment, Add an Action & an Outcome -- Employment and Training Hub
    When user click on "ET Case" under customer
    And user click on Drop Down List
    And user select "Active Cases" from drop down list
    When user search ET CASE 
    #"Julie Utting ET Case" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    #Then user validate Regarding fields is auto populated
    Then user verify all the "Appointment" list values
      | Initial | In work | Final | Follow Up |
    Then user fill details for "Appointment" as "Initial"
    Then user validates the field "Phone Number" when "Appointment Type" is selected as "Phone"
    Then user validates the field "Teams Link URL" when "Appointment Type" is selected as "Online"
    Then user validates the field "First Line" when "Appointment Type" is selected as "Face to Face"
    Then user validates the field "Second Line" when "Appointment Type" is selected as "Face to Face"
    Then user validates the field "Town" when "Appointment Type" is selected as "Face to Face"
    Then user validates the field "Postcode" when "Appointment Type" is selected as "Face to Face"
    Then user fill details for "Appointment Type" as "Phone"
    And user enters description
    And user click on save button
    
     @US38576
  Scenario: US38576 of Sprint 10
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseTitle
    Then user Click the + on the timeline and select "E-mail Activity"
    Then user validate Contact name is autopopulate in "TO" under Email Activity
    Then user validate CaseTitle is autopopulate in "Regarding" under Email Activity

  @US38577
  Scenario: US38577 of Sprint 10
    #need to complete
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user Click the + on the timeline and select "Phone Call Activity"

  @CR30958 @TC37693 @TC37696 @TC37692 @TC38126 @TC37700
  Scenario Outline: CR30958 of Sprint 12
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseTitle
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Contact name is autopopulate in "To" under Email Activity
    Then user validate CaseTitle is autopopulate in "Regarding" under Email Activity

    Examples: 
      | Activity             |
      | E-mail Activity      |
      | Phone Call Activity  |
      | SMS Message Activity |
    
