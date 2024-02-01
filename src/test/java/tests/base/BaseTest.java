package tests.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class BaseTest {
  RequestBaseTest requestBaseTest = new RequestBaseTest();

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
