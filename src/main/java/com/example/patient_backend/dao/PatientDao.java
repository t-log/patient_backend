package com.example.patient_backend.dao;

import com.example.patient_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
}
