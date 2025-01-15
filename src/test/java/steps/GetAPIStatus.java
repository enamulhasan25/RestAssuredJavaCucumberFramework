package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static java.lang.System.out;

public class GetAPIStatus {

    // Accessing Singleton instance from the CommonValidations Class
    CommonValidations cm = CommonValidations.getInstance();

    @Then("validate the status value as {string} from response payload")
    public void validateTheStatusValueAsUPFromResponsePayload(String expectedStatus) {
        String actualResponsePayload = cm.getRes().getBody().asString(); // res is a shared variable and accessed directly from the other class object.
        out.println(actualResponsePayload);
        String statusValueFromResponsePayload = cm.getRes().jsonPath().getString("status").trim();
        Assert.assertEquals("The status value does not match", expectedStatus, statusValueFromResponsePayload);
    }
}