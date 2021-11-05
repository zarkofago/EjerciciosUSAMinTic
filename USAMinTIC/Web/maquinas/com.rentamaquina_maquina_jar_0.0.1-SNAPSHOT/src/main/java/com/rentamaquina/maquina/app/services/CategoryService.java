package com.rentamaquina.maquina.app.services;

import com.rentamaquina.maquina.app.entities.Category;
import com.rentamaquina.maquina.app.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  ZarKofAgo
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    /**
     * GET
     * @return 
     */
   public List<Category> getCategories(){
        return repository.getAll();
    }
    
    
    /**
     * Buscar por ID
     * @param categoryId
     * @return 
     */
    public Optional<Category> getCategory(int categoryId){
        return repository.getCategory(categoryId);
    }
    
    /**
     * POST
     * @param category
     * @return 
     */
    public Category save(Category category){
        if(category.getName()!=null && category.getDescription()!=null ){
            return repository.save(category);
        }else{
            Optional<Category> resultado = repository.getCategory(category.getId());
            if(resultado.isPresent()){
                return category;
            }else{
                return repository.save(category);
            }
        }
    }
    
    /**
     * UPDATE
     * @param category
     * @return 
     */
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> resultado = repository.getCategory(category.getId());
            if(resultado.isPresent()){
                if(category.getName()!=null){
                    resultado.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    resultado.get().setDescription(category.getDescription());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
    
    /**
     * DELETE
     * @param categoryId
     * @return 
     */
    public boolean deleteCategory(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}