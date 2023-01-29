Feature: Simple addition
  In order to avoid silly mistakes
  As a math idiot
  I want to be told the sum of two numbers

  Scenario: Add two numbers
    Given I have entered 50 into the calculator
    And I have entered 70 into the calculator
    When I press add
    Then the result should be 120 on the screen

    @Regression
  Scenario: Get Token
    Given I send the request to auth api to get token
    Then the token should be sent in the response

  Scenario: HTTP Post Request
    Given I send the post request
    Then new record should be created and id should be in the response