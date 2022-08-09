package com.company;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new UnsupportedOperationException("Jmeno musi byt vyplneno.");
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s",getName());
    }
}
