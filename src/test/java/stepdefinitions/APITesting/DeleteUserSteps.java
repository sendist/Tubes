package stepdefinitions.APITesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserSteps {
    private Response response;
    private RequestSpecification request;

    private String validAppId = "665c6e4627e8716117d6e02b";
    private String invalidAppId = "appIdTidakValid";
    private String validUserId = "665c81974fd179ca12767596";
    private String invalidUserId = "665c78404fd1798edf766f69";

    @Given("Prepare delete user request without app-id header")
    public void prepare_delete_user_request_without_app_id_header() {
        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", validUserId);
    }

    @Given("Prepare delete user request with invalid app-id header and valid user ID")
    public void prepare_delete_user_request_with_invalid_app_id_header_and_valid_user_id() {
        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", invalidAppId)
                .pathParam("id", validUserId);
    }

    @Given("Prepare delete user request with valid app-id header and valid user ID")
    public void prepare_delete_user_request_with_valid_app_id_header_and_valid_user_id() {
        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", validAppId)
                .pathParam("id", validUserId);
    }

    @Given("Prepare delete user request with valid app-id header and invalid user ID")
    public void prepare_delete_user_request_with_valid_app_id_header_and_invalid_user_id() {
        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("app-id", validAppId)
                .pathParam("id", invalidUserId);
    }

    @When("Send the request to delete user")
    public void send_request_to_delete_user() {        
        response = this.request.when()
        .delete("/user/{id}");
    }

    @Then("Verify the response status code is {int} Forbidden")
    public void verify_the_response_status_code_is_forbidden(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("Verify the response status code is {int} OK")
    public void verify_the_response_status_code_is_ok(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("Verify the response status code is {int} Not Found")
    public void verify_the_response_status_code_is_not_found(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }


    @Then("Verify the response body contains error field with message {string}")
    public void verify_response_body_contains_error_field_with_message(String errorMessage) {
        response.then().assertThat().body("error", equalTo(errorMessage));
    }

    @Then("Verify the response body contains the deleted user ID")
    public void verify_response_body_contains_deleted_user_id() {
        response.then().assertThat().body("id", equalTo(validUserId));
    }
}
