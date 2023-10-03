@CustomerEntity
Feature: Testing for Customer Entity in Tenancy Management

  @accountSearch
  Scenario Outline: TC28373_C8797 - Validation of Local/Quick Search for Accounts
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text
    
    Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Accounts | All Accounts | Davis Gregory;Davis Gregory Solicitors *;01242 235202 |

  @blockSearch
  Scenario Outline: TC28374_C8797 - Validation of Local/Quick Search for Blocks
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
   	#Then user is navigated to "Blocks Active Blocks - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Blocks | Active Blocks |   * Swindon* ; 1001* ; *Shared* |
      
      
  @neighborhoodsSearch
  Scenario Outline: TC28375_C8797 - Validation of Local/Quick Search for Neighborhoods
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Neighborhoods Active Neighborhoods - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Neighborhoods | Active Neighborhoods |* Princess Road * ; Abingdon * ; * Torquay  |
      
      
  @schemesSearch
  Scenario Outline: TC28377_C8797 - Validation of Local/Quick Search for Schemes
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Schemes Active Scheme's - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Schemes | Default |159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF ; * Roseland * |
      
      
  @contactsSearch
  Scenario Outline: TC28365_C8797 - Validation of Local/Quick Search for Contacts
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Contacts | All Contacts | Jamie Hines ; * Alan ; jalonhane8@sovereign.org.uk ; 44635703* |
      
      
  @dataProtectionSearch
  Scenario Outline: TC30413_C8797 - Validation of Local/Quick Search for Data Protection
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Data Protection Active Data Protection - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Data Protection | Active Data Protection | Data Protection for A Reidy on 29/06/2020 15:09 ; * Edmonds * ; *Abby * |
     
     @tenanciesSearch
  Scenario Outline: TC30411_C8797 - Validation of Local/Quick Search for Tenancies
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    #And user verify left side pane under customer
    When user click on "<Tab>" under customer
    #Then user is navigated to "Tenancies Active Tenancies - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub |  Tenancies | Active Tenancies | 87848, Flat 4 1 Glenmore Road, Salisbury, Wiltshire, SP1 3HF ; 9213842 ; 87848* ; * Fisher * | 
 
   @globalSearch
  Scenario Outline: TC28366_C8797 - Validation of Global Search with and without wild card search
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    Then user enter "<SearchText>" in global search text box and validate text

   Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Knowledge Article | Active Knowledge Article |Julie Utting ; *Smith ; 26844, 40 Prospect Road  |
      
     @US37599 @Sprint13
  @TC38080_TC38086
  Scenario Outline: US37599 of Sprint 11
  Given User navigates to CRM login page
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
      
      
      @US37599 @Sprint13
  Scenario Outline: TC38080_TC38086 of Sprint 11
  Given User navigates to CRM login page
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
