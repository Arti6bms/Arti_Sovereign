@GenericCasesOptimization
Feature: Testing of GenericCases-Optimization in Tenancy Management

  Background: 
    Given User navigates to CRM login page
    When user selects App "Customer Service Hub"
  #Then user is navigated to "Tier 1 Dashboard - Dynamics 365" page

@GenericCases-Optimization
  Scenario: TC_29519-US22963 : Validate Case Story Option field is displayed under Case Story Tab on the Case Form.(Newly added testcase from Optimization US 22963)
    When user click on "Cases" under Service
    And user click on Drop Down List
    And user select "All Cases" from drop down list
    When user search ", Hannah Franklin, 245 Willowherb Road, Emersons Green, BS16 7GR, CAS-12792-Q4M6L6" and click on contact name
    When user click on "Case Story" tab
    Then user validate Case Story Multi select Option field is displayed under Case Story Tab
    Then user validate "Case Story Option" drop down list values
    | ABA | Banding Assessment Panel | CBT referral | Committal | Community Protection Notice | Community Protection Warning | Community Trigger | Criminal Behaviour Order | Demoted Tenancy | Dog Control Order | Eviction | Final warning | Full Closure | Initial Visit (HO or ASBO) | Injunction | Internal Transfer | Living together fund | Mediation | Noise Abatement Order | NOSP served | NTQ served | Partial Closure | Possession | Property Abandoned | Referral to Safe Partnerships | Referral to Womankind | Section 21 Served | Signposted to Domestic Abuse specialist | Signposted to Mental Health team | Signposted to Police | Signposted to Social Services | Solicitors Letter | SPO granted |Tenancy caution | Tenant ended tenancy | Undertaking | Warning - 1st | Warning - 2nd |
    Then user validate Multiple options are selected in Case Story option field Under Case Story Tab
    And user select all Option and verify displayed with Top 5 options and remaining displayed Number Count
    And user click on the Number Count in Case Story Option field and Validate
    Then user click on save button
    
    @ASBCases-Optimization
    @TC_34556-US22311_TC29514
  Scenario: TC_34556-US22311 : ASB Case Form - General Validation - ASB Connection, Validate Initial Victim Assessment and Full Victim Assessment Tabs, Case story
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user fill details for "ASB Case Category" as "Other criminal behaviour"
    Then user fill details for "ASB Type" as "Anything nor recorded elsewhere"
    And user enters description
    And user click on save button
    Then user validate "Initial Victim Assessment" Tabs are hidden
    Then user validate "Full Victim Assessment" Tabs are hidden
    And user click on  Advanced Find option From the tool bar
    Then user Set Query Parameters in Advance Find and Click on Results button
    Then user click on link from list
    And user switch to next window
    Then user validate "Initial Victim Assessment" Tabs are hidden
    Then user validate "Full Victim Assessment" Tabs are hidden
    #When click on "Summary" tab
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    And user Click on "New Connection"
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Witness"
    And user enters description
    Then user click on save button
    And user click on Back button
    When user click on "Case Story" tab
    Then user validate "Case Story Option" drop down list values
      | ABA | Banding Assessment Panel | CBT referral | Committal | Community Protection Notice | Community Protection Warning | Community Trigger | Criminal Behaviour Order | Demoted Tenancy | Dog Control Order | Eviction | Final warning | Full Closure | Initial Visit (HO or ASBO) | Injunction | Internal Transfer | Living together fund | Mediation | Noise Abatement Order | NOSP served | NTQ served | Partial Closure | Possession | Property Abandoned | Referral to Safe Partnerships | Referral to Womankind | Section 21 Served | Signposted to Domestic Abuse specialist | Signposted to Mental Health team | Signposted to Police | Signposted to Social Services | Solicitors Letter | SPO granted |Tenancy caution | Tenant ended tenancy | Undertaking | Warning - 1st | Warning - 2nd |

