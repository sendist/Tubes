Feature: Create User

Background: 
    Given DummyAPI server is up
    And Set base url

@GetHasNoAuthorization @TC01
Scenario: Get has no authorization
    When hit GET user by Id 
    Then User get status code Forbidden
    And User get response error field containing message "APP_ID_MISSING"

@GetHasInvalidAuthorizationAndValidId @TC02
Scenario: Get has invalid authorization and valid Id
    When hit GET user by Id and Invalid App Id
    Then User get status code Forbidden
    And User get response error field containing message "APP_ID_NOT_EXIST"

@GetHasValidAuthorizationAndId @TC03
Scenario: Get has valid authorization and Id
    When hit GET user by Id and valid App Id
    Then User get status code Ok
    And User get response body with id field equals

@GetHasValidAuthorizationAndInvalidId @TC04
Scenario: Get has valid authorization and invalid Id
    When hit GET user by valid Id and invalid App Id
    Then User get status code Not Found
    And User get response error field containing message "RESOURCE_NOT_FOUND"
