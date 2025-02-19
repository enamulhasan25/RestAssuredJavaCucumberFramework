package steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class GetCartWithCartId {

    // Accessing Singleton instance from the common Validations Class
    ServiceCalls cm = ServiceCalls.getInstance();

    @Then("print the response payload")
    public void printTheResponsePayload() {
        Response res = cm.getResponse();
        res.body().prettyPrint();
    }
}