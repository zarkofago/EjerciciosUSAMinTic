package com.rentamaquina.maquina.app.repositories;

import com.rentamaquina.maquina.app.entities.Category;
import com.rentamaquina.maquina.app.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  ZarKofAgo
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    /**
     * Buscar registro
     * @param categoryId
     * @return 
     */
    public Optional<Category> getCategory(int categoryId){
        return categoryCrudRepository.findById(categoryId);
    }

    /**
     * Insert
     * @param category
     * @return 
     */
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    
    /**
     * Delete
     * @param category 
     */
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
    
    
}
