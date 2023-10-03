@Outcomes
Feature: Testing of Outcome in Employment and Training

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    When user click on "Assessment" under customer
    When user search "Julie Utting ET Assessments"
    Then user sort the records from newer to older
    Then user click on Assessment name "Julie Utting ET Assessments"
    When user click on "Outcomes" tab
    Then user clicks on "New Outcome. Add New Outcome"
    Then user validate "Contact Information" is mapped from Assessment

  @TC_23324
  Scenario: TC_23324-C11768-Validation of Wellbeing Outcome
    Then user select "Outcome Type" as "Wellbeing"
    Then user validate the "Wellbeing Outcome" section for below fields
      | Wellbeing Outcome Gained | Mental Health | Confidence | Control of Life | Financial Comfort | Able to Access Information | Able to access the internet | Able to pay for housing |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user fills all the fields in Wellbeing Outcome Section
      | Mental Health | Confidence | Control of Life | Financial Comfort | Able to Access Information | Able to access the internet | Able to pay for housing | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "Wellbeing" is showing in Outcome grid
    Then user open the Outcome "Wellbeing"
    Then user removes "Wellbeing Outcome Gained" field data
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Wellbeing"
    Then user validate "Wellbeing Outcomes not entered" grid for "Wellbeing"
    When user click on "Outcomes" tab
    Then user deactivates the outcome "Wellbeing"
    Then user click on "Save"
#
  @TC_23325
  Scenario: TC_23325-C11769-Validation of Training Outcome
    Then user select "Outcome Type" as "Training"
    Then user validate the "Training Outcome" section for below fields
      | Training Outcome Claimed Date | Training Type | Type of Training | Digital Skills Training | Training Completed | Certificate Awarded | Provider | Level | Date Training Started | Claim Training Outcome on Skills For Work | Date Training Outcome Claimed On Skills For Work |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight | Add to CV | Evidence |
    Then user validates the field "Training Completed Date" when "Training Completed" is selected as "Yes"
    Then user validates the field "Certificate Awarded Date" when "Certificate Awarded" is selected as "Yes"
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user enters the details in "Training Outcome" section
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "Training" is showing in Outcome grid
    Then user open the Outcome "Training"
    Then user removes "Training Outcome Claimed Date" field data
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Training"
    When user click on "Outcomes" tab
    Then user deactivates the outcome "Training"
    Then user click on "Save"
#
  @TC_23329
  Scenario: TC_23329-C11773-Validation of License/Affiliation/Registration outcome
    Then user select "Outcome Type" as "License/ Affiliation/ Registration"
    Then user validate the "License/ Affiliation/ Registration" section for below fields
      | License/ Affiliation/ Registration Start Date | License/ Affiliation/ Registration Expiry Date | License/ Affiliation/ Registration Type |
    Then user validate the "Outcome Type" section for below fields
      | Outcome Type | Opportunity Outcome | Missed Outcome |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user enters the details in License/ Affiliation/ Registration section
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "License/ Affiliation/ Registration" is showing in Outcome grid
    Then user open the Outcome "License/ Affiliation/ Registration"
    Then user removes "License/ Affiliation/ Registration Start Date" field data
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "License/ Affiliation/ Registration"
    When user click on "Outcomes" tab
    Then user deactivates the outcome "License/ Affiliation/ Registration"
    Then user click on "Save"
