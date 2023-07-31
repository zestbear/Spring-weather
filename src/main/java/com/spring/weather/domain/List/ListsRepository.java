package com.spring.weather.domain.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ListsRepository extends MongoRepository<Lists, String> {
    List<Lists> findAllByOrderByIdDesc();
}
