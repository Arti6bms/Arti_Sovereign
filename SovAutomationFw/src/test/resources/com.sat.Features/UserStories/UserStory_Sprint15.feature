@15
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @US12162 @TC39554
  Scenario: US12162 of Sprint 15
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
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
     Then user select Use Saved View field under Advanced Find
     Then user click on Results under Advanced Find
     Then user validate below coloumn names are available
|Case Title|Category (Case Title)|Subcategory (Case Title)|Case Number (Case Title)|Risk Priority|Modified On(Case)|Modified By(case)|Created On (Case Title)|Created By (Case Title)|Owner(Case)|Status (Case Title)|Status Reason (Case Title)|Created On|Created By|

     @US37863 @TC39043
  Scenario: US37863-TC39043 of Sprint 15
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    Then user clicks "Related" Tab for selecting "CaseItemAudit"

  @US37863 @TC39044
  Scenario: US37863-TC39044 of Sprint 15
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
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - All Cases"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Case Title | Category (Case Title) | Subcategory (Case Title) | Case Number (Case Title) | Risk Priority | Modified On(Case) | Modified By(case) | Created On (Case Title) | Created By (Case Title) | Owner(Case) | Status (Case Title) | Status Reason (Case Title) | Created On | Created By |

  @US37863 @TC39181
  Scenario: US37863-TC39181 of Sprint 15
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find
    Then user select Use Saved View field under Advanced Find for "Case Risk Audit - Inactive Cases"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Case Title | Category (Case Title) | Subcategory (Case Title) | Case Number (Case Title) | Risk Priority | Modified On(Case) | Modified By(case) | Created On (Case Title) | Created By (Case Title) | Owner (Case Title) | Status (Case Title) | Status Reason (Case Title) | Created On | Created By |

  @US37863 @TC39046
  Scenario: US37863-TC39046 of Sprint 15
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

  @US38576
  Scenario: US38576 of Sprint 10
    When user selects App "Employment and Training"
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseTitle
    Then user Click the + on the timeline and select "E-mail Activity"
    Then user validate Contact name is autopopulate in "TO" under Email Activity
    Then user validate CaseTitle is autopopulate in "Regarding" under Email Activity

  @US38577
  Scenario: US38577 of Sprint 10
    #need to complete
    When user selects App "Employment and Training"
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user Click the + on the timeline and select "Phone Call Activity"

  @CR30958 @TC37693 @TC37696 @TC37692 @TC38126 @TC37700
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "ET Case" under customer
    Then user click on any active ET Case name
    Then user read the ETCaseContactName
    Then user read the ETCaseTitle
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Contact name is autopopulate in "To" under Email Activity
    Then user validate CaseTitle is autopopulate in "Regarding" under Email Activity

    Examples: 
      | Activity             |
      | E-mail Activity      |
      | Phone Call Activity  |
      | SMS Message Activity |

  @CR30958 @TC37702 @TC37704 @TC37701 @TC38125
  Scenario Outline: CR30958 of Sprint 12
    When user selects App "Employment and Training"
    When user click on "Referrals" under customer
    Then user select one of active Referral
    Then user read the ReferralTitle
    Then user read the ReferralName
    Then user Click the + on the timeline and select "<Activity>"
    Then user validate Referal Contact name is autopopulate in "To" under Email Activity
    Then user validate ReferralTitle is autopopulate in "Regarding" under Email Activity

    Examples: 
      | Activity             |
      | E-mail Activity      |
      | Phone Call Activity  |
      | SMS Message Activity |

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


@TC37794_TC37797
Scenario: CR31393 of Sprint 12
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

 @US27111
@TC37601
Scenario:US27111
When user selects App "Customer Service Hub"
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
When user search "Julie Utting" and click on contact name link
And user click on plus icon on the timeline
And user select "Task" from timeline option
Then user fill details for "Task Category" as "Housing Management"
Then user fill details for "Task Sub-Category" as "Assisted Gardening"

