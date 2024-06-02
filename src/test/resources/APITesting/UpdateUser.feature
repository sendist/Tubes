Feature: Update User

  Background:
    Given DummyAPI server is up
    And Set base url

  @OperationHasNoAuthorization @TC01
  Scenario: Operation has no authorization
    Given prepare JSON payload with "TC01"
    When hit PUT update user API
    Then User gets response body with error field containing message "APP_ID_MISSING"
    And User get the response status code is 403 Forbidden

  @OperationHasValidAuthorizationAndUpdatesLastName @TC02
  Scenario: Operation has valid authorization and updates last name
    Given prepare JSON payload with "TC02"
    And Set valid App ID in header
    When hit PUT update user API
    Then User gets response body with updated last name
    And User get the response status code is 200 OK

  @OperationHasValidAuthorizationAndUpdatesGender @TC03
  Scenario: Operation has valid authorization and updates gender
    Given prepare JSON payload with "TC03"
    And Set valid App ID in header
    When hit PUT update user API
    Then User gets response body with updated gender
    And User get the response status code is 200 OK

  @OperationHasValidAuthorizationAndUpdatesDateOfBirth @TC04
  Scenario: Operation has valid authorization and updates date of birth
    Given prepare JSON payload with "TC04"
    And Set valid App ID in header
    When hit PUT update user API
    Then User gets response body with updated date of birth
    And User get the response status code is 200 OK

  @OperationHasValidAuthorizationButUpdatesFirstNameWithInvalidFormat @TC05
  Scenario: Operation has valid authorization but updates first name with invalid format
    Given prepare JSON payload with "TC05"
    And Set valid App ID in header
    When hit PUT update user API
    Then User get the response status code is 400 Bad Request
    And User gets response body with error field containing message "BODY_NOT_VALID"
