@AutoRoutingTask
Feature: Testing of Auto Routing in Tenancy Management

  @AutoRoutingFunctionalityTask
  Scenario: TC28300_C10713-Validation of Tasks - Manual Routing
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name
    And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user enter Response Time and Description
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user marked as completed and task has been removed from the queue
    
     When user click on "Blocks" under customer
    And user click on Drop Down List
    And user select "Active Blocks" from drop down list
    When user search "100012, Block 34/36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" and click on contact name 
    And user click on plus icon on the timeline 
    And user select "Task" from timeline option
    Then user enter Response Time and Description
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user marked as completed and task has been removed from the queue
    
     When user click on "Schemes" under customer
    #Then user is navigated to "Schemes Active Scheme's - Dynamics 365" page
    And user click on Drop Down List
    And user select "Default" from drop down list
    When user search "159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF" and click on contact name 
    And user click on plus icon on the timeline 
     And user select "Task" from timeline option
    Then user enter Response Time and Description
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user marked as completed and task has been removed from the queue
    
     When user click on "Accounts" under customer
    #Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "Assets" from drop down list
    When user search "93960, 23 Odiham Drive, Speen, Newbury, Berkshire, RG14 1GA" and click on contact name 
    And user click on plus icon on the timeline 
    And user select "Task" from timeline option
    Then user enter Response Time and Description
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user marked as completed and task has been removed from the queue
    
     When user click on "Accounts" under customer
    #Then user is navigated to "Accounts Accounts Being Followed - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Accounts" from drop down list
    When user search "AMS Mortgages" and click on contact name
    And user click on plus icon on the timeline 
    And user select "Task" from timeline option
    Then user enter Response Time and Description
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user open task and marked as completed and task has been removed from the queue
        
     When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on Drop Down List
    And user select "Active Cases" from drop down list
    When user search "Adaptations, Julie Utting, 23 Odiham Drive, Newbury, RG14 1GA, CAS-1366258-D8S0P6" and click on contact name
   And user click on plus icon on the timeline
    And user select "Task" from timeline option
    Then user enter Response Time and Description
     And user Click on save and close
     And user open cases
    Then user click open activities and change owner name
    And user click on save button
    Then user click on three dots appearing top most right corner on the form
    And user select Assign from the top menu option
    And user select the Queue from the lookup
    And user click on save and close button
    When user click on "Queues" under customer
    #Then user is navigated to "Queue Items All Items - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Items" from drop down list
    And user marked as completed and task has been removed from the queue
    
    @TimelineFunctionality
    Scenario: TC28306_C11554-Validation of Timeline Functionality
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
     When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
   When user search "Jerrilee Shepherd" and click on contact name
     And user click on plus icon on the timeline
     And user select "Task" from timeline option
    Then user enter Response Time and Description
    And user click on save and close button
     Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
     And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
     Then user scroll down "Description" in page
    And user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    And user click on plus icon on the timeline
    And user select "Appointment" from timeline option
    Then user enter Subject
    And user click on save button
    And user click on Back button
    And user click on plus icon on the timeline
    And user select "E-mail" from timeline option
    Then user enter Subject
    And user click on save button
    And user click on Back button
    
    
    @NotesFunctionality
     Scenario: TC28302_C8807-Validation of Notes functionality
     Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
     When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "James Green" and click on contact name 
    Then user click on Enter Note
    And user enter note title
    And user enter text in main box
    Then user click on Add Note button
    Then user verify the note shows on the timeline
    
    #@TimelineExportFunctionality
    #Scenario: TC28307_C11560-Validation of Timeline Export
    #Given User navigates to CRM login page
    #When user selects App "Customer Service Hub"
     #When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    #And user click on Drop Down List
    #And user select "All Contacts" from drop down list
    #When user search "Jerrilee Shepherd" and click on contact name
     #Then user click on three dots appearing top most right corner on the form
     #And user select "Run Report" from the top menu option
     #Then user select Export Contact & Case Timeline option
     #And user validate all column name
     #|Type|Subject|Regarding|Relationship|Description|Owner|Created On|Created By|Status|Outcome|
       #And user verify print and save options
     #And user validate contact cases and note grid
     #And user validate all activities in report
     #|Phone Calls|Tasks|Notes|Letters|Emails|Appointments|
   
    
    
    
   
