package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static java.lang.System.out;

public class GetSingleProduct {

    // Accessing Singleton instance from the common Validations Class
    CommonValidations cm = CommonValidations.getInstance();

    @Then("productId {string} should display in the response payload")
    public void productIdShouldDisplayInTheResponsePayload(String expectedProductId) {
        cm.getRes().body().prettyPrint();

        // Fetch productId from the response and compare
        String actualProductId = cm.getRes().jsonPath().getString("id");
        Assert.assertEquals("Product ID does not match", expectedProductId, actualProductId);
    }
}