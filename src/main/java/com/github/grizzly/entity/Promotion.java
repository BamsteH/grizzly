package com.github.grizzly.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "promotions")
@NoArgsConstructor
public class Promotion {

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private long product_id;

    @Column(name = "percent")
    private int percent;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public Promotion(long product_id, int percent, Date startDate, Date endDate) {
        this.product_id = product_id;
        this.percent = percent;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
