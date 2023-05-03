package com.example.PatientCRUD.repository;

import com.example.PatientCRUD.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
