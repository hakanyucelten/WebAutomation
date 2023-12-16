Feature: Login Test

  Scenario: User logs in
    Given user is on the Google homepage
    When user searches for "Gmail"
    And user clicks on the "Gmail" link
    And user clicks on the sign-in button
    Then user should be on the Gmail sign-in page