Feature: get result status accordingly

  Background:
    * url "https://petstore.swagger.io/v2/"

  Scenario Outline: Fetch list of pets via status

    Given path 'pet/findByStatus'
    And params {status:<status>}
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    Examples:
    |status|
    |available|
    |pending  |
    |sold     |