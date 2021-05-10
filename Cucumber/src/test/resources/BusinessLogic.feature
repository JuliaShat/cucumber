Feature:Emails exchange

  Scenario: Creating and saving random email, write and send and delete emails
    Given I open main page
    And I choose random name
    And I click dropdown domain menu
    And I choose rover info domain
    Then I remember email address
    And I open settings
    And I remember the secret address
    And I close settings
    Then I check the settings window is closed
    Then I check waiting new letters string is visible


      Given I write new letter
      And I'm waiting for the email submission form is visible
      And I fill in the email
      And I send the email
      And I wait for the new letter income and open it
      Then I check the income email content
      And I click to reply
      And I fill in and send the email Test2
      And I go back to the main page
      Then I check letter ReTest


      Given I open last income letter
      And I check the Re income email content
      And I delete the email
      Then I check that Re email was deleted
    Then I close browser