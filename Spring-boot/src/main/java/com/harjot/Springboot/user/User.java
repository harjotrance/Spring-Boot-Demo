package com.harjot.Springboot.user;

import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer id;
    @Size(min=2 , message = "Name should have atleast 2 characters")
    private String name;
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(String name, Date birthDate , Integer id) {
        this.name = name;
        this.birthDate = birthDate;
        this.id = id;
    }

    protected User () {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
