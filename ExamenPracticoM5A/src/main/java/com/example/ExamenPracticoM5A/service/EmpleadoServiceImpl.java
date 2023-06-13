/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ExamenPracticoM5A.service;

import com.example.ExamenPracticoM5A.modelo.Empleado;
import com.example.ExamenPracticoM5A.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



/**
 *
 * @author HP
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado, Integer> {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoRepository;
    }
    


}
