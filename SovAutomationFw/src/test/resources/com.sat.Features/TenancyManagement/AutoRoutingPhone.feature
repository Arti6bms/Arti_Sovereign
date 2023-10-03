@AutoRoutingPhone
@Tenancy
Feature: Testing of Auto Routing in Tenancy Management

  @AutoRoutingFunctionalityPhone
  Scenario: TC28296_C8805,TC28297_C10712,TC28298_C11730
    #Scenario: TC28296_C8805-Validation of Phone Calls functionality from a Contact and Cases
    #Scenario: TC28296_C8805-Validation of Phone Calls functionality from a Contact
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name link
    
    #Direction=Outgoing
   Then user scroll down "GENERAL INFORMATION" in page
    And user clear text box
    And user click on save button
    And user enter your phone number "4324325358" in Mobile Phone field
    And user click on save button
    Then user click on phone symbol next to Mobile phone number
   Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
    And user Click on save and close
    #Then user scroll up in page
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
     #Direction=Incoming
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
   Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
    And user select direction "Incoming"
    And user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
    #Scenario: TC28296_C8805-Validation of Phone Calls functionality from a Case
    When user click on "Cases" under customer
    And user click on Drop Down List
    And user select "Active Cases" from drop down list
    #When user search ", Amanda Elkins, 5 Lynch Close, Blandford Forum, DT11 0JJ, CAS-763451-R4S9C5" and click on contact name link
    When user search "Abandonment, Darren Chissell, 20 Bovington Close, Poole, BH17 8AZ, CAS-508532-W8L5K1" and click on contact name link
   
   
    #Direction=Outgoing
    Then user scroll down "CASE DETAILS" in page
    And user enter your phone number "4324325358" in Mobile Phone field
    Then user click on phone symbol next to Mobile phone number
    Then user enter Subject
    Then user enter Phone Call Category,Description
    And user Click on save and close
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
     #Direction=Incoming
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
    And user select direction "Incoming"
   And user Click on save and close
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
   #Scenario: TC28298_C11730-Validate Phone Call functionality Form - Tick Boxes 
    When user click on "Accounts" under customer
    And user click on Drop Down List
    And user select "Assets" from drop down list
    When user search "93960, 23 Odiham Drive, Speen, Newbury, Berkshire, RG14 1GA" and click on contact name link
    #When user search "Abandonment, Darren Chissell, 20 Bovington Close, Poole, BH17 8AZ, CAS-508532-W8L5K1" and click on contact name link
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
    Then user scroll down "Description" in page
    And user select "First Time Resolution" check box
    And user select "Expression of Dissatisfaction" check box
    And user click on save and close button
    And Refresh the timeline and find the phone call activity
    
    When user click on "Contacts" under customer
    #Then user is navigated to "Contacts My Active Contacts - Dynamics 365" page
    And user click on Drop Down List
    And user select "All Contacts" from drop down list
    When user search "Jerrilee Shepherd" and click on contact name link
     And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
   Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
      Then user scroll down "Description" in page
    And user select "First Time Resolution" check box
    And user select "Expression of Dissatisfaction" check box
    And user click on save and close button
    And Refresh the timeline and find the phone call activity
    
   #Scenario: TC28297_C10712-Validation of Phone Calls functionality from Asset / Block / Scheme
  #Scenario: TC28297_C10712-Validation of Phone Calls functionality from Asset 
  When user click on "Accounts" under customer
    And user click on Drop Down List
    And user select "Assets" from drop down list
    When user search "93960, 23 Odiham Drive, Speen, Newbury, Berkshire, RG14 1GA" and click on contact name link
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    Then user enter Phone Call Category,Description,Regarding
     And user click on save button
    And user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
    
    #Scenario: TC28297_C10712-Validation of Phone Calls functionality from Block 
     When user click on "Blocks" under customer
    And user click on Drop Down List
    And user select "Active Blocks" from drop down list
    When user search "100012, Block Flat 34/Flat 36 Hoopers Walk, Longwell Green, Bristol, BS30 9DZ" and click on contact name link
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    And user enter Call To 
    Then user enter Phone Call Category,Description,Regarding
     And user click on save button
    And user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
     #Scenario: TC28297_C10712-Validation of Phone Calls functionality from Scheme
     When user click on "Schemes" under customer
    And user click on Drop Down List
    And user select "Default" from drop down list
    When user search "159172, Scheme Bints Place, Northmoor, Witney, Oxfordshire, OX29 5TF" and click on contact name link
    And user click on plus icon on the timeline 
    And user select "Phone Call" from timeline option
    Then user enter Subject
    And user enter Call To 
    Then user enter Phone Call Category,Description,Regarding
    And user enter Call To 
     And user click on save button
    And user click on save and close button
    Then user open your phone call activity and clicking on Mark Complete with the tick mark
    And user verify the activity has updated to "Closed" on the timeline
    
    
    
    
   

     
    
    
    