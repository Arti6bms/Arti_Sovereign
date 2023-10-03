@GenericCases @Tenancy
Feature: Testing of Generic Cases in Tenancy Management

  @GenericCasesFunctionality
  Scenario: TC28329_C8811, TC28330_C8812, TC28331_C8813, TC28332_C10724
    #Scenario: TC28329_C8811-Validation of Raising Cases
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user enter all mandatory fields
    And user change risk priority and status
    And user click on save button
    #And user validate case title,owner name and an auto post has been created on the case timeline
    
    @TC28330
    Scenario: TC28330_C8812-Validation of Assigning an existing Case
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    And user select Assign from the top menu option
    Then user validate owner name and assign to me
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "Active Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    ##When user search "Adaptations, Julie Utting, 23 Odiham Drive, Newbury, RG14 1GA, CAS-779862-C9N3Y6" and click on contact name link
    When user click on "Dashboards" under customer
    And user click on Dashboard Drop Down List
    And user select "Activities & Queues" from drop down list
    Then user select any record
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    When user click on "Queues" under customer
    And user click on Drop Down List
    And user select "All Items" from drop down list
    Then user validate case notification in their queue
    #Then user search Case Title and click on contact name link
    
    @TC28331
    Scenario: TC28331_C8813-Validation of Appointments functionality
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
 		When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    Then user clicks on "Save and Close"
    Then user Hover on the first appointment click on the Close Activity(tick mark)
    Then user Select State as "Canceled" and Status "Cancelled by Sovereign" and click on Close Appointment
    And user click on closed appointment record from timeline validates the text
    Then User validates the text "Read-only  This record’s status: Canceled"
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    Then user clicks on "Save and Close"
    Then user Hover on the first appointment click on the Close Activity(tick mark)
   Then user Select State as "Canceled" and Status "Cancelled by Resident" and click on Close Appointment
    And user click on closed appointment record from timeline validates the text
    Then User validates the text "Read-only  This record’s status: Canceled"
   And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    Then user clicks on "Save and Close"
    Then user Hover on the first appointment click on the Close Activity(tick mark)
    Then user Select State as "Canceled" and Status "Non-Access" and click on Close Appointment
    And user click on closed appointment record from timeline validates the text
    Then User validates the text "Read-only  This record’s status: Canceled"
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    Then user clicks on "Save and Close"
    Then user Hover on the first appointment click on the Close Activity(tick mark)
    Then user Select State as "Canceled" and Status "Missed by Sovereign" and click on Close Appointment
    And user click on closed appointment record from timeline validates the text
    Then User validates the text "Read-only  This record’s status: Canceled"
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    Then user clicks on "Save and Close"
    Then user Hover on the first appointment click on the Close Activity(tick mark)
    Then user Select State as "Completed" and click on Close Appointment
    And user click on closed appointment record from timeline validates the text
    Then User validates the text "Read-only  This record’s status: Completed"
    
    
    #Scenario: TC28332_C10724-Validation of Manager Section
    #When user click on "Cases" under customer
    #And user click on Drop Down List
    #And user select "Active Cases" from drop down list
    #Then user search Case Title and click on contact name link
    #When user search "Abandonment, Daniel Whitear, Flat 2 Victoria Court Victoria Road, Torquay, TQ1 1HT, CAS-716595-Q5X1Z3" and click on contact name link
    #Then user scroll down "CASE DETAILS" in page
    #And user clear case monitored and manager
    #And user click on save button
    #And user select case monitored as Yes and enter manager
    #And user click on save button
    #Then user refresh page
    #Then user open activity enter outcome and Complete with the tick mark
    #Then user refresh page
    #Then user scroll down "CASE DETAILS" in page
    #And user verify case monitored as No
    
    
      @US36984 @TC37485
  Scenario: CR36399 of Sprint 14
     Given User navigates to CRM login page
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
    
    @US12162 @TC39554
  Scenario: US12162 of Sprint 15
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
    

    
       
  @US12162 @TC39554
  Scenario: US12162 of Sprint 15
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
  Given User navigates to CRM login page
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

  @US37863 @TC39180
  Scenario: US37863 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
     Then user select Use Saved View field under Advanced Find
     Then user click on Results under Advanced Find
     Then user validate below coloumn names are available
