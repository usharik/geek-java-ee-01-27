package ru.geekbrains.persist;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "from Product"),
        @NamedQuery(name = "countAll", query = "select count(*) from Product"),
        @NamedQuery(name = "deleteById", query = "delete from Product p where p.id = :id")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(length = 1024)
    private String description;

    @Column
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
