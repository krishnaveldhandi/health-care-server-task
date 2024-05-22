package com.health.care.repository;

import com.health.care.dao.AddressDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<AddressDao, Long> {
}
