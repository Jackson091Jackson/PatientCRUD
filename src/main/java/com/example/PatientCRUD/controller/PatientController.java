package com.example.PatientCRUD.controller;

import com.example.PatientCRUD.entity.PatientEntity;
import com.example.PatientCRUD.exception.PatientException;
import com.example.PatientCRUD.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<PatientEntity> getAllEmployee(){
        return patientRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public PatientEntity createEmployee(@RequestBody PatientEntity employee){
        return patientRepository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping({"id"})
    public ResponseEntity<PatientEntity> getEmployeeById(@PathVariable long id){
        PatientEntity employee = patientRepository.findById(id)
                .orElseThrow(() -> new PatientException("Patient not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<PatientEntity> updatePatient(@PathVariable long id,@RequestBody PatientEntity patientEntityDetails){
        PatientEntity updatePatient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientException("Patient not exist with id: " + id));

        updatePatient.setFirstName(patientEntityDetails.getFirstName());
        updatePatient.setLastName(patientEntityDetails.getLastName());
        updatePatient.setPatientNo(patientEntityDetails.getPatientNo());
        updatePatient.setUgonjwa(patientEntityDetails.getUgonjwa());
        updatePatient.setPhoneNo(patientEntityDetails.getPhoneNo());

        patientRepository.save(updatePatient);
        return ResponseEntity.ok(updatePatient);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable long id){

        PatientEntity patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientException("Patient not exist with id: " + id));

        patientRepository.delete(patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
