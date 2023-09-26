@tag
Feature: Validate the AmeriSaveSendNotes

Scenario: AmeriSave Send Notes
Given POST the AmeriSaveSendNotes API
And Extract the Response from the server for AmeriSaveAPI
Then Validate the Response Body of AmeriSaveSendNotes
