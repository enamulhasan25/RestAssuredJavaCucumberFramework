package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class GetAllProductsList {

    // Accessing Singleton instance from the common Validations Class
    CommonValidations cm = CommonValidations.getInstance();

    @Then("print the list of products from the response")
    public void printListOfAllProducts() {
        out.println(cm.getRes().body().prettyPrint());
    }
}