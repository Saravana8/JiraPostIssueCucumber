Feature: Jira API validation
  
  @CreateJiraissue
  Scenario Outline: validating Jira API create issue
    Given Add payload for create the issue "<summary>","<description>"
    When User should call "createJiraIssue" with "Post" http request
    Then User should verify the response code should be 201
    And User should verify the response body should contains "sarvan"

    Examples: 
      | summary                           | description                       |
      | user unable to click login button | login button not working properly |
 
  @UpdateJiraissue
  Scenario Outline: verify the jira update issues
    Given Add payload for update the issue "<summary>","<description>"
    When User should call "updateJiraIssue" with "Put" http request
    Then User should verify the response code should be 204

    Examples: 
      | summary                                   | description                                   | 
      | user unable to verify login functionality | login button not working properly as expected | 
  
  @GetAllJiraissues
  Scenario: verify the jira Get issues
    Given User add the baseuri
    When User should call "getJiraIssue" with "Get" http request
    Then User should verify the response code should be 200
  
  @Deleteissue
  Scenario: verify the jira delete issues
    Given User add the baseuri
    When User should call "deleteJiraIssue" with "delete" http request
    Then User should verify the response code should be 204

