package com.codecool.spring.repository;

import com.codecool.spring.model.GreetingJSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreetingJSONRepository extends JpaRepository<GreetingJSON, Long> {

     List<GreetingJSON> findByName(String name);

}
