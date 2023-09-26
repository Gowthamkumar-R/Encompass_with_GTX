
@tag
Feature: AmeriSave Place Order Validation

  @tag1
  Scenario: verify AmeriSavePlaceOrder response
    Given POST the API request with informations
    When Response from the server executed
    Then Validate the response