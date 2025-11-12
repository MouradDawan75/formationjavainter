package javainter.hexagonale.domain;

import javainter.hexagonale.domain.entities.Cart;
import javainter.hexagonale.domain.entities.Product;

public class CartService implements CartApi{

    private StockSpi stockSpi;
    private ProductSpi productSpi;
    private CartPersistenceSpi cartPersistenceSpi;

    public CartService(StockSpi stockSpi, ProductSpi productSpi) {
        this.stockSpi = stockSpi;
        this.productSpi = productSpi;
    }

    @Override
    public Cart getCart(String cartId) {
        return cartPersistenceSpi.getCart(cartId);
    }

    @Override
    public Cart addProductToCart(String productRef, int quantityRequest, String cartId) {
        Product product = productSpi.retrieveProduct(productRef);
        int quantityAvailable = stockSpi.getProductAvailability(productRef);
        int quantityBought = Math.min(quantityAvailable, quantityRequest);

        Product productToAdd = product;
        productToAdd.setQuantityAvailable(quantityAvailable);
        productToAdd.setQuantityBought(quantityBought);

        Cart cart = cartPersistenceSpi.getCart(cartId);
        cart.getProducts().add(productToAdd);


        return cartPersistenceSpi.updateCart(cart);
    }
}
