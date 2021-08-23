package com.github.grizzly.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "specification_values")
@NoArgsConstructor
public class SpecificationValue {

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "specification_id")
    private long specificationId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specification_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Specification specification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public SpecificationValue(long specificationId, long productId, String value) {
        this.specificationId = specificationId;
        this.productId = productId;
        this.value = value;
    }
}
