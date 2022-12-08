package com.example.patient_backend.controller;

import com.example.patient_backend.dao.PatientDao;
import com.example.patient_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String homePage(){return "Welcome to patient home page";}

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patient> viewPage()
    {
        return (List<Patient>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String addPage(@RequestBody Patient p){
        dao.save(p);
        return "{\"status\":\"success\"}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Patient> searchPage(@RequestBody Patient p){
        return (List<Patient>) dao.searchPatient(p.getName());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public String deletePage(@RequestBody Patient p){
        dao.deletePatient(p.getId());
        return "{\"status\":\"success\"}";
    }
}
