package com.testemedical.testemedical.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testemedical.testemedical.domain.entities.AdminEntity;
import com.testemedical.testemedical.domain.repositories.AdminRepository;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public AdminEntity createAdmin(AdminEntity admin) throws Exception {
        if (admin.getEmail() != null) {
            throw new Exception("Email já cadastrado");
        }

        if (admin.getCpf() != null) {
            throw new Exception("CPF já cadastrado");
        }
        return adminRepository.save(admin);
    }

    public AdminEntity getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    public AdminEntity updateAdmin(Long id, AdminEntity updatedAdmin) {
        AdminEntity existingAdmin = adminRepository.findById(id).orElse(null);

        if (existingAdmin == null) {
            return null;
        }
        existingAdmin.setFirstName(updatedAdmin.getFirstName());
        existingAdmin.setLastName(updatedAdmin.getLastName());
        existingAdmin.setCpf(updatedAdmin.getCpf());
        existingAdmin.setEmail(updatedAdmin.getEmail());
        existingAdmin.setPassword(updatedAdmin.getPassword());

        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }

}
