package ru.geekbrains.service;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProductServiceRemote {

    List<ProductRepr> findAll();

    ProductRepr findById(Long id);

    Long countAll();
}
