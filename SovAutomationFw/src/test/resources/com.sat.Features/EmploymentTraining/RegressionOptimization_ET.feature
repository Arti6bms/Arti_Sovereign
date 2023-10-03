@RegressionOptimization
  Feature: Testing of Regression - Optimization Test Case in Employment and Training
  
  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    
  @TC_32225
  Scenario: US17274-32225 : Validate National Insurance Field is displayed under Gender field under Summary Tab on Contact(Non Resident/Partner Form) form
    When user click on "Contacts" under customer
    Then user creates the new contact
    Then user scroll down "Contact Details" in page
    Then user validate "National Insurance Number" field is display

  @TC_32232
  Scenario: US17262-32232 : Validate Fields displayed when Saving to Customer selected in Outcome Type on Outcome form.
    When user click on "Outcome" under "CaseManagement"
    Then user creates the new contact
    Then user select "Outcome Type" as "Savings to Customer"
    Then user verified the "Contact Information" section for below fields
      | Reason for Enrollment | ActionPlan Lookup | ET Case | Assessment |
    Then user validate the "Outcome Type" section for below fields
      | Outcome Type | Opportunity Outcome | Missed Outcome |
    Then user verified the "Savings to Customer" section for below fields
      | Date Captured | Income Generated | Debt Reduced or Written Off | Overall Annual Saving | Rent Account at Date of Capture |
    Then user validate the "Outcome Details" section for below fields
      | Date Expected | Has Resident Achieved? | First instance this FY add to Value Insight |
    Then user click on "Save"

  @TC_32235
  Scenario: US17184-32235 : Validate Fields displayed on External Provider Programme Outcome form
    When user click on "Outcome" under "CaseManagement"
    Then user creates the new contact
    Then user select "Outcome Type" as "External Provider Programme"
    Then user verified the "Contact Information" section for below fields
      | Reason for Enrollment | ActionPlan Lookup | ET Case | Assessment |
    Then user validate the "Outcome Type" section for below fields
      | Outcome Type | Opportunity Outcome | Missed Outcome |
    Then user verified the "External Provider Programme" section for below fields
      | External Provider | Date referred | Support Offered | Date ended |
    Then user click on "Save"
    
    @CR30958 @TC37685 @TC38127 @TC38129 @TC37691
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user read the ContactName
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Contacts name is autopopulate in "To" under Email Activity
    Then user validate Contacts name is autopopulate in "Regarding" under Email Activity

    Examples: 
      | Activity             |
      | E-mail Activity      |
      | SMS Message Activity |

  @CR30958 @TC37689 @TC37698 @TC37706
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "<Page>" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user read the ContactName
    Then user Click the + on the timeline and select "Phone Call Activity"
    Then user validate Phone Number in the New Phone Call Form as empty

    Examples: 
      | Page      |
      | Contacts  |
      | ET Case   |
      | Referrals |

  @CR30958 @TC37686 @TC37687 @TC38128
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user read the ContactName
    Then user read the ContactMobileNumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Contacts name is autopopulate in " Call To" under Phone Call Activity
    Then user validate Contact mobile Number is autopopulate in "Mobile Phone Number" under Phone Call Activity
    Then user validate Contacts name is autopopulate in "Regarding" under Phone Call Activity

    Examples: 
      | Activity            |
      | Phone Call Activity |

  @CR30958 @TC37690
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user select one of active Contact
    Then user read the ContactName
    Then user read the ContactMobileNumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Contact mobile Number is autopopulate in "Mobile Phone Number" under SMS Message Activity

    Examples: 
      | Activity             |
      | SMS Message Activity |

  @CR30958 @TC37695 @TC37697
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseContactName Phonenumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate ET Contacts name is autopopulate in "Call To" under Phone Call Activity
    Then user validate ET Case Contact mobile Number is autopopulate in "Mobile Phone Number" under Phone Call Activity

    Examples: 
      | Activity            |
      | Phone Call Activity |

  @CR30958 @TC37703 @TC37705
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Referrals" under customer
    Then user select one of active Referral
    Then user read the ReferralTitle
    Then user read the ReferralName
    Then user read the ReferralPhoneNumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Referal Contact name is autopopulate in "To" under Email Activity
    Then user validate PhoneNumber is autopopulate in "Phone Number" under Phone Call Activity

    Examples: 
      | Activity            |
      | Phone Call Activity |

  @CR30958 @TC37708 @TC37709
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Referrals" under customer
    Then user select one of active Referral
    Then user read the ReferralTitle
    Then user read the ReferralName
    Then user read the ReferralPhoneNumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Referral mobile Number is autopopulate in "Mobile Phone Number" under SMS Message Activity
    Then user validate ReferralTitle is autopopulate in "Regarding" under Email Activity

    Examples: 
      | Activity             |
      | SMS Message Activity |

  @CR30958 @TC37699
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseContactName Phonenumber
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate ET Case Contact mobile Number is autopopulate in "Mobile Phone Number" under SMS Message Activity

    Examples: 
      | Activity             |
      | SMS Message Activity |

  @CR30958 @TC37710_Referral_SMS_Message_Activity
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "<Page>" under customer
    Then user select one of active Referral
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user enters "SMS Message" as "SMS Automation"
    And user click on save button
    Then user click on Back button
    Then user validate SMS Message in Timeline

    Examples: 
      | Page      |
      | Referrals |

  @CR30958 @TC37710_ETCase_SMS_Message_Activity
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "<Page>" under customer
    Then user click on any active ET Case name
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user enters "SMS Message" as "SMS Automation"
    And user click on save button
    Then user click on Back button
    Then user validate SMS Message in Timeline

    Examples: 
      | Page    |
      | ET Case |

  @CR30958 @TC37710_Referral_Email_Activity
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "<Page>" under customer
    Then user select one of active Referral
    Then user Click the + on the timeline and select "E-mail Activity"
    Then user enter "Subject" as "Automation Subject"
    And user click on save button
    Then user click on Back button
    Then user validate Email Message in Timeline

    Examples: 
      | Page      |
      | Referrals |

  @CR30958 @TC37710_ETCase_Email_Activity
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "<Page>" under customer
    Then user click on any active ET Case name
    Then user Click the + on the timeline and select "E-mail Activity"
    Then user enter "Subject" as "Automation Subject"
    And user click on save button
    Then user click on Back button
    Then user validate Email Message in Timeline

    Examples: 
      | Page    |
      | ET Case |

