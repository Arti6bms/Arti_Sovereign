@Potential_ET
Feature: Testing of Potential Outcomes in Employment and Training

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    When user click on "E & T Opportunity" under customer
    #When user search "TEST Opportunity Programme"
    When user search Opportunity Name
    Then user sort the records from newer to older
    Then user click on Potential name
    When user click on "Outcome Management" tab
    Then user clicks on "New Potential Outcome. Add New Potential Outcome"

  @TC_23342
  Scenario: TC_23342-C11788-Validation of Wellbeing Outcome - Potential Outcome
    Then user select "Outcome Type" as "Wellbeing"
    Then user validate the "Wellbeing Outcome" section for below fields
      | Mental Health | Confidence | Control of Life | Financial Comfort | Able to Access Information | Able to Access The Internet | Able to Pay for Housing |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected |
    Then user fills all the fields in Wellbeing Outcome Section
      | Mental Health | Confidence | Control of Life | Financial Comfort | Able to Access Information | Able to Access The Internet | Able to Pay for Housing | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Wellbeing" Potential is showing in Outcome Management grid

  @TC_23343
  Scenario: TC_23343-C11789-Validation of Training Outcome - Potential Outcome
    Then user select "Outcome Type" as "Training"
      Then user validate the "Training Outcome" section for below fields
      | Training Outcome Gained | Training Type | Type of Training | Digital Training | 
    Then user validate the "Outcome Details" section for below fields
      | Date Expected |
   Then user enters the details in Training Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Training" Potential is showing in Outcome Management grid
    
   @TC_23344
  Scenario: TC_23344-C11790-Validation of Job Outcome - Potential Outcome
   Then user select Outcome Type as Job
    Then user validate the "Job Outcome" section for below fields
   | Job Contract Type | Job Contract Duration | Salary Range | Weekly Hours | Job Company Name | Job Title |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected |
   Then user enters the details in Job Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Job" Potential is showing in Outcome Management grid
    
    @TC_23345
  Scenario: TC_23345-C11791-Validation of Work Placement Outcome - Potential Outcome
   Then user select "Outcome Type" as "Work Placement"
    Then user validate the "Work Placement" section for below fields
   | Placement Company Name |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected |Role|Number of hours|
   Then user enters the details in Work Placement Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Work Placement" Potential is showing in Outcome Management grid
  
   @TC_23346
  Scenario: TC_23346-C11792-Validation of Volunteering Outcome - Potential Outcome
   Then user select "Outcome Type" as "Volunteering"
    Then user validate the "Volunteering Outcome" section for below fields
   | Volunteering Company Name |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected |Role|Number of hours|
   Then user enters the details in Volunteering Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Volunteering" Potential is showing in Outcome Management grid
  
   @TC_23347
  Scenario: TC_23347-C11793-Validation of License/ Affiliation/ Registration Outcome - Potential Outcome
   Then user select "Outcome Type" as "License/ Affiliation/ Registration"
    Then user validate the "License/ Affiliation/ Registration Outcomes" section for below fields
   | License/ Affiliation/ Registration Type |
   Then user enters the details in LicenseAffiliationRegistration Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "License/ Affiliation/ Registration" Potential is showing in Outcome Management grid
    
    @TC_23348
  Scenario: TC_23348-C11794-Validation of MaD Programme Outcome - Potential Outcome
   Then user select "Outcome Type" as "MaD Programme"
 Then user validate the "Outcome Details" section for below fields
      | Date Expected |Role|Number of hours|
   Then user enters the details in MaD Programme Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "MaD Programme" Potential is showing in Outcome Management grid

 @TC_23349
  Scenario: TC_23349-C11795-Validation of Equipment Grant Outcome - Potential Outcome
   Then user select "Outcome Type" as "Equipment Grant"
   Then user enters the details in Equipment Grant Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Equipment Grant" Potential is showing in Outcome Management grid
    
    
    @TC_23350
  Scenario: TC_23350-C11796-Validation of Financial Grant Outcome - Potential Outcome
   Then user select "Outcome Type" as "Financial Grant"
 Then user validate the "Outcome Details" section for below fields
      | Date Expected |Role|Number of hours|
   Then user enters the details in Financial Grant Outcome section for potential
    Then user click on "Save & Close"
    When user click on "Outcome Management" tab
    Then user validates the "Financial Grant" Potential is showing in Outcome Management grid
    