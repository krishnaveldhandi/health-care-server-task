package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Doctors;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Long> {
	

}
