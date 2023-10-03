@ContractsReferrals_ET
Feature: Testing of ContractsReferrals

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"

  #Then user is navigated to "My Work Dashboard - Dynamics 365" page
  @TC_23293
  Scenario: TC_23293-C11479-validation of default contact form - Employment and Training
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user search Existing contact name
    Then user select Existing contact name in contact form
    Then user validates the "Contact Type" as "Existing Contact"
    Then user validates form type as "Contact (Resident Form)"
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user search New contact name
    Then user select New contact name in contact form
    Then user validates the "Contact Type" as "New Contact"
    Then user validates form type as "Contact (Non Resident/Partner Form)"

  @TC_23296
  Scenario: TC_23296-C11753-Validation of creating a task from 'Employment and Training'
    When user click on "Contacts" under customer
    Then user navigate to "All Contacts" view
    Then user search Existing contact name
    Then user select Existing contact name in contact form
    Then user Click the + on the timeline and select "Task Activity"
    Then user select "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on "Save and Close"
    Then user Reopen the "Task" from the timeline
    Then user click on "Assign"
    Then user select "Assign To" as "User or team"
    Then user fill all the details for "User or team" as "E and T"
    Then user clicks on Assign button
    Then user clicks on More Header Fields
    Then user validates "Owner" as "E and T" in "More Header Fields"
    Then user click on "Mark Complete"
    Then user verifies if "Task" is closed
    
    
   #tescase does not have below steps
    #Then user Click the + on the timeline and select "Task Activity"
    #Then user select "Task Category" as "Communities"
    #Then user select "Task Sub-Category" as "Employment & Training"
    #Then user select "Response Time" as "Routine (5 Working Days)"
    #And user enters description
    #And user Click on save and close
    #Then user clicks on More Header Fields
    #Then user validates "Owner" as "E and T" in "More Header Fields"

  @TC_23294
  Scenario: TC_23294-C11750-Validation of creation of New Contact
    When user click on "Contacts" under customer
    Then user creates the new contact
    Then user validates form type as "Contact (Non Resident/Partner Form)"
    Then user validate the "Contact Details" section for below fields
      | Title | First Name | Last Name | Email | Telephone (Home) | Telephone (Mobile) | Contact Type | Contact Preferences | ET Customer Type | URN | Alert Flag |
    Then user validate the "Pre Applicant Details" section for below fields
      | Street 1 | Street 2 | Street 3 | City | Town | Post Code | Country | County | Local Authority Home | Date of Birth | Age | Gender | National Insurance Number | Income | Employment Status | Employer Local Authority | Ethnicity | Preferred Language | Religion | Sexuality |
    Then user verifies "Ethnicity" list values
      | Arab | Asian or Asian British - Bangladeshi | Asian or Asian  British - Indian | Asian or Asian British - Other | Asian or Asian British - Pakistan | Black or Black British - African | Black or Black British - Caribbean | Black or Black British - other | Chinese | Gypsy Romany Irish | Mixed - Other | Mixed - white & Asian | Mixed White & Black African | Mixed- white & Black Caribbean |
    Then user verifies "Preferred Language" list values
      | Albanian | Amharic | Arabic | Bengali | Cantonese | Chinese Cantonese | chinese Hakka | chinese Mandarian | Croatian | Czech | English | Farsi | French | German | Greek | Gujarati | Hindi | Italian | Kurdish | Latvian | Mandarin | Other | Polish | Portugese | Punjabi | Romanian | Russian | Sebian | Somali | Spanish | Tamil | Turkish | Urdu | Vietnamese |
    Then user verifies "Religion" list values
      | Baha'i | Buddhism | Catholic | Christian | Confucianism | Daoism | Hinduism | Islam | Jainism | Judaism | None | Other | Question Refused | Rastafarianism | Scientology | Shinto | Sikhism | Zoroastrian/Parsi |
    Then user verifies "Sexuality" list values
      | Asexual | Bisexual | Heterosexual | Homosexual | Pan-sexual | Prefer not to say |
    Then user validate the "MARKETING" section for below fields
      | Communities GDPR Consent |
    Then user fills all the fields in Contact Details Section
    Then user fills all the fields in Pre Applicant Details Section
#
  @TC_23295
  Scenario: TC_23295-C11752-Validation of creation of New referral form
    When user click on "Referrals" under customer
    Then user select one of active Referral items "xyz" and read the Contact details
    Then user click on "Referrals" from "More Tabs" option
    Then user clicks on "New Referral. Add New Referral"
    Then user verifies "Reason for Referral" list values
      | Find Work | Better Work | Access Training | Work Placement | Build Confidence for Work | Business Start Up | Money and Digital |
    Then user selects "Reason for Referral" as "Find Work"
    Then user enters value as "TEST" in "Additional Information"
    And user click on save button
    Then user validates the following fields are mapped from contact
    |Email|ContactNumber|Person Reference|Postcode|
#
  @TC23297
  Scenario: TC23297_C11754-Validation of Creation of  a Phone Call - Employment and Training
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Julie Utting" and click on contact name
    And user click on plus icon on the timeline
    And user select "Phone Call" from timeline option
    Then user enter Subject
    Then user fill details for "Phone Call Category" as "Finance"
    And user enters description
    And user Click on save and close
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline

 

    @US37502 @Sprint13
  Scenario: US37502 of Sprint 11
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
    
    
    @CR30958 @TC37702 @TC37704 @TC37701 @TC38125
  Scenario Outline: CR30958 of Sprint 12
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
    
    @US37502 @Sprint13
  Scenario: US37502 of Sprint 11
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
    