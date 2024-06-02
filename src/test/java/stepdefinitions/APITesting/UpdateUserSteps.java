package stepdefinitions.APITesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUserSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserSteps.class);

    private JSONObject globalPayload;
    private Response response;
    private RequestSpecification request;

    private String validUserId = "665c8c994fd179ffd6767af5";
    private String validAppId = "665c6e4627e8716117d6e02b";
    private String updateTitle = "mr";
    private String updateFirstNameTC01 = "Eza";
    private String updateFirstNameTC19 = "E";
    private String updateLastName = "Sananta";
    private String updateDateOfBirth = "2002-04-2";
    private String updateGender = "female";

    private JSONObject getPayload(String testData) {
        // Test Data
        JSONObject payload = new JSONObject();

        switch (testData) {
            case "TC01":
                payload.put("title", updateTitle);
                payload.put("firstName", updateFirstNameTC01);
                break;
            case "TC06":
                payload.put("lastName", updateLastName);
                break;
            case "TC07":
                payload.put("gender", updateGender);
                break;
            case "TC09":
                payload.put("dateOfBirth", updateDateOfBirth);
                break;
            case "TC19":
                payload.put("firstName", updateFirstNameTC19);
                break;
            default:
                throw new IllegalArgumentException("Invalid test data: " + testData);
        }

        return payload;
    }

    @Given("prepare JSON payload with {string}")
    public void prepare_json_payload_with_test_data(String testData) {
        this.globalPayload = getPayload(testData);
        LOGGER.info("Payload for test data {}: {}", testData, globalPayload.toJSONString());

        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", validUserId)
                .body(globalPayload.toJSONString());
    }

    @Given("Set valid App ID in header")
    public void set_valid_appid_in_header() {
            this.request.given()
                .contentType(ContentType.JSON)
                .header("app-id", validAppId);
    }

    @When("hit PUT update user API")
    public void hit_put_update_user_api() {
        response = this.request
                .when()
                .put("/user/{id}");
        LOGGER.info("Response: {}", response.asString());
    }

    @Then("User gets response body with error field containing message {string}")
    public void user_gets_response_body_with_error_field_containing_message(String errorMessage) {
        response.then()
                .assertThat()
                .body("error", equalTo(errorMessage));
    }

    @Then("User gets status code {int} Forbidden")
    public void user_gets_status_code_forbidden(Integer statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }

    @Then("User gets response body with updated last name")
    public void user_gets_response_body_with_updated_last_name() {
        response.then()
                .assertThat()
                .body("lastName", equalTo(updateLastName));
    }

    @Then("User gets response body with updated gender")
    public void user_gets_response_body_with_updated_gender() {
        response.then()
                .assertThat()
                .body("gender", equalTo(updateGender));
    }

    @Then("User gets response body with updated date of birth")
    public void user_gets_response_body_with_updated_date_of_birth() {
        response.then()
                .assertThat()
                .body("dateOfBirth", equalTo("2002-04-02T00:00:00.000Z"));
    }

    @Then("User get the response status code is {int} Bad Request")
    public void verify_the_response_status_code_is_bad_request(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("User get the response status code is {int} OK")
    public void user_get_the_response_status_code_is_ok(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("User get the response status code is {int} Forbidden")
    public void user_get_the_response_status_code_is_forbidden(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
