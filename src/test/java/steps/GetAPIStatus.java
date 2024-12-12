package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static java.lang.System.out;

public class GetAPIStatus {

    Response res;

    @When("a GET call made to the {string}")
    public void aGETCallMadeToTheStatus(String endpoint) {
        res = given()
                .get(endpoint);
    }

    @And("response code should be {int}")
    public void responseCodeShouldBe(int expectedCode) {
        Assert.assertEquals(expectedCode,res.getStatusCode());
    }

    @Then("validate the status value as {string} from response payload")
    public void validateTheStatusValueAsUPFromResponsePayload(String expectedStatus) {
        out.println(res.getBody().asString());
        String statusValueFromResponsePayload = res.jsonPath().getString("status");
        out.println("Status Value from Response Payload is =" + statusValueFromResponsePayload);
        Assert.assertEquals("The status value does not match", expectedStatus, statusValueFromResponsePayload);
    }
}