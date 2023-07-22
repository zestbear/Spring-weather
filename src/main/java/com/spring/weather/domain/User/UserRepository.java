package com.spring.weather.domain.User;

import com.spring.weather.domain.List.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT p FROM Lists p ORDER BY p.id DESC")
    List<Lists> findAllDesc();

}