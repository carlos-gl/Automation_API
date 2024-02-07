package tests.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestBase {

  public Response getStatusApplication(){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .get("/test")
            .then()
            .extract().response();
  }

}
