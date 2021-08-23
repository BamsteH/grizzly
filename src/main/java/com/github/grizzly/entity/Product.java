package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", columnDefinition = "VARCHAR(64)")
    private String name;

    @NotNull
    @Column(name = "description", columnDefinition = "VARCHAR(256)")
    private String description;

    @NotNull
    @Column(name = "image")
    private String mainImage;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    private List<String> images = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    private Set<SpecificationValue> specificationValues = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Promotion> promotions = new HashSet<>();

    public Product(
            String name,
            String description,
            String mainImage,
            BigDecimal price,
            int quantity,
            Category category
    ) {
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(
            Long id,
            String name,
            String description,
            String mainImage,
            BigDecimal price,
            int quantity,
            Category category
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mainImage = mainImage;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }

}