package com.rentamaquina.maquina.app.repositories;
import com.rentamaquina.maquina.app.entities.Client;
import com.rentamaquina.maquina.app.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  ZarKofAgo
 */

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    /**
     * Buscar registro
     * @param idClient
     * @return 
     */
    public Optional<Client> getClient(int idClient){
        return clientCrudRepository.findById(idClient);
    }

    /**
     * Insert
     * @param client
     * @return 
     */
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    
    
    /**
     * Delete
     * @param client 
     */
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
    
}
