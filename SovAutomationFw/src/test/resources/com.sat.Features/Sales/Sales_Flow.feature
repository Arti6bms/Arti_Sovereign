@Sales_Flow
Feature: Testing of Sales_Flow

  Background: 
    Given User navigates to CRM login page
    When user selects App "Sales Hub"

  @TC_22651
  Scenario: TC_22651-Validate Application Saved\Updated after providing date property resrved data field under Reservation section of allocation Tab
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities" from drop down list
    Then user search Application Title
    Then user select any Opportunity
    When user click on "Allocation" tab
    Then user enter the Property Offered
    Then user enter Property Reserved Date
    Then user click on "Save"

  @TC_22653
  Scenario: TC_22653-Validate sales status is set to reserved on Account when Date is set in Property Reserved Date field under Reservation section of allocation Tab
    When user click on "Applications" under customer
    Then user click on "New"
    Then user fill all the details for "Lead Applicant" as "Aaisha Tanvir"
    Then user select "Number of Additional Applicants" as "3"
    Then user validates "Additional Applicant" field is appearing 3 times
    Then user enter the "Additional Applicant" fields
    Then user fill all the details for "Buyers Solicitor" as "Peter Dodson"
    Then user fill all the details for "Buyers Solicitor Contact" as "Jenny Cotterell"
    Then user fill all the details for "Financial Advisor" as "Sterling Mortgage Advice"
    Then user fill all the details for "Financial Advisor Contact" as "Matt Eady Smith"
    When user click on "Application" tab
    Then user select "Application Status" as "Active"
    Then user fill all the details for "Development" as "testing"
    Then user fill all the details for "Preferred Property"
    Then user enter Bedroom Applied for field
    Then user enter Property Type field
    Then user enter Property Position field
    Then user enter values in HtB Application grid
    Then user enter values in Financial Assessment grid
    Then user enter values in Criteria grid
    Then user click on "Save"
    When user click on "Summary" tab
    Then user validates Application Title
    When user click on "Application" tab
    Then user validate Application Status
    Then user validate Days Preference Registered
    Then user validate Total Number in Household
    Then user validate Local Connection Score
    Then user clicks Application on BPF
    Then user selects FA Status as "Complete"
    Then user selects HtB Status as "Complete"
    Then user selects Meets Development Criteria as "Yes"
    Then user selects Application Complete as "Complete"
    Then user selects Allocated as "Yes"
    Then user clicks Next Stage in BPF
    Then user validate Allocation tab is selected
    When user click on "Allocation" tab
    Then user enter details in Allocation offer Grid
    Then user enter details in Financial Grid
    Then user enter details in Reservation Grid
    Then user click on "Save"
    Then user clicks Allocation on BPF
    When user click on "Allocation" tab
    Then user enter the Property Offered
    Then user enter Property Reserved Date
    Then user click on "Save"
    Then user clicks on Property Offered value link
    Then user navigates to "SL Property" form
    Then user validate the Sales Status field value as "Reserved"
    
    #Then user validate Reserved Flag is displayed

  @TC_22708
  Scenario: TC_22708-Validate Sales status is set to Completed When Completion date is set Property Offered Application
   When user click on "Applications" under customer
    Then user click on "New"
    Then user fill all the details for "Lead Applicant" as "Aaisha Tanvir"
    Then user select "Number of Additional Applicants" as "3"
    Then user validates "Additional Applicant" field is appearing 3 times
    Then user enter the "Additional Applicant" fields
    Then user fill all the details for "Buyers Solicitor" as "Peter Dodson"
    Then user fill all the details for "Buyers Solicitor Contact" as "Jenny Cotterell"
    Then user fill all the details for "Financial Advisor" as "Sterling Mortgage Advice"
    Then user fill all the details for "Financial Advisor Contact" as "Matt Eady Smith"
    When user click on "Application" tab
    Then user select "Application Status" as "Active"
    Then user fill all the details for "Development" as "testing"
    Then user fill all the details for "Preferred Property"
    Then user enter Bedroom Applied for field
    Then user enter Property Type field
    Then user enter Property Position field
    Then user enter values in HtB Application grid
    Then user enter values in Financial Assessment grid
    Then user enter values in Criteria grid
    Then user click on "Save"
    When user click on "Summary" tab
    Then user validates Application Title
    When user click on "Application" tab
    Then user validate Application Status
    Then user validate Days Preference Registered
    Then user validate Total Number in Household
    Then user validate Local Connection Score
    Then user clicks Application on BPF
    Then user selects FA Status as "Complete"
    Then user selects HtB Status as "Complete"
    Then user selects Meets Development Criteria as "Yes"
    Then user selects Application Complete as "Complete"
    Then user selects Allocated as "Yes"
    Then user clicks Next Stage in BPF
    Then user validate Allocation tab is selected
    When user click on "Allocation" tab
    Then user enter details in Allocation offer Grid
    Then user enter details in Financial Grid
    Then user enter details in Reservation Grid
    Then user click on "Save"
    Then user clicks Allocation on BPF
    When user click on "Allocation" tab
    Then user enter the Property Offered
    Then user enter Property Reserved Date
    Then user click on "Save"
     Then user clicks Allocation on BPF
    Then user selects Property Offered to Customer as "Yes"
    Then user selects AIP Accepted as "Yes"
    Then user selects Reservation Complete as "Yes"
    Then user selects AML Started as "Yes"
    Then user clicks Next Stage in BPF
    Then user click on "Create"
    Then user validate "AML" form is opened
    Then user enter the details in AML check grid
    Then user enter the details in Evidence Proof of ID grid
    Then user enter the details in Source of Funds grid
   Then user clicks AML on BPF
    Then user select "Referred to Sales Manager/Director" as "Yes"
    Then user select "Signed Off" as "Yes"
    Then user select "AML Passed" as "Yes"
    Then user clicks on "Save & Close"
    When user click on "Summary" tab
    Then user clicks AML on BPF
    Then user clicks Next Stage in BPF
    When user click on "Conveyancing" tab
   	Then user select "Sales Stage" as "Conveyancing"
    Then user enter the details in Reservation Key Milestones
    Then user enter the details in Conveyancing Key Milestones
    Then user enter the details in Mortgage Key Milestones
    Then user enter the details in Documents received
    Then user enter the details in Documents Checked
    Then user enter the details in Documents Signed
    Then user enter the details in Documents Returned
    Then user enter the details in Exchange Key Milestones
    Then user enter the details in Viewings
    Then user click on "Save"
    Then user validate "Weeks of Exchange" field
    Then user clicks Conveyancing on BPF
    Then user enter the details in Conveyancing BPF field
    Then user clicks Next Stage in BPF
    When user click on "Completion" tab
    Then user enter Completion Date
    Then user click on "Save"
    When user click on "Allocation" tab
    Then user clicks on Property Offered value link
     Then user navigates to "SL Property" form
    Then user validate the Sales Status field value as "Completed"


  @TC_22655
  Scenario: TC_22655-Validate Sales Status is set to Apply Now for Account when user click on closed as Lost Button on application contains Property Offered
     When user click on "Applications" under customer
    Then user click on "New"
    Then user fill all the details for "Lead Applicant" as "Aaisha Tanvir"
    Then user select "Number of Additional Applicants" as "3"
    Then user validates "Additional Applicant" field is appearing 3 times
    Then user enter the "Additional Applicant" fields
    Then user fill all the details for "Buyers Solicitor" as "Peter Dodson"
    Then user fill all the details for "Buyers Solicitor Contact" as "Jenny Cotterell"
    Then user fill all the details for "Financial Advisor" as "Sterling Mortgage Advice"
    Then user fill all the details for "Financial Advisor Contact" as "Matt Eady Smith"
    When user click on "Application" tab
    Then user select "Application Status" as "Active"
    Then user fill all the details for "Development" as "testing"
    Then user fill all the details for "Preferred Property"
    Then user enter Bedroom Applied for field
    Then user enter Property Type field
    Then user enter Property Position field
    Then user enter values in HtB Application grid
    Then user enter values in Financial Assessment grid
    Then user enter values in Criteria grid
    Then user click on "Save"
    When user click on "Summary" tab
    Then user validates Application Title
    When user click on "Application" tab
    Then user validate Application Status
    Then user validate Days Preference Registered
    Then user validate Total Number in Household
    Then user validate Local Connection Score
    Then user clicks Application on BPF
    Then user selects FA Status as "Complete"
    Then user selects HtB Status as "Complete"
    Then user selects Meets Development Criteria as "Yes"
    Then user selects Application Complete as "Complete"
    Then user selects Allocated as "Yes"
    Then user clicks Next Stage in BPF
    Then user validate Allocation tab is selected
    When user click on "Allocation" tab
    Then user enter details in Allocation offer Grid
    Then user enter details in Financial Grid
    Then user enter details in Reservation Grid
    Then user click on "Save"
    Then user clicks Allocation on BPF
    When user click on "Allocation" tab
    Then user enter the Property Offered
    Then user enter Property Reserved Date
    Then user click on "Save"
    #Then user clicks on "More commands for Application"
    Then user clicks on "Close as lost"
    Then user click on OK
    #Then user validate read only message
    Then user validate read only message as "Lost"
    When user click on "Allocation" tab
    Then user clicks on Property Offered value link
    When user click on "Summary" tab
    Then user validate the Sales Status field value as "Apply Now"
     
     
     
     #When user click on "Applications" under customer
    #And user click on Drop Down List
    #And user select "Open Opportunities" from drop down list
    #Then user sort the records from newer to older in Oppurtunities List
    #Then user select any Opportunity
    #When user click on "Allocation" tab
    #Then user enter the Property Offered
    #Then user enter Property Reserved Date
    #Then user click on "Save"
    #Then user clicks on "More commands for Application"
    #Then user clicks on "Close as Lost"
    #Then user click on OK
    #Then user validate read only message
    #When user click on "Allocation" tab
    #Then user clicks on Property Offered value link
    #When user click on "Summary" tab
    #Then user validate the Sales Status field value as "Apply Now"
    			#Then user validate Apply Now Flag is displayed

