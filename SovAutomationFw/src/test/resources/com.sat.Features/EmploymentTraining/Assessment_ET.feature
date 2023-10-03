@Assessment
Feature: Testing of Assessment in Employment and Training

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"

  @TC_23299
  Scenario: TC_23299-C11758-Validation of creation of New Assessment
    When user click on "Contacts" under Site Map
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Julie Utting" and click on contact name
    Then user click on more tabs
    Then user select Referrals under More Tabs
    Then user click on New Referral
    Then user click on "Save"
    Then user validates "ContactNumber" is mapped from contact as "07856785432"
    Then user enter "Better Work" in "Reason for Referral" text box
    Then user enter "Additional Information" as "Test Additional Information"
    Then user click on "Save"
    Then user click on New Assessment
    Then user validates "Reason for Enrolment" as "Better Work"
    Then user validates "Additional Information" as "Test Additional Information"
    Then user clicks on "More Header Editable Fields"
    Then user will select ETO as "Abdoulie Jeng"
    Then user click on "Save"
    Then user validates "Contact Assessed" is populated as "Julie Utting"
    Then user validates "Person Reference" is mapped from contact as "276801"
    Then user validates "Mobile Phone" is mapped from contact as "07856785432"
    Then user validates "Home Phone" is mapped from contact as "0163537615"
    Then user validates Assessment Title as "Julie Utting ET Assessments"
    Then user clicks on "Press Enter to go back."
    Then user validate Assessment is showing in Assessment Grid

  @TC_23300_23301
  Scenario: TC_23300-C11759-Validation of complete the Triage Assessment
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Julie Utting" and click on contact name
    Then user clicks on "More Tabs"
    Then user select Referrals under More Tabs 
    Then user click on New Referral   
    #Then user select "Referrals"
    #Then user clicks on "New Referral. Add New Referral"
    Then user click on "Save"
    Then user selects "Reason for Referral" as "Better Work"
    Then user enter "Additional Information" as "Test Additional Information"
    Then user click on "Save"
    Then user click on New Assessment
    Then user clicks on "More Header Editable Fields"
    Then user will select ETO as "Abdoulie Jeng"
    Then user click on "Save"
    When user click on "Triage Assessment" tab
    Then user validate the "Contact Information" section for below fields
      | Reason for Enrolment | Source of Referral External | Source of Referral Internal | Safeguarding Statement Read | Demographic Info Captured for ActiveH |
    Then user validate the "Sector Choices" section for below fields
      | Security | Warehouse and Distribution | Childcare | Construction | Customer Services | Distribution/Logistics | Education | Hospitality and Catering | Health and Social Care | Admin | Retail | Tech/ Digital | Self Employment | Other | Contract Type |
    Then user verifies the field "Contract Type"
      | Full Time | Part Time | Home Working | Fixed Term | Permanent | Agency | Temporary | Seasonal |
    Then user validate the "Sensitive Information" section for below fields
      | Is English your First Language | Care Leaver | Lone Parent | Criminal Convictions/Cautions | Vulnerably Housed | Parental Responsibilities/ Childcare | Caring Responsibilities |
    Then user validate the "Rent Account Capture" section for below fields
      | Date of Enrollment | Rent Account Status |
    Then user validate the "Background Information" section for below fields
      | Photo ID? | Driving License | Passport | Provisional Driving License | Other forms of ID? | Birth Certificate | Biometrics Card | Work Permit | References | Bank Account? | Right to Work in UK? | Appropriate Email Address? | Phone Number in Use? | Help with Childcare? | Access to Reliable Transport? |
    Then user validate the "Rent Account Capture" section for below fields
      | Date of Enrollment | Rent Account Status |
    Then user select "Lone Parent" as "Yes"
    Then user validates "Lone Parent Information"
    Then user select "Criminal Convictions/Cautions" as "Yes"
    Then user validates "Criminal Convictions/Cautions Information"
    Then user fills all the fields in Contact Information Section
    Then user fills all the fields in Background Information Section
      | Photo ID? | Driving License | Passport | Provisional Driving License | Other forms of ID? | Birth Certificate | Biometrics Card | Work Permit | References | Bank Account? | Right to Work in UK? | Appropriate Email Address? | Phone Number in Use? | Help with Childcare? | Access to Reliable Transport? |
    Then user fills all the fields in Sector Choices Section
      | Security | Warehouse and Distribution | Childcare | Construction | Customer Services | Distribution/Logistics | Education | Hospitality and Catering | Health and Social Care | Admin | Retail | Tech/ Digital | Self Employment |
    Then user fills all the fields in Sensitive Information Section
      | Is English your First Language | Care Leaver | Lone Parent | Criminal Convictions/Cautions | Vulnerably Housed | Parental Responsibilities/ Childcare | Caring Responsibilities |
    Then user click on "Save"
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user click on contact "Julie Utting"
    Then user verifies Timeline Name as "Triage Assessment for Julie Utting has been completed!" and status as "Closed"
    #Then user validates Owner "D365 Service Account" and Created By as "Maheshwar Poloju"
    Then user navigates to ETO Initial Assessment
    Then user fills all the fields in Service Goals Section
      | Find Work | Access Training | Work Placement | Confidence | Business Start Up |
    Then user fills all the fields in Goal Setting Section
      | What is your goal? | Support for Goal? | Way of Working? | 6 Weeks | 6 Months | 3 Years |
    Then user click on "Save"
    Then user clicks Initial Assessment on BPF
    Then user selects Initial Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Final Assessment on BPF
    Then user selects Final Assessment Complete as "Yes"
    Then user clicks Finish in BPF
    Then user click on contact "Julie Utting"
    Then user verifies Timeline Name as "Final Assessment for Julie Utting has been completed!" and status as "Closed"
    
    
    #Then user validates Owner "D365 Service Account" and Created By as "Thangam K"
    #Then user validate the "Rent Account Capture" section for below fields
      #| Date of Enrollment | Rent Account Status |

  @TC23301_TC23302
  Scenario: TC23301_C11765-Validation of complete the Initial Assessment  - Employment and Training Hub
    When user click on "Assessment" under customer
    #Then user is navigated to "Assessments Active Assessments - Dynamics 365" page
    Then user creates the new contact
    When user click on "Triage Assessment" tab
    Then user fill details for "Driving License" as "Yes"
    And user click on More Header fields icon
    And user fill all the details for "Contact Assessed" as "- Carpenter"
    And user fill all the details for "ETO" as "# adm_aday"
    And user click on save button
    When user click on "ETO Initial Assessment" tab
    #Then user verify "Referral" filed is auto populated
    Then user fill details for "Find Work" as "Yes"
    Then user fill details for "Better Work" as "Yes"
    Then user fill details for "Access Training" as "Yes"
    Then user fill details for "Work Placement" as "Yes"
    Then user fill details for "Confidence" as "Yes"
    Then user fill details for "Business Start Up" as "Yes"
    Then user verify all the "Programme Type" list values
      | ET Standard Offer | Kickstart | Skills for Work |
    Then user fill details for "Programme Type" as "ET Standard Offer"
    Then user verified the "Referral" section for below fields
      | Referral | Programme Type |
    Then user verified the "Service Goals" section for below fields
      | Find Work | Better Work | Access Training | Work Placement | Confidence | Business Start Up |
    Then user scroll down "Referral" in page
    Then user verified the "Goal Setting " section for below fields
      | What is your goal? | Support for Goal? | Way of Working? | Goal: 6 Weeks | Goal: 6 Months | Goal: 3 Years |
    Then user verified the "Health and Wellbeing" section for below fields
      | Help with Learning/Training? | Disability/Health Conditions? | Help with Building Confidence? |
    Then user fill details for "Help with Learning/Training?" as "Yes"
    Then user validate "Learning and Training Information" field is display
    Then user fill details for "Disability/Health Conditions?" as "Yes"
    Then user validate "Disability/ Health Conditions Information" field is display
    Then user fill details for "Help with Building Confidence?" as "Yes"
    Then user validate "Building Confidence Information" field is display
    Then user verified the "Job Searching and Career Development" section for below fields
      | Job Applications | Interviews | IT Training | Functional Skills | Vocational Skills | Volunteering/ Work Placement |
   When user click on "ETO Initial Assessment" tab
    Then user verified the "Benefits" section for below fields
      | Universal Credit | ESA | JSA | DLA | PIP | Income Support | Other - Please Specify |
    Then user verified the "Education and Skills" section for below fields
      | Driving License | CSCS | SIA | DBS |Unique Tax Reference | HGV License | Sentinel Card |
    Then user fill details for "CSCS" as "Yes"
    Then user validate "CSCS Expiry Date" field is display
    Then user fill details for "SIA" as "Yes"
    Then user validate "SIA Expiry Date" field is display
    Then user fill details for "DBS" as "Yes"
    Then user validate "DBS Expiry Date" field is display
    Then user fill details for "Unique Tax Reference" as "Yes"
    Then user validate "UTR Number" field is display
    Then user fill details for "HGV License" as "Yes"
    Then user validate "HGV Expiry Date" field is display
    Then user fill details for "Sentinel Card" as "Yes"
    Then user validate "Sentinel Card Expiry Date" field is display
    Then user verified the "Digital Skills Support Required" section for below fields
      | IT Programmes? | Access to a Device? | Internet Access? | Social Media/ Video Conferencing? | Digital Skills Notes |
    Then user verified the "Money Matters Support Required" section for below fields
      | Help with Money Matters? | Know how much to earn? | Help Financing Tenancy? |
      Then user fill details for "Help with Money Matters?" as "Yes"
    Then user fill details for "Know how much to earn?" as "Yes"
    Then user fill details for "Help Financing Tenancy?" as "Yes"
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
    Then user click on Back button
    Then user clicks Final Assessment on BPF
    Then user selects Final Assessment Complete as "Yes"
    Then user clicks Finish in BPF
    Then user click on contact "- Carpenter"
    Then user verifies Timeline Name as "Final Assessment for Julie Utting has been completed!" and status as "Closed"
    
  