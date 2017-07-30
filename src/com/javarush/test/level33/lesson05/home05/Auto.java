package com.javarush.test.level33.lesson05.home05;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="className")

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,  property="className")
@JsonAutoDetect
public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}