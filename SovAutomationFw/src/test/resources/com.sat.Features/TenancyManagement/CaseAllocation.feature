@CaseAllocation
Feature: Validation of Cases functionality

  @TC28333
  Scenario: TC28333- C10718-Validation of Close the case
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Estate Issues"
    Then user enters description
    And user click on save button
    And user clicks on "More commands for Case"
    #Then Validate Owner as "Housing Advice and Resolution Service"
    And Assign Owner to "Me"
    And user clicks on "More Header Editable Fields" 
    Then Validate Owner as "Thangam K"
    And user clicks on "More commands for Case"
    And click on Vertical symbol "Case" of Queues and select "Resolve Case"
    When User enters details to Resolve Case
    Then User validates the text "Read-only This record’s status: Resolved"

  @TC28334
  Scenario: TC28334- C10719-Validation of Reactivate the case
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search "ASB, Jerrilee Shepherd, Flat 25 Odiham Drive, Newbury, RG14 1GA, CAS-1366131-W7L7K5"
    And user selects first record with status "Resolved"
    Then user click on "Reactivate Case"
    And user click on confirm button
    #Then User validates the text "Read-only This record’s status: Resolved" not present

  @TC28336
  Scenario: TC28336- C11555-Validation of Case Timeline
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search "ASB"
    And user selects first record with status "Resolved"
    Then user click on "Reactivate Case"
    And user click on confirm button
    Then User validates the text "Read-only This record’s status: Resolved" not present

  @TC28785
  Scenario Outline: C11555-Validation of Case Timeline
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory2>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory3>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory4>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory5>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory6>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory7>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory8>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "<Category>"
    Then user fill all the details for "Subcategory" as "<SubCategory9>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Owner as "Housing Advice and Resolution Service"
    And user click on save and close button
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "<Housing Advice and Resolution Service>" from drop down
    Then user click on refresh button
    Then user selects "Entered Queue" as "Sort newer to older"
    Then user click on refresh button
    Then User validates the created case numbers in the selected Queue 
    Examples:
      | TCID    | Category | SubCategory1 | SubCategory2     | SubCategory3                | SubCategory4                | SubCategory5    | SubCategory6       | SubCategory7      | SubCategory8 | SubCategory9        |
      | TC28785 | Tenancy  | COVID-19     | Garden Condition | Property Condition Internal | Property Condition External | Service Charges | Boundary Enquiries | Estate Walkabouts | Keys & Fobs  | Estate Improvements |

   @TC_37550 @TC37550 @TC37551 @TC37553 @TC37554
  Scenario: US22302 TC37550 TC37551 TC37553 TC37554
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user navigates to "Case for Interactive experience" form
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user will select Category as "Customer"
    Then user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enter description
    And user click on save button
    Then user verify the case Owner as "East Admin Tenancy"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user fill all the details for "Customer" as "Martin Bell"
    And user will select Category as "Customer"
    Then user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enter description
    And user click on save button
    Then user verify the case Owner as "West Admin Tenancy"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user fill all the details for "Customer" as "Liam Donald"
    And user will select Category as "Customer"
    Then user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enter description
    And user click on save button
    Then user verify the case Owner as "South Admin Tenancy"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user fill all the details for "Customer" as "Laura Trim"
    And user will select Category as "Customer"
    Then user fill all the details for "Subcategory" as "Assisted Gardening"
    Then user enter description
    And user click on save button
    Then user verify the case Owner as "East Admin Tenancy"
    
    @TC42734_TC42735_TC42736_TC42737_TC42738
    Scenario: US41097  Validate 'Retrofit' Option is displayed in Case Subcategory Field 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under customer
    And user click on "New Case"
    Then user fill all the details for "Customer" as "Liam Donald"
    Then user fill all the details for "Category" as "Building (Dwelling)"
    Then user fill all the details for "Subcategory" as "Retrofit"
    Then user verifies "Case Closure Reason" list values
      | Customer Refusal | Works Completed | None Access | Property not suitable | 
    And user fill all the details for "Case Closure Reason" as "Works Completed"
    Then user enter description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "Thangam K"
    And user clicks on "More commands for Case"
    Then user click on "Assign"
    Then user select "Assign To" as "User or team"
    Then user fill all the details for "User or team" as "Housing Advice and Resolution Service"
    Then user clicks on Assign button
    Then user verify the case Owner as "Housing Advice and Resolution Service"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "<Housing Advice and Resolution Service>" from drop down
    Then user selects "Entered Queue" as "Sort newer to older"
     Then user click on refresh button
    And select task with contact "Liam Donald"
    
    