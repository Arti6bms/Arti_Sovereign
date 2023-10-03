@UserStorySprint4
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page
  When user selects App "Customer Service Hub"
  #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
  @US23397
  Scenario: Us -23397,Us-33983,Us-34001,US-33478,US-21094
    When user click on "Neighborhoods" under customer
    And user click on Drop Down List
    And user select "Active Neighborhoods" from drop down list
    When user search "Abingdon - 1 to 5 Fitchett Yard flats" and click on contact name link
    Then user fill details for "Walkabout Frequency" as "1 week"

  @US34001
  Scenario: Us -34001
    #East Admin Tenancy
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
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Tenancy"
    And user fill all the details for "Subcategory" as "Joint to Sole (Tenancy Change)"
    And user enters description
    And user click on save button
    Then user validate Originating Neighbourhood fields is auto populated

  @US22305
  Scenario: Us -22305
    When user click on "Neighborhoods" under customer
    And user search "125 Princess Road Branksome, Poole" and click on contact name link
    And user select "Walkabout Frequency" as "6 Months"
    And user select "Rating" as "2"
    Then user click on "Save"
    Then user click on "Related"
    And user click on Tab "Related" for selecting "Audit History"
    And user verify the new values as "6 Months" and "2" in "Audit History"

  @US21094
  Scenario: Us -21094
    When user click on "Neighborhoods" under customer
    And user search "125 Princess Road Branksome, Poole" and click on contact name link
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user click on "Save and Close"
    Then user Reopen the "appointment" from the timeline
    Then user provide the Walkabout Rating and mark the appointment complete
    Then user verifies if "Appointment" is closed
    Then user validate "Appointment closed date" field as "Walkabout Completion Date"

  @US22301
  Scenario: Us -22301
    When user click on "Cases" under customer
    And user click on New Cases
    And user will select Category as "Customer"
    And user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user verify all the "Assisted Gardening Case Types" list values
      | Vulnerability | Financial | Disability | No Support | Awaiting Move(BAP/Downsizing) | Other |

  @US22302
  Scenario: Us -22302
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
    When user click on "Cases" under customer
    And user click on New Cases

  @CR36395 @Sprint13
  Scenario: CR36395 of Sprint 11
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |

  @CR36396 @Sprint13
  Scenario: CR36396 od Sprint 11
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |
    Then user click on "Save (CTRL+S)"
    Then user select "Rating" as "2"
    Then user click on "Save (CTRL+S)"
    Then user click on "Mark Complete"
    Then user validate Walkabout Frequency as "1 week"
    Then user validate Walkabout Completion Date as current date

  @US37502 @Sprint13
  Scenario: US37502 of Sprint 11
    When user selects App "Employment and Training"
    When user click on "Referrals" under Site Map
    Then user search Referral Name having Mobile Phone
    Then user click on Referral name
    Then user Click on Contact link
    Then user read the phone numbers
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user validate the phone number is displayed correctly when Mobile Phone exists
    When user click on "Referrals" under Site Map
    Then user search Referral Name having Mobile Phone 2
    Then user click on Referral name
    Then user Click on Contact link
    Then user read the phone numbers
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user validate the phone number is displayed correctly when Mobile Phone 2 exists
    When user click on "Referrals" under Site Map
    Then user search Referral Name having Home Phone
    Then user click on Referral name
    Then user Click on Contact link
    Then user read the phone numbers
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user validate the phone number is displayed correctly when Home Phone exists
    When user click on "Referrals" under Site Map
    Then user search Referral Name having Work Phone
    Then user click on Referral name
    Then user Click on Contact link
    Then user read the phone numbers
    Then user Click the + on the timeline and select "SMS Message Activity"
    Then user validate the phone number is displayed correctly when Work Phone exists

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

  @CR37097 @Sprint13
  Scenario: CR37097 of Sprint 10
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    Then user clicks on "New" contact
    Then user navigate to the Preferred Language field
    Then user verifies the field "Preferred Language"
      | Nepali | Macedonian | Lithuanian | Estonian |

  @CR14171 @Sprint13
  Scenario Outline: TC33088_TC34655_TC34657_TC34653_TC34651_TC34656_TC34658 of Sprint 11
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

  @CR14171 @Sprint13
  Scenario: TC34654 of Sprint 11
    When user selects App "Sales Hub"
    When user click on "Contacts" under customer
    Then user navigate to "Active Contacts" view
    Then user select one of active Contact
    Then user enter the mobilephone which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the mobilephone starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid mobilephone starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"

  @US37599 @Sprint13
  Scenario Outline: TC38080_TC38086 of Sprint 11
    When user selects App "Customer Service Hub"
    Then user add the Team "<TeamName>"
    When user click on "Accounts" under Site Map
    Then user navigate to "All Accounts" view
    Then user select one of active Account
    When user click on "Household Group Information" tab
    Then user validate locked field
      | Household Group Reference | Legal Tenancy Name | Preferred Language | Employment & Training Involved | Household Verification Date |
    Then user delete the Team "<TeamName>"

    Examples: 
      | TeamName                              |
      | Housing Advice and Resolution Service |
      | Sovereign-HouseholdVerification       |

  @CR38075 @Sprint13
  Scenario Outline: TC38459_TC38460_TC38461_TC38462_TC38463_TC38464 of Sprint 13
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