|Case Title|Category (Case Title)|Subcategory (Case Title)|Case Number (Case Title)|Risk Priority|Modified On(Case)|Modified By(case)|Created On (Case Title)|Created By (Case Title)|Owner(Case)|Status (Case Title)|Status Reason (Case Title)|Created On|Created By|

     @US37863 @TC39043
  Scenario: US37863-TC39043 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    Then user clicks "Related" Tab for selecting "CaseItemAudit"

  @US37863 @TC39044
  Scenario: US37863-TC39044 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    Then user clicks on "More Header Editable Fields"
    Then user select "Risk Priority" as "Critical"
    Then user click on "Save"
    Then user read Account Login Name
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - Active Cases"
    Then user click on Results under Advanced Find
    Then user validate the Modified By Case field

  @US37863 @TC39047
  Scenario: US37863-TC39047 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - All Cases"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Case Title | Category (Case Title) | Subcategory (Case Title) | Case Number (Case Title) | Risk Priority | Modified On(Case) | Modified By(case) | Created On (Case Title) | Created By (Case Title) | Owner(Case) | Status (Case Title) | Status Reason (Case Title) | Created On | Created By |

  @US37863 @TC39181
  Scenario: US37863-TC39181 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - Inactive Cases"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Case Title | Category (Case Title) | Subcategory (Case Title) | Case Number (Case Title) | Risk Priority | Modified On(Case) | Modified By(case) | Created On (Case Title) | Created By (Case Title) | Owner (Case Title) | Status (Case Title) | Status Reason (Case Title) | Created On | Created By |

  @US37863 @TC39046
  Scenario: US37863-TC39046 of Sprint 15
     Given User navigates to CRM login page
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

  @US37863 @TC39148
  Scenario: US37863-TC39148 of Sprint 15
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    Then user clicks on "More Header Editable Fields" option
    Then user select "Risk Priority" as "Critical"
    And user click on save button
    When user click on "Summary" tab
    And user click on save button
    Then user validate "Risk Priority" is displayed as "Critical"
    Then user clicks "Related" Tab for selecting "CaseItemAudit"
    Then user validate case record "Case Title" is created under case item audit
    
    
    @TC37794_TC37797
Scenario: CR31393 of Sprint 12
   Given User navigates to CRM login page
When user selects App "Customer Service Hub"
When user click on "Cases" under customer
And user click on Drop Down List
And user select "Active Cases" from drop down list
When user search "ASB, 101 Police, CAS-1051665-J1X9C7" and click on contact name link
When user click on "Triage Assessment" tab
Then user enter value in "Tell us what is going on" text field
Then user click on save button


  @TC_37640
  Scenario: CR31391 of Sprint 12
     Given User navigates to CRM login page
When user selects App "Customer Service Hub"
When user click on "Cases" under customer
And user click on Drop Down List
And user select "All Cases" from drop down list
When user search "ASB, 101 Police, CAS-1051665-J1X9C7" and click on contact name link
When user click on "Action Plan" tab
Then user validate the "Action Plan Customer Requirements" section for below fields
| Contact Other Agencies | Check Website | Speak To Neighbour | Encourage Other Witness |
Then user verifies "Contact Other Agencies" list values
| Police | Social Services | Mental Health Team | GP | Other Medical Professional | Probation | Local Authority |
Then user select "Select all" options in "Contact Other Agencies" field


@CR_33989 @TC_40008
Scenario: CR_33989
   Given User navigates to CRM login page
When user selects App "Customer Service Hub"
 When user click on "Cases" under customer
 And user click on Drop Down List
 And user select "Active Cases" from drop down list
 When user search ", Rebecca Hudson, 4 Jellicoe Close, Ryde, PO33 3FB, CAS-963280-P2W3N7" and click on contact name link
 And user select Assign from the top menu option
 Then user clicks on Assign button
 Then user validate "Owner" as "TK"
 Then user open created task
 Then user verify the Queue Item Details as Customer Contact Admin
 Then user verify the Owner as "Customer Contact Admin"

