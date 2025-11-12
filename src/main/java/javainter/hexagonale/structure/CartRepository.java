package javainter.hexagonale.structure;

import javainter.hexagonale.domain.CartPersistenceSpi;
import javainter.hexagonale.domain.entities.Cart;

public class CartRepository implements CartPersistenceSpi {

    //utilisation d'un repository ppur l'accès à la BD

    @Override
    public Cart getCart(String cartId) {
        return null;
    }

    @Override
    public Cart updateCart(Cart cart) {
        return null;
    }
}
