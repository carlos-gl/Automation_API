package tests.login;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import payloads.LoginPayload;

import static io.restassured.RestAssured.*;

public class RequestLogin {

  private final String PATH_LOGIN = "/auth/login";
  public Response login(String username, String password) {
    return given()
            .header("accept", "application/json")
            .header("Content-Type", "application/json")
            .when()
            .body(LoginPayload.toJson(username, password))
            .post(PATH_LOGIN);
  }

  public String getBearerToken(String username, String password) {
    return login(username, password)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .path("token");
  }
}
