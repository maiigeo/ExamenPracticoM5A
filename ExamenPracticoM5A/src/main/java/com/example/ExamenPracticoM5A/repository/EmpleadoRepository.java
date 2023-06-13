/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ExamenPracticoM5A.repository;

import com.example.ExamenPracticoM5A.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Query(value = "Select * from empleado u where u.apellido = :apellido", nativeQuery = true)
    public Empleado buscarEmpleado(String apellido);
    
}
