package com.globallabes.springwebmvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Jedi {

    @NotEmpty(message = "Name cannot be blank")
    private String name;

    @NotBlank
    private String lastName;

    public Jedi (final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
