@UserStorySprint21
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @CR44632 @TC44614 @TC44774 @TC44775 @TC42651
  Scenario: CR44632-TC44614-TC44774-TC44775-TC42651 of Sprint 21
    When user selects App "Sales Hub"
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
    When user selects App "Sales Hub"
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

  @CR43465 @TC44792
  Scenario: CR43465-TC44792 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |

  @CR43465 @TC44785
  Scenario: CR43465-TC44785 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "All Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Email Address | Status | Actual Close Date | Actual Revenue | Est. close date | Est. revenue | Rating | Probability |

  @CR43465 @TC44793
  Scenario: CR43465-TC44793 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Closed Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44786
  Scenario: CR43465-TC44786 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Closed Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44795
  Scenario: CR43465-TC44795 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Lost Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44789
  Scenario: CR43465-TC44789 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Lost Opportunities - Sales" from drop down list
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

  @CR43465 @TC44784
  Scenario: CR43465-TC44784 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Open Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Est. close date | Est. revenue | Contact | Account | Probability | Rating | Email |

  @CR43465 @TC44794
  Scenario: CR43465-TC44794 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "My Won Opportunities - Resales and Staircasing" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44788
  Scenario: CR43465-TC44788 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    And user select "Won Opportunities - Sales" from drop down list
    Then user verify list of column names
      | Topic | Potential Customer | Status | Actual Revenue | Actual Close Date |

  @CR43465 @TC44780
  Scenario: CR43465-TC44780 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views
      | My Open Opportunities - Resales and Staircasing | All Opportunities - Resales and Staircasing | Won Opportunities - Resales and Staircasing | Lost Opportunities - Resales and Staircasing | Closed Opportunities - Resales and Staircasing |

  @CR43465 @TC44777
  Scenario: CR43465-TC44777 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views
      | My Open Opportunities - Sales | All Opportunities - Sales | Won Opportunities - Sales | Lost Opportunities - Sales | Closed Opportunities - Sales |

  @CR43465 @TC44781
  Scenario: CR43465-TC44781 of Sprint 21
    When user selects App "Resales"
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views are not displayed
      | My Opportunities | All Opportunities | Won Opportunities | Lost Opportunities | Closed Opportunities |

  @CR43465 @TC44778
  Scenario: CR43465-TC44778 of Sprint 21
    When user selects App "Sales Hub"
    When user click on "Applications" under customer
    And user click on Drop Down List
    Then user validate the views are not displayed
      | My Opportunities | All Opportunities | Won Opportunities | Lost Opportunities | Closed Opportunities |

  @US44680 @TC45565 @TC45556 @TC45533 @TC45538 @TC45542
  Scenario: US44680 of Sprint 21
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
