package com.example.restapitestproject.model;

public class CustomNameValuePair {
    private String name, value;

    public CustomNameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public CustomNameValuePair() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomNameValuePair{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
