package com.testemedical.testemedical.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testemedical.testemedical.domain.entities.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    AdminEntity findByEmail(String email);

    AdminEntity findByCpf(String cpf);



}
