@tag
Feature: Generate Autherization Token

  @tag1
  Scenario: RestAssured API Token generation 
    Given I want to provide login credentials for token generation API
    And verify the token in responce
    
    