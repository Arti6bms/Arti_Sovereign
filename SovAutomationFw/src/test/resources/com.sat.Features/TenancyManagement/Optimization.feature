@OPT
@Tenancy
Feature: Testing of Optimization

  @Optimization
  @TC_34552_TC_34555_29517_29526_29523_34560_29512_29513_32268_29516_29520_29527_32326_38791_38792_38793_40043
  @CR45335 @TC_46517_TC_46519_TC_46520_TC_46522_TC_46523_TC_46524
  Scenario: TC_34552_TC_34555_29517_29526_29523_34560 : Validation of Action Plan Form on ASB Case - ASB Incident and Action
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    And user enters description
    And user click on save button
    When user click on "Triage Assessment" tab
    #Then user verifies the tool tip for "Triage Assessment Questions"
    #Then user verifies the questions in "Triage Assessment Questions" section
      #| Questions                                        |
      #| Q1. Tell us what is going on?                    |
      #| Q2. Who's Involved?                              |
      #| Q3. When Did it Start?                           |
      #| Q4. How often is this happening?                 |
      #| Q5. Can you think why this is happening          |
      #| Q6. Is this a protected characteristic?          |
      #| Q7. Who's been affected by this                  |
      #| Q8. Do you have any support needs?               |
      #| Q9. Have you called us before about this?        |
      #| Q11. What do you think will sort the problem     |
      #| Q12. Agreed Actions                              |
      #| Q13. Safeguarding Referral to be considered      |
      #| Q14. DA Referral made                            |
      #| Q15. Customer have additional needs to consider? |
    #Then user verifies "Triage Assessment Score and Outcome" section
      #| FieldName     |
      #| TA Score      |
      #| Response Time |
    #Then user verifies "Q4. How often is this happening?" list values
      #| Only Once | Daily | Mosst Days | Most Weeks | Most Months |
    #Then user verifies "Q10. What have you tried before calling us?" list values
      #| Select all | Addressed this with Neighbour | Checked our website | Contacted Local Authority | Contacted Police | Contacted other Agencies | None |
    #Then user verifies "Q12. Agreed Actions" list values
      #| Select all | Signpost to agency and close case | Refer to Mediation and close case | Application to living together fund (HO/ASBO) | Refer to CBT (HO/ASBO) |
    #Then user verifies "Q15a Does the Customer have Additional Needs" list values
      #| Select all | Multiple Existing Cases | Mental Health | GP Support | Social Services |
    #Then user verifies "Response Time" list values
      #| Urgent | Routine | ASB Priority 1 | ASB Priority 2 | ASB Priority 3 | Safeguarding Priority 1 | Safeguarding Priority 2 |
    #Then user verifies "Select Characteristic" list values
      #| Sex | Sexual Orientation | Disability | Age | Gender | Reassignment | Marriage and civil partnership | Race | Religion or Belief |
    #Then user verifies "If none, any reason why Free Text box is displayed."
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user verifies "Triage Assessment" BPF Stage has "Triage Assessment Complete" field with Default as No
    Then user verifies "Action Plan" BPF Stage has "Action Plan Generated" field with Default as No
    Then user verifies "Case Story" BPF Stage has "Case Story Generated" field with Default as No
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user navigate to ASB Incident Grid and enter the details in ASB Incident form and click on save and close button
      | Name | Regarding |
      | Max | Testera   |
      | John  | Testera   |
    #Then user validate more than one ASB Incident can be added to the Grid
    Then user validate Active and Inactive Records are Displayed in ASB Incident grid
    Then user validate "Action Plan" tab
    Then user verifies "Action Plan" list values
      | Action Plan Sovereign Requirements | Action Plan Customer Requirements | Action | ASB Incident |
    And user clicks on "More commands for Action"
     Then user click on "New Action"
    #Then user Navigate to Action Plan and Click on +New Action button
    Then Validate the Action Plan Quick Create form for below fields
      | Action | Owner | Contact | By When | Date Completed | Regarding | Description | Timeline |
    Then user clicks on Back button
    Then user navigate to Action Grid and enter the details in Action Plan form and click on save and verifies description and close button
      | Action  |
      | Action1 |
      | Action2 |
    Then user validate more than one Action can be added to the Grid
    Then user validate Records are displayed from Newest to Oldest order in Action Plan grid of Case
    Then user validate Active and Inactive Records are Displayed in Action Plan grid
    Then user validate the "Action Plan Sovereign Requirements" section for below fields
      | Owner | Contact Preference | Contact Time | Contact Timescale |
    Then user validate the "Action Plan Customer Requirements" section for below fields
      | Contact Other Agencies | Check Website | Speak To Neighbour | Encourage Other Witness |
    Then user validate the "Action" grid for below fields
      | Action | By Who | By When | Date Completed |
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user validate "Case Story" tab
    Then user verifies "Case Story Option" field exists
    Then user verifies "Case Story Option" list values
      | ABA | Banding Assessment Panel | Coaching/CBT referral | Committal application (ASB Breach) | Community Protection Notice | Community Protection Warning | Community Trigger/ASB Case Review | Criminal Behaviour Order | Demoted Tenancy | Dog Control Order  | Final warning | Full Closure | Initial Visit (LO or ASBO) | Injunction | Internal Transfer | Noise Abatement Order | NOSP served | NTQ served | Partial Closure | Property Abandoned | Referral to Safe Partnerships | Section 21 Served | Signposted to Mental Health team | Signposted to Police | Signposted to Social Services | Solicitors Letter | SPO granted | Tenancy caution | Tenant ended tenancy | Undertaking | Eviction (Discretionary) | Eviction (Mandatory Ground) | informal mediation (officer) | Injunction with power of arrest | Mediation assessment referral | Mediation complete | Mediation referral | Referral to drug and alcohol services | Signposted to external agency | words of advice |
     Then user select "Select all" Option in "Case Story Option" field and verifies All Selected Options are visible
    Then user fills the Case Story options date fields
    Then user deselect "Select all" Option in "Case Story Option" field and verifies All deselected Options are invisible
    And user click on save button
  
   
   
   
    #Then user verifies ASB Case form Contain Stages as mentioned below
      #| Assessment Process Flow | Triage Assessment | Action Plan | Case Story |     
      #
    #Then user click on "Action Plan" tab
    #Then user click on More commands for Case button
    #When user click on "Summary" tab
    #And user click on save button
    #Then user clicks on Customer field
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag
    # change the form here
    #Then user clicks on Account field
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag
    #When user click on "Household Group Information" tab
    #Then user clicks on HOUSEHOLD GROUP CONTACT
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag
    #Then user clicks on Back button
    #Then user clicks on Back button
    #Then user clicks on Back button
    #When user click on "Summary" tab
    #Then user click on More commands for Case button
    #Then user click on "Resolve Case"
    #Then user enters the details for "Resolution" as "Test"
    #Then user click on "Resolve" button
    #When user click on "Summary" tab
    #Then user clicks on Customer field
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag after case is resolved
    #Then user clicks on Account field
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag after case is resolved
    #When user click on "Household Group Information" tab
    #Then user clicks on HOUSEHOLD GROUP CONTACT
    #Then user verifies the "ASB" flag exists
    #Then user verifies the Tool Tip of "ASB" flag after case is resolved
    
    
    @TC38958_TC38959_TC38963_TC38964_TC37543
    Scenario: US24566 Validate Assisted Gardening Flag tooltip is Displayed 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Aidan Doman"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    Then user verifies "Assisted Gardening Case Types" field exists
    Then user verify all the "Assisted Gardening Case Types" list values
      | Awaiting Move (BAP / Downsizing) | Disability | Financial | No Support | Other | Vulnerability |
    And user click on save button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag
    When user click on "Household Group Information" tab
    Then user clicks on HOUSEHOLD GROUP CONTACT
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag
    Then user clicks on Back button
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
    
    @TC38960_TC38962
    Scenario: US24566 TC38960_TC38962
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "James Green"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "Assisted Gardening" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag does not exist
    
    @TC41249_TC41250
    Scenario: US24566 TC41249_TC41250 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Zuri Audi"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Delete"
    Then user click on "Delete" button
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Zuri Audi" and click on contact name
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
    
    @TC41247_TC41248
    Scenario: US24566 TC41247_TC41248
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Bone"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Delete"
    Then user click on "Delete" button
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "A Bone" and click on contact name
    Then user click on refresh button
    Then user verifies the "Assisted Gardening" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag does not exist
    
    @TC41220_TC41225
    Scenario: US24566 TC41220_TC41225
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "John Toms"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Cancel Case"
    Then user click on "Confirm" button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
     Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag exists
    Then user verifies the Tool Tip of "Assisted Gardening" flag does not exist
    
    @TC41216_TC38961
    Scenario: US24566 TC41216_TC38961
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Bailey"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Cancel Case"
    Then user click on "Confirm" button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "Assisted Gardening" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Assisted Gardening" flag does not exist
    
    @TC43309_TC43311_TC43315_TC43336_TC43337_TC28335
    Scenario: CR43137 Validate HOP Case is Created Successfully
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Bailey"
    And user fill all the details for "Category" as "Housing for Older People"
    And user fill all the details for "Subcategory" as "Pull Cord Testing"
    Then user enters description
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "High"
    And user click on save button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    Then user clicks on Account field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    Then user clicks on Back button
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag does not exist
    Then user clicks on Account field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag does not exist
    
    @TC43326_TC43328_TC43338_TC43339
    Scenario: CR43137 TC43326_TC43328
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "James Green"
    And user fill all the details for "Category" as "Housing for Older People"
    And user fill all the details for "Subcategory" as "Rapid Resolution"
    Then user enters description
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "High"
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "HOP" flag does not exist
    Then user clicks on Account field
    Then user verifies the "HOP" flag does not exist
    Then user clicks on Back button
    Then user clicks on Back button
    Then user click on "Reactivate Case"
    Then user click on "Reactivate" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    Then user clicks on Account field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    
    @TC43343_TC43344_TC43346_TC43347
    Scenario: CR43137 TC43344_TC43347 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Zuri Audi"
    And user fill all the details for "Category" as "Housing for Older People"
    And user fill all the details for "Subcategory" as "Rapid Resolution"
    Then user enters description
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "High"
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Delete"
    Then user click on "Delete" button
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Zuri Audi" and click on contact name
    Then user verifies the "HOP" flag does not exist
    Then user verifies the Tool Tip of "HOP" flag does not exist
    Then user clicks on Account field
    Then user verifies the "HOP" flag does not exist
    Then user verifies the Tool Tip of "HOP" flag does not exist
    
    @TC43340_TC43341_TC43342_TC43345_TC43348_TC43349
    Scenario: CR43137 TC43340_TC43341_TC43342_TC43345
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Barry"
    And user fill all the details for "Category" as "Housing for Older People"
    And user fill all the details for "Subcategory" as "Rapid Resolution"
    Then user enters description
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "High"
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Cancel Case"
    Then user click on "Confirm" button
    Then user click on "OK" button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "HOP" flag does not exist
    Then user verifies the Tool Tip of "HOP" flag does not exist
    Then user clicks on Account field
    Then user verifies the "HOP" flag does not exist
    Then user verifies the Tool Tip of "HOP" flag does not exist
    Then user clicks on Back button
    Then user clicks on Back button
    Then user click on "Reactivate Case"
    Then user click on "Reactivate" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    Then user clicks on Account field
    Then user verifies the "HOP" flag exists
    Then user verifies the Tool Tip of "HOP" flag
    
    
    @TC44553_TC44560_TC44563_TC44556_TC44559
    Scenario: US43566 Validate Retrofit Case Flag 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Bailey"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user enters description
    And user click on save button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    Then user clicks on Back button
    Then user clicks on Back button
    When user click on "Summary" tab
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    
    @TC44569_TC44572
    Scenario: US43566 Validate Retrofit flag of Reactivate case
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "James Green"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on refresh button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "Retrofit" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag does not exist
    Then user clicks on Back button
    Then user clicks on Back button
    Then user click on "Reactivate Case"
    Then user click on "Reactivate" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    
    @TC44567_TC44565
    Scenario: US43566 Validate Retrofit flag for Deleted case
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Zuri Audi"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Delete"
    Then user click on "Delete" button
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Zuri Audi" and click on contact name
    Then user verifies the "Retrofit" flag does not exist
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag does not exist
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    
    @TC44573_TC44570_TC44574_TC44576
    Scenario: US43566 Validate Retrofit flag for Cancelled case 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "A Barry"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user enters description
    And user click on save button
    Then user click on More commands for Case button
    Then user click on "Cancel Case"
    Then user click on "Confirm" button
    Then user click on "OK" button
    Then user click on refresh button 
    Then user clicks on Customer field
    Then user verifies the "Retrofit" flag does not exist
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag does not exist
    Then user verifies the Tool Tip of "Retrofit" flag does not exist
    Then user clicks on Back button
    Then user clicks on Back button
    Then user click on "Reactivate Case"
    Then user click on "Reactivate" button
    Then user click on refresh button
    Then user clicks on Customer field
    Then user click on refresh button
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    Then user clicks on Account field
    Then user verifies the "Retrofit" flag exists
    Then user verifies the Tool Tip of "Retrofit" flag
    
    @CR31385 @Sprint13
  	Scenario: CR31385 of Sprint 10
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    Then user validates "Agreed Actions" Question contains "Refer to Coaching (HO/ASBO)"
    
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
    Then user select "Select all" options in "Contact Other Agencies" field
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

  
  @CR36399 @TC37628 @CR45320 @TC_46505_TC_46507_TC_46508_TC_46510_TC_46512_TC_46514
  @CR45338 @TC_46496_TC_46497_TC_46501_TC_46502_TC_46503
  @CR45339 @TC_46504_TC_46506_TC_46509_TC_46511_TC_46513_TC_46521_TC_46515_TC_46516_TC_46518
  Scenario: CR36399 of Sprint 14
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    #ASB New changes
     Then user verify all the lookup values in "Case Closure Reason"
      | Non Engagement | Not ASB (on investigation) | Perp/Victim relocated | Resolved assertive intervention (non legal) | Resolved Early intervention | Resolved legal intervention | 
      Then user verifies "Case Closure Reason" does not contains the below list
      |Court Order Complied | Deceased | Early Intervention | Existing Case in Inprogress | Full Closure | Injunction Complied | Mediation | Partial Closure Order | Signposted to Other agenecies | Tenant Eviction | undertaking? |
      And user fill all the details for "Case Closure Reason" as "Non Engagement"
      And user enters description
	    Then user fill details for "Customer Survey" as "No"
	    Then user validate "Customer Survey Case Category" field is display
	    Then user verify all the "Customer Survey Case Category" list values
      | Domestic Abuse | Mental Health | Not ASB | Both are Perpetrators | Non-engagement by customer |
      Then user fill details for "Customer Survey Case Category" as "Domestic Abuse"
      Then user validate "Exclusion Reasons - Domestic Abuse" field is display
      Then user verify all the "Exclusion Reasons - Domestic Abuse" list values
      | If the CSAT call will have a detrimental impact on personal wellbeing | If the CSAT call could put them at personal risk/danger | If the customer wishes expressly NOT to be surveyed |
      Then user fill details for "Customer Survey Case Category" as "--Select--"
      Then Validate the fields have been hidden from the case form
      | Exclusion Reasons - Domestic Abuse | Exclusion Reasons - Mental Health | Exclusion Reasons - Not ASB | Exclusion Reasons - Both Are Perpetrators | Exclusion Reasons - Non-engagement by customer |
      Then user fill details for "Customer Survey Case Category" as "Mental Health"
	    Then user validate "Exclusion Reasons - Mental Health" field is display
	    Then user verify all the "Exclusion Reasons - Mental Health" list values
	    | If the CSAT will have a detrimental impact on personal wellbeing | If the customer explicitly wishes NOT to be surveyed |
	    Then user verifies "Exclusion Reasons - Mental Health" field does not contains the below list
	    | If the CSAT call could put them at personal risk/danger |
	    Then user fill details for "Customer Survey Case Category" as "Not ASB"
	    Then user validate "Exclusion Reasons - Not ASB" field is display
	    Then user verify all the "Exclusion Reasons - Not ASB" list values
	    | Case was opened in Error | Case was re-opened for data cleansing | Upon investigation not to be ASB |
	    Then user verifies "Exclusion Reasons - Not ASB" field does not contains the below list
	    | There is non-engagement by the customer(s) |
	    Then user fill details for "Customer Survey Case Category" as "Both are Perpetrators"
	    Then user validate "Exclusion Reasons - Both Are Perpetrators" field is display
	    Then user verify all the "Exclusion Reasons - Both Are Perpetrators" list values
	    | Evidence supports both parties are perpetrators |
	    Then user fill details for "Customer Survey Case Category" as "Non-engagement by customer"
	    Then user validate "Exclusion Reasons - Non-engagement by customer" field is display
	    Then user verify all the "Exclusion Reasons - Non-engagement by customer" list values
	    | customer request for NFA | numerous attempts no further contact from customer |
	    Then user fill details for "Exclusion Reasons - Non-engagement by customer" as "customer request for NFA"
	    And user click on save button
	   
	     #ASB New changes done
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    And user click on save button
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user verifies "Contact Other Agencies" list values
    | Police Contact | Social Care | Community Mental Health Team | GP | Other Medical Professional | ProbationProbation | Local Authority | EWO (Educational welfare officer) | Probation i.e. other agencies EH | Support Workers | 
    Then user select "Social Care" options in "Contact Other Agencies" field
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
   