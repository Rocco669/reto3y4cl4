/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto2Cl4Rocco.Rocco.Service;

import com.Reto2Cl4Rocco.Rocco.Model.Cleaningprods;
import com.Reto2Cl4Rocco.Rocco.Repository.CleaningprodsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesartbossa
 */
@Service
public class CleaningprodsService {
    @Autowired
    private CleaningprodsRepository cleaningprodRepository;

    public List<Cleaningprods> getAll() {
        return cleaningprodRepository.getAll();
    }

    public Optional<Cleaningprods> getCleaningprod(String reference) {
        return cleaningprodRepository.getCleaningprod(reference);
    }

    public Cleaningprods create(Cleaningprods accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cleaningprodRepository.create(accesory);
        }
    }

    public Cleaningprods update(Cleaningprods accesory) {

        if (accesory.getReference() != null) {
            Optional<Cleaningprods> accesoryDb = cleaningprodRepository.getCleaningprod(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cleaningprodRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCleaningprod(reference).map(accesory -> {
            cleaningprodRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
