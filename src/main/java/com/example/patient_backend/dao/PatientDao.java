package com.example.patient_backend.dao;

import com.example.patient_backend.model.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query(value = "SELECT `id`, `age`, `appointment_date`, `blood_group`, `hospital_name`, `name` FROM `patientdb` WHERE `name`=:name",nativeQuery = true)
    List<Patient> searchPatient(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patientdb` WHERE `id`=:id",nativeQuery = true)
    void deletePatient(@Param("id") Integer id);
}
