package com.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UPITransferServiceApiTest extends BaseTransferApiTest {

  // Junit + Hamcrest + Rest Assured
  // @Test
  public void transferMoneyTest() {

    String requestBody = """
        {
          "fromAccountNumber": "1234567890",
          "toAccountNumber": "0987654321",
          "amount": 100.0
        }
        """;

    given()
        .spec(transferRequestSpec)
        .body(requestBody)
        .when()
        .post()
        .then()
        .spec(transferResponseSpec)
        .body("status", equalTo("success"));

  }

}
