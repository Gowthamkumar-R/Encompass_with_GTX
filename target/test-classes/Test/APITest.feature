#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Cucumber validation using RestAssured API
  I want to use this template for API Verification

<<<<<<< Updated upstream
  @tag1
  Scenario: RestAssured API Connection and validate JSON Response
=======
# @tag1
#  Scenario: Create API Request Body & Format JSON content
#    Given Generate API Request Body
#    And Format API RequestBody JSON
#    Then Write Back formated JSON to specific file

  @tag2
    Scenario: RestAssured API Connection and validate JSON Response
>>>>>>> Stashed changes
    Given I want to connect with RestAssured API
    And Test API Connection
    When Validate Rest Assured Response
    And Close RestAssured connection
    Then Connect to JSON file
<<<<<<< Updated upstream
    And Validate JSON Content

  @tag2
  Scenario: Create API Request Body & Format JSON content
    Given Generate API Request Body
    And Format API RequestBody JSON
    Then Write Back formated JSON to specific file
=======
    And Validate JSON Content
>>>>>>> Stashed changes
