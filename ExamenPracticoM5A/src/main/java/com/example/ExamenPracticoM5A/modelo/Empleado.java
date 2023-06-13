/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ExamenPracticoM5A.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author HP
 */
@Data
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;

    @Size(min = 1, max = 45, message = "El apellido debe tener máximo 45 caracteres")
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;

    @Size(min = 1, max = 15, message = "El telefono debe tener máximo 15 caracteres")
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimieno;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dias_trabajo")
    private int dias_trabajo;

    @NotBlank(message = "El sueldo no puede estar en blanco")
    @Column(name = "sueldo")
    private double sueldo;

    public double settearsueldo(int dias_trabajo) {
        if (dias_trabajo >= 20 && dias_trabajo < 30) {
            double sueldo1 = dias_trabajo * 15;
            sueldo = (sueldo1 * 0.2)+sueldo1;
        } else if (dias_trabajo >= 30) {
            double sueldo1 = dias_trabajo * 15;
            sueldo = (sueldo1 * 0.5)+sueldo1;
        }

        return sueldo;
    }

    public double bono(int dias_trabajo) {
        sueldo = dias_trabajo * 15;
        return sueldo;
    }

}
