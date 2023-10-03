@ProcessingApplications_Resales
Feature: Testing of Processing Applications Resales

  Background: 
    Given User navigates to CRM login page
    When user selects App "Resales"

  @TC_23489_TC_22901_TC_22902_TC_22904_TC_22905_TC_22906
  Scenario: TC_23489_TC_22901_TC_22902_TC_22904_TC_22905_TC_22906
    When user click on "Contacts" under customer
    Then user select any contact
    Then user clicks "Related" Tab for selecting "Applications"
    Then user clicks on "New Application. Add New Application"
    #Then user validate Lead Application is mapped from Contact
    Then user read the Property details
    #Then user fill all the details for "Property Sale Form" as "RS000000000029"
    Then user fill all the details for "Property Sale Form" as "RS000000000972"
    Then user fill all the details for "Property" as "100001, 36 Silks Way, Andover, Hampshire, SP11 6UU"
    Then user select "Sale Type Field" as "Resale"
    Then user enter the details in Buyer Details section
    Then user enter the details in Sellers Details section
    Then user enter the details in Sovereign Stakeholder Details section
    Then user enter the details in Information section
    When user click on "Application" tab
    Then user enter the details in Assessment section
    Then user enter the details in Allocation Placement section
    Then user enter the details in Criteria section
    Then user click on "Save"
    #Then user validate "Lease Expiry Date" is mapped from "Property Sales Form"
    #Then user validate "Remaining Lease Term" is mapped from "Property Sales Form"
    Then user click on "Save"
    Then user validate "Notes" field when below values are selected in "Application Status"
      | Items Outstanding | DIP requested | Sent to LA to nominate |
    Then user validate "Share Price"
    Then user validate "Unable To Approve Reason" field when "Able To Approve" is selected as "No"
    Then user validate "Homeowner Status" field when "Existing Accommodation" is selected as "Home Owner"
    Then user validate "Total Number in Household" field is total of "Number of Adults" and "Number of Children"
    Then user validate "Financial Advisor" is mapped from "Summary" Tab
    Then user validate "Financial Advisor Contact" is mapped from "Summary" Tab
    Then user clicks Application on BPF
    Then user selects FA Status as "Complete"
    Then user selects HtB Status as "Complete"
    Then user selects Application Complete as "Complete"
    Then user selects Allocated as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks on Create
    Then user Validates AML stage on BPF
    Then user validate "Contact" is mapped from "Summary" Tab
    Then user validate "Number of Additional Applicants" is mapped from Summary Tab
    Then user validate "First Additional Applicant" is mapped from "Summary" Tab
    Then user enter the details in AML check grid
    Then user enter the details in Questionnaire section
    Then user enter the details in Evidence Proof of ID grid
    Then user enter the details in Source of Funds grid
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
    Then user enter the details in Risk section
    Then user validate the message Total percentage should be equal to 100
    Then user enter the details in AML Signature section
    Then user click on "Save"
    Then user clicks AML on BPF
    Then user validates "AML Status" as "Passed"
    Then user validates "AML Risk Status" as "High"
    Then user validate below fields are hidden
      | Referred to Sales Manager/Director |
    Then user select "Referred to Sales Manager/Director" as "Yes"
    Then user select "Signed Off" as "Yes"
    Then user select "AML Passed" as "Yes"
    Then user clicks Next Stage in BPF
    Then user enter the details in Reservation section
    Then user enter the details in Memorandum of Sale
    Then user clicks Reservation on BPF
    Then user validate "Property" is mapped from "Summary" Tab
    #Then user validate Reservation Form Received is mapped from "Reservation" Tab
    #Then user enters Reservation Fee Received
    Then user select "Reservation Complete" as "Yes"
    Then user enters MOS Sent
    Then user clicks Next Stage in BPF
    Then user enter the details in Mortgage Key Milestones section
    Then user enter the details in Resale Fees Seller
    Then user enter the details in Resale Fees Buyer
    Then user enter the details in Completion Statement
    Then user validate Rent Amount Owed field
    Then user validate Total Seller field
    Then user validate Current Month Rent Owed field
    Then user validate Total buyer field
    Then user clicks Conveyancing on BPF
    Then user set "Mortgage Offer Approved" date
    Then user set "Completion Statement Issued" date
    Then user selects Completed as "Yes"
    Then user clicks Next Stage in BPF
    Then user enter the details in Completion and Handover information
    Then user enter the details in Post Completion Documentation
    Then user enter the details in Fee Confirmation
    Then user validates Sovereign Requirement Section is not displayed under Post Completion Requirement tab
    Then user validates Total fees seller is displayed under Post Completion Requirement tab
    Then user validates Total fees buyer is displayed under Post Completion Requirement tab
    Then user validates Fee Confirmation Section is displayed under Post Completion Requirement tab
    Then user validates Post Completion Documentation Section is displayed under Post Completion Requirement tab
    Then user clicks Post Completion on BPF
    Then user set "Completion Date" date
    Then user selects Handover to Internal Teams as "Yes"
    Then user selects CORE as "Yes"
    Then user selects HtB Completed as "Yes"
    Then user selects Funds Received as "Yes"
    Then user selects Post Completion Tasks Completed as "Complete"
    Then user clicks on "Finish"
    Then user click on "Save"
    Then user clicks on "Close as Won"
    Then user click on OK
    Then user clicks on "Reopen Opportunity"
    Then user clicks on "More commands for Application"
    Then user clicks on "Close as Lost"
    Then user click on OK

  #
  @TC_23663
  Scenario: TC_23663
    When user click on "Properties" under customer
    And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name
    Then user select any property
    Then user clicks "Related" Tab for selecting "Rent Account"
    Then user select any Rent Account Record
    #Then user read the "Current Monthly Rent" and "Current Monthly Service Charge" from "RENT ACCOUNT DETAILS" section
    #Then user read the "Rent" and "Other" charges from "Charges" Section
    #Then user validate "Current Monthly Rent" and "Current Monthly Service Charge"
    Then user clicks on "New Charge. Add New Charge"
    Then user enters details in New Charge Section
    Then user click on "Save & Close"
    #		Then user clicks on "Press Enter to go back."
    Then user click on "Property Sales" tab
    Then user clicks on "New Property Sale. Add New Property Sale"
    Then user fill all the details for "Primary Contact" as "Firstname Lastname"
    Then user select "Sale Type" as "Resale"
    Then user click on "Save"

  @TC31015
  Scenario: TC31015_US21527 : Validate Changes of Fields and Sections under Summary Tab of Resale Application
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    When user search "Abdulla Sharif" and click on contact name link
    When user click on "Application" tab
    And user click on "New Application"
    Then verify all section under tab
      | Property | Buyer Details |
    Then user validate "Property" field is display
    Then user validate "Property Sale Form" field is display
    #Then user fill all the details for "Property Sale Form" as "RS000000000010"
    Then user fill all the details for "Property Sale Form" as "RS000000000207"
    Then user scroll down till "Sellers Details" present in page
    #Then user verified the "Sellers Details" section for below fields
    #| Legal Tenancy Name | Resales Repossession? | Executor? |
    Then user scroll down till "Buyer Details" present in page
    Then user verify "Buyers Solicitor" filed is Locked
    Then user verify "Buyers Solicitor Contact" filed is Locked
    #Then user scroll down till "Seller Solicitor" present in page
    Then user scroll to section "Sellers Details"
    Then user verify "Seller Solicitor" filed is Locked
    Then user verify "Seller Solicitor Contact" filed is Locked

  @CR43465 @TC44792
  Scenario: CR43465-TC44792 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |

  @CR43465 @TC44793
  Scenario: CR43465-TC44793 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Closed Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44795
  Scenario: CR43465-TC44795 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Lost Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44791
  Scenario: CR43465-TC44791 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Open Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Est. close date | Est. revenue | Contact | Account | Probability | Rating | Email |

  @CR43465 @TC44794
  Scenario: CR43465-TC44794 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Won Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44780
  Scenario: CR43465-TC44780 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views
      | My Open Opportunities - Resales and Staircasing | All Opportunities - Resales and Staircasing | Won Opportunities - Resales and Staircasing | Lost Opportunities - Resales and Staircasing | Closed Opportunities - Resales and Staircasing |

  @CR43465 @TC44781
  Scenario: CR43465-TC44781 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views are not displayed
      | My Opportunities | All Opportunities | Won Opportunities | Lost Opportunities | Closed Opportunities |

  @CR43465 @TC45654
  Scenario: CR43465-TC45654 of Sprint 21
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Open Opportunities - Resales and Staircasing" from drop down list
    Then user validate list of column names
      | Topic | Potential Customer | Est. close date | Est. revenue | Contact | Account | Probability | Rating | Email (Potential Customer) |
    And user click on Drop Down List
    And user select "All Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |
    And user click on Drop Down List
    And user select "Closed Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
    And user click on Drop Down List
    And user select "Lost Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
    And user click on Drop Down List
    And user select "My Won Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |
