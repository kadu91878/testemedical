package com.testemedical.testemedical.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testemedical.testemedical.domain.entities.PatientEntity;
import com.testemedical.testemedical.domain.repositories.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientEntity createPatient(PatientEntity patient) throws Exception {
        if (patient.getEmail() != null) {
            throw new Exception("Email já cadastrado");
        }

        if (patient.getCpf() != null) {
            throw new Exception("CPF já cadastrado");
        }
        return patientRepository.save(patient);
    }

    public PatientEntity getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    public PatientEntity updatePatient(Long id, PatientEntity updatedPatient) {
        PatientEntity existingPatient = patientRepository.findById(id).orElse(null);

        if (existingPatient == null) {
            return null;
        }
        existingPatient.setFirstName(updatedPatient.getFirstName());
        existingPatient.setLastName(updatedPatient.getLastName());
        existingPatient.setCpf(updatedPatient.getCpf());
        existingPatient.setEmail(updatedPatient.getEmail());
        existingPatient.setPassword(updatedPatient.getPassword());

        return patientRepository.save(existingPatient);
    }

}
