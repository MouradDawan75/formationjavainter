package javainter.hexagonale.application;

import javainter.hexagonale.domain.CartApi;
import javainter.hexagonale.domain.entities.Cart;

public class CartController {

    private CartApi cartService;

    public CartController(CartApi cartService) {
        this.cartService = cartService;
    }

    public CartDto getCart(String cartId){
        Cart cart = cartService.getCart(cartId);
        return  CartDto.fromEntity(cart);
    }


    public CartDto addProductToCart(String productRef, int quantityRequest, String cartId){
        Cart cart = cartService.addProductToCart(productRef, quantityRequest, cartId);
        return CartDto.fromEntity(cart);
    }

}
