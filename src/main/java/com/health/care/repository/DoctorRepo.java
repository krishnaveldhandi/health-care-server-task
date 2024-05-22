package com.health.care.repository;

import com.health.care.dao.DoctorDao;
import com.health.care.dao.SpecializationDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends CrudRepository<DoctorDao, Long> {

    List<DoctorDao> findAllBySpecializationsContains(SpecializationDao specializations);
}
