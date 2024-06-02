Feature: Create User

Background: 
    Given DummyAPI server is up
    And Set base url

@OperationHasNoAuthorization @TC01
Scenario: Operation has no authorization
    When Prepare JSON payload
    And hit POST create user API 
    Then User get status code 403 Forbidden
    And User get response body with error field containing message "APP_ID_MISSING"

