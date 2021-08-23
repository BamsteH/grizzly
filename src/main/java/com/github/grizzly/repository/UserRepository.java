package com.github.grizzly.repository;

import com.github.grizzly.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(@NonNull String login);

    Optional<User> findByEmail(@NonNull String email);

    Optional<User> findByPhone(@NonNull String phone);

    List<User> findByCreatedAtBefore(LocalDateTime createdAt);

    List<User> findByCreatedAtAfter(LocalDateTime createdAt);

    List<User> findByUpdatedAtBefore(LocalDateTime updatedAt);

    List<User> findByUpdatedAtAfter(LocalDateTime updatedAt);

    List<User> findByActive(User.Active active);

    List<User> findByVerification(User.Verification verification);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
