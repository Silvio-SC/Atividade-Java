package product;

public class ProductModel {
    String barCode;
    String name;
    Integer priceInCents;
    Integer stock;

    public ProductModel(String barCode, String name, Integer priceInCents, Integer stock) {
        this.barCode = barCode;
        this.name = name;
        this.priceInCents = priceInCents;
        this.stock = stock;
    };


}
