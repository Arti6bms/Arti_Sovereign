Feature: Testing Login Functionality

@loginShau
  Scenario: Test CRM Login with valid credentials
    Given User navigates to CRM login page
    When user enters valid username "TP_HCLPO-AK@sovereign.org.uk"
    And Click on Next button
    When user enter valid password "Sov3rdPartyAccount!"
    And click on signin
    And Click on yes
    Then user is navigated to "Apps - Dynamics 365" page

  Scenario Outline: Test navigation for Tenancy Management
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page

    Examples: 
      | App_Name             |
      | Customer Service Hub |
