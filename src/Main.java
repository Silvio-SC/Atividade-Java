import product.ProductController;

public class Main {
    // atributos auxiliares para teste (caso precise).
    public static void main(String[] args) throws Exception {
        ProductController productController = new ProductController(); 

        productController.createProduct("0001", "Banana", 0, 100);
        productController.createProduct("0002", "Lapis", 500, 100);
        productController.createProduct("0003", "Carro", 20, 100);
        
        System.out.println(productController.retrievePrice("0004"));

    }

    // métodos auxiliares para teste (caso precise).
}
