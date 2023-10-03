@CustomerSearch
Feature: Testing for Customer Entity in Tenancy Management

  @accountSearch
  Scenario Outline: TC28373_C8797 - Validation of Local/Quick Search for Accounts
    Given User navigates to CRM login page
    When user selects App "<App_Name>"
    Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    And user verify left side pane under customer
    When user click on "<Tab>" under customer
    Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "<Options>" from drop down list
    Then user enter "<SearchText>" in search text box and validate text
    Then user click on Blocks entity and verify local search
      | * Swindon* | 1001* | *Shared* |
    Then user click on Neighborhoods entity and verify local search
      | * Princess Road * | 12 Tanners Close | Abingdon * | * Torquay |
    Then user click on Schemes entity and verify local search
      | 159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF | * Roseland * | *172 | BA1* |
    Then user click on Contacts entity and verify local search
      | Jamie Hines | * Alan | jalonhane8@sovereign.org.uk | 44635703* |
    Then user click on Data Protection entity and verify local search
      | Data Protection for A Reidy on 29/06/2020 15:09 | * Edmonds * | *Abby * |
    Then user click on Tenancies and verify local search
      | 87848, Flat 4 1 Glenmore Road, Salisbury, Wiltshire, SP1 3HF | 9213842 | 87848* | * Fisher * |

    
    Examples: 
      | App_Name             | Tab      | Options      | SearchText                                            |
      | Customer Service Hub | Accounts | All Accounts | Davis Gregory;Davis Gregory Solicitors *;01242 235202 |
