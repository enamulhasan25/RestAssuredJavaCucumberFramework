package steps;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static java.lang.System.out;

public class CreateNewCart {

    // Accessing a singleton instance
    ServiceCalls sc = ServiceCalls.getInstance();
    public static String newlyCreatedCartId = "";

    @Then("capture the newly created cartId from the response")
    public void captureNewlyCreatedCart() {
        Response currentResponse = sc.getResponse();
        if (currentResponse != null) {
            currentResponse.body().prettyPrint();
            // Extract the cartId from the response
            newlyCreatedCartId = currentResponse.body().jsonPath().getString("cartId").trim();
            out.println("Newly created cart id is: " + newlyCreatedCartId);
            // sca.aGetCallMadeToTheCartEndpoint(newlyCreatedCartId);
        } else {
            out.println("Response is null. Please check again.");
        }
    }
}