@CR_33989 @TC_40010
Scenario: CR33989
   Given User navigates to CRM login page
	When user selects App "Customer Service Hub" 
	When user click on "Cases" under customer
	And user click on Drop Down List
	And user select "Active Cases" from drop down list
	When user search ", Rebecca Hudson, 4 Jellicoe Close, Ryde, PO33 3FB, CAS-963280-P2W3N7" and click on contact name link
 And user click on plus icon on the timeline
 And user select "Task" from timeline option
 Then user enter Response Time and Description
 And user Click on save and close
 Then user open your phone call activity and clicking on Mark Complete with the tick mark
 Then user click on refresh button
 Then user open created task
 Then user clicks on Queue Item Details link
 Then user verifies the closed task "CAS-963280-P2W3N7, undefined, Rebecca Hudson, 4 Jellicoe Close, Ryde, PO33 3FB" is does not exist in Queue items

@CR_33989 @TC34721_TC34719_TC34707_TC34723_TC34722_TC34709_TC34720_TC34435
Scenario Outline: CR33989
Given User navigates to CRM login page
When user selects App "<Hub>"
When user click on "Activities" under Site Map
Then user clicks "Task"
Then user navigates to "Task for Interactive experience" form
Then user click on "Discard changes" button
Then user validate "Queue Item Details" field is display
Then user clicks on "More Header Editable Fields"
Then user validates "Queue Item Details"
Then user validates "Modified By"
Then user validates "Owner"
Then user validates "Activity Status"

Examples:
   | Hub |
| Customer Service Hub |
| Sales Hub |
| Resales |
| Employment and Training |

@CR40046 @TC43034
  Scenario: CR40046-TC43034 of Sprint 19
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
     Given User navigates to CRM login page
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
    
    
     @CR43274 @TC42735
  Scenario: CR43274-TCTC42735 of Sprint 20
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Building (Dwelling)"
    And user fill all the details for "Subcategory" as "Retrofit"
    Then user verifies "Case Closure Reason" list values
      | Customer Refusal | Works Completed | None Access | Property not suitable | Refused at design | Refused post survey | Tenancy Ended | Works ended by Contractor | Works ended by customer |

  @CR44715
  @TC45577_TC45575_TC45589_TC45576_TC45584_TC45687
  Scenario Outline: CR44715 Validate 'Customer Specialist - Home Ownership' queue is set as default queue for 'Customer Specialist - Home Ownership' team.
  Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  When user click on "Cases" under customer
  And user click on New Cases
  Then user fill all the details for "Customer" as "<CustomerName>"
  And user fill all the details for "Category" as "Enforcement (legal)"
  And user fill all the details for "Subcategory" as "Breach of Lease"
  Then user verifies "Case Closure Reason" list values
      | Action taken | Action withdrawn | Breach remedied | 
  And user enters description
  And user click on save button
  Then user validate case Owner as "Customer Specialist - Home Ownership"
  Then user clicks on "Customer Specialist - Home Ownership"
  Then user validate default queue name as "<Customer Specialist - Home Ownership>"
  
  Examples:
  | CustomerName |
  | Anthony Hudd |
  | Tina King    |
  
  @US44680 @TC45565 @TC45556 @TC45533 @TC45538 @TC45542
  Scenario: US44680 of Sprint 21
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user verify all the lookup values in "Category"
      | Home Ownership |
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Home Ownership"
    Then user fill all the details for "Subcategory" as "Equity loan remortgage"
    Then user verify all the lookup values in "Case Closure Reason"
      | Approved | Completed | Declined | Refused | Withdrawn |
    Then user enters description
    And user click on save button
    Then user validate Case Owner as "Customer Specialist - Home Ownership"
    And user click on "Customer Specialist - Home Ownership"
    Then user validate default queue as "Customer Specialist - Home Ownership"

  @US44680 @TC45541 @TC45543 @TC45544 @TC45548 @TC45547 @TC45549 @TC45550 @45551 @TC45552 @TC45553 @TC45554 @TC45534 @TC45559
  Scenario Outline: US44680 of Sprint 21
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user verify all the lookup values in "Category"
      | Home Ownership |   
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Home Ownership"
    Then user verify all the lookup values in "Subcategory"   
      |Enfranchisement|Equity loan remortgage|Equity loan settlement|Home Ownership general|Lease extension|Lease variation|Notices and certificates|Repurchase/reverse staircasing request|Right to Manage|Section 20|SO – joint/sole to sole/joint|SO Remortgage|Solicitor sales enquiries|
    Then user verify all the lookup values in "Case Closure Reason"
      | Approved | Completed | Declined | Refused | Withdrawn |

    Examples: 
      | Subcategory            |
      | Equity loan settlement |
      | Home Ownership general |
      | Lease extension        |
      | Lease variation        |
      |Notices and certificates|
      |Repurchase/reverse staircasing request|
      |Right to Manage|
      |Section 20|
      |SO – joint/sole to sole/joint|
      |SO Remortgage|
      |Solicitor sales enquiries|

