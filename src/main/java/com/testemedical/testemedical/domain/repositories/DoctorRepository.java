package com.testemedical.testemedical.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testemedical.testemedical.domain.entities.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    DoctorEntity findByEmail(String email);

    DoctorEntity findByCpf(String cpf);

}
