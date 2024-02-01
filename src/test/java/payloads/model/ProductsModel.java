package payloads.model;
public class ProductsModel {

  private String title;
  private String description;
  private float price;
  private float discountPercentage;
  private float rating;
  private float stock;
  private String brand;
  private String category;
  private String thumbnail;

  public ProductsModel(String title, String description, float price, float discountPercentage, float rating, float stock, String brand, String category, String thumbnail){
    this.title = title;
    this.description = description;
    this.price = price;
    this.discountPercentage = discountPercentage;
    this.rating = rating;
    this.stock = stock;
    this.brand = brand;
    this.category = category;
    this.thumbnail = thumbnail;
  }
}
