package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static java.lang.System.out;

public class ServiceCalls {

    // Singleton instance
    private static ServiceCalls instance;
    private Response res;

    public ServiceCalls() {
    }

    // Static method to provide access to the single instance
    public static ServiceCalls getInstance() {
        if (instance == null) {
            instance = new ServiceCalls();
        }
        return instance;
    }

    // Getter and Setter for the response variable
    public Response getResponse() {
        return res;
    }

    public void setResponse(Response response) {
        this.res = response;
    }

    // GET Service Call
    @When("a GET call is made to the {string}")
    public void aGETCallMadeToThe(String endpoint) {
        res = given().get(endpoint);
        getInstance().setResponse(res);
    }

    // GET call for the single product search
    @When("a GET call is made to the single product endpoint {string} with productId {string}")
    public void aGetCallMadeToTheSingleProductEndpoint(String endpoint, String productId) {
        res = given()
                .pathParam("productId", productId)
                .get(endpoint);
        getInstance().setResponse(res);
    }

    // GET call for retrieving the newly created cart
    @When("a GET call is made to the newly created cartId {string}")
    public void aGetCallMadeToTheCartEndpoint(String endpoint) {
        if (CreateNewCart.newlyCreatedCartId == null || CreateNewCart.newlyCreatedCartId.isEmpty()) {
            out.println("Error: Cart ID is null or empty. Please check the response of cart creation.");
            return;
        }

        String finalEndpoint = endpoint.replace("{cartId}", CreateNewCart.newlyCreatedCartId);
        out.println("Final endpoint: " + finalEndpoint);

        res = given()
                .pathParam("cartId", CreateNewCart.newlyCreatedCartId)
                .get(finalEndpoint);
        getInstance().setResponse(res);
    }

    // POST call for adding an item into cart
    @When("a POST call is made to the add cart endpoint {string} with cartId {string}")
    public void aPOSTCallMadeToTheAddCartEndpoint(String endpoint, String cartId) throws IOException {
        AddAnItemToCart add = new AddAnItemToCart();
        String resolvedEndpoint = endpoint.replace("{cartId}", cartId);

        res = given()
                .contentType("application/json")
                .body(add.getProductIdFromRequestPayloadTemplate().toString())
                .when()
                .post(resolvedEndpoint);

        getInstance().setResponse(res);
    }

    // POST call for registering a client
    @When("a POST call is made to the {string}")
    public void aPostCallIsMadeToTheRegister(String endpoint) {
        res = given()
                .contentType("application/json")
                .body(RegisterClient.getCreateAPIClientPayload())
                .when()
                .post(endpoint);

        getInstance().setResponse(res);
    }

    // POST call without body for creating a cart
    @When("a POST call without body is made to the {string}")
    public void aPostCallWithoutBodyIsMadeToThe(String endpoint) {
        res = given().when().post(endpoint);
        getInstance().setResponse(res);
    }

    // Validating the response code
    @And("response code should be {int}")
    public void responseCodeShouldBe(int expectedCode) {
        Assert.assertEquals("Response code mismatch", expectedCode, res.getStatusCode());
        getInstance().setResponse(res);
    }
}