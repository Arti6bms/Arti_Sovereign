@Queues @Tenancy
Feature: Testing of Queue in Tenancy Management

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
  
  @TC_28309
  Scenario: TC_28309-C8810-Validation of Working from a Queue
    Then user click on "Queues" under customer
    Then user Open "All Items" and "All Queues"
    Then user select a queue with multiple items
    Then user Select multiple items
    Then user click "Pick" on the top ribbon
    Then user click on Pick in new window
    Then user Validate that user name is showing in Worked By column
    Then user change the selection from "All Items" to "Items im working on"
    Then user verifies if items picked in this list are visible
    Then user select one of picked items
    And user will click "Release"
    Then user verifies released item is removed from "Items Im working on"
    Then user verifies that name has been removed from the "worked by" column in its original queue"<E and T>"
    Then user open the item in the original queue
    Then user updates the "Regarding" field with contact "Tester Test"
    Then user verifies the item is in the contact timeline

  ##Then user navigate back to the Queue and Select item and remove from queue
  #@TC_28309
  #Scenario: TC_28309-C8810-Validation of Working from a Queue
    #Then user click on "Queues" under customer
    #Then user Open "All Items" and "All Queues"
    #Then user select a queue with multiple items
    #Then user Select multiple items
    #Then user click "Pick" on the top ribbon
    #Then user click on Pick in new window
    #Then user Validate that user name is showing in Worked By column
    #Then user change the selection from "All Items" to "Items im working on"
    #Then user verifies if items picked in this list are visible
    #Then user select one of picked items
    #And user will click "Release"
    #Then user verifies released item is removed from "Items Im working on"
    #Then user verifies that name has been removed from the "worked by" column in its original queue"<East Housing Response>"
    #Then user open the item in the original queue
    #Then user updates the "Regarding" field with contact "Tester Test"
    #Then user verifies the item is in the contact timeline

  #Then user navigate back to the Queue and Select item and remove from queue