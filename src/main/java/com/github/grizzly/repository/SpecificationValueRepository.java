package com.github.grizzly.repository;

import com.github.grizzly.entity.SpecificationValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecificationValueRepository extends JpaRepository<SpecificationValue, Long> {

    Optional<SpecificationValue> findById(long id);

    List<SpecificationValue> findAllBySpecificationId(long specificationId);

    List<SpecificationValue> findAllByProductId(long productId);

}
