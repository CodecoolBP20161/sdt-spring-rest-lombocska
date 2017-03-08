package com.codecool.spring.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity(name="greeting")
public class GreetingJSON {

    @Column(name="value")
    public String value;

    @Id
    @Column(name="greeting_id", unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Size(min=1, max=255)
    @Column(name="name")
    private String name;

    private GreetingJSON(){}

    public GreetingJSON(String name) {
        this.name = name;
    }
}
