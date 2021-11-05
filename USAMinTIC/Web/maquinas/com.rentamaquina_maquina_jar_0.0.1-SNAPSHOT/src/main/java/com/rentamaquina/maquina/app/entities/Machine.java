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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="machine")
public class Machine implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column (name="brand", length=45)
    private String brand;
    private Integer year;
    private String description;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("machines")
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "machine")
    @JsonIgnoreProperties({"machine","messages"})
    public List<Reservation> reservations;
    
}