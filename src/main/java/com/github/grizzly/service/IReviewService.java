package com.github.grizzly.service;

import com.github.grizzly.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReviewService {

    List<Review> findAllByProduct(Long idProduct);

    List<Review> findAllByUserId(Long idUser);

    void save(Review review);

    Review update(Review review);

}
