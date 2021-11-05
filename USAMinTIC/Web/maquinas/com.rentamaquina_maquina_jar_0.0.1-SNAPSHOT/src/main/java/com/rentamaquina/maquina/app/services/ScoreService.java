package com.rentamaquina.maquina.app.services;

import com.rentamaquina.maquina.app.entities.Score;
import com.rentamaquina.maquina.app.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author  ZarKofAgo
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Score> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param scoreId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return repository.getScore(scoreId);
    }
    
    /**
     * POST
     * @param score
     * @return 
     */
    public Score save(Score score){
        if(score.getIdScore() !=null){
            return repository.save(score);
        }else{
            Optional<Score> resultado = repository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                return score;
            }else{
                return repository.save(score);
            }
        }
    }
    
    /**
     * UPDATE
     * @param score
     * @return 
     */
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> resultado = repository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                if(score.getMessageText()!=null){
                    resultado.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    resultado.get().setStars(score.getStars());
                }
                
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    
    /**
     * DELETE
     * @param scoreId
     * @return 
     */

    
    public boolean delete(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