#
  @TC_23326
  Scenario: TC_23326-C11770-Validation of Job Outcome
    Then user select "Outcome Type" as "Job"
    Then user validate the "Job Outcome" section for below fields
      | Job Outcome Claimed Date | Job Start Date | Job Contract Type | Job Contract Duration | Salary Range | Hourly Rate | Weekly Hours | Job Company Name | Job Company Sector | Job Role Type | Job Title | Date Job Role Finished | Reason for leaving | Number of Weeks Employed |
    Then user verifies the field "Job Contract Type"
      | Full Time | Part Time | Self Employment | Apprenticeship |
    Then user verifies the field "Job Contract Duration"
      | Fixed Term Contract | Permanent | Seasonal |
    Then user verifies the field "Salary Range"
      | £0-£5000 | £5001-£10,000 | £10,001-£15,000 | £15,001-£20,000 | £20,001 - £30,000 | £30,001-£40,000 | £40,000+ |
    Then user verifies the field "Job Company Sector"
      | Security | Warehouse and Distribution | Childcare | Construction | Customer Services | Distribution/ Logistics | Education | Hospitality and Catering | Health and Social Care | Admin | Retail | Tech/ Digital | Self Employment | Other |
    Then user verifies the field "Job Role Type"
      | Business Operations | Financial Services | People Services | Customer Service | Trades | Health | Safety and Compliance | IT | Facilities | Comms | Legal and Corporate Services | Other |
    Then user verifies the field "Reason for leaving"
      | Contract ended | Job terminated | Customer choice |
    Then user validate the "Sustainment Checks" section for below fields
      | Sustainment 3 Months | Sustainment 3 Month Met | Sustainment 6 Months | Sustainment 6 Months Met | Sustainment 9 Months | Sustainment 9 Months Met | Sustainment 12 Months | Sustainment 12 Months Met |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user validate the "Rent Account Capture" section for below fields
      | Rent Account Status (Job Start) | Rent Account Status (3months) | Rent Account Status (6months) | Rent Account Status (9months) | Rent Account Status (12months) |
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "Job" is showing in Outcome grid
    Then user open the Outcome "Job"
    Then user removes "Job" field data
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Job"
#
  @TC_23327
  Scenario: TC_23327_C11771- Validation of Work Placement Outcome  - Employment and Training Hub
    Then user fill details for "Outcome Type" as "Work Placement"
    And user click on save button
    Then user click on refresh button
    Then user verified the "Work Placement Outcome" section for below fields
      | Work Placement Outcome Gained | Work Placement Start Date | Work Placement Company | Work Placement Role |
    Then user scroll down "Outcome Type" in page
     Then user validate the "Outcome Type" section for below fields
      | Outcome Type | Opportunity Outcome | Missed Outcome |
    Then user verified the "Next Section" section for below fields
      | Date Expected | Has Resident Achieved? | Further Information | Number of Hours | Date Completed | Add to CV | Evidence | First instance this FY add to Value Insight |
    Then user fill details for "Has Resident Achieved?" as "No"
    Then user validate "Further Information" field is display
    And user click on save and close button
    When user click on "Outcomes" tab
    Then user validates the Outcome "Work Placement" is showing in Outcome grid
    Then user open the Outcome "Work Placement"
    Then user removes "Work Placement Outcome Gained" field data
    Then user updates the "Date Expected" field to past date
    Then user fill details for "Has Resident Achieved?" as "No"
    And user click on save and close button
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Work Placement"
#
  @TC_23328
  Scenario: TC_23328_C11772-  Validation of Volunteering Outcome  - Employment and Training Hub
    Then user fill details for "Outcome Type" as "Volunteering"
    And user click on save button
    Then user click on refresh button
    Then user verified the "Volunteering Outcome" section for below fields
      | Volunteering Outcome Gained | Volunteering Start Date | Volunteering Company | Volunteering Role |
    Then user verified the "Next Section" section for below fields
      | Date Expected | Has Resident Achieved? | Further Information | Number of Hours | Date Completed | Add to CV | Evidence | First instance this FY add to Value Insight |
    Then user fill details for "Has Resident Achieved?" as "No"
    Then user validate "Further Information" field is display
    And user click on save and close button
    When user click on "Outcomes" tab
    Then user validates the Outcome "Volunteering" is showing in Outcome grid
    Then user open the Outcome "Volunteering"
    Then user removes "Volunteering Outcome Gained" field data
    Then user updates the "Date Expected" field to past date
    Then user fill details for "Has Resident Achieved?" as "No"
    And user click on save and close button
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Volunteering"
#
  @TC23330
  Scenario: TC_23330_C11774- Validation of MaD Programme Outcome - Employment and Training Hub
    Then user fill details for "Outcome Type" as "MaD Programme"
    And user click on save button
    Then user click on refresh button
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user fill details for "Has Resident Achieved?" as "No"
    Then user validate "Further Information" field is display
    And user click on save and close button
    When user click on "Outcomes" tab
    Then user validates the Outcome "MaD Programme" is showing in Outcome grid
    Then user open the Outcome "MaD Programme"
    Then user updates the "Date Expected" field to past date
    Then user fill details for "Has Resident Achieved?" as "No"
    And user click on save and close button
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "MaD Programme"
#
  @TC_23331
  Scenario: TC_23331-C11775-Validation of Equipment Grant Outcome - Employment and Training Hub
    Then user select "Outcome Type" as "Equipment Grant"
    Then user verified the "Equipment Grant" section for below fields
      | Type of Equipment | Description | Number of Units | Maximum Number per Customer | Value per Unit | Equipment Grant Awarded | Equipment Date Grant Completed |
    Then user validate the "Outcome Details" section for below fields
      |Date Expected | Has Resident Achieved? |
    Then user verifies the field "Type of Equipment"
      | Laptop | Smart Phone | Desktop | Tablet | Mobile Broadband | Wi-Fi Dongle | PPE | Work Boots | Other |
    Then user validates the field "Description" when "Type of Equipment" is selected as "Other"
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "Equipment Grant" is showing in Outcome grid
    Then user open the Outcome "Equipment Grant"
    Then user removes "Equipment Date Grant Completed" field data
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Equipment Grant"
#
  @TC_23332
  Scenario: TC_23332-C11776-Validation of Financial Grant - Employment and Training
    Then user select "Outcome Type" as "Financial Grant"
    Then user verified the "Financial Grant" section for below fields
      | Type of Funding Applied For | Amount of Grant Available | Amount of Funding Applied For | Grant Category | Type of Grant | Individual Grant Cap | Grant Application Cap | Type of Payment | Brief Description | Grant Awarded | Amount Awarded | Date Grant Completed |
    Then user validate the "Outcome Details" section for below fields
      |Date Expected | Has Resident Achieved? | 
    Then user validates the field "External Funding Provider" when "Type of Funding Applied For" is selected as "External Funding"
    Then user validates the field "Further Information" when "Has Resident Achieved" is selected as "No"
    Then user verifies the field "Type of Funding Applied For"
      | Sovereign Grant | External Funding |
    Then user verifies the field "Grant Category"
      | Money Programme Grant | Digital Programme Grant | E&T Discretionary Grant | E&T Grant Provider | Other |
    Then user verifies the field "Type of Grant"
      | Training Grant | Work Grant |Business Start up/ Enterprise Grant| Childcare Grant | Digital Equipment Grant | White Goods Grant | Fuel Vouchers | ET Financial Support | ET Travel Support | Other |
    Then user verifies the field "Type of Payment"
      | Voucher | Credit Card Payment | External Grant Payment | BACS | Cheque | Other |
    Then user click on "Save & Close"
    When user click on "Outcomes" tab
    Then user validates the Outcome "Financial Grant" is showing in Outcome grid
    Then user open the Outcome "Financial Grant"
    Then user removes "Date Grant Completed" field
    Then user updates the "Date Expected" field to past date
    Then user select "Has Resident Achieved?" as "No"
    Then user click on "Save & Close"
    When user click on "Final Assessment" tab
    Then user validate "Expected Outcomes Not Achieved" grid for "Financial Grant"
