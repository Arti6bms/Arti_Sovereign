@ProcessingApplications_sales
Feature: Testing of Processing Applications

  Background: 
    Given User navigates to CRM login page
    When user selects App "Sales Hub"

  @TC_23158_TC_23160_TC_23161_TC_23162_TC_23163
  Scenario: TC_23158_TC_23160_TC_23161_TC_23162_TC_23163-Validation of Process of an Application-Summary and Application Tabs and Allocation stage and AML Stage and Conveyancing stage and completion stage
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
    #				#Then user fill all the details for "Development" as "Abbey Fields"
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
    Then user selects Property Offered to Customer as "Yes"
    Then user selects AIP Accepted as "Yes"
    Then user selects Reservation Complete as "Yes"
    Then user selects AML Started as "Yes"
    Then user clicks Next Stage in BPF
    Then user click on "Create"
    Then user validate "AML" form is opened
    Then user validate the fields are mapped from Summary tab
    Then user enter the details in AML check grid
    Then user enter the details in Evidence Proof of ID grid
    Then user enter the details in Source of Funds grid
    Then user validate the message Total percentage should be equal to 100
    Then user validate Score as "3" and risk as "Low" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | Yes                       | Yes                     |
    Then user validate Score as "2" and risk as "Medium" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | Yes                       | No                      |
    Then user validate Score as "1" and risk as "High" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | No                        | No                      |
    Then user validate Score as "0" and risk as "High" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | No                     | No                        | No                      |
    Then user clicks AML on BPF
    Then user validates AML Status is mapped from AML form
    Then user validate AML Risk Status is mapped from AML form
    Then user select "Referred to Sales Manager/Director" as "Yes"
    Then user select "Signed Off" as "Yes"
    Then user select "AML Passed" as "Yes"
    Then user clicks on "Save & Close"
    When user click on "Summary" tab
    Then user clicks AML on BPF
    Then user clicks Next Stage in BPF
    When user click on "Conveyancing" tab
    Then user validate the "Details" section for below fields
      | Topic | Customer Reference | Development | Property Offered | Tenure | Sales Stage |
    Then user select "Sales Stage" as "Conveyancing"
    Then user validate the following grids are displayed in "Conveyancing"
      | Exchange Key Milestones | Conveyancing Key Milestones | Mortgage Key Milestones | Viewings | Documents received | Documents Checked | Documents Signed | Documents Returned |
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
    #When user click on "Completion" tab
    #Then user enter the details in Post Completion Key Milestones
    Then user click on "Save"
    Then user clicks Post Completion on BPF
    Then user enter the details in Post Completion BPF field
    Then user clicks on "Finish"
    Then user validate Post Completion stage is marked as Finished

  #@TC_23164
  #Scenario: TC_23164_ Validation of process an Application - Closure Stage
  #When user click on "Applications" under customer
  #And user click on Drop Down List
  #And user select "Open Opportunities" from drop down list
  #Then user click on open opportunity
  #Then user clicks on "More commands for Application"
  #Then user clicks on "Close as won"
  #Then user click on OK
  #Then user validate read only message
  @TC_30934
  Scenario: TC_30934_Validation Sales status is set to Completed on property offered
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

  @TC_30936
  Scenario: TC_30936_Validation Sales status is set to Reserved
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

  @TC_30937
  Scenario: TC_30937_Validation Sales status is set to Apply Now
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

  @TC_38934 @TC38935_TC38936_TC44327_TC44324_TC44325_TC38917_TC44317_TC38924_TC38930_TC38922_TC38923
  Scenario: US34638 US34637 CR43188 Validate Chain information grid is Displayed under Allocation Tab
    When user click on "Applications" under customer
    Then user click on "New"
    Then user fill all the details for "Lead Applicant" as "Aaisha Tanvir"
    When user click on "Application" tab
    Then user select "Application Status" as "Active"
    Then user click on "Save"
    When user click on "Summary" tab
    When user click on "Application" tab
    Then user validate Application Status
    Then user clicks Application on BPF
    Then user selects FA Status as "Complete"
    Then user selects HtB Status as "Complete"
    Then user selects Meets Development Criteria as "Yes"
    Then user selects Application Complete as "Complete"
    Then user selects Allocated as "Yes"
    Then user clicks Next Stage in BPF
    When user click on "Allocation" tab
    Then user scroll down to till element is visible
    Then user validates "Chain Information" grid
    #Then user validate the "Chain Information" grid for below fields
    #| Customer Name(s) | Property Type | Estate Agent details (Company name, contact, phone |
    Then user clicks on "New Chain Information"
    Then user verified the "Customer Details" section for below fields
      | Customer Name(s) | Address of Property to be sold | Property Type | Estate Agent details (Company name, contact, phone | Buyers Solicitor details (Company name, office, co | Financial Advisor details (Company name, contact, | Additional Supporting Info | Sales Manager Signed Off? | End of Chain |
    Then user verified the "Milestones" section for below fields
      | Sale Agreed Date | MOS Sent | Mortgage Survey Date | Mortgage Offer Received | Searches Applied For | Enquiry Info (raised, answered, outstanding) | If Flat, When Was Management Pack Ordered |
    And user fill all the details for "Name" as "Test Chain info"
    And user fill all the details for "Customer Name(s)" as "Julie Utting"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    Then user clicks on "Save & Close"
    Then user scroll down to till element is visible
    And user selects first record
    Then user click on "Edit" button
    Then user enters "Buyers Solicitor details (Company name, office, co" as "Solicitor1"
    And user fill all the details for "Financial Advisor details (Company name, contact," as "Advisor1"
    And user fill all the details for "Additional Supporting Info" as "Testing"
    Then user select "Sales Manager Signed Off?" as "Yes"
    Then user select "End of Chain" as "No"
    Then user click on "Save"
    Then user click on refresh button
    Then user validates "Additional links in chain" grid
    Then user clicks on "More commands for Additional links in Chain"
    Then user clicks on "Add additional link"
    Then user fill the details for Quick create "Name" field as "Test Additional link"
    Then user fill the details for Quick create "Customer Name(s)" field as "Liam Donald"
    And user Click on save and close
    Then user click on Back button
    Then user scroll down to till element is visible
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "End of chain Yes Test"
    Then user click on "Save"
    Then user validate "Allocation" tab
    Then user scroll down to till element is visible
    Then user validates "Chain Information" grid

  @TC42649_TC42650_TC44315_TC44314_TC42648
  Scenario: CR41253
    When user click on "Applications" under customer
    #Then user click on Dismiss
    And user click on Drop Down List
    And user select "My Open Opportunities" from drop down list
    Then user select any Opportunity
    When user click on "Allocation" tab
    Then user scroll down to till element is visible
    Then user validates "Chain Information" grid
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "New chain information1"
    And user fill all the details for "Customer Name(s)" as "Anthony Hudd"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    And user fill all the details for "Additional Supporting Info" as "Testing"
    Then user select "Sales Manager Signed Off?" as "Yes"
    Then user select "End of Chain" as "No"
    Then user click on "Save"
    Then user click on refresh button
    Then user clicks on "More commands for Additional links in Chain"
    Then user clicks on "Add additional link"
    Then user fill the details for Quick create "Name" field as "Test Additional link"
    Then user fill the details for Quick create "Customer Name(s)" field as "Liam Donald"
    And user Click on save and close
    Then user click on Back button
    Then user validate "Allocation" tab
    Then user scroll down to till element is visible
    Then user validates "Chain Information" grid
    And user selects first record in additional link chain
    Then user verify the Test additional popup

  @CR44632 @TC44614 @TC44774 @TC44775 @TC42651
  Scenario: CR44632-TC44614-TC44774-TC44775-TC42651 of Sprint 21
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
    Then user clicks on "More commands for Chain Information"
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "Test Chain info"
    And user fill all the details for "Customer Name(s)" as "Julie Utting"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    Then user select "End of Chain" as "No"
    Then user click on "Save"
    Then user validates "General" section
    Then user clicks on "More commands for Additional links in Chain"
    Then user validate Add additional link option is available
    Then user clicks on "Press Enter to go back."
    Then user validate child links are not displayed for selected chain information
    Then user clicks on "More commands for Chain Information"
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "Test Chain info"
    And user fill all the details for "Customer Name(s)" as "Julie Utting"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    Then user select "End of Chain" as "No"
    Then user click on "Save"
    Then user clicks on "More commands for Additional links in Chain"
    Then user clicks on "Add additional link"
    Then user enter Name field as "add Child 1"
    Then user enter Customer Name field as "add Julie Utting 1"
    Then user clicks on "Save and Close"
    Then user clicks on "More commands for Additional links in Chain"
    Then user clicks on "Add additional link"
    Then user enter Name field as "add Child 2"
    Then user enter Customer Name field as "add Julie Utting 2"
    Then user clicks on "Save and Close"
    Then user clicks on "Press Enter to go back."
    Then user validate the child Chain information grid records are showing based on created date

  @CR44632 @TC38925 @TC42647
  Scenario: CR44632-TC38925-TC42647 of Sprint 21
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
    Then user clicks on "More commands for Chain Information"
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "Test Chain info"
    And user fill all the details for "Customer Name(s)" as "Julie Utting"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    Then user select "End of Chain" as "Yes"
    Then user click on "Save"
    Then user click on "Press Enter to go back."
    Then user validates "Child Chain Information" section
    Then user clicks on "More commands for Chain Information"
    Then user clicks on "New Chain Information"
    And user fill all the details for "Name" as "RRR"
    And user fill all the details for "Customer Name(s)" as "Julie Utting 2"
    Then user select "Property Type" as "House"
    Then user enters "Estate Agent details (Company name, contact, phone" as "Test98764352727"
    Then user click on "Save"
    Then user click on "Press Enter to go back."
    Then user validate the Chain information grid records are showing based on created date

  @CR43465 @TC44785
  Scenario: CR43465-TC44785 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |

  @CR43465 @TC44786
  Scenario: CR43465-TC44786 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Closed Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44789
  Scenario: CR43465-TC44789 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Lost Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44784
  Scenario: CR43465-TC44784 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Open Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Est. close date | Est. revenue | Contact | Account | Probability | Rating | Email |

  @CR43465 @TC44788
  Scenario: CR43465-TC44788 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Won Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44777
  Scenario: CR43465-TC44777 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views
      | My Open Opportunities - Sales | All Opportunities - Sales | Won Opportunities - Sales | Lost Opportunities - Sales | Closed Opportunities - Sales |

  @CR43465 @TC44778
  Scenario: CR43465-TC44778 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views are not displayed
      | My Opportunities | All Opportunities | Won Opportunities | Lost Opportunities | Closed Opportunities |

  @CR43465 @TC45656
  Scenario: CR43465-TC45656 of Sprint 21
    When user click on "Applications" under customer
    Then user verify list of column names
      | Topic | Potential Customer | Est. close date | Est. revenue | Contact | Account | Probability | Rating | Email (Potential Customer) |
    And user click on Drop Down List
    And user select "All Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |
    And user click on Drop Down List
    And user select "Closed Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
    And user click on Drop Down List
    And user select "Lost Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
    And user click on Drop Down List
    And user select "Won Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
