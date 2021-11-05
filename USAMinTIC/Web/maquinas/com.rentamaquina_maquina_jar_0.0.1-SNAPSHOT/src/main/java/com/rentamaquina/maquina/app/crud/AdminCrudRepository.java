package com.rentamaquina.maquina.app.crud;

import com.rentamaquina.maquina.app.entities.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ZarKofAgo
 */
public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
    
}
