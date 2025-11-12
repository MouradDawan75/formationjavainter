package javainter.hexagonale.domain;

import javainter.hexagonale.domain.entities.Cart;

public interface CartPersistenceSpi {
    Cart getCart(String cartId);
    Cart updateCart(Cart cart);
}
