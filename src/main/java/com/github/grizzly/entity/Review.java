package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "review")
@NoArgsConstructor
@EqualsAndHashCode
public class Review {

    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private long idReviewer;

    @Column(name = "review", columnDefinition = "VARCHAR(256)")
    private String review;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Date createdAt;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private long productId;

    @NotNull
    @Column(name = "rate", nullable = false)
    private int rate;

    public Review(long idReviewer, String review, Date createdAt, long productId, int rate) {
        this.idReviewer = idReviewer;
        this.review = review;
        this.createdAt = createdAt;
        this.productId = productId;
        this.rate = rate;
    }
}
