package tests.user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestUser {

  private final String PATH_USERS = "/users";
  public Response getUser(){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .get(PATH_USERS)
            .then()
            .extract().response();
  }

}
