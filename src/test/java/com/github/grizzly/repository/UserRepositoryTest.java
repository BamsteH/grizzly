package com.github.grizzly.repository;

import com.github.grizzly.entity.Role;
import com.github.grizzly.entity.User;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.exceptions.InvalidInputData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "test")
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findAll(){
        List<User> exp = UserRepositoryMocks.users();
        List<User> act = userRepository.findAll();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByPhone_user1(){
        User act = userRepository.findByPhone("user1_phone").orElseThrow();
        User exp = UserRepositoryMocks.user_1();
        Assert.assertEquals(exp, act);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByPhone_notPresented(){
        userRepository.findByPhone("notPresented_phone").orElseThrow(EntityNotFoundException::new);
    }

    @Test(expected = InvalidInputData.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByPhone_null(){
        userRepository.findByPhone(null).orElseThrow(InvalidInputData::new);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByPhone_empty(){
        userRepository.findByPhone("").orElseThrow(EntityNotFoundException::new);
    }

    @Test
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByLogin_user2(){
        User act = userRepository.findByLogin("user2_login").orElseThrow();
        User exp = UserRepositoryMocks.user_2();
        Assert.assertEquals(exp, act);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByLogin_notPresented(){
        userRepository.findByLogin("notPresented_login").orElseThrow(EntityNotFoundException::new);
    }

    @Test(expected = InvalidInputData.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByLogin_null(){
        userRepository.findByLogin(null).orElseThrow(InvalidInputData::new);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByLogin_empty(){
        userRepository.findByLogin("").orElseThrow(EntityNotFoundException::new);
    }

    @Test
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByEmail_user3(){
        User act = userRepository.findByEmail("user3_@email.com").orElseThrow();
        User exp = UserRepositoryMocks.user_3();
        Assert.assertEquals(exp, act);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByEmail_notPresented(){
        userRepository.findByEmail("notPresented_email").orElseThrow(EntityNotFoundException::new);
    }

    @Test(expected = InvalidInputData.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByEmail_null(){
        userRepository.findByEmail(null).orElseThrow(InvalidInputData::new);
    }

    @Test(expected = EntityNotFoundException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void findByEmail_empty(){
        userRepository.findByEmail("").orElseThrow(EntityNotFoundException::new);
    }

    @Test
    @Sql({"users-schema.sql"})
    public void userRole(){
        User user = new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"
        );
        user.addRole(Role.USER);
        userRepository.save(user);
        Set<Role> act = userRepository.findById(1L).orElseThrow().getRoles();
        Set<Role> exp = Set.of(Role.USER);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"users-schema.sql"})
    public void updateUserRole(){
        User user = new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"
        );
        userRepository.save(user);
        user = userRepository.findById(1L).orElseThrow();
        user.addRole(Role.USER);
        userRepository.save(user);
        Set<Role> act = userRepository.findById(1L).orElseThrow().getRoles();
        Set<Role> exp = Set.of(Role.USER);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"users-schema.sql"})
    public void manyRoles(){
        User user = new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"
        );
        user.addRoles(Set.of(Role.USER, Role.MANAGER, Role.ADMIN));
        userRepository.save(user);
        Set<Role> act = userRepository.findById(1L).orElseThrow().getRoles();
        Set<Role> exp = Set.of(Role.USER, Role.MANAGER, Role.ADMIN);
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test(expected = DataIntegrityViolationException.class)
    @Sql({"users-schema.sql", "users-data.sql"})
    public void saveDuplicate(){
        User user = new User(
                "firstName",
                "lastName",
                "user1_login",
                "password",
                "user2_@email.com",
                "user3_phone"
        );
        userRepository.save(user);
    }
}