@US44680 @TC45686
  Scenario: US44680 of Sprint 21
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user verify all the lookup values in "Category"
      | Home Ownership |
    Then user fill all the details for "Customer" as "Tina King"
    Then user fill all the details for "Category" as "Home Ownership"
    Then user fill all the details for "Subcategory" as "Equity loan remortgage"
    Then user enters description
    And user click on save button
    Then user validate Case Owner as "Customer Specialist - Home Ownership"
    And user click on "Customer Specialist - Home Ownership"
    Then user validate default queue as "Customer Specialist - Home Ownership"
    
    
    @US34001
  Scenario: Us -34001
    #East Admin Tenancy
        Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer    
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Housing Management"
    Then user fill details for "Task Sub-Category" as "Housing Admin"
    Then user enter Response Time and Description
    And user click on save button
    Then user validate case Owner as "East Admin Tenancy"
    #West Admin Tenancy
    When user click on "Contacts" under customer    
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Amanda Batchelor" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Housing Management"
    Then user fill details for "Task Sub-Category" as "Housing Admin"
    Then user enter Response Time and Description
    And user click on save button
    Then user validate case Owner as "West Admin Tenancy"
    #South Admin Tenancy
    When user click on "Contacts" under customer    
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Liam Donald" and click on contact name link
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Housing Management"
    Then user fill details for "Task Sub-Category" as "Housing Admin"
    Then user enter Response Time and Description
    And user click on save button
    Then user validate case Owner as "South Admin Tenancy"

  @US33983
  Scenario: Us -33983
      Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Compliance"
    And user fill all the details for "Subcategory" as "PEEPs"
    Then user verify "PEEPs Type" filed is mandatory
    Then user fill details for "PEEPs Type" as "Supported"
    And user enters description
    And user click on save button
    Then user verify "PEEPs Type" filed is Locked
    Then user verify all the "PEEPs Type" list values
      | Supported | Housing for Older People | General Needs | Homeownership | Guest Room |

  @US22309
  Scenario: Us -22309
      Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Tenancy"
    And user fill all the details for "Subcategory" as "Joint to Sole (Tenancy Change)"
    And user enters description
    And user click on save button
    Then user validate Originating Neighbourhood fields is auto populated
    
     @US22301
  Scenario: Us -22301
        Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user verify all the "Assisted Gardening Case Types" list values
      | Vulnerability | Financial | Disability | No Support | Awaiting Move(BAP/Downsizing) | Other |

  @US22302
  Scenario: Us -22302
        Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Tom Sproule"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user verify all the lookup values in "Case Closure Reason"
      | Accepted | Refused | Not Accepted - Open up a Garden Condition Case |
    And user fill all the details for "Case Closure Reason" as "Accepeted"
    Then user enters description
    And user click on save button
    Then user verify the Owner as "East Admin Tenancy"
    And user click on save and close button
    And user click on New Cases
    Then user fill all the details for "Customer" as "Liam Donnelly"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    And user fill all the details for "Case Closure Reason" as "Accepeted"
    Then user enters description
    And user click on save button
    Then user verify the Owner as "West Admin Tenancy"
    And user click on save and close button
    And user click on New Cases
    Then user fill all the details for "Customer" as "Liam Donald"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    And user fill all the details for "Case Closure Reason" as "Accepeted"
    Then user enters description
    And user click on save button
    Then user verify the Owner as "South Admin Tenancy"
    And user click on save and close button

  @US27111
  Scenario: Us -27111
        Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
  
  
   @TC23298_TC28305_TC22946_TC22874_TC33720
  Scenario Outline: Validation of Creation of an Email 
  Given User navigates to CRM login page
  	When user selects App "<Hub>"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Julie Utting" and click on contact name
    And user click on plus icon on the timeline
    And user select "E-mail" from timeline option
    Then user verify all the "Recipient Type(To)" list values
     |Account|Contact|User (Staff)|Queue|
    Then user verifies "Recipient Type(To)" field with Default as "Contact"
    Then user selects "Account" in field "Recipient Type(To)"
    Then user validate the Alert message "Please ensure that you are sending and copying this email to the correct recipients"
    Then user verify all the "Recipient Type(Cc & Bcc)" list values
     |Account|Contact|User (Staff)|Queue|
    Then user verifies "Recipient Type(Cc & Bcc)" field with Default as "User (Staff)"
    Then user selects "Contact" in field "Recipient Type(Cc & Bcc)"
    Then user validate the Alert message "Please ensure that you are sending and copying this email to the correct recipients"
    And user click on save button
    Then user fill all the details for "Cc" as "Jerrilee Shepherd"
    Then user fill all the details for "Bcc" as "Anthony Hudd"
    Then user enter Subject
    And user click on save button
    Then user click on "Send" button
    
    Examples: 
      | Hub                     |
      | Customer Service Hub    |
      | Employment and Training |
      | Resales                 |
      | Sales Hub               |
    
    @CR31385 @Sprint13
  Scenario: CR31385 of Sprint 10
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user click on save button
    Then user validates "Agreed Actions" Question contains "Refer to Coaching (HO/ASBO)"
    
    
    @CR14171 @Sprint13
  Scenario Outline: TC33088_TC34655_TC34657_TC34653_TC34651_TC34656_TC34658 of Sprint 11
  Given User navigates to CRM login page
    When user selects App "<Hub>"
    When user click on "Contacts" under customer
    Then user navigate to "Active Contacts" view
    Then user select one of active Contact
    Then user enter the Mobile Phone which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the Mobile Phone starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid Mobile Phone starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"
    Then user enter the Mobile Phone 2 which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the Mobile Phone 2 starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid Mobile Phone 2 starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"

    Examples: 
      | Hub                     |
      | Employment and Training |
      | Customer Service Hub    |
      | Resales                 |
      
          @TC35882_TC35883 @CR_33989
