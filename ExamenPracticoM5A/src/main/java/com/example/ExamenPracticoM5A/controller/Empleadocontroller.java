/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ExamenPracticoM5A.controller;

import com.example.ExamenPracticoM5A.modelo.Empleado;
import com.example.ExamenPracticoM5A.service.EmpleadoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/empleado")
public class Empleadocontroller {
    @Autowired
    EmpleadoServiceImpl empleadoService;

    @Operation(summary = "Se obtiene la lista de Empleado")
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaEmpleado() {
        return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Empleado")
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado u) {
         u.setSueldo(u.settearsueldo(u.getDias_trabajo()));
        return new ResponseEntity<>(empleadoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado u) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado != null) {
            try {
                empleado.setApellido(u.getApellido());
                empleado.setDias_trabajo(u.getDias_trabajo());
                empleado.setDireccion(u.getDireccion());
                empleado.setFecha_nacimieno(u.getFecha_nacimieno());
                empleado.setObservacion(u.getObservacion());
                empleado.setTelefono(u.getTelefono());
                empleado.setSueldo(u.settearsueldo(u.getDias_trabajo()));

                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
