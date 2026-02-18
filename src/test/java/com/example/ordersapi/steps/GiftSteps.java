package com.example.ordersapi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private Map<String, Object> giftRequest;
    private Long giftId;
    private ResponseEntity<?> response;

    // ---------- GIVEN ----------

    @Given("a gift with product {string}, quantity {int} and description {string}")
    public void givenGift(String product, int quantity, String description) {
        giftRequest = new HashMap<>();
        giftRequest.put("product", product);
        giftRequest.put("quantity", quantity);
        giftRequest.put("description", description);
    }

    @Given("an existing gift with product {string}, quantity {int} and description {string}")
    public void givenExistingGifts(String product, int quantity, String description) {
        Map<String, Object> request = new HashMap<>();
        request.put("product", product);
        request.put("quantity", quantity);
        request.put("description", description);

        ResponseEntity<Map> createResponse =
                restTemplate.postForEntity("/gifts", request, Map.class);

        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(createResponse.getBody()).isNotNull();

        this.giftId = ((Number) createResponse.getBody().get("id")).longValue();
    }

    // ---------- WHEN ----------

    @When("the gift is saved")
    public void whenGiftIsSaved() {
        ResponseEntity<Map> createResponse =
                restTemplate.postForEntity("/gifts", giftRequest, Map.class);

        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(createResponse.getBody()).isNotNull();

        this.giftId = ((Number) createResponse.getBody().get("id")).longValue();
    }

    @When("the gift is deleted")
    public void whenGiftIsDeleted() {
        restTemplate.delete("/gifts/" + giftId);
    }

    @When("I request a gift with id {int}")
    public void whenRequestGiftsById(Integer id) {
        response = restTemplate.getForEntity("/gifts/{id}", String.class, id);
    }

    @When("I delete a gift with id {int}")
    public void whenDeleteGiftById(Integer id) {
        restTemplate.delete("/gifts/{id}", id);
        response = restTemplate.getForEntity("/gifts/{id}", String.class, id);
    }

    @When("I request all gifts")
    public void whenRequestAllGifts() {
        response = restTemplate.getForEntity("/gifts", Object[].class);
    }

    @When("I create a gift with invalid payload")
    public void whenCreateInvalidGift() {
        response = restTemplate.postForEntity("/gifts", "invalid-json", String.class);
    }

    // ---------- THEN ----------

    @Then("the gift is persisted successfully")
    public void thenGiftPersistedSuccessfully() {
        ResponseEntity<Map> getResponse =
                restTemplate.getForEntity("/gifts/" + giftId, Map.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).isNotNull();
        assertThat(((Number) getResponse.getBody().get("id")).longValue())
                .isEqualTo(giftId);
    }

    @Then("the gift no longer exists")
    public void thenGiftNoLongerExists() {
        ResponseEntity<String> getResponse =
                restTemplate.getForEntity("/gifts/" + giftId, String.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Then("the response status should be {int}")
    public void thenResponseStatusShouldBe(Integer status) {
        assertThat(response.getStatusCode().value()).isEqualTo(status);
    }
}
