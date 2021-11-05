package com.rentamaquina.maquina.app.crud;

import com.rentamaquina.maquina.app.entities.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author  ----------
 */
public interface ClientCrudRepository  extends CrudRepository<Client,Integer>{
    
}