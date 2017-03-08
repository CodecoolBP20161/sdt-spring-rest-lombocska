package com.codecool.spring.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;


@Data
public class GreetingXML {

    @XmlAttribute
    private String value;

    public GreetingXML(String value) {
        this.value = value;
    }
}
