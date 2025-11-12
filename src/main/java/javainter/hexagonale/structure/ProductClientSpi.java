package javainter.hexagonale.structure;

import javainter.hexagonale.domain.ProductSpi;
import javainter.hexagonale.domain.entities.Product;

public class ProductClientSpi implements ProductSpi {
    @Override
    public Product retrieveProduct(String productRef) {

        //appel du système distant -< récupérer

        return null;
    }
}