Scenario Outline: TC35882_TC35883 CR33989 Validate Value is Populated in Queue Items Details field on Task form when Task is Created of Customer service and Resale hub
Given User navigates to CRM login page
When user selects App "<Hub>"
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
When user search "Jerrilee Shepherd" and click on contact name link
And user click on plus icon on the timeline
And user select "Task" from timeline option
Then user enter Response Time and Description
And user click on save button
Then user verify the Queue Item Details as Customer Contact Admin

Examples:
| Hub|
| Customer Service Hub |
| Resales |

 @CR38075 @Sprint13
  Scenario Outline: TC38459_TC38460_TC38461_TC38462_TC38463_TC38464 of Sprint 13
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "<CustomerName>"
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Customer Refusal"
    Then user verify all the lookup values in "Case Closure Reason"
      | Deferred – to next financial year | Refused – Asset still in good condition | Refused – Illegitimate reason | Refused – Legitimate reason | Sovereign Refusal | Upgrade Completed |
    Then user select "Customer Refusal Type" as "Doors"
    Then user enters description
    And user click on save button
    Then user validate "Owner" as "<OwnerFieldname>"

    Examples: 
      | CustomerName | OwnerFieldname      |
      | Tom Sproule  | East Admin Tenancy  |
      | Martin Bell  | West Admin Tenancy  |
      | Liam Donald  | South Admin Tenancy |
      | Laura Trim   | East Admin Tenancy  |

  @US38074 @Sprint13
  Scenario Outline: TC38470_TC38471_TC38473 of Sprint 12
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "<CustomerName>"
    And user will select Category as "Customer"
    Then user verify all the lookup values in Subcategory
      | Customer Refusal |
    Then user enters description
    And user click on save button
    Then user validate Subcategory field is mandatory
    And user fill all the details for "Subcategory" as "Customer Refusal"
    Then user verifies the field "Customer Refusal Type"
      | Bathroom | Doors | Heating upgrade | Kitchen | Windows |
    Then user verify all the lookup values in "Case Closure Reason"
      | Deferred – to next financial year | Refused – Asset still in good condition | Refused – Illegitimate reason | Refused – Legitimate reason | Sovereign Refusal | Upgrade Completed |
    And user click on save button
    Then user validate "Customer Refusal" case

    Examples: 
      | CustomerName | OwnerFieldname     |
      | Tom Sproule  | East Admin Tenancy |