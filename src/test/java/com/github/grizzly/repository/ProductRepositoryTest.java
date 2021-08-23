package com.github.grizzly.repository;

import com.github.grizzly.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.grizzly.repository.ProductRepositoryMock.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findByName() {
        Product act = ProductRepositoryMock.product1();
        Product exp = productRepository.findByName("product1_name").orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findById() {
        Product act = ProductRepositoryMock.product2();
        Product exp = this.productRepository.findById(2L).orElseThrow();
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findAllByCategoryId() {
        List<Product> exp = productsByCategoryByIdTwo();
        List<Product> act = this.productRepository.findAllByCategoryId(2L);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findAllByCategoryName() {
        List<Product> exp = productsByCategoryByNameOne();
        List<Product> act = this.productRepository.findAllByCategoryName("category1_name");
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql(value = {"grizzly-schema-product.sql", "grizzly-product-data.sql"})
    public void findAllProducts() {
        List<Product> exp = products();
        List<Product> act = this.productRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }
}