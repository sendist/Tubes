Feature: Create User

    Background: 
        Given DummyAPI server is up
        And Set base url
        And Prepare JSON payload

    @CreateOperationHasNoAuthorization @TC01
    Scenario: Create operation has no authorization
        When hit POST create user API 
        Then User get response body with error field containing message "APP_ID_MISSING"
        And User get status code 403 Forbidden

    @CreateOperationHasInvalidAuthorization @TC02
    Scenario: Create operation has invalid authorization
        Given Set invalid app-id in header
        When hit POST create user API
        Then User get response body with error field containing message "APP_ID_NOT_EXIST"
        And User get status code 403 Forbidden

    @CreateOperationHasAuthorizationWithValidInputDataAndEmailHasNotBeenRegisteredInTheSystem @TC03
    Scenario: Create operation has authorization with valid input data and email has not been registered in the system
        Given Set valid app-id in header
        When hit POST create user API
        Then User gets a response body containing the newly added user data
        And User get status code 200 OK

    @CreateOperationHasAuthorizationWithValidInputDataAndEmailAlreadyRegisteredInTheSystem @TC04
    Scenario: Create operation has authorization with valid input data and email already registered in the system
        Given Set valid app-id in header
        When hit POST create user API
        Then User gets a response body with error field containing message "BODY_NOT_VALID"
        And User get status code 400 Bad Request
    
    @CreateOperationHasAuthorizationWithAllFieldsFilledInExceptFirstNameFilledInBlank @TC05
    Scenario: Operation has authorization with all fields filled in except firstName filled in blank
        Given Set valid app-id in header
        Given Set first name to blank
        When hit POST create user API
        Then User gets a response body with error field containing message "BODY_NOT_VALID"
        And User get status code 400 Bad Request

