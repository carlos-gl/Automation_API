package tests.products;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.ProductsPayload;
import tests.login.RequestLogin;

import static io.restassured.RestAssured.given;

public class RequestProduct extends RequestLogin {

  private final String PATH_AUTH_PRODUCTS = "/auth/products";
  private final String PATH_PRODUCTS = "/products";

  public Response getProductsWithAuthorization(){
    return given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + getBearerToken("kminchelle", "0lelplR"))
            .when()
            .get(PATH_AUTH_PRODUCTS)
            .then()
            .extract().response();
  }
  public Response getProductsWithoutAuthorization(){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .get(PATH_AUTH_PRODUCTS)
            .then()
            .extract().response();
  }

  public Response getProductsInPathNoAuthorization(){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .get(PATH_PRODUCTS)
            .then()
            .extract().response();
  }

  public Response getProductsInPathNoAuthorizationById(int ID){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .pathParam("id", ID)
            .get(PATH_PRODUCTS + "/{id}")
            .then()
            .extract().response();
  }

  public Response postProducts(String title, String description, float price, float discountPercentage, float rating, float stock, String brand, String category, String thumbnail){
    return given()
            .contentType(ContentType.JSON)
            .when()
            .body(ProductsPayload.toJson(title, description, price, discountPercentage, rating, stock, brand, category, thumbnail))
            .post(PATH_PRODUCTS + "/Add");
  }

}
