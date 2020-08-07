Feature: Jira API validation

  Scenario Outline: validating Jira API create issue
    Given Add payload for create the issue "<summary>","<description>"
    When User should call the API create issue with post http request
    Then User should verify the response code should be 201
    And User should verify the response body should contains "sarvan231"

    Examples: 
      | summary                                                  | description                                     |
      | user unable to click login button                        | login button working properly                   |
      | user unable to get PNR status                            | not get expected PNR                            |
      | Unable Select Flights button                             | Flight button not working properly              |
      | As Payment gateway not working for internet banking      | Internet banking is not get results as expected |
      | As unable to select more than 2 traveler in one way trip | Not displayed as per customer requirement       |
