package com.github.grizzly.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "first_name", columnDefinition = "VARCHAR(32)", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", columnDefinition = "VARCHAR(32)", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "login", columnDefinition = "VARCHAR(32)", unique = true, nullable = false, updatable = false)
    private String login;

    @NotNull
    @Column(name = "password", columnDefinition = "VARCHAR(16)", nullable = false)
    private String password;

    @NotNull
    @Email
    @Column(name = "email", columnDefinition = "VARCHAR(32)", unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(name = "phone", columnDefinition = "VARCHAR(16)", unique = true, nullable = false)
    private String phone;

    @NotNull
    @CreationTimestamp
    @EqualsAndHashCode.Exclude
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotNull
    @UpdateTimestamp
    @EqualsAndHashCode.Exclude
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @NotNull
    @Column(name = "active", columnDefinition = "VARCHAR(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Active active;

    @NotNull
    @Column(name = "is_verified", columnDefinition = "VARCHAR(16)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Verification verification;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "users_roles",
            joinColumns = @JoinColumn(columnDefinition = "user_id"))
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void addRoles(Set<Role> roles) {
        this.roles.addAll(roles);
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Address> addresses;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Order> orders;

    public User(
            String firstName,
            String lastName,
            String login,
            String password,
            String email,
            String phone
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.active = Active.OFF;
        this.verification = Verification.NO;
    }

    public User(
            long id,
            String firstName,
            String lastName,
            String login,
            String password,
            String email,
            String phone
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.active = Active.OFF;
        this.verification = Verification.NO;
    }

    public enum Active {
        ON, OFF
    }

    public enum Verification {
        YES, NO
    }
}
