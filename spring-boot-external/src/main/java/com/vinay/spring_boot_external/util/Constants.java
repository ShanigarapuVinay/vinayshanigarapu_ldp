package com.vinay.spring_boot_external.util;

public class Constants {
    private Constants(){
        throw new UnsupportedOperationException("This util class can't be instantiated");
    }

    public static final String PRODUCT_BASE = "/products";
    public static final String PRODUCT_ID = "/{id}";

    public static final String CART_BASE = "/carts";
    public static final String CART_ID = "/{id}";
    public static final String CART_ID_PRODUCTS = "/{id}/products";
    public static final String CART_ID_PRODUCTS_PRODUCT_ID = "/{cartId}/products/{productId}";

    public static final String ORDER_BASE = "/orders";
    public static final String ORDER_ID = "/{id}";
    public static final String SAVE_CART = "/save-cart/{cartId}";
}
