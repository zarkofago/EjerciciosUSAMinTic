package com.rentamaquina.maquina.app.repositories;

import com.rentamaquina.maquina.app.entities.Message;
import com.rentamaquina.maquina.app.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  ZarKofAgo
 */
@Repository
public class MessageRepository  {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    /**
     * Buscar registro
     * @param messageId
     * @return 
     */
    public Optional<Message> getMessage(int messageId){
        return messageCrudRepository.findById(messageId);
    }

    /**
     * Insert
     * @param message
     * @return 
     */
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    /**
     * Delete
     * @param message 
     */
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
    
    
}

