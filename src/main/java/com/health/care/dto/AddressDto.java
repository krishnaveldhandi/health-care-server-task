package com.health.care.dto;

import com.health.care.dao.AddressDao;

public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public AddressDto() {
    }

    public AddressDto(AddressDao address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        this.country = address.getCountry();
    }

    public AddressDto(Long id, String street, String city, String state, String zip, String country) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressDao toDao() {
        AddressDao dao = new AddressDao();
        dao.setId(id);
        dao.setStreet(street);
        dao.setCity(city);
        dao.setState(state);
        dao.setZip(zip);
        dao.setCountry(country);
        return dao;
    }

    public AddressDao toDao(AddressDao dao) {
        dao.setId(id);
        dao.setStreet(street);
        dao.setCity(city);
        dao.setState(state);
        dao.setZip(zip);
        dao.setCountry(country);
        return dao;
    }

    public boolean hasDifference(AddressDao address) {
        return !(this.street.equals(address.getStreet())
                && this.city.equals(address.getCity())
                && this.state.equals(address.getState())
                && this.zip.equals(address.getZip())
                && this.country.equals(address.getCountry()));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AddressDto{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", zip='").append(zip).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
