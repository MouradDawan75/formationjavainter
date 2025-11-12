package javainter.hexagonale.domain;

import javainter.hexagonale.domain.entities.Product;

public interface ProductSpi {
    Product retrieveProduct(String productRef);
}
