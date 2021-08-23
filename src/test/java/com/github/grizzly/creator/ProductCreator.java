package com.github.grizzly.creator;

import com.github.grizzly.entity.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductCreator {

    public static final String NAME = "Test";
    public static final String DESCRIPTION = "TestDescription";
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static final int QUANTITY = 100;

    public static Product createTestProduct(){
        Product testProduct = new Product();

        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);
        testProduct.setQuantity(QUANTITY);

        return testProduct;
    }

    public static Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }

}
