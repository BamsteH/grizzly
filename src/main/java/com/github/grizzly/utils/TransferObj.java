package com.github.grizzly.utils;

import com.github.grizzly.dto.ProductDto;
import com.github.grizzly.entity.Product;

public class TransferObj {

    public static Product toProduct(ProductDto data) {
        return new Product(
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity(),
                data.getCategory()
        );
    }

    public static ProductDto fromProduct(Product data) {
        return new ProductDto(
                data.getName(),
                data.getDescription(),
                data.getMainImage(),
                data.getPrice(),
                data.getQuantity(),
                data.getCategory()
        );
    }

}
