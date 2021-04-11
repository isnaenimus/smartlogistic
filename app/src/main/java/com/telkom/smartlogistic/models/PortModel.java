package com.telkom.smartlogistic.models;

public class PortModel {
    private String name;
    private String city;
    private String province;
    private String country;

    public PortModel(String name, String city, String province, String country) {
        this.name = name;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
