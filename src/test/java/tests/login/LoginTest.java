package tests.login;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

  RequestLoginTest loginRequest = new RequestLoginTest();

  @Test
  @Tag("todos")
  public void SucessLogin() throws Exception {
    loginRequest.login("kminchelle", "0lelplR" )
            .then()
            .statusCode(HttpStatus.SC_OK);
  }

  @Test
  @Tag("todos")
  public void LoginWithInvalidUsername() throws Exception {
    loginRequest.login("invalidUser", "0lelplR")
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("message", Matchers.equalTo("Invalid credentials"));
  }

  @Test
  @Tag("todos")
  public void LoginWithInvalidPassword() throws Exception {
    loginRequest.login("kminchelle", "invalidPass")
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("message", Matchers.equalTo("Invalid credentials"));
  }
}
