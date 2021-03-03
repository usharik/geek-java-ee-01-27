package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {

    List<ProductRepr> findAll();

    ProductRepr findById(Long id);

    Long countAll();

    void saveOrUpdate(ProductRepr product);

    void deleteById(Long id);
}
