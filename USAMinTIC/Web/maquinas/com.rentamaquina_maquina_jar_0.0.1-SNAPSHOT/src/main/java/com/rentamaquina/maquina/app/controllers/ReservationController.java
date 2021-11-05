package com.rentamaquina.maquina.app.controllers;

import com.rentamaquina.maquina.app.entities.Reservation;
import com.rentamaquina.maquina.app.services.ReservationService;
import com.rentamaquina.maquina.app.reports.CountClient;
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
import com.rentamaquina.maquina.app.reports.StatusReservations;

/**
 *
 * @author ZarKofAgo
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    
    @Autowired
    private ReservationService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAllReservations();
    }
    
    /**
     * POST
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }
    
    /**
     * PUT
     * @param reservation
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }
    
    /**
     * DELETE
     * @param idReservation
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idReservation") int idReservation) {
        return service.deleteReservation(idReservation);
    }
    
    @GetMapping("/report-status")
    public StatusReservations getStatusReservations(){
        return service.getReportStatusReservations();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getTimesReservations(@PathVariable ("dateOne") String dateOne, @PathVariable ("dateTwo") String dateTwo ){ 
        return service.getReportsTimeReservations(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<CountClient> getClients(){
        return service.serviceTopClients();
    }
}