@TC37603_TC37605_TC37604_TC37602
Scenario Outline: US27111 of Sprint 14
When user selects App "Customer Service Hub"
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
When user search "<Contact>" and click on contact name
And user click on plus icon on the timeline
And user select "Task" from timeline option
Then user fill details for "Task Category" as "Housing Management"
Then user fill details for "Task Sub-Category" as "Assisted Gardening"
Then user enter Response Time and Description
And user click on save button
Then user verify the Owner as "<OwnerFieldname>"

Examples:
| Contact | OwnerFieldname      |
| Jerrilee Shepherd| East Admin Tenancy  |
| Martin Bell| West Admin Tenancy  |
| Liam Donald| South Admin Tenancy |
| Laura Trim| East Admin Tenancy  |


@CR_33989 @TC_40008
Scenario: CR_33989
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


@CR_33989
@TC35888_TC35889
Scenario Outline:CR33989
 When user selects App "<Hub>"
 When user click on "Contacts" under customer
 Then user navigate to "All Contacts" view
 When user search "Jerrilee Shepherd" and click on contact name link
 And user click on plus icon on the timeline
 And user select "Task" from timeline option
 Then user enter Response Time and Description
 And user Click on save and close
 Then user open created task
 Then user verify the Queue Item Details as Customer Contact Admin

Examples:
| Hub             |
| Sales Hub |

@CR_33989 @TC34721_TC34719_TC34707_TC34723_TC34722_TC34709_TC34720_TC34435
Scenario Outline: CR33989
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


@TC35882_TC35883 @CR_33989
Scenario Outline: TC35882_TC35883 CR33989 Validate Value is Populated in Queue Items Details field on Task form when Task is Created of Customer service and Resale hub
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


@CR29290
@TC38396_TC37802_TC37801
Scenario: US21574 Validate Auto Email is displayed when Advert Live Date is set on Property Sale Resale Form.
When user selects App "Resales"
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter "Advert Link (URL)" as "https://www.google.com"
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verify the auto popup title content
Then user click on close button in auto popup email
Then user click on "Summary" tab
And Refresh the timeline and find the phone call activity

 @CR29290
@TC_37803
Scenario: CR29290 : Validate Auto generated Advert Live Email  is Deleted and not displayed in Timeline on Property Sale Resale Form when Delete button is clicked.
When user selects App "Resales"
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter "Advert Link (URL)" as "https://www.google.com"
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verify the auto popup title content
Then user clicks on "More commands for E-mail"
Then user delete the case
Then user clicks on "Delete" option
Then user click on "Summary" tab
And Refresh the timeline and find the phone call activity

@CR29290
@TC_38398
Scenario: US21574 CR29290
When user selects App "Resales"
When user click on "Properties" under customer
And user click on Drop Down List
And user select "Assets" from drop down list
Then user search Property Name
Then user select any property
Then user click on "Property Sales" tab
Then user clicks on "New Property Sale. Add New Property Sale"
Then user fill all the details for "Primary Contact" as "Firstname Lastname"
Then user select "Sale Type" as "Resale"
Then user click on "Save"
Then user click on "Valuation & Internal Checks" tab
Then user enter all mandatory fields in Valuation & Internal Checks tab
Then user verifies the auto popup is does not exist

@CR29290
@TC_34860
Scenario: Validate Email popup Preview is displayed when Date of Approval is set on Resale Application Form.
When user selects App "Resales"
When user click on "Contacts" under customer
Then user navigate to "All Contacts" view
When user search "Jerrilee Shepherd" and click on contact name link
Then user clicks "Related" Tab for selecting "Applications"
Then user clicks on "New Application. Add New Application"
Then user validate Lead Application is mapped from Contact
Then user read the Property details
Then user fill all the details for "Property" as "90913, Flat 137 Sinclair Drive, Churchill Way West, Basingstoke, Hampshire, RG21 6AF"
Then user fill all the details for "Property Sale Form" as "RS000000000010"
Then user select "Sale Type Field" as "Resale"
Then user enter the details in Buyer Details section
Then user enter the details in Sellers Details section
Then user enter the details in Sovereign Stakeholder Details section
When user click on "Application" tab
Then user enter the details in Allocation Placement section
Then user verify the auto popup title content 



