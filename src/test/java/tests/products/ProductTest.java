package tests.products;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class ProductTest extends BaseTest {

  Faker faker = new Faker();
  RequestProduct requestProduct = new RequestProduct();

  @Test
  public void getProductsWithAuthorization() {
    requestProduct.getProductsWithAuthorization()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }

  @Test
  public void GetProductsWithoutAuthorizationInPathAuth() {
    requestProduct.getProductsWithoutAuthorization()
            .then()
            .statusCode(HttpStatus.SC_FORBIDDEN);
  }

  @Test
  public void getProducts()  {
    requestProduct.getProductsInPathNoAuthorization()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }

  @Test
  public void getProductById()  {
    requestProduct.getProductsInPathNoAuthorizationById(1)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("id", Matchers.equalTo(1));
  }

  @Test
  public void AddNewProduct()  {
    requestProduct.postProducts(faker.commerce().productName(), faker.lorem().word(),
                    faker.number().randomNumber(), faker.number().numberBetween(1, 10),
                    faker.number().numberBetween(1, 10), faker.number().randomNumber(),
                    faker.lorem().word(), faker.commerce().material(), "https://i.dummyjson.com/data/products/11/thumnail.jpg")
            .then()
            // Expected status is 201 but is returning status 200
            .statusCode(HttpStatus.SC_CREATED);
  }
}
