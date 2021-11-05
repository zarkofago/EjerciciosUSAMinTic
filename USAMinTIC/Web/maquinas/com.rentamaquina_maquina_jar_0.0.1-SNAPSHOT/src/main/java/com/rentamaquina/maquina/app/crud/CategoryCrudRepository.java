package com.rentamaquina.maquina.app.crud;

import com.rentamaquina.maquina.app.entities.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author  ROCKS
 */
public interface CategoryCrudRepository extends CrudRepository<Category,Integer>{
    
}