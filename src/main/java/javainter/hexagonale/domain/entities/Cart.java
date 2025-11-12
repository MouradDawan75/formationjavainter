package javainter.hexagonale.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String id;
    private List<Product> products = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double totalCartAmount(){

        double cartAmount = products.stream()
                .map(p -> p.getPrice() * p.getQuantityBought())
                .reduce(0.0, Double::sum);

        if(cartAmount > 100){
            cartAmount = cartAmount * 0.9;
        }

        return cartAmount;
    }
}
