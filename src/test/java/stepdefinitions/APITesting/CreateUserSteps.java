package stepdefinitions.APITesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.HelperClass;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserSteps {

    private JSONObject globalPayload;
    private Response response;
    private RequestSpecification request;

    public JSONObject getPayload() {
        // Test Data
        String title = "ms";
        String firstName = "Daffa";
        String lastName = "Raihandika";
        String gender = "female";
        String email = "daffa9998@example.com";
        String dateOfBirth = "1990-01-01";
        String phone = "08127387812";
        String picture = "https://example.com/picture.jpg";

        // location object
        JSONObject location = new JSONObject();
        location.put("street", "123 Example St");
        location.put("city", "Exampleville");
        location.put("state", "Examplestate");
        location.put("country", "Exampleland");
        location.put("timezone", "+7:00");

        // Construct the main JSON payload
        JSONObject payload = new JSONObject();
        payload.put("title", title);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("dateOfBirth", dateOfBirth);
        payload.put("phone", phone);
        payload.put("picture", picture);
        payload.put("location", location);

        return payload;
    }

   @Given("DummyAPI server is up") 
   public void dummyapi_server_is_up() {
       Assert.assertTrue(HelperClass.isServerRunning("https://dummyapi.io/"));
   }

   @Given("Set base url")
   public void set_base_url_to_https_dummyapi_io_data_v1() {
       RestAssured.baseURI = "https://dummyapi.io/data/v1";
   }

   @Given("Prepare JSON payload")
   public void prepare_json_payload() {
        this.globalPayload = getPayload();
        this.request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(globalPayload.toJSONString());

   }

   @Given("Set invalid app-id in header")
   public void set_invalid_app_id_in_header() {
        this.request.given()
                .header("app-id", "invalid-app-id");
   }

   @Given("Set valid app-id in header")
   public void set_valid_app_id_in_header() {
        this.request.given()
                .header("app-id", "6627132f6cae03d7fddee77b");
   }

   @Given("Set first name to blank")
   public void set_first_name_to_blank() {
        globalPayload.put("firstName", "");
   }

   @When("hit POST create user API")
   public void hit_post_user_create_api() {
        response = this.request
                .when()
                .post("/user/create");
   }

   @Then("User get response body with error field containing message \"APP_ID_MISSING\"")
   public void user_get_response_body_with_error_field_containing_message_app_id_missing() {
        response.then()
                .assertThat()
                .body("error", equalTo("APP_ID_MISSING"));
   }

   @Then("User get response body with error field containing message \"APP_ID_NOT_EXIST\"")
   public void user_get_response_body_with_error_field_containing_message_app_id_not_exist() {
        response.then()
                .assertThat()
                .body("error", equalTo("APP_ID_NOT_EXIST"));
   }

   @Then("User gets a response body with error field containing message \"BODY_NOT_VALID\"")
   public void user_gets_a_response_body_with_error_field_containing_message_body_not_valid() {
        response.then()
                .assertThat()
                .body("error", equalTo("BODY_NOT_VALID"));
   }

   @Then("User get status code 403 Forbidden")
   public void user_get_status_code_403_forbidden() {
        response.then()
                .assertThat()
                .statusCode(403);
   }

   @Then("User get status code 200 OK")
   public void user_get_status_code_200_ok() {
        response.then()
                .assertThat()
                .statusCode(200);
   }

   @Then("User get status code 400 Bad Request")
   public void user_get_status_code_400_bad_request() {
        response.then()
                .assertThat()
                .statusCode(400);
   }

   @Then("User gets a response body containing the newly added user data")
   public void user_gets_a_response_body_containing_the_newly_added_user_data() {
        String email = (String) globalPayload.get("email");
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("ms"))
                .body("firstName", equalTo("Daffa"))
                .body("lastName", equalTo("Raihandika"))
                .body("gender", equalTo("female"))
                .body("email", equalTo(email))
                .body("dateOfBirth", equalTo("1990-01-01T00:00:00.000Z"))
                .body("phone", equalTo("08127387812"))
                .body("picture", equalTo("https://example.com/picture.jpg"))
                .body("location.street", equalTo("123 Example St"))
                .body("location.city", equalTo("Exampleville"))
                .body("location.state", equalTo("Examplestate"))
                .body("location.country", equalTo("Exampleland"))
                .body("location.timezone", equalTo("+7:00"));
   }
}
