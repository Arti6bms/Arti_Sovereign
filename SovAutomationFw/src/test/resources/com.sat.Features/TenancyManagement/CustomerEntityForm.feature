@CustomerEntitiesForm
@Tenancy
Feature: Testing for Customer Entities Form in Tenancy Management

Background: 
    Given User navigates to CRM login page
     When user selects App "Customer Service Hub"

  @ContactForm
  Scenario: TC28278_C8798-Validation of Contact Form
    When user click on "Contacts" under customer
    And user click on Drop Down List
     And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then verify all tabs are appearing on the Contact Form
      | Summary | Correspondence | Data Protection | Tenancies | Rent Accounts | Conflicts Tab | Related |
    When user click on "Summary" tab    
    Then verify all sections under "Summary" tab
      |GENERAL INFORMATION | TIMELINE | Flags |
    #And verify Locked fields under GENERAL INFORMATION section
    #And verify Unlocked fields under GENERAL INFORMATION section
    #Then verify filter options on the timeline    
    When user click on "Correspondence" tab
    Then verify all sections under "Correspondence" tab
     | MAIN ADDRESS | CORRESPONDENCE ADDRESS | EMERGENCY CONTACTS | AUTHORITY TO DISCUSS THESE ACCOUNTS |
    #Then click on New Emergency Contact
    #And user click on save and close button
    #Then user scroll down "MAIN ADDRESS" in page
    #Then click on New Contact
    #And user click on save and close button
    #When user click on "Data Protection" tab
    #And verify all section "DATA PROTECTION DETAILS" under Data Protection tab
    #And click on New Data Protection link
    #Then verify all section under tab
      #| General | CUSTOMER INFORMATION | DATA PROTECTION QUESTIONS | ACCOUNT INFORMATION |
    #And user click on save and close button
    #When user click on "Tenancies" tab
    #Then user open "Miss J Shepherd" Form
    #And user click on save and close button
    #When user click on "Rent Accounts" tab
    #Then user open "Flat- Flat 25 Odiham Drive, Newbury ,RG14 1GA" Form
    #And user click on save and close button
    #When user click on "Conflicts Tab" tab
    #When user click on "Related" tab

  @BlocksForm
  Scenario: TC28281_C8800-Validation of Blocks Form
    When user click on "Blocks" under customer
    And user click on Drop Down List
    And user select "Active Blocks" from drop down list
    When user search "100012, Block 34/36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" and click on contact name
    Then verify all tabs are appearing on the "Block Form" Form
      | General | Assets | Repair Cases | Related |
    When user click on "General" tab
    Then verify all section under tab
      | General | Main Address | Timeline |
    When user click on "Assets" tab
    Then user open "154967, 34 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" Form
    Then verify all tabs are appearing on the "Account Form" Form
      | Summary | Asset Information | Tenancy Information | Repair Cases | Rent Account | Related |
    And user click on Back button
    When user click on "Summary" tab
    Then verify all section under tab
      | Summary | ACCOUNT INFORMATION | ASSET INFORMATION | MAIN ADDRESS | CORRESPONDENCE ADDRESS | TIMELINE |
    When user click on "Repair Cases" tab
    When user click on "Related" tab

  @SchemeForm
  Scenario: TC28367_C8800 -Validation of Scheme Form
    When user click on "Schemes" under customer
    And user click on Drop Down List
    And user select "Default" from drop down list
    When user search "159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF" and click on contact name
    Then verify all tabs are appearing on the "Scheme Form" Form
      | General | Blocks | Assets | Repair Cases | Related |
    When user click on "General" tab
    Then verify all section under tab
      | General | Main Address | Timeline |
    When user click on "Blocks" tab
    When user click on "Assets" tab
    When user click on "Repair Cases" tab
    When user click on "Related" tab

  @HouseholdGroupForm
  Scenario: TC28279_C11542 -Validation of Household Group  Form
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user scroll down "GENERAL INFORMATION" in page
    Then user Scroll down to Account field and click on the address hyperlink
    Then user is navigated to "SHA Tenancy Management Account Form" form
    Then verify all tabs are appearing on the "Account Form" Form
      | Summary | Household Group Information | SMS Contact Information | SMS Tenancy Information | SMS Asset Information | Related |
    Then verify all section under tab
      | Summary | ACCOUNT INFORMATION | TIMELINE | Flags | MAIN ADDRESS | CORRESPONDENCE ADDRESS |
    When user click on "Household Group Information" tab
    Then verify all section under tab
      | Household Group Information | HOUSEHOLD GROUP DETAILS | HOUSEHOLD GROUP CONTACTS | ASSETS |
    Then user scroll down "HOUSEHOLD GROUP DETAILS" in page
    Then click on New Contact
    And user click on save and close button
    Then user scroll down "HOUSEHOLD GROUP DETAILS" in page
    Then click on New Account
    When user click on "SMS Contact Information" tab
    Then verify all section under tab
      | SMS Contact Information | CONTACT 1: GENERAL INFORMATION | CONTACT 2: GENERAL INFORMATION | CONTACT 1: MAIN ADDRESS | CONTACT 1: CORRESPONDENCE ADDRESS | CONTACT 2: CORRESPONDENCE ADDRESS |
    When user click on "SMS Tenancy Information" tab
    Then verify all section under tab
      | SMS Tenancy Information | Tenancy 1 | Tenancy 2 |
    When user click on "SMS Asset Information" tab
    Then verify all section under tab
      | SMS Asset Information | ASSET 1 DETAILS | ASSET 1 DETAILS |
    When user click on "Related" tab

  @AssetForm
  Scenario: TC28280_C8799 -Validation of Asset Form
    When user click on "Accounts" under customer
    And user click on Drop Down List
    And user select "Assets" from drop down list
    When user search "93960, 23 Odiham Drive, Speen, Newbury, Berkshire, RG14 1GA" and click on contact name
    Then verify all tabs are appearing on the "Account Form" Form
      | Summary | Asset Information | Tenancy Information | Repair Cases | Rent Account | Related |
    When user click on "Summary" tab
    Then verify all section under tab
      | Summary | ACCOUNT INFORMATION | ASSET INFORMATION | TIMELINE | Flags | MAIN ADDRESS | CORRESPONDENCE ADDRESS |
    When user click on "Asset Information" tab
    Then verify all section under tab
      | Asset Information | ASSET DETAILS | ASSET ADDRESS | Rent Account |
    When user click on "Tenancy Information" tab
    Then user open "Miss J Utting" Form
    And user click on save and close button
    When user click on "Repair Cases" tab
    When user click on "Rent Account" tab
    Then user open "House- 23 Odiham Drive, Newbury ,RG14 1GA" Form
    And user click on save and close button
    When user click on "Related" tab
    
    @CR38075 @Sprint13 @TC38459
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
      #| Tom Sproule  | East Admin Tenancy  |
      #| Roger Barnett   | West Admin Tenancy  |
      |Stefano Missiato|West Admin Tenancy|
      #| Liam Donald  | South Admin Tenancy |
      #| Laura Trim   | East Admin Tenancy  |

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
