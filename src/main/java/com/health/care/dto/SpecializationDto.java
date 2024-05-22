package com.health.care.dto;

import com.health.care.dao.DoctorDao;
import com.health.care.dao.SpecializationDao;

public class SpecializationDto {
    private Long id;

    private String name;
    private int experience;

    public SpecializationDto() {
    }

    public SpecializationDto(SpecializationDao specialization) {
        this.id = specialization.getId();
        this.name = specialization.getName();
        this.experience = specialization.getExperience();
    }

    public SpecializationDto(Long id, String name, int experience) {
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

    public SpecializationDao toDao() {
        SpecializationDao specializationDao = new SpecializationDao();
        specializationDao.setExperience(experience);
        specializationDao.setId(id);
        specializationDao.setName(name);
        return specializationDao;
    }

    public SpecializationDao toDao(DoctorDao doctorDao) {
        SpecializationDao specializationDao = new SpecializationDao();
        specializationDao.setExperience(experience);
        specializationDao.setId(id);
        specializationDao.setName(name);
        specializationDao.setDoctor(doctorDao);
        return specializationDao;
    }

    public SpecializationDao toDao(SpecializationDao specializationDao) {
        specializationDao.setExperience(experience);
        specializationDao.setId(id);
        specializationDao.setName(name);
        return specializationDao;
    }

    public boolean hasDifference(SpecializationDao specialization) {
        return !(this.name.equals(specialization.getName())
                && this.experience == specialization.getExperience());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SpecializationDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", experience=").append(experience);
        sb.append('}');
        return sb.toString();
    }
}
