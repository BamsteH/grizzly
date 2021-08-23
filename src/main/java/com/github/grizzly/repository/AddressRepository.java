package com.github.grizzly.repository;

import com.github.grizzly.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    Optional<Address>findById(long userId);

}
