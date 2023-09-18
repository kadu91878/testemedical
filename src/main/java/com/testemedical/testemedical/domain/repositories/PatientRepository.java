package com.testemedical.testemedical.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testemedical.testemedical.domain.entities.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    PatientEntity findByEmail(String email);

    PatientEntity findByCpf(String cpf);

}
