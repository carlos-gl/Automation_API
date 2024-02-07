package tests.user;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;


public class UserTest extends BaseTest {

  RequestUser requestUserTest = new RequestUser();

  @Test
  public void returnStatusCode200() {
    requestUserTest.getUser()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }
}
