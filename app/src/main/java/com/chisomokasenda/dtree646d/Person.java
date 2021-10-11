package com.chisomokasenda.dtree646d;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {
    @SerializedName("NAME")
    @Expose
    private String name;
    @SerializedName("SURNAME")
    @Expose
    private String surname;
    @SerializedName("AGE")
    @Expose
    private Integer age;
    @SerializedName("CITY")
    @Expose
    private String city;
    @SerializedName("ID")
    @Expose
    private Integer id;
    @SerializedName("PARENTID")
    @Expose
    private String parentid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

}
