/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2Cl4Rocco.Rocco.Repository;

import com.Reto2Cl4Rocco.Rocco.Model.Cleaningprods;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Reto2Cl4Rocco.Rocco.Interface.InterfaceCleaningprods;

/**
 *
 * @author cesartbossa
 */
@Repository
public class CleaningprodsRepository {
    @Autowired
    private InterfaceCleaningprods repository;

    public List<Cleaningprods> getAll() {
        return repository.findAll();
    }

    public Optional<Cleaningprods> getCleaningprod(String reference) {
        return repository.findById(reference);
    }
    public Cleaningprods create(Cleaningprods cleaningprod) {
        return repository.save(cleaningprod);
    }

    public void update(Cleaningprods cleaningprod) {
        repository.save(cleaningprod);
    }
    
    public void delete(Cleaningprods cleaningprod) {
        repository.delete(cleaningprod);
    }
}
