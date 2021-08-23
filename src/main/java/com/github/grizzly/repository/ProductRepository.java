package com.github.grizzly.repository;

import com.github.grizzly.entity.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Optional<Product> findByName(@NonNull String name);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByCategoryName(String name);

}
