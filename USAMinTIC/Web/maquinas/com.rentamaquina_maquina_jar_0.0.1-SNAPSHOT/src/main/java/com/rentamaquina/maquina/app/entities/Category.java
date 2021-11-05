package com.rentamaquina.maquina.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author  ZarKofAgo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category implements Serializable {
    
    @Id
    @Column(name="categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name", length=45)
    private String name;
    @Column(name="description", length=240)
    private String description;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="category")
    @JsonIgnoreProperties("category")
    private List<Machine> machines;
}