@TC38325_TC38322_TC38324_TC38326_TC38327
Scenario: CR38266 of Sprint 12
When user selects App "Employment and Training"
When user click on "Referrals" under customer
Then user clicks "New"
Then user fill all the details for "Name" as "Julie Utting"
Then user validates "ContactNumber" is mapped from contact as "07505780307"
And user click on save button
Then user Click on Contact link
Then user read the phone numbers
Then user click on Back button
Then user clicks "New"
Then user fill all the details for "Name" as "Jack Taylor"
Then user validates "ContactNumber" is mapped from contact as "+447941517601"
And user click on save button
Then user Click on Contact link
Then user read the phone numbers
Then user click on Back button
Then user clicks "New"
Then user fill all the details for "Name" as "Christine Earle"
Then user validates "ContactNumber" is mapped from contact as "07902096919"
And user click on save button
Then user Click on Contact link
Then user read the phone numbers
Then user click on Back button
Then user clicks "New"
Then user fill all the details for "Name" as "Charlotte Stratton"
Then user validates "ContactNumber" is mapped from contact as "01242 215470"
And user click on save button
Then user Click on Contact link
Then user read the phone numbers
Then user click on Back button
Then user clicks "New"
Then user fill all the details for "Name" as "Zoe Toms"
Then user validates "ContactNumber" is mapped from contact as ""
And user click on save button
Then user Click on Contact link
Then user read the phone numbers
Then user click on Back button
