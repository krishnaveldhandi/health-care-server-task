package com.health.care.dao;

import com.health.care.models.Genders;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class DoctorDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Genders gender;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AddressDao address;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SpecializationDao> specializations;

    public DoctorDao() {
    }

    public DoctorDao(Long id, String firstName, String lastName, String email, String phone, Genders gender, AddressDao address, List<SpecializationDao> specializations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.specializations = specializations;
    }

    public DoctorDao(String firstName, String lastName, String email, String phone, Genders gender, AddressDao address, List<SpecializationDao> specializations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.specializations = specializations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public AddressDao getAddress() {
        return address;
    }

    public void setAddress(AddressDao address) {
        this.address = address;
    }

    public List<SpecializationDao> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<SpecializationDao> specializations) {
        this.specializations = specializations;
    }
}