@ASBCases-OptimizationTC_34561-US22299
  Scenario Outline: TC_34561-US22299 : Validate ASB Court Order Flag is Displayed for all the available Case Story Options
    When user click on "Cases" under customer
    #Then user is navigated to "Cases (Sovereign) My Active Cases - Dynamics 365" page
    And user click on New Cases
    Then user fill all the details for "Customer" as "Jerrilee Shepherd"
    And user fill all the details for "Category" as "Enforcement (legal)"
    And user fill all the details for "Subcategory" as "ASB"
    Then user fill details for "ASB Case Category" as "Other criminal behaviour"
    Then user fill details for "ASB Type" as "Anything nor recorded elsewhere"
    And user enters description
    And user click on save button
    Then user validates the case displayed
    When user click on "Triage Assessment" tab
    Then user fills the Triage Assessment Questions
    Then user clicks Triage Assessment on BPF
    Then user selects Triage Assessment Complete as "Yes"
    Then user clicks Next Stage in BPF
    Then user clicks Action Plan on BPF
    Then user selects Action Plan Generated as "Yes"
    Then user clicks Next Stage in BPF
    Then user validate "Case Story Option" drop down list values
    | ABA | Banding Assessment Panel | CBT referral | Committal | Community Protection Notice | Community Protection Warning | Community Trigger | Criminal Behaviour Order | Demoted Tenancy | Dog Control Order | Eviction | Final warning | Full Closure | Initial Visit (HO or ASBO) | Injunction | Internal Transfer | Living together fund | Mediation | Noise Abatement Order | NOSP served | NTQ served | Partial Closure | Possession | Property Abandoned | Referral to Safe Partnerships | Referral to Womankind | Section 21 Served | Signposted to Domestic Abuse specialist | Signposted to Mental Health team | Signposted to Police | Signposted to Social Services | Solicitors Letter | SPO granted |Tenancy caution | Tenant ended tenancy | Undertaking | Warning - 1st | Warning - 2nd |
    Then user select Case Story Option as "<Value>"
    Then user click on save button
    When user click on "Summary" tab
     Then user fill details for "Customer Survey" as "No"
    Then user scroll down "CASE DETAILS" in page
    Then user scroll down to till element is visible
    And user Click on "New Connection"
    #And user click on three dot for more connection
    And user fill all the details for "Name" as "Jerrilee Shepherd"
    And user fill all the details for "As this role" as "Alleged Perpetrator"
    And user enters description
    Then user click on save button
    And user click on "Jerrilee Shepherd" link
    #And user click on Back button
    #When click on "Summary" tab
    #Then user verifies the "ASB Court Order" flag exists
    #Then user verifies the Tool Tip of "ASB Court Order" flag

    Examples: 
      | Value                        |
      #| Undertaking                  |
      #| Injunction                   |
       | Committal                    |
      #| Demoted Tenancy              |
      #| NOSP served                  |
      #| Section 21 Served            |
      #| NTQ served                   |
      #| SPO granted                  |
      #| Partial Closure              |
      #| Full Closure                 |
      #| Possession                   |
      #| Eviction                     |
      #| Community Protection Warning |
      #| Community Protection Notice  |
      #| Tenant ended tenancy         |
      #| Community Trigger            |
      #| Noise Abatement Order        |
      #| Criminal Behaviour Order     |
      #| Dog Control Order            |
      
      @TC_32329_TC34554_TC32319_TC32276
      Scenario: TC_32329_TC34554
      When user click on "Cases" under customer
      And user click on New Cases
	    Then user fill all the details for "Customer" as "Julie Utting"
	    And user fill all the details for "Category" as "Enforcement (legal)"
	    And user fill all the details for "Subcategory" as "ASB"
	    Then user fill details for "ASB Case Category" as "Other criminal behaviour"
	    Then user fill details for "ASB Type" as "Anything nor recorded elsewhere"
	    And user enters description
	    And user click on save button
	    When user click on "Summary" tab
	    Then user validate the "Customer Survey" section for below fields
      | Customer Survey | Survey Creation Date |
	    Then user fill details for "Customer Survey" as "No"
	    Then user verify all the "Customer Survey Case Category" list values
      | Domestic Abuse | Mental Health | Not ASB | Both are Perpetrators |
      Then user fill details for "Customer Survey Case Category" as "Domestic Abuse"
      Then user validate "Exclusion Reasons - Domestic Abuse" field is display
      Then user verify all the "Exclusion Reasons - Domestic Abuse" list values
      | If the CSAT call will have a detrimental impact on personal wellbeing | If the CSAT call could put them at personal risk/danger | If the customer wishes expressly NOT to be surveyed |
      Then user fill details for "Customer Survey Case Category" as "Mental Health"
	    Then user validate "Exclusion Reasons - Mental Health" field is display
	    Then user verify all the "Exclusion Reasons - Mental Health" list values
	    | If the CSAT will have a detrimental impact on personal wellbeing | If the CSAT call could put them at personal risk/danger |
	    Then user fill details for "Customer Survey Case Category" as "Not ASB"
	    Then user validate "Exclusion Reasons - Not ASB" field is display
	    Then user verify all the "Exclusion Reasons - Not ASB" list values
	    | Case was opened in Error | Case was re-opened for data cleansing | There is non-engagement by the customer(s) |
	    Then user fill details for "Customer Survey Case Category" as "Both are Perpetrators"
	    Then user validate "Exclusion Reasons - Both Are Perpetrators" field is display
	    Then user verify all the "Exclusion Reasons - Both Are Perpetrators" list values
	    | Evidence supports both parties are perpetrators |
	    

     
	    
