/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Reto2Cl4Rocco.Rocco.Interface;

import com.Reto2Cl4Rocco.Rocco.Model.Cleaningprods;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cesartbossa
 */
public interface InterfaceCleaningprods extends MongoRepository<Cleaningprods, String>{
    
}
