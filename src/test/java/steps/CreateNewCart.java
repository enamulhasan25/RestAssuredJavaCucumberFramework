package steps;

import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class CreateNewCart {

    private String actualCartIdFromResponse;

    public String getActualCartIdFromResponse() {
        return actualCartIdFromResponse;
    }

    public void setActualCartIdFromResponse(String actualCartIdFromResponse) {
        this.actualCartIdFromResponse = actualCartIdFromResponse;
    }

    @Then("capture the cartId from the response")
    public void createNewCart() {
        actualCartIdFromResponse = CommonValidations.res.jsonPath().getString("cartId").trim();
        out.println("Newly created cart id is : " + actualCartIdFromResponse);
    }
}