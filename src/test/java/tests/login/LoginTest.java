package tests.login;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {

  RequestLogin loginRequest = new RequestLogin();

  @Test
  public void SucessLogin() {
    loginRequest.login("kminchelle", "0lelplR" )
            .then()
            .statusCode(HttpStatus.SC_CREATED);
  }

  @Test
  public void LoginWithInvalidUsername() {
    loginRequest.login("invalidUser", "0lelplR")
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("message", Matchers.equalTo("Invalid credentials"));
  }

  @Test
  public void LoginWithInvalidPassword() {
    loginRequest.login("kminchelle", "invalidPass")
            .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .body("message", Matchers.equalTo("Invalid credentials"));
  }
}
