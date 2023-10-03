@Neighborhoods
@Tenancy
Feature: Testing of Neighborhoods in Tenancy Management

  @Neighborhood1
  Scenario: TC_28343-32347-C8829-Validation of View & Edit a Neighborhood
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    #Then user verifies following fields are mandatory
      #| Name | Owner | Walkabout Frequency | Region |
    #Then user updates the "Owner"     
    Then user verifies neighborhood frequency
      | 1 week | 1 Month | 3 Month | 6 Months | 9 Months | 12 Months | 60 Months |90 Months|
    Then user verifies the field "Region"
      | East | West | South |Supported | HOPs | Homeownership | Zone 1 | Zone 2 | Zone 3 | Zone 4 | Zone 5 | Zone 6 | Zone 7 | Zone 8 | Archive |
    Then user click on "Save"
    When user click on "Assets" tab
    #Then user validate assets linked to that neighborhood

  @Neighborhood
  @TC_28344
  Scenario: TC_28344-C8830-Validation of Walkabout Appointments
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
     Then user Save the appointment    
    Then user Reopen the "appointment" from the timeline
    Then user Validate that the following fields are auto populated
      | Regarding | Duration | Is Appointment Fixed Time = 0 | All day event= 0 | VIP=0 |
    #Then enter anything in the description box
    Then user try to mark the appointment as close
    Then user provide the Walkabout Rating and mark the appointment complete
    Then user verifies if "Appointment" is closed

  @Neighborhood33
 	@TC_28345
  Scenario: TC_28345-C8831-Validation of Link Cases
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Cases" under customer
    Then user navigate to "Active Cases" view
    Then user select one of active Case items
    Then user selects "Originating Neighbourhood"
    Then user Save the case
    Then user clicks the "Originating Neighbourhood"
    Then user clicks "Related" Tab for selecting "Cases"
    Then user navigate to "Active Cases" view
    Then user validates that the case linked to walkabout is showing in the grid
    
    @US37859 @TC39574_TC39587_TC40094_TC39602_TC39585_TC40097_TC39629_TC39634_TC39627_TC39631
  Scenario: Validate Neighborhood Item Audit Record is displayed
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user enter "1 Month" in "Walkabout Frequency" text box
    Then user enter "3" in "Rating" text box
    And user enter "South" in "Region" text box
    Then user click on "Save"
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the appointment
    Then user Reopen the "appointment" from the timeline
    Then user provide the Walkabout Rating and mark the appointment complete
    And user click on Tab "Related" for selecting "NeighbourhoodItemAudit"
    Then user sort the records from newer to older
    Then user selects first record
    Then user click on "Edit" button
    Then user validate "Rating" field is display
    Then user validate "Walkabout Frequency" field is display
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find of NeighbourhoodItemAudit
    Then user select Use Saved View field under Advanced Find for "Active NeighbourhoodAudit"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Name (NeighbourhoodName) | NeighbourhoodName | Rating | Walkabout Frequency | Modified On(Neighbourhood) | Modified By(Neighbourhood) | Created On (NeighbourhoodName) | Created By (NeighbourhoodName) | Status (NeighbourhoodName) | Status Reason (NeighbourhoodName) | Created On |

  @TC39633
  Scenario: TC39633 Validate Neighborhood Item Audit Record is displayed
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find of NeighbourhoodItemAudit
    Then user select Use Saved View field under Advanced Find for "Inactive NeighbourhoodAudit"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Name (NeighbourhoodName) | NeighbourhoodName | Rating | Walkabout Frequency | Modified On(Neighbourhood) | Modified By(Neighbourhood) | Created On (NeighbourhoodName) | Created By (NeighbourhoodName) | Status (NeighbourhoodName) | Status Reason (NeighbourhoodName) | Created On |

  @TC39632
  Scenario: TC39632 Validate Neighborhood Item Audit Record is displayed
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    And user click on  Advanced Find option From the tool bar
    Then user select Look Up field under Advanced Find of NeighbourhoodItemAudit
    Then user select Use Saved View field under Advanced Find for "AllNeighbourhoodItemAudit"
    Then user click on Results under Advanced Find
    Then user validate below coloumn names are available
      | Name (NeighbourhoodName) | NeighbourhoodName | Rating | Walkabout Frequency | Created On (NeighbourhoodName) | Created By (NeighbourhoodName) | Modified On (NeighbourhoodName) | Modified By (NeighbourhoodName) | Status (NeighbourhoodName) | Status Reason (NeighbourhoodName) | Created On |

   @TC_37454
   Scenario: CR36396 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user enter "1 Week" in "Walkabout Frequency" text box
    Then user enter "3" in "Rating" text box
    And user enter "South" in "Region" text box
    Then user click on "Save"
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the appointment
    Then user Reopen the "appointment" from the timeline
    Then user provide the Walkabout Rating and mark the appointment complete
    Then user verifies "1 week" value exists
    
    @TC_35217
    Scenario: US21094 : Validate 1 month value is  set in Walkabout Frequency field when the Rate Value is decreased in Appointment on Neighborhood form.
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user enter "6 Month" in "Walkabout Frequency" text box
    Then user enter "3" in "Rating" text box
    And user enter "South" in "Region" text box
    Then user click on "Save"
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the appointment
    Then user Reopen the "appointment" from the timeline
    Then user provide the Walkabout Rating and mark the appointment complete
    Then user verifies "1 Month" value exists
   
    @CR36395 @Sprint13 @USerstory
  	Scenario: CR36395 of Sprint 11
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |
      
    @CR36396 @US21094 @TC35216 @Sprint13
  	Scenario: US21094 TC35216 of Sprint 11
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |
    Then user clicks on "Save (CTRL+S)"
    Then user select "Rating" as "2"
    Then user clicks on "Save (CTRL+S)"
    Then user click on "Mark Complete"
    Then user validate Walkabout Frequency as "1 week"
    Then user validate Walkabout Completion Date as current date
   
   
     @US23397
  Scenario: Us -23397,Us-33983,Us-34001,US-33478,US-21094
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Neighborhoods" under customer
    And user click on Drop Down List
    And user select "Active Neighborhoods" from drop down list
    When user search "Abingdon - 1 to 5 Fitchett Yard flats" and click on contact name link
    Then user fill details for "Walkabout Frequency" as "1 week"
    
    @US22305
  Scenario: Us -22305
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Neighborhoods" under customer
    And user search "125 Princess Road Branksome, Poole" and click on contact name link
    And user select "Walkabout Frequency" as "6 Months"
    And user select "Rating" as "2"
    Then user click on "Save"
    Then user click on "Related"
    And user click on Tab "Related" for selecting "Audit History"
    And user verify the new values as "6 Months" and "2" in "Audit History"

  @US21094
  Scenario: Us -21094
  	Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    When user click on "Neighborhoods" under customer
    And user search "125 Princess Road Branksome, Poole" and click on contact name link
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user click on "Save and Close"
    Then user Reopen the "appointment" from the timeline
    Then user provide the Walkabout Rating and mark the appointment complete
    Then user verifies if "Appointment" is closed
    Then user validate "Appointment closed date" field as "Walkabout Completion Date"
    
    @CR36395 @Sprint13
  Scenario: CR36395 of Sprint 11
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |

  @CR36396 @Sprint13
  Scenario: CR36396 od Sprint 11
  Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
    Then user click on "Neighborhoods" under customer
    Then user picks the Neighborhood name
    Then user Click the + on the timeline and select "Appointment Activity"
    Then user Enter a "Subject"
    Then user Save the "Appointment"
    Then user Reopen the "appointment" from the timeline
    Then user verifies the field "Rating"
      | 1 | 2 | 3 |
    Then user click on "Save (CTRL+S)"
    Then user select "Rating" as "2"
    Then user click on "Save (CTRL+S)"
    Then user click on "Mark Complete"
    Then user validate Walkabout Frequency as "1 week"
    Then user validate Walkabout Completion Date as current date