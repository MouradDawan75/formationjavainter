package designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;

public class ProductBridge implements Bridge{

    @Override
    public List<ProductEntity> getAllProducts(Object systemExterne) {

        List<ProductEntity> result = new ArrayList<>();

        if(systemExterne instanceof SystemeExterne1){
            SystemeExterne1 sys = (SystemeExterne1) systemExterne;
            List<Product> products = sys.getProducts();

            result = products.stream()
                    .map(p -> new ProductEntity(p.getId(), p.getDescription()))
                    .toList();
        }

        if(systemExterne instanceof SystemeExterne2){
            SystemeExterne2 sys = (SystemeExterne2) systemExterne;
            List<Produit> products = sys.getProduits();

            result = products.stream()
                    .map(p -> new ProductEntity(p.getId(), p.getName()))
                    .toList();
        }



        return result;
    }
}
