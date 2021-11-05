package com.rentamaquina.maquina.app.repositories;

import com.rentamaquina.maquina.app.entities.Score;
import com.rentamaquina.maquina.app.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  ZarKofAgo
 */
@Repository
public class ScoreRepository {
     @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    /**
     * Buscar registro
     * @param scoreId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return scoreCrudRepository.findById(scoreId);
    }

    /**
     * Insert
     * @param score
     * @return 
     */
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    
    /**
     * Delete
     * @param score 
     */
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }

    public boolean delete(int scoreId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
