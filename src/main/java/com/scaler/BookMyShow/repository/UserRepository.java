package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndName(String email, String name);

    User save(User user);
}
