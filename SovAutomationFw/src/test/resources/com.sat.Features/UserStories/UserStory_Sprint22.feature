@UserStorySprint22
Feature: Testing of user stories

  Background: 
    Given User navigates to CRM login page

  @CR45319 @TC46453 @TC46481 @TC46471 @TC46491 @46487 @46480 @46475 @46485 @46468 @46492
  Scenario: CR45319-TC46453 of Sprint 22
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user fill all the details for "Customer" as "Liam Donald"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "ASB"
    Then user verifies "ASB Case Category" list values
      | Noise | Harassment / Intimidation | Damage to propery | Nuisance from vehicles | Supply and Production | Domestic Abuse | Physical Violence | ASB in communal areas | Prostitution / sexual acts | Other criminal behaviour | Substance Misuse related to ASB |
    Then user selects "Prostitution / sexual acts" in field "ASB Case Category"
    Then user verifies "ASB Type" list values
      | Voyeurism | Indecent behaviour | Use of property for illegal sexual activity |
    Then user selects "Substance Misuse related to ASB" in field "ASB Case Category"
    Then user verifies "ASB Type" list values
     |Class A|Class B|Class C|Cuckooing|County lines related|Cultivation|
     Then user selects "ASB in communal areas" in field "ASB Case Category"
    Then user verifies "ASB Type" list values
    |Dangerous activity|Other breach of tenancy|Problematic Rough sleeping|Problematic gatherings|
    Then user selects "Problematic gatherings" in field "ASB Type"
    Then user enter description
    And user click on save button
    Then user read Account Login Name
    When user click on "Summary" tab
    Then user selects "Substance Misuse related to ASB" in field "ASB Case Category"
    Then user selects "Class A" in field "ASB Type"
    And user click on save button
    When user click on "Summary" tab
    Then user selects "Supply and Production" in field "ASB Case Category"
    Then user selects "Dealing" in field "ASB Type"
    And user click on save button
    And user click on  Advanced Find option From the tool bar
    Then user select Look for field "Cases" under Advanced Find
    Then user click on select in Advanced find to select "category"
    #Then user click on select in Advanced find to select "subcategory"
    #Then user click on select in Advanced find to select "asbcasecategory"
    #Then user select Use Saved View field under Advanced Find for "Case Risk Audit - Active Cases"
    #Then user click on Results under Advanced Find
     
