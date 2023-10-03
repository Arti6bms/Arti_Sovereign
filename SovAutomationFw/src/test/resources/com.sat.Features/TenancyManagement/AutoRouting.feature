@AutoRouting
Feature: Task Allocation: Validation of Tasks Auto Routing of Category

  @TC28926
  Scenario: TC28926 -Task Allocation: Validation of Tasks Auto Routing of Category = Sales and Marketing
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Sales and Marketing" and Sub Category "Sales and Marketing"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Sovereign Living"
    Then user validate the Queue Item Details "New Build Shared Ownership"

  @TC28927_TC29203
  Scenario: TC28927_TC29203- Task Allocation: Validation of Tasks Auto Routing Category = Home Ownership
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Home Ownership" and Sub Category "Resales"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Resales"
    Then user validate the Queue Item Details "Resales"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Home Ownership" and Sub Category "Resales & Staircasing Consultants"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Resales"
    Then user validate the Queue Item Details "Resales / Staircasing Consultants"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Home Ownership" and Sub Category "Staircasing"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Resales"
    Then user validate the Queue Item Details "Staircasing"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Home Ownership" and Sub Category "Home Ownership"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Resales"
    Then user validate the Queue Item Details "Home Ownership"

  @TC28930
  Scenario: TC28930- Task Allocation: Validation of Tasks Auto Routing of Category = "Customer Contact"
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Customer Contact" and Sub Category "Customer Contact Admin"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Customer Contact Admin"
    Then user validate the Queue Item Details "Customer Contact Admin"

  #And click on Vertical symbol "Task" of Queues and select "Queue Item Details"
  #Then Verify details in the Queue
  #| General | Related | Queue | Worked By | Entered Queue | Modified On |
  #And click on queue and validate details in the queue
  #| <Customer Contact Admin> | SUMMARY | QUEUE ITEMS | EMAIL SETTINGS | MEMBERS | RECORD CREATION AND UPDATE RULES |
  @TC28931
  Scenario: TC28931- Task Allocation: Validation of Tasks Auto Routing Category = Market Rent
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Market Rent" and Sub Category "Market Rent"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Market Rent"
    Then user validate the Queue Item Details "Market Rent"

  #And click on Vertical symbol "Task" of Queues and select "Queue Item Details"
  #Then Verify details in the Queue
  #| General | Related | Queue | Worked By | Entered Queue | Modified On |
  #And click on queue and validate details in the queue
  #| <Market Rent> | SUMMARY | QUEUE ITEMS | EMAIL SETTINGS | MEMBERS | RECORD CREATION AND UPDATE RULES |
  @TC28933
  Scenario: TC28933-Task Allocation: Validation of Task Auto Routing of Category = "Out Of Hours"
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Out Of Hours" and Sub Category "Out of Hours / Care Alarm"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Out Of Hours"
    Then user validate the Queue Item Details "Out Of Hours"

  #And click on Vertical symbol "Task" of Queues and select "Queue Item Details"
  #Then Verify details in the Queue
  #| General | Related | Queue | Worked By | Entered Queue | Modified On |
  #And click on queue and validate details in the queue
  #| <Out Of Hours> | SUMMARY | QUEUE ITEMS | EMAIL SETTINGS | MEMBERS | RECORD CREATION AND UPDATE RULES |
  @TC29005
  Scenario: TC29005-Task Allocation: Validation of Tasks Auto routing of Category = Income & Sub Category = Rent Card
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "Rent Card"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Income Admin"
    Then user validate the Queue Item Details "Income Admin"

  @TC29006
  Scenario: TC29006-Task Allocation: Validation of Tasks Auto routing of Category = Income & Sub Category = Rent Statement
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "Rent Statement"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Income Admin"
    Then user validate the Queue Item Details "Income Admin"

  @TC28983_TC28993_TC32173
  Scenario Outline: <TCID>: Task Allocation: Validation of Tasks Auto routing of Category = Income & Sub Category = <Sub Category>
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jodie Edwards" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Berkshire Income"
    Then user validate the Queue Item Details "Berkshire Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jemima Hitch" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Hampshire Income"
    Then user validate the Queue Item Details "Hampshire Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Paul Hampson" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Oxfordshire Income"
    Then user validate the Queue Item Details "Oxfordshire Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Hollie Smith-Bishton" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "West of England Income"
    Then user validate the Queue Item Details "West of England Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Amy Alice Solly" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Blandford Income"
    Then user validate the Queue Item Details "Blandford Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Anne-Marie Kennedy" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Devon Income"
    Then user validate the Queue Item Details "Devon Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Matthew James Bronsdon" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Christchurch Income"
    Then user validate the Queue Item Details "Christchurch Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Bianka Reilly" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "IOW & Hythe Income"
    Then user validate the Queue Item Details "IOW & Hythe Income"

    Examples: 
      | TCID    | Sub Category           |
      | TC28983 | Account                |
      | TC28993 | Arrangement            |
      | TC32173 | Benefit Advice/Support |

  @TC29004
  Scenario Outline: "<TCID>": Task Allocation: Validation of Tasks Auto routing of Category = Income & Sub Category = <Sub Category>
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    #Then user is navigated to "Accounts Accounts Being followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jade Buchanan" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Rents Team Newbury"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Amy Alice Solly" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Blandford Income"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Anne-Marie Kennedy" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Devon Income"
    When user click on "Contacts" under customer
    #Then user is navigated to "Accounts Accounts Being followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Matthew James Bronsdon" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Christchurch Income"
    When user click on "Contacts" under customer
    #Then user is navigated to "Accounts Accounts Being followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Bianka Reilly" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Income" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "IOW & Hythe Income"

    Examples: 
      | TCID    | Sub Category |
      | TC29004 | Direct Debit |

  @TC29019_TC29021_TC29022_TC29506_TC29034_TC29035_TC29036_TC29037
  Scenario Outline: "<TCID>" -Task Allocation: Validation of Tasks Auto routing of Category = <Category> & Sub Category = <Sub Category>
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact1>" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "<Category>" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route1>"
    Then user validate the Queue Item Details "<Route1>"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact2>" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "<Category>" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route2>"
    Then user validate the Queue Item Details "<Route2>"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact3>" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "<Category>" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route3>"
    Then user validate the Queue Item Details "<Route3>"

    Examples: 
      | TCID    | Category           | Sub Category              | Contact1     | Contact2     | Contact3    | Route1                                | Route2                                | Route3                                |
      | TC29019 | Housing Management | Housing                   | Julie Utting | Anthony Hudd | Liam Donald | Housing Advice and Resolution Service | Housing Advice and Resolution Service | Housing Advice and Resolution Service |
      | TC29021 | Housing Management | Safeguarding              | Julie Utting | Anthony Hudd | Liam Donald | East Safeguarding                     | West Safeguarding                     | South Safeguarding                    |
      | TC29022 | Housing Management | Anti-Social Behaviour     | Julie Utting | Anthony Hudd | Liam Donald | Housing Advice and Resolution Service | Housing Advice and Resolution Service | Housing Advice and Resolution Service |
      | TC29506 | Housing Management | Housing Intervention Team | Julie Utting | Anthony Hudd | Liam Donald | HIT Team                              | HIT Team                              | HIT Team                              |
      | TC29034 | Lettings           | Decant                    | Julie Utting | Anthony Hudd | Liam Donald | East Lettings                         | West Lettings                         | South Lettings                        |
      | TC29035 | Lettings           | Garages                   | Julie Utting | Anthony Hudd | Liam Donald | East Garages                          | West Garages                          | South Garages                         |
      | TC29036 | Lettings           | Lettings Query            | Julie Utting | Anthony Hudd | Liam Donald | East Lettings                         | West Lettings                         | South Lettings                        |
      | TC29037 | Lettings           | Mutual Exchange           | Julie Utting | Anthony Hudd | Liam Donald | East Mutual Exchange                  | West Mutual Exchange                  | South Mutual Exchange                 |

  @TC29020
  Scenario: TC29020 -Task Allocation: Validation of Tasks Auto routing of Category = Housing Management & Sub Category = Supported
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    # Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Julie Utting" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Housing Management" and Sub Category "Supported"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "Supported Housing"
    Then user validate the Queue Item Details "Supported Housing"

  @TC32174_TC32175_TC32176
  Scenario Outline: "<TCID>" -Task Allocation: Validation of Tasks Auto routing of Category = <Category> & Sub Category = <Sub Category>
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    # Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "<Category>" and Sub Category "<Sub Category>"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | TCID    | Category | Sub Category            | Contact           | Route                   |
      | TC32174 | Income   | Former Tenant Arrears   | Julie Utting      | Former Tenant Arrears   |
      | TC32175 | Income   | Garages                 | Liam Donald       | Income Admin            |
      | TC32175 | Income   | Admin                   | Liam Donald       | Income Admin            |
      | TC32175 | Income   | Refunds                 | Liam Donald       | Income Admin            |
      | TC32176 | Income   | Tenancy Support Adviser | Jerrilee Shepherd | Tenancy Support Adviser |

  @TC29056
  Scenario: TC29056 -Task Allocation: Validation of Tasks Auto routing of Category = Finance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Finance" and Sub Category "Service Charge"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
	  And user search for the task title
    Then verify the task is routed to "Service Charges"
    Then user validate the Queue Item Details "Service Charges"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Anthony Hudd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Finance" and Sub Category "Missing Payment"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "Rents Team Christchurch"
    Then user validate the Queue Item Details "Rents Team Christchurch"
    #When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    #And user click on Drop Down List
    #And user select "All Contacts" from drop down list
    #When user search "Julie Utting" and click on contact name link
    #Then user click on Create Time line and select "Task"
    #And select Task category "Finance" and Sub Category "Former Tenant Arrears"
    #Then user enter description
    #And user click on save and close button
    #Then User stores the current date and time "Asia/Kolkata"
    #Then user click on "Queues" under Service
    #And user click on Drop Down List
    #And user select "All Items" from drop down list
    #Then user click on refresh button
    #Then user selects "Entered Queue" as "Sort newer to older"
    #Then user click on refresh button
    #And select task with contact "Julie Utting"
    #Then verify the task is routed to "Former Tenant Arrears"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Finance" and Sub Category "Recharges"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "Accounts Receivable"
    Then user validate the Queue Item Details "Accounts Receivable"

  @TC29063
  Scenario: TC29063 -Task Allocation: Validation of Tasks Auto routing of Category = Compliants
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    # Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Complaints" and Sub Category "New Complaint"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Complaints"
    Then user validate the Queue Item Details "Complaints"
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Complaints" and Sub Category "Existing Complaint"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Complaints"
    Then user validate the Queue Item Details "Complaints"

  @TC29064
  Scenario: TC29064 -Task Allocation: Validation of Tasks Auto routing of Category = Other Departments
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Other Departments" and Sub Category "Query"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Customer Contact Admin"
    Then user validate the Queue Item Details "Customer Contact Admin"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Other Departments" and Sub Category "Accident Report Line"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "Customer Contact Admin"
    Then user validate the Queue Item Details "Customer Contact Admin"

  @TC28301
  Scenario: TC28301 - C10714-Validation of Tasks - Reassign
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Other Departments" and Sub Category "Accident Report Line"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    Then user enter description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then user click on "Assign"
    Then user clicks on Assign button

  #When user select a queue filter "<Sovereign Sales>"
  #
  #
  #Then user click on three dots appearing top most right corner on the form
  #And user select Assign from the top menu option
  #
  #And select task with contact "Jerrilee Shepherd"
  #Then verify the task is routed to "Sovereign Living"
  #And click on Vertical symbol "Contact" of Queues and select "Queue Item Details"
  #Then user selects "Entered Queue" as "Sort newer to older"
  #When user filters "Type" as "Filter By" with "Task"
  @TC34565 @TC34558 @TC32299
  Scenario: TC34565 TC34558
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    Then user click on Create Time line and select "Task"
    And select Task category "Housing Management" and Sub Category "Housing Intervention Team"
    Then user enter description
    Then user select "Response Time" as "Routine (5 Working Days)"
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    And user search for the task title
    Then verify the task is routed to "HIT Team"
    Then user validate the Queue Item Details "HIT Team"

  @TC_29102
  Scenario Outline: TC29102 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Electrical Supervisor"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact        | Route                       |
      | Scott Sillence | East Electrical Supervisor  |
      | Jonathan Snook | South Electrical Supervisor |
      | Anthony Hudd   | West Electrical Supervisor  |

  @TC_29103
  Scenario Outline: TC29103 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Property Projects"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact        | Route                   |
      | Scott Sillence | East Property Projects  |
      | Jonathan Snook | South Property Projects |
      | Anthony Hudd   | West Property Projects  |

  @TC_29105_TC29106_TC29107
  Scenario Outline: TC29105,TC29106 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "<SubCategory1>"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact            | SubCategory1        | Route                |
      | Scott Sillence     | Grounds Maintenance | Grounds Maintenance  |
      | Jonathan Snook     | Defects             | Works In Defect      |
      | Scott Sillence     | Scheduling          | Hampshire Scheduling |
      | Jonathan Snook     | Scheduling          | Dorset Scheduling    |
      | Anthony Hudd       | Scheduling          | West Scheduling      |
      | Anne-Marie Kennedy | Scheduling          | Devon Scheduling     |
      | Bianka Reilly      | Scheduling          | IOW Scheduling       |

  @TC29108
  Scenario Outline: TC29108 : Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Empty Homes"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact            | Route             |
      | Scott Sillence     | East Empty Homes  |
      | Jonathan Snook     | South Empty Homes |
      | Anthony Hudd       | West Empty Home   |
      | Anne-Marie Kennedy | Devon Empty Homes |
      | Bianka Reilly      | IOW Empty Homes   |

  @TC29109
  Scenario Outline: TC29109 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Planned Works"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact            | Route               |
      | Scott Sillence     | East Planned Works  |
      | Jonathan Snook     | South Planned Works |
      | Anthony Hudd       | West Planned Works  |
      | Anne-Marie Kennedy | Devon Planned Works |
      | Bianka Reilly      | IOW Planned Works   |

  @TC29110
  Scenario Outline: TC29110 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Gas Supervisor"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact        | Route                |
      | Scott Sillence | North Gas Supervisor |
      | Jonathan Snook | South Gas Supervisor |

  @TC29111
  Scenario Outline: TC29111 - Validation of Task Auto Routing of Category = Repairs and Maintenance
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "<Contact>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Gas"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user read the Task title
    Then User stores the current date and time "Asia/Kolkata"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user select "All Queues" from drop down
    #Then user selects "Entered Queue" as "Sort newer to older"
    And user search for the task title
    Then verify the task is routed to "<Route>"
    Then user validate the Queue Item Details "<Route>"

    Examples: 
      | Contact        | Route                |
      | Jonathan Snook | South Gas Scheduling |
      | Scott Sillence | North Gas Scheduling |

  @Localities @TC42307 @TC42308 @TC42309 @TC42310 @TC42311 @TC42312 @TC42313 @TC42314 @TC42315
  Scenario Outline: Localities positive scenarios
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    When user search "<ContactName>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Property Manager"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user validate the Queue Item Details "<Locality>"
    And user clicks on locality queue "<Locality>"
    Then user select the queue from the QUEUE ITEMS section
    Then user click "Pick" on the top ribbon
    Then user click on Pick in new window
    #Then user Validate that user name is showing in Worked By column for localities
    Then user select the queue from the QUEUE ITEMS section
    Then user select the queue from the QUEUE ITEMS section
    Then user clicks on "More commands for Queue Item"
    And user will click "Release"

    Examples: 
      | ContactName    | Locality   |
      #| Julie Utting     | Locality1  |
      #| Amanda Batchelor | Locality2  |
      #| Amanda Atkinson  | Locality3  |
      #| Liam Donaldson   | Locality4  |
      #| Zyiah Nurse      | Locality5  |
      #| Zygmunt Piec     | Locality6  |
      #| Eira Smith       | Locality7  |
      #| Andrew Mugford   | Locality8  |
      #| Jamie Stilwell   | Locality9  |
      #| Charlotte Ray    | Locality10 |
      | Nina McGowan   | Locality1  |
      | Tina Gardner   | Locality2  |
      | Dennis Rogers  | Locality3  |
      | Ziya Yamusak   | Locality4  |
      | Pat Randles    | Locality5  |
      | Amanda Allen   | Locality6  |
      | Lelia Pryor    | Locality7  |
      | Peter Marriott | Locality8  |
      | Harley Bright  | Locality9  |
      | Lourdes Prado  | Locality10 |

  @Localities1
  Scenario Outline: Localities Negative scenarios
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    When user search "<ContactName>" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user fill details for "Task Category" as "Repairs and Maintenance"
    Then user fill details for "Task Sub-Category" as "Property Manager"
    Then user fill details for "Response Time" as "Routine (5 Working Days)"
    And user enters description
    And user click on save button
    Then user validate the Queue is not set as "<Locality>"

    Examples: 
      | ContactName    | Locality  |
      | James Vass     | Locality1 |
      | George Hatcher | Locality1 |

  @LoclityColumns @TC41406_TC41931_TC41933_TC41935_TC41937_TC41939_TC41941_TC41943_TC41945_TC41947
  Scenario Outline: US40487- Validate the list of columns are displayed in Locality Queue View
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Queues" under Service
    And user click on Drop Down List
    And user select "Locality Queue" from drop down list
    And user select "<Locality>" from drop down
    And user validate all column name in Queue
      | Title | Type | Worked By | Regarding (Object) | Created On | Entered Queue | Description (Object) | SLA on Target (Object) | Queue | Locality Number (Account) | Locality Name (Account) |

    Examples: 
      | Locality     |
      | <Locality1>  |
      | <Locality2>  |
      | <Locality3>  |
      | <Locality4>  |
      | <Locality5>  |
      | <Locality6>  |
      | <Locality7>  |
      | <Locality8>  |
      | <Locality9>  |
      | <Locality10> |
