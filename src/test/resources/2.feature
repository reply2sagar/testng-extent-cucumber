Feature: Verify placeholder API

    @Regression
  Scenario: Get Token
    Given I send the request to auth api to get token
    Then the token should be sent in the response

  Scenario: HTTP Post Request
    Given I send the post request
    Then new record should be created and id should be in the response