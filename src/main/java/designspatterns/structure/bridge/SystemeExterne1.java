package designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;

public class SystemeExterne1 {

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "tv"));
        products.add(new Product(2, "phone"));
        return products;
    }

}

class Product{
    private int id;
    private String description;

    public Product(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
