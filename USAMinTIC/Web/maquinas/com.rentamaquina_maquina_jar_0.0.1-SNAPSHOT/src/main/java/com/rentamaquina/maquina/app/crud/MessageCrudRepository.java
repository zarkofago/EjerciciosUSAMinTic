package com.rentamaquina.maquina.app.crud;

import com.rentamaquina.maquina.app.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author  -------------
 */
public interface MessageCrudRepository  extends CrudRepository<Message,Integer>{
    
}