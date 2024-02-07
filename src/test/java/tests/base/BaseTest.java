package tests.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class BaseTest {
  RequestBase requestBaseTest = new RequestBase();

  @BeforeAll
  public static void setUp() {
    RestAssured.baseURI = Utils.getBaseUrl();
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

  }
  @Test
  public void checkStatusApplication(){
    requestBaseTest.getStatusApplication()
            .then()
            .statusCode(200);
  }
}
