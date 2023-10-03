@UserStorySprint13
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

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

  @CR36396 @US21094 @TC35216 @Sprint13
  Scenario: US21094 TC35216 of Sprint 11
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |
    Then user clicks on "Save (CTRL+S)"
    Then user select "Rating" as "2"
    Then user clicks on "Save (CTRL+S)"
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
  @TC33088_TC34655_TC34657_TC34653_TC34651_TC34656_TC34658
  Scenario Outline: CR14171 of Sprint 11
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
  @TC34654
  Scenario: CR14171 of Sprint 11
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
  @TC38080_TC38086
  Scenario Outline: US37599 of Sprint 11
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
  @TC38459_TC38460_TC38461_TC38462_TC38463_TC38464
  Scenario Outline:  CR38075 of Sprint 13
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
  @TC38470_TC38471_TC38473
  Scenario Outline: US38074 of Sprint 12
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
