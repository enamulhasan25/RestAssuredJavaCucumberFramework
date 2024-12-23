package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static java.lang.System.out;

public class GetSingleProduct {

    @Then("productId {string} should display in the response payload")
    public void productIdShouldDisplayInTheResponsePayload(String expectedProductId) {
        String actualResponsePayload = CommonValidations.res.getBody().asString(); // res is a shared variable and accessed directly from the other class object.
        out.println(actualResponsePayload);

        // Fetch productId from the response and compare
        String actualProductId = CommonValidations.res.jsonPath().getString("id");
        Assert.assertEquals("Product ID does not match", expectedProductId, actualProductId);
    }
}