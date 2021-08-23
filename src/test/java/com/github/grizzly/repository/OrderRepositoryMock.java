package com.github.grizzly.repository;

import com.github.grizzly.entity.Order;
import com.github.grizzly.entity.User;
import com.github.grizzly.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepositoryMock {

    public static User user1() {
        return new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"
        );
    }

    public static User user2() {
        return new User(2L,
                "user2_firstName",
                "user2_lastName",
                "user2_login",
                "user2_password",
                "user2_@email.com",
                "user2_phone"
        );
    }

    public static Order order1() {
        Order order1 = new Order(
                    1L,
                    LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40),
                    LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40),
                    new BigDecimal("100.01"),
                    Status.OPEN,
                    new ArrayList<> (),
                    user1()
            );
        return order1;
    }

    public static Order order2() {
        Order order2 = new Order(
                    2L,
                    LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40),
                    LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40),
                    new BigDecimal("50.99"),
                    Status.OPEN,
                    new ArrayList<> (),
                    user2()
            );
        return order2;
    }

    public static Order order3() {
        Order order3 = new Order(
                3L,
                LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
                LocalDateTime.of(2020, Month.JULY, 29, 19, 30, 40),
                new BigDecimal("1.09"),
                Status.OPEN,
                new ArrayList<> (),
                user1()
        );
        return order3;
    }

    public static Order orderAlwaysNew5() {
        Order order5 = new Order(
                5L,
                LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
                LocalDateTime.of(2021, Month.APRIL, 29, 19, 30, 40),
                new BigDecimal("1.09"),
                Status.OPEN,
                new ArrayList<> (),
                user1()
        );
        return order5;
    }

    public static Order orderAlwaysNew6() {
        Order order6 = new Order(
                6L,
                LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
                LocalDateTime.of(2021, Month.MAY, 29, 19, 30, 40),
                new BigDecimal("100"),
                Status.COMPLETED,
                new ArrayList<> (),
                user2()
        );
        return order6;
    }

    public static Order order4() {
        return new Order(
                4L,
                LocalDateTime.of(2020, Month.MARCH, 29, 19, 30, 40),
                LocalDateTime.of(2020, Month.MARCH, 29, 19, 30, 40),
                new BigDecimal("1111.09"),
                Status.COMPLETED,
                new ArrayList<>(),
                user1()
        );
    }

    public static List<Order> orders() {
        return List.of(
                order1(),
                order2(),
                order3(),
                order4()
        );
    }

    public static List<Order> ordersById() {
        return List.of(
                order1(),
                order3()
        );
    }

    public static List<Order> ordersUser1Desc() {
        return List.of(
                order3(),
                order4(),
                order1()
        );
    }

    public static List<Order> ordersWithCompletedStatus() {
        return List.of(
                order4()
        );
    }

    public static List<Order> ordersAfterDelete() {
        return List.of(
                order1(),
                order3(),
                order4()
        );
    }
}
