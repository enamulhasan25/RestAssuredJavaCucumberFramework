package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class CreateNewCart {

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
        CommonValidations.res.body().prettyPrint();
        newlyCreatedCartId = CommonValidations.res.jsonPath().getString("cartId").trim();
        out.println("Newly created cart id is : " + newlyCreatedCartId);
    }
}