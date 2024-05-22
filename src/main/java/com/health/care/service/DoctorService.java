package com.health.care.service;

import com.health.care.dao.AddressDao;
import com.health.care.dao.DoctorDao;
import com.health.care.dao.SpecializationDao;
import com.health.care.dto.DoctorDto;
import com.health.care.dto.SpecializationDto;
import com.health.care.repository.AddressRepo;
import com.health.care.repository.DoctorRepo;
import com.health.care.repository.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private SpecializationRepo specializationRepo;

    public DoctorDto save(DoctorDto dto) {
        DoctorDao doctor = doctorRepo.save(dto.toDao());
        AddressDao address = dto.getAddress().toDao();
        address.setDoctor(doctor);
        addressRepo.save(address);
        List<SpecializationDao> specializations = dto.getSpecializations().stream().map(SpecializationDto::toDao).toList();
        specializations.forEach(specialization -> specialization.setDoctor(doctor));
        specializationRepo.saveAll(specializations);
        return DoctorDto.getDto(doctor, address, specializations);
    }


    public DoctorDto update(DoctorDto dto) {
        if (dto.getId() == null) {
            return null;
        }
        DoctorDao doctor = doctorRepo.findById(dto.getId()).orElse(null);
        if (doctor == null) {
            return null;
        }

        if (dto.hasDifference(doctor)) {
            doctor = doctorRepo.save(dto.toDao(doctor));
        }
        AddressDao address = doctor.getAddress();

        if (dto.getAddress().hasDifference(address)) {
            address = addressRepo.save(dto.getAddress().toDao(address));
        }

        DoctorDao finalDoctor = doctor;
        List<SpecializationDao> newSpecializations = dto.getSpecializations().stream().filter(sp -> sp.getId() == null).map(sp -> sp.toDao(finalDoctor)).toList();
        List<SpecializationDto> oldSpecializations = dto.getSpecializations().stream().filter(sp -> sp.getId() != null).toList();
        List<SpecializationDao> specializations = new ArrayList<>();
        if (!newSpecializations.isEmpty()) {
            List<SpecializationDao> list = StreamSupport.stream(specializationRepo.saveAll(newSpecializations).spliterator(), false).toList();
            specializations.addAll(list);
        }
        oldSpecializations.forEach(sp -> {
            SpecializationDao specializationDao = specializationRepo.findById(sp.getId()).orElse(null);
            if (specializationDao != null && sp.hasDifference(specializationDao)) {
                specializations.add(specializationRepo.save(sp.toDao(specializationDao)));
            } else if (specializationDao != null) {
                specializations.add(specializationDao);
            }
        });
        return DoctorDto.getDto(doctor, address, specializations);
    }

    public DoctorDto get(long id) {
        if (id == 0) return null;
        DoctorDao doctor = doctorRepo.findById(id).orElse(null);

        if (doctor == null) return null;
        return DoctorDto.getDto(doctor);
    }

    public List<DoctorDto> getAll() {
        List<DoctorDao> doctor = StreamSupport.stream(doctorRepo.findAll().spliterator(), false).toList();
        return doctor.stream().map(DoctorDto::getDto).toList();
    }

    public void delete(long id) {
        if (id == 0) return;
        doctorRepo.deleteById(id);
    }
}
