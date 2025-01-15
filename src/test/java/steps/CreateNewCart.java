package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class CreateNewCart {

    // Accessing Singleton instance from the common Validations Class
    CommonValidations cm = CommonValidations.getInstance();

    // Instance variable
    private String newlyCreatedCartId;

    public String getActualCartIdFromResponse() {
        return newlyCreatedCartId;
    }

    public void setActualCartIdFromResponse(String actualCartIdFromResponse) {
        this.newlyCreatedCartId = actualCartIdFromResponse;
    }

    @Then("capture the cartId from the response")
    public void createNewCart() {
        cm.getRes().body().prettyPrint();
        newlyCreatedCartId = cm.getRes().jsonPath().getString("cartId").trim();
        out.println("Newly created cart id is : " + newlyCreatedCartId);
    }
}