package payloads;

import com.google.gson.Gson;
import payloads.model.ProductsModel;

public class ProductsPayload {

  public static String toJson(String title, String description, float price, float discountPercentage, float rating, float stock, String brand, String category, String thumbnail){
    ProductsModel productsModel = new ProductsModel(title, description, price, discountPercentage, rating, stock, brand, category, thumbnail);
    return new Gson().toJson(productsModel);
  }
}
