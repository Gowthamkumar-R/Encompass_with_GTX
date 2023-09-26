@tag
Feature: GTX Order 

@tag1
Scenario: Validate the GTX Order Response
Given POST the GTXOrder API request
When Retrieve the response from the server
Then Validate the GTX Order response is sucessful