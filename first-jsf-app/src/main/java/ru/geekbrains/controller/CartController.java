package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    // TODO
    private final Map<Long, ProductRepr> productMap = new HashMap<>();

    public void addToCart(ProductRepr product) {
        productMap.put(product.getId(), product);
    }

    public void removeFromCart(ProductRepr product) {
        productMap.remove(product.getId());
    }

    public List<ProductRepr> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
}
