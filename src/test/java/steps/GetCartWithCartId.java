package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class GetCartWithCartId {

    @Then("print the response payload")
    public void printTheResponsePayload() {
        String actualResponsePayload = CommonValidations.res.getBody().asString();
        out.println(actualResponsePayload);
    }
}