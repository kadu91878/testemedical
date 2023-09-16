package com.testemedical.testemedical.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testemedical.testemedical.domain.entities.PatientEntity;
import com.testemedical.testemedical.domain.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/")
    public ResponseEntity<PatientEntity> createPatient(@RequestBody PatientEntity patient) throws Exception {
        PatientEntity createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Long id){
        PatientEntity patient = patientService.getPatientById(id);
        if (patient != null){
            return ResponseEntity.ok(patient);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity <List<PatientEntity>> getAllPatient(){
        List<PatientEntity> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientEntity> updatePatient(@PathVariable Long id, @RequestBody PatientEntity updatedPatient){
        PatientEntity updated = patientService.updatePatient(id, updatedPatient);
        if(updated != null){
          return  ResponseEntity.ok(updated);
        }else{
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PatientEntity> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
