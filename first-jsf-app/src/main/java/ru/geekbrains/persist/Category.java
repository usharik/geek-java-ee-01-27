package ru.geekbrains.persist;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "findAllCategories", query = "from Category"),
        @NamedQuery(name = "countAllCategories", query = "select count(*) from Category"),
        @NamedQuery(name = "deleteCategoryById", query = "delete from Category p where p.id = :id"),
        @NamedQuery(name = "allProductsByCategoryId",
                query = "select p " +
                        "from Product p " +
                        "inner join Category c on p.category.id = c.id " +
                        "where c.id = :id")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "nativeQuery", query = "select * from categories")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
