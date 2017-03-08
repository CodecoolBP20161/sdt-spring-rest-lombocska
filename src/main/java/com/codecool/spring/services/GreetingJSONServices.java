package com.codecool.spring.services;

import com.codecool.spring.model.GreetingJSON;
import com.codecool.spring.repository.GreetingJSONRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GreetingJSONServices {

    private GreetingJSONRepository greetingJSONRepository;

    @Autowired
    public GreetingJSONServices(GreetingJSONRepository greetingJSONRepository) {
        this.greetingJSONRepository = greetingJSONRepository;
    }

    public List<GreetingJSON> findByName(String name) {
        return greetingJSONRepository.findByName(name);
    }


    public void save(GreetingJSON greetingJSON) {
        log.debug("saving user");
        greetingJSONRepository.save(greetingJSON);
    }
}
