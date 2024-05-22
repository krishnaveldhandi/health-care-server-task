package com.health.care.dto;

import com.health.care.dao.AddressDao;
import com.health.care.dao.DoctorDao;
import com.health.care.dao.SpecializationDao;
import com.health.care.models.Genders;

import java.util.List;

public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Genders gender;
    private AddressDto address;
    private List<SpecializationDto> specializations;

    public DoctorDto() {
    }

    public DoctorDto(DoctorDao doctor) {
        this.id = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.email = doctor.getEmail();
        this.phone = doctor.getPhone();
        this.gender = doctor.getGender();
    }

    public static DoctorDto getDto(DoctorDao doctor, AddressDao address, List<SpecializationDao> specializations) {
        DoctorDto result = new DoctorDto(doctor);
        result.setAddress(new AddressDto(address));
        result.setSpecializations(specializations.stream().map(SpecializationDto::new).toList());
        return result;
    }
    public static DoctorDto getDto(DoctorDao doctor) {
        DoctorDto result = new DoctorDto(doctor);
        result.setAddress(new AddressDto(doctor.getAddress()));
        result.setSpecializations(doctor.getSpecializations().stream().map(SpecializationDto::new).toList());
        return result;
    }

    public DoctorDto(Long id, String firstName, String lastName, String email, String phone, Genders gender, AddressDto address, List<SpecializationDto> specializations) {
        this.id = id;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<SpecializationDto> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<SpecializationDto> specializations) {
        this.specializations = specializations;
    }

    public DoctorDao toDao() {
        DoctorDao dao = new DoctorDao();
        dao.setId(id);
        dao.setFirstName(firstName);
        dao.setLastName(lastName);
        dao.setEmail(email);
        dao.setPhone(phone);
        dao.setGender(gender);
        return dao;
    }

    public DoctorDao toDao(DoctorDao dao) {
        dao.setId(id);
        dao.setFirstName(firstName);
        dao.setLastName(lastName);
        dao.setEmail(email);
        dao.setPhone(phone);
        dao.setGender(gender);
        return dao;
    }

    public boolean hasDifference(DoctorDao doctor) {
        return !(this.firstName.equals(doctor.getFirstName())
                && this.lastName.equals(doctor.getLastName())
                && this.email.equals(doctor.getEmail())
                && this.phone.equals(doctor.getPhone())
                && this.gender.equals(doctor.getGender()));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DoctorDto{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", address=").append(address);
        sb.append(", specializations=").append(specializations);
        sb.append('}');
        return sb.toString();
    }
}
