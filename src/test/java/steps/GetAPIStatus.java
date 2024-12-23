package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static java.lang.System.out;

public class GetAPIStatus {

    @Then("validate the status value as {string} from response payload")
    public void validateTheStatusValueAsUPFromResponsePayload(String expectedStatus) {
        String actualResponsePayload = CommonValidations.res.getBody().asString(); // res is a shared variable and accessed directly from the other class object.
        out.println(actualResponsePayload);
        String statusValueFromResponsePayload = CommonValidations.res.jsonPath().getString("status").trim();
        Assert.assertEquals("The status value does not match", expectedStatus, statusValueFromResponsePayload);
    }
}