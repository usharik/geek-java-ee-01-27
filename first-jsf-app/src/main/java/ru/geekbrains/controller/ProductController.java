package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ProductRepr;
import ru.geekbrains.service.ProductService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private ProductService productService;

    @EJB
    private CategoryRepository categoryRepository;

    private ProductRepr product;

    private List<ProductRepr> products;

    private List<Category> categories;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        products = productService.findAll();
        categories = categoryRepository.findAll();
    }

    public ProductRepr getProduct() {
        return product;
    }

    public void setProduct(ProductRepr product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new ProductRepr();
        return "/product_form.xhtml?faces-redirect=true";
    }

    public List<ProductRepr> getAllProducts() {
        return products;
    }

    public String editProduct(ProductRepr product) {
        this.product = product;
        return "/product_form.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductRepr product) {
        productService.deleteById(product.getId());
    }

    public String saveProduct() {
        productService.saveOrUpdate(product);
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
