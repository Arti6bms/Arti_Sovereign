@BlockSchemeCases
@Tenancy
Feature: Testing of Block&Scheme Cases in Tenancy Management

  Scenario: TC28327_C11722 and TC28328_C11723
  #Scenario: TC28327_C11722 Validation of creating a case against a Block
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on New Cases
    Then user scroll down "CASE DETAILS" in page
    And user fill all the details for "Block" as "100012, Block 34/36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ"
    Then user verify the Customer as "Block & Scheme Case Contact"
    Then Validate the fields have been hidden from the case form
      | Home Phone | Mobile Phone | Mobile Phone 2 | Work Phone | Email | Main Tenancy Start Date |
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Estate Issues"
    And user enters description
    And user click on save button
    #Then user validate the case title
      #| Estate Issues | 100012, Block Flat 34/Flat 36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ |
    Then user validate case Owner as "Housing Advice and Resolution Service"
  #Scenario: TC28328_C11723-Validation of Creation of a case against a Scheme  
    When user click on "Cases" under customer
    And user click on New Cases
    Then user scroll down "CASE DETAILS" in page
    And user fill all the details for "Scheme" as "10000, *Disposed* 69 Moorfields Road, Bath, BA2 2HP"
    Then user verify the Customer as "Block & Scheme Case Contact"
    Then Validate the fields have been hidden from the case form
      | Home Phone | Mobile Phone | Mobile Phone 2 | Work Phone | Email | Main Tenancy Start Date |
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "Estate Issues"
    And user enters description
    And user click on save button
    #Then user validate the case title
      #| Estate Issues | 10000, *Disposed* 69 Moorfields Road, Bath, BA2 2HP |
    Then user validate case Owner as "Housing Advice and Resolution Service"