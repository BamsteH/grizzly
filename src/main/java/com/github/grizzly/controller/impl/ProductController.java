package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IProductController;
import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.service.IProductService;
import com.github.grizzly.utils.TransferObj;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.TransferObj.fromProduct;
import static com.github.grizzly.utils.TransferObj.toProduct;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService productService;

    @Override
    public List<ProductDto> findAll() {
        return this.productService.readAll().stream()
                .map(TransferObj::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto payload) {
        return fromProduct(this.productService.create(toProduct(payload)));
    }

    @Override
    public void update(ProductDto payload) {
        this.productService.update(toProduct(payload));
    }

    @Override
    public void deleteById(Long id) {
        this.productService.deleteById(id);
    }
}
