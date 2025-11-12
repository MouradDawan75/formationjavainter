package javainter.hexagonale.domain;

import javainter.hexagonale.domain.entities.Cart;

public interface CartApi {
    Cart getCart(String cartId);
    Cart addProductToCart(String productRef, int quantityRequest, String cartId);
}
