package tests.user;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;


public class UserTest extends BaseTest {

  RequestUserTest requestUserTest = new RequestUserTest();

  @Tag("All")
  @Test
  public void returnStatusCode200() throws Exception {
    requestUserTest.getUser()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }
}
