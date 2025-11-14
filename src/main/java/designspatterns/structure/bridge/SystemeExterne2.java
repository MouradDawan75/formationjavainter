package designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;

public class SystemeExterne2 {

    public List<Produit> getProduits(){
        List<Produit> prods = new ArrayList<>();
        prods.add(new Produit(1, "pc dell", 1500));
        prods.add(new Produit(2, "ecran hp", 50));

        return prods;
    }
}

class Produit{
    private int id;
    private String name;
    private double price;

    public Produit(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
