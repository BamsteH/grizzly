package com.github.grizzly.controller;

import com.github.grizzly.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAll();

    @PostMapping
    ProductDto save(@RequestBody ProductDto payload);

    @PutMapping
    void update(@RequestBody ProductDto payload);

    @DeleteMapping(path = "/{id}")
    void deleteById(@PathVariable(name = "id") Long id);

}
