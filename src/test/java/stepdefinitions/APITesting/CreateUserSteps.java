package stepdefinitions.APITesting;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.HelperClass;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserSteps {

    private JSONObject globalPayload;
    private Response response;

    public JSONObject getPayload() {
        // Test Data
        String title = "ms";
        String firstName = "Daffa";
        String lastName = "Raihandika";
        String gender = "female";
        String email = "daffa@example.com";
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

   @When("Prepare JSON payload")
   public void prepare_json_payload() {
        this.globalPayload = getPayload();
   }

   @When("hit POST create user API")
   public void hit_post_user_create_api() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(globalPayload.toJSONString())
                .when()
                .post("/user/create");
   }

   @Then("User get response body with error field containing message \"APP_ID_MISSING\"")
   public void user_get_response_body_with_error_field_containing_message_app_id_missing() {
        response.then()
                .assertThat()
                .body("error", equalTo("APP_ID_MISSING"));
   }

   @Then("User get status code 403 Forbidden")
   public void user_get_status_code_403_forbidden() {
        response.then()
                .assertThat()
                .statusCode(403);
   }
}
