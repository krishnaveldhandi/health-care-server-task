package com.health.care.repository;

import com.health.care.dao.SpecializationDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends CrudRepository<SpecializationDao, Long> {
}
