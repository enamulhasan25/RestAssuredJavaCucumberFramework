package steps;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;

import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class GetProductsByCategory {

    @Then("all products should have the category {string}")
    public void all_products_should_have_the_category(String expectedCategory) {
        JsonPath jsonPath = CommonValidations.res.jsonPath();
        List<Map<String, Object>> products = jsonPath.getList("$");
        out.println("All products are: "+ products);

        boolean allMatch = products.stream()
                .allMatch(product -> product.get("category").equals(expectedCategory));
        out.println("All categories of coffee are: "+ allMatch);
        Assert.assertTrue("Not all products have the category: " + expectedCategory, allMatch);
    }
}