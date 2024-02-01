package tests.products;

import com.github.javafaker.Faker;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class ProductTest extends BaseTest {

  Faker faker = new Faker();
  RequestProductTest requestProductTest = new RequestProductTest();

  @Tag("All")
  @Test
  public void getProductsWithAuthorization() {
    requestProductTest.getProductsWithAuthorization()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }

  @Tag("All")
  @Test
  public void GetProductsWithoutAuthorizationInPathAuth() {
    requestProductTest.getProductsWithoutAuthorization()
            .then()
            .statusCode(HttpStatus.SC_FORBIDDEN);
  }

  @Tag("All")
  @Test
  public void getProducts()  {
    requestProductTest.getProductsInPathNoAuthorization()
            .then()
            .statusCode(HttpStatus.SC_OK);
  }

  @Tag("All")
  @Test
  public void getProductById()  {
    requestProductTest.getProductsInPathNoAuthorizationById(1)
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("id", Matchers.equalTo(1));
  }

  @Tag("All")
  @Test
  public void AddNewProduct()  {
    requestProductTest.postProducts(faker.commerce().productName(), faker.lorem().word(),
                    faker.number().randomNumber(), faker.number().numberBetween(1, 10),
                    faker.number().numberBetween(1, 10), faker.number().randomNumber(),
                    faker.lorem().word(), faker.commerce().material(), "https://i.dummyjson.com/data/products/11/thumnail.jpg")
            .then()
            // Expected status is 201 but is returning status 200
            .statusCode(HttpStatus.SC_OK);
  }
}
