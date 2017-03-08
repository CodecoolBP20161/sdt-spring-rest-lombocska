package com.codecool.spring.controller;

import com.codecool.spring.model.GreetingJSON;
import com.codecool.spring.model.GreetingXML;
import com.codecool.spring.services.GreetingJSONServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/hello-world")
public class MyController {

    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingJSONServices greetingJSONServices;

    @GetMapping("/withXML")
    public @ResponseBody GreetingXML sayHelloWithXML(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        log.info("sayHelloWithXML() method called");
        return new GreetingXML(String.format(template , name));
    }

    @GetMapping(produces = "application/json", value="/withJSON")
    public @ResponseBody GreetingJSON sayHelloWithJSON (@RequestParam(value="name", required=false, defaultValue="Stranger") String name){
        log.info("sayHelloWithJSON() method called");
        GreetingJSON greetingJSON1 = new GreetingJSON(String.format(template , name));
        greetingJSONServices.save(greetingJSON1);

        log.info("Saved greeted user:" + greetingJSONServices.findByName(greetingJSON1.getName()));
        return greetingJSON1;
    }


}
