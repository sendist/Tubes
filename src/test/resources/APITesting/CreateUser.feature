Feature: Create User

Background: 
    Given DummyAPI server is up
    And Set base url
    And Prepare JSON payload

@CreateOperationHasNoAuthorization @TC01
Scenario: Operation has no authorization
    And hit POST create user API 
    Then User get status code 403 Forbidden
    And User get response body with error field containing message "APP_ID_MISSING"

@CreateOperationHasInvalidAuthorization @TC02
Scenario: Operation has invalid authorization
    Given Set invalid app-id in header
    And hit POST create user API
    Then User get status code 403 Forbidden
    And User get response body with error field containing message "APP_ID_NOT_EXIST"
