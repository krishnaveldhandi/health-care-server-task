package com.health.care.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "specialization")
public class SpecializationDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorDao doctor;

    public SpecializationDao() {
    }

    public SpecializationDao(Long id, String name, int experience, DoctorDao doctor) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.doctor = doctor;
    }

    public SpecializationDao(String name, int experience, DoctorDao doctor) {
        this.name = name;
        this.experience = experience;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public DoctorDao getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDao doctor) {
        this.doctor = doctor;
    }
}
