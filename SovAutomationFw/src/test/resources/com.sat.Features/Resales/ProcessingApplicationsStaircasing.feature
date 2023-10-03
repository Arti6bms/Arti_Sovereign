@ProcessingApplications_Resales_Staircase
Feature: Testing of Processing Applications Resales

  Background: 
    Given User navigates to CRM login page
    When user selects App "Resales"

  @TC_22907_TC_22908_TC_22910_TC_23487_TC_29863
  Scenario: TC_22907_TC_22908_TC_22910_TC_23487
    When user click on "Contacts" under customer
    And user click on Drop Down List
    And user select "Active Contacts" from drop down list
    Then user search Contact Name
    Then user select any Active Contact
    Then user click on "Application" tab
    Then user clicks on "New Application. Add New Application"
    And user select "Staircasing Application" form
    #Then user validate the "Property Details" section for below fields
      #| Property | Sale Type Field |
    Then user fill all the details for "Property" as "100014, 10 Rumney Penrose Road, Stoke Gifford, Bristol, BS16 1RA"
    #		#Then user fill all the details for "Property" as "100004, 4 Hoopers Walk, Longwell Green, Bristol, South Gloucestershire, BS30 9DZ"
    Then user select "Sale Type Field" as "Interim SC"
#			    # Then user clicks on "Repossession?"
#			    # Then user clicks on "Executor?"
#			    #And user fill all the details for "Current Owner Solicitor" as "Test Solicitors"
#			    #And user fill all the details for "Current Owner Solicitor Contact" as " - Dale"
#			    #And user fill all the details for "Current Owner Solicitor Contact" as "# AIBuilderProd"
#			    #And user fill all the details for "Property Legal Solicitor Contact" as "# app-powerpack-dynamics-bauqa"
    Then user validates "Information" section
#			    #Then user validate the below fields are autopopulated
#			    #| Asset Type | Property Type | Bedrooms | Property Manager |
     Then user clicks Internal Checks on BPF
    Then user enter the value in "Current Monthly Rent" as "10000"
    Then user enter the value in "Current Monthly Service Charge" as "3000"
    Then user enter the value in "Future Monthly Rent" as "3000"
    Then user enter the value in "Future Monthly Service Charge" as "300"
    Then user click on "Save"
    Then user clicks Internal Checks on BPF
    Then user select "Application Received" as "Complete"
    Then user select "Internal Checks Complete" as "Complete"
    Then user select "Meets Criteria?" as "No"
    Then user select "Application Complete?" as "Complete"
    Then user clicks Next Stage in BPF
    Then user clicks on Create
    Then user Validates AML stage on BPF
    Then user enter the details in AML check grid
    Then user enter the details in Questionnaire section
    Then user enter the details in Evidence Proof of ID grid
    Then user enter the details in Source of Funds grid
    Then user validate Score as "3" and risk as "Low" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | Yes                       | Yes                     |
    Then user validate Score as "2" and risk as "Medium" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | Yes                       | No                      |
    Then user validate Score as "1" and risk as "High" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | Yes                    | No                        | No                      |
    Then user validate Score as "0" and risk as "High" for the below combination
      | Proof of Name Sign Off | Proof of Address Sign Off | Proof of Funds Sign Off |
      | No                     | No                        | No                      |
    Then user enter the details in Risk section
    Then user validate the message Total percentage should be equal to 100
    Then user click on "Save"
    Then user clicks AML on BPF
    Then user validates "AML Status" as "Passed"
    Then user validates "AML Risk Status" as "High"
    Then user select "Referred to Manager/ Legal?" as "Complete"
    Then user select "Signed Off" as "Yes"
    Then user select "AML Passed" as "Yes"
    Then user clicks Next Stage in BPF
    Then user Validates Authority To Proceed stage on BPF
    Then user clicks Authority To Proceed on BPF
    	#Then user select "Valuation Approved" as "Yes"
    Then user select Valuation Approved checkbox
		    #Then user set "Date of ATP Sent" date
		    #Then user set "Date of ATP Received" date
    Then user select "Transaction Proceeding" as "Yes"
    Then user clicks Next Stage in BPF
    Then user set Date of Instruction date
    Then user validate "Forecasted Completion" is 8 weeks from "Date of Instruction" date
    Then user enter the details in "Solicitor’s Instruction" section
    Then user enter the details in "Projected Completion" section
    Then user enter the details in "Completion and Handover" section
    Then user click on "Save"
    Then user Validates Conveyancing stage on BPF
    Then user clicks Conveyancing on BPF
    Then user selects Conveyancing Complete as "Yes"
    Then user clicks on "Finish"

  @TC_23488
  Scenario: TC_23488
     When user click on "Properties" under customer
     And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name for staircasing
    Then user select any property
    Then user clicks "Related" Tab for selecting "Rent Account"
    Then user select any Rent Account Record
    Then user read the "Current Monthly Rent" and "Current Monthly Service Charge" from "RENT ACCOUNT DETAILS" section
    Then user read the "Rent" and "Other" charges from "Charges" Section
    Then user validate "Current Monthly Rent" and "Current Monthly Service Charge"
    Then user clicks on "New Charge. Add New Charge"
    Then user enters details in New Charge Section
		Then user click on "Save & Close"
      | Property | Sale Type Field |
    Then user fill all the details for "Property" as "100016, 22 Rumney Penrose Road, Stoke Gifford, Bristol, Avon, BS16 1RA"
    Then user select "Sale Type Field" as "Resale"
    
    @TC_31028
    Scenario: TC_31028
       When user click on "Properties" under customer
     And user click on Drop Down List
    And user select "Assets" from drop down list
    Then user search Property Name for staircasing
    Then user select any property
    Then user click on "Asset Information" tab
    Then user scroll down "Lease Details" in page
    Then user set "Date of Lease Commencement Date" date
    Then user enter "Term of Lease" as "10"
    Then user validate the "Lease Expiry Date" field
    
       @TC_31029
    Scenario: TC_31029 need to develope this
       When user click on "Properties" under customer
     And user click on Drop Down List 
     
         @TC_30998
    Scenario: TC_30998 develope this
     When user click on "Properties" under customer
     And user click on Drop Down List 
    
   
    

