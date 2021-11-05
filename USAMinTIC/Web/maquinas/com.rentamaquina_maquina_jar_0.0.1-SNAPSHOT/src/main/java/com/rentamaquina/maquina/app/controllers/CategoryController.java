package com.rentamaquina.maquina.app.controllers;

import com.rentamaquina.maquina.app.entities.Category;
import com.rentamaquina.maquina.app.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> findAll(){
        return service.getCategories();
    }
    
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.save(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.update(category);
        return ResponseEntity.status(201).build();
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return service.deleteCategory(categoryId);
    }
}
