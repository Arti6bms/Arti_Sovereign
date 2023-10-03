@EmploymentTrainingRegressionTestNavigation
Feature: Testing of Navigation of Test Cases in Employment and Training Module

  Background: 
    Given User navigates to CRM login page
    When user selects App "Employment and Training"
    #Then user is navigated to "My Work Dashboard - Dynamics 365" page

  @TC23289
  Scenario: TC23289_C11746-Validation of E&T Hub View
    Then verify all tabs are appearing on the "My Work" Form
      | Dashboards | Activities | Queue Items |
    Then verify all tabs are appearing on the "Customer" Form
      | Contacts | Referrals |
    Then verify all tabs are appearing on the "Case Management" Form
      | Assessment | ET Case | Outcome |
    Then verify all tabs are appearing on the "Opportunities" Form
      | E & T Opportunity |
    Then verify all tabs are appearing on the "Marketing" Form
      | SMS Campaigns | Campaigns |
    Then verify all tabs are appearing on the "Templates" Form
      | Email Templates | Letter |

  @TC23291
  Scenario: TC23291_C11748-Validation of Search functionality in Employment and Training Hub - Quick Search/Local Search
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    Then user enter "*Charlotte Emms ; *Tester " in search text box and validate text
    When user click on "Assessment" under customer
    #Then user is navigated to "Assessments Active Assessments - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Assessments" from drop down list
    Then user enter "Jamie Hines ; Nathan*" in search text box and validate text
    When user click on "ET Case" under customer
    #Then user is navigated to "ET Cases Active Cases - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Cases" from drop down list
    Then user enter "Julie Utting ET Case ; * Kulkarni * " in search text box and validate text
    When user click on "E & T Opportunity" under customer
    #Then user is navigated to "E & T Opportunities Active E & T Opportunities - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active E & T Opportunities" from drop down list
    Then user enter "Adobe flash play; *Production* " in search text box and validate text
    
    @TC29919
  Scenario: TC29919_Validation of Global search functionality in Employment and Training Hub
    Then user enter "Julie Utting ; *Nathan " in global search text box and validate text
    
    
    
@CR14171 @Sprint13
  Scenario: TC34654 of Sprint 11
    When user click on "Contacts" under customer
    Then user navigate to "Active Contacts" view
    Then user select one of active Contact
    Then user enter the mobilephone which does not starts with 07 or +
    Then user validate the Alert message "Invalid Mobile Number. Mobile Number should start with 07 or + "
    Then user enter the mobilephone starting with 07 having greater than 11 numbers
    Then user validate the Alert message "Mobile number must be of 11 digits when begins with 07 with no Alphacharacters & Spaces."
    Then user enter the invalid mobilephone starting with +
    Then user validate the Alert message "Minimum mobile number length must be around 11 digits - they cannot be in excess of 15 digits with no alpha characters or spaces"
    

 