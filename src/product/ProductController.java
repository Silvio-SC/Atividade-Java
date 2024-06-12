package product;

import java.util.ArrayList;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

public class ProductController {

    public ArrayList<ProductModel> products = new ArrayList<>();

    
    public void createProduct (String barCode, String name, Integer priceInCents, Integer stock) throws Exception{
        
        try {
            for (Integer i = 0; i < products.size(); i++) {
                if(name == products.get(i).name) {
                    throw new Exception("Nome já existe.");
                }

                if(barCode == products.get(i).barCode) {
                    throw new Exception("barCode já existe.");
                }
            }

            if (priceInCents < 0) {
                throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
            }

            ProductModel novoProduto = new ProductModel(barCode, name, priceInCents, stock);

            products.add(novoProduto);
    
            System.out.println("Produto " + name + " adicionado.");

        } catch (NegativePriceException e) {
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        };
        
    };

    public void read () throws Exception{
        
        try {
            if (products.size() == 0) {
                throw new NotFoundException("Não há produtos cadastrados");
            }

            for (Integer i = 0; i < products.size(); i++) {
                ProductModel product = products.get(i);
                System.out.println("Nome do produto: " + product.name + 
                ", Preço: " + product.priceInCents + ", stock: " + product.stock
                + ", codigo de barras: " + product.barCode  );
            }
    

        } catch (Exception e) {
            System.out.println(e.getMessage());
        };
        
    };

    public Integer retrievePrice(String barCode) throws Exception{
        
        int price = -1;

        try {
            if (products.size() == 0) {
                throw new Exception("Não há produtos cadastrados");
            }

            for (Integer i = 0; i < products.size(); i++) {
                if (products.get(i).barCode == barCode){
                    price = products.get(i).priceInCents;
                };
            }

            if (price == -1) {
                throw new NotFoundException();
            };
    

        } catch (Exception e) {
            System.out.println(e.getMessage());
        };
        
        return price;
    };

}
