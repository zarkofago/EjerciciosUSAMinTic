package com.rentamaquina.maquina.app.repositories;

import com.rentamaquina.maquina.app.entities.Admin;
import com.rentamaquina.maquina.app.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZarKofAgo
 */

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    /**
     * Buscar registro
     * @param adminId
     * @return 
     */
    public Optional<Admin> getAdmin(int adminId){
        return adminCrudRepository.findById(adminId);
    }

    /**
     * Insert
     * @param admin
     * @return 
     */
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    
    /**
     * Delete
     * @param admin 
     */
    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }
    
    
}
