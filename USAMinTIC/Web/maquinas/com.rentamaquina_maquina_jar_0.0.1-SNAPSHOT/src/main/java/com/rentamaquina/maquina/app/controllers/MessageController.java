package com.rentamaquina.maquina.app.controllers;

import com.rentamaquina.maquina.app.entities.Message;
import com.rentamaquina.maquina.app.services.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author  ZarKofAgo
 */
@RestController
@RequestMapping("Message")
@CrossOrigin(origins = "*")
public class MessageController {
   
    @Autowired
    private MessageService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Message> getAll(){
        return service.getAll();
    }
    
    /**
     * POST
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return service.save(message);
    }
    
    /**
     * PUT
     * @param message
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return service.update(message);
    }
    
    /**
     * DELETE
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idMessage") int idMessage) {
        return service.deleteMessage(idMessage);
    }
    
}