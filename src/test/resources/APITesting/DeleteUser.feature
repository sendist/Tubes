Feature: Delete User

Background:
    Given DummyAPI server is up
    And Set base url

@DeleteUserOperationWithoutIncludingAppIdHeaderWithValidUserID @TC01
Scenario: Perform delete user operation without including "app-id" header, with valid user ID
    Given Prepare delete user request without app-id header
    When Send the request to delete user
    Then Verify the response status code is 403 Forbidden
    And Verify the response body contains error field with message "APP_ID_MISSING"

@DeleteUserOperationWithInvalidAppIdHeaderWithValidUserID @TC02
Scenario: Perform delete user operation with invalid "app-id" header, with valid user ID
    Given Prepare delete user request with invalid app-id header and valid user ID
    When Send the request to delete user
    Then Verify the response status code is 403 Forbidden
    And Verify the response body contains error field with message "APP_ID_NOT_EXIST"

@DeleteUserOperationWithValidAppIdHeaderWithValidUserID @TC03
Scenario: Perform delete user operation with valid "app-id" header, and valid user ID
    Given Prepare delete user request with valid app-id header and valid user ID
    When Send the request to delete user
    Then Verify the response status code is 200 OK
    And Verify the response body contains the deleted user ID

@DeleteUserOperationWithValidAppIdHeaderWithInvalidUserID @TC04
Scenario: Perform delete user operation with valid "app-id" header, and invalid user ID
    Given Prepare delete user request with valid app-id header and invalid user ID
    When Send the request to delete user
    Then Verify the response status code is 404 Not Found
    And Verify the response body contains error field with message "RESOURCE_NOT_FOUND"
