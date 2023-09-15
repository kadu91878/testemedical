package com.testemedical.testemedical.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testemedical.testemedical.domain.entities.DoctorEntity;
import com.testemedical.testemedical.domain.repositories.DoctorRepository;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorEntity createDoctor(DoctorEntity doctor) throws Exception {
        // Check if the email is already registered
        DoctorEntity existingDoctorWithEmail = doctorRepository.findByEmail(doctor.getEmail());
        if (existingDoctorWithEmail != null) {
            throw new Exception("Email já cadastrado");
        }
    
        // Check if the CPF is already registered
        DoctorEntity existingDoctorWithCpf = doctorRepository.findByCpf(doctor.getCpf());
        if (existingDoctorWithCpf != null) {
            throw new Exception("CPF já cadastrado");
        }
    
        // If neither the email nor the CPF is registered, save the new doctor
        return doctorRepository.save(doctor);
    }

    public DoctorEntity getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorEntity updateDoctor(Long id, DoctorEntity updatedDoctor) {
        DoctorEntity existingDoctor = doctorRepository.findById(id).orElse(null);

        if (existingDoctor == null) {
            return null;
        }
        existingDoctor.setFirstName(updatedDoctor.getFirstName());
        existingDoctor.setLastName(updatedDoctor.getLastName());
        existingDoctor.setCpf(updatedDoctor.getCpf());
        existingDoctor.setEmail(updatedDoctor.getEmail());
        existingDoctor.setCrm(updatedDoctor.getCrm());
        existingDoctor.setPassword(updatedDoctor.getPassword());
        existingDoctor.setSpecialty(updatedDoctor.getSpecialty());

        return doctorRepository.save(existingDoctor);

    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
