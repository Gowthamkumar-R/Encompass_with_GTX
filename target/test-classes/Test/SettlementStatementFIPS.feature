@tag
Feature: Settlement Service Information FIPS

  @tag1
  Scenario: Verify Settlement Statement Information FIPS
    Given the settlement FIPS information is provided
    When then FIPS feature file is executed
    Then verify the settlement FIPS details are correctly recorded
    