package com.github.grizzly.repository;

import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.github.grizzly.repository.OrderRepositoryMock.*;
import static com.github.grizzly.repository.UserRepositoryMocks.user_1;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value="test")
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void findAll(){
        List<Order> exp = OrderRepositoryMock.orders();
        List<Order> act = orderRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldFindAllOrders(){
        List<Order> exp = ordersUser1Desc();
        User user = user_1();
        List<Order> act = this.orderRepository.findAllByUserOrderByCreateDateDesc(user);
        Assert.assertEquals(exp, act);
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldSaveOrders(){
        Order act = orderAlwaysNew5();
        Order exp = this.orderRepository.save(act);
        act.setCreateDate(exp.getCreateDate());
        act.setModifyDate(exp.getModifyDate());
        Assert.assertEquals(act, exp);
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldSaveListOrders(){
        Order orderFive = orderAlwaysNew5();
        Order orderSix = orderAlwaysNew6();
        List <Order> newOrders = List.of(orderFive, orderSix);
        List<Order> act = this.orderRepository.saveAll(newOrders);
        orderFive.setCreateDate(act.get(0).getCreateDate());
        orderFive.setModifyDate(act.get(0).getModifyDate());
        orderSix.setCreateDate(act.get(1).getCreateDate());
        orderSix.setModifyDate(act.get(1).getModifyDate());
        List<Order> exp = List.of(orderFive, orderSix);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldFindOrderById(){
        long id = 2L;
        Order act = order2();
        Order exp = this.orderRepository.getById(id);
        Assert.assertEquals(act, exp);
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldFindOrderByStatus(){
        List<Order> exp = ordersWithCompletedStatus();
        List<Order> act = this.orderRepository.findOrderByStatus(Status.COMPLETED);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldFindAllById(){
        List<Order> exp = ordersById();
        List<Long> ids = List.of(1L,3L);
        List<Order> act = this.orderRepository.findAllById(ids);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldDeletedById(){
        long id = 2L;
        this.orderRepository.deleteById(id);
        List<Order> exp = ordersAfterDelete();
        List<Order> act = orderRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldDeletedAll(){
        this.orderRepository.deleteAll();
        List<Order> exp = new ArrayList<>();
        List<Order> act = orderRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-schema-order.sql", "grizzly-data-order.sql"})
    public void shouldDeleteById(){
        List<Order> exp = ordersById();
        List<Long> ids = List.of(2L,4L);
        this.orderRepository.deleteAllById(ids);
        List<Order> act = orderRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }
}