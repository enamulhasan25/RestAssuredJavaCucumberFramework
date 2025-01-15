package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static java.lang.System.out;

public class CommonValidations {

    // Single ton instance
    private static final CommonValidations instance = new CommonValidations();

    // instance variable
    private Response res;

    // Getter and Setter for the above instance variable
    public void setResponse(Response res) {
        this.res = res;
    }

    public Response getRes() {
        return res;
    }

    // Default constructor
    public CommonValidations() {
    }

    // Static method to provide access to the single instance
    public static CommonValidations getInstance() {
        return instance;
    }

    // GET Service Call
    @When("a GET call is made to the {string}")
    public void aGETCallMadeToThe(String endpoint) {
        res = given()
                .get(endpoint);
        getInstance().setResponse(res);
    }

    @When("a GET call is made to the single product endpoint {string} with productId {string}")
    public void aGetCallMadeToTheSingleProductEndpoint(String endpoint, String productId) {
        res = given()
                .pathParam("productId", productId)
                .get(endpoint);
        getInstance().setResponse(res);
    }


    @When("a GET call is made to the single cart endpoint {string} with cartId {string}")
    public void aGetCallMadeToTheCartEndpoint(String endpoint, String cartId) {
        CreateNewCart cr = new CreateNewCart();
        cr.setActualCartIdFromResponse("" + cartId);
        out.println("This is the Newly Created CartId = " + cr.getActualCartIdFromResponse());
        res = given()
                .pathParam("cartId", cartId)
                .get(endpoint);
        getInstance().setResponse(res);
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
        getInstance().setResponse(res);
    }

    // For POST Service call for RegisterClientId
    @When("a POST call is made to the {string}")
    public void aPostCallIsMadeToTheRegister(String endpoint) {
        res = given().contentType("application/json")
                .body(RegisterClient.getCreateAPIClientPayload())
                .when()
                .post(endpoint);
        // Setting the response in the Singleton instance
        getInstance().setResponse(res);
    }

    //POST call without body
    @When("a POST call without is made to the {string}")
    public void aPostCallWithoutBodyIsMadeToThe(String endpoint) {
        res = given()
                .when()
                .post(endpoint);
        getInstance().setResponse(res);
    }

    // Validating the response code
    @And("response code should be {int}")
    public void responseCodeShouldBe(int expectedCode) {
        Assert.assertEquals(expectedCode, res.getStatusCode());
    }
}