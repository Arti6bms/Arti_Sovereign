@CaseAutoRouting
Feature: Case Allocation: Validation of Cases Auto Routing of Category

  @TC28778
  Scenario: TC28778- Case Allocation: Validation of Case Auto Routing of Category = "Enforcement"
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "ASB"
    Then user enters description
    And user navigates to "Initial Victim Assessment"
    Then user answers all the questions
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Abandonment"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Estate Issues"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Eviction Income"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Squatters"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Financial Exclusion (Arreas, NOSP)"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Vehicles"
    Then user enters description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "<Housing Advice and Resolution Service>" from drop down
    Then user click on refresh button
    #Then user selects "Entered Queue" as "Sort newer to older"
    Then user click on refresh button
    
    
    #Then User validates the created case numbers in the selected Queue
    #@TC28778 Fraud
    #Scenario: TC28778- Case Allocation: Validation of Case Auto Routing of Category = "Enforcement" and subcategory="Fraud"
    #Given User navigates to CRM login page
    #When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Enforcement (legal)"
    Then user fill all the details for "Subcategory" as "Fraud"
    Then user fill details for "Fraud Case Category" as "Abandonments"
    Then user enters description
    And user click on save button

  #When user saves the case Number
  #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
  #Then Verify details in the Queue
  #| General | Related | Queue | Worked By | Entered Queue | Modified On |
  #Then Validate Queue as "Housing Advice and Resolution Service"
  #And user click on save and close button
  #Then user click on "Queues" under Service
  #And user click on Drop Down List
  #And user select "All Items" from drop down list
  #And user select "<Housing Advice and Resolution Service>" from drop down
  #Then user click on refresh button
  #Then user selects "Entered Queue" as "Sort newer to older"
  #Then user click on refresh button
  #Then User validates the created case numbers in the selected Queue
  
  
  @TC28779
  Scenario Outline: "<TCID>"- Case Allocation: Validation of Case Auto Routing of Category = "<Category>"
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list

    #And user select "<Housing Advice and Resolution Service>" from drop down
    #Then user click on refresh button
    #Then user selects "Entered Queue" as "Sort newer to older"
    #Then user click on refresh button
    #Then User validates the created case numbers in the selected Queue
    Examples: 
      | TCID    | Category            | SubCategory1 | SubCategory2     | SubCategory3                | SubCategory4                | SubCategory5    | SubCategory6       | SubCategory7      | SubCategory8 | SubCategory9        |
      | TC28779 | Building (Dwelling) | Adaptations  | Garden Condition | Property Condition Internal | Property Condition External | Service Charges | Boundary Enquiries | Estate Walkabouts | Keys & Fobs  | Estate Improvements |

  @TC28780_TC28781
  Scenario Outline: Case Allocation: Validation of Case Auto Routing of Category = "<Category>"
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    Then user navigates to "Case for Interactive experience" form
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user will select Category as "Customer"
    Then user fill all the details for "Subcategory" as "<SubCategory>"
    Then user click on save and continue button
    Then user enter description
    And user click on save button
    When user saves the case Number
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #Then user click on saveclose button
    And user click on save button
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "<Housing Advice and Resolution Service>" from drop down
    Then user click on refresh button

    #Then user selects "Entered Queue" as "Sort newer to older"
    #Then user click on refresh button
    #Then User validates the created case numbers in the selected Queue
    Examples: 
      | SubCategory       |
      | Complaints        |
      | Hoarding          |
      | Permissions       |
      | Transfer/Homehunt |
      | Safeguarding      |

  @TC28785
  Scenario Outline: "<TCID>"- Case Allocation: Validation of Case Auto Routing of Category = "<Category>"
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
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
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
    #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "Housing Advice and Resolution Service"
    #And user click on save and close button
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "<Housing Advice and Resolution Service>" from drop down
    Then user click on refresh button

    #Then user selects "Entered Queue" as "Sort newer to older"
    #Then user click on refresh button
    #Then User validates the created case numbers in the selected Queue
    Examples: 
      | TCID    | Category | SubCategory1 | SubCategory2 | SubCategory3                   | SubCategory4       | SubCategory5 | SubCategory6 | SubCategory7 | SubCategory8      | SubCategory9    |
      | TC28785 | Tenancy  | COVID-19     | FTT Review   | Joint to Sole (Tenancy Change) | Probationary Visit | Sign up      | SIV          | Succession   | Tenancy Extension | Tenancy General |

  @TC32315
  Scenario: Case Allocation: Validation of Case Auto Routing of Category = COVID-19 and Blank Region
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Emily Keylock"
    Then user fill all the details for "Category" as "Tenancy"
    Then user fill all the details for "Subcategory" as "COVID-19"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user click on More commands for Case button
    Then user click on "Queue Item Details"
    Then Verify details in the Queue
    | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "Housing Advice and Resolution Service"
    And user click on save and close button
  
  @TC_28816
  Scenario Outline: TC28816- Case Allocation: Validation of Case Auto Routing of Category = Lettings
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    Then user fill all the details for "Category" as "Lettings"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "East Lettings"
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    #Then Verify details in the Queue
      #| General | Related | Queue | Worked By | Entered Queue | Modified On |
    #Then Validate Queue as "East Lettings"
    #And user click on save and close button

    Examples: 
      | SubCategory1     |
      | Mutual Exchanges |
      | Garages          |
      | Decant           |

  @TC_28823
  Scenario Outline: TC28823 - Validation of Case Auto Routing of Category = Compliance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "<Customer>"
    Then user fill all the details for "Category" as "Compliance"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "<Route1>"
     And user clicks on "More commands for Case"
     And user clicks on "Queue Item Details"   
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "<Route1>"

    #And user click on save and close button
    Examples: 
      | Customer     | SubCategory1         | Route1                  |
      #| Anthony Hudd | Disced Gas           | West Housing Compliance |
      #| Anthony Hudd | Electrical           | West Housing Compliance |
      #| Anthony Hudd | FRA                  | West Housing Compliance |
      #| Anthony Hudd | Asbestos             | West Housing Compliance |
      #| Anthony Hudd | Gas                  | West Housing Compliance |
      #| Anthony Hudd | Lifts                | West Housing Compliance |
      | Anthony Hudd | Detection CO2/Smokes | West Housing Compliance |
      | Anthony Hudd | Damp and Mould       | West Housing Compliance |
      | Anthony Hudd | Repairs/Remedials    | West Housing Compliance |

  @TC_28823_1
  Scenario Outline: TC28823 - Validation of Case Auto Routing of Category = Compliance & SubCategory = PEEPs
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "<Customer>"
    Then user fill all the details for "Category" as "Compliance"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user selects "General Needs" in field "PEEPs Type"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "<Route1>"
    And user clicks on "More commands for Case"
    Then user click on "Queue Item Details"
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "<Route1>"

    #And user click on save and close button
    Examples: 
      | Customer          | SubCategory1 | Route1                   |
      | Jerrilee Shepherd | PEEPs        | East Housing Compliance  |
      | Liam Donald       | PEEPs        | South Housing Compliance |
      | Anthony Hudd      | PEEPs        | West Housing Compliance  |

  @TC_28828
  Scenario Outline: TC28828 - Case Allocation: Validation of Case Auto Routing of Category = Supported Housing
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Julie Utting"
    Then user fill all the details for "Category" as "Supported Housing"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "Housing Advice and Resolution Service"
      And user clicks on "More commands for Case"
     And user clicks on "Queue Item Details" 
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "<Housing Advice and Resolution Service>"
    And user click on save and close button

    Examples: 
      | SubCategory1             |
      | Mental Health Crisis     |
      | Move On                  |
      | Multiagency Meeting      |
      | Property Check           |
      | Support Provider Contact |
      | Weekly Meeting           |
      | Welfare Check            |

  @TC_28829
  Scenario Outline: TC28829 - Case Allocation: Validation of Case Auto Routing of Category = Housing for old people
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "Julie Utting"
    Then user fill all the details for "Category" as "Housing for Older People"
    Then user fill all the details for "Subcategory" as "<SubCategory1>"
    Then user enters description
    And user click on save button
    When user saves the case Number
    Then user verify the case Owner as "Housing Advice and Resolution Service"
    And user clicks on "More commands for Case"
    Then user click on "Queue Item Details"
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "<Housing Advice and Resolution Service>"
    #And user click on save and close button

    Examples: 
      | SubCategory1      |
      #| Pull Cord Testing |
      #| Rapid Resolution  |
      | Targeted Support  |
      | Welfare Check     |

      @TC29507_TC29508
    Scenario Outline: "<TCID>"- Case Allocation: Validation of blank asset, region route to Housing Intervention team
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Cases" under Service
    And user click on "New Case"
    And user click on Case Drop Down List
    And user select "Case for Interactive experience" from drop down list
    Then user fill all the details for "Customer" as "<Contact>"
    Then user fill all the details for "Category" as "Tenancy"
    Then user fill all the details for "Subcategory" as "Housing Intervention Team"
    Then user enters description
    And user click on save button
    When user saves the case Number    
     Then user verify the case Owner as "HIT Team"
     And user clicks on "More commands for Case"
     And user clicks on "Queue Item Details"     
    Then Validate Queue as "<HIT Team>"
    
    Examples: 
      | TCID    | Contact       |
      | TC29507 | Julie Maidens |
      | TC29508 | B Oliver      |
      
   @TC_34559_TC28812_TC28813_TC32301
  Scenario: TC_34559-US20120 : Validate  Additions options displayed in Category = Tenancy fields on Case Form
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
     When user click on "Cases" under customer
     And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Tenancy"
    And user fill all the details for "Subcategory" as "Housing Intervention Team"
    And user enters description
    And user click on save button
    Then user verifies "HIT Case Types" field exists
    Then user verifies "HIT Case Types" list values
      | Assessment | Intervention | Non Engagement |
    Then user verifies "Case Closure Reason" list values
      | No Intervention required | Case Changed to Intervention | Intervention Successful | Non Engagement | Tenancy Success Achieved | Further plan to be developed |
    When user click on "Cases" under customer
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Tenancy"
    And user fill all the details for "Subcategory" as "Tenancies at Risk"
    Then user verifies "Case Closure Reason" list values
      | Engaged | Risk Reduced | Non Engagement | Existing Case | Unsuitable Referral |
    And user enters description
    And user click on save button
    Then user verify the case Owner as "Tenancies at Risk"
    And user clicks on "More commands for Case"
    Then user click on "Queue Item Details"
    #And click on Vertical symbol "Case" of Queues and select "Queue Item Details"
    Then Verify details in the Queue
      | General | Related | Queue | Worked By | Entered Queue | Modified On |
    Then Validate Queue as "Tenancies at Risk"