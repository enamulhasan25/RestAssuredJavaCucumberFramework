package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GetSingleProduct {

    // Accessing Singleton instance from the common Validations Class
    ServiceCalls cm = ServiceCalls.getInstance();

    @Then("productId {string} should display in the response payload")
    public void productIdShouldDisplayInTheResponsePayload(String expectedProductId) {
        cm.getResponse().body().prettyPrint();

        // Fetch productId from the response and compare
        String actualProductId = cm.getResponse().jsonPath().getString("id");
        Assert.assertEquals("Product ID does not match", expectedProductId, actualProductId);
    }
}