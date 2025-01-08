package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.System.out;

public class AddAnItemToCart {

    private String actualItemIdFromResponse;

    public final String jsonFilePath = "src/test/resources/requestPayloads/addItemToCart.json";

    public JSONObject getProductIdFromRequestPayloadTemplate() throws IOException {
        String content = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        return new JSONObject(content);
    }

    @Given("I have request payload to add an item to cart")
    public void iHaveRequestPayloadToAddAnItemToCart() throws IOException {
        JSONObject payload = getProductIdFromRequestPayloadTemplate();
        out.println("Request Payload: " + payload.toString());
    }

    @Then("capture the itemId from the response")
    public void captureItemIdFromResponse() {
        CommonValidations.res.body().prettyPrint();
        actualItemIdFromResponse = CommonValidations.res.jsonPath().getString("itemId").trim();
        out.println("Captured ItemId: " + actualItemIdFromResponse);
    }
}