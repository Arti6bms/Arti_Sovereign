@Complaints
Feature: Testing of Compliants

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"

  @TC_33633
  Scenario: TC_33633
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 1"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 1 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user check Stage 1 Complaint Acknowledged field
    Then user click on "Save"
    Then user validate the case title
      | Complaints | Jerrilee Shepherd, Flat 25 Odiham Drive, Newbury, RG14 1GA |
    Then user validate locked field
      | Region |
    Then user validate the Timeline for case email customer confirmation

  #validate stage1 field is autopopulate
  @TC_33707
  Scenario: TC_33707
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 2"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user check Stage 2 Complaint Acknowledged field
    Then user click on "Save"
    Then user validate the case title
      | Complaints | Jerrilee Shepherd, Flat 25 Odiham Drive, Newbury, RG14 1GA |
    Then user validate the Timeline for case email customer confirmation

  #validate stage2 field is autopopulate
  @TC_33945
  Scenario: TC_33945
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 1"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 1 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user validate the Alert message "Please update the Complaints Status before Closing"
    Then user select "Complaints Status" as "Suspended"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user validate the Timeline for resolved case email customer confirmation

  @TC_33975
  Scenario: TC_33975
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 2"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user validate the Alert message "Please update the Complaints Status before Closing"
    Then user select "Complaints Status" as "Suspended"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on "Resolve Case"
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user validate the Timeline for resolved case email customer confirmation

  @TC_33708
  Scenario: TC_33708
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Data request received"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user check Stage 2 Complaint Acknowledged field
    Then user click on "Save"
    Then user validate the case title
      | Complaints | Jerrilee Shepherd, Flat 25 Odiham Drive, Newbury, RG14 1GA |
    Then user validate the Timeline for case email customer confirmation

  #validate stage2 field is autopopulate
  @TC_33985
  Scenario: TC_33985
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Suspended"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Data request received"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user validate the Timeline for resolved case email customer confirmation

  @TC_33995
  Scenario: TC_33995
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 1"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 1 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user validate the Alert message "Please update the Complaints Status before Closing"
    Then user select "Complaints Status" as "Suspended"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user validate the Timeline for resolved case email customer confirmation
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate Complaints Stage field is set to "Stage 2"
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    Then user check Stage 2 Complaint Acknowledged field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate Complaints Stage field is set to ""
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Data request received"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate Complaints Stage field is set to "Formal Housing Ombudsman - Data request received"
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Pending outcome"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate Complaints Stage field is set to "Formal Housing Ombudsman - Pending outcome"
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Outcome received"
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user enters the details for "Resolution" as "Test"
    Then user click on "Resolve" button
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate Complaints Stage field is set to "Formal Housing Ombudsman - Outcome received"

    @TC_34014
    @1
 	Scenario: TC_34014
 	When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Open"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 1"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    #Then user validates below checkbox fields exists
    #| Contractor Complaint | Received by CEO or Exec board level | Received by MP |  | Informal Ombudsman Complaint | Formal Ombudsman Complaint | First Time Resolution |
    And user fill all the details for Stage 1 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "Cancel Case"
    Then user click on "Confirm" button
    #Then user validate the message "Read-only This record’s status: Canceled"
    Then user click on Reactivate Case
    Then user click on "Reactivate" button
    Then user validate the Timeline for resolved case email customer confirmation
    
    @TC_28342
 	Scenario: TC_28342
 	When user click on "Cases" under customer
 	And user click on Drop Down List
    And user select "All Cases" from drop down list
    
    @TC41118_TC41119_TC41120_TC32592
    Scenario: CR40098
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user verify all the "Complaints Status" list values
     |Closed Pending - Responded|Closed - Upheld|Closed - Not Upheld|Closed - Partially Upheld|Cancelled|Closed Pending - Other|Open|Suspended|Closed - Housing Ombudsman - Upheld|Closed - Housing Ombudsman - Not Upheld|Closed - Housing Ombudsman - Partially Upheld|Closed - Housing Ombudsman - Outside Jurisdiction|
    Then user select "Complaints Status" as "Closed Pending - Responded"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Stage 1"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
     And user fill all the details for Stage 1 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user validate the Alert message "Please update the Complaints Status before Closing"
    
    @TC_32596
    Scenario: TC_32596 CR40098
    When user click on "Cases" under customer
    And user click on New Cases
    Then user navigates to "Complaints Case Form" form
    And user enters description
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Complaints"
    And user enter the details for Subcategory as "Complaints"
    Then user select "Complaints Status" as "Closed Pending - Other"
    Then user select "Complaint Pending Reason" as "Pending Service"
    Then user select "Complaint Priority" as "Low"
    Then user select "Complaint Complexity" as "1-Simple"
    Then user select "Complaint Tier" as "Tier 1"
    Then user select "Complaints Stage" as "Formal Housing Ombudsman - Data request received"
    And user fill all the details for "Directorate" as "COO"
    And user fill all the details for Service Area as "Rents"
    And user fill all the details for Stage 2 Complaint Specialist as "# CDSReportService-CHE"
    And user fill all the details for "Failure Type" as "Community"
    And user fill all the details for "Failure reason" as "Other"
    Then user select "Complaint Contact Preference" as "Phone"
    Then user select "Complaint Contact Frequency" as "Daily"
    Then user enter the details in Failure Reason If Other please specify field
    Then user enter the details for Root Cause Type as "Community"
    Then user enter the details for for Root Cause Reason as "Other"
    Then user enter the details in Root Cause Reason If Other please specify field
    Then user click on "Save"
    Then user clicks on "More commands for Case"
    Then user click on Resolve Case
    Then user validate the Alert message "Please update the Complaints Status before Closing"
    
    