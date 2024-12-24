package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CommonValidations {

    public static Response res;

    // default constructor
    public CommonValidations() {
    }

    // For GET Service call
    @When("a GET call is made to the {string}")
    public void aGETCallMadeToTheStatus(String endpoint) {
        res = given()
                .get(endpoint);
    }

    @When("a GET call is made to the single product endpoint {string} with productId {string}")
    public void aGetCallMadeToTheSingleProductEndpoint(String endpoint, String productId) {
        CommonValidations.res = given()
                .pathParam("productId", productId)
                .get(endpoint);
    }

    @When("a GET call is made to the single cart endpoint {string} with cartId {string}")
    public void aGetCallMadeToTheCartEndpoint(String endpoint, String cartId) {
        CommonValidations.res = given()
                .pathParam("cartId", cartId)
                .get(endpoint);
    }

    // For POST Service call for Adding an item into cart
    @When("a POST call is made to the add cart endpoint {string} with cartId {string}")
    public void aPOSTCallMadeToTheAddCartEndpoint(String endpoint, String cartId) throws IOException {
        AddAnItemToCart add = new AddAnItemToCart();
        String resolvedEndpoint = endpoint.replace("{cartId}", cartId);
        res = given().contentType("application/json")
                .body(add.getProductIdFromRequestPayloadTemplate().toString())
                .when()
                .post(resolvedEndpoint);
    }

    // For POST Service call for RegisterClientId
    @When("a POST call is made to the {string}")
    public void a_post_call_is_made_to_the(String endpoint) {
        res = given().contentType("application/json")
                .body(RegisterClient.getCreateAPIClientPayload())
                .when()
                .post(endpoint);
    }

    //POST call witout body
    @When("a POST call without is made to the {string}")
    public void aPostCallWithoutBodyIsMadeToThe(String endpoint) {
        res = given()
                .when()
                .post(endpoint);
    }

    // Validating the response code
    @And("response code should be {int}")
    public void responseCodeShouldBe(int expectedCode) {
        Assert.assertEquals(expectedCode, res.getStatusCode());
    }
}