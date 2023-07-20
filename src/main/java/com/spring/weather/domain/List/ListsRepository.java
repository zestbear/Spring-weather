package com.spring.weather.domain.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListsRepository extends JpaRepository<Lists, Long> {

    @Query("SELECT p FROM Lists p ORDER BY p.id DESC")
    List<Lists> findAllDesc();
}
