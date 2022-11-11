package com.capacitacioncrud.Primer.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Empleados")
public class Empleado {
    @Id//PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//
    private Long id;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private float sueldo;



}
