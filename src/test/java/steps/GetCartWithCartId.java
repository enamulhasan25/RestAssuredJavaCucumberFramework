package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class GetCartWithCartId {

    // Accessing Singleton instance from the common Validations Class
    CommonValidations cm = CommonValidations.getInstance();

    @Then("print the response payload")
    public void printTheResponsePayload() {
        cm.getRes().body().prettyPrint();
    }
}